/**
* @author Srichakradhar
*
*/
import java.util.ArrayList;
import java.util.Date;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import javax.swing.border.EmptyBorder;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
public class Operator_UI extends JFrame {

private static final long serialVersionUID = 1L;
Car_Park park;
private JPanel contentPane;
private JTextField textField;
private JPasswordField passwordField;
private JPanel panel_1_0;
private JPanel panel_1_5;
private JPanel panel_1_1;
private JPanel panel_1_3;
private JPanel panel_1_4;
private JPanel panel_1_2;
private JButton btnLogin;
int ID1 = 1;
int PW1 = 1;
public String ID;
static choose frame0;
/**
* Launch the application.
*/
public static void main(String[] args) {
EventQueue.invokeLater(new Runnable() {
public void run() {
try {
Operator_UI frame = new Operator_UI();
frame.setVisible(true);
} catch (Exception e) {
e.printStackTrace();
}
}
});
}
/**
* Create the frame.
*/
public Operator_UI() {
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setBounds(450, 100, 450, 300);
contentPane = new JPanel();
setContentPane(contentPane);
contentPane.setLayout(new GridLayout(6, 1, 0, 0));
panel_1_0 = new JPanel();
contentPane.add(panel_1_0);
panel_1_1 = new JPanel();
contentPane.add(panel_1_1);
panel_1_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
JLabel lblCarParkSystem = new JLabel("Car Park Control System");
panel_1_1.add(lblCarParkSystem);
lblCarParkSystem.setFont(new Font("Times New Roman", Font.PLAIN, 28));
panel_1_2 = new JPanel();
contentPane.add(panel_1_2);
panel_1_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
JLabel lblId = new JLabel(" ID:");
panel_1_2.add(lblId);
lblId.setHorizontalAlignment(SwingConstants.RIGHT);
lblId.setFont(new Font("Times New Roman", Font.PLAIN, 20));
textField = new JTextField();
panel_1_2.add(textField);
textField.setHorizontalAlignment(SwingConstants.LEFT);
textField.setColumns(10);
panel_1_3 = new JPanel();
contentPane.add(panel_1_3);
JLabel lblPassword = new JLabel("Password:");
panel_1_3.add(lblPassword);
lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 20));
passwordField = new JPasswordField();
panel_1_3.add(passwordField);
passwordField.setColumns(10);
passwordField.setHorizontalAlignment(SwingConstants.LEFT);
panel_1_4 = new JPanel();
contentPane.add(panel_1_4);
btnLogin = new JButton("Login");
panel_1_4.add(btnLogin);
panel_1_5 = new JPanel();
contentPane.add(panel_1_5);
login();
}
public void login(){
  btnLogin.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
ID = textField.getText();
choose.ID=ID;
RegisterNewCar.ID=ID;
RegisterNewCar_1.ID=ID;
ModifyParkInfo.ID=ID;
char[] PW = passwordField.getPassword();
String Password = new String(PW);
try {
FileReader fr=new FileReader("OperatorList.txt");
BufferedReader br=new BufferedReader(fr);
String num=br.readLine();
int numOfOP=Integer.parseInt(num);
while(numOfOP!=0){
String line1=br.readLine();
String line2=br.readLine();
System.out.println("line1 "+line1);
System.out.println("line2 "+line2);
System.out.println("ID "+ID);
System.out.println("Password "+Password);
if(ID.equals(line1) && Password.equals(line2)){
ID1 = 1;
PW1 = 1;
break;
}
else{
ID1 = 0;
PW1 = 0;
}
numOfOP--;
}
if((ID1 == 1) && (PW1 == 1)){
setVisible(false);
frame0=new choose();
frame0.setVisible(true);
frame0.lblOperator.setText("Operator: "+ID);
}
else{
JOptionPane.showMessageDialog(null, "Sorry, you entered a wrong ID or Password.", "SORRY", JOptionPane.ERROR_MESSAGE);
                                }
} catch (FileNotFoundException e1) {
// TODO Auto-generated catch block
e1.printStackTrace();
} catch (IOException e2) {
// TODO Auto-generated catch block
e2.printStackTrace();
}
}
});
}
}
class choose extends JFrame {
/**
*
*/
private static final long serialVersionUID = 1L;
private JPanel contentPane1;
RegisterNewCar_1 frame1;
ModifyParkInfo initial;
JLabel lblOperator;
Date today;
static String ID;
static int addTicket=0;
/**
* Launch the application.
*/
/**
 * * Create the frame.
*/
public choose() {
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setBounds(450, 100, 450, 300);
contentPane1 = new JPanel();
contentPane1.setBorder(new EmptyBorder(5, 5, 5, 5));
setContentPane(contentPane1);
contentPane1.setLayout(new GridLayout(5, 0, 0, 0));
JPanel panel_4 = new JPanel();
FlowLayout fl_panel_4 = (FlowLayout) panel_4.getLayout();
fl_panel_4.setAlignment(FlowLayout.LEFT);
contentPane1.add(panel_4);
lblOperator = new JLabel("Operator:");
lblOperator.setHorizontalAlignment(SwingConstants.CENTER);
panel_4.add(lblOperator);
JPanel panel_3 = new JPanel();
contentPane1.add(panel_3);
JLabel label = new JLabel("Car Park Control System");
label.setFont(new Font("Times New Roman", Font.PLAIN, 28));
panel_3.add(label);
JPanel panel_2 = new JPanel();
contentPane1.add(panel_2);
JButton btnRegisterNewCar = new JButton("Register New Car");
panel_2.add(btnRegisterNewCar);
btnRegisterNewCar.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
setVisible(false);
frame1=new RegisterNewCar_1();
frame1.setVisible(true);
}
});
JPanel panel_1 = new JPanel();
contentPane1.add(panel_1);
JButton btnModify = new JButton("Modify Park Info");
panel_1.add(btnModify);
btnModify.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
setVisible(false);
initial=new ModifyParkInfo();
initial.setVisible(true);
}
});
JPanel panel = new JPanel();
FlowLayout flowLayout = (FlowLayout) panel.getLayout();
flowLayout.setAlignment(FlowLayout.RIGHT);
contentPane1.add(panel);
JButton btnLogout = new JButton("Logout");
panel.add(btnLogout);
btnLogout.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
setVisible(false);
new Operator_UI().setVisible(true);
}
});
}
}
class RegisterNewCar extends JFrame {
/**
*
*/
private static final long serialVersionUID = 1L;
private JPanel contentPane;
public JLabel lblIdXxxxxxxx;
public JLabel lblNameXxxxx;
public JLabel lblEmailXxxxxxxxxcom;
public static String ID;
String registerInput;
JButton btnRegister;
int flag;//indicate whether it is registered.
//If it already register,set flag=1.if not,flag=0
/**
* Launch the application.
*/
public void run() {
try {
RegisterNewCar frame = new RegisterNewCar();
frame.setVisible(false);
} catch (Exception e) {
e.printStackTrace();
}
}
/**
* Create the frame.
*/
public RegisterNewCar() {
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setBounds(450, 100, 450, 300);
contentPane = new JPanel();
contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
setContentPane(contentPane);
contentPane.setLayout(new BorderLayout(0, 0));
JPanel panel = new JPanel();
contentPane.add(panel, BorderLayout.EAST);
panel.setLayout(new GridLayout(6, 1, 0, 0));
JPanel panel_2 = new JPanel();
panel.add(panel_2);
JButton btnHome = new JButton(" Home ");
panel_2.add(btnHome);
btnHome.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
setVisible(false);
choose frame0=new choose();
frame0.setVisible(true);
frame0.lblOperator.setText("Operator: "+ID);
}
});
JPanel panel_3 = new JPanel();
panel.add(panel_3);
JButton btnModifyParkInfo = new JButton("Modify Park Info");
panel_3.add(btnModifyParkInfo);
btnModifyParkInfo.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
setVisible(false);
new ModifyParkInfo().setVisible(true);
}
});
JPanel panel_4 = new JPanel();
panel.add(panel_4);
JPanel panel_5 = new JPanel();
panel.add(panel_5);
JPanel panel_6 = new JPanel();
panel.add(panel_6);
JPanel panel_7 = new JPanel();
FlowLayout flowLayout = (FlowLayout) panel_7.getLayout();
flowLayout.setAlignment(FlowLayout.RIGHT);
panel.add(panel_7);
JButton btnLogout = new JButton("Logout");
panel_7.add(btnLogout);
btnLogout.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
setVisible(false);
new Operator_UI().setVisible(true);
}
});
JPanel panel_1 = new JPanel();
contentPane.add(panel_1, BorderLayout.CENTER);
panel_1.setLayout(new GridLayout(0, 1, 0, 0));
JPanel panel_8 = new JPanel();
panel_1.add(panel_8);
JPanel panel_9 = new JPanel();
panel_1.add(panel_9);
JLabel lblRegisterNewCar = new JLabel("Register New Car");
panel_9.add(lblRegisterNewCar);
lblRegisterNewCar.setFont(new Font("Times New Roman",
Font.PLAIN, 28));
JPanel panel_10 = new JPanel();
panel_1.add(panel_10);
panel_10.setLayout(new GridLayout(0, 1, 0, 0));
JPanel panel_12 = new JPanel();
panel_10.add(panel_12);
lblIdXxxxxxxx = new JLabel("There is no such a ID number.");
panel_12.add(lblIdXxxxxxxx);
JPanel panel_13 = new JPanel();
panel_10.add(panel_13);
lblNameXxxxx = new JLabel("Name: XXXXX");
panel_13.add(lblNameXxxxx);
JPanel panel_14 = new JPanel();
panel_10.add(panel_14);
lblEmailXxxxxxxxxcom = new JLabel("Email:XXXXXX@XXX.com");
panel_14.add(lblEmailXxxxxxxxxcom);
JPanel panel_11 = new JPanel();
panel_1.add(panel_11);
btnRegister = new JButton("Register");
panel_11.add(btnRegister);
register();
}
public void register(){
btnRegister.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
  setVisible(false);
check();
new RegisterNewCar_1().setVisible(true);
}
});
}
public void check(){
registerInput=lblIdXxxxxxxx.getText();
if( registerInput.equals("There is no such a ID number."))
{
JOptionPane.showMessageDialog(null, "You can't register since you are not a QM staff.",
                              "FAILURE", JOptionPane.ERROR_MESSAGE);
}
else{
try{
FileReader fr=new FileReader("registerlist.txt");
BufferedReader br=new BufferedReader(fr);
String line=br.readLine();
flag=0;
while (line!=null)
{
if (line.equals(registerInput))
{
JOptionPane.showMessageDialog(null, "You can't register again since you have registered",
                              "FAILURE", JOptionPane.ERROR_MESSAGE);
flag=1;
break;
}
line=br.readLine();
}
br.close();
fr.close();
if (flag==0){
FileWriter fw=new FileWriter("registerlist.txt",true);
BufferedWriter bw=new BufferedWriter(fw);
bw.write(registerInput);
bw.newLine();
bw.flush();
fw.close();
JOptionPane.showMessageDialog(null, "Congratuation! You are registered in the car park successfully!",
                              "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
}
}
catch(IOException ev)
{
System.out.println("Cannot find the file.");
}
}
}
}
class RegisterNewCar_1 extends JFrame {
/**
*
*/
private static final long serialVersionUID = 1L;
private JPanel contentPane;
public JTextField textField;
public static String ID;
JButton btnSearch;
RegisterNewCar frame2;
String searchInput;
public RegisterNewCar_1 frame;
/**
* Launch the application.
*/
public void run() {
try {
frame = new RegisterNewCar_1();
frame.setVisible(true);
} catch (Exception e) {
e.printStackTrace();
}
}
/**
* Create the frame.
*/
public RegisterNewCar_1() {
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setBounds(450, 100, 450, 300);
contentPane = new JPanel();
contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
setContentPane(contentPane);
contentPane.setLayout(new BorderLayout(0, 0));
JPanel panel = new JPanel();
contentPane.add(panel, BorderLayout.EAST);
panel.setLayout(new GridLayout(6, 1, 0, 0));
JPanel panel_2 = new JPanel();
panel.add(panel_2);
JButton btnHome = new JButton(" Home ");
panel_2.add(btnHome);
btnHome.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
setVisible(false);
choose frame0=new choose();
frame0.setVisible(true);
frame0.lblOperator.setText("Operator: "+ID);
}
});
JPanel panel_3 = new JPanel();
panel.add(panel_3);
JButton btnModifyParkInfo = new JButton("Modify Park Info");
panel_3.add(btnModifyParkInfo);
btnModifyParkInfo.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
setVisible(false);
new ModifyParkInfo().setVisible(true);
}
});
JPanel panel_4 = new JPanel();
panel.add(panel_4);
JPanel panel_5 = new JPanel();
panel.add(panel_5);
JPanel panel_6 = new JPanel();
panel.add(panel_6);
JPanel panel_7 = new JPanel();
FlowLayout flowLayout = (FlowLayout) panel_7.getLayout();
flowLayout.setAlignment(FlowLayout.RIGHT);
panel.add(panel_7);
JButton btnLogout = new JButton("Logout");
panel_7.add(btnLogout);
btnLogout.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
setVisible(false);
new Operator_UI().setVisible(true);
}
});
JPanel panel_1 = new JPanel();
contentPane.add(panel_1, BorderLayout.CENTER);
panel_1.setLayout(new GridLayout(0, 1, 0, 0));
JPanel panel_8 = new JPanel();
panel_1.add(panel_8);
JPanel panel_9 = new JPanel();
panel_1.add(panel_9);
JLabel lblRegisterNewCar = new JLabel("Register New Car");
panel_9.add(lblRegisterNewCar);
lblRegisterNewCar.setFont(new Font("Times New Roman",
Font.PLAIN, 28));
JPanel panel_10 = new JPanel();
panel_1.add(panel_10);
JLabel lblId = new JLabel("ID:");
lblId.setFont(new Font("SimSun-ExtB", Font.PLAIN, 18));
panel_10.add(lblId);
textField = new JTextField();
panel_10.add(textField);
textField.setColumns(10);
JPanel panel_11 = new JPanel();
panel_1.add(panel_11);
btnSearch = new JButton("Search");
panel_11.add(btnSearch);
search();
}
public void search(){
btnSearch.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
setVisible(false);
frame2=new RegisterNewCar();
frame2.setVisible(true);
searchInput=textField.getText();
try{
FileReader fr=new FileReader("StaffDB.txt");
BufferedReader br=new BufferedReader(fr);
String num=br.readLine();
int numOfOP=Integer.parseInt(num);
while(numOfOP!=0)
{
String line=br.readLine();
String line1=br.readLine();
String line2=br.readLine();
if (line.equals(searchInput)){
frame2.lblIdXxxxxxxx.setText("ID: "+searchInput);
 frame2.lblNameXxxxx.setText("Name: "+line1);
 frame2.lblEmailXxxxxxxxxcom.setText("Email: "+line2);
 break;
}
}
br.close();
fr.close();}
catch(IOException ev)
  {
System.out.println("Cannot find the file.");
}
}
});
}
}
class ModifyParkInfo extends JFrame {
/**
*
*/
private static final long serialVersionUID = 1L;
public JPanel contentPane;
public JTextPane textField; //Park Sets
public JTextPane textField_1; //0-2
public JTextPane textField_2; //2-4
public JTextPane textField_3; //4-8
public JTextPane textField_4; //Y1
public JTextPane textField_5; //M1
public JTextPane textField_6; //D1
public JTextPane textField_7; //Y2
public JTextPane textField_8; //M2
public JTextPane textField_9; //D2
public JTextPane textField_10; //8-12
public JTextPane textField_11; //12-24
public static String ID;
JButton btnUpdate;
ArrayList<String> store;
FileWriter fw;
BufferedWriter bw;
/**
* Launch the application.
*/
public void run() {
  try {
ModifyParkInfo frame = new ModifyParkInfo();
frame.setVisible(true);
} catch (Exception e) {
e.printStackTrace();
}
}
/**
* Create the frame.
*/
public ModifyParkInfo() {
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setBounds(450, 100, 450, 300);
contentPane = new JPanel();
contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
contentPane.setLayout(new BorderLayout(0, 0));
setContentPane(contentPane);
JPanel panel = new JPanel();
contentPane.add(panel, BorderLayout.EAST);
panel.setLayout(new GridLayout(6, 1, 0, 0));
JPanel panel_3 = new JPanel();
panel.add(panel_3);
JButton button = new JButton(" Home ");
panel_3.add(button);
button.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
setVisible(false);
choose frame0=new choose();
frame0.setVisible(true);
frame0.lblOperator.setText("Operator: "+ID);
}
});
JPanel panel_4 = new JPanel();
panel.add(panel_4);
JButton btnRegisterNewCar = new JButton("Register New Car");
panel_4.add(btnRegisterNewCar);
btnRegisterNewCar.addActionListener(new ActionListener() {
  public void actionPerformed(ActionEvent e) {
setVisible(false);
new RegisterNewCar_1().setVisible(true);
}
});
JPanel panel_5 = new JPanel();
panel.add(panel_5);
JPanel panel_6 = new JPanel();
panel.add(panel_6);
JPanel panel_7 = new JPanel();
panel.add(panel_7);
JPanel panel_8 = new JPanel();
FlowLayout flowLayout = (FlowLayout) panel_8.getLayout();
flowLayout.setAlignment(FlowLayout.RIGHT);
panel.add(panel_8);
JButton button_2 = new JButton("Logout");
panel_8.add(button_2);
button_2.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
setVisible(false);
new Operator_UI().setVisible(true);
}
});
JPanel panel_1 = new JPanel();
contentPane.add(panel_1, BorderLayout.CENTER);
panel_1.setLayout(new GridLayout(0, 1, 0, 0));
JPanel panel_2 = new JPanel();
panel_1.add(panel_2);
JPanel panel_9 = new JPanel();
panel_1.add(panel_9);
JLabel lblModifyParkInfo = new JLabel("Modify Park Info");
lblModifyParkInfo.setFont(new Font("Times New Roman", Font.PLAIN,
28));
panel_9.add(lblModifyParkInfo);
JPanel panel_10 = new JPanel();
panel_1.add(panel_10);
panel_10.setLayout(new GridLayout(0, 2, 0, 0));
JPanel panel_14 = new JPanel();
panel_10.add(panel_14);
JLabel lblParkSets = new JLabel("Park Sets:");
panel_14.add(lblParkSets);
textField = new JTextPane();
panel_14.add(textField);
JPanel panel_15 = new JPanel();
panel_10.add(panel_15);
panel_15.setLayout(new GridLayout(2, 0, 0, 0));
JPanel panel_16 = new JPanel();
FlowLayout flowLayout_1 = (FlowLayout) panel_16.getLayout();
flowLayout_1.setAlignment(FlowLayout.LEFT);
panel_15.add(panel_16);
JLabel lblTarrif = new JLabel("Tariffs:");
lblTarrif.setVerticalAlignment(SwingConstants.TOP);
lblTarrif.setHorizontalAlignment(SwingConstants.LEFT);
panel_16.add(lblTarrif);
JPanel panel_17 = new JPanel();
FlowLayout flowLayout_2 = (FlowLayout) panel_17.getLayout();
flowLayout_2.setVgap(0);
flowLayout_2.setHgap(0);
flowLayout_2.setAlignment(FlowLayout.LEFT);
panel_15.add(panel_17);
JLabel lblHours = new JLabel(" 0 to 2 Hours - \u00A3 ");
panel_17.add(lblHours);
textField_1 = new JTextPane();
panel_17.add(textField_1);
//textField_1.setColumns(3);
JPanel panel_11 = new JPanel();
panel_1.add(panel_11);
panel_11.setLayout(new GridLayout(1, 0, 0, 0));
JPanel panel_18 = new JPanel();
panel_11.add(panel_18);
panel_18.setLayout(new GridLayout(2, 0, 0, 0));
JLabel lblOpen = new JLabel("Open Time:");
panel_18.add(lblOpen);
JLabel lblYyyyMmDd = new JLabel("YYYY MM DD ");
lblYyyyMmDd.setHorizontalAlignment(SwingConstants.TRAILING);
panel_18.add(lblYyyyMmDd);
JPanel panel_19 = new JPanel();
panel_11.add(panel_19);
panel_19.setLayout(new GridLayout(2, 0, 0, 0));
JPanel panel_20 = new JPanel();
FlowLayout flowLayout_3 = (FlowLayout) panel_20.getLayout();
flowLayout_3.setVgap(0);
flowLayout_3.setHgap(0);
flowLayout_3.setAlignment(FlowLayout.LEFT);
panel_19.add(panel_20);
JLabel lblTo = new JLabel(" 2 to 4 Hours - \u00A3 ");
panel_20.add(lblTo);
textField_2 = new JTextPane();
//textField_2.setColumns(3);
panel_20.add(textField_2);
JPanel panel_21 = new JPanel();
FlowLayout flowLayout_4 = (FlowLayout) panel_21.getLayout();
flowLayout_4.setVgap(0);
flowLayout_4.setHgap(0);
flowLayout_4.setAlignment(FlowLayout.LEFT);
panel_19.add(panel_21);
JLabel lblTo_1 = new JLabel(" 4 to 8 Hours - \u00A3 ");
panel_21.add(lblTo_1);
textField_3 = new JTextPane();
//textField_3.setColumns(3);
panel_21.add(textField_3);
JPanel panel_12 = new JPanel();
panel_1.add(panel_12);
panel_12.setLayout(new GridLayout(0, 2, 0, 0));
JPanel panel_22 = new JPanel();
panel_12.add(panel_22);
panel_22.setLayout(new GridLayout(2, 4, 0, 0));
JPanel panel_24 = new JPanel();
panel_22.add(panel_24);
JLabel lblFrom = new JLabel("From");
panel_24.add(lblFrom);
JPanel panel_25 = new JPanel();
FlowLayout flowLayout_5 = (FlowLayout) panel_25.getLayout();
flowLayout_5.setVgap(0);
flowLayout_5.setHgap(0);
panel_22.add(panel_25);
textField_4 = new JTextPane();
//textField_4.setHorizontalAlignment(SwingConstants.LEFT);
panel_25.add(textField_4);
//textField_4.setColumns(3);
JPanel panel_26 = new JPanel();
FlowLayout flowLayout_6 = (FlowLayout) panel_26.getLayout();
flowLayout_6.setVgap(0);
flowLayout_6.setHgap(0);
panel_22.add(panel_26);
textField_5 = new JTextPane();
panel_26.add(textField_5);
//textField_5.setColumns(2);
JPanel panel_27 = new JPanel();
FlowLayout flowLayout_7 = (FlowLayout) panel_27.getLayout();
flowLayout_7.setVgap(0);
flowLayout_7.setHgap(0);
panel_22.add(panel_27);
textField_6 = new JTextPane();
//textField_6.setColumns(2);
panel_27.add(textField_6);
JPanel panel_28 = new JPanel();
panel_22.add(panel_28);
JLabel lblTo_2 = new JLabel("To");
panel_28.add(lblTo_2);
JPanel panel_29 = new JPanel();
FlowLayout flowLayout_8 = (FlowLayout) panel_29.getLayout();
flowLayout_8.setVgap(0);
flowLayout_8.setHgap(0);
panel_22.add(panel_29);
textField_7 = new JTextPane();
//textField_7.setHorizontalAlignment(SwingConstants.LEFT);
//textField_7.setColumns(3);
panel_29.add(textField_7);
JPanel panel_30 = new JPanel();
FlowLayout flowLayout_9 = (FlowLayout) panel_30.getLayout();
flowLayout_9.setVgap(0);
flowLayout_9.setHgap(0);
panel_22.add(panel_30);
textField_8 = new JTextPane();
panel_30.add(textField_8);
//textField_8.setColumns(2);
JPanel panel_31 = new JPanel();
FlowLayout flowLayout_10 = (FlowLayout) panel_31.getLayout();
flowLayout_10.setHgap(0);
flowLayout_10.setVgap(0);
panel_22.add(panel_31);
textField_9 = new JTextPane();
panel_31.add(textField_9);
//textField_9.setColumns(2);
JPanel panel_32 = new JPanel();
panel_12.add(panel_32);
panel_32.setLayout(new GridLayout(2, 0, 0, 0));
JPanel panel_33 = new JPanel();
FlowLayout flowLayout_11 = (FlowLayout) panel_33.getLayout();
flowLayout_11.setAlignment(FlowLayout.LEFT);
flowLayout_11.setVgap(0);
flowLayout_11.setHgap(0);
panel_32.add(panel_33);
JLabel lblTohours = new JLabel(" 8 to12Hours - \u00A3 ");
panel_33.add(lblTohours);
textField_10 = new JTextPane();
//textField_10.setColumns(3);
panel_33.add(textField_10);
JPanel panel_34 = new JPanel();
FlowLayout flowLayout_12 = (FlowLayout) panel_34.getLayout();
flowLayout_12.setVgap(0);
flowLayout_12.setHgap(0);
flowLayout_12.setAlignment(FlowLayout.LEFT);
panel_32.add(panel_34);
JLabel lbltohours = new JLabel(" 12to24Hours - \u00A3 ");
panel_34.add(lbltohours);
textField_11 = new JTextPane();
//textField_11.setColumns(3);
panel_34.add(textField_11);
JPanel panel_13 = new JPanel();
panel_1.add(panel_13);
btnUpdate = new JButton("Update");
panel_13.add(btnUpdate);
confirm();
setInitial();
}
public void confirm(){
btnUpdate.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
setVisible(false);
new choose().setVisible(true);
update();
System.out.println(Car_Park.d1+""+Car_Park.m1+""+Car_Park.y1);
System.out.println(Car_Park.d2+""+Car_Park.m2+""+Car_Park.y2);
}
});
}
public void update(){
if(isInteger(textField.getText()))
Car_Park.parking_space=Integer.parseInt(textField.getText());
if(isDouble(textField_1.getText())||isInteger(textField_1.getText()));
Car_Park.price1=(Double.parseDouble(textField_1.getText()));
if(isDouble(textField_2.getText())||isInteger(textField_2.getText()))
Car_Park.price2=Double.parseDouble(textField_2.getText());
if(isDouble(textField_3.getText())||isInteger(textField_3.getText()))
Car_Park.price3=Double.parseDouble(textField_3.getText());
if(isDouble(textField_10.getText())||isInteger(textField_10.getText()))
Car_Park.price4=Double.parseDouble(textField_10.getText());
if(isDouble(textField_11.getText())||isInteger(textField_11.getText()))
Car_Park.price5=Double.parseDouble(textField_11.getText());
if(isInteger(textField_4.getText()))
Car_Park.y1=Integer.parseInt(textField_4.getText())-1900;
if(isInteger(textField_5.getText()))
Car_Park.m1=Integer.parseInt(textField_5.getText())-1900;
if(isInteger(textField_6.getText()))
Car_Park.d1=Integer.parseInt(textField_6.getText())-1;
if(isInteger(textField_7.getText()))
Car_Park.y2=Integer.parseInt(textField_7.getText())-1;
if(isInteger(textField_8.getText()))
Car_Park.m2=Integer.parseInt(textField_8.getText());
if(isInteger(textField_9.getText()))
Car_Park.d2=Integer.parseInt(textField_9.getText());
}
public void setInitial(){
textField.setText(""+Car_Park.parking_space);
textField_1.setText(""+Car_Park.price1);
textField_2.setText(""+Car_Park.price2);
textField_3.setText(""+Car_Park.price3);
textField_10.setText(""+Car_Park.price4);
textField_11.setText(""+Car_Park.price5);
textField_4.setText("xxxx");
textField_5.setText("xx");
textField_6.setText("xx");
textField_7.setText("xxxx");
textField_8.setText("xx");
textField_9.setText("xx");
}
public static boolean isDouble(String value) {
 try {
 Double.parseDouble(value);
 return true;
 } catch (NumberFormatException e) {
 return false;
 }
}
public static boolean isInteger(String value) {
 try {
 Integer.parseInt(value);
 return true;
 } catch (NumberFormatException e) {
 return false;
 }
}
}