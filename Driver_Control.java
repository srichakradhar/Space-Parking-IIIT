import java.io.FileNotFoundException;
import java.io.FileWriter ;
import java.io.BufferedWriter ;
import java.io.IOException;
import java.io.FileReader ;
import java.io.BufferedReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
public class Driver_Control extends JFrame implements ActionListener {
  private static final long serialVersionUID = 1L;
Enter_UI enterFrame;
Payment_UI payFrame;
Exit_UI exitFrame ;
public Car_Park park;
String IDInput;
String payInput;
String leaveInput;
String collectionInput;
String AccountInput;
Usage transhtemp=new Usage();
int accountNum;
int key=0;
Public_Account transpaytemp;
int flag=0;
int count=0;
int size=0; //mylist3 size
int ticketcount=0;
LinkedList<Usage> mylist1=new LinkedList<Usage>();//Stack1, is for usage
LinkedList<Usage> mylist2=new LinkedList<Usage>();//Stack2, is for account
ArrayList<Staff_Account> mylist3=new ArrayList<Staff_Account>();
//Stack1, is for usage
ArrayList<Public_Account> mylist4=new ArrayList<Public_Account>();
//Stack2, is for account
FileWriter fw;
BufferedWriter bw;
FileReader fr;
BufferedReader br;
public Driver_Control(){
EventQueue.invokeLater(new Runnable() {
public void run() {
try {

// mylist4 is for the public user;
//  mylist3 is for the QM staff
park=new Car_Park();
enter();
record();
fr=new FileReader("StaffDB.txt");
br=new BufferedReader(fr);
enterFrame = new Enter_UI();
enterFrame.setVisible(true);
enterFrame.btnNewButton.addActionListener(new
ActionListener(){
 public void actionPerformed(ActionEvent evt) {
 Date today=new Date();

 boolean b=checkDay(today);
 System.out.println("Today? "+b);
 if(b)
 {

 if(ticketcount==Car_Park.amount_of_tickets)
 {JOptionPane.showMessageDialog(null, "Sorry, there is no ticket.", "SORRY", JOptionPane.ERROR_MESSAGE);
 choose.addTicket=1;
 if(choose.addTicket==1)
{

Operator_UI.frame0.lblOperator.setText("Attention: The ticket is used up, please fill in the ticket box.");
JOptionPane.showMessageDialog(null, "Sorry, There is no ticket. Operator fills in the ticket box.",
                              "SORRY",JOptionPane.INFORMATION_MESSAGE);
Car_Park.amount_of_tickets=10;
ticketcount=0;
}
 System.out.println("You can't get in."+choose.addTicket);
 }
 {
 Public_Account pubTemp= mylist4.get(ticketcount);
 while(pubTemp.payflag!=0)
 { pubTemp= mylist4.get(ticketcount);
 ticketcount++;
 } //used to test the situation after add ticket, ticket count back to 0

 pubTemp.card_number=""+ticketcount;
 pubTemp.payflag=1;
 JOptionPane.showMessageDialog(null, "Welcome, your ticket number is "+pubTemp.card_number, "SUCCESS",
JOptionPane.INFORMATION_MESSAGE);

System.out.println("Welcome" + pubTemp.accountNum);

 Usage temp=new Usage();
 temp.accountlistnum=pubTemp.accountNum;
 temp.type=false;
 temp.id=""+ticketcount;
 temp.enter_time=new Date();
 mylist1.add(temp);
 ticketcount++;
 count++;

Car_Park.remaining_ticket=Car_Park.amount_of_tickets-ticketcount;

Car_Park.remaining_space=Car_Park.parking_space-count;

 enterFrame.textArea.setText(park.refreshEnter());
 }//end if

 }
 else
 JOptionPane.showMessageDialog(null, "Public can't step in today.", "FAILURE", JOptionPane.ERROR_MESSAGE);
 }

});
/*listen to the enterFrame's text field to process the entrance of the staff*/

enterFrame.txtReadCard.addActionListener(new
ActionListener(){
 public void actionPerformed(ActionEvent evt) {

 IDInput =
enterFrame.txtReadCard.getText().toString();
 AccountInput="ID: "+IDInput;
 try{
FileReader fr=new FileReader("registerlist.txt");
BufferedReader br=new BufferedReader(fr);
String line=br.readLine();
int check=0;
while (line!=null)
{
check++;
if(check>size)
{
Staff_Account tempAccount=new Staff_Account(line);
mylist3.add(tempAccount);
}
line=br.readLine();
}
size=mylist3.size();
System.out.println("Now the size is "+size);
Staff_Account a=mylist3.get(1);
System.out.println("The name is "+a.card_number);
br.close();
fr.close();
}
catch(IOException e)
 {
 System.out.println("Cannot find the file.");
 }
int j;
 for ( j=0;j<size;j++)
   {
Staff_Account b=mylist3.get(j);
if(b.card_number.equals(AccountInput))
break;
}
 if(j==size)
 {
 System.out.println("You can't enter.");
 JOptionPane.showMessageDialog(null, "You can't enter, you haven't registered.",
                               "FAILURE", JOptionPane.ERROR_MESSAGE);
 }
 else
 {
 Staff_Account findaccount=mylist3.get(j);
 if(findaccount.payflag==1)
 JOptionPane.showMessageDialog(null, "You can't enter, your last car usage had a problem.",
                               "FAILURE", JOptionPane.ERROR_MESSAGE);
 else{
 findaccount.payflag=1;
System.out.println("It is"+findaccount.card_number);

 Usage temp=new Usage(IDInput);
 temp.type=true;
 temp.accountlistnum=j;

 temp.enter_time=new Date();
 mylist1.add(temp);
 count++;

Car_Park.remaining_space=Car_Park.parking_space-count;

 JOptionPane.showMessageDialog(null, "Welcome"+findaccount.card_number, "SUCCESS",
JOptionPane.INFORMATION_MESSAGE);

 enterFrame.textArea.setText(park.refreshEnter());
 }
 }
 }
});
payFrame = new Payment_UI();
payFrame.setVisible(true);
payFrame.textField_1.addActionListener(new ActionListener(){
 @SuppressWarnings("deprecation")
public void actionPerformed(ActionEvent evt) {

 payInput=payFrame.textField_1.getText();
 Usage temp,htemp=new Usage();
 if(flag==0) //whether the car is in car park
 {
 while(!empty(mylist1))

 { if(mylist1.size()!=0)
 { temp=(Usage)mylist1.getLast();

mylist1.removeLast();
 if( payInput.equals(temp.id))
 { count--;
 htemp=temp;
 flag=1;
 }
 else mylist2.add(temp);
 }
 }
 while(!empty(mylist2))
 {temp=(Usage)mylist2.getLast();
 mylist2.removeLast();
 mylist1.add(temp);
 }

 if(flag==0) //no such a car in car park
 {JOptionPane.showMessageDialog(null, "Sorry, there is no such a car.",
                                "SORRY", JOptionPane.ERROR_MESSAGE);
 payFrame.textField_1.setText("There is no such a car");}
 else //find the info of the car
 {
flag=0;
double s=0;
if (htemp.type==true)
{
 int year1=0;int month1=0;int day1=0;
 Date tempory=new Date();
 int year=tempory.getYear();
 int month=tempory.getMonth();
int day=tempory.getDate();
if( mylist3.get(htemp.accountlistnum).accountDate!=null)
 {
 System.out.println("Calculate the days of parking.");
 year1 = mylist3.get(htemp.accountlistnum).accountDate.getYear();
 month1 = mylist3.get(htemp.accountlistnum).accountDate.getMonth();
 day1 = mylist3.get(htemp.accountlistnum).accountDate.getDate();
 htemp.payment_time = tempory;

if(year==year1&&month==month1&&day==day1)
 s=0;
 else
 { if(month-month1==0)
 { int dayin=day-day1;
 s=1*dayin;
 }else{

JOptionPane.showMessageDialog(null, "Sorry, your last month bill has problems, \nplease ask operator for help.",
                              "SORRY", JOptionPane.ERROR_MESSAGE);
 }
 }


 }
else
 {htemp.payment_time=tempory;

 s=1;
 }
}
if (htemp.type==false)
{ htemp.payment_time=new Date();
 s=countcost(htemp);
 }
 htemp.charge=s;
 if(htemp.type==true)
{
Staff_Account
findaccount=mylist3.get(htemp.accountlistnum);

findaccount.accountCharge=findaccount.accountCharge+s;
 System.out.println("Your account charge is"+findaccount.accountCharge);
 findaccount.payflag=0;
}


try{
 fw = new
FileWriter("usage_information.txt", true);
 bw = new BufferedWriter(fw);
 bw.newLine();

bw.write("\t"+htemp.id+"\t"+htemp.enter_time+"\t"+htemp.payment_time+"\t"
           +htemp.charge);
 bw.close();
}
 catch(IOException e)
 {
System.out.println("Cannot find the file.");
}
if(htemp.type==true)
payFrame.textArea.setText("Successfully out.\n This time your expense is "
                            +htemp.charge+".\n" + "Your account charge is"
                            +mylist3.get(htemp.accountlistnum).accountCharge);
 Date lastTime=new Date();

mylist3.get(htemp.accountlistnum).accountDate=lastTime; 
payFrame.textArea.append(park.refreshPayment());
 if(htemp.type==false)
{
 payFrame.textArea.setText("Please pay your fee.\nYou need to pay "
                             +(float)htemp.charge);

payFrame.textArea.append(park.refreshPayment());
 Public_Account
paytemp=mylist4.get(htemp.accountlistnum);

/////////////////////////////////////////////////////////////////////////////////

 System.out.println("Now you have to pay the fee before you leave the car park.");

 accountNum=htemp.accountlistnum;


 htemp.collection=0;
 transhtemp=htemp;
 System.out.println("Usage:"+transhtemp.id+transhtemp.collection+"\n");
 payFrame.textField_2.setEditable(true);




payFrame.textField_2.addActionListener(new ActionListener(){

 public void
actionPerformed(ActionEvent evt) {
 Public_Account
transpaytemp=mylist4.get(accountNum);


if(transpaytemp.payflag!=0)
 {
 System.out.println("Account:"+transpaytemp.card_number+transpaytemp.payflag+"\n");;
 System.out.println("the collection1 is "+transhtemp.collection);


collectionInput=payFrame.textField_2.getText();
payFrame.textField_2.setText("");
 float money=Float.parseFloat(collectionInput);

 System.out.println("the collection2 is "+transhtemp.collection);


transhtemp.collection=transhtemp.collection+money;

 System.out.println("the collection3 is "+transhtemp.collection);
 if
(transhtemp.collection>=transhtemp.charge)
 {
 transpaytemp.payflag=0;
 BigDecimal a = new
BigDecimal(transhtemp.collection);
 BigDecimal paidMoney
= a.setScale(2, RoundingMode.DOWN);


JOptionPane.showMessageDialog(null, "You have paid \u00A3 "+ paidMoney,
                              "Welcome", JOptionPane.INFORMATION_MESSAGE);

Car_Park.amount_of_coins=Car_Park.amount_of_coins+transhtemp.collection;
 System.out.println("The park max is "+Car_Park.max_money);
 System.out.println("The park coin is "+Car_Park.amount_of_coins);
 if
(Car_Park.amount_of_coins>=Car_Park.max_money)

{JOptionPane.showMessageDialog(null, "The money box is full, you have to collect the money.",
                               "Operator", JOptionPane.INFORMATION_MESSAGE);

JOptionPane.showMessageDialog(null, "The money (\u00A3"
                                +Car_Park.amount_of_coins
                                +") is taken away.","Operator",
JOptionPane.INFORMATION_MESSAGE);

Car_Park.amount_of_coins=0;}

payFrame.textField_2.setEditable(false);
transhtemp.collection=0;
 }

 }

 System.out.println("In the end, account"+transpaytemp.card_number+"flag number is"+transpaytemp.payflag+"\n");

 }
 });

 }
 generate_bill();
 }
}
 }
});
exitFrame = new Exit_UI();
exitFrame.setVisible(true);
exitFrame.textField_1.addActionListener(new ActionListener(){

public void actionPerformed(ActionEvent evt) {

 leaveInput =
exitFrame.textField_1.getText().toString();
 int length=mylist4.size();
 int i;
 for(i=0;i<length;i++)
 {
 if(leaveInput.equals(mylist4.get(i).card_number))
 break;
 }
 if(i!=length)
 {
 Public_Account exit=mylist4.get(i);
 if(exit.payflag==0)
 exitFrame.txtrIdSParking.setText("Thank you for using Space Park.");
 if(exit.payflag==1)
 exitFrame.txtrIdSParking.setText("You have to pay before exit");
 }
 else
 {
 int length1=mylist3.size();
 int j;
 leaveInput="ID: "+leaveInput;
 for(j=0;j<length1;j++)
 {

if(leaveInput.equals(mylist3.get(j).card_number))
 break;
 }
 if(j!=length1)
 {
 Staff_Account exit=mylist3.get(j);
 if(exit.payflag==0)
 {

exitFrame.txtrIdSParking.setText("QM: "+mylist3.get(j).card_number+".:\nNow your account charge is "
                                   +mylist3.get(j).accountCharge
                                   +".\nPlease pay it off at the end of the month.\nWelcome to you again.");
 }
 if(exit.payflag==1)

exitFrame.txtrIdSParking.setText("You have to RECORD your expense in your account");
 }
 else
 exitFrame.txtrIdSParking.setText("There is something wrong in your account, \nyou are not in the car park.");
 }
 }
});
} catch (Exception e) {
e.printStackTrace();
}
}
});
}
public void enter() throws IOException{
FileReader fr = null;
try {
fr = new FileReader("registerlist.txt");
} catch (FileNotFoundException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
BufferedReader br=new BufferedReader(fr);
String line = null;
try {
line = br.readLine();
} catch (IOException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
flag=0;
int checktype=0;
while (line!=null)
{ checktype++;
if(checktype<=Car_Park.amount_of_tickets)
{
Public_Account tempAccount=new Public_Account(line);
mylist4.add(tempAccount);
}
else{
Staff_Account tempAccount=new Staff_Account(line);
mylist3.add(tempAccount);
}
try {
line=br.readLine();
} catch (IOException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
}
size=mylist3.size();
System.out.println("the size3 is "+mylist3.size());
System.out.println("the size4 is "+mylist4.size());
Staff_Account a=mylist3.get(1);
System.out.println("the name is"+a.card_number);
br.close();
fr.close();
}
public void record() throws IOException{
fw=new FileWriter("usage_information.txt");
bw=new BufferedWriter(fw);
bw.write("ID number\t\tEnter time\t\tpayment time\t\t\tcharge");
 bw.close();
}
public double countcost(Usage temp ) //calculate the charge
{
 int
s1=temp.payment_time.getSeconds()+temp.payment_time.getMinutes()*60+temp.payment_time.getHours()*3600+temp.payment_time.getDay()*216000;
 int s2=temp.enter_time.getSeconds()+temp.enter_time.getMinutes()*60+temp.enter_time.getHours()*3600+temp.enter_time.getDay()*216000;
 double s=0;

 {
 int s3=s1-s2;

 if(s3>0&&s3<2*3600)
 s=Car_Park.price1;
 else if(s3>=2*3600&&s3<4*3600)
 s=Car_Park.price2;
 else if(s3>=4*3600&&s3<8*3600)
 s=Car_Park.price3;
 else if(s3>=8*3600&&s3<12*3600)
   s=Car_Park.price4;
 else if(s3>=12*3600&&s3<24*3600)
 s=Car_Park.price5;
 else
 s=Car_Park.price5;
 }

 return s;
}
/*It is a method to generate immediately bill*/
public void generate_bill(){
try{
fw=new FileWriter("bill.txt");
bw=new BufferedWriter(fw);
bw.write("ID card number\t\t\taccount Charge");
 bw.close();
FileWriter fw=new FileWriter("bill.txt",true);
BufferedWriter bw=new BufferedWriter(fw);
for(int i=0;i<size;i++)
{
Staff_Account billaccount=mylist3.get(i);
bw.newLine();

bw.write(billaccount.card_number+"\t\t\t\t"+billaccount.accountCharge);

}
 bw.close();
}
catch(IOException ev)
{
System.out.println("Cannot find the file!");
}
}
@SuppressWarnings("deprecation")
public boolean checkDay(Date date){
int judge=0;
judge=Car_Park.y1*Car_Park.y2*Car_Park.m1*Car_Park.m2*Car_Park.d1*Car_Park.d2;
System.out.println("!!!!!!!! Result of check day: "+judge);
int i=date.getDay();
if(i==6)
{
return true;
}
if(i==0)
{
return true;
}
if(judge!=0)
{
System.out.println("!!!!!!!!");
Car_Park.date1.setYear(Car_Park.y1);
Car_Park.date2.setYear(Car_Park.y2);
Car_Park.date1.setMonth(Car_Park.m1);
Car_Park.date2.setMonth(Car_Park.m2);
Car_Park.date1.setDate(Car_Park.d1);
Car_Park.date2.setDate(Car_Park.d2);
Car_Park.date1.setHours(0);
Car_Park.date2.setHours(23);
Car_Park.date1.setMinutes(0);
Car_Park.date2.setMinutes(59);
Car_Park.date1.setSeconds(0);
Car_Park.date2.setSeconds(59);
System.out.println(date);
System.out.println(Car_Park.date1);
System.out.println(Car_Park.date2);
if(date.after(Car_Park.date1)&&date.before(Car_Park.date2))
return true;
}
return false;
}
public void push(Usage usage,LinkedList<Usage> mylist)
  {
 mylist.add(usage);
}
public Usage pop(LinkedList<Usage> mylist) 
{
 Usage temp=new Usage();
 if(mylist.size()!=0) {temp=(Usage)mylist.getLast();
mylist.removeLast();return (Usage)temp;}
 else return null;
}
public boolean empty(LinkedList<Usage> mylist)
{
 if(mylist.size()==0) return true;
 else return false;
}
public static boolean isInteger(String value) {
 try {
 Integer.parseInt(value);
 return true;
 } catch (NumberFormatException e) {
 return false;
 }
}
@Override
public void actionPerformed(ActionEvent arg0) {
// TODO Auto-generated method stub
}
} 