_author__ = 'alicezhang'

class Car:

    def __init__(self,inputYear,inputMake,inputModel):
        self.__year = inputYear
        self.__make = inputMake
        self.__model = inputModel

    def getYear(self):
        return self.__year

    def getMake(self):
        return self.__make

    def getModel(self):
        return self.__model

    def setYear(self,newYear):
        self.__year = newYear

    def setMake(self,newMake):
        self.__make = newMake

    def setModel(self,newModel):
        self.__model = newModel

    def __str__(self):
        output = "Car's yeat is: " + str(self.__year) + "; Make: " + self.__make + "; Model: " + self.__model
        return output

def main():
    car1 = Car(1980,"abc","ABC")
    car2 = Car(2000,"opq","OPQ"
    car3 = Car(2015,"xyz","XYZ")

    print(car1)
    print(car2)
    print(car3)

main()

