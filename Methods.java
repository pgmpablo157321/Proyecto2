import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;

public class Methods {
	
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
	
	
	
	public static int[] horizontalPath(int[][]info){
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
	
	
	
	
	public static void cutVerticalPath(int path[], int[][]energy, BufferedImage img){
		int l=energy.length;
		int a=energy[0].length;
		for(int i=0;i<l;i++){
			for(int j=path[i];j<a-1;j++){
				energy[i][j]=energy[i][j+1];
				img.setRGB(j, i, img.getRGB(j+1, i));
			}
			energy[i]=Arrays.copyOf(energy[i], a-1);
		}
	}
	
	public static void cutHorizontalPath(int path[], int[][]energy, BufferedImage img){
		int l=energy.length;
		int a=energy[0].length;
		for(int j=0;j<a;j++){
			for(int i=path[j];i<l-1;i++){
				energy[i][j]=energy[i+1][j];
			}
		}
		energy=Arrays.copyOf(energy, l-1);
		img=img.getSubimage(0,0,a,l-1);
	}
	
	
	private static int function(int i, int j, Color img[][]){
		int ans=0;
		int l=img.length;
		int m=img[0].length;
		int cont=0;
		if(i>0){
			ans+=Math.abs(img[i][j].getBlue()-img[i-1][j].getBlue());
			ans+=Math.abs(img[i][j].getRed()-img[i-1][j].getRed());
			ans+=Math.abs(img[i][j].getGreen()-img[i-1][j].getGreen());
			cont++;
		}
		if(i<l-1){
			ans+=Math.abs(img[i][j].getBlue()-img[i+1][j].getBlue());
			ans+=Math.abs(img[i][j].getRed()-img[i+1][j].getRed());
			ans+=Math.abs(img[i][j].getGreen()-img[i+1][j].getGreen());
			cont++;
		}
		if(j>0){
			ans+=Math.abs(img[i][j].getBlue()-img[i][j-1].getBlue());
			ans+=Math.abs(img[i][j].getRed()-img[i][j-1].getRed());
			ans+=Math.abs(img[i][j].getGreen()-img[i][j-1].getGreen());
			cont++;
		}
		if(j<m-1){
			ans+=Math.abs(img[i][j].getBlue()-img[i][j+1].getBlue());
			ans+=Math.abs(img[i][j].getRed()-img[i][j+1].getRed());
			ans+=Math.abs(img[i][j].getGreen()-img[i][j+1].getGreen());
			cont++;
		}
		ans/=cont;
		
		
		return ans;
		
		
	}
	
	private static int function2(int i, int j, Color img[][]){
		int ans=0;
		int l=img.length;
		int m=img[0].length;
		int cont=0;
		if(i>0){
			ans+=Math.abs(img[i][j].getBlue()-img[i-1][j].getBlue());
			ans+=Math.abs(img[i][j].getRed()-img[i-1][j].getRed());
			ans+=Math.abs(img[i][j].getGreen()-img[i-1][j].getGreen());
			cont++;
		}
		if(i<l-1){
			ans+=Math.abs(img[i][j].getBlue()-img[i+1][j].getBlue());
			ans+=Math.abs(img[i][j].getRed()-img[i+1][j].getRed());
			ans+=Math.abs(img[i][j].getGreen()-img[i+1][j].getGreen());
			cont++;
		}
		if(j>0){
			ans+=Math.abs(img[i][j].getBlue()-img[i][j-1].getBlue());
			ans+=Math.abs(img[i][j].getRed()-img[i][j-1].getRed());
			ans+=Math.abs(img[i][j].getGreen()-img[i][j-1].getGreen());
			cont++;
		}
		if(j<m-1){
			ans+=Math.abs(img[i][j].getBlue()-img[i][j+1].getBlue());
			ans+=Math.abs(img[i][j].getRed()-img[i][j+1].getRed());
			ans+=Math.abs(img[i][j].getGreen()-img[i][j+1].getGreen());
			cont++;
		}
		if(i>0&&j>0){
			ans+=Math.abs(img[i][j].getBlue()-img[i-1][j-1].getBlue());
			ans+=Math.abs(img[i][j].getRed()-img[i-1][j-1].getRed());
			ans+=Math.abs(img[i][j].getGreen()-img[i-1][j-1].getGreen());
			cont++;
		}
		if(i>0&&j<m-1){
			ans+=Math.abs(img[i][j].getBlue()-img[i-1][j+1].getBlue());
			ans+=Math.abs(img[i][j].getRed()-img[i-1][j+1].getRed());
			ans+=Math.abs(img[i][j].getGreen()-img[i-1][j+1].getGreen());
			cont++;
		}
		if(j>0&&i<l-1){
			ans+=Math.abs(img[i][j].getBlue()-img[i+1][j-1].getBlue());
			ans+=Math.abs(img[i][j].getRed()-img[i+1][j-1].getRed());
			ans+=Math.abs(img[i][j].getGreen()-img[i+1][j-1].getGreen());
			cont++;
		}
		if(j<m-1&&i<l-1){
			ans+=Math.abs(img[i][j].getBlue()-img[i+1][j+1].getBlue());
			ans+=Math.abs(img[i][j].getRed()-img[i+1][j+1].getRed());
			ans+=Math.abs(img[i][j].getGreen()-img[i+1][j+1].getGreen());
			cont++;
		}
		
		
		ans/=cont;
		return ans;
		
		
	}
	
	public static int[][] energy(BufferedImage img){
		int l=img.getHeight();
		int m=img.getWidth();
		int[][]e=new int [img.getHeight()][img.getWidth()];
		Color[][] pal=new Color[img.getHeight()][img.getWidth()];
		for(int i=0;i<l;i++){
			for(int j=0;j<m;j++){
				pal[i][j]=new Color(img.getRGB(j, i));
			}
		}
		for(int i=0;i<l;i++){
			for(int j=0;j<m;j++){
				e[i][j]=function2(i,j, pal);
			}
		}
		return e;
	}

	
	public static void imprimir(int[][]a){

		for(int i=0;i<a.length;i++){
			for(int j=0;j<a[0].length;j++){
				System.out.print(a[i][j]+" ");
				if(a[i][j]<1000){
					System.out.print(" ");
				}
				if(a[i][j]<100){
					System.out.print(" ");
				}
				if(a[i][j]<10){
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
		int a[][];
		try {
			BufferedImage img=ImageIO.read(new File("C:/Users/Asus/workspace/ImageResize/src/Image2.jpg"));
			//imprimir(a);
			for (int i = 0; i < 100; i++) {
				a=energy(img);
				cutVerticalPath(verticalPath(a),a, img);
				img=img.getSubimage(0, 0, img.getWidth()-1, img.getHeight());
			}
			
			ImageIO.write(img, "png", new File("C:/Users/Asus/workspace/ImageResize/src/Image(1).jpg"));
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}

}
