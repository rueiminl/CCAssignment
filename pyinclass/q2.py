# Enter your code here. Read input from STDIN. Print output to STDOUT
def gcd(x, y):
   while(y):
       x, y = y, x % y
   return x

T = int(raw_input())
for t in range(T):
    N = int(raw_input())
    A = [int(i) for i in raw_input().split()]
    found = False
    for i in range(len(A)):
        for j in xrange(i+1, len(A)):
            if gcd(A[i], A[j]) == 1:
                found = True
                break
        if found:
            break
    if found:
        print "YES"
    else:
        print "NO"

