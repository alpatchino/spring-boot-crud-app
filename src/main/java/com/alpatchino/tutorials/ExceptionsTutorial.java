package com.alpatchino.tutorials;

import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by patri on 08/10/2017.
 */
public class ExceptionsTutorial {

    /**
     * Checked exceptions − A checked exception is an exception that occurs at compile time,
     * and must be declared in the throws clause of a method. These exceptions cannot be ignored
     * at the time of compilation, the programmer should take care of (handle) these exceptions.
     */

    /**
     * Unchecked exceptions − An unchecked exception is an exception that occurs at the time of execution.
     * These are also called as Runtime Exceptions. These include programming bugs, such as logic
     * errors or improper use of an API. Runtime exceptions are ignored at the time of compilation.
     */

    /**
     * Errors are series runtime enviroment problems that are almost certainly not recoverable.
     * Examples include OutOfMemoryError, LinkageError, StackOverflowError.
     */

    /**

     Best practices you must consider:


     #1 - Never swallow exception in catch block - you will lose cause of error forever

         catch (NoSuchMethodException e) {
         return null;
         }

     #2 Declare specific checked exceptions that your method can throw

         public void foo() throws Exception { !! Do not do this !!
         }

         public void foo() throws SpecificException1, SpecificException2 { //Correct way
         }

     #3 Do no catch the Exception class, catch the specific sub classes instead

     #4 Never catch Throwable class

     #5 Always correctly wrap the exceptions in custom exceptions so that stack trace is not lost

         catch (NoSuchMethodException e) {
            throw new MyServiceException("Some information: " + e.getMessage());  //Incorrect way
         }

         catch (NoSuchMethodException e) {
            throw new MyServiceException("Some information: " , e);  //Correct way
         }

     #6
     */

    // Exceptions thrown during course of execution. Our responsibility to catch these
    java.lang.RuntimeException runtime;

    // ExceptionsTutorial checked by the compiler. Compiler will warn and not let you run program
    java.lang.Exception ex;

    // Other common ExceptionsTutorial
    ArithmeticException a;
    ClassNotFoundException b;
    IllegalArgumentException c;
    IndexOutOfBoundsException d;
    InputMismatchException f;
    IOException g;

    static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args){

        divideByZero(2);

        int age = checkValidAge();

        if(age != 0){
            System.out.println("You are " + age + " years old");
        }

    }

    private static int checkValidAge() {

        try{
            return userInput.nextInt();
        }catch(InputMismatchException e){
            userInput.next();
            System.out.print("Not a number!");
            return 0;
        }
    }

    private static void divideByZero(int a) {

        try{

            System.out.println(a/0);

        }catch (ArithmeticException e){
            // Nicer exception message
            System.out.println(e.getMessage());
            // Print entire stack trace
            e.printStackTrace();
        }
    }

    private static void tryWithResources(){

        try(FileReader fr = new FileReader("filepath")){

            // use resource
        }catch(IOException e){
            e.printStackTrace();
        }
    }

}

// User defined exceptions
class InsufficientFundsException extends Exception {

    private double amount;

    public InsufficientFundsException(double amount){ this.amount = amount;}

    public double getAmount(){ return amount; }
}

class CheckingAccount{

    private double balance;
    private int number;

    public void withdraw(double amount) throws InsufficientFundsException {
        if(amount <= balance) {
            balance -= amount;
        }else {
            double needs = amount - balance;
            throw new InsufficientFundsException(needs);
        }
    }
}

/**
 *  Then we use:
 *
 *      try {
 *          c.withdraw(100.00);
 *      }catch(InsufficientFundsException e){
 *          System.out.println("Sorry, but you do not have sufficient funds for this transaction);
 *          e.printStackTrace();
 *      }
 */

