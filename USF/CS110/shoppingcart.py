__author__ = 'alicezhang'
print('Welcome to the Health Food Shop!')

print('Please enter how many potatoes you would like to buy ($0.75 per potato): ')
potatoes = input()
total1 = int(potatoes) * 0.75

print('Please enter how many tomatoes you would like to buy ($1.25 per tomato): ')
tomatoes = input()
total2 = int(tomatoes) * 1.25

print('Please enter how many apples you would like to buy ($0.5 per apple): ')
apples = input()
total3 = int(apples) * 0.5

print('Please enter how many mangoes you would like to buy ($1.75 per mango): ')
mangoes = input()
total4 = int(mangoes) * 1.75

owed = total1 + total2 + total3 + total4
print('You need to pay $', str(owed), '.')

print('Please enter the amount you pay for the food.')
(user) = float(input())

while user < owed:
    print('More Money Please.')
    user = user + float(input())

change = user - owed
print('Your change is $', change, '.')

if change > 5:
    num5bills = change//5
    remainder = change%5
    change = remainder
    print('Give', int(num5bills), '$5 bill(s).')

if change > 1:
    num1bills = change//1
    remainder = change%1
    change = remainder
    print('Give', int(num1bills), '$1 bill(s).')

if change > 0.25:
    numQ = change//0.25
    remainder = change%0.25
    change = remainder
    print('Give', int(numQ), 'Quarter(s).')

if change > 0.1:
    numD = change//0.1
    remainder = change%0.1
    change = remainder
    print('Give', int(numD), 'Dime(s).')

if change > 0.05:
    numN = change//0.05
    remainder = change%0.05
    change = remainder
    print('Give', int(numN), 'Nickel(s).')

if change > 0.01:
    numP = change//0.01
    remainder = change%0.01
    change = remainder
    print('Give', int(numP), 'Penny(ies).')
