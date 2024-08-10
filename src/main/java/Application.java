import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Worker> list = new ArrayList<>();
        list.add(new Worker("Никита", "2000-01-01", 1000, Customer.Gender.FEMALE));
        list.add(new Worker("Леонид", "2000-01-01", 1000, Customer.Gender.MALE));
        list.add(new Worker("Светлана", "2000-01-01", 1000, Customer.Gender.FEMALE));
        list.add(new Worker("Моника", "2000-01-01", 1000, Customer.Gender.FEMALE));
        list.add(new Worker("Владимир", "2000-01-01", 1000, Customer.Gender.MALE));

        for (Worker worker : list) {
            System.out.println(worker);
        }

        list.getFirst().setGender(Customer.Gender.MALE);
        System.out.println();
        for (Worker worker : list) {
            System.out.println(worker);
        }

        System.out.println();
        congratulation(list.toArray(Worker[]::new));
    }

    public enum Holidays {

        NO_HOLIDAY("Нет праздника"),
        NEW_YEAR("Новый год"),
        MARCH_8("8 Марта"),
        FEBRUARY_23("23 Февраля");

        private final String title;

        Holidays(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }

        @Override
        public String toString() {
            return "{'" +
                    title + '\'' +
                    '}';
        }

        public static Holidays currentDay() {
            LocalDate currentDate = LocalDate.now();
            Holidays currDay = Holidays.values()[0];
            if (currentDate.toString().startsWith("01-01", 5)) {
                currDay = Holidays.values()[1];
            } else if (currentDate.toString().startsWith("02-23", 5)) {
                currDay = Holidays.values()[3];
            } else if (currentDate.toString().startsWith("03-08", 5)) {
                currDay = Holidays.values()[2];
            }
            return currDay;
        }
    }

    public static void congratulation(Worker[] workers) {
        Holidays currentDay = Holidays.currentDay();
        switch (currentDay) {
            case NEW_YEAR:
                System.out.println("Поздравляю Всех сотрудников с праздником " + currentDay.getTitle());
                break;
            case FEBRUARY_23:
                for (Worker worker : workers) {
                    if (worker.getGender().equals(Customer.Gender.MALE)) {
                        System.out.println(worker.getName() + " Поздравляю Вас с " + currentDay.getTitle());
                    }
                }
                break;
            case MARCH_8:
                for (Worker worker : workers) {
                    if (worker.getGender().equals(Customer.Gender.FEMALE)) {
                        System.out.println(worker.getName() + " Поздравляю Вас с " + currentDay.getTitle());
                    }
                }
                break;
            case NO_HOLIDAY:
                System.out.println(currentDay.getTitle());
                break;
        }
    }
}
