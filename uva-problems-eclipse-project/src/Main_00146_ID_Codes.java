import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;


public class Main_00146_ID_Codes {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String line;
		//int k=0;
		while(!(line=br.readLine()).equals("#")){
			int i=line.length()-1;
			while(i > 0 && line.charAt(i-1) >= line.charAt(i)){
				i--;
			}
			if(i==0){
				bw.write("No Successor\n");
			}else{
				char toChange = line.charAt(i-1);
				char next     = line.charAt(i);
				int positionNext = 0;
				char[] charsLine = new char[line.length()-i];
				for(int j=i;j<line.length();j++){
					//bw.write("j="+j+"\n");
					char current = line.charAt(j);
					//bw.write("current="+current+"\n");
					charsLine[j-i] = current;
					if(current<next && current>toChange){
						next = current;
						positionNext = j-i;
					}
				}
				/*
				bw.write("k="+(k++)+"\n");
				bw.write("line="+line+"\n");
				bw.write("positionNext="+positionNext+"\n");
				bw.write("toChange="+toChange+"\n");
				bw.write("next="+next+"\n");
				bw.write("charsLine.length="+charsLine.length+"\n");
				bw.write(charsLine);
				bw.write("\n");*/
				charsLine[positionNext] = toChange;
				//bw.write("XXXXXXXXXX+\n");
				Arrays.sort(charsLine);
				//bw.write("YYYYYYYYYY+\n");
				String nextCode = line.substring(0, i-1)+next+(new String(charsLine));
				//bw.write("ZZZZZZZZZZ+\n");
				bw.write(nextCode+"\n");
				//bw.write("AAAAAAAAAA+\n");
				//if(k==3) return;
				//bw.write("BBBBBBBBBB+\n");
			}
			//bw.flush();
		}
		
		bw.close();
		br.close();
	}

}
