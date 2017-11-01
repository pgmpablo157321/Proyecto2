
public class FindingPath {
	
	public static int[] Path(int[][] info, int l, int m, boolean dir){
		int [][]Path=new int [l][m];
		int [][]Path2=new int[l][m];
		if(dir){
			for(int i=0;i<l;i++){
				Path[i][0]=info[i][0];
			}
			for(int i=1;i<m;i++){
				for(int j=0;j<l;j++){
					Path[j][i]=info[j][i]+Math.min(Path[j][i-1], Math.min(j>0?Path[j-1][i-1]:Integer.MAX_VALUE, j<l-1?Path[j+1][i-1]:Integer.MAX_VALUE));
					if(j>0&&Path[j-1][i-1]==Math.min(Path[j][i-1],Math.min(j>0?Path[j-1][i-1]:Integer.MAX_VALUE, j<l-1?Path[j+1][i-1]:Integer.MAX_VALUE))){
						Path2[j][i]=-1;
					}
					if(Path[j][i-1]==Math.min(Path[j][i-1],Math.min(j>0?Path[j-1][i-1]:Integer.MAX_VALUE, j<l-1?Path[j+1][i-1]:Integer.MAX_VALUE))){
						Path2[j][i]=0;
					}
					if(j<l-1&&Path[j+1][i-1]==Math.min(Path[j][i-1],Math.min(j>0?Path[j-1][i-1]:Integer.MAX_VALUE, j<l-1?Path[j+1][i-1]:Integer.MAX_VALUE))){
						Path2[j][i]=1;
					}
				}
			}
			int aux=Integer.MAX_VALUE;
			int index=0;
			int camino[]=new int[m];
			for(int i=0;i<l;i++){
				if(aux>Path[i][m-1]){
					aux=Path[i][m-1];
					index=i;
				}
			}
			camino[m-1]=index;
			for(int i=m-2;i>=0;i--){
				index=index+Path2[index][i+1];
				camino[i]=index;
			}
			
			return camino;
		}else{
			for(int i=0;i<m;i++){
				Path[0][i]=info[0][i];
			}
			for(int i=1;i<l;i++){
				for(int j=0;j<m;j++){
					Path[i][j]=info[i][j]+Math.min(Path[i-1][j], Math.min(j>0?Path[i-1][j-1]:Integer.MAX_VALUE, j<m-1?Path[i-1][j+1]:Integer.MAX_VALUE));
					if(j>0&&Path[i-1][j-1]==Math.min(Path[i-1][j], Math.min(j>0?Path[i-1][j-1]:Integer.MAX_VALUE, j<m-1?Path[i-1][j+1]:Integer.MAX_VALUE))){
						Path2[i][j]=-1;
					}
					if(Path[i-1][j]==Math.min(Path[i-1][j], Math.min(j>0?Path[i-1][j-1]:Integer.MAX_VALUE, j<m-1?Path[i-1][j+1]:Integer.MAX_VALUE))){
						Path2[i][j]=0;
					}
					if(j<l-1&&Path[i-1][j+1]==Math.min(Path[i-1][j], Math.min(j>0?Path[i-1][j-1]:Integer.MAX_VALUE, j<m-1?Path[i-1][j+1]:Integer.MAX_VALUE))){
						Path2[i][j]=1;
					}
				
				}
			}
			
			int aux=Integer.MAX_VALUE;
			int index=0;
			int camino[]=new int[l];
			
			for(int i=0;i<m;i++){
				if(aux>Path[l-1][i]){
					aux=Path[l-1][i];
					index=i;
				}
			}
			
			camino[l-1]=index;
			for(int i=l-2;i>=0;i--){
				index=index+Path2[i+1][index];
				camino[i]=index;
			}
			return camino;
		}	
		
	}
	
	
	
	
	public static int[][] vertical(int path[], int[][]image){
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
	
	public static int[][] horizontal(int path[], int[][]image){
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
	
	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[][]=new int[960][1280];
		/*for(int i=0;i<a.length;i++){
			for(int j=0;j<a[0].length;j++){
				a[i][j]=(int)(Math.random()*90)+10;
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}*/
		System.out.println();
		System.out.println();
		int n[][]=horizontal(Path(a, a.length,a[0].length,true),a);
		System.out.println();
		System.out.println();
		/*for(int i=0;i<n.length;i++){
			for(int j=0;j<n[0].length;j++){
				System.out.print(n[i][j]+" ");
			}
			System.out.println();
		}*/
		
		
		
		
		

	}

}
