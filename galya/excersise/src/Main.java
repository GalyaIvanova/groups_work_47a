import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
//2.1. Stream Creation
        String[] arr = new String[]{"a", "b", "c"};
        Stream<String> stream = Arrays.stream(arr);
        stream = Stream.of("a", "b", "c");
        ArrayList<String> list = new ArrayList<>();
        list.add("One");
        list.add("OneAndOnly");
        list.add("Derek");
        list.add("Change");
        list.add("factory");
        list.add("justBefore");
        list.add("Italy");
        list.add("Italy");
        list.add("Thursday");
        list.add("");
        list.add("");
        Stream<String> stream0 = list.stream();
        //Multi-threading With Streams
        List<String> listP = Arrays.asList("Hello ",
                "G", "E", "E", "K", "S!");

        listP.parallelStream().forEach(System.out::print);
        System.out.println("\n");
        listP.parallelStream().forEachOrdered(System.out::print);

//======================================================================================================
        long count = list.stream().distinct().count();

        for (String string : list) {
            if (string.contains("a")) {
               // return true;
            }
        }
        boolean isExist = list.stream()
                .distinct()
                .limit(4)
                .anyMatch(element -> element.contains("a"));

        Stream<String> stream1 = list.stream().filter(element -> element.contains("d"));
        List<String> uris = new ArrayList<>();
        uris.add("C:\\My.txt");
        Stream<Path> stream2 = uris.stream().map(uri -> Paths.get(uri));
        List<Detail> details = new ArrayList<>();
        details.add(new Detail());
        Stream<String> stream3 = details.stream().flatMap(detail -> detail.getParts().stream());


        boolean isValid = list.stream().anyMatch(element -> element.contains("h")); // true
        boolean isValidOne = list.stream().allMatch(element -> element.contains("h")); // false
        boolean isValidTwo = list.stream().noneMatch(element -> element.contains("h")); // false

        Stream.empty().allMatch(Objects::nonNull); // true

        Stream.empty().anyMatch(Objects::nonNull); // false




        List<Integer> integers = Arrays.asList(1, 1, 1);
        Integer reduced = integers.stream().reduce(23, (a, b) -> a + b);

        List<String> resultList
                = list.stream().map(element -> element.toUpperCase()).collect(Collectors.toList());
    }
}