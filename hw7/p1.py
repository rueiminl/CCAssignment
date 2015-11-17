# Complete the function below.


def  diceGame( result):
    
    x = [''.join(sorted(i)) for i in result]
    y = [list(i) for i in x]
    count = 0
    for j in range(len(x[0])):
        maxnum = 0
        for i in range(len(x)):
            num = int(x[i][j])
            if num > maxnum:
                maxnum = num
                if num == 9:
                    break
        print maxnum
        count += maxnum    
    return count

