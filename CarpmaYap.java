//written by engtheITSpecialist 
//linkedin.com/in/engin-taş-8659537b

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
public class CarpmaYap {
	public static void Carpma() throws IOException{
        String incorrectStatistic="";
    String incorrectString="";
    int totalMoney=0;
    String sonuc="";
    String answerString="";
    
        int correctCount=0;
    int count=0;
    long StartTime=System.currentTimeMillis();
    String output = "";
    //you can change amount of questions. i decided 15 questions in begining. 
    while(count<20){
        int number1=0;
        int number2=0;
        int answer=0;
      //you can decide which numbers choosen as randomly. for example i dont want numbers these are small 4 
        do {
        number1=(int)(Math.random()*10);
        number2=(int)(Math.random()*10);
    }while(number1<4  || number2<4);
    
        
        
        
        do {
        	answerString=JOptionPane.showInputDialog(Messages.QUESTİON+number1+"*"+number2+" ? ");
        	answer=Integer.parseInt(answerString);
        }while(answer>100||answer<0);
        
        String replyString;
        if(number1*number2==answer){
            replyString=Messages.ADMIRE;
            correctCount++;
        }else{
            replyString=Messages.WRONGANSWER+"*"+number2+" need to be  "+(number1*number2);
            incorrectStatistic+=number1+"X"+number2+"="+answerString+"\n";
        }
        JOptionPane.showMessageDialog(null, replyString);
        count++;
        output+="\n"+number1+"X"+number2+"="+answerString+((number1*number2==answer) ? " correct ":"incorrect");
        
    }
   
    long endTime=System.currentTimeMillis();
    long testTime=endTime-StartTime;
    sonuc=" You answered "+correctCount+" correctly\n";
    JOptionPane.showMessageDialog(null,output+sonuc+" \n in "+ testTime/1000+ "second.");
    
    Date date=new Date();
    DateFormat df=new SimpleDateFormat("dd/MM/yyyy hh:mm");
    
    String mesaj=df.format(date)+">>>>> in "+(testTime/1000)+" seconds "+sonuc+">>>>> You earn "+(correctCount)+ "cent.";
    
    
    incorrectString=incorrectStatistic+"";
    
    DosyaIslemleri di=new DosyaIslemleri(1, mesaj,incorrectString);
    totalMoney=(correctCount*3)+di.paraOku();
    
    di.paraYaz(totalMoney);
        
        
    }
}
