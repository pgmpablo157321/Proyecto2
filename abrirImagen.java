import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;



public class abrirImagen {

	private JFrame frame;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					abrirImagen window = new abrirImagen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public abrirImagen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnExplorar = new JButton("Explorar");
		btnExplorar.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent arg0) {
				    JFileChooser selector=new JFileChooser();
				    int resultado=selector.showOpenDialog(null);
				    if(resultado==JFileChooser.APPROVE_OPTION){
				     File imagen =selector.getSelectedFile();
				     GUI a = new GUI(imagen);
				     frame.setVisible(false);
				    }
			 }
			 		
			 		
		});
		btnExplorar.setBounds(177, 216, 117, 25);
		frame.getContentPane().add(btnExplorar);
		
		JLabel lblSeleccionarImagen = new JLabel("Seleccionar Imagen");
		lblSeleccionarImagen.setBounds(172, 101, 175, 15);
		frame.getContentPane().add(lblSeleccionarImagen);
	}
}