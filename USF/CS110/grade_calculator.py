__author__ = 'alicezhang'

inputfile = open('/Users/alicezhang/Desktop/grades110_lab6_input.csv','r')

list = inputfile.readlines()

#Report Card
linenum = 0
for line in list:
    linenum = linenum + 1

    #Individual quizzes
    i_total = 0
    if linenum > 2:
        alist = line.split(',')
        i1 = alist[2]
        i2 = alist[4]
        i3 = alist[6]
        i_total = int(i1) + int(i2) + int(i3)
        i_total = i_tinputfile = open('/Users/alicezhang/Desktop/grades110_lab6_input.csv','r')otal / 150
        i_total = i_total * 0.3
        i_total = i_total * 100

    #Team Quizzes
    t_total = 0
    if linenum > 2:
        alist = line.split(',')
        t1 = alist[3]
        t2 = alist[5]
        t3 = alist[7]
        t_total = int(t1) + int(t2) + int(t3)
        t_total = t_total / 150
        t_total = t_total * 0.1
        t_total = t_total * 100

    #Labs
    l_total = 0
    if linenum > 2:
        alist = line.split(',')
        l1 = alist[11]
        l2 = alist[12]
        l4 = alist[13]
        l5 = alist[14]
        l_total = int(l1) + int(l2) + int(l4) + int(l5)
        l_total = l_total / 200
        l_total = l_total * 0.25
        l_total = l_total * 100

    #Projects
    p_total = 0
    if linenum > 2:
        alist = line.split(',')
        p1 = alist[8]
        p2 = alist[9]
        p3 = alist[10]
        p_total = int(p1) + int(p2) + int(p3)
        p_total = p_total / 300
        p_total = p_total * 0.3
        p_total = p_total * 100


    #In-Class Programming
    ic_total = 0
    if linenum > 2:
        alist = line.split(',')
        ic1 = alist[15]
        ic2 = alist[16]
        ic3 = alist[17]
        ic_total = ''
        ic_total = int(ic1) + int(ic2) + int(ic3)
        ic_total = ic_total /  15
        ic_total = ic_total * 0.05
        ic_total = ic_total * 100

    #Total
    total = i_total + t_total + l_total + p_total + ic_total


    if linenum > 2:
        alist = line.split(',')
        first_name = alist[0]
        last_name = alist[1]

        outputString = 'Grades for ' + first_name + ' ' + last_name + '\n'
        outputString = outputString + 'Projects:' + str(p_total.__round__(2)) + '%' + '\n'
        outputString = outputString + 'Labs:' + str(l_total.__round__(2)) + '%' + '\n'
        outputString = outputString + 'In-class:' + str(ic_total.__round__(2)) + '%' + '\n'
        outputString = outputString + 'Individual quizzes:' + str(i_total.__round__(2)) + '%' + '\n'
        outputString = outputString + 'Team quizzes:' + str(t_total.__round__(2)) + '%' + '\n'
        outputString = outputString + 'Total:' + str(total.__round__(2)) + '%' + '\n'

        if total >= 93:
            outputString = outputString + 'Current Grade:A' + '\n'
        if total >= 90 and total < 93:
            outputString = outputString + 'Current Grade:A-' + '\n'
        if total >= 87 and total < 90:
            outputString = outputString + 'Current Grade:B+' + '\n'
        if total >= 83 and total < 87:
            outputString = outputString + 'Current Grade:B' + '\n'
        if total >= 80 and total < 83:
            outputString = outputString + 'Current Grade:B-' + '\n'
        if total >= 77 and total < 80:
            outputString = outputString + 'Current Grade:C+' + '\n'
        if total >= 73 and total < 77:
            outputString = outputString + 'Current Grade:C' + '\n'
        if total >= 70 and total < 73:
            outputString = outputString + 'Current Grade:C-' + '\n'
        if total >= 67 and total < 70:
            outputString = outputString + 'Current Grade:D+' + '\n'
        if total >= 63 and total < 70:
            outputString = outputString + 'Current Grade:D' + '\n'
        if total >= 60 and total < 63:
            outputString = outputString + 'Current Grade:D-' + '\n'
        if total >= 0 and total < 60:
            outputString = outputString + 'Current Grade:F' + '\n'

        print(outputString)

        outfilename = first_name + '.txt'
        outfile = open(outfilename,'w')
        outfile.write(outputString)
        outfile.close()





