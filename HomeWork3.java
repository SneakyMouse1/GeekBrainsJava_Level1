import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

class HomeWork3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Тыкните и выберите: 1 - Угадай число, 2 - Угадай слово");
        int a = in.nextInt();
        if (a == 1) GuessTheNumber(); //Задание 1.
        else GuessTheWord(); //Задание 2
    }
    //Написать программу, которая загадывает случайное число от 0 до 9, и пользователю дается 3 попытки угадать это число.
// При каждой попытке компьютер должен сообщить больше ли указанное пользователем число чем загаданное, или меньше.
// После победы или проигрыша выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).
    public static void GuessTheNumber(){
        Scanner in = new Scanner(System.in);

        int a, n = (int)(Math.random()*10);
        System.out.println("Программа загадала число от 0 до 9. У вас 3 попытки, чтобы отгадать.");
        for (int i = 0; i < 3; i++){
            System.out.println("Попытка " + (i+1) + ": ");
            a = in.nextInt();
            if (a < n) System.out.println("Число больше!");
            if (a > n) System.out.println("Число меньше!");
            if (a == n) {System.out.println("Вы угадали!");
                System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
                a = in.nextInt();
                if (a == 1) GuessTheNumber();
                else {System.out.println("Спасибо за игру!");
                    System.exit(0);
                }
            }
        }
        System.out.println("Вы не угадали(((((");
        System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
        a = in.nextInt();
        if (a == 1) GuessTheNumber();
        else {System.out.println("Спасибо за игру!");
        }
    }
//2 * Создать массив из слов String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado",
// "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive",
// "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
//При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
//сравнивает его с загаданным словом и сообщает правильно ли ответил пользователь. Если слово не угадано,
// компьютер показывает буквы которые стоят на своих местах.
//apple – загаданное
//apricot - ответ игрока
//ap############# (15 символов, чтобы пользователь не мог узнать длину слова)

    public static void GuessTheWord(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rnd = new Random();
        String word;
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear",
                "pepper", "pineapple", "pumpkin", "potato"};
        System.out.println(Arrays.toString(words));
        int n = rnd.nextInt(words.length);
        System.out.println(words[n]);
        System.out.println("Программа загадала слово, попробуйте угадать");
        char[] chs = words[n].toCharArray();
        char[] chCmp = new char[chs.length];
        for (int i = 0; i < chs.length; i++) {
            chCmp[i] = '*';
        }

        while (true) {
            System.out.print("Введите слово (0 exit): ");
            word = sc.nextLine();
            if (word.equals("0")) {
                break;
            }
            if (word.equals(words[n])) {
                System.out.println("Вы угадали)))))");
                break;
            } else {
                System.out.println("Вы не угадали((((((");
                char[] chWord = word.toCharArray();

                for (int i = 0; i < chs.length; i++) {
                    if (i >= chWord.length) {
                        break;
                    }
                    if (chs[i] == chWord[i]) {
                        chCmp[i] = chs[i];
                    }
                }
                System.out.println(String.valueOf(chCmp));
            }
        }

    }
}