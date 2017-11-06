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
		int a[][] = new int[5][6];
		Scanner in = new Scanner(System.in);
		try {
			BufferedImage img = ImageIO.read(new File("C:/Users/Asus/workspace/ImageResize/src/Castillo.jpg"));
			resizePicture b = new resizePicture(img);
			b.setEnergy(235, 12, 366, 240, false);
			// imprimir(b.getEnergy());
			// BufferedImage img2=new
			// BufferedImage(411,279,BufferedImage.TYPE_3BYTE_BGR);
			// for(int i=0;i<279;i++){
			// for(int j=0;j<411;j++){
			// img2.setRGB(j, i, -b.getEnergy()[i][j]);
			// }
			// }
			b.horizontalCut(80);
			b.showHorizontalPath();

			// ImageIO.write(img2, "png", new
			// File("C:/Users/Asus/workspace/ImageResize/src/Energia.jpg"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	}

}
