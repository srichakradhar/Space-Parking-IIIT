/**
* @author Srichakradhar
*
*/
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;
public class Operator_Control {
Operator_UI frame;
choose frame1;
RegisterNewCar_1 frame2;
RegisterNewCar frame3;
ModifyParkInfo frame4;
public Operator_Control(){
EventQueue.invokeLater(new Runnable() {
public void run() {
try {
frame = new Operator_UI();
frame.setVisible(true);
frame1 = new choose();
frame1.setVisible(false);
frame2 = new RegisterNewCar_1();
frame2.setVisible(false);
if(frame2.isVisible()==true){
search();
}
frame3 = new RegisterNewCar();
frame3.setVisible(false);
if(frame3.isVisible()==true){
addAccount();
check();
}
frame4 = new ModifyParkInfo();
frame4.setVisible(false);
if(frame3.isVisible()==true){
update();
}
} catch (Exception e) {
e.printStackTrace();
}
}
});
}
public void input(){
frame.login();
}
public void addAccount(){
frame3.register();
}
public void search(){
frame2.search();
}
public void check(){
frame3.check();
}
public void update(){
frame4.confirm();
}
}