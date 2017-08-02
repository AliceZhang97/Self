__author__ = 'alicezhang'
print('Welcome to the Payroll Manager!')

def payroll_calculator(eName,hoursWorked,payRate):
    if hoursWorked <= 40:
        salary = hoursWorked * payRate
    if hoursWorked > 40:
        salary1 = 40 * payRate
        salary2 = (hoursWorked - 40) * (1.5 * payRate)
        salary = salary1 + salary2
    print(eName, ', the hours you worked is ', hoursWorked, ', and your salary is $', str(salary), '.')

def main():
    print('Enter your name please.')
    eName = input()
    print('Enter the hours you worked please.')
    hoursWorked = int(input())
    print('Enter your pay rate please.')
    payRate = int(input())

    payroll_calculator(eName,hoursWorked,payRate)

main()
