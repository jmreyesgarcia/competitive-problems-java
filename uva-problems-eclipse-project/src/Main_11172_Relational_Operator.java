import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_11172_Relational_Operator {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String line = br.readLine();
		int cases = Integer.parseInt(line);
		for (int i = 0; i < cases; i++) {
			line = br.readLine();
			String[] numbers = line.split(" ");
			int one = Integer.parseInt(numbers[0]);
			int two = Integer.parseInt(numbers[1]);
			if(one>two){
				bw.write(">\n");
			}else if(two>one){
				bw.write("<\n");
			}else{
				bw.write("=\n");				
			}
		}
		bw.close();
		br.close();
	}
}
