import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    int id;
    String name;
    double salary;

    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Salary: $" + salary;
    }
}

public class EmployeeManagement {
    public static void main(String[] args) {
        ArrayList<Employee> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add  2. Update  3. Remove  4. Search  5. Display  6. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Salary: ");
                    double salary = sc.nextDouble();
                    list.add(new Employee(id, name, salary));
                    System.out.println("Employee added.");
                    break;

                case 2:
                    System.out.print("Enter ID to update: ");
                    id = sc.nextInt();
                    for (Employee e : list) {
                        if (e.id == id) {
                            sc.nextLine();
                            System.out.print("Enter New Name: ");
                            e.name = sc.nextLine();
                            System.out.print("Enter New Salary: ");
                            e.salary = sc.nextDouble();
                            System.out.println("Employee updated.");
                            break;
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter ID to remove: ");
                    id = sc.nextInt();
                    list.removeIf(e -> e.id == id);
                    System.out.println("Employee removed.");
                    break;

                case 4:
                    System.out.print("Enter ID to search: ");
                    id = sc.nextInt();
                    for (Employee e : list) {
                        if (e.id == id) {
                            System.out.println(e);
                            break;
                        }
                    }
                    break;

                case 5:
                    if (list.isEmpty()) System.out.println("No employees found.");
                    else list.forEach(System.out::println);
                    break;

                case 6:
                    System.out.println("Exiting... Goodbye!");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
