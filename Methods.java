import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class Methods {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[][]=new int[5][6];
		Scanner in=new Scanner(System.in);
		try {
			BufferedImage img=ImageIO.read(new File("C:/Users/Asus/workspace/ImageResize/src/Ejemplo2.jpg"));
			resizePicture.verticalCut(img,90);
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}

}
