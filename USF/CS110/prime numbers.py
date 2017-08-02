__author__ = 'nicholas'

print("Welcome! Enter an integer greater than 1 and I will determine if it is prime:")
num=int(input())
div=2

while div<num:
   if num > 1:
       rem=num%div
       #print(rem)
       while rem > 0 and div<num:
           div=div+1
           #print(div)
           rem=num%div
           #print(rem)
       if rem==0 and div<num:
           print(str(num)+" is not prime because it is divisible by "+str(div))
       break
if div==num:
   print(str(num)+" is prime!")
