//written by engtheITSpecialist 
//linkedin.com/in/engin-taş-8659537b
//This class process for division operations

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class BolmeYap {
	public static void Bolme() throws IOException{
		
        String incorrectStatistic="";
    String incorrectString="";
    int totalMoney=0;
    String sonuc="";
    String answerString="";
    int correctCount=0;
    int count=0;
    long StartTime=System.currentTimeMillis();
    String output = "";
 
    while(count<15){
        int number1=0;
        int number2=0;
        int answer=0;
//i dont want number that smaller then 2, or number1 equal number2 or number1 mod number2 is zero
        do {
        number1=(int)(Math.random()*50);
        number2=(int)(Math.random()*10);
    }while(number1<2  || number2<2 || number1%number2!=0 ||number1==number2);
    //if number1 smaller then number2 we need to change number1 and number2
        if(number1<number2){
            int temp=number1;
            number1=number2;
            number2=temp;
            
        }
        
        
        do {
        	answerString=JOptionPane.showInputDialog(Messages.QUESTİON+number1+":"+number2+" ? ");
        	answer=Integer.parseInt(answerString);
        }while(answer>100||answer<0);
        
        String replyString;
        if(number1/number2==answer){
        	replyString=Messages.ADMIRE;
            correctCount++;
        }else{
        	replyString=Messages.WRONGANSWER+":"+number2+" need to be  "+(number1/number2);
            incorrectStatistic+=number1+":"+number2+"="+answerString+"\n";
        }
        JOptionPane.showMessageDialog(null, replyString);
        count++;
        output+="\n"+number1+":"+number2+"="+answerString+((number1/number2==answer) ? " correct ":"incorrect");
        
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
    totalMoney=(correctCount*7)+di.paraOku();
    
    di.paraYaz(totalMoney);
        
        
    }
}
