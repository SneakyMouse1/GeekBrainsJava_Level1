/*
 *	Семён Смыслов
 *	задание к занятию 1
 */

//1. Создать пустой проект в IntelliJ IDEA и прописать метод main();
//2. Создать переменные всех пройденных типов данных, и инициализировать их значения;
public class HomeWork1 {
    public static void main(String[] args) {
        int a = 5;
        long b = 1000000000000L;
        short c = 32000;
        byte d = 127;
        float f = 1.3252365f;
        double g = 1.34634543653;
        boolean l = true;
        char ch = 'l';
        System.out.println(calc(1,2,3,4));
        System.out.println(sum10to20(5,6));
        posorneg(3);
        System.out.println(ifneg(-5));
        greetings("Георгий");
        LeapYear(100);
    }
    //3. Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат,
    //где a, b, c, d – входные параметры этого метода;
    public static int calc(int a, int b, int c, int d){
        return a*(b+(c/d));
    }
    //4. Написать метод, принимающий на вход два числа, и проверяющий что их сумма лежит
    //в пределах от 10 до 20(включительно), если да – вернуть true, в противном случае – false;
    public static boolean sum10to20 (int a, int b){
        if (a + b >= 10 && b + a <= 20 ){
            return true;
        }
        else return false;
    }
    //5. Написать метод, которому в качестве параметра передается целое число, метод должен
    //напечатать в консоль положительное ли число передали, или отрицательное; Замечание: ноль
    //считаем положительным числом.
    public static void posorneg(int a){
        if (a >= 0) System.out.println("Положительное число");
        else System.out.println("Отрицательное число");
    }
    //6. Написать метод, которому в качестве параметра передается целое число, метод должен
    //вернуть true, если число отрицательное;
    public static boolean ifneg(int a){
        if (a < 0)
            return true;
        return false;
    }
    //7. Написать метод, которому в качестве параметра передается строка, обозначающая имя,
    //метод должен вывести в консоль сообщение «Привет, указанное_имя!»;
    public static void greetings (String name){
        System.out.println("Привет, " + name + "!");
        //альтернативный способ System.out.printf("Привет, %s!" , name);
    }
    //8. * Написать метод, который определяет является ли год високосным, и выводит сообщение
    //в консоль. Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й
    //– високосный.
    public static void LeapYear (int year){
        boolean leapYear = ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0));
        if (leapYear) System.out.printf(year + " г. високосный");
        else System.out.printf(year + " г. не високосный");
    }
}

}