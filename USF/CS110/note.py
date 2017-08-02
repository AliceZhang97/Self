__author__ = 'alicezhang'
password = "mickey"
userinput = "donald"
numAttemps = 3

while userinput != password:
    print('Please enter your password: ')
    userinput = input()
    numAttemps = numAttemps - 1
    if numAttemps < 0:
        break

if userinput != password:
    print('Sorry! incorrect password')

if numAttemps < 0:
    print('Your three attemps are up! You have been locked out.')

