/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConnectionClass;
import java.sql.*;
/**
 *
 * @author LENOVO
 */

public class ConnectionClass {
    public Connection con;
PreparedStatement pst;
ResultSet rst;
public void Connect()
{
try
{
//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
//con=DriverManager.getConnection("jdbc:odbc:DSN3PM");
Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=dbcvcm;integratedSecurity=true;");
    System.out.println("connected");
}
catch(Exception ex)
{
System.out.println("error in connection"+ex);
}
}
public void Disconnect(){
    try
    {
        con.close();
        System.out.println("Disconnected");
    }
    catch(Exception ex)
    {
        System.out.println("error in DisConnection"+ex);
    }
}
public void show()
{
    try
    {
        pst=con.prepareStatement("select * from tbcenter");
        rst=pst.executeQuery();
        while(rst.next())
        {
            System.out.println("EmployeeID="+rst.getString(1));
            System.out.println("EmployeeName="+rst.getString(2));
            System.out.println("Phone="+rst.getString(3));
            System.out.println("Salary="+rst.getString(4));
            System.out.println("DOJ="+rst.getString(5));
            System.out.println("EmpAddress="+rst.getString(6));       
        }
        rst.close();
    }
    catch(Exception ex)
    {
        System.out.println("Error in Select"+ex);
    }
}
public static void main(String a[]){
    ConnectionClass cobj=new ConnectionClass();
    cobj.Connect();
    cobj.show();
    cobj.Disconnect();
}
}

