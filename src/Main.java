public class Main {
    public static EmployeeBook employeeBook = new EmployeeBook();
    public static void printSeparaor() {
        System.out.println("=====================================");
    }
    public static void main(String[] args) {

        Employee[] employees = new Employee[10];
        employees[0] = new Employee("Петров Николай Федорович",  3,  250000);
        employees[1] = new Employee("Сидоров Иван Сергеевич",  1,  170000);
        employees[2] = new Employee("Новикова Инна Дмитриевна",  5,  80000);
        employees[3] = new Employee("Жданова Надежда Ивановна",  2,  90000);
        employees[4] = new Employee("Григорова Елена Анатольевна",  4,  120000);
        employees[5] = new Employee("Фомин Сергей Викторович",  3,  100000);
        employees[6] = new Employee("Павлова Светлана Александровна",  2,  270000);
        employees[7] = new Employee("Кравцов Генадий Степанович",  1,  90000);
        employees[8] = new Employee("Золотова Анна Олеговна",  5,  102000);
        employees[9] = new Employee("Жаров Иван Иванович",  5,  95000);
        employees[0].setSalary(200000);
        employees[5].setNumDepartment(3);

        printEmployees(employees);
        printSeparator();
        System.out.println("Затраты на зп составляют: " + countCosts(employees) + " рублей.");
        printSeparator();

        employees[0] = null;
        Employee employeeWithMinSalary = getEmployeeWithMinSalary(employees);
        if (employeeWithMinSalary != null){
            System.out.println("Минимальная заработная плата у сотрудника: \n " + employeeWithMinSalary);
        }

        printSeparator();
        System.out.println("Максимальная заработна плата у сотрудника: \n" + employees[maxSalaryDepart(employees)]);
        printSeparator();
        System.out.println("Средняя заработная плата составляет: " + midSalary(employees));
        printSeparator();
        listEmployees(employees);


        printSeparaor();
        indexationSalary(employees, 10);
        printSeparaor();
        System.out.println("Минимальная зарплата в отделеу сотрудника: " + employees[minSalaryDepart(employees, 3)].getNameFull());
        printSeparaor();
       System.out.println("Максимальная зарплата в отделеу сотрудника: " + employees[maxSalaryDepart(employees, 6)].getNameFull());
        printSeparaor();
        System.out.println(councostsDepart(employees, 6));
        printSeparaor();
        System.out.println(countEmployeeDepart(employees, 6));
        System.out.println(minSalaryDepart(employees, 6));
        indexationSalaryDepart(employees, 6, 15);
    }

    private static int maxSalaryDepart(Employee[] employees) {
        return 0;
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

    public static Employee getEmployeeWithMinSalary(Employee[] employees) {
        int min = Integer.MAX_VALUE;
        Employee tempEmployee = null;
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() < min) {
                min = (int) employee.getSalary();
                tempEmployee = employee;
            }
        }
        return tempEmployee;
    }

    public static Employee getEmployeeWithMaxSalary(Employee[] employees) {
        int max = Integer.MAX_VALUE;
        Employee tempEmployee = null;
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() > max) {
                max = (int) employee.getSalary();
                tempEmployee = employee;
            }
        }
        return tempEmployee;
    }

    public static float midSalary(Employee[] employees) {
        return (float) countCosts(employees) / employees.length;
    }

    public static void listEmployees(Employee[] employees) {
        System.out.println("\n Список сотрудников фирмы\n");
        for (Employee i : employees) {
            System.out.println(i.getNameFull());
        }
    }

    public static void printSeparator() {
        System.out.println("=====================================");
    }


    public static void indexationSalary(Employee[] employees, int percent) {
        for (Employee i: employees) {
            i.setSalary(i.getSalary() + i.getSalary() / 100 * percent);
        }
    }

    public static int minSalaryDepart(Employee[] employees, int depart) {
        int min = (int) employees[0].getSalary();
        int idx = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() < min && employees[i].getNumDepartment() == depart) {
                min = (int) employees[i].getSalary();
                idx = i;
            }
        }
        return idx;
    }

    public static int maxSalaryDepart(Employee[] employees, int depart) {
        int max = (int) employees[0].getSalary();
        int idx = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() > max && employees[i].getNumDepartment() == depart) {
                max = (int) employees[i].getSalary();
                idx = i;
            }
        }
        return idx;
    }

    public static int councostsDepart(Employee[] employees, int depart) {
        int p = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getNumDepartment() ==depart) {
                p = (int) (p + employees[i].getSalary());
            }
        }
        return p;
    }

    public static float midSalaryDepart(Employee[] employees, int depart) {
        return (float) councostsDepart(employees, depart) / countEmployeeDepart(employees, depart);
    }

    public static int countEmployeeDepart(Employee[] employees, int depart) {
        int count = 0;
        for (Employee i : employees) {
            if (i.getNumDepartment() == depart) {
                count++;
            }
        }
        return count;
    }

    public static void indexationSalaryDepart(Employee[] employees, int depart, int percent) {
      for (Employee i : employees) {
          if (i.getNumDepartment() == depart) {
              i.setSalary(i.getSalary() + i.getSalary() / 100 * percent);
          }
      }
    }
}