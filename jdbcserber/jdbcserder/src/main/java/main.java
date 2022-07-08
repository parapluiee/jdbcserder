import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class main {
    public static void main(String args[]){
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch(Exception exception){
            System.out.println("Class.forName() error");
        }
        try {
            SQLServerDataSource datab = new SQLServerDataSource();
            datab.setDatabaseName("javabase");
            datab.setServerName("localhost");
            datab.setUser("javauser");
            datab.setPassword("t3stp@ssword");
            datab.setTrustServerCertificate(true);
            //datab.setURL("jdbc:sqlserver://localhost/javabase;user=moi;password=moi3tement^");
            conn = datab.getConnection();
        }
        catch (Exception ex){
            System.out.println(ex.toString());
        }
        String query = "SELECT Weaponname FROM tableau";
        try (Statement stmt = conn.createStatement()) {
        ResultSet rs = stmt.executeQuery(query);
        System.out.println(rs.toString());
        System.out.println("lol");
        }catch (Exception ex){
            System.out.println(ex.toString());
        }
    }
}
