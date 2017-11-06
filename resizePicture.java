import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import javax.imageio.ImageIO;

public class resizePicture {
	
	private int[][]energy;
	private BufferedImage img;
	
	public resizePicture(BufferedImage img) {
		this.energy=energyFunctions.energy(img);
		this.img=img;
	}
	
	public int[][] getEnergy() {
		return energy;
	}

	public void setEnergy(int x1, int y1, int x2, int y2, boolean p) {
		if(p){
			for(int i=y1;i<y2;i++){
				for(int j=x1;j<x2;j++){
					energy[i][j]=300000;
				}
			}
		}else{
			for(int i=y1;i<y2;i++){
				for(int j=x1;j<x2;j++){
					energy[i][j]=-3000000;
				}
			}
		}
	}


	

	public int[] verticalPath(){
		int l = this.energy.length; //Largo
		int m = this.energy[0].length;//Ancho
		int [][]Path=new int [l][m];
		int [][]Path2=new int[l][m];
		for(int i=0; i<m;i++){
			Path[0][i]=this.energy[0][i];
		}
		for (int i = 1; i < l; i++) {
			for (int j = 0; j < m; j++) {
				int minimo = Path[i-1][j];
				Path2[i][j]=0;
				if ((j > 0) && (Path[i - 1][j - 1]< minimo)) {
					minimo=Path[i - 1][j - 1];
					Path2[i][j] = -1;
				} 
				if ((j < m - 1) && (Path[i - 1][j + 1] < minimo)) {
					minimo=Path[i - 1][j + 1];
					Path2[i][j] = 1;
				}
				Path[i][j]=minimo+this.energy[i][j];
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
			index = index + Path2[i+1][index];
			camino[i] = index;
		}
		//System.out.println(aux);
		return camino;
	}
	
	private int[] horizontalPath(){
		int l = this.energy.length; //Largo
		int m = this.energy[0].length;//Ancho
		int [][]Path=new int [l][m];
		int [][]Path2=new int[l][m];
		for (int i = 0; i < l; i++) {
			Path[i][0] = this.energy[i][0];
		}
		for (int i=1; i<m; i++) {
			for (int j=0; j<l; j++) {
				int minimo=Path[j][i-1];
				Path2[j][i]=0;
				if((j>0)&&Path[j-1][i-1]<minimo){
					minimo=Path[j-1][i-1];
					Path2[j][i]=-1;
				}
				if((j<l-1)&&Path[j+1][i-1]<minimo){
					minimo=Path[j+1][i-1];
					Path2[j][i]=1;
				}
				Path[j][i]=this.energy[j][i]+minimo;
//				int minimo = Math.min(Path[j][i-1], Math.min(j>0?Path[j-1][i-1] : Integer.MAX_VALUE,
//						j< l-1?Path[j+1][i-1]:Integer.MAX_VALUE));
//				//
//				Path[j][i] = this.energy[j][i] + minimo;
//				if (j > 0 && Path[j - 1][i - 1] == minimo) {
//					Path2[j][i] = -1;
//				} else if (Path[j][i - 1] == minimo) {
//					Path2[j][i] = 0;
//				} else if (j < l - 1 && Path[j + 1][i - 1] == minimo) {
//					Path2[j][i] = 1;
//				}
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
	
	public void verticalCut(int t) throws IOException{
		for(int k=0;k<t;k++){
			int l=energy.length;
			int a=energy[0].length;
			int path[]=this.verticalPath();
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
	
	public void horizontalCut(int t) throws IOException{
		for(int k=0;k<t;k++){
			int l=energy.length;
			int a=energy[0].length;
			int path[]= this.horizontalPath();
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
	
	public void showVerticalPath()throws IOException{
		int path[]= verticalPath();
		for(int i=0;i<energy.length;i++){
			img.setRGB(path[i], i, Color.RED.getRGB());
		}
		ImageIO.write(img, "jpg", new File("C:/Users/Asus/workspace/ImageResize/src/VerticalPath.jpg"));
	}
	
	public void showHorizontalPath()throws IOException{
		int path[]= horizontalPath();
		for(int i=0;i<energy[0].length;i++){
			img.setRGB(i, path[i], Color.RED.getRGB());
		}
		ImageIO.write(img, "jpg", new File("C:/Users/Asus/workspace/ImageResize/src/HorizontalPath.jpg"));
	}
	
	
}
