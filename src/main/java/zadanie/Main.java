package zadanie;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> list = Methods.checkPrimeNumbers(123456789);
        List<String> collect = Methods.convertIntToString(list);
        List<String> list1 = Methods.sortEachElement(collect);
        System.out.println("The solution to this problem is a number: " + Methods.countElementWithHighestValue(list1));
    }
}
