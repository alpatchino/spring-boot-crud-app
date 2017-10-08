package com.alpatchino;

import com.alpatchino.orders.Order;

import java.util.*;

/**
 * Created by patri on 22/09/2017.
 *
 * Taken from: https://www.youtube.com/watch?v=wOks4LW6I24
 */
public class Java8 {



    public void example(){

        List<Order> orders = new ArrayList<>();

        /***


        Java 7
        Collections.sort(orders, new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2){
                return o1.number.compareTo(o2.name);
            }
        });


        Java 8

         * Make use of parameter type inference
         * Only specify the types when compiler needs it

        orders.sort((o1, o2) -> o1.number.compareTo(o2.number));

         * Do not use parameter brackets when optional
            str -> str.toUpperCase(Locale.US);

         Prefer expression lambdas over block lambdas
         Use separate method if necessary
         // prefer
             str -> str.toUpperCase(Locale.US);
             // use with care
             str -> {
                return str.toUpperCase(Locale.US);
             }


         Java8 for Abstraction

          * Can also be used when two methods have very similar code
          * abstract the difference with lambdas
         *
             private int doFoo(){
                return doFooBar(lambdaOfFooSpecificLogic);
             }

             private int doFooBar(Function<A, B> fn){
                 // lots of code
                 result = fn.apply(arg);
                 // lots of code
                 return 0;
             }


         Functional Interfaces

           * An interface with a single abstract method
            Runnable
            Comparable
            Callable

           * Java 8 adds many new functional interfaces
            Function<T, R>
            Predicate<T>
            Supplier<T>
            Consumer<T>
            see java.util.function package

             @FunctionalInterface - guards against someone trying to add another method
             public interface FooBarQuery {
                public abstract Foo findAllFoos(Bar bar);


         TESTING FOR EXCEPTIONS - https://youtu.be/wOks4LW6I24?t=16m18s

           * Use a helper method (TestHelper from OpenGamma Strata)
           * Lots of variations on this theme are possible, so quick to write more unit tests

             public void testConstructorRejectsEmptyString(){
                TestHelper.assertThrows(IllegalArgumentException.class, () -> new Foo(""));
             }


         OPTIONAL AND NULL - https://youtu.be/wOks4LW6I24?t=18m45s

          * Simple concept; object can be present with a value or empty (Optional.empty())
          * Variable fo type Optional must never, ever, ever be null

             # Standard code

             // library, should return null if not found
             public Foo findFoo(String key) { ... }

             // application code must remember to check for null
             Foo foo = findFoo(key);
             if (foo == null){
                foo = Foo.DEFAULT;
             }

             # Java 8 alternative

             // library, returns Optional if not found
             public Optional<Foo> findFoo(String key) { ... }

             // application code
             Foo foo = findFoo(key).orElse(Foo.Default);
             // or
             Foo foo = findFoo(key).orElseThrow(RuntimeException::new);

          * Have a discussion about Optional and be consistent
              * A: Use everywhere instead of null
              * B: Use instead of null on public APIs, input and output
              * C: Use instead of null on public return types (preferred)

          * If you use write an API using option C then you can guarantee that
            every time you call a method it'll never be null]
          * Optional is a class
          * Some memory/performance cost to using it
          * Not serializable
          * Not ideal to be an instance variable
          * JDK authors added it for return types
          * Use in parameters often annoying for callers
          * User as return type gets best value from concept

          More info: http://blog.joda.org/2015/08/java-se-8-optional-pragmatic-approach.html


         STREAMS - https://youtu.be/wOks4LW6I24?t=23m

              # Standard code

             List<Trade> trades = loadTrades();
             List<Money> valued = new ArrayList<Money>();

             for (Trade t : trade){
                 if(t.isActive(){
                    Money pv = presentValue(t);
                    value.add(pv);
             }

             # Java 8 alternative

             List<Trade> trades = loadTrades();
             List<Money> valued = trades.stream()
                                        .filter(t -> t.isActive())
                                        .map(t -> presentValue(t))
                                        .collect(Collectors.toList());


         INTERFACES

         * Now have super-powers
         * Default methods, normal methods but on interface
         * Static methods, "
         * Extend interfaces without breaking compatibility
         * Cannot default equals, hashCode, toString
         * New macro design options
         * Instead of factory class, use static method on inteface
         * Instead of abstract class, use interface with defaults
         * Results in fewer classes

         * Use modifiers, much clearer now there are different types of methods
         * Prepares for possible future with non-public methods

            public interface Foo {
                 public static of(String key) { ... }
                 public abstract getKey();
                 public default inActive() { ... }
            }

         ***/


    }






}
