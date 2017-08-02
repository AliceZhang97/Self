__author__ = 'nicholas'

AVG = 0
SUM = 0
MIN = 1000
MAX = 0
i = 10
count = 10

print('We are going to find out the min, max, and average of 10 numbers')
while i > 0:
    print('Please enter number', str(i), 'of your choice:')
    NUMBER = int(input('Please enter number', str(i), 'of your choice:'))
#    NUMBER = int(NUMBER)
    #MIN STATEMENT
    if NUMBER < MIN:
        MIN = NUMBER
    else:
        MIN = MIN
     #MAX STATEMENT
    if NUMBER > MAX:
        MAX = NUMBER
    else:
        MAX = MAX
    SUM = SUM + NUMBER
    i = i - 1

AVG = SUM/count
print('Min =', MIN, '-', 'Max =', MAX, '-', 'Average =', AVG)
