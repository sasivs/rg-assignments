import java.util.ArrayList;

public class EmployeeCRUD {
    private ArrayList<Employee> employees;

    public EmployeeCRUD() {
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public Employee getEmployee(int id) {
        for (Employee employee : employees) {
            if(employee.getId() == id){
                return employee;
            }
        }
        return null;
    }

    public void deleteEmployee(int id) {
        employees.removeIf(employee -> employee.getId() == id);
    }

    public void updateEmployee(int id, String name, String department){
        Employee employee = getEmployee(id);
        if(employee != null){
            employee.setName(name);
            employee.setDepartment(department);
        }
    }

    public static void main(String[] args) {
        EmployeeCRUD crudClass =  new EmployeeCRUD();
        Employee employee1 = new Employee();
        Employee employee2 = new Employee();
        employee1.setId(1);
        employee2.setId(2);
        employee1.setName("Peter Parker");
        employee2.setName("MJ");
        employee1.setDepartment("Engineering");
        employee2.setDepartment("Engineering");
        crudClass.addEmployee(employee1);
        crudClass.addEmployee(employee2);

        ArrayList<Employee> employees = crudClass.getEmployees();
        for (Employee employee : employees) {
            System.out.println("Id: " + employee.getId());
            System.out.println("Name: " + employee.getName());
            System.out.println("Department: " + employee.getDepartment());
        }

        Employee employee3 = crudClass.getEmployee(3);
        if (employee3 != null) {
            System.out.println("Id: " + employee3.getId());
            System.out.println("Name: " + employee3.getName());
            System.out.println("Department: " + employee3.getDepartment());
        }

        crudClass.updateEmployee(2, "Gwen Stacy", "Biological Sciences");

        Employee employee4 = crudClass.getEmployee(2);
        if (employee4 != null) {
            System.out.println("Id: " + employee4.getId());
            System.out.println("Name: " + employee4.getName());
            System.out.println("Department: " + employee4.getDepartment());
        }

        crudClass.deleteEmployee(2);

        Employee employee5 = crudClass.getEmployee(2);
        if (employee5 != null) {
            System.out.println("Id: " + employee5.getId());
            System.out.println("Name: " + employee5.getName());
            System.out.println("Department: " + employee5.getDepartment());
        }

    }
}
