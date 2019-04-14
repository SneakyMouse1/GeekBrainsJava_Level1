public class Employee {
    // поля класса
    String name; //ФИО
    String position; //должность
    String email; //это понятно
    String phone_number; //номер телефона
    int salary; //зарплата
    int age; //возраст

    // конструктор
    public Employee(String name, String position, String email, String phone_number, int salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone_number = phone_number;
        this.salary = salary;
        this.age = age;
        }

    // переопределенный метод
    @Override
    public String toString(){
            return String.format("Имя: %s \tДолжность: %s \nEmail: %s \t Номер телефона: %s \n Зарплата: %d \t Возраст: %d \n",
                    name, position, email, phone_number, salary, age);}

    // метод вывода в консоль
    public void print(){
        System.out.println(this);
        }


    public static void main(String[] args)  {

        Employee[] persArray = new Employee[5];
                persArray[0] = new Employee("Иванов Иван Иванович", "Генеральный директор", "III@primer,ru", "+79996665544", 250000, 65);
                persArray[1] = new Employee("Петров Петр петрович", "Директор по банкетам", "PPP@primer,ru", "+79998884455", 127000, 46);
                persArray[2] = new Employee("Дмитров Дмитрий Дмитриевич", "Охранник", "DDD@primer,ru", "+79997771234", 19000, 23);
                persArray[3] = new Employee("Профурсетова Анджела Батьковна", "Секретарь", "PAB@primer,ru", "+79995554789", 120000, 28);
                persArray[4] = new Employee("Рубенштерн Аполлон Сулейманович", "Директор по работе с клиентами", "RAS@primer,ru", "+79994445896", 138000, 48);

        for (int i=0; i < persArray.length; i++)
        if (persArray[i].age > 40) persArray[i].print();

    }
}