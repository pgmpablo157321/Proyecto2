import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;

public class resizePicture {
	
	public static int[] verticalPath(int[][] info){
		int l = info.length; //Largo
		int m = info[0].length;//Ancho
		int [][]Path=new int [l][m];
		int [][]Path2=new int[l][m];
		Path[0] = info[0];
		for (int i = 1; i < l; i++) {
			for (int j = 0; j < m; j++) {
				int minimo = Math.min(Path[i - 1][j], Math.min(j > 0 ? Path[i - 1][j - 1] : Integer.MAX_VALUE,
						j < m - 1 ? Path[i - 1][j + 1] : Integer.MAX_VALUE));
				Path[i][j] = info[i][j] + minimo;
				if (j > 0 && Path[i - 1][j - 1] == minimo) {
					Path2[i][j] = -1;
				} else if (Path[i - 1][j] == minimo) {
					Path2[i][j] = 0;
				} else if (j < l - 1 && Path[i - 1][j + 1] == minimo) {
					Path2[i][j] = 1;
				}
			}
		}
		int aux = Integer.MAX_VALUE;
		int index = 0;
		int camino[] = new int[l];
		for (int i = 0; i < m; i++) {
			if (aux > Path[l - 1][i]) {
				aux = Path[l - 1][i];
				index = i;
			}
		}
		camino[l - 1] = index;
		for (int i = l - 2; i >= 0; i--) {
			index = index + Path2[i + 1][index];
			camino[i] = index;
		}
		return camino;
	}
	
	private static int[] horizontalPath(int[][]info){
		int l = info.length; //Largo
		int m = info[0].length;//Ancho
		int [][]Path=new int [l][m];
		int [][]Path2=new int[l][m];
		for (int i = 0; i < l; i++) {
			Path[i][0] = info[i][0];
		}
		for (int i=1; i<m; i++) {
			for (int j=0; j<l; j++) {
				int minimo = Math.min(Path[j][i-1], Math.min(j>0?Path[j-1][i-1] : Integer.MAX_VALUE,
						j< l-1?Path[j+1][i-1]:Integer.MAX_VALUE));
				//
				Path[j][i] = info[j][i] + minimo;
				if (j > 0 && Path[j - 1][i - 1] == minimo) {
					Path2[j][i] = -1;
				} else if (Path[j][i - 1] == minimo) {
					Path2[j][i] = 0;
				} else if (j < l - 1 && Path[j + 1][i - 1] == minimo) {
					Path2[j][i] = 1;
				}
			}
		}
		int aux = Integer.MAX_VALUE;
		int index = 0;
		int camino[] = new int[m];
		for (int i = 0; i < l; i++) {
			if (aux > Path[i][m - 1]) {
				aux = Path[i][m - 1];
				index = i;
			}
		}
		camino[m - 1] = index;
		for (int i = m - 2; i >= 0; i--) {
			index = index + Path2[index][i + 1];
			camino[i] = index;
		}
		return camino;
	}
	
	public static void verticalCut(BufferedImage img, int t) throws IOException{
		int[][]energy=energyFunctions.energy(img);
		for(int k=0;k<t;k++){
			int l=energy.length;
			int a=energy[0].length;
			int path[]=verticalPath(energy);
			for(int i=0;i<l;i++){
				for(int j=path[i];j<a-1;j++){
					energy[i][j]=energy[i][j+1];
					img.setRGB(j, i, img.getRGB(j+1, i));
				}
				energy[i]=Arrays.copyOf(energy[i], a-1);
			}
			
		}
		img=img.getSubimage(0, 0, img.getWidth()-t, img.getHeight());
		
		ImageIO.write(img, "png", new File("C:/Users/Asus/workspace/ImageResize/src/Image(1).jpg"));
		
	}
	
	public static void horizontalCut(BufferedImage img, int t) throws IOException{
		int[][]energy=energyFunctions.energy(img);
		for(int k=0;k<t;k++){
			int l=energy.length;
			int a=energy[0].length;
			int path[]= horizontalPath(energy);
			for(int j=0;j<a;j++){
				for(int i=path[j];i<l-1;i++){
					energy[i][j]=energy[i+1][j];
					img.setRGB(j, i, img.getRGB(j, i+1));
				}
			}
			energy=Arrays.copyOf(energy, l-1);
		}
		img=img.getSubimage(0,0,img.getWidth(),img.getHeight()-t);
		ImageIO.write(img, "png", new File("C:/Users/Asus/workspace/ImageResize/src/Image(1).jpg"));
	}
	
	public static void showVerticalPath(int[][]energy, BufferedImage img)throws IOException{
		int path[]= verticalPath(energy);
		for(int i=0;i<energy.length;i++){
			img.setRGB(path[i], i, Color.RED.getRGB());
		}
		ImageIO.write(img, "png", new File("C:/Users/Asus/workspace/ImageResize/src/VerticalPath.jpg"));
	}
	
	public static void showHorizontalPath(int[][]energy, BufferedImage img)throws IOException{
		int path[]= horizontalPath(energy);
		for(int i=0;i<energy[0].length;i++){
			img.setRGB(i, path[i], Color.RED.getRGB());
		}
		ImageIO.write(img, "png", new File("C:/Users/Asus/workspace/ImageResize/src/HorizontalPath.jpg"));
	}
	
	
}
