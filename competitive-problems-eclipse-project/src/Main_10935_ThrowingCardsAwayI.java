import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;


public class Main_10935_ThrowingCardsAwayI {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String line;
		Queue<Integer> q = new LinkedList<>();
		while(!(line=br.readLine()).equals("0")){
			int n = Integer.parseInt(line);
			for(int i=1;i<=n;i++){
				q.offer(i);
			}
			bw.write("Discarded cards:");
			String sep = " ";
			while(q.size()>1){
				bw.write(sep+q.poll());
				q.offer(q.poll());
				sep = ", ";
			}
			bw.write("\nRemaining card: "+q.poll()+"\n");
		}
		
		bw.close();
		br.close();
	}

}
