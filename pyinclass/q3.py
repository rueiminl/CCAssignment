# Complete the function below.


def  max_Chocolates( arr):
    for k in arr:
        if (k % 2) == 0:
            print (k/2)*(k/2)
        else:
            print (k/2+1)*(k/2)

