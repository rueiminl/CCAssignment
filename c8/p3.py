# Enter your code here. Read input from STDIN. Print output to STDOUT
r = raw_input()
arr = r.split()
A = [int(i) for i in arr]
A.sort()
T = input()
targets = []
for _ in range(T):
    targets.append(input())

dp = [[0]*(max(targets) + 1) for i in range(len(A)+1)]
dp[0][0] = 1
for i in xrange(1, len(A)+1):
    dp[i][0] = 1
    for j in xrange(1, max(targets)+1):
        dp[i][j] = dp[i-1][j]
        if j - A[i-1] >= 0:
            dp[i][j] += dp[i][j - A[i-1]]
            if dp[i][j] > 1000000007:
                dp[i][j] -= 1000000007

for target in targets:
    if target < 0:
        print 0
        continue
    print dp[len(A)][target]

