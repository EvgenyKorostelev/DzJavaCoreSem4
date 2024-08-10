

public class Worker {

    private final String name;
    private final String dateBirth;
    private int salary;
    private Customer.Gender gender;

    public Worker(String name, String dateBirth, int salary, Customer.Gender gender) {
        this.name = name;
        this.dateBirth = dateBirth;
        this.salary = salary;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public Customer.Gender getGender() {
        return gender;
    }

    public void setGender(Customer.Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", dateBirth='" + dateBirth + '\'' +
                ", salary=" + salary +
                '}';
    }
}


