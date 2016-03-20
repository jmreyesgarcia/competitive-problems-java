package testCasesGenerator;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class Main_TCG_10226_HardwoodSpecies {
	public static final int MAX_CASES = 1;
	public static final int MAX_TREES = 10000;
	public static void main(String[] args) throws IOException{
		BufferedWriter bw = new BufferedWriter(new FileWriter("10226_HardwoodSpecies_input.txt"));
		
		char[] alpha = new char[]{'a','b','c','d','e','f','g','h','i','j'};
		bw.write(MAX_CASES+"\n");
		for (int i = 0; i < MAX_CASES; i++) {
			bw.write("\n");
			int n = (int)(Math.random()*MAX_TREES) + 1;
			for(int j=0;j<n;j++){
				int a = (int)(Math.random()*alpha.length);
				int b = (int)(Math.random()*alpha.length);
				int c = (int)(Math.random()*alpha.length);
				int d = (int)(Math.random()*alpha.length);
				String name = ""+alpha[a]+alpha[b]+alpha[c]+alpha[d];
				bw.write(name+"\n");
			}
		}
		
		bw.close();
	}
}
