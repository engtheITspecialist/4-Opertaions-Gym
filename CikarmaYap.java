//written by engtheITSpecialist 
//linkedin.com/in/engin-taş-8659537b

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
public class CikarmaYap {
	public static void Cikarma() throws IOException{
        String sonuc="";
         String incorrectStatistic="";
       String incorrectString="";
        int totalMoney=0;
  
       int correctCount=0;
       int count=0;
       long StartTime=System.currentTimeMillis();
       String output = "";
       //you can change amount of questions. i decided 15 questions in begining. 
       while(count<20){
           int number1=(int)(Math.random()*10);
           int number2=(int)(Math.random()*10);
           
           
           // we can check number1 and number2 which one is bigger then other. we are changing if first one is small
           if(number1<number2){
               int temp=number1;
               number1=number2;
               number2=temp;
               
           }
           
           String answerString=JOptionPane.showInputDialog(Messages.QUESTİON+number1+"-"+number2+" ? ");
           int answer=Integer.parseInt(answerString);
           String replyString;
           if(number1-number2==answer){
               replyString=Messages.ADMIRE;
               correctCount++;
           }else{
               replyString=Messages.WRONGANSWER+ number1+"-"+number2+" need to be  "+(number1-number2);
               incorrectStatistic+=number1+"-"+number2+"="+answerString+"\n";
           }
           JOptionPane.showMessageDialog(null, replyString);
           count++;
           output+="\n"+number1+"-"+number2+"="+answerString+((number1-number2==answer) ? " correct ":"incorrect");
           
       }
       long endTime=System.currentTimeMillis();
       long testTime=endTime-StartTime;
       sonuc=correctCount+" You answered "+correctCount+" correctly\n";
       JOptionPane.showMessageDialog(null,output+sonuc+" \n in "+ testTime/1000+ "second.");
       
       Date date=new Date();
       DateFormat df=new SimpleDateFormat("dd/MM/yyyy hh:mm");
       
       
        String mesaj=df.format(date)+">>>>> in "+(testTime/1000)+" seconds "+sonuc+">>>>> You earn "+(correctCount)+ "cent.";
        incorrectString=incorrectStatistic+"";
       DosyaIslemleri di=new DosyaIslemleri(2, mesaj,incorrectString);
       totalMoney=(correctCount*2)+di.paraOku();
       
       di.paraYaz(totalMoney);
    }
}
