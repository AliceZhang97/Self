__author__ = 'alicezhang'
import random

def computerRPS():
    RPS = random.randint(1,3)
    if RPS == 1:
        print('The computer chooses ROCK!')
        RPS = "rock"
    if RPS == 2:
        print('The computer chooses PAPER!')
        RPS = "paper"
    if RPS == 3:
        print('The computer chooses SCISSORS!')
        RPS = "scissors"
    return RPS

def main():
    print('Welcome to the ROCK PAPER SCISSORS game!')
    print('Please enter which one you choose! (rock/paper/scissors): ')
    user = input()

    RPS = computerRPS()

    if user == RPS :
        print('It is a tie!')
    elif user == "rock" and RPS == "scissors":
        print("Player wins! Rock beats scissors.")
    elif user == "scissors" and RPS == "rock":
        print("Computer wins! Rock beats scissors.")
    elif user == 'rock' and RPS == 'paper':
        print('Computer wins! Paper beats rock.')
    elif user == 'paper' and RPS == 'rock':
        print('Player wins! Paper beats rock.')
    elif user == 'scissors' and RPS == 'paper':
        print('Player wins! Scissors beat paper.')
    elif user == 'paper' and RPS == 'scissors':
        print('Computer wins! Scissors beat paper.')

main()
