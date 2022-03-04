package zadanie;

import java.util.*;
import java.util.stream.Collectors;

public class Methods {

    public static List<Integer> checkPrimeNumbers(int n) {
        List<Integer> list = new ArrayList<>();
        boolean[] primeNumbers = new boolean[n];
        Arrays.fill(primeNumbers, true);
        primeNumbers[0] = false;
        primeNumbers[1] = false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            for (int j = i + i; j < n; j = j + i) {
                primeNumbers[j] = false;
            }
        }
        for (int k = 0; k < n; k++) {

            if (primeNumbers[k]) {
                list.add(k);
            }
        }
        return getListOfPrimeNumbersWithLongestElements(list);
    }

    private static int checkTheLongestLengthOfNumber(List<Integer> list) {
        Collections.sort(list);
        Integer integer = list.get(list.size() - 1);
        return String.valueOf(integer).length();
    }

    private static List<Integer> getListOfPrimeNumbersWithLongestElements(List<Integer> list) {
        int i = checkTheLongestLengthOfNumber(list);
        return list.stream()
                .filter(integer -> (int) (Math.log10(integer) + 1) == i)
                .collect(Collectors.toList());
    }

    public static List<String> convertIntToString(List<Integer> list) {
        return list.stream().map(String::valueOf)
                .collect(Collectors.toList());
    }

    public static List<String> sortEachElement(List<String> list) {
        List<String> newList = new ArrayList<>();
        for (String s : list) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            newList.add(new String(charArray));
        }
        return newList;
    }

    public static int countElementWithHighestValue(List<String> list) {
        Map<String, Long> collect = list.stream().
                collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        return findMaxElementFromMap(collect);
    }

    private static int findMaxElementFromMap(Map<String, Long> map) {
        Optional<Map.Entry<String, Long>> maxEntry = map.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue()
                );
        assert maxEntry.orElse(null) != null;
        return Math.toIntExact(maxEntry.get().getValue());
    }
}
