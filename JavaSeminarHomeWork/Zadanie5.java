import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Zadanie5 {
    public static void main(String[] args) {
        List<Integer> numbers = readNumberList();

        // Удаление четных чисел
        removeEvenNumbers(numbers);

        // Поиск минимального значения
        int min = findMinValue(numbers);

        // Поиск максимального значения
        int max = findMaxValue(numbers);

        // Поиск среднего значения
        double average = calculateAverage(numbers);

        System.out.println("Список после удаления четных чисел: " + numbers);
        System.out.println("Минимальное значение: " + min);
        System.out.println("Максимальное значение: " + max);
        System.out.println("Среднее значение: " + average);
    }

    public static List<Integer> readNumberList() {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();

        System.out.print("Введите количество чисел: ");
        int count = scanner.nextInt();

        System.out.println("Введите " + count + " целых чисел:");
        for (int i = 0; i < count; i++) {
            int num = scanner.nextInt();
            numbers.add(num);
        }

        return numbers;
    }

    public static void removeEvenNumbers(List<Integer> numbers) {
        numbers.removeIf(n -> n % 2 == 0);
    }

    public static int findMinValue(List<Integer> numbers) {
        int min = Integer.MAX_VALUE;
        for (int num : numbers) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

    public static int findMaxValue(List<Integer> numbers) {
        int max = Integer.MIN_VALUE;
        for (int num : numbers) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    public static double calculateAverage(List<Integer> numbers) {
        if (numbers.isEmpty()) {
            return 0.0;
        }

        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }

        return (double) sum / numbers.size();
    }
}
