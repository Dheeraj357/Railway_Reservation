//Program For Railway Reservation In Java...
package railway_reservation;
import java.io.*; 
import java.util.Scanner; 
import java.util.logging.Level; 
import java.util.logging.Logger; 
 
class Demo { 
InputStreamReader isr=new InputStreamReader (System.in); 
BufferedReader br=new BufferedReader (isr); 
private int pno[]=new int[275]; 
 private String name[]=new String[275]; 
private String phno[]=new String[275]; 
 private int age[]=new int[275]; 
private int cl[]=new int[275]; 
 int pcount=0; 
private int pnum=0; 
private int max1= 75; 
private int max2= 125; 
private int max3= 175; 
 
void  doHeading()throws Exception { 
System.out.println("#########################################################"); 
System.out.println("*********Railway Reservation For Marathwada Express***********"); 
System.out.println("#########################################################"); 
} 
public void doBook()throws Exception { 
System.out.println("Please enter the  class of ticket"); 
System.out.println("1. AC\t 2. First\t 3. Sleeper\t"); 
int c=Integer.parseInt(br.readLine()); 
//cl[pcount]=c;
int ticketAvailable =0,t=0;
if(c<1 || c >3)
{
 System.out.println("Please enter Right choice ...."); 
return;    
}
Demo D = new Demo();
//if(c<=3)   
System.out.println("Please enter no. of tickets"); 
t=Integer.parseInt(br.readLine());
if(c==1 && D.max1>=t) { 
ticketAvailable=1; 
} 
if(c==2 && D.max2>=t) { 
ticketAvailable=1; 
} 
if(c==3 && D.max3>=t) { 
ticketAvailable=1; 
}

if(ticketAvailable == 1 ) { 
for(int i=0;i<t;i++) {
    File f = new File("demo.txt");
        FileOutputStream fos = new FileOutputStream(f);
        DataOutputStream dos =new DataOutputStream(fos); 
        //dos.writeUTF("sunday");
                
     /* FileInputStream fis =new FileInputStream(f);
        DataInputStream dis =new DataInputStream(fis);
        String str =dis.readUTF();
        System.out.println(str);*/
// pcount += 1; 
// pnum +=1; 
  D.pno[pcount]=D.pnum; 
 System.out.println("Please enter your name: "); 
 D.name[pcount]=br.readLine();
 dos.writeUTF("This is ur Name:"+D.name[pcount]); 
 System.out.println("Please enter your age: "); 
 D.age[pcount]=Integer.parseInt(br.readLine()); 
 dos.writeUTF("This is ur Age:"+D.age[pcount]);
 D.cl[pcount]=c; 
 dos.writeUTF("This is ur Class Name:"+D.cl[pcount]);
 System.out.println("Please enter your phone no. :"); 
 D.phno[pcount]=br.readLine(); 
 dos.writeUTF("This is ur Phone Number:"+D.phno[pcount]);
 D.pcount += 1; 
 D.pnum +=1; 
 //st++;
 System.out.println("value of pcount:"+D.pcount);
 System.out.println("value of pnum:"+D.pnum);
 System.out.println("value of age:"+D.age[pcount]);
  System.out.println("value of class:"+D.cl[pcount]);
   System.out.println("value of phone number:"+D.phno[pcount]);
    System.out.println("value of name:"+D.name[pcount]);
    
 System.out.println("Ticket successfully booked..."); 
//System.exit(0);
//Railway_Rservation rr = new Railway_Rservation();
//rr.main();
//System.exit(0);
//return 0;
}//for 
 if(c==1) { 
 D.max1 -=  t; 
 System.out.println("Please pay Rs."+t*1500); 
 System.out.println("this is your remaining seats.."+D.max1);
 } 
 if(c==2) { 
 D.max2 -= t;  
 System.out.println("Please pay Rs."+t*1200); 
 } 
 if(c==3) { 
 D.max3 -= t; 
 System.out.println("Please pay Rs."+t*1000); 
 }
}
/*for(int i=0;i<D.pnum;i++)
{
    System.out.println("value of pno"+D.pno[i]); 

}*/
return ; 
} 
  public void   doCancel()throws Exception { 
 int t_pno[]=new int[275]; 
 String t_name[]=new String[275]; 
 String t_phno[]=new String[275]; 
 int t_age[]=new int[275]; 
 int t_cl[]=new int[275]; 
 int t_pcount=0; 
 int passengerFound=0; 
 Demo D = new Demo();
 System.out.println("Please enter your passenger no."); 
 int p=Integer.parseInt(br.readLine());
 System.out.println("value of pcount:"+D.pcount);
 
 for(int i=0;i<D.pcount;i++) 
 {
 if(D.pno[i] != p) 
 {
 t_name[t_pcount]= D.name[i]; 
 t_phno[t_pcount]= D.phno[i]; 
 t_age[t_pcount]= D.age[i]; 
 t_cl[t_pcount]= D.cl[i]; 
 t_pcount+=1; 
 System.out.println("This ticket number is not present...");
 //System.exit(0);
// return 0;
 } 
 else { 
  passengerFound=1; 
 if(D.cl[i]==1) { 
 D.max1++; 
 System.out.println("Please collect refund of Rs."+1800); 
 } 
 if(D.cl[i] ==2) { 
 D.max2++;
 System.out.println("Please collect refund of Rs."+1500);
 }
 if(D.cl[i]==3) { 
 D.max3++; 
 System.out.println("Please collect refund of Rs."+1000); 
 }
 }
 } 
 if(passengerFound==1) { 
D.pno=t_pno; 
 D.name=t_name; 
 D.age=t_age; 
 D.cl=t_cl; 
 D.phno=t_phno; 
 D.pcount=t_pcount; 
 System.out.println("ticket successfully cancelled"); 
 } 
 //for loop
 return ;
 } //method
 /*Display Chart*/
  public void doDispList()throws Exception { 
 Demo D =new Demo();
/* File f = new File("demo.txt");
 FileInputStream fis =new FileInputStream(f);
        DataInputStream dis =new DataInputStream(fis);
        
        String str =dis.readUTF();
        System.out.println(str);*/
      if(D.pcount == 0){
     System.out.println("No Ticket Present....");
     //System.exit(0);
     //return 0;
     }
     else{
 System.out.println("Passenger list in AC class");
 System.out.println("PassengerNo. \t Name \t\t Age \t Phone No."); 
 for(int i=0;i<D.pcount;i++) { 
 if(D.cl[i]==1) {
 System.out.println(D.pno[i]+"\t"+D.name[i]+"\t\t"+D.age[i]+"\t"+D.phno[i]);
 }
 }
 System.out.println("Passenger list in First class:"); 
 System.out.println("Passenger No. \t name \t\t age \t Phone No."); 
 for(int i=0;i<D.pcount;i++) { 
 if(D.cl[i]==2) {
 System.out.println(D.pno[i]+"\t"+D.name[i]+"\t\t"+D.age[i]+"\t"+D.phno[i]); 
 } 
 } 
 System.out.println("Passenger list in Sleeper class:"); 
 System.out.println("pno \t name \t\t age \t phno"); 
 for(int i=0;i<D.pcount;i++) { 
 if(D.cl[i]==3) { 
 System.out.println(D.pno[i]+"\t"+D.name[i]+"\t\t"+D.age[i]+"\t"+D.phno[i]); 
 } 
 } 
 }
     return ;
 }
 /*method for searching*/
public void doSearch()throws Exception { 
 int passengerFound=0; 
 System.out.println("Please enter passenger no. to search:"); 
 int p=Integer.parseInt(br.readLine()); 
 for(int i=0;i<pcount;i++) { 
 if(pno[i]==p) { 
 System.out.println("Detail found.."); 
 passengerFound=1; 
 System.out.println("passenger no.="+pno[i]); 
 System.out.println("name="+name[i]); 
 System.out.println("class="+cl[i]); 
 System.out.println("phno="+phno[i]); 
 System.out.println("age="+age[i]); 
 } 
 }//for 
 if(passengerFound==0) {
	System.out.println("No such passenger...");
       // System.exit(0);
//return 0;
 }//method
 return ;
 } 
	 public void doDispUnbooked()throws Exception 
        { 
 //Demo D = new Demo();
            System.out.println("No. of booked tickets status:"); 
  System.out.println("AC class "+ max1);
  System.out.println("First class "+ max2);
 System.out.println("Sleeper class "+ max3);
 //System.exit(0);
 return ;
        } 
void doExit() {
 System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&"); 
System.out.println("Name : Dheeraj , Class : CSE, Roll No. : 69"); 
System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&"); 
System.exit(0);
//return 0;
}
} 
            
        
/*Main Method*/        
public class Railway_Rservation 
{
 public static void main(String a[]) throws Exception
 { 
     while(1==1)
     {
try {
 int cho;
 System.out.println("1.Book ticket");
 System.out.println("2.Cancel ticket");
 System.out.println("3.Search passenger");
 System.out.println("4.Reservation chart"); 
 System.out.println("5.Display unbooked tickets");
 System.out.println("6.Exit"); 
 System.out.println("Please enter your choice"); 
Scanner Sc; 
Sc = new Scanner(System.in); 
cho=Sc.nextInt(); 
 Demo D = new Demo();
System.out.println("\f"); 
D.doHeading(); 
switch(cho) { 
case 1:D.doBook(); 
break; 
case 2:D.doCancel(); 
break; 
case 3:D.doSearch(); 
break; 
case 4:D.doDispList(); 
break; 
case 5:D.doDispUnbooked(); 
break; 
case 6:D.doExit(); 
break; 
default :System.out.println("Invalid choice"); 
} 
 } 
catch (Exception ex) { 
Logger.getLogger(Railway_Rservation.class.getName()).log(Level.SEVERE, null, ex);
 }
     }//while loop close   
     /*String url="jdbc:mysql://localhost: //";
     String uname="root";
     String pass ="";
     String Query="select username from student where userid=";
     
     class.forName("com.mysql.jdbc.Driver");
     Connection con=DriverManager.getConnection(url,uname,pass);
 Statement st = con.createStatement();
 //st.executeQuery(Query);
 ResultSet rs = st.executeQuery(Query);
 rs.next();
 String name=rs.getString("");
 System.out.println(name);
 st.close();
 con.close();*/
 }
}
        

    
    


