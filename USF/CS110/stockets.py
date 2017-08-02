__author__ = 'alicezhang'
print('This is the Stock Transaction Program.')
print('Please enter your name.')
name = input()

print('Please enter the amount of shares you want to buy.')
numShares = input()
totalPrice1 = int(numShares)*32.87
print(str(name) + ', the amount of money you pay is $' + str(totalPrice1) + '.')
commission1 = 0.02*int(totalPrice1)
print('The amount of commission you need to pay your broker is $' + str(commission1) + '.')

print('Please enter the amount of shares you want to sale.')
numShares = input()
totalPrice2 = int(numShares)*33.92
print(str(name) + ', the amount of money you sale is $' + str(totalPrice2) + '.')
commission2 = 0.02*int(totalPrice2)
print('The amount of commission you need to pay your broker is $' + str(commission2) + '.')

amount1 = int(totalPrice1) + int(commission1)
print(str(amount1))
amount2 = int(totalPrice2) - int(commission2)
print(str(amount2))
left = int(amount2) - int(amount1)
if left > 0:
    print(str(name) + ', you made a profit!')
else:
    print(str(name) + ', you lost money.')

print('Bye, ' + str(name) + '.')
