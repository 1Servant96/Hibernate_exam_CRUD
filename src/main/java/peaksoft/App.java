package peaksoft;

import peaksoft.Entity.Person;
import peaksoft.dao.HibernateDao;

import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    static Scanner scannerS = new Scanner(System.in);
    static Scanner scannerN = new Scanner(System.in);

    public static void main(String[] args) {
        HibernateDao hibernateDao = new HibernateDao();
        while (true) {
            queries();
            String button = scannerS.nextLine();
            switch (button) {
                case "1" -> {
                    Person person = new Person();
                    System.out.println("Enter the name");
                    person.setName(scannerS.nextLine());
                    System.out.println("Enter the age");
                    person.setAge(scannerN.nextByte());
                    hibernateDao.create(person);
                }
                case "2" -> {
                    System.out.println("Enter the id of person");
                    Person result = hibernateDao.read(scannerS.nextLine());
                    System.out.println("Created: " + result);
                    System.out.println();
                }
                case "3" -> {
                    System.out.println("Enter the id of person");
                    Person person = hibernateDao.findPerson(scannerN.nextLong());
                    System.out.println("Enter the new name");
                    person.setName(scannerS.nextLine());
                    System.out.println("Enter the new age");
                    person.setAge(scannerN.nextByte());
                    hibernateDao.update(person);
                }
                case "4" -> {
                    System.out.println("Enter the id of person which you wanna delete");
                    hibernateDao.delete(hibernateDao.findPerson(scannerN.nextLong()));
                }
            }
            if (button.equals("x"))
                break;
        }
    }

    public static void queries() {
        System.out.println("Press 1 to create person\n" +
                "Press 2 to read person\n" +
                "Press 3 to update person \n" +
                "Press 4 to delete person\n" +
                "-----------------------------------"
        );
    }
}
