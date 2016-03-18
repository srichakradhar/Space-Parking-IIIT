import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;
public class Exit_UI extends JFrame {
  private static final long serialVersionUID = 1L;
private JPanel contentPane;
JTextField textField_1;
JTextArea txtrIdSParking;

// Launch the application.

public static void main(String[] args) {
EventQueue.invokeLater(new Runnable() {
public void run() {
try {
Exit_UI frame = new Exit_UI();
frame.setVisible(true);
} catch (Exception e) {
e.printStackTrace();
}
}
});
}

// Create the frame.
public Exit_UI() {
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setBounds(900, 400, 450, 300);
contentPane = new JPanel();
contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
setContentPane(contentPane);
contentPane.setLayout(new BorderLayout(0, 0));
JPanel panel = new JPanel();
contentPane.add(panel, BorderLayout.NORTH);
JLabel lblThankYou = new JLabel("Thank you!");
panel.add(lblThankYou);
lblThankYou.setFont(new Font("Times New Roman", Font.PLAIN, 28));
JPanel panel_1 = new JPanel();
contentPane.add(panel_1, BorderLayout.SOUTH);
JLabel lblPleaseScanThe = new JLabel("Please scan the card or insert the ticket.");
panel_1.add(lblPleaseScanThe);
lblPleaseScanThe.setFont(new Font("Times New Roman", Font.PLAIN,
17));
JPanel panel_2 = new JPanel();
contentPane.add(panel_2, BorderLayout.EAST);
panel_2.setLayout(new GridLayout(5, 1, 10, 3));
JPanel panel_3 = new JPanel();
panel_2.add(panel_3);
panel_3.setLayout(new GridLayout(4, 1, 0, 0));
JPanel panel_4 = new JPanel();
panel_2.add(panel_4);
JLabel lblInsertTicket = new JLabel("Insert Ticket");
panel_4.add(lblInsertTicket);
textField_1 = new JTextField();
textField_1.setHorizontalAlignment(SwingConstants.CENTER);
textField_1.setBackground(Color.BLACK);
textField_1.setForeground(Color.WHITE);
panel_2.add(textField_1);
textField_1.setColumns(10);
JPanel panel_5 = new JPanel();
contentPane.add(panel_5, BorderLayout.CENTER);
panel_5.setLayout(new BorderLayout(10, 10));
JPanel panel_6 = new JPanel();
panel_5.add(panel_6, BorderLayout.SOUTH);
JPanel panel_7 = new JPanel();
panel_5.add(panel_7, BorderLayout.WEST);
JPanel panel_8 = new JPanel();
panel_5.add(panel_8, BorderLayout.NORTH);
JPanel panel_9 = new JPanel();
panel_5.add(panel_9, BorderLayout.EAST);
txtrIdSParking = new JTextArea();
txtrIdSParking.setText("Welcome to our car park!\nHere is the exit.");
txtrIdSParking.setEditable(false);
panel_5.add(txtrIdSParking, BorderLayout.CENTER);
}
} 