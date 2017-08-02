__author__ = 'alicezhang'
#1
def CS110length(inputString):
    counter = 0
    for ch in inputString:
        counter = counter + 1
    return counter

#2
def CS110upper(inputString):
    outputString = ""
    for ch in inputString:
        ordinalValue = ord(ch)
        if ordinalValue >= 97 and ordinalValue <= 122:
            new_ord = ordinalValue - 32
            new_ch = chr(new_ord)
            outputString = outputString + new_ch
        else:
            outputString = outputString + ch
    return outputString

#3
def CS110lower(inputString):
    outputString = ""
    for ch in inputString:
        ordinalValue = ord(ch)
        if ordinalValue >= 65 and ordinalValue <= 90:
            new_ord = ordinalValue + 32
            new_ch = chr(new_ord)
            outputString = outputString + new_ch
        else:
            outputString = outputString + ch
    return outputString

#4
def CS110rfind(inputString, ch):
    for i in range(len(inputString)-1,-1,-1):
        if inputString[i] == ch:
            return i
    return -1

#5
def CS110compare(inputString,inputString2):
    length = len(inputString)
    i = 0
    while i < length:
        if inputString[i] == inputString2[i]:
            i = i + 1
        else:
            if inputString[i] > inputString2[i]:
                return 1
            elif inputString[i] < inputString2[i]:
                return -1
    return 0

#5 - pythonCompare
def pythonCompare(inputString, inputString2):
    if inputString < inputString2:
        return -1
    elif inputString == inputString2:
        return 0
    elif inputString > inputString2:
        return 1

#6
def CS110replace(inputString, char, newchar):
    outputString = ''
    for ch in inputString:
        if ch == char:
            ch = newchar
            outputString = outputString + ch
        else:
            outputString = outputString + ch
    return outputString

#7
def CS110lstrip(inputString):
    outputString = ''
    checker = False
    for ch in inputString:
        if ch != ' ' or checker == True:
            checker = True
            outputString = outputString + ch
    return outputString

#8
#8 CS110rstrip
def CS110rstrip(inputString):
    outputString = ''
    checker = False
    for index in range(len(inputString)-1,-1,-1):
        if inputString[index] != ' ' or checker == True:
            checker = True
            outputString = inputString[index] + outputString
    return outputString

def CS110strip(inputString):
    outputString = CS110lstrip(inputString)
    returnString = CS110rstrip(outputString)
    return returnString

#9
def CS110in(inputString, char):
    for ch in inputString:
        while ch == char:
            return True
    return False

#10
def CS110notin(inputString, char):
    for ch in inputString:
        while ch != char:
            return True
    return False

def main():
    inputString = ' Alice in San Francisco '
    inputString2 = ' Alice in Wonderland '

    # Test #1
    len1 = CS110length(inputString)
    len2 = len(inputString)
    if len1 == len2:
        print('CS110length function worked successfully.')
    else:
        print('CS110length failed.')

    #Test #2
    upper1 = CS110upper(inputString)
    upper2 = inputString.upper()
    if upper1 == upper2:
        print('CS110upper function worked successfully.')
    else:
        print('CS110upper failed.')

    #Test #3
    lower1 = CS110lower(inputString)
    lower2 = inputString.lower()
    if lower1 == lower2:
        print('CS110lower function worked successfully.')
    else:
        print('CS110lower failed.')

    #Test #4
    rfind1 = CS110rfind(inputString,'i')
    rfind2 = inputString.rfind('i')
    if rfind1 == rfind2:
        print('CS110rfind function worked sucessfully.')
    else:
        print('CS110rfind failed.')

    #Test #5
    com1 = CS110compare(inputString,inputString2)
    com2 = pythonCompare(inputString,inputString2)
    if com1 == com2:
        print('CS110compare function worked successfully.')
    else:
        print('CS110compare failed.')

    #Test #6
    replace1 = CS110replace(inputString,'i', 'q')
    replace2 = inputString.replace('i','q')
    if replace1 == replace2:
        print('CS110replace function worked successfully.')
    else:
        print('CS110replace failed.')

    #Test #7
    lstrip1 = CS110lstrip(inputString)
    lstrip2 = inputString.lstrip()
    if lstrip1 == lstrip2:
        print('CS110lstrip function worked successfully.')
    else:
        print('CS110lstrip failed.')

    #Test #8
    strip1 = CS110strip(inputString)
    strip2 = inputString.strip()
    if strip1 == strip2:
        print('CS110strip function worked successfully.')
    else:
        print('CS110strip failed.')

    #Test#9
    in1 = CS110in(inputString,'i')
    in2 = 'i' in inputString
    if in1 == in2:
        print('CS110in function worked successfully.')
    else:
        print('CS110in failed.')

    #Test#10
    notin1 = CS110notin(inputString,'b')
    notin2 = 'b' not in inputString
    if notin1 == notin2:
        print('CS110notin function worked successfully.')
    else:
        print('CS110notin failed.')

main()
