__author__ = 'alicezhang'
from os import listdir
from os.path import isfile, join
print('Please enter your path.')
mypath = str(input())
onlyfiles = [ f for f in listdir(mypath) if isfile(join(mypath,f)) ]

word_frequency = {}

file_num = 0
for file in onlyfiles:
    file_num = file_num + 1
    if file_num > 1:
        afile = file.split()
        print(afile)

        linenum = 0
        inputfile = open("/Users/alicezhang/Downloads/docs/" + afile[0] , 'r')

        for line in inputfile:

            alist = line.split()

            ch_count = 0
            for ch in alist:
                ch = ch.lower()
                ch = ch.strip()
                ch = ch.replace(",","")
                ch = ch.replace(":","")
                ch = ch.replace(";","")
                ch = ch.replace(".","")
                ch = ch.replace("-","")
                ch = ch.replace("'","")
                ch = ch.replace("!","")
                ch = ch.replace("?","")
                ch = ch.replace("*","")
                ch = ch.replace("\"","")
                ch = ch.replace("\'","")
                print(ch)
                if ch in word_frequency:
                    count = word_frequency[ch]
                    count = count + 1
                    word_frequency[ch] = count
                else:
                    word_frequency[ch] = 1



outfile = open("/Users/alicezhang/Downloads/docs/index.html" , 'w')

htmloutput = ""
htmloutput += "<!DOCTYPE html>"
htmloutput += "<html>"
htmloutput += "<body>"
htmloutput += "<h1><b>Words</b> and <b>Count</b></h1>"
htmloutput += "<table>"
# for loop
for ch in word_frequency:
    if word_frequency[ch] > 50:
        htmloutput += "<tr><td>" + ch + "</td>" + "<td>" + str(word_frequency[ch]) + "</td></tr>"

htmloutput += "</table>"
htmloutput += "</body>"
htmloutput += "</html>"

outfile.write(htmloutput)
outfile.close()
