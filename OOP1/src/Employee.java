public class Employee {

    private String full_name;
    private String position;
    private String email;
    private String phone_number;
    private double wage;
    private int age;

    public Employee(String full_name, String position, String email, String phone_number, double wage, int age) {
        this.full_name = full_name;
        this.position = position;
        this.email = email;
        this.phone_number = phone_number;
        this.wage = wage;
        this.age = age;
    }

    public void printInfo() {
        System.out.println("name: " + full_name + ", position: " + position + ", email: " + email + ", phone number: " + phone_number + ", wage: " + wage + ", age: " + age);
    }

    public int getAge() {
        return age;
    }
}
