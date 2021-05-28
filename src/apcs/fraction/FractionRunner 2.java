package apcs.fraction;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class FractionRunner {
    public static void main(String[] args) throws InterruptedException {

        //noinspection InfiniteLoopStatement
        while (true) {

            System.out.println("Compute-A-Fraction 5000.... Booting");
            TimeUnit.SECONDS.sleep(2);
            System.out.println("Ready for user input...");

            System.out.print("Please specify a fraction. First, enter the numerator: ");
            Scanner reader = new Scanner(System.in);
            int n1 = reader.nextInt();
            System.out.print("Now, specify a denominator: ");
            int d1 = reader.nextInt();


            Fraction firstFraction = new Fraction(n1, d1);

            boolean repeat;

            do {
                System.out.print("What would you like to do today? (\"help\" for more options) ");
                String input = reader.next().toLowerCase();
                repeat = false;

                switch (input) {
                    case "help":
                        System.out.println("The available commands are:\nexit, add, addInt, decrement, divide, divideInt, equals, greaterThan, increment, lessThan, lessThanOrEqualTo, multiply, multiplyInt, negate, simplify, subtract, and subtractInt.");
                        repeat = true;
                        break;

                    case "exit":
                    case "cancel":
                    case "stop":
                    case "restart":
                        repeat = false;
                        break;

                    case "add":
                    case "+":
                    case "plus":
                        System.out.println(
                                firstFraction.add(getSecondFraction())
                        );
                        break;

                    case "addint":
                    case "addi":
                    case "+i":
                    case "+int":
                        System.out.println(
                                firstFraction.addInt(getInt())
                        );
                        break;

                    case "decrement":
                    case "dec":
                    case "--":
                        System.out.println(
                            firstFraction.decrement()
                        );
                        break;

                    case "divide":
                    case "div":
                    case "/":
                        System.out.println(
                                firstFraction.divide(getSecondFraction())
                        );
                        break;

                    case "divideint":
                    case "divint":
                    case "divi":
                    case "/int":
                    case "/i":
                        System.out.println(
                                firstFraction.divideInt(getInt())
                        );
                        break;

                    case "equals":
                    case "equal":
                    case "=":
                    case "==":
                    case "===":
                        System.out.println(
                                firstFraction.equals(getSecondFraction())
                        );
                        break;

                    case "greaterThan":
                    case ">":
                    case "greater":
                        System.out.println(
                                firstFraction.greaterThan(getSecondFraction())
                        );
                        break;

                    case "increment":
                    case "inc":
                    case "++":
                        System.out.println(
                                firstFraction.increment()
                        );
                        break;

                    case "lessthan":
                    case "less":
                    case "<":
                        System.out.println(
                                firstFraction.lessThan(getSecondFraction())
                        );
                        break;

                    case "lessthanorequalto":
                    case "lessequal":
                    case "<=":
                        System.out.println(
                                firstFraction.lessThanOrEqualTo(getSecondFraction())
                        );
                        break;

                    case "multiply":
                    case "mult":
                    case "*":
                        System.out.println(
                                firstFraction.multiply(getSecondFraction())
                        );
                        break;

                    case "multiplyint":
                    case "multiplyi":
                    case "multint":
                    case "multi":
                    case "*int":
                    case "*i":
                        System.out.println(
                                firstFraction.multiplyInt(getInt())
                        );
                        break;

                    case "negate":
                        System.out.println(
                                firstFraction.negate()
                        );
                        break;

                    case "simplify":
                        System.out.println(
                                firstFraction.simplify()
                        );
                        break;

                    case "subtract":
                    case "sub":
                    case "-":
                    case "minus":
                        System.out.println(
                                firstFraction.subtract(getSecondFraction())
                        );
                        break;


                    case "subtractint":
                    case "subi":
                    case "subint":
                    case "-int":
                    case "-i":
                        System.out.println(
                                firstFraction.subtractInt(getInt())
                        );

                    default:
                        System.out.println("Command not recognised. Type \"help\" to receive a list of commands.");
                        repeat = true;
                        break;

                }
            } while (repeat);
        }
    }

    public static Fraction getSecondFraction() {
        System.out.print("Please specify a 2nd fraction. First, enter the numerator: ");
        Scanner reader = new Scanner(System.in);
        int n2 = reader.nextInt();
        System.out.print("Now, specify a denominator: ");
        int d2 = reader.nextInt();
        return new Fraction(n2, d2);
    }

    public static int getInt() {
        System.out.print("Please specify an int: ");
        Scanner reader = new Scanner(System.in);
        return reader.nextInt();
    }
}