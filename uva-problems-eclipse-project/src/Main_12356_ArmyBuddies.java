import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main_12356_ArmyBuddies {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String line;
		//String cad = "";
		int[] soldiers = new int[100000];		
		while(!(line = br.readLine()).equals("0 0")){
			String[] sb = line.split(" ");
			int s = Integer.parseInt(sb[0]);
			int b = Integer.parseInt(sb[1]);
			
			//int[] soldiers = new int[s];
			for(int i=0;i<s;i++) soldiers[i] = i+1;
			
			for(int i=0;i<b;i++){
				line = br.readLine();
				String[] lr = line.split(" ");
				int l = Integer.parseInt(lr[0]);
				int r = Integer.parseInt(lr[1]);
				
				String lbu = "*";
				String rbu = "*";
				
				int dif = -(r-l)-1;

				int poslbu = l-2; 
				if(poslbu>=0){
					if(soldiers[poslbu]<0){
						dif += soldiers[poslbu];
						poslbu = poslbu+soldiers[poslbu];
						if(poslbu>=0){
							lbu = soldiers[poslbu]+"";							
						}
					}else{
						lbu = soldiers[poslbu]+"";
					}
				}
				
				int posrbu = r;
				if(posrbu<s){
					if(soldiers[posrbu]<0){
						dif += soldiers[posrbu];
						posrbu = posrbu-soldiers[posrbu];
						if(posrbu<s){
							rbu = soldiers[posrbu]+"";
							soldiers[posrbu-1] = dif;
						}
					}else{
						rbu = soldiers[posrbu]+"";
					}
				}
				
				if(poslbu+1>=0){
					soldiers[poslbu+1] = dif;
				}
				
				soldiers[l-1] = dif;
				soldiers[r-1] = dif;
				
				bw.write(lbu+" "+rbu+"\n");
			}
			bw.write("-\n");
		}
		
		//bw.write(cad);
		br.close();
		bw.close();
	}
}
