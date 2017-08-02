__author__ = 'nicholas'


print('enter first integer')
a=input()
print('enter second integer')
b=input()
if b==0:
    print(a)
else:
    while b!=0:
        t=b
        b=int(a)%int(b)
        a=t
    print(a)
