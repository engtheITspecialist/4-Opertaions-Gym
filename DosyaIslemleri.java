import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class DosyaIslemleri {
	int islemTipi=0;
	String sonucString="";
	String incorrect="";


	public DosyaIslemleri(){
	    
	}

	    public  DosyaIslemleri(int a,String b,String c) throws IOException {
	        this.islemTipi=a;
	        this.sonucString=b;
	        this.incorrect=c;
	        
	         //kazanılan paranın yazıldığı dosyayı oluşturuyoruz.
	            File fileEarnedMoney=new File("E:/earnedMoney.txt");
	       if(!fileEarnedMoney.exists()){
	           fileEarnedMoney.createNewFile();
	       }
	            
	            File fileSonuc;
	            File fileIncorrect;
	            
	            
	            if(this.islemTipi==1){
	            //sonuçlar ve kazanımlar için file  oluşturuyoruz..
	            fileSonuc=new File("E:/carpma/carpmasonuclar.txt");
	            //yanlışların istatistiğinin tutulduğu dosyayı oluşturuyoruz.
	            fileIncorrect=new File("E:/carpma/incorrectStatistic.txt");
	            
	        }
	        else if(this.islemTipi==2){
	                //sonuçlar ve kazanımlar için file  oluşturuyoruz..
	            fileSonuc=new File("E:/cikarma/cikarmasonuclar.txt");
	            //yanlışların istatistiğinin tutulduğu dosyayı oluşturuyoruz.
	            fileIncorrect=new File("E:/cikarma/incorrectStatistic.txt");
	                   
	        }
	        else{
	            //sonuçlar ve kazanımlar için file  oluşturuyoruz..
	            fileSonuc=new File("E:/toplama/toplamasonuclar.txt");
	            //yanlışların istatistiğinin tutulduğu dosyayı oluşturuyoruz.
	            fileIncorrect=new File("E:/toplama/incorrectStatistic.txt");       
	        }
	            
	           
	            
	            
	            
	            if(!fileSonuc.exists()|| !fileIncorrect.exists()){
		            fileSonuc.createNewFile();
		            fileIncorrect.createNewFile();
		            
		            }  
	            
	            
	          //filewriter nesnesi oluşturuyoruz. ardından bufferedreader nesnesi oluşturyoruz.
	            FileWriter fwSonuc=new FileWriter(fileSonuc,true);
	            BufferedWriter bwSonuc=new BufferedWriter(fwSonuc);

	            // yanlışlar için filewriter nesnesi oluşturuyoruz. ardından bufferedreader nesnesi oluşturyoruz.
	            FileWriter fwIncorrect=new FileWriter(fileIncorrect,true);
	            BufferedWriter bwIncorrect=new BufferedWriter(fwIncorrect);
	            bwSonuc.newLine();
	            bwSonuc.write(this.sonucString);
	            bwSonuc.newLine();
	            bwSonuc.close();
	            fwSonuc.close();

	            bwIncorrect.newLine();
	            bwIncorrect.write(this.incorrect);
	            bwIncorrect.newLine();
	            bwIncorrect.close();
	            fwIncorrect.close();
  
	    }

	    DosyaIslemleri(int i, String mesaj) {
	        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	    }
	     
	    
	    
	public  int paraOku(){
	           int para=0;
	           String s="";
	           String fileName="E:/earnedMoney.txt";  
	           try{
	               FileReader fileReader =new FileReader(fileName);
	               String line;
	               BufferedReader br= new BufferedReader(fileReader);
	               while((line=br.readLine())!=null){
	                   para=Integer.parseInt(line);
	               }
	           }catch(IOException e){
	               
	           }
	           return para;
	       }

	
	
	
	public  static void paraYaz(int a){
	           int para=0;
	           para=a;
	           String fileName="E:/earnedMoney.txt";
	           try{
	               FileWriter fwSonuc=new FileWriter(fileName,false);
	            BufferedWriter bwSonuc=new BufferedWriter(fwSonuc);
	               bwSonuc.write(a+"");
	               bwSonuc.close(); 
	           }catch(IOException e){
	               
	           }
	           
	       }
}
