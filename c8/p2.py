# Enter your code here. Read input from STDIN. Print output to STDOUT
x = raw_input().split()
L = int(x[0])
C = int(x[1])
INT_MAX = L * C + 1
lines = []
for i in range(L):
    lines.append(raw_input())

traces = [[False for i in range(C)] for i in range(L)]
paths = [[0 for i in range(C)] for i in range(L)]
steps = [[INT_MAX for i in range(C)] for i in range(L)]
paths[0][0] = 1
steps[0][0] = 0
traces[0][0] = True
candidates = []
if C > 1 and lines[0][1] == 'o':
    candidates.append([0,1])
if L > 1 and lines[1][0] == 'o':
    candidates.append([1,0])
step = 1
# format of candidate: [x, y, path]
while len(candidates) > 0:
    for candidate in candidates:
        r = candidate[0]
        c = candidate[1]
        if steps[r][c] < INT_MAX:
            # done before
            continue
        path = 0
        if r > 0 and steps[r-1][c] < step:
            path += paths[r-1][c]
        if r < L - 1 and steps[r+1][c] < step:
            path += paths[r+1][c]
        if c > 0 and steps[r][c-1] < step:
            path += paths[r][c-1]
        if c < C - 1 and steps[r][c+1] < step:
            path += paths[r][c+1]
        if path > 1000000007:
            path -= 1000000007
        paths[r][c] = path
        steps[r][c] = step
    new_candidates = []
    for candidate in candidates:
        r = candidate[0]
        c = candidate[1]
        if r > 0 and not traces[r-1][c]:
            traces[r-1][c] = True
            if lines[r-1][c] == 'o':
                new_candidates.append([r-1,c])
        if r < L - 1 and not traces[r+1][c]:
            traces[r+1][c] = True
            if lines[r+1][c] == 'o':
                new_candidates.append([r+1,c])
        if c > 0 and not traces[r][c-1]:
            traces[r][c-1] = True
            if lines[r][c-1] == 'o':
                new_candidates.append([r,c-1])
        if c < C - 1 and not traces[r][c+1]:
            traces[r][c+1] = True
            if lines[r][c+1] == 'o':
                new_candidates.append([r,c+1])
    candidates = new_candidates
    step += 1
print paths[L-1][C-1]
if steps[L-1][C-1] == INT_MAX:
    print -1
else:
    print steps[L-1][C-1]

