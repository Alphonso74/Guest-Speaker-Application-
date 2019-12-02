import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;

public class mainMenu extends JFrame
{


    //private JLabel SNameLabel, SJobLabel, SAffillLabel, DOVLabel, FacNameLabel, RoomNumLabel, CourseNameLabel;








    private JButton tablereportBtn, formBtn;

    private JPanel SpeakerAppPanel, SpeakerRequestPanel, buttonPanel, commentPanel;

    private ActionListener listener;
    private JPanel headerArea, picturePanel;
    private JLabel header, blankSpace, picture;


    public mainMenu()
    {
        super("Speaker Menu");

        setLayout(new GridLayout(4,1,1,1));
        listener = new ChoiceListener();

        headerArea = headerAreatop();

        add(headerArea);

        //ImageIcon image = new ImageIcon(this.getClass().getResource("/images/waveimage.jpg"));
        //picturePanel = picturePanel();

        //picture = new JLabel(image);

        //picture.setLayout(new GridLayout(5,4,0,1));
       // picture.setPreferredSize(new Dimension(20,20));
        //picture.setSize(50,50);
        //picture.setHorizontalAlignment(SwingConstants.CENTER);
        // add(image);
        //add(picture);

        //table = dataChatBottom();
        //add(picturePanel);


        buttonPanel = createbuttonPanel();

        add(buttonPanel);




        setSize(1440,900);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



    }

   /* public JPanel picturePanel(){

        ImageIcon image = new ImageIcon(this.getClass().getResource("/images/waveimage.jpg"));


        picture = new JLabel(image);

        //picture.setLayout(new GridLayout(5,4,0,1));
        // picture.setPreferredSize(new Dimension(20,20));
        picture.setPreferredSize(new Dimension(100,100));
        picture.setHorizontalAlignment(SwingConstants.CENTER);
        // add(image);
        //add(picture);

        return picturePanel();

    }*/


    public JPanel createbuttonPanel()
    {

        JPanel buttonPanel = new JPanel();

        tablereportBtn= new JButton("Speaker Report Table");
        formBtn = new JButton("Speaker Presentation Form");
        //enterBtn = new JButton("Add Data");

        tablereportBtn.addActionListener(listener);
        tablereportBtn.setPreferredSize(new Dimension(300,150));
        tablereportBtn.setVerticalAlignment(SwingConstants.CENTER);
        formBtn.addActionListener(listener);
        formBtn.setPreferredSize(new Dimension(300,150));
        formBtn.setVerticalAlignment(SwingConstants.CENTER);
        //enterBtn.addActionListener(listener);

        buttonPanel.setPreferredSize(new Dimension(700,450));
        buttonPanel.add(tablereportBtn);
        buttonPanel.add(formBtn);
        // buttonPanel.add(enterBtn);


        return buttonPanel;
    }

    public JPanel headerAreatop(){

        //header = new JLabel("REPORT",SwingConstants.CENTER);

        blankSpace = new JLabel("   ");
        header = new JLabel("Speaker Database: Main Menu");

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
        headerArea.setBorder(new BevelBorder(BevelBorder.LOWERED));
        //headerArea.add()

        headerArea.add(blankSpace);
        headerArea.add(header);




        return headerArea;

    }

   /* public JPanel createCommentPanel()
    {
        JPanel commentPanel = new JPanel();
        commentPanel.setBorder(BorderFactory.createTitledBorder("Additional Comments")); 	// sets border and title

        AddtionalCom = new JTextArea(6,50);
        commentPanel.add(AddtionalCom);
        AddtionalCom.setBackground(Color.LIGHT_GRAY);


        return commentPanel;
    }*/





    class ChoiceListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            Object source = event.getSource();
            if(event.getSource()== formBtn)
            {
                AppGUI p = new AppGUI();
                p.setSize(1440,700);
                p.show();

            }

            if(event.getSource()== tablereportBtn)
            {

                doggy f = new doggy();
                f.setSize(1440,700);
                f.show();

            }

        }

    }


    public static void main(String[] args)
    {

        mainMenu x = new mainMenu();

    }

}
