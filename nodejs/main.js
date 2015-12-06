// parse arguments
var filename = process.argv[2];
console.log("Hello, " + filename);

// 1. The number of words in the document
var word_count = 0;
// 2. The number of lines
var line_count = 0;
// 3. A list of all the words with the count of their occurrence, in descending order
var word_freq = {};
// 4. A list of the ten most common trigrams
var trigram_freq = {};
// 5. A listing of the edit distances between the most common trigram and the next ten most common trigrams, in order of distance value. This should include the trigrams being compared and the edit distance value.

// read the file line by line
// ref http://stackoverflow.com/questions/6156501/read-a-file-one-line-at-a-time-in-node-js
var r = require('readline').createInterface({
    input: require('fs').createReadStream(filename),
});

// split words by non-alphanumeric
// ref http://stackoverflow.com/questions/6053541/regex-every-non-alphanumeric-character-except-white-space-or-colon
var trigram = ["", "", ""];
r.on('line', function (line) {
    line_count += 1;
    words = line.split(/[^a-zA-Z0-9]+/);
    for (i in words) {
        var word = words[i].toLowerCase()
        if (word == "")
            continue;
        word_count += 1;

        if (!(word in word_freq)) {
            word_freq[word] = 0;
        }
        word_freq[word] += 1;

        trigram[0] = trigram[1];
        trigram[1] = trigram[2];
        trigram[2] = word;
        if (trigram[0] != "") {
            trigram_key = trigram[0] + " " + trigram[1] + " " + trigram[2]
            if (!(trigram_key in trigram_freq)) {
                trigram_freq[trigram_key] = 0;
            }
            trigram_freq[trigram_key] += 1;
        }
    }
 });

function edit_distance_helper(str1, str2, i, j, dp) {
    if (dp[i][j] == -1) {
        if (i > 0) {
            var temp = edit_distance_helper(str1, str2, i-1, j, dp) + 1;
            if (dp[i][j] == -1 || temp < dp[i][j])
                dp[i][j] = temp;
        }
        if (j > 0) {
            var temp = edit_distance_helper(str1, str2, i, j-1, dp) + 1;
            if (dp[i][j] == -1 || temp < dp[i][j])
                dp[i][j] = temp;
        }
        if (i > 0 && j > 0) {
            var temp = edit_distance_helper(str1, str2, i-1, j-1, dp);
            if (str1[i-1] != str2[j-1])
                temp += 1;
            if (dp[i][j] == -1 || temp < dp[i][j])
                dp[i][j] = temp;
        }
    }
    return dp[i][j];
}
function edit_distance(str1, str2) {
    // create dynamic programming helper variable
    var dp = []
    for (var i = 0; i <= str1.length; i++) {
        dp[i] = []
        for (var j = 0; j <= str2.length; j++) {
            dp[i][j] = -1;
        }
    }
    dp[0][0] = 0;
    // dp[i][j] means the edit distance between str1[0:(i+1)] and str2[0:(j+1)]
    return edit_distance_helper(str1, str2, str1.length, str2.length, dp);
}

r.on('close', function() {
    var output = filename + ".html";
    var stream = require('fs').createWriteStream(output);
    stream.once('open', function(fd) {
        stream.write('<html>');
        stream.write('<head>');
        stream.write('<title>');
        stream.write("Document Summary Statistics - ");
        stream.write(filename);
        stream.write('</title>');
        stream.write('</head>');
        stream.write('<body>');
        stream.write("<h1> 1. The number of words in the document </h1>");
        stream.write("word count = " + word_count);
        stream.write("<h1> 2. The number of lines </h1>");
        stream.write("line count = " + line_count);
        stream.write("<h1>4. A list of the ten most common trigrams</h1>");
        // sort by freq
        // ref http://stackoverflow.com/questions/1069666/sorting-javascript-object-by-property-value
        var trigram_ranks = [];
        for (var trigram in trigram_freq)
            trigram_ranks.push([trigram, trigram_freq[trigram]])
        trigram_ranks.sort(function(a, b) {return b[1] - a[1]});
        stream.write('<table border="1">');
        stream.write("<tr>");
        stream.write("<th>Rank</th>");
        stream.write("<th>Trigram</th>");
        stream.write("<th>Count</th>");
        stream.write("</tr>");
        for (var i = 0; i < Math.min(10, trigram_ranks.length); i++) {
            stream.write("<tr>");
            stream.write("<td>" + (parseInt(i)+1) + "</td>");
            stream.write("<td>" + trigram_ranks[i][0] + "</td>");
            stream.write("<td>" + trigram_ranks[i][1] + "</td>");
            stream.write("</tr>");
        }
        stream.write("</table>");

        var top_trigram = trigram_ranks[0][0]
        var edit_distance_ranks = []
        for (var i = 1; i < Math.min(11, trigram_ranks.length); i++) {
            edit_distance_ranks.push([trigram_ranks[i][0], edit_distance(top_trigram, trigram_ranks[i][0])]);
        }
        edit_distance_ranks.sort(function(a, b) {return b[1] - a[1]});
        stream.write("<h1> 5. A listing of the edit distances between the most common trigram and the next ten most common trigrams, in order of distance value. This should include the trigrams being compared and the edit distance value.</h1>");
        stream.write("top trigram = " + top_trigram);
        stream.write('<table border="1">');
        stream.write("<tr>");
        stream.write("<th>Rank</th>");
        stream.write("<th>Trigram</th>");
        stream.write("<th>Edit Distance</th>");
        stream.write("</tr>");
        for (i in edit_distance_ranks) {
            stream.write("<tr>");
            stream.write("<td>" + (parseInt(i)+1) + "</td>");
            stream.write("<td>" + edit_distance_ranks[i][0] + "</td>");
            stream.write("<td>" + edit_distance_ranks[i][1] + "</td>");
            stream.write("</tr>");
        }
        stream.write("</table>");

        stream.write("<h1> 3. A list of all the words with the count of their occurrence, in descending order</h1>");
        // sort by freq
        // ref http://stackoverflow.com/questions/1069666/sorting-javascript-object-by-property-value
        var word_ranks = [];
        for (var word in word_freq)
            word_ranks.push([word, word_freq[word]])
        word_ranks.sort(function(a, b) {return b[1] - a[1]});
        stream.write('<table border="1">');
        stream.write("<tr>");
        stream.write("<th>Rank</th>");
        stream.write("<th>Word</th>");
        stream.write("<th>Count</th>");
        stream.write("</tr>");
        for (i in word_ranks) {
            stream.write("<tr>");
            stream.write("<td>" + (parseInt(i)+1) + "</td>");
            stream.write("<td>" + word_ranks[i][0] + "</td>");
            stream.write("<td>" + word_ranks[i][1] + "</td>");
            stream.write("</tr>");
        }
        stream.write("</table>");
        stream.write('</body>');
        stream.write('</html>');
        stream.end();
    });
});