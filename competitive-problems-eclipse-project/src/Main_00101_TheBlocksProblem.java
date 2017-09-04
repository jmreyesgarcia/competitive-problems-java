import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_00101_TheBlocksProblem {
	public static final int NN = -1;
	
	public static class Coord{
		int f = 0;
		int c = 0;
	}
	
	public static Coord buscarNumero(int[][] bworld, int numBusc){
		Coord co = new Coord();
		
		//System.out.println("numBusc="+numBusc);
		boolean encontro = false;
		for(int j=0;j<bworld[0].length && !encontro;j++){
			//System.out.println("bworld[0]["+j+"]="+bworld[0][j]);
			for(int i=0; bworld[i][j]!=NN && !encontro && i<bworld.length;i++){
				//System.out.println("hola");
				if(bworld[i][j]==numBusc){
					//System.out.println("entra");
					co.f = i;
					co.c = j;
					encontro = true;
				}
			}
		}
		
		return co;
	}
	
	public static void limpiarTope(int[][] bworld, Coord co){
		for(int i=co.f+1;i<bworld.length && bworld[i][co.c]!=NN;i++){
			int val = bworld[i][co.c];
			bworld[0][val]  = val;
			bworld[i][co.c] = NN;
		}
	}
	
	public static int buscarFilaTope(int[][] bworld, Coord co){
		int i =co.f;
		while(i<bworld.length && bworld[i][co.c]!=NN){
			i++;
		}
		return i;
	}
	
	public static void apilar(int[][] bworld, Coord origen, Coord destino){
		for(int i=0;origen.f+i<bworld.length && bworld[origen.f+i][origen.c]!=NN;i++){
			bworld[destino.f+i][destino.c] = bworld[origen.f+i][origen.c];
			bworld[origen.f+i][origen.c] = NN;
		}
	}
	
	public static void print(int[][] bworld, BufferedWriter bw) throws IOException{
		for(int j=0;j<bworld[0].length;j++){
			//System.out.print(j+": ");
			bw.write(j+":");
			for(int i=0;i<bworld.length && bworld[i][j]!=NN;i++){
				if(bworld[i][j]!=NN){
					//System.out.print(""+bworld[i][j]);
					bw.write(" "+bworld[i][j]);
				}
			}
			//System.out.println("");
			bw.write("\n");
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String line = br.readLine();
		int n = Integer.parseInt(line);
		int[][] blocksWorld = new int[n][n];
		
		for(int i=0;i<blocksWorld.length;i++)
			for(int j=0;j<blocksWorld[i].length;j++)
				blocksWorld[i][j] = NN;
		for(int j=0;j<blocksWorld.length;j++)
			blocksWorld[0][j] = j;
		
		//print(blocksWorld,bw);
		
		while(!(line = br.readLine()).equals("quit")){
			String[] cmds = line.split(" ");
			int num1 = Integer.parseInt(cmds[1]);
			int num2 = Integer.parseInt(cmds[3]);
			Coord co1 = buscarNumero(blocksWorld, num1);
			Coord co2 = buscarNumero(blocksWorld, num2);
			//System.out.println("co1.c="+co1.c+", co1.f="+co1.f);
			//System.out.println("co2.c="+co2.c+", co2.f="+co2.f);
			if(co1.c != co2.c){ //if co1.c == co2.c, the command is ignored 
				
				if(cmds[2].equals("onto")){
					limpiarTope(blocksWorld, co2);
					co2.f++;
				}else{ //"over"
					co2.f = buscarFilaTope(blocksWorld, co2);
				}				
				
				if(cmds[0].equals("move")){
					limpiarTope(blocksWorld, co1);
					
					blocksWorld[co2.f][co2.c] = blocksWorld[co1.f][co1.c];
					blocksWorld[co1.f][co1.c] = NN;
				}else{//"pile"
					apilar(blocksWorld, co1, co2);
				}
			}
			//print(blocksWorld,bw);
		}
		print(blocksWorld,bw);
		
		br.close();
		bw.close();
	}
}
