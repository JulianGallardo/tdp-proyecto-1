package launcher;

import javax.swing.JFrame;

import entities.Student;
import gui.SimplePresentationScreen;

public class Launcher {
	public static void main(String [] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	Student user=new Student(135005,"Gallardo","Julian","Juliangallardo26603@gmail.com","https://github.com/JulianGallardo","/images/logo-uns.png");
            	JFrame gui=new SimplePresentationScreen(user);
            	gui.setVisible(true);
            }
        });
    }
}