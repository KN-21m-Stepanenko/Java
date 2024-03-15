import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class L2task1_1 {
    public static void main(String[] args) {
        Random rand = new Random();
        Integer[] array = initialize_array();
        Integer[] newArray;
        int i;
        for (i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(498) - 192; //  -192 до +305
        }
        prn_array(array); // печать
        int arLen = array.length - 1;
        newArray = array.clone();
        Arrays.sort(newArray);
        //1. Знайти добутки трьох найменших та трьох найбільших елементів у масиві.
        prn_array(newArray);
        System.out.printf("Добуток 3х найменших значень: %d\n", newArray[0] * newArray[1] * newArray[2]);
        System.out.printf("Добуток 3х найбільших значень: %d\n", newArray[arLen] * newArray[arLen - 1] * newArray[arLen - 2]);
        //2. Визначити два мінімальних елементи у масиві, відсортувати елементи, що розташовані між мінімальними,
        // якщо їх кількість більше 7, а їх сума більш ніж у двічі перевищує значення найбільшого у масиві
        int startPoint = Arrays.asList(array).indexOf(newArray[0]);
        int endPoint = Arrays.asList(array).indexOf(newArray[1]);
        if (endPoint < startPoint) startPoint = startPoint + endPoint - (endPoint = startPoint);
        System.out.println("startPoint " + startPoint + ' ' + "endPoint " + endPoint);
        if (endPoint - startPoint > 8){
            int sumBetween = 0;
            for (i = startPoint + 1; i < endPoint; i++){ //?? int i
                sumBetween += array[i];
            }
            if (sumBetween > newArray[arLen]){
                Arrays.sort(array, startPoint + 1, endPoint);
            }
        }
        prn_array(array);
        //3. Визначити число від’ємних елементів, що розташовані перед найбільшим додатнім елементом масиву.
        // Якщо шукане число від’ємних елементів буде дорівнювати 0, то відсортувати у спадному порядку елементи
        // розташовані після найбільшого додатного елемента.
        int maxIndex = Arrays.asList(array).indexOf(newArray[arLen]);
        int negativeCount = 0;
        for (i = 0; i < maxIndex; i++) {
            if (array[i] < 0) negativeCount++;
        }
        System.out.println("maxIndex " + maxIndex + " negativeCount " + negativeCount);
        if (negativeCount == 0) {
            Arrays.sort(array, maxIndex + 1, arLen + 1, Collections.reverseOrder());
        }
        prn_array(array);
        //4. Змінити порядок розташування елементів на обернений, потім відсортувати елементи першої половини
        // масиву у спадному порядку, зменшити на мінімальний елемент з першої половини елементи другої половини масиву.
        int temp;
        for (i = 0; i < array.length/2; i++){
            temp = array[i];
            array[i] = array[arLen - i];
            array[arLen-i] = temp;
        }
        Arrays.sort(array, 0, array.length / 2, Collections.reverseOrder());
        for (i = array.length / 2; i < array.length; i++) {
            array[i] -= array[array.length / 2 - 1];
        }
        prn_array(array);
        //5. Знайти найбільший додатній та найменший від’ємний елементи у масиві та поміняти їх місцями.
        newArray = array.clone();
        Arrays.sort(newArray);
        prn_array(newArray);
        startPoint = Arrays.asList(array).indexOf(newArray[0]);
        endPoint = Arrays.asList(array).indexOf(newArray[arLen]);
        temp = array[startPoint];
        array[startPoint] = array[endPoint];
        array[endPoint] = temp;
        prn_array(array);
    }

    public static Integer[] initialize_array(){
        System.out.println("Оберите спосіб ініціалізації масива:");
        System.out.println("Введення через консоль: 1");
        System.out.println("Зчитування із файла: 2");
        System.out.println("Заповнення випадковими числами: 3");

        Integer[] array = new Integer[50];
        return array;
    }
    public static void prn_array(Integer[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.println("Элемент " + (i) + ": " + array[i]);
        }

    }
}