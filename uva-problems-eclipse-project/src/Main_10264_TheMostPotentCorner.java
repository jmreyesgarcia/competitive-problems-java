import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.BitSet;


public class Main_10264_TheMostPotentCorner {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String line;
		while((line=br.readLine())!=null){
			int n = Integer.parseInt(line);
			int totalCorner = (int)Math.pow(2, n);
			int[] cornerWeights = new int[totalCorner];
			
			for(int i=0;i<totalCorner;i++){
				line=br.readLine();
				cornerWeights[i] = Integer.parseInt(line);
			}
			
			int[] cornerPotencies = new int[totalCorner];
			for(int i=0;i<totalCorner;i++){
				BitSet bs = BitSet.valueOf(new long[]{i});
				//String numberStrAux = "";
				/*for(int k=n-1;k>=0;k--){
					numberStrAux += (bs.get(k)?1:0);
				}
				bw.write(i+" es "+numberStrAux+"\n");*/
				cornerPotencies[i] = 0;
				for(int j=0;j<n;j++){
					bs.flip(j);
					String numberStr = "";
					for(int k=n-1;k>=0;k--){
						numberStr += (bs.get(k)?1:0);
					}
					int number = Integer.valueOf(numberStr, 2);
					//bw.write(i+" vecino de "+number+"\n");
					//bw.write(numberStrAux+" vecino de "+numberStr+"\n");
					cornerPotencies[i] += cornerWeights[number];

					bs.flip(j);
				}
				//bw.write("cornerPotencies["+i+"] = "+cornerPotencies[i]+"\n");
			}
			
			int max = 0;
			for(int i=0;i<totalCorner;i++){
				BitSet bs = BitSet.valueOf(new long[]{i});
				for(int j=0;j<n;j++){
					bs.flip(j);
					String numberStr = "";
					for(int k=n-1;k>=0;k--){
						numberStr += (bs.get(k)?1:0);
					}
					int number = Integer.valueOf(numberStr, 2);
					//bw.write(i+" vecino de "+number+"\n");
					//bw.write("potencia["+i+"]="+cornerPotencies[i]+", potencia["+number+"]="+cornerPotencies[number]+"\n");
					int current = cornerPotencies[i]+cornerPotencies[number];
					if(current>max){
						max = current;
					}
					//bw.write("max="+max+"\n");
					bs.flip(j);
				}
			}
			
			bw.write(max+"\n");
			//bw.flush();
		}
		
		bw.close();
		br.close();
	}
}
