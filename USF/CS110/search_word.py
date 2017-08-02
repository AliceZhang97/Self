__author__ = 'alicezhang'

inputfile = open("/Users/alicezhang/Downloads/docs/Alice-in-Wonderland.txt",'r')

print('Enter a word you want to search.')
search_string = input()

list = inputfile.readlines()

linenum = 0

word_count = 0

for line in list:
    linenum = linenum + 1
    if linenum > 1:
        alist = line.split()
        for ch in alist:
            if ch.__contains__(search_string):
                print(str(linenum) + line)
                word_count = word_count + 1

print('The total work count is ', word_count)
