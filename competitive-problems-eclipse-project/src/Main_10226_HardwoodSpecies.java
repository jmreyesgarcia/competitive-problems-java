import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;


public class Main_10226_HardwoodSpecies {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String line = br.readLine();
		int n = Integer.parseInt(line);
		br.readLine();
		String sep = "";
		for (int i = 0; i < n; i++) {
			bw.write(sep);
			sep = "\n";
			HashMap<String, Integer> population = new HashMap<>();
			ArrayList<String> treeSpeciesAL = new ArrayList<>();
			int total = 0;
			line = br.readLine();
			while(line!=null && !line.equals("")){
				//System.out.println(line);
				if(!population.containsKey(line)){
					population.put(line, 0);
					treeSpeciesAL.add(line);
				}
				population.put(line, population.get(line)+1);
				total++;
				line = br.readLine();
			}
			
			Collections.sort(treeSpeciesAL);
			
			DecimalFormatSymbols dfs = new DecimalFormatSymbols(Locale.getDefault());
			dfs.setDecimalSeparator('.');
			dfs.setGroupingSeparator(',');
			DecimalFormat df = new DecimalFormat("0.0000",dfs);
			
			for (int j = 0; j < treeSpeciesAL.size(); j++) {
				String nameSpecie = treeSpeciesAL.get(j);
				double percentage = (population.get(nameSpecie)*100)/(double)total;
				bw.write(nameSpecie+" "+df.format(percentage)+"\n");
			}
		}

		bw.close();
		br.close();
	}

}
