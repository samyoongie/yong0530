package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBConnection {
private static DBConnection db;
private Statement stmt;
Connection con;
/*private static final String DB_URL = "jdbc:sqlserver://localhost\\DEKSTOP-CSPUA39:1433;databaseName=ContainerManagement";
private static final String dbUser = "sam";
private static final String dbPass = "123";*/
private static final String DB_URL = "jdbc:sqlserver://cms-samyoongie.database.windows.net:1433;database=ContainerManagement;user=sam@cms-samyoongie;password= {Story123};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";

private DBConnection() throws ClassNotFoundException, SQLException {
   con = getConnection();
}

public static DBConnection getInstance() throws ClassNotFoundException, SQLException{
    if(db==null){
        db = new DBConnection();
    }
    return db;
}

private  Connection getConnection() throws ClassNotFoundException, SQLException{
    con=null;
    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    //con = DriverManager.getConnection(DB_URL,dbUser,dbPass);
    con = DriverManager.getConnection(DB_URL);
    return con;
}

public ResultSet RunQuery(String query) throws SQLException{
    stmt = db.con.createStatement();
    ResultSet rs = stmt.executeQuery(query);
    return rs;
}

public void RunInsert(Item item) throws SQLException {
	String sql = "INSERT INTO ITEM (ITEM_NAME, ITEM_DESCRIPTION, ITEM_QUANTITY, CUST_ID, AGENT_ID)values (?, ?, ?, ?, ?)";
    PreparedStatement statement = con.prepareStatement(sql);
    statement.setString(1, item.getItem_name());
    statement.setString(2, item.getItem_description());
    statement.setInt(3, item.getItem_quantity());
    statement.setInt(4, item.getCustomer().getCust_ID());
    statement.setInt(5, item.getAgent().getID());
    int row = statement.executeUpdate();

}

public void RunInsert(Booking booking) throws SQLException {
	String sql = "INSERT INTO BOOKING (BOOKING_ID, BOOKING_DATE, BOOKING_PRICE, CUST_ID, AGENT_ID, SCHEDULE_ID)values (?, ?, ?, ?, ?, ?)";
    PreparedStatement statement = con.prepareStatement(sql);
    statement.setInt(1, booking.getBooking_ID());
    statement.setObject(2, booking.getBooking_Date());
    statement.setDouble(3, booking.getBooking_Price());
    statement.setInt(4, booking.getCustomer().getCust_ID());
    statement.setInt(5, booking.getAgent().getID());
    statement.setInt(6, booking.getSchedule().getSchedule_ID());
    int row = statement.executeUpdate();

}


public void RunInsert(Schedule schedule) throws SQLException {
	String sql = "INSERT INTO SCHEDULE (DEPARTURETIME, ARRIVALTIME, SHIP_ID, ROUTE_ID)values (?, ?, ?, ?)";
    PreparedStatement statement = con.prepareStatement(sql);  
    statement.setObject(1, schedule.getSchedule_departuretime());
    statement.setObject(2, schedule.getSchedule_arrivaldatetime());
    statement.setInt(3, schedule.getShip().getShip_ID());
    statement.setInt(4, schedule.getRoute().getRoute_ID());
    int row = statement.executeUpdate();

}

public void RunInsert(Agent agent) throws SQLException {
	String sql = "INSERT INTO AGENT (AGENT_USERNAME, AGENT_PASSWORD, AGENT_NAME, AGENT_GENDER, AGENT_EMAILADDRESS, AGENT_CONTACTNUMBER, AGENT_COMPANYNAME, AGENT_COMPANYADDRESS, AGENT_CREDIT) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    PreparedStatement statement = con.prepareStatement(sql);
    statement.setString(1, agent.getUsername());
    statement.setString(2, agent.getPassword());
    statement.setString(3, agent.getName());
    statement.setString(4, agent.getGender());
    statement.setString(5, agent.getEmailaddress());
    statement.setString(6, agent.getContactnumber());
    statement.setString(7, agent.getCompanyname());
    statement.setString(8, agent.getCompanyaddress());
    statement.setDouble(9, agent.getCredit());
    int row = statement.executeUpdate();

}

public void RunInsert(Ship ship) throws SQLException {
	String sql = "INSERT INTO SHIP (SHIP_NAME, SHIP_BAY) values (?, ?)";
    PreparedStatement statement = con.prepareStatement(sql);
    statement.setString(1, ship.getShip_Name());
    statement.setInt(2, ship.getShip_Bay());
    int row = statement.executeUpdate();

}

public void RunInsert(Route route) throws SQLException {
	String sql = "INSERT INTO ROUTE (ROUTE_NAME, ROUTE_DEPARTUREDESTINATION, ROUTE_ARRIVALDESTINATION) values (?, ?, ?)";
    PreparedStatement statement = con.prepareStatement(sql);
    statement.setString(1, route.getRoute_Name());
    statement.setString(2, route.getDeparturedestination());
    statement.setString(3, route.getArrivaldestination());
    int row = statement.executeUpdate();
    

}

public void RunInsert(Customer customer) throws SQLException {
	String sql = "INSERT INTO CUSTOMER (CUST_NAME, CUST_ICPASSPORT, CUST_GENDER, CUST_EMAILADDRESS, CUST_CONTACTNUMBER, CUST_ADDRESS, AGENT_ID) values (?, ?, ?, ?, ?, ?, ?)";
    PreparedStatement statement = con.prepareStatement(sql);
    statement.setString(1, customer.getCust_name());
    statement.setString(2, customer.getCust_icpassport());
    statement.setString(3, customer.getCust_gender());
    statement.setString(4, customer.getCust_emailaddress());
    statement.setString(5, customer.getCust_contactnumber());
    statement.setString(6, customer.getCust_address());
    statement.setInt(7, customer.getAgent().getID());
    int row = statement.executeUpdate();

}

public void UpdateAgent (Agent agent) throws SQLException {
	String sql = "UPDATE AGENT SET AGENT_PASSWORD = ? , AGENT_EMAILADDRESS = ?, AGENT_CONTACTNUMBER = ?, AGENT_COMPANYNAME =?, AGENT_COMPANYADDRESS =?, AGENT_CREDIT =? WHERE AGENT_ID =?";
    PreparedStatement statement = con.prepareStatement(sql);
    statement.setString(1, agent.getPassword());
    statement.setString(2, agent.getEmailaddress());
    statement.setString(3, agent.getContactnumber());
    statement.setString(4, agent.getCompanyname());
    statement.setString(5, agent.getCompanyaddress());
    statement.setDouble(6, agent.getCredit());
    statement.setInt(7, agent.getID());
    int row = statement.executeUpdate();
}

public void UpdateItem (Item item) throws SQLException {
	String sql = "UPDATE ITEM SET BOOKING_ID = ? WHERE ITEM_ID =?";
    PreparedStatement statement = con.prepareStatement(sql);
    statement.setInt(1, item.getBooking().getBooking_ID());
    statement.setInt(2, item.getItem_id());   
    int row = statement.executeUpdate();
}
}
