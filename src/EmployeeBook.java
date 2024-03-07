public class EmployeeBook {

    private Employee[] employees;

    public EmployeeBook() {
        employees = new Employee[10];
    }


    public void printEmployees() {
        for (Employee i : employees) {
            if (i != null) {
                System.out.println(i);
            }
        }
    }


    public double countCosts() {
        double f = 0;

        for (Employee i : employees) {
            if (i != null) {
                f = f + i.getSalary();
            }
        }
        return f;
    }


    public String freeMinSalary() {
        return returnFullName(minSalary());
    }

    private String returnFullName(int i) {
        return null;
    }


    public String freeMaxSalary() {
        return returnFullname(maxSalary());
    }

    private String returnFullname(int i) {
        return null;
    }


    private int minSalary() {
        int idx = 0;
        double min = employees[maxSalary()].getSalary();
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null &&employees[i].getSalary() < min) {
                min = employees[i].getSalary();
                idx = i;
            }
        }
        return idx;
    }


    private int maxSalary() {
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


    public double midSalary(Employee[] employees) {
        return countCosts() / this.employees.length;
    }


    public void listEmployees(Employee[] employees) {
        System.out.println("\n Список сотрудников фирмы \n");
        for (Employee i : this.employees) {
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


    public String freeminSalary(int depart) {
        return returnFullName(minSalary(depart));
    }


    public String freeMaxSalary(int depart) {
        return returnFullName(maxSalary(depart));
    }


    private int minSalary(int depart) {
        double min = employees[maxSalary(depart)]. getSalary();
        int idx = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() < min && employees[i].getNumDepartment() == depart) {
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
            if (employees[i] != null && employees[i].getSalary() > max && employees[i].getNumDepartment() == depart) {
                max = employees[i].getSalary();
                idx = i;
            }
        }
        return idx;
    }


    public double countCosts(int depart) {
        double f = 0;
        for (Employee i : employees) {
            if (i != null && i.getNumDepartment() == depart) {
                f = f + i.getSalary();
            }
        }
        return f;
    }


    public double midSalary(int depart) {
        return countCosts(depart) / countEmployeeDepart(depart);
    }

    private double countEmployeeDepart(int depart) {
        return 0;
    }


    public void indexationSalary(int depart, int percent) {
        for (Employee i : employees) {
            if (i != null && i.getNumDepartment() == depart) {
                i.setSalary(i.getSalary() + i.getSalary() / 100 * percent);
            }
        }
    }


    public void listEmployees(int depart) {
        System.out.println("Список сотрудников отдела " + depart);
        for (Employee i : employees) {
            if (i != null && i.getNumDepartment() == depart) {
                System.out.println(i.getId() + " " + i.getNameFull() + " " + i.getSalary());
            }
        }
    }


    public void printSalaryLess(int less) {
        System.out.println("Сотрудник с зарплатой " + less + " рублей и меньше:");
        for (Employee i : employees) {
            if (i != null && i.getSalary() <= less) {
                System.out.println(i.getId() + " " + i.getNameFull() + " " +i.getSalary());
            }
        }
    }


    public void printSalaryMore(int more) {
        System.out.println("Сотрудник с зарплатой " + more + " рублей и больше:");
        for (Employee i : employees) {
            if (i != null && i.getSalary() >= more) {
                System.out.println(i.getId() + " " + i.getNameFull() + " " + i.getSalary());
            }
        }
    }

    public void setEmployees(Employee[] employees) {
        this.employees = employees;
    }
}