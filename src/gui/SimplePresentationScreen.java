package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.Student;
import javax.swing.JTabbedPane;
import java.awt.Toolkit;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.util.Calendar;
import java.util.GregorianCalendar;

@SuppressWarnings("serial")
public class SimplePresentationScreen extends JFrame {

	private JPanel contentPane;
	private JPanel tabInformation;
	private JTabbedPane tabbedPane;
	private Student studentData;

	public SimplePresentationScreen(Student studentData) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(SimplePresentationScreen.class.getResource("/images/tdp.png")));
		this.studentData = studentData;
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setTitle("TdP-DCIC-UNS 2022 :: Pantalla de presentaci\u00F3n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(615, 274));
		setResizable(false);
		setContentPane(contentPane);
		
		init();
	}
	
	private void init() {
		// Tabbed Pane to student personal data
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(5, 5, 430, 201);
		tabInformation = new JPanel();
		tabInformation.setPreferredSize(new Dimension(425, 275));
		tabbedPane.addTab("Información del alumno", null, tabInformation, "Muestra la información declarada por el alumno");
		tabInformation.setLayout(null);
		
		JTextArea textArea_LU = new JTextArea();
		textArea_LU.setBounds(92, 11, 309, 22);
		tabInformation.add(textArea_LU);
		int lu=studentData.getId();
		contentPane.setLayout(null);
		textArea_LU.setText(String.valueOf(lu));
		
		JTextArea textArea_Apellido = new JTextArea();
		textArea_Apellido.setBounds(92, 41, 309, 22);
		tabInformation.add(textArea_Apellido);
		contentPane.add(tabbedPane);
		textArea_Apellido.setText(studentData.getLastName());
		
		
		JTextArea textArea_Nombre = new JTextArea();
		textArea_Nombre.setBounds(92, 74, 309, 22);
		tabInformation.add(textArea_Nombre);
		textArea_Nombre.setText(studentData.getFirstName());
		
		JTextArea textArea_Email = new JTextArea();
		textArea_Email.setBounds(92, 107, 309, 22);
		tabInformation.add(textArea_Email);
		textArea_Email.setText(studentData.getMail());
		
		
		JTextArea textArea_Github = new JTextArea();
		textArea_Github.setBounds(92, 140, 309, 22);
		tabInformation.add(textArea_Github);
		textArea_Github.setText(studentData.getGithubURL());
		
		
		JLabel lblLU = new JLabel("LU");
		lblLU.setBounds(10, 16, 46, 14);
		tabInformation.add(lblLU);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(10, 45, 46, 14);
		tabInformation.add(lblApellido);
		
		JLabel lblLabelNombre = new JLabel("Nombre");
		lblLabelNombre.setBounds(10, 79, 46, 14);
		tabInformation.add(lblLabelNombre);
		
		JLabel lblLabelEmail = new JLabel("E-Mail");
		lblLabelEmail.setBounds(10, 112, 46, 14);
		tabInformation.add(lblLabelEmail);
		
		JLabel lblLableGitHub = new JLabel("GitHub Url");
		lblLableGitHub.setBounds(10, 145, 60, 14);
		tabInformation.add(lblLableGitHub);
		
		
		
		JLabel lblLLabel_Imagen = new JLabel("");
		lblLLabel_Imagen.setBounds(450, 43, 139, 144);
		lblLLabel_Imagen.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblLLabel_Imagen);
		ImageIcon image=new ImageIcon(SimplePresentationScreen.class.getResource(studentData.getPathPhoto()));
		Icon imagen=new ImageIcon(image.getImage().getScaledInstance(lblLLabel_Imagen.getWidth(),lblLLabel_Imagen.getHeight(), Image.SCALE_DEFAULT));
		lblLLabel_Imagen.setIcon(imagen);
		
		JLabel lblHoraYDia = new JLabel("");
		lblHoraYDia.setBounds(15, 210, 394, 14);
		contentPane.add(lblHoraYDia);
		setearHoraYFecha(lblHoraYDia);
		
		
	}
	
	private void setearHoraYFecha(JLabel aSetear){
		Calendar fecha=new GregorianCalendar();
		String fechaCompleta=String.format("%02d/%02d/%02d",fecha.get(Calendar.DATE),fecha.get(Calendar.MONTH)+1,fecha.get(Calendar.YEAR));
		String horaCompleta=String.format("%02d:%02d:%02d",fecha.get(Calendar.HOUR_OF_DAY),fecha.get(Calendar.MINUTE),fecha.get(Calendar.SECOND));
		
		aSetear.setText("Esta ventana fue generada el "+fechaCompleta+" a las "+horaCompleta);
	}
	
}
