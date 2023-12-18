import javax.management.Query;
import java.sql.*;

public class JdbcExample {
    // java ; JDBC -> database
    // Java Database Connectivity - an API that allows Java to talk to different databases (mySQL, etc.)
    // 1. download the driver
    // 2. databases: SQL, mysql, postgres
    // 3. link to database
    // 4. username, password

    public static void main(String[] args) {
        String dbUrl = "jdbc:mysql://localhost:3306/demo_db";
        String username = "root";
        String password = "";
        Statement statement = null;
        ResultSet resultSet = null;
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(dbUrl, username, password);
            System.out.println("Connected to database successfully.");
            statement = conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM employees");
            statement = conn.createStatement();
            statement.execute("INSERT INTO employees VALUES(Null, 'Jack', 44)");// sql injection


            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                System.out.println("ID: "+id+" Name: "+name+" Age: "+age);

            }
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
        // Execute the sql statements
        // executeQuery() just to read
        // execute() just to update, remove, etc.
    }
}
