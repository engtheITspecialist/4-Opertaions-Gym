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
       while(count<15){
           int number1=(int)(Math.random()*10);
           int number2=(int)(Math.random()*10);
           
           
           
           if(number1<number2){
               int temp=number1;
               number1=number2;
               number2=temp;
               
           }
           
           String answerString=JOptionPane.showInputDialog(number1+"-"+number2+" nedir? ");
           int answer=Integer.parseInt(answerString);
           String replyString;
           if(number1-number2==answer){
               replyString="Doðru bildin Kaan ";
               correctCount++;
           }else{
               replyString="Cevabýn yanlýþ\n"+ number1+"-"+number2+" cevap "+(number1-number2)+" olmalýydý.";
               incorrectStatistic+=number1+"-"+number2+"="+answerString+"\n";
           }
           JOptionPane.showMessageDialog(null, replyString);
           count++;
           output+="\n"+number1+"-"+number2+"="+answerString+((number1-number2==answer) ? " doðru ":"yanlýþ");
           
       }
       long endTime=System.currentTimeMillis();
       long testTime=endTime-StartTime;
       sonuc=correctCount+" adet dogru cevap verdin\n";
       JOptionPane.showMessageDialog(null,output+" \n"+ testTime/1000+ "saniyede "+sonuc);
       
       Date date=new Date();
       DateFormat df=new SimpleDateFormat("dd/MM/yyyy hh:mm");
       
       
        String mesaj=df.format(date)+">>>>>"+(testTime/1000)+" saniyede "+sonuc+">>>>> "+(correctCount*2)+ "kuruþ kazandýn.";
        incorrectString=incorrectStatistic+"";
       DosyaIslemleri di=new DosyaIslemleri(2, mesaj,incorrectString);
       totalMoney=(correctCount*2)+di.paraOku();
       
       di.paraYaz(totalMoney);
    }
}
