package sbudiman;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class impiccato {
	//GUI
	private JFrame frame;
	Panel panel = new Panel();
	Panel panel_1 = new Panel();
	TextField tfparola = new TextField();
	TextField tfprova = new TextField();
	TextArea talettere = new TextArea();
	Button btnCrea = new Button("Crea");
	Label lblp[];
	Label lblt[];
	JLabel lblbase0 = new JLabel("");
	JLabel lblbase1 = new JLabel("");
	JLabel lblbase2 = new JLabel("");
	JLabel lblbase3 = new JLabel("");
	JLabel lblbase4 = new JLabel("");
	JLabel lblbase5 = new JLabel("");
	JLabel lblbase6 = new JLabel("");
	Label lbltentativi = new Label("Tentativi:0/6");
	// 
	
	//Attributi
	char[] apdi;
	String paroladaindovinare;
	String parolaindividuata;
	String lettera;
	int numerotentativi;
	int t=0;
	int controllino = 0;
	boolean vinto;
	boolean supporto=false;
	// 

	public static void main(String[] args)
	{
		impiccato window = new impiccato();
		window.frame.setVisible(true);
	}

		public impiccato()
		{
		//PROSSIMAMENTE: int pulsanti = JOptionPane.YES_NO_OPTION; // Pulsanti si/no
		//PROSSIMAMENTE: int rispulsanti = JOptionPane.showConfirmDialog (null, "","Benvenuto",pulsanti); // Questa variabile salva la decisione che prossimamente verrà confrontata.
		JOptionPane.showMessageDialog(null, "Benvenuto, stai per iniziare una nuova partita al gioco dell'impiccato! \n Non ricordi come si gioca? \n Un giocatore sceglie una parola, essa viene nascosta però come indizio c'è il numero delle lettere. \n Il nostro sistema le predispone automaticamente. \n L'altro giocatore, invece, dovrà trovare la parola. \n Ti chiederai: come? \n Chiamando delle lettere o parole, fai attenzione alle maiuscole/minuscole. \n Alla fine riuscirai ad individuare la parola, scrivila nel campo testo e vincerai. \n (Se prima non hai esaurito tutti i tuoi tentativi (6)) ^_^\n Buon divertimento.");
		frame = new JFrame("L'impiccato");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(impiccato.class.getResource("/sbudiman/immagini/16x16.png")));
		frame.setBounds(100, 100, 737, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(panel);
		panel.setBackground(Color.ORANGE);
		panel.setLayout(null);
		
		lblbase0.setBounds(351, 63, 201, 199);
		lblbase0.setIcon(new ImageIcon(impiccato.class.getResource("/sbudiman/immagini/0.png")));
		lblbase1.setBounds(351, 63, 201, 199);
		lblbase1.setIcon(new ImageIcon(impiccato.class.getResource("/sbudiman/immagini/1.png")));
		lblbase2.setBounds(351, 63, 201, 199);
		lblbase2.setIcon(new ImageIcon(impiccato.class.getResource("/sbudiman/immagini/2.png")));
		lblbase3.setBounds(351, 63, 201, 199);
		lblbase3.setIcon(new ImageIcon(impiccato.class.getResource("/sbudiman/immagini/3.png")));
		lblbase4.setBounds(351, 63, 201, 199);
		lblbase4.setIcon(new ImageIcon(impiccato.class.getResource("/sbudiman/immagini/4.png")));
		lblbase5.setBounds(351, 63, 201, 199);
		lblbase5.setIcon(new ImageIcon(impiccato.class.getResource("/sbudiman/immagini/5.png")));
		lblbase6.setBounds(351, 63, 201, 199);
		lblbase6.setIcon(new ImageIcon(impiccato.class.getResource("/sbudiman/immagini/6.png")));
		lblbase1.setVisible(false);
		lblbase2.setVisible(false);
		lblbase3.setVisible(false);
		lblbase4.setVisible(false);
		lblbase5.setVisible(false);
		lblbase6.setVisible(false);
		panel.add(lblbase0);
		panel.add(lblbase1);
		panel.add(lblbase2);
		panel.add(lblbase3);
		panel.add(lblbase4);
		panel.add(lblbase5);
		panel.add(lblbase6);
		panel_1.setBounds(-299, 0, 583, 311);
		panel.add(panel_1);
		
		panel_1.setBackground(Color.RED);
		panel_1.setLayout(null);

		//Immagini impiccato
		
		tfparola.setText("Inserisci parola da indovinare");
		tfparola.setBounds(306, 66, 268, 22);
		panel_1.add(tfparola);
		
		btnCrea.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnCrea.setBounds(306, 94, 268, 22);
		panel_1.add(btnCrea);
		
		tfprova.setText("Tenta la fortuna inserendo una lettera o una parola");
		tfprova.setBounds(306, 66, 268, 22);
		panel_1.add(tfprova);
		
		Button btnprova = new Button("Prova!");
		btnprova.setBounds(306, 94, 268, 22);
		panel_1.add(btnprova);
		
		talettere.setEditable(false);
		talettere.setBounds(299, 171, 285, 140);
		panel_1.add(talettere);
		lbltentativi.setAlignment(Label.CENTER);
		lbltentativi.setBounds(299, 10, 285, 22);
		panel_1.add(lbltentativi);
		
		Label label = new Label("Se la parola \u00E8 molto lunga, allarga la finestra ^_^");
		label.setBackground(Color.ORANGE);
		label.setAlignment(Label.CENTER);
		label.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 12));
		label.setBounds(284, 289, 437, 22);
		panel.add(label);
		
		//Listener
		btnCrea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				paroladaindovinare = tfparola.getText();
				tfparola.setText(null);
				nuovaparola();
				tfparola.setVisible(false);
				btnCrea.setVisible(false);
			}
		});
		
		btnprova.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				controllino++;
				int l = tfprova.getText().length();
				if(talettere.getText().equalsIgnoreCase(tfprova.getText()))
				{
					tfprova.setText("Hai già provato ad inserire questa lettera.");
				}
				if(tfprova.getText().equals("Hai già provato ad inserire questa lettera."))
				{
					tfprova.setText(null);
				}
					if(l == 1)
					{
						nuovalettera();
						confrontalettera(lettera);
					}
					else
					{
						confrontaparola();
					}
				
			}
		});
		
		tfprova.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                tfprova.setText("");
            }
        });
		
		tfparola.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                tfparola.setText("");
            }
        });
		//
		
		//PROSSIMAMENTE: if(rispulsanti == JOptionPane.YES_OPTION) // Condizione che verifica la risposta, se sì agisce impostando tutto in versione minimal
		//{
		//}
	}

	//Funzioni
	void nuovaparola() 
	{
		int a=470;
		int l=paroladaindovinare.length();
		lblp=new Label[l];
		lblt=new Label[l];
		btnCrea.setEnabled(false);
		
		
		for(int i = 0; i < l; i++)
		{
			apdi=paroladaindovinare.toCharArray();
		    System.out.println(apdi[i]);
		    
			try
			{
				Thread.sleep(100);
			} 
			catch (InterruptedException e1) 
			{
				e1.printStackTrace();
			}
			
			System.out.println(i);
			lblp[i]=new Label();
			lblp[i].setText(String.valueOf(apdi[i]));
			lblp[i].setFont(new Font("Dialog", Font.PLAIN, 12));
			lblp[i].setBounds(a, 263, 20, 15);
			lblp[i].setVisible(false);
			panel.add(lblp[i]);
			lblt[i]=new Label("_");
			lblt[i].setFont(new Font("Dialog", Font.PLAIN, 12));
			lblt[i].setBounds(a, 263, 10, 20);
			panel.add(lblt[i]);
			a=a+19;
			
		}
		
	}
	
	void nuovalettera()
	{
		tfprova.getText();
		lettera=tfprova.getText();
	}
	
	boolean confrontalettera(String lettera) 
	{
		System.out.println("[DEBUG]: Funzione confrontalettera");
		int l=paroladaindovinare.length();
		
	
		if(paroladaindovinare.contains(lettera))
		{
					
					for(int i = 0; i < l; i++)
					{
						if(lettera.equalsIgnoreCase(String.valueOf(apdi[i])))
						{
							lblp[i].setVisible(true);
							System.out.println("[DEBUG]: Nella posizione "+i+" "+"è stata trovata una lettera");
		
						}
						
					}
			
				
			
	   }
	   else
	   {
		  tentativiesauriti();
	   }
			return supporto;
	}
	
	boolean confrontaparola()
	{
		System.out.println("[DEBUG]: Funzione confrontaparola");
		if(tfprova.getText().equalsIgnoreCase(paroladaindovinare))
		{
			vinto=true;
			System.out.println("[DEBUG]: Hai vinto");
			ParolaIndovinata();
			return true;
		}
		else
		{
			tentativiesauriti();
		}
		return false;
	}
	
	boolean tentativiesauriti() 
	{
		System.out.println("[DEBUG]: Funzione tentativiesauriti");
		
		if(t==0)
		{
			lblbase1.setVisible(true);
		}
		if(t==1)
		{
			lblbase2.setVisible(true);
		}
		if(t==2)
		{
			lblbase3.setVisible(true);
		}
		if(t==3)
		{
			lblbase4.setVisible(true);
		}
		if(t==4)
		{
			lblbase5.setVisible(true);
		}

		
			if(t==5)
			{
				lblbase6.setVisible(true);
				lbltentativi.setText("Tentativi:6/6");
				JOptionPane.showMessageDialog(null, "Hai perso, sei uno sbudiman");
				frame.dispose();
			}
			else
			{
				System.out.println("Incremento t");
				t++;
				lbltentativi.setText("Tentativi:"+t+"/6");
				talettere.setText(talettere.getText()+tfprova.getText()+",");
			}
			

		
		
		
		return true;
		
	}
	
	boolean ParolaIndovinata()
	{
		System.out.println("[DEBUG]: Funzione ParolaIndovinata");
		int l=paroladaindovinare.length();
		if(vinto==true)
		{
			for(int i=0; i<l; i++)
			{
			lblp[i].setVisible(true);
			}
			JOptionPane.showMessageDialog(null, "Hai vinto, sei uno sbudiman bello");
			frame.dispose();
		}
		return false;
	}
	//
}
