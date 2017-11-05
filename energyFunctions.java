import java.awt.Color;
import java.awt.image.BufferedImage;

public class energyFunctions {
	
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
	
	
	private static int function3(int i, int j, Color img[][]){
		int ans=0;
		int l=img.length;
		int m=img[0].length;
		int cont=0;
		if(i>0){
			ans+=Math.abs(img[i][j].getBlue()-img[i-1][j].getBlue());
			ans+=Math.abs(img[i][j].getRed()-img[i-1][j].getRed());
			ans+=Math.abs(img[i][j].getGreen()-img[i-1][j].getGreen());
		}else{
			ans+=Math.abs(img[i][j].getBlue()-img[i+1][j].getBlue());
			ans+=Math.abs(img[i][j].getRed()-img[i+1][j].getRed());
			ans+=Math.abs(img[i][j].getGreen()-img[i+1][j].getGreen());
		}
		if(i<l-1){
			ans+=Math.abs(img[i][j].getBlue()-img[i+1][j].getBlue());
			ans+=Math.abs(img[i][j].getRed()-img[i+1][j].getRed());
			ans+=Math.abs(img[i][j].getGreen()-img[i+1][j].getGreen());
		}else{
			ans+=Math.abs(img[i][j].getBlue()-img[i-1][j].getBlue());
			ans+=Math.abs(img[i][j].getRed()-img[i-1][j].getRed());
			ans+=Math.abs(img[i][j].getGreen()-img[i-1][j].getGreen());
		}
		if(j>0){
			ans+=Math.abs(img[i][j].getBlue()-img[i][j-1].getBlue());
			ans+=Math.abs(img[i][j].getRed()-img[i][j-1].getRed());
			ans+=Math.abs(img[i][j].getGreen()-img[i][j-1].getGreen());
		}else{
			ans+=Math.abs(img[i][j].getBlue()-img[i][j+1].getBlue());
			ans+=Math.abs(img[i][j].getRed()-img[i][j+1].getRed());
			ans+=Math.abs(img[i][j].getGreen()-img[i][j+1].getGreen());
		}
		if(j<m-1){
			ans+=Math.abs(img[i][j].getBlue()-img[i][j+1].getBlue());
			ans+=Math.abs(img[i][j].getRed()-img[i][j+1].getRed());
			ans+=Math.abs(img[i][j].getGreen()-img[i][j+1].getGreen());
		}else{
			ans+=Math.abs(img[i][j].getBlue()-img[i][j-1].getBlue());
			ans+=Math.abs(img[i][j].getRed()-img[i][j-1].getRed());
			ans+=Math.abs(img[i][j].getGreen()-img[i][j-1].getGreen());
		}
		
		
		return ans;
		
		
	}
	
	
	private static int function4(int i, int j, Color img[][]){
		int ans=0;
		int l=img.length;
		int m=img[0].length;
		int cont=0;
		if(i>0&&i<l-1){
			ans+=Math.pow(img[i+1][j].getBlue()-img[i-1][j].getBlue(),2);
			ans+=Math.pow(img[i+1][j].getRed()-img[i-1][j].getRed(),2);
			ans+=Math.pow(img[i+1][j].getGreen()-img[i-1][j].getGreen(),2);
		}else{
			if(i==0){
				ans+=Math.pow(img[i+1][j].getBlue()-img[l-1][j].getBlue(),2);
				ans+=Math.pow(img[i+1][j].getRed()-img[l-1][j].getRed(),2);
				ans+=Math.pow(img[i+1][j].getGreen()-img[l-1][j].getGreen(),2);
			}else{
				ans+=Math.pow(img[0][j].getBlue()-img[i-1][j].getBlue(),2);
				ans+=Math.pow(img[0][j].getRed()-img[i-1][j].getRed(),2);
				ans+=Math.pow(img[0][j].getGreen()-img[i-1][j].getGreen(),2);
			}
		}
		if(j>0&&j<m-1){
			ans+=Math.pow(img[i][j+1].getBlue()-img[i][j-1].getBlue(),2);
			ans+=Math.pow(img[i][j+1].getRed()-img[i][j-1].getRed(),2);
			ans+=Math.pow(img[i][j+1].getGreen()-img[i][j-1].getGreen(),2);
		}else{
			if(j==0){
				ans+=Math.pow(img[i][j+1].getBlue()-img[i][m-1].getBlue(),2);
				ans+=Math.pow(img[i][j+1].getRed()-img[i][m-1].getRed(),2);
				ans+=Math.pow(img[i][j+1].getGreen()-img[i][m-1].getGreen(),2);
			}else{
				ans+=Math.pow(img[i][0].getBlue()-img[i][j-1].getBlue(),2);
				ans+=Math.pow(img[i][0].getRed()-img[i][j-1].getRed(),2);
				ans+=Math.pow(img[i][0].getGreen()-img[i][j-1].getGreen(),2);
			}
			
		}
		
		return ans;
		
		
	}
	
	private static int function5(int i, int j, Color img[][]){
		int ans=0;
		int l=img.length;
		int m=img[0].length;
		int cont=0;
		if(i>0&&i<l-1){
			ans+=img[i+1][j].getBlue()-img[i-1][j].getBlue();
			ans+=img[i+1][j].getRed()-img[i-1][j].getRed();
			ans+=img[i+1][j].getGreen()-img[i-1][j].getGreen();
		}else{
			if(i==0){
				ans+=img[i+1][j].getBlue()-img[l-1][j].getBlue();
				ans+=img[i+1][j].getRed()-img[l-1][j].getRed();
				ans+=img[i+1][j].getGreen()-img[l-1][j].getGreen();
			}else{
				ans+=img[0][j].getBlue()-img[i-1][j].getBlue();
				ans+=img[0][j].getRed()-img[i-1][j].getRed();
				ans+=img[0][j].getGreen()-img[i-1][j].getGreen();
			}
		}
		if(j>0&&j<m-1){
			ans+=img[i][j+1].getBlue()-img[i][j-1].getBlue();
			ans+=img[i][j+1].getRed()-img[i][j-1].getRed();
			ans+=img[i][j+1].getGreen()-img[i][j-1].getGreen();
		}else{
			if(j==0){
				ans+=img[i][j+1].getBlue()-img[i][m-1].getBlue();
				ans+=img[i][j+1].getRed()-img[i][m-1].getRed();
				ans+=img[i][j+1].getGreen()-img[i][m-1].getGreen();
			}else{
				ans+=img[i][0].getBlue()-img[i][j-1].getBlue();
				ans+=img[i][0].getRed()-img[i][j-1].getRed();
				ans+=img[i][0].getGreen()-img[i][j-1].getGreen();
			}
		}
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
				e[i][j]=function4(i,j, pal);
			}
		}
		return e;
	}

	
}
