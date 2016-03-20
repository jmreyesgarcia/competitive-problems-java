import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;


public class Main_10107_What_is_the_Median {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String line;
		ArrayList<Integer> numberList = new ArrayList<>(10000);
		while((line=br.readLine())!=null){
			numberList.add(Integer.parseInt(line.trim()));
			Collections.sort(numberList);
			if(numberList.size()%2!=0){
				bw.write(numberList.get(numberList.size()/2)+"\n");
			}else{
				int n1 = numberList.get(numberList.size()/2);
				int n2 = numberList.get((numberList.size()/2)-1);
				bw.write((((long)n1+(long)n2)/2)+"\n");
			}
		}
		
		bw.close();
		br.close();
	}
}
