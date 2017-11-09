import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class GUI{

	private JFrame frame;
	int alto, ancho;
	JSlider slider;
	JSlider slider_1;
	ImagePanel a;
	private JButton btnGuardar;
	BufferedImage recortada;
	
	float x=0;
    float y=0;
    float anchoo=0;
    float altoo=0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI(new File("/home/ssuarezz/Imágenes/Proyecto2.jpeg"));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	
	/**
	 * @wbp.parser.entryPoint
	 */
	public GUI(File f) {
		initialize(f);
		frame.setVisible(true);
	}
	

	
	private void initialize(File f) {
		a=new ImagePanel(new File("/home/ssuarezz/Imágenes/Proyecto2.jpeg"));
		a.setBounds(49,51,a.getImage().getWidth()+50,a.getImage().getHeight()+70);
		a.setLayout(null);
		frame = new JFrame();
		frame.setBounds(50, 50, a.getImage().getWidth()+80, a.getImage().getHeight()+150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(a, a.getBounds());
		
		JButton btnRedimencionar = new JButton("Redimensonar");
		btnRedimencionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					for(int i=0;i<ancho-slider.getValue();i++){
						a.r.showVerticalPath();
						a.setImage(a.r.getImg());
						a.paint(a.getGraphics());
						frame.repaint();
						Thread.sleep(20);
						a.r.verticalCut(1);
						a.setImage(a.r.getImg());
						a.paint(a.getGraphics());
						Thread.sleep(20);
						frame.repaint();
					}
					ancho=slider.getValue();
					for(int i=0;i<slider_1.getValue()-alto;i++){
						a.r.showHorizontalPath();
						a.setImage(a.r.getImg());
						a.paint(a.getGraphics());
						frame.repaint();
						Thread.sleep(20);
						a.r.horizontalCut(1);
						a.setImage(a.r.getImg());
						a.paint(a.getGraphics());
						Thread.sleep(20);
						frame.repaint();
					}
					alto=slider_1.getValue();
				}catch (IOException | InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
				
				
				
			}
		});
		btnRedimencionar.setBounds((a.getImage().getWidth()-60)/2,a.getImage().getHeight()+10,136,20);
		a.add(btnRedimencionar);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				recortada=a.getImage();
				try {
					ImageIO.write(recortada,"jpg", new File("Recorte de " +f.getName()));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	            JOptionPane.showMessageDialog(null, "Se ha guardado Correctamente la imagen recortada");;
			}
		});
		btnGuardar.setBounds((a.getImage().getWidth()-60)/2,a.getImage().getHeight()+40,136,20);
		a.add(btnGuardar);
		
		slider = new JSlider();
		slider.setBounds(49, 12, a.getImage().getWidth(), 26);
		slider.setMaximum(a.getImage().getWidth());
		slider.setValue(slider.getMaximum());
		frame.getContentPane().add(slider);
		ancho=a.getImage().getWidth();
		
		slider_1 = new JSlider();
		slider_1.setOrientation(SwingConstants.VERTICAL);
		slider_1.setBounds(12, 51, 26, a.getImage().getHeight());
		slider_1.setMaximum(a.getImage().getHeight());
		slider_1.setValue(0);
		frame.getContentPane().add(slider_1);
		alto=0;
	}


}
