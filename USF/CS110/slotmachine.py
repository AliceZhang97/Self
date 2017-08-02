__author__ = 'alicezhang'
import random
import time

def roll():
    print('The slot machine is rolling!')
    time.sleep(1)

def main():
    startingBalance = 20
    print('Your starting Balance is $20.')
    roll()

    playAgain = 'y'
    while startingBalance > 5 and (playAgain == 'y' or playAgain == 'Y'):
        num1 = random.randint(1,10)
        num2 = random.randint(1,10)
        num3 = random.randint(1,10)

        print(num1, num2, num3)

        if num1 == num2 and num1 == num3:
            print('You have won the Jackpot! You win $20!')
            startingBalance = startingBalance + 20
        if num1 == num2 or num1 == num3 or num2 == num3:
            print('You have won a partial jackpot. You win $5!')
            startingBalance = startingBalance + 5
        else:
            print('Sorry, you lose $2.')
            startingBalance = startingBalance - 2
        print('Your balance now is $', startingBalance)

        print('Do you want to play agian? Enter Y to continue!')
        playAgain = input()

main()
