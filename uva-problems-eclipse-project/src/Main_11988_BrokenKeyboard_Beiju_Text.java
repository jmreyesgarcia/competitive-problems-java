import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;


public class Main_11988_BrokenKeyboard_Beiju_Text {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String line;
		while((line=br.readLine())!=null){
			LinkedList<LinkedList<Character>> textLL = new LinkedList<>();
			LinkedList<Character> text = new LinkedList<>();
			textLL.addLast(text);
			for(int i=0;i<line.length();i++){
				char current = line.charAt(i);
				if(current=='['){
					text = new LinkedList<>();
					textLL.addFirst(text);
				}else if(current==']'){
					text = new LinkedList<>();
					textLL.addLast(text);
				}else{
					text.addLast(current);
				}
			}
			while(!textLL.isEmpty()){
				LinkedList<Character> currentText = textLL.pollFirst();
				while(!currentText.isEmpty()){
					bw.write(currentText.pollFirst());
				}
			}
			bw.write("\n");
		}
		
		bw.close();
		br.close();
	}

}
