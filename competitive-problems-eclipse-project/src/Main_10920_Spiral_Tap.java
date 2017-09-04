import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main_10920_Spiral_Tap {
	/*
	public static void print(int[][] spiralTap, BufferedWriter bw) throws IOException{
		for (int k = 0; k < spiralTap.length; k++) {
			for (int k2 = 0; k2 < spiralTap.length; k2++) {
				//bw.write(spiralTap[k][k2]+"\t");
				System.out.print(spiralTap[k][k2]+"\t");
			}
			//bw.write("\n");
			System.out.println("");
		}		
		System.out.println("");
	}*/
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String line;

		while(!(line = br.readLine()).equals("0 0")){
			String[] sp = line.split(" ");
			int s = Integer.parseInt(sp[0]);
			long p = Long.parseLong(sp[1]);
			int i;
			int j;
			//long count = (long)s*(long)s;
			
			boolean finded = false;
			int min/* = 0*/;
			int max/* = s*/;
			
			int rootSquare = (int)Math.sqrt(p);
			//bw.write(" p="+p+", rootSquare="+rootSquare+"\n");
			if(rootSquare%2==0){
				rootSquare++;
			}
			//bw.write("*p="+p+", rootSquare="+rootSquare+"\n");
			int count = rootSquare*rootSquare;
			//bw.write("s="+s+", p="+p+", count="+count+"\n");
			if(count<p){ //no creo que sea necesario
				rootSquare+=2;
				count = rootSquare*rootSquare;
			}
				
			min = (s-rootSquare)/2;
			//bw.write("min="+min+"\n");
			max = s - min;
			//bw.write("max="+max+"\n");
			i = j = max - 1;

			while(count>0 && !finded){
				while(i>=min/*0 && spiralTap[i][j]==0*/){
					//System.out.println("A, i="+i);
					if(count==p){
						finded = true;
						bw.write("Line = "+(i+1)+", column = "+(j+1)+".\n");
					}
					/*spiralTap[i][j] = */count--; 
					i--;
				}
				
				i++; j--;
				
				while(j>=min/*0 && spiralTap[i][j]==0*/){
					//System.out.println("B, j="+j);
					if(count==p){
						finded = true;
						bw.write("Line = "+(i+1)+", column = "+(j+1)+".\n");
					}
					/*spiralTap[i][j] = */count--; 
					j--;
				}
				
				j++; i++;
				min++;

				while(i<max/*s && spiralTap[i][j]==0*/){
					//System.out.println("C, i="+i);
					if(count==p){
						finded = true;
						bw.write("Line = "+(i+1)+", column = "+(j+1)+".\n");
					}
					/*spiralTap[i][j] = */count--; 
					i++;
				}
				
				i--; j++;
				max--;
				
				while(j<max/*s && spiralTap[i][j]==0*/){
					//System.out.println("D, j="+j);
					if(count==p){
						finded = true;
						bw.write("Line = "+(i+1)+", column = "+(j+1)+".\n");
					}
					/*spiralTap[i][j] = */count--; 
					j++;
				}
				
				j--; i--;
				//bw.flush();
			}
			//print(spiralTap,bw);
		}
		br.close();
		bw.close();
	}
}
