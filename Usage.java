import java.util.*;
public class Usage {
public String id; //ID number
public int number; //park place number
public Date enter_time; //record enter time
public Date payment_time; //record payment time
public double charge; //the charge of each use
public double collection; //the collection that the public paid
public float parking_hours; //the total hours in this paring time
public int accountlistnum; //record the usage of an account
public boolean type; //decide the usage of public or staff

Usage(String id)
 {
 this.id=id;
 this.enter_time=new Date();
 System.out.println("ID: "+this.id+" Enter time: "+this.enter_time);
 }
Usage(){
}

 public void paymentTime()
 {
 this.payment_time=new Date();
 System.out.println("ID: "+this.id+" Payment time:"+this.payment_time);
 }
}