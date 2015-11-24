/*
 * Complete the function below.
 */
function cavityMap(arr) {
    if (arr.length <= 2)
        return arr;
    var res = [];
    res.push(arr[0]);
    for (var i = 1; i < arr.length - 1; i++) {
        var row = arr[i][0];
        for (var j = 1; j < arr[i].length - 1; j++) {
            if (arr[i][j] > arr[i-1][j] && arr[i][j] > arr[i+1][j] && arr[i][j] > arr[i][j-1] && arr[i][j] > arr[i][j+1])
                row += 'X';
            else
                row += arr[i][j];
        }
        row += arr[i][arr[i].length - 1];
        res.push(row);
    }
    res.push(arr[arr.length - 1]);
    return res;
}


