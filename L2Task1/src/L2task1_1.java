import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

public class L2task1_1 {

    public static void main(String[] args) {
        Integer[][] array, baseArray;
        int i;
        baseArray = arrayInitialize();
        if (baseArray.length < 2) {
            System.out.println("Масив має менше 2 рядків");
            return;
        }
        prnArray(baseArray); // печать
        //int arLen = array.length - 1; // індекс останнього елеманта масиву
        array = baseArray.clone();
        sumOfAverages(array);


    }

    public static void writeToFile(Integer[][] array) {
        try (PrintStream writer = new PrintStream("arrayB.txt")) {
            for (Integer[] row : array) {
                for (Integer item : row) {
                    writer.print(item + " ");
                }
                writer.println();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Произошла ошибка при записи в файл: " + e.getMessage());
        }
    }

    public static void sumOfAverages(Integer[][] array) {
        int averageSum = 0, rowAverage;
        for (Integer[] row : array) {
            rowAverage = 0;
            for (Integer rowItem : row) {
                rowAverage += rowItem;
            }
            rowAverage /= array[0].length;
            System.out.println("averageSum: " + averageSum + " rowAverage " + rowAverage);
            averageSum += rowAverage;
        }
        System.out.println("averageSum:" + averageSum);
        Integer[][] bArray = array.clone();
        for (int i = 1; i < bArray.length; i++) {
            for (int j = 0; j < i; j++) {
                bArray[i][j] = averageSum;
            }
        }
        prnArray(bArray);
        writeToFile(bArray);
    }

    public static Integer[][] arrayInitialize() {
        Integer[][] initArray;
        System.out.println("Оберіть спосіб ініціалізації масива:");
        System.out.println("1. Консольне введення");
        System.out.println("2. Зчитування з файлу");
        System.out.println("3. Генерація випадкових чисел");
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextInt()) {
            System.out.println("Введено не числове значення.");
            scanner.next();
        }
        //       int t = 0;
//        switch (t){ //(scanner.nextInt()) {
//            case 1:
//                scanner = new Scanner(System.in);
//                System.out.println("Введіть масив чисел, які розділені пробілами");
//                String line = scanner.nextLine();
//                return Arrays.stream(line.split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
//            case 2:
//                try (Scanner fileScanner = new Scanner(new File("1dimArray.txt"))){
//                    List<Integer> numbersRead = new ArrayList<>();
//                    while (fileScanner.hasNextInt()) {
//                        numbersRead.add(fileScanner.nextInt());
//                    }
//                    fileScanner.close();
//                    return numbersRead.toArray(new Integer[0]);
//                } catch (IOException e) {
//                    System.out.println("Помилка читання: " + e.getMessage());
//                }
//                break;
//        }
        initArray = new Integer[10][12];
        Random rand = new Random();
        for (int i = 0; i < initArray.length; i++) {
            for (int j = 0; j < initArray[i].length; j++) {
                initArray[i][j] = rand.nextInt(199) - 99; //  -99 до +99
            }
        }
        return initArray;
    }

    public static void prnArray(Integer[][] array) {
        for (Integer[] row : array) {
            for (Integer rowItem : row) {
                System.out.printf("%4s ", rowItem);
            }
            System.out.println();
        }
        System.out.println();
    }
}
