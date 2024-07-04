import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeJDBC {
    private static final String JDBC_DRIVER = "org.postgresql.Driver";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/rg_assignments";
    private static final String USER = "";
    private static final String PASS = "";

    public void connect() throws SQLException {
        Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
        System.out.println("Connected to database!");
        connection.close();
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }

    public void addEmployee(Employee employee) throws SQLException {
        Connection connection = getConnection();
        String sql = "INSERT INTO employees (id, name, department) VALUES (?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, employee.getId());
        statement.setString(2, employee.getName());
        statement.setString(3, employee.getDepartment());
        statement.executeUpdate();
        statement.close();
        connection.close();
        System.out.println("Employee added successfully!");
    }

    public void getAllEmployees() throws SQLException {
        Connection connection = getConnection();
        String sql = "SELECT * FROM employees";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        System.out.println("Employee list: (id, name, department)");
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String department = resultSet.getString("department");
            System.out.println(id + "\t" + name + "\t" + department);
        }
        resultSet.close();
        statement.close();
        connection.close();
    }

    public Employee getEmployeeById(int id) throws SQLException {
        Connection connection = getConnection();
        String sql = "SELECT * FROM employees WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        Employee employee = null;
        if (resultSet.next()) {
            id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String department = resultSet.getString("department");
            employee = new Employee();
            employee.setId(id);
            employee.setName(name);
            employee.setDepartment(department);
        }
        resultSet.close();
        statement.close();
        connection.close();
        return employee;
    }

    public void updateEmployee(Employee employee) throws SQLException {
        Connection connection = getConnection();
        String sql = "UPDATE employees SET name = ?, department = ? WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, employee.getName());
        statement.setString(2, employee.getDepartment());
        statement.setInt(3, employee.getId());
        int rowsUpdated = statement.executeUpdate();
        statement.close();
        connection.close();
        if (rowsUpdated > 0) {
            System.out.println("Employee updated successfully!");
        } else {
            System.out.println("Employee with ID " + employee.getId() + " not found!");
        }
    }

    public void deleteEmployee(int id) throws SQLException {
        Connection connection = getConnection();
        String sql = "DELETE FROM employees WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        int rowsDeleted = statement.executeUpdate();
        statement.close();
        connection.close();
        if (rowsDeleted > 0) {
            System.out.println("Employee deleted successfully!");
        } else {
            System.out.println("Employee with ID " + id + " not found!");
        }
    }


    public static void main(String[] args) {
        EmployeeJDBC employeeJDBC = new EmployeeJDBC();
        Employee employee1 = new Employee();
        employee1.setId(1);
        employee1.setName("Peter Parker");
        employee1.setDepartment("Engineering");
        Employee employee2 = new Employee();
        employee2.setId(2);
        employee2.setName("MJ");
        employee2.setDepartment("Engineering");

        try{
            employeeJDBC.addEmployee(employee1);
            employeeJDBC.addEmployee(employee2);

            employeeJDBC.getAllEmployees();

            Employee employee3 = employeeJDBC.getEmployeeById(2);
            System.out.println("Employee with ID " + employee3.getId() + " found!");

            employee3.setName("Gwen Stacy");
            employee3.setDepartment("Biological Engineering");
            employeeJDBC.updateEmployee(employee3);

            employeeJDBC.getAllEmployees();

            employeeJDBC.deleteEmployee(2);
            employeeJDBC.getAllEmployees();
        }
        catch(SQLException e){
            e.printStackTrace();
        }

    }
}
