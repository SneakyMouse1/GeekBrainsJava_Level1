/*
 *	Семён Смыслов
 *	задание ко 2 уроку
 */
public class HomeWork2 {
    public static void main(String[] args) {
        inv();
        fill();
        change();
        DiagNum();
        }
//1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
// С помощью цикла и условия заменить 0 на 1, 1 на 0;
    static void inv() {
        int[] arr = new int[] {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println("До: ");
        for (int i = 0; i < arr.length; i++) {
        System.out.print(arr[i] + " ");
        if (arr[i] == 0) arr[i] = 1;
        else arr[i] = 0;
        }
        System.out.println("После:  ");
        for (int i : arr) {
        System.out.print(i + " ");
        }
        }
//2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
    static void fill() {
        int[] a = new int[8];
        for (int i = 0; i < a.length; i++) {
            a[i] = i*3;
        }
        System.out.println(Arrays.toString(a));
    }

//3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
    public static void change() {
        int[] a = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < a.length; i++) {
        if (a[i] < 6) a[i] *= 2;
        }
        System.out.println(Arrays.toString(a));
        }

//4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью цикла(-ов)
// заполнить его диагональные элементы единицами;
    static void DiagNum() {
        int length = 5;
        int[][] arr = new int[length][length];
        for (int i = 0; i < length; i++) {
        for (int j = 0; j < length; j++) {
        if ((i == j) || (i == length - 1 - j)) {
        arr[i][j] = 1;
        }
        }
        }