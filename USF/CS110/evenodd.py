__author__ = 'alicezhang'
def isEven(n):
    if n%2 == 0:
        print(str(n), ' is an even number.')
    if n%2 != 0:
        print(str(n), ' is an odd number.')

def main():
    print('Input a number please.')
    n = int(input())
    isEven(n)

main()
