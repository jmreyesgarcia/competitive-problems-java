package failedPrograms;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;


public class Main_11988_BrokenKeyboard_Beiju_Text_1_TimeLimit {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String line;
		while((line=br.readLine())!=null){
			LinkedList<Character> text1 = new LinkedList<>();
			LinkedList<Character> text2 = new LinkedList<>();
			for(int i=0;i<line.length();i++){
				char current = line.charAt(i);
				if(current=='['){
					text1.addAll(text2);
					text2 = text1;
					text1 = new LinkedList<>();
				}else if(current==']'){
					text1.addAll(text2);
					text2 = new LinkedList<>();
				}else{
					text1.addLast(current);
				}
			}
			text1.addAll(text2);			
			while(!text1.isEmpty()){
				bw.write(text1.pollFirst());
			}
			bw.write("\n");
		}
		
		bw.close();
		br.close();
	}

}
