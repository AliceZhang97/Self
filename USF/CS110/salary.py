__author__ = 'alicezhang'
def option1():
    salary1 = 100*10
    return salary1

def option2():
    n = 0
    salary2 = 1
    while n < 10:
        salary2 = salary2*2
        n = n +1
    return salary2

def main():
    salary1 = option1()
    print('For option 1, the salary will be ', salary1)
    salary2 = option2()
    print('For option 2, the salary will be ', salary2)

    if int(salary1) < int(salary2):
        print('Option 2 is a better way.')
    if int(salary1) > int(salary2):
        print('Option 1 is a better way.')

main()
