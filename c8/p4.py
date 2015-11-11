# Enter your code here. Read input from STDIN. Print output to STDOUT
def compare_area(box1, box2):
    area1 = box1[0]*box1[1]
    area2 = box2[0]*box2[1]
    if area1 < area2:
        return 1
    elif area1 > area2:
        return -1
    return 0

N = input()
boxes = []
for _ in range(N):
    box = raw_input().split()
    W = int(box[0])
    L = int(box[1])
    H = int(box[2])
    boxes.append([W, L, H])

boxes = sorted(boxes, compare_area)

dp = [0]*len(boxes)
dp[0] =boxes[0][2]
result = dp[0]
for i in xrange(1, len(boxes)):
    max_h = boxes[i][2]
    for j in range(i):
        if boxes[j][0] > boxes[i][0] and boxes[j][1] > boxes[i][1]:
            h = dp[j] + boxes[i][2]
            if h > max_h:
                max_h = h
    dp[i] = max_h
    if max_h > result:
        result = max_h
print result

