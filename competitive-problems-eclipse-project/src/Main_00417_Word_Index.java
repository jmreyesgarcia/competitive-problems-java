import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;


public class Main_00417_Word_Index {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		//long antes = System.currentTimeMillis();
		String[] alphabet = new String[]{"","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
		int init;
		int n = 1;
		HashMap<String, Integer> hm = new HashMap<>();
		for(int i=0;i<alphabet.length;i++){
			init = 0; if(!alphabet[i].equals("")) init = i+1;
			for(int j=init;j<alphabet.length;j++){
				init = 0; if(!alphabet[j].equals("")) init = j+1;
				for(int k=init;k<alphabet.length;k++){
					init = 0; if(!alphabet[k].equals("")) init = k+1;
					for(int l=init;l<alphabet.length;l++){
						for(int m=l+1;m<alphabet.length;m++){
							String word = alphabet[i]+alphabet[j]+alphabet[k]+alphabet[l]+alphabet[m];
							hm.put(word,n++);
							//System.out.println((n++)+"->"+word);
						}
					}
				}
			}
		}
		//long despues = System.currentTimeMillis();
		//System.out.println(despues-antes);

		String line;
		while((line=br.readLine())!=null){
			bw.write(hm.getOrDefault(line, 0)+"\n");			
		}
		
		bw.close();
		br.close();
	}
}
