package sit.int202;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("\nProblem 1 :");
        problem1();
        System.out.println("\nProblem 2 :");
        problem2();
        System.out.println("\nProblem 3 :");
        problem3();
        System.out.println("\nProblem 4 :");
        problem4();
    }

    private static void problem1() {
        List<Student> students = Arrays.asList(
                new Student(10001, "Somsri", 3.25),
                new Student(10002, "Somsak", 3.00),
                new Student(10009, "Somchai", 3.26),
                new Student(10007, "Somsiri", 3.25),
                new Student(10037, "Sirisopaphan", 3.25)
        );

        HashSet<Student> studentHashSet = new HashSet<>(students);
        TreeSet<Student> studentTreeSet = new TreeSet<>(students);

        System.out.println("Unsorted HashSet:");
        studentHashSet.forEach(System.out::println);

        System.out.println("\nUnsorted TreeSet:");
        studentTreeSet.forEach(System.out::println);

        List<Student> sortedStudentsHashSet = new ArrayList<>(studentHashSet);
        Collections.sort(sortedStudentsHashSet);

        List<Student> sortedStudentsTreeSet = new ArrayList<>(studentTreeSet);
        Collections.sort(sortedStudentsTreeSet);


        System.out.println("\nSorted HashSet:");
        sortedStudentsHashSet.forEach(System.out::println);

        System.out.println("\nSorted TreeSet:");
        sortedStudentsTreeSet.forEach(System.out::println);
    }

    private static void problem2() {
        int[] nums = {1,2,3,5,8,7,9,6,4};
        int target = 6;

        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            map.putIfAbsent(complement, new ArrayList<>());
            map.get(complement).add(i);
        }

        boolean foundPairs = false;

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                List<Integer> complementIndices = map.get(nums[i]);
                for (int complementIndex : complementIndices) {
                    if (i < complementIndex) {
                        System.out.println("Indices: " + Arrays.toString(new int[]{i, complementIndex}));
                        foundPairs = true;
                    }
                }
            }
        }

        if (!foundPairs) {
            System.out.println("No solution found.");
        }
    }

    private static void problem3() {
        try {
            File file = new File("/Users/Ratchiiz/Desktop/jcfreview/src/main/java/sit/int202/data.txt"); // Replace with your file path
            Scanner scanner = new Scanner(file);
            Map<String, List<Integer>> wordFrequencyMap = new HashMap<>();

            int position = 1;
            while (scanner.hasNext()) {
                String word = scanner.next();
                word = word.replaceAll("[^a-zA-Z]", "");

                if (!word.isEmpty()) {
                    wordFrequencyMap.putIfAbsent(word, new ArrayList<>());
                    wordFrequencyMap.get(word).add(position);
                }

                position++;
            }

            List<Map.Entry<String, List<Integer>>> sortedEntries = new ArrayList<>(wordFrequencyMap.entrySet());
            sortedEntries.sort(Comparator.comparingInt(entry -> entry.getValue().size()));

            for (Map.Entry<String, List<Integer>> entry : sortedEntries) {
                System.out.print(entry.getKey() + " (" + entry.getValue().size() + ") : ");
                for (Integer location : entry.getValue()) {
                    System.out.print("@" + location + " ");
                }
                System.out.println();
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }

    private static void problem4() {
        int[] array = {8, 2, 3, 7, 8, 8, 7, 4, 7, 4, 4, 2, 2, 3, 8, 7, 7, 3, 3, 8};

        Map<Integer, List<Integer>> numberPositions = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            int number = array[i];
            numberPositions.putIfAbsent(number, new ArrayList<>());
            numberPositions.get(number).add(i);
        }

        int highestFrequency = 0;
        int numberWithHighestFrequency = 0;
        for (Map.Entry<Integer, List<Integer>> entry : numberPositions.entrySet()) {
            int frequency = entry.getValue().size();
            if (frequency > highestFrequency) {
                highestFrequency = frequency;
                numberWithHighestFrequency = entry.getKey();
            }
        }

        System.out.print(numberWithHighestFrequency + " (" + highestFrequency + ") : ");
        List<Integer> positions = numberPositions.get(numberWithHighestFrequency);
        for (int position : positions) {
            System.out.print(position + " ");
        }
        System.out.println();
    }
}