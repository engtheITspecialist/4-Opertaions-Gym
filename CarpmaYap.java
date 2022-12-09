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
    while(count<15){
        int number1=0;
        int number2=0;
        int answer=0;
//rastgele sayÄ±larda 1 ve 0 olmasÄ±n. 
        do {
        number1=(int)(Math.random()*10);
        number2=(int)(Math.random()*10);
    }while(number1<4  || number2<4);
    
        
        
        
        do {
        	answerString=JOptionPane.showInputDialog(number1+"X"+number2+" nedir? ");
        	answer=Integer.parseInt(answerString);
        }while(answer>100||answer<0);
        
        String replyString;
        if(number1*number2==answer){
            replyString="Doðru bildin Kaan ";
            correctCount++;
        }else{
            replyString="Cevabýn yanlýþ\n"+ number1+"X"+number2+" cevap "+(number1*number2)+" olmalýydý";
            incorrectStatistic+=number1+"X"+number2+"="+answerString+"\n";
        }
        JOptionPane.showMessageDialog(null, replyString);
        count++;
        output+="\n"+number1+"X"+number2+"="+answerString+((number1*number2==answer) ? " doðru ":"yanliþ");
        
    }
   
    long endTime=System.currentTimeMillis();
    long testTime=endTime-StartTime;
    sonuc=correctCount+" adet dogru cevap verdin\n";
    JOptionPane.showMessageDialog(null,output+" \n"+ testTime/1000+ "saniyede "+sonuc);
    
    Date date=new Date();
    DateFormat df=new SimpleDateFormat("dd/MM/yyyy hh:mm");
    
    String mesaj=df.format(date)+">>>>>"+(testTime/1000)+" saniyede "+sonuc+">>>>> "+(correctCount*4)+ "kuruþ kazandýn.";
    
    
    incorrectString=incorrectStatistic+"";
    
    DosyaIslemleri di=new DosyaIslemleri(1, mesaj,incorrectString);
    totalMoney=(correctCount*3)+di.paraOku();
    
    di.paraYaz(totalMoney);
        
        
    }
}
