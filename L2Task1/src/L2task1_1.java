import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

public class L2task1_1 {

    public static void main(String[] args) {
        Integer[][] array, baseArray;
        baseArray = arrayInitialize();
        if (baseArray.length < 2) {
            System.out.println("Масив має менше 2 рядків");
            return;
        }
        prnArray(baseArray); // печать
        sumOfAverages(baseArray);
        swapColumns(baseArray);
        prnArray(baseArray); // печать
    }

    public static Integer[][] cloneBMatrix(Integer[][] array) {
        Integer[][] copy = new Integer[array.length][array[0].length];
        for (int i = 0; i < copy.length; i++) {
            for (int j = 0; j < copy[1].length; j++) copy[i][j] = array[i][j];
        }
        return copy;
    }

    public static void swapColumns(Integer[][] array) {
        int minPositive = Integer.MAX_VALUE, maxNegative = Integer.MIN_VALUE;
        for (Integer[] row : array) {
            for (Integer rowItem : row) {
                if (rowItem > 0) {
                    if (rowItem < minPositive) minPositive = rowItem;
                    continue;
                }
                if (rowItem < 0) {
                    if (rowItem > maxNegative) maxNegative = rowItem;
                }
            }
        }
        double result = (double) minPositive / maxNegative;
        System.out.println("Bідношення мінімального з додатних елементів до максимального з від’ємних: " + result);
        Integer[][] newBArray = cloneBMatrix(array);
        for (Integer[] row : newBArray) {
            for (int i = 0; i < row.length / 2; i++) {
                Integer temp = row[i];
                row[i] = row[row.length - i - 1];
                row[row.length - i - 1] = temp;
            }
        }
        prnArray(newBArray);
        writeToFile(newBArray);
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
            System.out.println("Помилка запису у файл: " + e.getMessage());
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
        Integer[][] newBArray = cloneBMatrix(array);
        for (int i = 1; i < newBArray.length; i++) {
            for (int j = 0; j < i; j++) {
                newBArray[i][j] = averageSum;
            }
        }
        prnArray(newBArray);
        writeToFile(newBArray);
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
