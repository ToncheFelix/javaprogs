import javax.swing.*;
import javax.swing.JFrame;
import java.awt.event.*;
import java.awt.Color;
import java.lang.*;
import java.lang.Integer;
import java.awt.Font;
import java.lang.Math.*;
import java.io.*;
 class Calculadora extends JFrame implements ActionListener{
  private JTextField Pantalla;
  private JButton Botones[];
  //                   0    1   2   3   4  5   6   7   8   9   10  11  12    suma      div  15  16   17     raiz     19   20   exponente2   22    23      24
  //                   0    1   2   3   4  5   6   7   8   9   10  11  12     13       14    15  16     17      18        19   20    21        22      23      24     25     26    27    28   29     30     31     32    33    34  35  36
  String[] Etiquetas={"9","8","7","6","5","4","3","2","1","0",".","+","-","\u00D7","\u00F7","=","AC","\u2190","\u221A","\u00B1","%","x"+"\u00B2","C","Std/C","Exit","1/x","Sin","Cos","Tan","x^y","aSin","aCos","aTan","e^x","e","\u03C0","ln"};
  private double  Memory1,Memory2,Result,aux;//Operaciones varias
  private int x=1,y=41,xs=70,ys=40,sepx=71,sepy=41,Opp=0,yc=0;//sepx=x+xs||sepy=sepx °°Opp ejm n1 +- n2
  String Operacion, Screentxt="",auxtxt;
  private boolean press=false;
 protected Calculadora(){
   super("JTonch Calc");
   setVisible(true);
   setLayout(null);
   setSize(291,316);
   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   getContentPane().setBackground(new java.awt.Color(0,0,0));
   
   Pantalla =new JTextField(30);
   Font fuente = new Font("Arial", 0, 18);
   Font fuentecontr = new Font("Arial", 0, 12);  
   Font fuente2 = new Font("Arial", 0, 16);
   Font fuente3 = new Font("Arial", 0, 13);

   Pantalla.setFont(fuente);
   Pantalla.setHorizontalAlignment(JTextField.LEFT);  
   Pantalla.setBounds(x,1,4*sepx-1,ys);
   add(Pantalla);
   Botones =new JButton[37]; 
      for(int i=0;i<37;i++){
       Botones[i]=new JButton(Etiquetas[i]);
       if(i>9 && i<37){
        Botones[i].setFont (fuente3);//125, 125, 130
        Botones[i].setBackground(new java.awt.Color(69, 68, 75));
       }else{
       Botones[i].setFont (fuente2);
       Botones[i].setBackground(new java.awt.Color(125, 125, 130));}
       Botones[i].setForeground(java.awt.Color.white);
       add(Botones[i]);
       Botones[i].addActionListener(this);
       }
      Botones[16].setBackground(new java.awt.Color(25, 25, 28));
      Botones[22].setBackground(new java.awt.Color(25, 25, 28));
      Botones[17].setBackground(new java.awt.Color(25, 25, 28));   
      Botones[23].setBackground(new java.awt.Color(25, 25, 28));   
      Botones[24].setBackground(java.awt.Color.RED);   
      Botones[16].setBounds(x,y,xs-(xs/4),ys);//CE
      Botones[16].setFont (fuentecontr);
      Botones[22].setBounds(x+xs-(xs/4),y,xs-(xs/4),ys);//C
      Botones[22].setFont (fuentecontr);
      Botones[17].setBounds(x+2*(xs-(xs/4)),y,xs-(xs/4),ys);//del
      Botones[17].setFont (fuentecontr);
      Botones[23].setBounds(x+1+3*(xs-(xs/4)),y,xs-(xs/15),ys);//ctf
      Botones[23].setFont (fuentecontr);
      Botones[24].setBounds(x+2+3*(xs-(xs/4))+xs-(xs/15),y,xs-(xs/5),ys);//exit
      Botones[24].setFont (fuentecontr);

      Botones();
  }
public void actionPerformed(ActionEvent e)
  {    //----------------------Números----------------------------//

      if(e.getSource()==Botones[10])// (punto)
         {  
            Screentxt=Pantalla.getText();
            if(Screentxt.length()<=0)
              {
                Pantalla.setText("0.");
                
              }
              else if(!punto(Pantalla.getText()))
                 {
                   if((Pantalla.getText()).equals("-"))
                    Pantalla.setText(Pantalla.getText()+"0.");
                    else
                   Pantalla.setText(Pantalla.getText()+".");
                   }
         }    
     if(e.getSource()==Botones[0])//9
         {
          Pantalla.setText(Pantalla.getText()+"9");
         }
     if(e.getSource()==Botones[1])//8
         {
          Pantalla.setText(Pantalla.getText()+"8");
         }
     if(e.getSource()==Botones[2])//7
         {
          Pantalla.setText(Pantalla.getText()+"7");
         } 
     if(e.getSource()==Botones[3])//6
        {
          Pantalla.setText(Pantalla.getText()+"6");
         } 
     if(e.getSource()==Botones[4])//5
        {
          Pantalla.setText(Pantalla.getText()+"5");
        }  
     if(e.getSource()==Botones[5])//4
        {
         Pantalla.setText(Pantalla.getText()+"4");
        } 
     if(e.getSource()==Botones[6])//3
        {
        Pantalla.setText(Pantalla.getText()+"3");
        } 
     if(e.getSource()==Botones[7])//2
        {
        Pantalla.setText(Pantalla.getText()+"2");
        }
     if(e.getSource()==Botones[8])//1
        {
        Pantalla.setText(Pantalla.getText()+"1");
        } 
     if(e.getSource()==Botones[9])//0
        { 
        Pantalla.setText(Pantalla.getText()+"0");
        }
//----------------------End_Números----------------------------//
//----------------------Opciones Cal----------------------------//
      if(e.getSource()==Botones[11])// Suma  
   {Opp=1;         
            if(!(Pantalla.getText()).equals(""))
             {  if (!(Pantalla.getText()).equals("-"))//condición contra error por cambio entre opradores
                Memory1=Double.parseDouble(Pantalla.getText()); 
                Pantalla.setText("");
                Operacion="+";
              }
        }
        if(e.getSource()==Botones[12])// Resta
          {
             if(!(Pantalla.getText()).equals("")){
                  if (!(Pantalla.getText()).equals("-")) //condición contra error por cambio entre opradores
                      Memory1=Double.parseDouble(Pantalla.getText()); 
                  Pantalla.setText("");
                 }
                  else if((Pantalla.getText()).equals("")){
                      Pantalla.setText("-");
                     }
            if(Opp==0)
           Operacion="-";
        }  
      if(e.getSource()==Botones[13])// Multiplicación 
        {  Opp=1;
           if(!(Pantalla.getText()).equals(""))
             {  if (!(Pantalla.getText()).equals("-"))//condición contra error por cambio entre opradores
                    Memory1=Double.parseDouble(Pantalla.getText()); 
                Pantalla.setText("");
                Operacion="*";
             }
        }
      if(e.getSource()==Botones[14])// División
        {
            Opp=1;
            if(!(Pantalla.getText()).equals(""))
             {if (!(Pantalla.getText()).equals("-"))//condición contra error por cambio entre opradores
              Memory1=Double.parseDouble(Pantalla.getText()); 
              Pantalla.setText("");
              Operacion="/";
             }
        }
       if(e.getSource()==Botones[20])//  %
          {
               Opp=1;
                if(!(Pantalla.getText()).equals(""))
                   {  if (!(Pantalla.getText()).equals("-"))//condición contra error por cambio entre opradores
                          Memory1=Double.parseDouble(Pantalla.getText()); 
                      Pantalla.setText("");
                      Operacion="%";
                   }
           }    

      if(e.getSource()==Botones[16])// AC all clear
          { 
           Pantalla.setText(""); 
           Memory1=0;
           Memory2=0;
          } 
      if(e.getSource()==Botones[17])//  Retroceso
          {   Screentxt = Pantalla.getText(); 
              Operacion="del";
            if(Screentxt.length()>0){
                Screentxt = Screentxt.substring(0,Screentxt.length()-1);
                Pantalla.setText(Screentxt);
                } 
            if(Screentxt.length()==0){
              Screentxt="";
              Pantalla.setText(Screentxt);
              }
          }
       if(e.getSource()==Botones[18])//  sqrt
      {
           if(!(Pantalla.getText()).equals("")){
           aux=Double.parseDouble(Pantalla.getText());
           aux=Math.sqrt(aux); 
           Pantalla.setText(Double.toString(redon(aux,10)));}
           } 
      if(e.getSource()==Botones[19])//  +-
          {
               if(!(Pantalla.getText()).equals("")){
               aux=Double.parseDouble(Pantalla.getText());
               aux*=-1; 
               Pantalla.setText(Double.toString(aux));}
           }     
       if(e.getSource()==Botones[21])//  exponente 2
          {
               if(!(Pantalla.getText()).equals("")){
               aux=Double.parseDouble(Pantalla.getText());
               aux*=aux; 
               Pantalla.setText(Double.toString(aux));}
           }      
       if(e.getSource()==Botones[22])// C clear Display
          { 
           Pantalla.setText(""); 
          }  
       if(e.getSource()==Botones[23])// Change to Cientic Calculator
          { 
            if(press==false){
              y+=ys*3+3;setSize(291,316+ys*3+3); 
              press=true;
             }else if(press==true){
            y-=ys*3+3;setSize(291,316); 
            press=false;
            }
            Botones(); 
          } 
          if(e.getSource()==Botones[25])//  inverso
          {
               if(!(Pantalla.getText()).equals("")){
               aux=Double.parseDouble(Pantalla.getText());
               aux=Math.pow(aux,-1); 
               Pantalla.setText(Double.toString(aux));}
           }
           if(e.getSource()==Botones[26])//  Seno
          {
               if(!(Pantalla.getText()).equals("")){
               aux=Double.parseDouble(Pantalla.getText());
               aux=Math.sin(aux); 
               Pantalla.setText(Double.toString(aux));}
           }
           if(e.getSource()==Botones[27])//  Coseno
          {
               if(!(Pantalla.getText()).equals("")){
               aux=Double.parseDouble(Pantalla.getText());
               aux=Math.cos(aux); 
               Pantalla.setText(Double.toString(aux));}
           }
           if(e.getSource()==Botones[28])//  Tangente
          {
               if(!(Pantalla.getText()).equals("")){
               aux=Double.parseDouble(Pantalla.getText());
               aux=Math.tan(aux); 
               Pantalla.setText(Double.toString(aux));}
           }
          if(e.getSource()==Botones[29])//  exponente y
          {  Opp=1;

               if(!(Pantalla.getText()).equals(""))
                Memory1=Double.parseDouble(Pantalla.getText()); 
                Pantalla.setText("");
                Operacion="powy";
           } 
           if(e.getSource()==Botones[30])//  arcSeno
          {
               if(!(Pantalla.getText()).equals("")){
               aux=Double.parseDouble(Pantalla.getText());
               aux=Math.asin(aux); 
               Pantalla.setText(Double.toString(aux));}
           }   
           if(e.getSource()==Botones[31])//  arcCos
          {
               if(!(Pantalla.getText()).equals("")){
               aux=Double.parseDouble(Pantalla.getText());
               aux=Math.acos(aux); 
               Pantalla.setText(Double.toString(aux));}
           } 
            if(e.getSource()==Botones[32])//  arcTan
          {
               if(!(Pantalla.getText()).equals("")){
               aux=Double.parseDouble(Pantalla.getText());
               aux=Math.atan(aux); 
               Pantalla.setText(Double.toString(aux));}
           }  
            if(e.getSource()==Botones[33])//  e^x
          {
               if(!(Pantalla.getText()).equals("")){
               aux=Double.parseDouble(Pantalla.getText());
               aux=Math.exp(aux); 
               Pantalla.setText(Double.toString(aux));}
           }
           if(e.getSource()==Botones[34])//  e
          {     
               if((Pantalla.getText()).equals("")){
               Pantalla.setText(Double.toString(Math.E));
             }else{
                 aux=Double.parseDouble(Pantalla.getText());
                 Pantalla.setText(Double.toString(Math.E*aux));}
           }
            if(e.getSource()==Botones[35])//  π
          {     
               if((Pantalla.getText()).equals("")){
               Pantalla.setText(Double.toString(Math.PI));
             }else{
                 aux=Double.parseDouble(Pantalla.getText());
                 Pantalla.setText(Double.toString(Math.PI*aux));
             }
           }
          if(e.getSource()==Botones[36])//  ln
          {
               if(!(Pantalla.getText()).equals("")){
               aux=Double.parseDouble(Pantalla.getText());
               aux=Math.log(aux); 
               Pantalla.setText(Double.toString(aux));}
           }  

          if(e.getSource()==Botones[24])// exit
          { System.exit(0);}           
//----------------------Igual----------------------------//
      if(e.getSource()==Botones[15]) 
      {
         Opp=0;
         if(!(Pantalla.getText()).equals("")){
            if(Operacion=="+")
              {  
                 Memory2=Double.parseDouble(Pantalla.getText());

                 Pantalla.setText(Double.toString(Memory1+Memory2));
              }
            if(Operacion=="-")
              { 
                 Memory2=Double.parseDouble(Pantalla.getText());
                 
                 if(Memory1 == 0)
                  Pantalla.setText(Double.toString(Memory2-Memory1));
                 else 
                 Pantalla.setText(Double.toString(Memory1-Memory2)); 
              }
            if(Operacion=="*")
              {  
                Memory2=Double.parseDouble(Pantalla.getText());
                 Pantalla.setText(Double.toString(Memory1*Memory2)); 
              }
            if(Operacion=="/")
              {  
                Memory2=Double.parseDouble(Pantalla.getText());
                 Pantalla.setText(Double.toString(Memory1/Memory2));
              }//end to /
              if(Operacion=="%")
              {  
                Memory2=Double.parseDouble(Pantalla.getText());
                 Pantalla.setText(Double.toString((Memory1*Memory2)/100)); 
              }
              if(Operacion=="del")
              {  
                Memory1=Double.parseDouble(Pantalla.getText()); //al dar igual no haya problema con del
                 Pantalla.setText(Double.toString(Memory1)); 
              }
              if(Operacion=="powy")
              {  
                Memory2=Double.parseDouble(Pantalla.getText()); 
                Pantalla.setText(Double.toString( Math.pow( Memory1,Memory2)  )); 
              }  
              else{
                 Memory1=Double.parseDouble(Pantalla.getText()); //al dar igual queda lo de memory 1
                 Pantalla.setText(Double.toString(Memory1)); 
                 Operacion="null";
               }
          }//condición =
      }//fin deBoton igual
   }//end of botones eventos.
   public static boolean punto(String Screentxt)
    {
      boolean p = false;
     for(int i=0;i<Screentxt.length();i++)
         {
           if(Screentxt.substring(i,i+1).equals(".")){
             p = true;
             break;
           }
         }
         return p;
    }
public  void Botones()
 {
//-----------------------------------------------------------------------------------
    Botones[25].setBounds( x,        yc+2*sepy, xs, ys);//x^-1
    Botones[26].setBounds( x+sepx,   yc+2*sepy, xs, ys);//sin
    Botones[27].setBounds( x+2*sepx, yc+2*sepy, xs, ys);//cos
    Botones[28].setBounds(x+3*sepx, yc+2*sepy,xs,ys);// tan

    Botones[29].setBounds( x,        yc+3*sepy,xs, ys);//x^y
    Botones[30].setBounds( x+sepx,   yc+3*sepy, xs, ys);//asin
    Botones[31].setBounds( x+2*sepx, yc+3*sepy, xs, ys);//acos
    Botones[32].setBounds(x+3*sepx, yc+3*sepy,xs,ys);// atan
    
    Botones[33].setBounds( x,        yc+4*sepy, xs, ys);// exp
    Botones[34].setBounds( x+sepx,   yc+4*sepy, xs, ys);// e
    Botones[35].setBounds( x+2*sepx, yc+4*sepy, xs, ys);// π  
    Botones[36].setBounds(x+3*sepx, yc+4*sepy,xs,ys);//  ln
  if(press==true){
    for(int j=25;j<37;j++){
        Botones[j].setVisible(true);}
  }else{
    for(int j=25;j<37;j++){
        Botones[j].setVisible(false);}
  }
//-----------------------------------------------------------------------------------
    Botones[21].setBounds(x+2*sepx,y+sepy,xs,ys);//^2
    Botones[18].setBounds(x+sepx,y+sepy,xs,ys);//√
    Botones[20].setBounds(x,y+sepy,xs,ys);//%
    Botones[14].setBounds(x+3*sepx,y+sepy,xs,ys);// (/)

    Botones[2].setBounds( x,        y+2*sepy, xs, ys);//7
    Botones[1].setBounds( x+sepx,   y+2*sepy, xs, ys);//8
    Botones[0].setBounds( x+2*sepx, y+2*sepy, xs, ys);//9
    Botones[13].setBounds(x+3*sepx, y+2*sepy,xs,ys);// (x)

    Botones[5].setBounds( x,        y+3*sepy, xs, ys);//4
    Botones[4].setBounds( x+sepx,   y+3*sepy, xs, ys);//5
    Botones[3].setBounds( x+2*sepx, y+3*sepy, xs, ys);//6
    Botones[12].setBounds(x+3*sepx, y+3*sepy,xs,ys);// (-)
    
    Botones[8].setBounds( x,        y+4*sepy, xs, ys);//1
    Botones[7].setBounds( x+sepx,   y+4*sepy, xs, ys);//2
    Botones[6].setBounds( x+2*sepx, y+4*sepy, xs, ys);//3
    Botones[11].setBounds(x+3*sepx, y+4*sepy,xs,ys);// (+)
   
    Botones[10].setBounds( x,           y+5*sepy, xs, ys);//.
    Botones[9].setBounds( x+sepx,       y+5*sepy, xs, ys);// 0
    Botones[19].setBounds( x+2*sepx,    y+5*sepy, xs, ys);// +/-
    Botones[15].setBounds( x+3*sepx,    y+5*sepy, xs, ys);//=
 }
    public static double redon(double valor, int decimales) {
    double escala = Math.pow(10, decimales);
    return Math.round(valor * escala) / escala;
  }
 }//fin de la clase