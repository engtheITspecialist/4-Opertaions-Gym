import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
public class ToplamaYap {
	public void Toplama() throws IOException{
        String sonuc="";
         String incorrectStatistic="";
       String incorrectString="";
        int totalMoney=0;
        int correctCount=0;
       int count=0;
       long StartTime=System.currentTimeMillis();
       String output = "";
       while(count<15){
           
           int number1=0;
           int number2=0;
           
//rastgele sayÄ±larda 1 ve 0 olmasÄ±n. 
           do {
           number1=(int)(Math.random()*10);
           number2=(int)(Math.random()*10);
       }while(number1==0 || number1==1 || number2==0||number2==1);
           
           
           String answerString=JOptionPane.showInputDialog(number1+"+"+number2+" nedir? ");
           int answer=Integer.parseInt(answerString);
           String replyString;
           if(number1+number2==answer){
               replyString="Doðru bildin Kaan ";
               correctCount++;
           }else{
               replyString="Cevabýn yanlýþ\n"+ number1+"+"+number2+" cevap "+(number1+number2)+" olmalýydý.";
               incorrectStatistic+=number1+"+"+number2+"="+answerString+"\n";
           }
           JOptionPane.showMessageDialog(null, replyString);
           count++;
           output+="\n"+number1+"+"+number2+"="+answerString+((number1-number2==answer) ? " doðru ":"yanliþ");
           
       }
       long endTime=System.currentTimeMillis();
       long testTime=endTime-StartTime;
       sonuc=correctCount+" adet dogru cevap verdin\n";
       JOptionPane.showMessageDialog(null,output+" \n"+ testTime/1000+ "saniyede "+sonuc);
       
       Date date=new Date();
       DateFormat df=new SimpleDateFormat("dd/MM/yyyy hh:mm");
       
       
        String mesaj=df.format(date)+">>>>>"+(testTime/1000)+" saniyede "+sonuc+">>>>> "+(correctCount)+ "kuruþ kazandýn.";
        incorrectString=incorrectStatistic+"";
       DosyaIslemleri di=new DosyaIslemleri(3, mesaj,incorrectString);
       totalMoney=(correctCount)+di.paraOku();
       di.paraYaz(totalMoney);
   }
}
