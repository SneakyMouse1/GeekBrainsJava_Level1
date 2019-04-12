import java.util.Random;
import java.util.Scanner;

public class HomeWork4 {
    // игра крестики и нолики

    private static final char USER_SIGN_ONE ='X';
    private static final char USER_SIGN_TWO = 'O';
    private static final char AI_SIGN = 'O';
    private static final char NOT_SIGN = '_';
    private static final int Size = 6;
    private static char[][] field = new char[Size][Size];

    public static void main(String[] args) {
        mainMenu();
    }

    private static void mainMenu() {
        System.out.println("The game Tic-tac-toe.\nChoose the game mode: \n1. Player vs Computer.\n2. Two players. " +
                "\n3. Exit game.");
        int mode = 0;
        Scanner in = new Scanner(System.in);
        mode = in.nextInt();
        switch (mode) {
            case 1: {
                AIMode();
                break;
            }
            case 2: {
                TwoPlayersMode();
                break;
            }
            case 3: {
                System.exit(0);
                break;
            }
            default: {
                System.out.println("Error. Try one more time.");
            }
        }
    }

    private static void AIMode() {
        int count = 0;
        initField();
        while (true) {
            printField();
            userStep(USER_SIGN_ONE, 0);
            count++;
            if (checkWin(USER_SIGN_ONE)) {
                System.out.println("User WIN!!!");
                printField();
                break;
            }
            aiStep();
            count++;
            if (checkWin(AI_SIGN)) {
                System.out.println("Computer WIN!!!");
                printField();
                break;
            }
            if (count == Math.pow(Size, 2)) {
                printField();
                break;
            }
        }
    }


    private static void TwoPlayersMode() {
        int count = 0;
        initField();
        while (true) {
            printField();
            userStep(USER_SIGN_ONE, 1);
            count++;
            if (checkWin(USER_SIGN_ONE)) {
                System.out.println("User One WIN!!!");
                printField();
                break;
            }
            userStep(USER_SIGN_TWO, 2);
            count++;
            if (checkWin(USER_SIGN_TWO)) {
                System.out.println("User Two WIN!!!");
                printField();
                break;
            }
            if (count == Math.pow(Size, 2)) {
                printField();
                break;
            }
        }
    }

    private static void initField() {
        for (int i = 0; i < Size; i++) {
            for (int j = 0; j < Size; j++) {
                field[i][j] = NOT_SIGN;
            }
        }
    }

    private static void printField() { 
        for (int i = 0; i <= Size; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < Size; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < Size; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void userStep(char Sign, int UserNumb) {
        int x;
        int y;
        do {
            if (UserNumb == 0) {
                System.out.println("Enter the coordinates x and y from 1 to " + Size);
            } else {
                System.out.println("User " + UserNumb + ". Enter the coordinates x and y from 1 to " + Size);
            }
            Scanner sc = new Scanner(System.in);
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        }
        while (CellBusy(x, y));
        field[x][y] = Sign;
    }

    private static void aiStep() {
        int x = -1;
        int y = -1;
        boolean ai_win = false;
        boolean user_win = false;

        // Поиск победного хода
        for (int i = 0; i < Size; i++) {
            for (int j = 0; j < Size; j++) {
                if (!CellBusy(i, j)) {
                    field[i][j] = AI_SIGN;
                    if (checkWin(AI_SIGN)) {
                        x = i;
                        y = j;
                        ai_win = true;
                    }
                    field[i][j] = NOT_SIGN;
                }
            }
        }
        // Проверка последнего хода
        if (!ai_win) {
            for (int i = 0; i < Size; i++) {
                for (int j = 0; j < Size; j++) {
                    if (!CellBusy(i, j)) {
                        field[i][j] = USER_SIGN_ONE;
                        if (checkWin(USER_SIGN_ONE))
                        {
                            x = i;
                            y = j;
                            user_win = true;
                        }
                        field[i][j] = NOT_SIGN;
                    }
                }
            }
        }
        // свободный ход
        if (!ai_win && !user_win) {
            do {
                Random rnd = new Random();
                x = rnd.nextInt(Size);
                y = rnd.nextInt(Size);
            }
            while (CellBusy(x, y));
        }
        field[x][y] = AI_SIGN;
    }


    private static boolean CellBusy(int x, int y) {
        if (x < 0 || y < 0 || x > Size - 1 || y > Size - 1) {
            return false;
        }
        return field[x][y] != NOT_SIGN;
    }

    private static boolean checkLine(int start_x, int start_y, int dx, int dy, char Sign) { // сравнение линий
        for (int i = 0; i < Size; i++) {
            if (field[start_x + i * dx][start_y + i * dy] != Sign)
                return false;
        }
        return true;
    }

    private static boolean checkWin(char Sign) {
        for (int i = 0; i < Size; i++) {
            // строки
            if (checkLine(i, 0, 0, 1, Sign)) return true;
            // столбцы
            if (checkLine(0, i, 1, 0, Sign)) return true;
        }
        // диагонали
        if (checkLine(0, 0, 1, 1, Sign)) return true;
        if (checkLine(0, Size - 1, 1, -1, Sign)) return true;
        return false;
    }


    private static boolean checkWin2(char Sign) {  // запасной вариант, который был озвучен на уроке
        // проверка строк
        for (int i = 0; i < Size; i++) {
            if (field[i][0] == Sign && field[i][1] == Sign && field[i][2] == Sign) {
                return true;
            }
        }

        // проверка столбцов
        for (int j = 0; j < Size; j++) {
            if (field[0][j] == Sign && field[1][j] == Sign && field[2][j] == Sign) {
                return true;
            }
        }

        // проверка диагоналей
        if (field[0][0] == Sign && field[1][1] == Sign && field[2][2] == Sign) {
            return true;
        }
        if (field[0][2] == Sign && field[1][1] == Sign && field[2][0] == Sign) {
            return true;
        }

        return false;
    }
}