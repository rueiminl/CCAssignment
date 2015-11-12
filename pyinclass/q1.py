# Enter your code here. Read input from STDIN. Print output to STDOUT
NT = raw_input().split(" ")
N = int(NT[0])
T = int(NT[1])
widths = raw_input().split(" ")
width = [int(i) for i in widths]
for t in range(T):
    ij = raw_input().split(" ")
    i = int(ij[0])
    j = int(ij[1])
    print min(width[i:(j+1)])
