import java.awt.*; //classe awt
import java.awt.event.ActionEvent; //un interfaccia per eventi che li invia
import java.awt.event.ActionListener; // interfaccia che raccoglie e gestisce gli eventi
/**
 * Applet
 */
public class CalcolatriceApplet extends Frame implements ActionListener { //estendendo la classe frame possiamo usare i metodi che gesticono le finestre

    Label lb1, lb2, lb3; //sottoclasse awt: componente per inserire il testo   
    
    TextField txt1, txt2, txt3; //componente che permette di editare una linea di testo

    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7;//crea componente bottone rinominabile
    
    //costruttore della classe
    public CalcolatriceApplet(){

        //creazione labels
        lb1 = new Label("var 1");
        lb2 = new Label("var 2");       //creiamo gli oggetti label a cui assegnamo i seguenti nomi
        lb3 = new Label("risultato");

        //creazione campi di testo
        txt1 = new TextField(10);//linee di testo da 10 colonne
        txt2 = new TextField(10);
        txt3 = new TextField(10);

        //creazione bottoni operazioni
        btn1 = new Button("Addizione");
        btn2 = new Button("Sottrazione");
        btn3 = new Button("Moltiplicazione");
        btn4 = new Button("Divisione");
        btn5 = new Button("Modulo");
        btn6 = new Button("Reset");
        btn7 = new Button("Chiudi");

        //aggiunge i componenti alla fine del contenitore(in questo caso "Frame")
        add(lb1);
        add(txt1);
        add(lb2);
        add(txt2);
        add(lb3);
        add(txt3);
        add(btn1);
        add(btn2);
        add(btn3);
        add(btn4);
        add(btn5);
        add(btn6);
        add(btn7);
        
        //settiamo attributi del frame
        setSize(500, 500);
        setTitle("Calcolatrice");
        setLayout(new FlowLayout());//setta un layout standard 5x5

        //aggiunge lo specifico action listener ai bottoni
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);//il this corrisponde alla classe CalcolatriceApplet
        btn4.addActionListener(this);//btn1.addActionListener(CalcolatriceAppet);
        btn5.addActionListener(this);
        btn6.addActionListener(this);
        btn7.addActionListener(this);

    
    }
    //sovrascrive il metodo actionPerfromed dell'interfaccia ActionListener, dove vengono processato le operazioni
    @Override
    public void actionPerformed(ActionEvent ae){
        double a=0, b=0, c = 0;
        
        //assegniamo alle variabili a,b i valori inseriti dall'utente
        try 
         {
            a = Double.parseDouble(txt1.getText());
         }catch( NumberFormatException e){
            txt1.setText("Input non valido");
         }
         try 
         {
            b = Double.parseDouble(txt2.getText());
         }catch( NumberFormatException e){
            txt2.setText("Input non valido");
         }
         //la varibile c è il risultato delle operazioni
         if(ae.getSource()==btn1)//se l'ggetto che il metodo getSource ritorna è uguale a btn1 esegue l'if
        {
            c = a + b;
            txt3.setText(String.valueOf(c));//aggiunge al campo testo
        }
        if(ae.getSource()==btn2)
        {
            c = a - b;
            txt3.setText(String.valueOf(c));
        }
        if(ae.getSource()==btn3)
        {
            c = a * b;
            txt3.setText(String.valueOf(c));
        }
        if(ae.getSource()==btn4)
        {
            c = a / b;
            txt3.setText(String.valueOf(c));
        }
        if(ae.getSource()==btn5)
        {
            c = a % b;
            txt3.setText(String.valueOf(c));
        }
        if(ae.getSource()==btn6)
        {
            txt1.setText("0");
            txt2.setText("0");
            txt3.setText("0");
        }
        if(ae.getSource()==btn7)
        {
            System.exit(0);//chiude l'applicazione           
        }

        
    }
    public static void main(String[] args)
    {
        CalcolatriceApplet cal = new CalcolatriceApplet();
        
        cal.setVisible(true);//rende visibile l'app

        cal.setLocation(300,300);//la posizione all'interno dello schermo
    }
    
    
}