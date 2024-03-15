import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите числа, разделенные пробелами или запятыми:");
        String line = scanner.nextLine();

        Integer[] numbers = Arrays.stream(line.split(",\\s"))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        System.out.println("Введенный массив: " + Arrays.toString(numbers));
    }
}