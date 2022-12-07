//This code is used to connect to the database using the MySQL Workbench.
//We use the DriverManager class to connect to the database.
//We then use the Connection object to access the database and perform queries.
import java.sql.Connection;
import java.sql.DriverManager;
import java.io.FileInputStream;
import java.sql.SQLException;
import java.util.Properties;
import java.io.IOException;

public class ConnectDB {

public static void main(String[] args) { 
   //Create a connection to the database
   String url = "jdbc:mysql://localhost:3307/petroleum & oil";
   String username = "root";
   String password = "password";

try {
   //Create a connection to the database
   Connection con = DriverManager.getConnection(url, username, password);
   System.out.println("Connected to the database successfully.");

} catch (Exception ex) {
   System.out.println("Error connecting to the database:" + ex.getMessage());
} 
}
//In this code we are creating a method to search for records in our database using the query method.
//We use the ResultSet interface to retrieve the data from the query.
//We then use the while loop to loop through the results and print out the data that matches our query.
public void searchRecords(String symbol, String currency, String open, String low) {

String query = "SELECT * FROM oilandgas WHERE symbol = ? AND currency = ? AND open = ? AND low = ?";

try {
   PreparedStatement statement = con.prepareStatement(query);
   statement.setString(1, symbol);
   statement.setString(2, currency);
   statement.setString(3, open);
   statement.setString(4, low);

   //Execute the query
   ResultSet resultSet = statement.executeQuery();

   //Loop through the results
   while (resultSet.next()) {
       System.out.println("Symbol: " + resultSet.getString("symbol"));
       System.out.println("Currency: " + resultSet.getString("currency"));
       System.out.println("Open: " + resultSet.getString("open"));
       System.out.println("Low: " + resultSet.getString("low"));
   }

} catch (SQLException ex) {
   System.out.println("Error searching records:" + ex.getMessage());
} 
}

//In this code we are creating a method to insert a record into our database using the executeUpdate() method.
//We use the PreparedStatement interface to prepare the query and set the parameter values.
//We then use the executeUpdate() method to execute the query and insert the record into the database.
public void insertRecord(String symbol, String currency, String open, String low) {

String query = "INSERT INTO oilandgas (symbol, currency, open, low) VALUES (?, ?, ?, ?)";

try {
   PreparedStatement statement = con.prepareStatement(query);
   statement.setString(1, symbol);
   statement.setString(2, currency);
   statement.setString(3, open);
   statement.setString(4, low);

   //Execute the query
   int rowsAffected = statement.executeUpdate();
   System.out.println("Rows affected: " + rowsAffected);

} catch (SQLException ex) {
   System.out.println("Error inserting records:" + ex.getMessage());

}
}
}