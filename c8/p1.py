# Enter your code here. Read input from STDIN. Print output to STDOUT
r = raw_input()
arr = r.split()
A = [int(i) for i in arr]
A.sort()
T = input()
targets = []
for _ in range(T):
    targets.append(input())
dp = [0]*(max(targets) + 1)
dp[0] = 1
for i in xrange(1,(max(targets)+1)):
    for a in A:
        if i-a >= 0:
            dp[i] += dp[i-a]
            if dp[i] >= 1000000007:
                dp[i] -= 1000000007
        else:
            break
for target in targets:
    if target < 0:
        print 0
        continue
    print dp[target]


