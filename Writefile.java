import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.io.*;
class Wen extends JFrame implements ActionListener{
	 JPasswordField mi;
	 JButton an;
	 JFrame jf;
     DataInputStream dis;
	  public Wen(){
	  mi=new JPasswordField(20);
	  an=new JButton("È·¶¨");
	  an.addActionListener(this);
	  jf=new JFrame();
	  
	  jf.add(mi);
	  jf.add(an);
	  
	  jf.setLayout(new FlowLayout());
	  
	  jf.setTitle("ÃÜÂëÊäÈë¿ò");
	  jf.setSize(300,70);
	  jf.setLocation(200,200);
	  jf.setVisible(true);
	  jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
	  jf.setResizable(false);
	 }
	 @Override
	 public void actionPerformed(ActionEvent e) {
	  String ch;
	  try {
		boolean flag=false;
		  dis=new DataInputStream(new FileInputStream("D://123.txt"));
		 String pass=mi.getText();
		while(dis.available()!=0){
			  String s=dis.readLine();
			if(pass.equals(s)){
				flag=true;
				break;
			}
		}
		if(flag){
			System.out.println("µÇÂ½³É¹¦");
		}else{
			System.out.println("µÇÂ½Ê§°Ü");
		}
	} catch (FileNotFoundException e1) {
		e1.printStackTrace();
	} catch (IOException e1) {
		e1.printStackTrace();
	}

	}
}
public class Writefile {
	 public static void main(String[] args) {
	  new Wen();
		 try{
	   FileOutputStream fos=new FileOutputStream("D:\\123.txt",true);
	   DataOutputStream dos=new DataOutputStream(fos);
	   dos.writeBytes("123456");
	   dos.write("\r\n".getBytes());
	   dos.close();
	  }catch(Exception e){
	   e.printStackTrace();
	  }
	}
}