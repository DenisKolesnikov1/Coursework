public class Main {
    public static EmployeeBook employeeBook = new EmployeeBook();

    public static void printSeparator() {
        System.out.println("====================================");
    }
    public static void main(String[] args) {

        Employee[] employees = new Employee[10];
        employees[0] = new Employee( "Петров Николай Федорович", 3, 250000 );
        employees[1] = new Employee( "Сидоров Иван Сергеевич", 1, 170000 );
        employees[2] = new Employee( "Новикова Инна Дмитриевна", 5, 80000 );
        employees[3] = new Employee( "Жданова Надежда Ивановна", 2, 90000 );
        employees[4] = new Employee( "Григорова Елена Анатольевна", 4, 120000 );
        employees[5] = new Employee( "Фомин Сергей Викторович", 3, 100000 );
        employees[6] = new Employee( "Павлова Светлана Александровна", 2, 270000 );
        employees[7] = new Employee( "Кравцов Генадий Степанович", 1, 90000 );
        employees[8] = new Employee( "Золотова Анна Олеговна", 5, 102000 );
        employees[9] = new Employee( "Жаров Иван Иванович", 5, 95000 );
        employees[0].setSalary( 200000 );
        employees[5].setNumDepartment( 3 );
        employeeBook.setEmployees(employees);
        
        printEmployees(employees);
        printSeparator();
        System.out.println("Затраты на зп составляют: " + countCosts(employees) + "рублей.");
        printSeparator();
        System.out.println("Минимальная зп у сотрудника: \n" + employees[minSalary(employees)]);
        printSeparator();
        System.out.println("Максимальная зп у сотрудника: \n" + employees[maxSalary(employees)]);
        printSeparator();
        System.out.println("Средняя зп составляет: " + employeeBook.midSalary(employees));
        printSeparator();
        employeeBook.listEmployees(employees);
    }

    public static void printEmployees(Employee[] employees) {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public static int countCosts(Employee[] employees) {
        int result = 0;
        for (int i = 0; i < employees.length; i++) {
            result = (int) (result + employees[i].getSalary());
        }
        return result;
    }

    public static int minSalary(Employee[] employees) {
        int min = (int) employees[0].getSalary();
        int idx = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() < min) {
                min = (int) employees[i].getSalary();
                idx = i;
            }
        }
        return idx;
    }

    public static int maxSalary(Employee[] employees) {
        int max = (int) employees[0].getSalary();
        int idx = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() > max) {
                max = (int) employees[i].getSalary();
                idx = i;
            }
        }
        return idx;
    }
}