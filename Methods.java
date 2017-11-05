import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class Methods {

	public static void imprimir(int[][] a) {
		  for (int i = 0; i < a.length; i++) {
		   for (int j = 0; j < a[0].length; j++) {
		    System.out.print(a[i][j] + " ");
		    if (a[i][j] < 1000) {
		     System.out.print(" ");
		    }
		    if (a[i][j] < 100) {
		     System.out.print(" ");
		    }
		    if (a[i][j] < 10) {
		     System.out.print(" ");
		    }
		   }
		   System.out.println();
		  }
		  System.out.println();
		  System.out.println();
		 }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[][]=new int[5][6];
		Scanner in=new Scanner(System.in);
		try {
			BufferedImage img=ImageIO.read(new File("C:/Users/Asus/workspace/ImageResize/src/Image3.jpg"));
			resizePicture b=new resizePicture(img);
			//b.setEnergy(0,0,100,100, true);
			//imprimir(b.getEnergy());
			b.verticalCut(399);
			b.showVerticalPath();
			//imprimir(b.getEnergy());
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}

}
