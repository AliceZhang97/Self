__author__ = 'alicezhang'

def rprint(n):
    if n == 0:
        return
    else:
        rprint(n-1)
        print(n)

def rmult(x,y):
    if y == 0:
        return 0
    else:
        result = x + rmult(x,y-1)
        return result

def rlines(n):
    if n == 0:
        return
    else:
        rlines(n-1)
        print("*"* n)

def rLargestList(l):
    if len(l) == 1:
        return l[0]
    else:
        num = rLargestList(l[1:])
        if num > l[0]:
            return num
        else:
            return l[0]

def rSumList(l):
    if len(l) == 1:
        return l[0]
    else:
        result = l[0] + rSumList(l[1:])
        return result

def rSum(n):
    if n == 0:
        return 0
    else:
        result = n + rSum(n-1)
        return result

def rPower(x,n):
    if n == 0:
        return 1
    else:
        result = x * rPower(x,n-1)
        return result

def main():
    #rprint
    n = int(input("Enter a number."))
    rprint(n)

    #rmult
    x = int(input("Enter a number."))
    y = int(input("Enter another number."))
    output = rmult(x,y)
    print(output)

    #rlines
    n = int(input("Enter a number."))
    rlines(n)

    #rLargestList
    l = []
    y = input("Do you want to add a number?")
    while y == "y" or y == "Y":
        print("Add a number.")
        x = int(input())
        l.append(x)
        print("Do you want to add a number?")
        y = input()
    print("The largest number in the list is: ", rLargestList(l))

    #rSumList
    l = []
    y = input("Do you want to add a number?")
    while y == "y" or y == "Y":
        print("Add a number.")
        x = int(input())
        l.append(x)
        print("Do you want to add a number?")
        y = input()
    print("The sum of this list is: ", rSumList(l))

    #rSum
    n = int(input("Enter a number."))
    output = rSum(n)
    print(output)

    #rPower
    x = int(input("Enter a number."))
    n = int(input("Enter its exponent."))
    output = rPower(x,n)
    print(output)


main()
