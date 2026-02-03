import java.sql.*;

public class StudentDB {
    static final String URL="jdbc:mysql://localhost:3306/test";
    static final String USER="root";
    static final String PASS="1234";

    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(URL,USER,PASS);

        // INSERT
        PreparedStatement ps = con.prepareStatement(
            "insert into student values(?,?)");
        ps.setInt(1,101);
        ps.setString(2,"Akash");
        ps.executeUpdate();

        // READ
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from student");
        while(rs.next()){
            System.out.println(rs.getInt(1)+" "+rs.getString(2));
        }
        con.close();
    }
}
