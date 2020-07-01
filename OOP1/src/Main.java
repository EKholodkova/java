public class Main {
    public static void main(String[] args) {
        getArray();
    }

    public static void getArray() {
        Employee[] eArray = new Employee[5];
        eArray[0] = new Employee("Petrov Ivan", "Product manager", "ipetrov@gmail.com", "88009995341", 55000.5, 39);
        eArray[1] = new Employee("Sokolov Victor", "Engineer", "vsocolov@gmail.com", "84991253671", 70000.95, 43);
        eArray[2] = new Employee("Ivanova Marina", "Accountant", "mivanova@gmail.com", "84956617874", 49500.0, 52);
        eArray[3] = new Employee("Stepanov Vasiliy", "Carrier", "vstepanov@gmail.com", "89054412389", 31000.0, 25);
        eArray[4] = new Employee("Korolev Leonid", "Director's Son", "lkorolev@gmail.com", "89507777777", 150630.4, 19);


        for(int i = 0; i < eArray.length; i ++) {
            if(eArray[i].getAge() > 40)
            eArray[i].printInfo();
        }
    }
}
