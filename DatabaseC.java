import java.sql.*;

import javax.swing.JOptionPane;

public class DatabaseC
{
    static final String DATABASE_URl = "jdbc:ucanaccess://V:/SemesterProjectDB.accdb";
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
    PreparedStatement insertNewEmployee = null;

    public DatabaseC()
    {
        try {
            connection = DriverManager.getConnection(DATABASE_URl);

            //establish connection to the database
            //Connection connection = DriverManager.getConnection("jdbc:ucanaccess:C://Users/user/Desktop/HumanResource.accdb");
            System.out.println("Made a connection");

            //create Statement for querying the database
            statement = connection.createStatement();
            System.out.println("Established statement");

            resultSet = statement.executeQuery("SELECT Full_Name, Job_Title, Affiliation, Date_of_Visit, Faculty_Name, Presentation_Location, Course_Name, Comments, Gift, Parking, Money, Returning FROM Speaker");

        } catch (SQLException sqlex)
        {
            JOptionPane.showMessageDialog(null, sqlex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }


    }




    public int addSpeaker (String DSName, String DSJob, String DSAffill, String DDOV, String DFacName, String DRoomNum, String DCourseName, String DComments, String DGift, String DParking, String DMoney, String DReturning)
    {

        int result = 0;
        try {
            insertNewEmployee = connection.prepareStatement("INSERT INTO Speaker(Full_Name, Job_Title, Affiliation, Date_of_Visit, Faculty_Name, Presentation_Location, Course_Name, Comments, Gift, Parking, Money, Returning) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);


            insertNewEmployee.setString(1, DSName);
            insertNewEmployee.setString(2, DSJob);
            insertNewEmployee.setString(3, DSAffill);
            insertNewEmployee.setString(4, DDOV);
            insertNewEmployee.setString(5, DFacName);
            insertNewEmployee.setString(6, DRoomNum);
            insertNewEmployee.setString(7, DCourseName);
            insertNewEmployee.setString(8, DComments);
            insertNewEmployee.setString(9, DGift);
            insertNewEmployee.setString(10, DParking);
            insertNewEmployee.setString(11, DMoney);
            insertNewEmployee.setString(12, DReturning);


            result = insertNewEmployee.executeUpdate();

            if (result == 1) {
                JOptionPane.showMessageDialog(null, "Record Insert Completed", DSName, JOptionPane.INFORMATION_MESSAGE);
            } else if (result == 0) {
                JOptionPane.showMessageDialog(null, "Record Insert Failed", DSName, JOptionPane.INFORMATION_MESSAGE);

            }
        } catch (SQLException sqlex) {
            JOptionPane.showMessageDialog(null, sqlex.getMessage(), "Database Insert Failed", JOptionPane.ERROR_MESSAGE);
            result = 0;
        }

        return result;
    }

/*	public static void main(String[] args)
	{
		SimpleDatabase x = new SimpleDatabase();
	}
*/
}
