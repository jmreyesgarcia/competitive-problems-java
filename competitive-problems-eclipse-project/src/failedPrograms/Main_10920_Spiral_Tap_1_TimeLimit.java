package failedPrograms;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main_10920_Spiral_Tap_1_TimeLimit {
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
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String line;

		while(!(line = br.readLine()).equals("0 0")){
			String[] sp = line.split(" ");
			int s = Integer.parseInt(sp[0]);
			long p = Long.parseLong(sp[1]);
			int i;
			int j = i = s-1;
			long count = (long)s*(long)s;
			
			boolean encontro = false;
			int min = 0;
			int max = s;
			while(count>0 && !encontro){
				while(i>=min/*0 && spiralTap[i][j]==0*/){
					if(count==p){
						encontro = true;
						bw.write("Line = "+(i+1)+", column = "+(j+1)+".\n");
					}
					/*spiralTap[i][j] = */count--; 
					i--;
				}
				
				i++; j--;
				
				while(j>=min/*0 && spiralTap[i][j]==0*/){
					if(count==p){
						encontro = true;
						bw.write("Line = "+(i+1)+", column = "+(j+1)+".\n");
					}
					/*spiralTap[i][j] = */count--; 
					j--;
				}
				
				j++; i++;
				min++;

				while(i<max/*s && spiralTap[i][j]==0*/){
					if(count==p){
						encontro = true;
						bw.write("Line = "+(i+1)+", column = "+(j+1)+".\n");
					}
					/*spiralTap[i][j] = */count--; 
					i++;
				}
				
				i--; j++;
				max--;
				
				while(j<max/*s && spiralTap[i][j]==0*/){
					if(count==p){
						encontro = true;
						bw.write("Line = "+(i+1)+", column = "+(j+1)+".\n");
					}
					/*spiralTap[i][j] = */count--; 
					j++;
				}
				
				j--; i--;				
			}
			//print(spiralTap,bw);
		}
		br.close();
		bw.close();
	}
}
