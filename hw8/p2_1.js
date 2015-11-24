/*
 * Complete the function below.
 */
function doesCircleExist(commands) {
    var x = 0;
    var y = 0;
    var dir = 0;
    for (var i = 0; i < commands.length; i++) {
        if (commands[i] == 'G') {
            if (dir == 0) {
                y++;
            } else if (dir == 1) {
                x++;
            } else if (dir == 2) {
                y--;
            } else {
                x--;
            }
        } else if (commands[i] == 'R') {
            dir++;
            if (dir == 4)
                dir = 0;
        } else {
            dir--;
            if (dir < 0)
                dir = 3;
        }
    }
    if (dir == 0 && (x != 0 || y != 0))
        return "NO";
    else
        return "YES";
}
