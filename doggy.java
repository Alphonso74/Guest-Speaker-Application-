//public class doggy {
//}

import com.sun.tools.javac.comp.Flow;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JPanel;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import javax.swing.JScrollBar;
import javax.swing.border.BevelBorder;

import static javax.swing.SwingConstants.SOUTH;

public class doggy extends JFrame {

    private JLabel header, blankSpace;
    private JPanel headerArea, buttonPanel;
    private JButton nextButton;
    private ActionListener listener;


    //JPanel header;

    //Object[] columns = {"Date", "FacultName", "CourseName", "Location" , "SpeakersName", "JobTitle", "Affiliation", "Gift?", "Permit?", "Reimbursemnt?", "Comments"};
    DefaultTableModel model = new DefaultTableModel();


    Container cnt = this.getContentPane();

    public static void main(String[] args) {
        final JFrame frame = new doggy();
        frame.setTitle("Speaker Database");
        frame.setBackground(Color.lightGray);
        frame.setSize(1440, 700);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setResizable(true);
        //frame.

        //frame.setUndecorated(true);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();

        /*JLabel nameLabel = new JLabel("REPORT");
        JPanel nameLabelPanel = new JPanel();
        nameLabelPanel.setPreferredSize(new Dimension(100, 25));
        JPanel.add(nameLabel);
        frame.add(nameLabelPanel);
        */

    }
    JTable table = new JTable(model);

    public JPanel headerAreatop(){

        //header = new JLabel("REPORT",SwingConstants.CENTER);

        blankSpace = new JLabel("   ");
        header = new JLabel("REPORT: SPEAKERS");

        blankSpace.setHorizontalAlignment(SwingConstants.CENTER);
        blankSpace.setVerticalAlignment(SwingConstants.CENTER);
        blankSpace.setVerticalTextPosition(SwingConstants.CENTER);
        blankSpace.setHorizontalTextPosition(SwingConstants.CENTER);
        blankSpace.setForeground(Color.blue);
        blankSpace.setFont(new Font("Impact", Font.BOLD, 32));
        blankSpace.setPreferredSize(new Dimension(100,30));


        header.setHorizontalAlignment(SwingConstants.CENTER);
        header.setVerticalAlignment(SwingConstants.CENTER);
        //header.set
        //header.setVerticalAlignment(b.SOUTH);
        header.setVerticalTextPosition(SwingConstants.CENTER);
        header.setHorizontalTextPosition(SwingConstants.CENTER);
        header.setForeground(Color.blue);
        header.setFont(new Font("Algerian", Font.BOLD, 32));
        header.setPreferredSize(new Dimension(100,30));

        JPanel headerArea = new JPanel();
        headerArea.setLayout(new GridLayout(3,4,0,1));
        headerArea.setPreferredSize(new Dimension(1000,100));
        headerArea.setBorder(new BevelBorder(BevelBorder.RAISED));
        //headerArea.add()

        headerArea.add(blankSpace);
        headerArea.add(header);




        return headerArea;

    }

    public JPanel createButtonPanel()
    {
        JPanel buttonPanel = new JPanel();

        nextButton = new JButton("NEXT");
        nextButton.setFont(new Font("Impact",Font.BOLD,24));
        nextButton.addActionListener(listener);
        nextButton.setPreferredSize(new Dimension(40,15));
        buttonPanel.add(nextButton);

        return buttonPanel;
    }



    public doggy() {
        //Label header = new Label("REPORT",Label.CENTER);
        // table.add(header,BorderLayout.NORTH);

        JPanel headertop = new JPanel();
        headerArea = headerAreatop();


        //table = dataChatBottom();

        add(headerArea);
        //add(table);


        cnt.setLayout(new FlowLayout(FlowLayout.CENTER));
        cnt.setLayout((new FlowLayout()));
        model.addColumn("Date of Visit");
        model.addColumn("Faculty's Name");
        model.addColumn("Course Name");
        model.addColumn("Presentation Location");
        model.addColumn("Speakers Name");
        model.addColumn("Speakers Job Title");
        model.addColumn("Speaker's Affiliation");
        // model.addColumn("Revisit?");
        //model.addColumn("Gift?");
       // model.addColumn("Parking Permit?");
        //model.addColumn("Reimbursement");
        model.addColumn("Additional Comments");


        //model.setColumnIdentifiers(columns);
        table.setModel(model);


        /*JScrollPane scroll = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
*/
        /*JPanel columnHeader = new JPanel() {
            @Override
            public Dimension getPreferredSize() {
                JScrollBar sb = new JScrollBar(JScrollBar.VERTICAL);
                return new Dimension(sb.getPreferredSize().width, 10);
            }
        };*/


        /*try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/java_db", "root", "");
            PreparedStatement pstm = con.prepareStatement("SELECT * FROM users");
            ResultSet Rs = pstm.executeQuery();
            while(Rs.next()){
                model.addRow(new Object[]{Rs.getInt(1), Rs.getString(2),Rs.getString(3),Rs.getString(4)});
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }*/

        //buttonPanel = createButtonPanel();
        //add(buttonPanel);



        JScrollPane pg = new JScrollPane(table);
        // pg.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        //pg.setVerticalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        //cnt.add(pg);

        //pg.add(table);
        table.setEnabled(false);
        pg.setPreferredSize(new Dimension(1440,400));
        table.getTableHeader().setReorderingAllowed(false);
        table.setBackground(Color.LIGHT_GRAY);
        table.setForeground(Color.black);
        table.setRowHeight(30);
        table.getTableHeader().setResizingAllowed(false);
        table.setBorder(new BevelBorder(BevelBorder.RAISED));
        //table.getconten
        cnt.add(pg);
        //this.pack();




    }
}