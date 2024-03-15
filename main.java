import java.util.Arrays;
import java.util.Collections;

public class main {
    public static void main(String[] args) {
        Integer[] array = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};

        // Проверка, есть ли в массиве 5 элементов
        if(array.length < 5) {
            System.out.println("Массив содержит менее 5 элементов");
        } else {
            // Сортировка элементов массива, начиная с 5-го элемента
            Arrays.sort(array, 4, array.length, Collections.reverseOrder());

            // Вывод отсортированного массива
            for (int i : array) {
                System.out.print(i + " ");
            }
        }
    }
}
