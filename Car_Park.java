/**
* @author Srichakradhar
*
*/
import java.util.ArrayList;
import java.util.Date;
import java.awt.EventQueue;
import java.io.BufferedWriter;
import java.io.FileWriter;
public class Car_Park {
static public int amount_of_tickets; //total amount of tickets
static public double amount_of_coins; //total coins in the collection box
static public double collection; //the collection in payment station
static public int parking_space; //total parking places
static public int remaining_space; //remaining parking places
static public int remaining_ticket; //remaining tickets in the ticket box
static public double max_money=100; //Maximum money can be stored in the collection box
static public double price1,price2,price3,price4,price5; //price for different time interval
static public Date opening_time[]; //opening time for public
static int y1=0; //start year
static int y2=0; //end year
static int m1=0; //start month
static int m2=0; //end month
static int d1=0; //start day
static int d2=0; //end day
static Date date1=new Date();;
static Date date2=new Date();
FileWriter fw;
BufferedWriter bw;
ArrayList<String> update;
ArrayList<Integer> updatenum;

public Car_Park(){
amount_of_tickets=10; //initial number of tickets
amount_of_coins=0; //initial amount of coins
parking_space=30; //initial parking places
remaining_space=parking_space;
remaining_ticket=amount_of_tickets;
price1=0.5; //initial parking tariffs
price2=1;
price3=2;
price4=3;
price5=5;
}
public static void main(String[] args) {
EventQueue.invokeLater(new Runnable() {
public void run() {
try {
new Driver_Control();
System.out.println("Driver_Control succeed");
new Operator_Control();
System.out.println("Operator_Control succeed");
} catch (Exception e) {
e.printStackTrace();
}
}
});
}
public static boolean isInteger(String value) {
 try {
 Integer.parseInt(value);
 return true;
 } catch (NumberFormatException e) {
 return false;
 } 

}
public String refreshEnter(){
String output;
output="The remaining space: "+remaining_space+"\nTarrif:\n" +
"QM STAFF:\t"+"\u00A3 1\nPUBLIC:\t0-2hours\t\u00A3 "+price1
+"\n\t2-4hours\t\u00A3 "+price2 +
"\n\t4-8hours\t\u00A3 "+price3 +"\n\t8-12hours\t\u00A3 "+price4
+"\n\t12-24hours\t\u00A3 "+price5 +"\r\n\r\n";
return output;
}
public String refreshPayment(){
String output;
output="\n\nPUBLICTarrif:\n" +
"0-2hours\t\u00A3 "+price1 +"\n2-4hours\t\u00A3 "+price2 +
"\n4-8hours\t\u00A3 "+price3 +"\n8-12hours\t\u00A3 "+price4
+"\n12-24hours\t\u00A3 "+price5 +"\r\n\r\n";
return output;
}
}