import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main_11727_Cost_Cutting {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String line = br.readLine();
		int cases = Integer.parseInt(line);
		for (int i = 0; i < cases; i++) {
			line = br.readLine();
			String[] numbers = line.split(" ");
			int one   = Integer.parseInt(numbers[0]);
			int two   = Integer.parseInt(numbers[1]);
			int three = Integer.parseInt(numbers[2]);
			bw.write("Case "+(i+1)+": ");
			if((one<=two && two<=three) || (three<=two && two<=one)){
				bw.write(two+"\n");
			}else if((two<=one && one<=three) || (three<=one && one<=two)){
				bw.write(one+"\n");
			}else if((one<=three && three<=two) || (two<=three && three<=one)){
				bw.write(three+"\n");
			}
		}
		bw.close();
		br.close();
	}

}
