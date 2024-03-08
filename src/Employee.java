import java.util.Objects;


public class Employee {

    private String nameFull;
    private int numDepartment;
    private double salary;
    private int id;
    private int counter = 1;


    public Employee(String nameFull, int numDepartment, double salary) {
        this.nameFull = nameFull;
        SetNumDepartment(numDepartment);
        this.salary = salary;
        this.id = counter++;
    }

    private void SetNumDepartment(int numDepartment) {
    }


    public String getNameFull() {
        return nameFull;
    }


    public int getNumDepartment() {
        return numDepartment;
    }


    public double getSalary() {
        return salary;
    }


    public int getId() {
        return id;
    }


    public void setNumDepartment(int numDepartment) {
        activeDepartment(numDepartment);
    }



    public void setSalary(double salary) {
        this.salary = salary;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "nameFull='" + nameFull + '\'' +
                ", numDepartment=" + numDepartment +
                ", salary=" + salary +
                ", id=" + id +
                ", counter=" + counter +
                '}';
    }


    private void activeDepartment(int numDepartment) {
        if (numDepartment < 1 || numDepartment > 5) {
            throw new IllegalArgumentException("Такого отдела нет. Укажите отдел с 1 по 5.");
        } else {
            this.numDepartment = numDepartment;
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return numDepartment == employee.numDepartment && Double.compare( salary, employee.salary ) == 0 && id == employee.id && counter == employee.counter && Objects.equals( nameFull, employee.nameFull );
    }


    @Override
    public int hashCode() {
        return Objects.hash( nameFull, numDepartment, salary, id, counter );
    }
}