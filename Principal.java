/**
* 
* Calculator v1.0
* Zacatecas, MX
* 
* @author  Felix Tonche Valadez
* @version 1.0
* @since   2017-10-21 
*/
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