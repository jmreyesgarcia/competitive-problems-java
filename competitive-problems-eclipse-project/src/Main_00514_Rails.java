import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main_00514_Rails {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String line;
		while(!(line=br.readLine()).equals("0")){
			int n = Integer.parseInt(line);
			while(!(line=br.readLine()).equals("0")){
				Stack<Integer> myStack = new Stack<Integer>();
				String[] coaches = line.split(" ");
				int iInput = 0;
				for(int i=1;i<=n;i++){
					int currentCoach = Integer.parseInt(coaches[iInput]);
					if(currentCoach==i){
						//bw.write("send the coach "+i+" by the rail B cause it is in the order\n");
						iInput++;
						if(iInput<coaches.length)
							currentCoach = Integer.parseInt(coaches[iInput]);
					}else{
						myStack.push(i);
						//bw.write("push the coach "+i+" on the stack cause it does not match with the next in planed order "+currentCoach+"\n");
					}
					//bw.write("before the loop, currentCoach is: "+currentCoach+"\n");
					while(!myStack.isEmpty() && myStack.peek()==currentCoach){
						//bw.write("in the loop, send the coach "+myStack.peek()+" by the rail B cause it is in the order\n");
						myStack.pop();
						iInput++;
						if(iInput<coaches.length)
							currentCoach = Integer.parseInt(coaches[iInput]);
					}
					//bw.write("=====\n");
				}
				if(myStack.isEmpty()){
					bw.write("Yes\n");
				}else{
					bw.write("No\n");
				}
				//bw.flush();
			}
			bw.write("\n");
		}
		
		bw.close();
		br.close();
	}
}