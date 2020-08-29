
import javax.swing.JFrame;

class Principal 
 {
  public static void main(String args[])
   {
    Calculadora obj=new Calculadora();

      obj.setBounds(500,300,291,316);
      obj.setVisible(true);
      obj.setResizable(false);
      obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
   }

}