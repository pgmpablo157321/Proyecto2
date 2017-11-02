import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;

public class Methods {
	
	public static int[] verticalPath(int[][] info, boolean dir){
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

	public static int[] horizontalPath(int[][]info, boolean dir){
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
	
	public static int[][] cutVerticalPaht(int path[], int[][]image){
		int l=image.length;
		int a=image[0].length;
		int mat[][]=new int[l][a-1];
		for(int i=0;i<l;i++){
			int cont=0;
			for(int j=0;j<a;j++){
				if (j!=path[i]){
					mat[i][cont]=image[i][j];
					cont++;
				}	
			}
		}
		return mat;
	}
	
	public static int[][] cutHorizontalPath(int path[], int[][]image){
		int l=image.length;
		int a=image[0].length;
		int mat[][]=new int[l-1][a];
		for(int j=0;j<a;j++){
			int cont=0;
			for(int i=0;i<l;i++){
				if (i!=path[j]){
					mat[cont][j]=image[i][j];
					cont++;
				}	
			}
		}
		return mat;
	}
	
	private static int function(int i, int j, Color img[][]){
		int ans=0;
		int l=img.length;
		int m=img[0].length;
		int cont=0;
		int blue = img[i][j].getBlue();
		int red = img[i][j].getRed();
		int green = img[i][j].getGreen(); 
		if(i>0){
			ans+=Math.abs(blue-img[i-1][j].getBlue());
			ans+=Math.abs(red-img[i-1][j].getRed());
			ans+=Math.abs(green-img[i-1][j].getGreen());
			cont++;
		}else if(i<l-1){
			ans+=Math.abs(blue-img[i+1][j].getBlue());
			ans+=Math.abs(red-img[i+1][j].getRed());
			ans+=Math.abs(green-img[i+1][j].getGreen());
			cont++;
		}else if(j>0){
			ans+=Math.abs(blue-img[i][j-1].getBlue());
			ans+=Math.abs(red-img[i][j-1].getRed());
			ans+=Math.abs(green-img[i][j-1].getGreen());
			cont++;
		}else if(j<m-1){
			ans+=Math.abs(blue-img[i][j+1].getBlue());
			ans+=Math.abs(red-img[i][j+1].getRed());
			ans+=Math.abs(green-img[i][j+1].getGreen());
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
		int blue = img[i][j].getBlue();
		int red = img[i][j].getRed();
		int green = img[i][j].getGreen(); 
		if(i>0){
			ans+=Math.abs(blue-img[i-1][j].getBlue());
			ans+=Math.abs(red-img[i-1][j].getRed());
			ans+=Math.abs(green-img[i-1][j].getGreen());
			cont++;
		}else if(i<l-1){
			ans+=Math.abs(blue-img[i+1][j].getBlue());
			ans+=Math.abs(red-img[i+1][j].getRed());
			ans+=Math.abs(green-img[i+1][j].getGreen());
			cont++;
		}else if(j>0){
			ans+=Math.abs(blue-img[i][j-1].getBlue());
			ans+=Math.abs(red-img[i][j-1].getRed());
			ans+=Math.abs(green-img[i][j-1].getGreen());
			cont++;
		}else if(j<m-1){
			ans+=Math.abs(blue-img[i][j+1].getBlue());
			ans+=Math.abs(red-img[i][j+1].getRed());
			ans+=Math.abs(green-img[i][j+1].getGreen());
			cont++;
		}else if(i>0&&j>0){
			ans+=Math.abs(blue-img[i-1][j-1].getBlue());
			ans+=Math.abs(red-img[i-1][j-1].getRed());
			ans+=Math.abs(green-img[i-1][j-1].getGreen());
			cont++;
		}else if(i>0&&j<m-1){
			ans+=Math.abs(blue-img[i-1][j+1].getBlue());
			ans+=Math.abs(red-img[i-1][j+1].getRed());
			ans+=Math.abs(green-img[i-1][j+1].getGreen());
			cont++;
		}else if(j>0&&i<l-1){
			ans+=Math.abs(blue-img[i+1][j-1].getBlue());
			ans+=Math.abs(red-img[i+1][j-1].getRed());
			ans+=Math.abs(green-img[i+1][j-1].getGreen());
			cont++;
		}else if(j<m-1&&i<l-1){
			ans+=Math.abs(blue-img[i+1][j+1].getBlue());
			ans+=Math.abs(red-img[i+1][j+1].getRed());
			ans+=Math.abs(green-img[i+1][j+1].getGreen());
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
				pal[i][j]=new Color(img.getRGB(i, j));
			}
		}
		for(int i=0;i<l;i++){
			for(int j=0;j<m;j++){
				e[i][j]=function(i,j, pal);
			}
		}
		return e;
	}
	
	public static void main(String[] args) {
	}
}
