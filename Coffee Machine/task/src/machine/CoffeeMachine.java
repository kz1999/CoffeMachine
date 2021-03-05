package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] machine = new int[5];
        machine[0] = 400;//water
        machine[1] = 540;//milk
        machine[2] = 120;//coffee beans
        machine[3] = 9;//cups
        machine[4] = 550;//money

        boolean exit = false;
        while(!exit) {
            System.out.println("Write action (buy, fill, take, remaining, exit");
            String input = sc.nextLine();

            switch (input) {
                case "buy":
                    buy(machine);
                    break;
                case "fill":
                    fill(machine);
                    break;
                case "take":
                    take(machine);
                    break;
                case "remaining":
                    print(machine);
                    break;
                case "exit":
                    exit = true;
                    break;
            }
        }
    }

    private static void take(int[] machine) {
        machine[4] = 0;
    }

    private static void fill(int[] machine) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water do you want to add:");
        machine[0] += scanner.nextInt();
        System.out.println("Write how many ml of milk do you want to add: ");
        machine[1] += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        machine[2] += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add: ");
        machine[3] += scanner.nextInt();
    }

    private static void buy(int[] machine) {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        Scanner scanner = new Scanner(System.in);
        String type = scanner.nextLine();

        switch (type) {
            case "1":
                espresso(machine);
                break;
            case "2":
                latte(machine);
                break;
            case "3":
                cappuccino(machine);
                break;
            case "back":
                break;
        }
    }

    private static void espresso(int[] machine) {
        if (machine[0] < 250){
            System.out.println("Sorry, not enough water!");
        } else if (machine[2] < 16) {
            System.out.println("Sorry, not enough coffee beans!");
        } else if (machine[3] == 0) {
            System.out.println("Sorry not enough disposable cups!");
        } else {
            machine[0] -= 250;
            machine[2] -= 16;
            machine[3]--;
            machine[4] += 4;
            System.out.println("I have enough resources, making you coffee!");
        }
    }

    private static void latte(int[] machine) {

        if (machine[0] < 350){
            System.out.println("Sorry, not enough water!");
        } else if (machine[1] < 75) {
            System.out.println("Sorry, not enough milk!");
        }else if (machine[2] < 20) {
            System.out.println("Sorry, not enough coffee beans!");
        } else if (machine[3] == 0) {
            System.out.println("Sorry not enough disposable cups!");
        } else {
            machine[0] -= 350;
            machine[1] -= 75;
            machine[2] -= 20;
            machine[3]--;
            machine[4] += 7;
            System.out.println("I have enough resources, making you coffee!");
        }
    }

    private static void cappuccino(int[] machine) {

        if (machine[0] < 200){
            System.out.println("Sorry, not enough water!");
        } else if (machine[1] < 100) {
            System.out.println("Sorry, not enough milk!");
        }else if (machine[2] < 12) {
            System.out.println("Sorry, not enough coffee beans!");
        } else if (machine[3] == 0) {
            System.out.println("Sorry not enough disposable cups!");
        } else {
            machine[0] -= 200;
            machine[1] -= 100;
            machine[2] -= 12;
            machine[3]--;
            machine[4] += 6;
            System.out.println("I have enough resources, making you coffee!");
        }
    }

    private static void print(int[] machine) {
        System.out.println("The coffee machine has:\n" + machine[0] + " of water\n" +
                machine[1] + " of milk\n" + machine[2] + " of coffee beans\n" +
                machine[3] + " of disposable cups\n" + machine[4] + " of money\n");
    }
}