__author__ = 'alicezhang'
print('Welcome to the Calculator Program!')

def add(num1, num2):
    result1 = int(num1) + int(num2)
    print('The answer is ', result1, '.')
    return add

def subtract(num1, num2):
    result2 = int(num1) - int(num2)
    print('The answer is ', result2, '.')
    return subtract

def multiply(num1, num2):
    result3 = int(num1) * int(num2)
    print('The answer is ', result3)
    return multiply

def divide(num1, num2):
    result4 = int(num1) / int(num2)
    print('The answer is ', result4)
    return divide

def playAgain():
    print('Do you want to go back the beginning and start again? Enter Y to continue!')
    user = input()
    if user == 'y' or user == 'Y':
        main()
    else:
        print('Thank you! Bye!')

def main():
    print('Please enter a number.')
    num1 = input()
    print('Please enter another number.')
    num2 = input()
    print('Please choose a mathematical operation among +,-,* and /.')
    operation = input()
    if operation == '+':
        add(num1, num2)
    if operation == '-':
        subtract(num1, num2)
    if operation == '*':
        multiply(num1, num2)
    if operation == '/':
        divide(num1, num2)
    playAgain()

main()



