import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class Main {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[][] = new int[5][6];
		Scanner in = new Scanner(System.in);
		try {
			
			BufferedImage img = ImageIO.read(new File("C:/Users/Asus/workspace/ImageResize/src/Castillo.jpg"));
			resizePicture b = new resizePicture(img);
//			 BufferedImage img2=new BufferedImage(img.getWidth(),img.getHeight(),BufferedImage.TYPE_3BYTE_BGR);
//			 for(int i=0;i<img.getHeight();i++){
//			 for(int j=0;j<img.getWidth();j++){
//			 img2.setRGB(j, i, b.getEnergy()[i][j]>10000?Color.RED.getRGB():Color.BLACK.getRGB());
//			 }
//			 }
//			 ImageIO.write(img2, "png", new File("C:/Users/Asus/workspace/ImageResize/src/Energia.jpg"));
//			 b.showVerticalPath();
			 b.verticalCut(100);

			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	}

}
