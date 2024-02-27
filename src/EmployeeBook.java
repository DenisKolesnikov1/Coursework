public class EmployeeBook {
    private final Employee[] employees = new Employee[10];

    public void printEmployees() {
        for (Employee i : employees) {
            if (i != null) {
                System.out.println(i);
            }
        }
    }

    public double countCosts() {
        double p = 0;
        for (Employee i : employees) {
            if (i != null) {
                p = p + i.getSalary();
            }
        }
        return  p;
    }

    public String freeMinSalary() {
        return returnFullName(minSalary());
    }

    public String freeMaxSalary() {
        return returnFullName(maxSalary());
    }

    private String returnFullName(int idx) {
        if (idx < employees.length - 1) {
            return employees[idx].getNameFull();
        } else {
            return "Индекс за пределами базы данных";
        }
    }

    private int minSalary() {
        int idx = 0;
        double min = employees[maxSalary()].getSalary();
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() < min) {
                min = employees[i].getSalary();
                idx = i;
            }
        }
        return idx;
    }

    private int maxSalary(int depart) {
        double max = 0;
        int idx = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() > max) {
                max = employees[i].getSalary();
                idx = i;
            }
        }
        return idx;
    }

    public double midSalary() {
        return countCosts() / employees.length;
    }

    public void listEmployees() {
        System.out.println("\n Список сотрудников фирмы \n");
        for (Employee i : employees) {
            if (i != null) {
                System.out.println(i.getNameFull());
            }
        }
    }

    public void indexationSalary(int percent) {
        for (Employee i : employees) {
            if (i != null) {
                i.setSalary(i.getSalary() + i.getSalary() / 100 * percent);
            }
        }
    }

    public String freeMinSalary(int depart) {
        return returnFullName(minSalary());
    }

    public String freeMaxSalary(int depart) {
        return returnFullName(maxSalary(depart));
    }

    private int maxSalary() {
        return maxSalary( 10 );
    }

    private int employees(int depart) {
        double max = 0;
        int idx = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() > max && employees[i].getNumDepartment() == depart) {
                max = employees[i].getSalary();
                idx = i;
            }
        }
        return idx;
    }

    public double countCosts(int depart) {
        double p = 0;
        for (Employee i : employees) {
            if (i != null && i.getNumDepartment() == depart) {
                p = p + i.getSalary();
            }
        }
        return p;
    }

    public double midSalary(int depart) {
        return countCosts(depart) / countEmployeeDepartment(depart);
    }

    public int countEmployeeDepartment(int depart) {
        int count = 0;
        for (Employee i : employees) {
            if (i != null && i.getNumDepartment() == depart) {
                count++;
            }
        }
        return count;
    }

    public void indexationSalary(int depart, int percent) {
        for (Employee i : employees) {
            if (i != null && i.getNumDepartment() == depart)
                System.out.println( i.getId() + " " + i.getNameFull() + " " + i.getSalary() );
        }
    }
}