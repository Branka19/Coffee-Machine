package machine;
import java.util.Scanner;

public class CoffeeMachine {

        static Scanner scanner = new Scanner(System.in);    
        static int waterSupply = 400;
        static int milkSupply = 540;
        static int coffeeSupply = 120;
        static int cupSupply = 9;
        static int moneySupply = 550;
    
    public static void main(String[] args) {

        String action = null;
        
        while(true)
        {
        System.out.println("Write action (buy, fill, take, remaining, exit): ");
        action = scanner.nextLine();  
        
        switch (action) {
            case "buy":
            buy();          
            break;
            
            case "fill":
            fill();
            break;
            
            case "take":
            take();
            break;
            
            case "remaining":
            remaining();
            break;
                }
       if(action.equals("exit"))
       break;
       
        }
    }
    
    static void buy()
    {
        System.out.println();
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        String option = scanner.nextLine();    
            switch (option) {
                case "1":
             //For the espresso, the coffee machine needs 250 ml of water and 16 g of coffee beans. It costs $4.
                makeCoffee(250, 0, 16);
                moneySupply = moneySupply + 4;
                break;
                
                case "2":
                // For the latte, the coffee machine needs 350 ml of water, 75 ml of milk, and 20 g of coffee beans. It costs $7.
                makeCoffee(350, 75, 20);
                moneySupply = moneySupply + 7;
                break;
                
                case "3":
                // And for the cappuccino, the coffee machine needs 200 ml of water, 100 ml of milk, and 12 g of coffee beans. 
                //It costs $6.
                makeCoffee(200, 100, 12);
                moneySupply = moneySupply + 6;
                break;
                
                case "back":
                break;
                } 
    }   
    
    static void fill()
    {
                System.out.println();
                System.out.println("Write how many ml of water do you want to add: ");
                waterSupply += Integer.parseInt(scanner.nextLine());
                System.out.println("Write how many ml of milk do you want to add: ");
                milkSupply += Integer.parseInt(scanner.nextLine());
                System.out.println("Write how many grams of coffee beans do you want to add: ");
                coffeeSupply += Integer.parseInt(scanner.nextLine());
                System.out.println("Write how many disposable cups of coffee do you want to add: ");
                cupSupply += Integer.parseInt(scanner.nextLine());
                System.out.println();
    }
    
    static void take()
    {
            //If the user writes "take" the program should give him all the money that it earned from selling coffee.
            System.out.println("I gave you $" + moneySupply);
            moneySupply = 0;
            System.out.println();
    }
    
    static void remaining()
    {
            System.out.println();
            System.out.println("The coffee machine has:");
            System.out.println(waterSupply + " of water");
            System.out.println(milkSupply + " of milk");
            System.out.println(coffeeSupply + " of coffee beans");
            System.out.println(cupSupply + " of disposable cups");
            System.out.println("$" + moneySupply + " of money");
            System.out.println();
    }
    
                static void makeCoffee(int neededWater, int neededMilk, int neededCoffee)
                {
                if(waterSupply >= neededWater && coffeeSupply >= neededCoffee && cupSupply >= 1 && milkSupply >= neededMilk)
                {
                    waterSupply = waterSupply - neededWater;
                    milkSupply = milkSupply - neededMilk;
                    coffeeSupply = coffeeSupply - neededCoffee;
                    cupSupply = cupSupply - 1;
                    System.out.println("I have enough resources, making you a coffee!");
                    System.out.println();
                    } else
                    {
                    if(waterSupply < neededWater)
                    {System.out.println("Sorry, not enough water!");
                    System.out.println();}
                    else if(milkSupply < neededMilk)
                    {System.out.println("Sorry, not enough milk!");
                    System.out.println();}
                    else if(coffeeSupply < neededCoffee)
                    {System.out.println("Sorry, not enough coffee!");
                    System.out.println();}
                    else if(cupSupply < 1)
                    {System.out.println("Sorry, not enough cups!");
                    System.out.println();}                
                    }
                }
}
