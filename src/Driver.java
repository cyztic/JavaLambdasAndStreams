import java.util.Arrays;
import java.util.List;

public class Driver {

    public static void main(String[] args)
    {
        //List
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);



        //EXTERNAL ITERATORS:

        //classic for loop
        System.out.print("Classic for loop: ");
        for(int i = 0; i < numbers.size(); i++)
        {
            System.out.print(numbers.get(i));
        }
        System.out.println();

        //for each loop
        System.out.print("for each loop: ");
        for(int n : numbers)
        {
            System.out.print(n);
        }
        System.out.println();






        //INTERNAL ITERATORS:
        System.out.print("lambda: ");
        //before lambda
        /*numbers.forEach(new Consumer<Integer>() {
            public void accept(Integer value){
                System.out.println(value);
            }
        });*/

        //after lambda
        //numbers.forEach((Integer value)-> System.out.print(value));

        //numbers.forEach((value)-> System.out.print(value)); //remove integer

        //numbers.forEach(value-> System.out.print(value)); //remove parentheses

        //SINCE IT IS JUST PASSING YOU CAN REMOVE THE VARIABLE
        //TO INVOKE THE FUNCTION YOU USE DOUBLE COLONS TO METHOD REFERENCE PRINT
        numbers.forEach(System.out::print);                 //METHOD REFERENCE

        //parenthesis are only optional for one parameter lambdas
        System.out.println();





        //METHOD REFERENCE:
        System.out.print("Using stream: ");
        numbers.stream()
                //.map(e -> String.valueOf(e))
                .map(String::valueOf)                       //METHOD REFERENCE
                .forEach(System.out::print);                //METHOD REFERENCE
        System.out.println();

        /*numbers.stream()
                .map(String::valueOf)
                .map(String::toString)
                .forEach(System.out::print);*/

        System.out.println(
        numbers.stream()
                //.reduce(0, (total, e) -> Integer.sum(total , e)));
                .reduce(0, Integer::sum));          //METHOD REFERENCE

        System.out.println(
        numbers.stream()
                .map(String::valueOf)
                //.reduce("", (carry, str) -> carry.concat(str)));
                .reduce("", String::concat));       //METHOD REFERENCE
    }

}
