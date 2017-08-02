__author__ = 'nicholas'

balance = 2000
balance = float(balance)
print("Hello your balance is " + str(balance))
print()
print("Choose 1 to make a deposit")
print("Choose 2 to make a withdrawal")
print("Choose 3 to show balance")
print("Choose 4 to quit")
print("please pick an option in the form of a number:")
user_input = input()
print()
user_input = int(user_input)
while user_input < 3 or user_input == 3:
   if user_input == 1:
       print("You have chosen to make a deposit.")
       print("Please enter an amount that you would like to deposit: ")
       deposit = input()
       deposit = float(deposit)
       balance = deposit + balance
   elif user_input == 2:
       print("You have chosen to make a withdrawal.")
       print("Please choose an amount you would like to withdrawal: ")
       withdrawal = input()
       withdrawal = float(withdrawal)
       balance = balance - withdrawal
   elif user_input == 3:
       print("You have chosen to show your balance")
       print("Your balance is: $" + str(balance))
   elif user_input == 4:
       break
   print("Choose 1 to make a deposit")
   print("Choose 2 to make a withdrawal")
   print("Choose 3 to show balance")
   print("Choose 4 to quit")
   print("please pick an option:")
   user_input = int(input())
