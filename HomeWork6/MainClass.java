import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Add distance for runnig: ");
        double distance_run = in.nextInt();
        System.out.println("Add distance for swimming: ");
        double distance_sw = in.nextInt();
        System.out.println("Add height for jumping: ");
        double distance_jump = in.nextInt();

        Cat CatOne = new Cat("Cat Timka", 200, 0, 2);
        Dog DogOne = new Dog("Dog Sharik", 500, 10, 0.5);
        Dog DogTwo = new Dog("Dog Rex", 600, 10, 0.5);

        CatOne.running(distance_run);
        CatOne.swimming(distance_sw);
        CatOne.jumping(distance_jump);

        DogOne.running(distance_run);
        DogOne.swimming(distance_sw);
        DogOne.jumping(distance_jump);

        DogTwo.running(distance_run);
        DogTwo.swimming(distance_sw);
        DogTwo.jumping(distance_jump);
    }
}

