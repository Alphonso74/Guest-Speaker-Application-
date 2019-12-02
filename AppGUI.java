
import javax.mail.Transport;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Vector;
import javax.swing.*;
import java.sql.*;

public class AppGUI extends JFrame
{


    private JLabel SNameLabel, SJobLabel, SAffillLabel, DOVLabel, FacNameLabel, RoomNumLabel, CourseNameLabel;

    private JTextField SNameTxt, SJobTxt, SAffillTxt, DOVTxt, FacNameTxt, RoomNumTxt, CourseNameTxt;

    private String DID, SName, SJob, SAffill, DOV, FacName, RoomNum, CourseName, Comments;

    private String DGift = "No";
    private String DParking = "No";
    private String DMoney = "No";
    private String DReturning = "No";

    private JTextArea AddtionalCom;

    private JCheckBox SmallGift, ParkingPermit, Money, Returning;

    private JButton clearBtn, reportBtn, enterBtn;

    private JPanel SpeakerAppPanel, SpeakerRequestPanel, buttonPanel, commentPanel;

    private ActionListener listener;

    Object[] row = new Object[11];


    private DatabaseC DB = new DatabaseC();

    public AppGUI()
    {
        super("Speaker Application");

        setLayout(new GridLayout(5,1,1,1));
        listener = new ChoiceListener();


        SpeakerAppPanel = createSpeakerAppPanel();
        SpeakerRequestPanel = createSpeakerRequestPanel();
        buttonPanel = createbuttonPanel();
        commentPanel = createCommentPanel();

        add(SpeakerAppPanel);
        add(commentPanel);
        add(SpeakerRequestPanel);
        add(buttonPanel);


        setSize(700,700);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



    }


    public JPanel createSpeakerAppPanel()
    {

        SNameLabel = new JLabel("Speaker's Full Name", SwingConstants.RIGHT);
        SNameTxt = new JTextField(25);
        SNameTxt.setToolTipText("Enter Speaker's Full Name");

        SJobLabel = new JLabel("Speaker's Job Title", SwingConstants.RIGHT);
        SJobTxt = new JTextField(25);
        SJobTxt.setToolTipText("Enter Speaker's Job Title");

        SAffillLabel = new JLabel("Speaker's Affiliation", SwingConstants.RIGHT);
        SAffillTxt = new JTextField(25);
        SAffillTxt.setToolTipText("Enter Speaker's Affiliation");

        DOVLabel = new JLabel("Speaker's Date of Visit (Ex. MM-DD-YY)", SwingConstants.RIGHT);
        DOVTxt = new JTextField(25);
        DOVTxt.setToolTipText("Enter Date of Visit");

        FacNameLabel = new JLabel("Faculty's Name", SwingConstants.RIGHT);
        FacNameTxt = new JTextField(25);
        FacNameTxt.setToolTipText("Enter Faculty's Full Name");

        RoomNumLabel = new JLabel("Presentation Location (Ex. E334)", SwingConstants.RIGHT);
        RoomNumTxt = new JTextField(25);
        RoomNumTxt.setToolTipText("Enter Room Location");

        CourseNameLabel = new JLabel("Course Name (Ex. IST 311)", SwingConstants.RIGHT);
        CourseNameTxt = new JTextField(25);
        CourseNameTxt.setToolTipText("Enter Course Name");


        JPanel SpeakerAppPanel = new JPanel();

        SpeakerAppPanel.setLayout(new GridLayout (7,2,1,1));
        SpeakerAppPanel.setBorder(BorderFactory.createTitledBorder("Enter Guest Speaker Information"));


        SpeakerAppPanel.add(SNameLabel);
        SpeakerAppPanel.add(SNameTxt);
        SpeakerAppPanel.add(SJobLabel);
        SpeakerAppPanel.add(SJobTxt);
        SpeakerAppPanel.add(SAffillLabel);
        SpeakerAppPanel.add(SAffillTxt);
        SpeakerAppPanel.add(DOVLabel);
        SpeakerAppPanel.add(DOVTxt);
        SpeakerAppPanel.add(FacNameLabel);
        SpeakerAppPanel.add(FacNameTxt);
        SpeakerAppPanel.add(RoomNumLabel);
        SpeakerAppPanel.add(RoomNumTxt);
        SpeakerAppPanel.add(CourseNameLabel);
        SpeakerAppPanel.add(CourseNameTxt);

        return SpeakerAppPanel;
    }

    public JPanel createSpeakerRequestPanel()
    {
        JPanel SpeakerRequestPanel = new JPanel();
        SpeakerRequestPanel.setLayout(new GridLayout (4,1,1,1));
        SpeakerRequestPanel.setBorder(BorderFactory.createTitledBorder("Faculty's Requests"));

        SmallGift = new JCheckBox("Small Gift");


        ParkingPermit = new JCheckBox("Temporary Parking Permit");


        Money = new JCheckBox("Reimbursements (Gas, Hotel, Etc.)");


        Returning = new JCheckBox("Has the speaker been here before?");



        SmallGift.addActionListener(listener);
        ParkingPermit.addActionListener(listener);
        Money.addActionListener(listener);
        Returning.addActionListener(listener);


        SpeakerRequestPanel.add(SmallGift);
        SpeakerRequestPanel.add(ParkingPermit);
        SpeakerRequestPanel.add(Money);
        SpeakerRequestPanel.add(Returning);

        add(SpeakerRequestPanel, BorderLayout.LINE_START);

        SmallGift.setSelected(false);
        ParkingPermit.setSelected(false);
        Money.setSelected(false);
        Returning.setSelected(false);


        return SpeakerRequestPanel;
    }

    public JPanel createbuttonPanel()
    {

        JPanel buttonPanel = new JPanel();

        clearBtn = new JButton("Clear");
        reportBtn = new JButton("Report");
        enterBtn = new JButton("Enter");

        clearBtn.addActionListener(listener);
        reportBtn.addActionListener(listener);
        enterBtn.addActionListener(listener);

        buttonPanel.add(clearBtn);
        buttonPanel.add(reportBtn);
        buttonPanel.add(enterBtn);


        return buttonPanel;
    }

    public JPanel createCommentPanel()
    {
        JPanel commentPanel = new JPanel();
        commentPanel.setBorder(BorderFactory.createTitledBorder("Additional Comments")); 	// sets border and title

        AddtionalCom = new JTextArea(6,50);
        commentPanel.add(AddtionalCom);
        AddtionalCom.setBackground(Color.LIGHT_GRAY);


        return commentPanel;
    }





    class ChoiceListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            Object source = event.getSource();
            if (source instanceof JCheckBox)
            {
                //String dGift = "No";
                if (SmallGift.isSelected())
                {
                    DGift = "Yes";
                    System.out.println("gift is selected");
                }
                if (ParkingPermit.isSelected())
                {
                    DParking = "Yes";
                    System.out.println("parking pass is selected");
                }
                if (Money.isSelected())
                {
                    DMoney = "Yes";
                    System.out.println("money is selected");
                }
                if (Returning.isSelected())
                {
                    DReturning = "Yes";
                    System.out.println("Speaker has returned");
                }

            }

            if (source instanceof JButton)
            {

                int result = 0;
                if (event.getSource() == enterBtn) {

                    SendEmail sendEmail = new SendEmail();
                    //Transport.send(sendEmail);


                    SName = SNameTxt.getText();
                    SJob = SJobTxt.getText();
                    SAffill = SAffillTxt.getText();
                    DOV = DOVTxt.getText();
                    FacName = FacNameTxt.getText();
                    RoomNum = RoomNumTxt.getText();
                    CourseName = CourseNameTxt.getText();
                    Comments = AddtionalCom.getText();

                    doggy table = new doggy();
                    table.model.insertRow(0, new Object[]{SName, SJob, SAffill, DOV, FacName, RoomNum, CourseName, Comments});

                    // table.setSize(1440,700);
                    // table.show();
                    table.setSize(1440,700);
                    table.show();

                    result = DB.addSpeaker(SName, SJob, SAffill, DOV, FacName, RoomNum, CourseName, Comments, DGift, DParking, DMoney, DReturning);





                    //addSpeaker();
                }


                if(event.getSource()== reportBtn)
                {

                    SName = SNameTxt.getText();
                    SJob = SJobTxt.getText();
                    SAffill = SAffillTxt.getText();
                    DOV = DOVTxt.getText();
                    FacName = FacNameTxt.getText();
                    RoomNum = RoomNumTxt.getText();
                    CourseName = CourseNameTxt.getText();
                    Comments = AddtionalCom.getText();

                    doggy table = new doggy();
                    table.model.insertRow(0, new Object[]{SName, SJob, SAffill, DOV, FacName, RoomNum, CourseName, Comments});
                    table.setSize(1440,700);
                    table.show();

                    //doggy d = new doggy();
                   // d.setSize(1440,700);
                    //d.show();
                    System.out.println("Report Button Works");
                }

                if(event.getSource()== clearBtn)
                {
                    SNameTxt.setText("");
                    SJobTxt.setText("");
                    SAffillTxt.setText("");
                    DOVTxt.setText("");
                    FacNameTxt.setText("");
                    RoomNumTxt.setText("");
                    CourseNameTxt.setText("");
                    System.out.println("Clear Button Works");
                    AddtionalCom.setText("");
                    SmallGift.setSelected(false);
                    ParkingPermit.setSelected(false);
                    Money.setSelected(false);
                    Returning.setSelected(false);
                }

            }



        }
    }

    public static void main(String[] args)
    {

        AppGUI x = new AppGUI();

    }

}
