__author__ = 'alicezhang'
inputFile = open('invites.csv','r')

list = inputFile.readlines()

linenum = 0

for line in list:
    linenum = linenum + 1
    if linenum > 1:
        alist = line.split(',')
        name = alist[0]
        birthday_month = alist[2]
        birthday_day = alist[3]

        str = 'Date: 09/29/2015' + '\n'
        str = str + 'Dear ' + name + ',' + '\n'
        str = str + 'I am having a Halloween party on October 31st at my place.' +  '\n'
        str = str + 'My address is 2130 Fulton Street, San Francisco, CA 94117. ' + '\n'
        str = str + 'Please let me know if you can make it.' + '\n'
        if birthday_month == '9' and birthday_day == '29':
            str = str + 'Happy Birthday, ' + name + '!' + '\n'
        str = str + 'Alice Zhang' + '\n'

        print(str)

        outfilename = 'invite' + name + '.txt'
        outfile = open(outfilename,'w')
        outfile.write(str)
        outfile.close()
