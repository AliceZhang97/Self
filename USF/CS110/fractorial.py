__author__ = 'nicholas'

print('please enter an integer')
a=input()
k=1
if int(a)<0:
    print('error')
else:
    if int(a)==0:
        k=1
    while int(a)>=1:
        k=int(k)*int(a)
        a=int(a)-1
    print(k)
