import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main_11498_DivisionOfNlogonia {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String line = br.readLine();
		while(!line.equals("0")){
			int k = Integer.parseInt(line);
			line = br.readLine();
			String[] points = line.split(" ");
			int p1 = Integer.parseInt(points[0]);
			int p2 = Integer.parseInt(points[1]);
			for (int i = 0; i < k; i++) {
				line = br.readLine();
				points = line.split(" ");
				int pA = Integer.parseInt(points[0]);
				int pB = Integer.parseInt(points[1]);
				String verticalP;
				if(pB>p2){
					verticalP = "N"; 
				}else if(pB<p2){
					verticalP = "S"; 
				}else{
					verticalP = "divisa";
				}
				String horizontalP;
				if(pA>p1){
					horizontalP = "E"; 
				}else if(pA<p1){
					horizontalP = "O"; 
				}else{
					horizontalP = "divisa";
				}
				
				if(verticalP.equals("divisa") || horizontalP.equals("divisa")){
					bw.write("divisa\n");
				}else{
					bw.write(verticalP+horizontalP+"\n");
				}
			}
			
			line = br.readLine();
		}
		bw.close();
		br.close();
	}

}
