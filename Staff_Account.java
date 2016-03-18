import java.util.Date;
/**
* @author Srichakradhar
*
*/
public class Staff_Account extends Account {
public double accountCharge; //define the charge of each account
public Date accountDate; //record the date


Staff_Account(String id){
this.card_number=id;
this.payflag=0;
System.out.println("Staff Card Number: "+this.card_number
                     +" Staff Payment State: "+this.payflag);
}
}