import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Stack;


public class Main_00127_Accordian_Patience {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String line1;
		while(!(line1 = br.readLine()).equals("#")){
			String line2 = br.readLine();
			String[] cards = (line1+" "+line2).split(" ");
			ArrayList<Stack<String>> cardsStacks = new ArrayList<>();
			
			for (int i = 0; i < cards.length; i++) {
				Stack<String> st = new Stack<>();
				st.push(cards[i]);
				cardsStacks.add(st);
			}
			
			int k = 0;
			int max = k;
			boolean third, first;
			do{
				String tplCard = null;
				String oplCard = null;
				char face, suit;
				third = false;
				first = false;
				k--;
				do{
					k++;
					if(k>max) max = k;
					String current = cardsStacks.get(k).peek();
					face = current.charAt(0);
					suit = current.charAt(1);
					if(k>=1){
						oplCard = cardsStacks.get(k-1).peek();
						first = /*(*/face==oplCard.charAt(0) || suit==oplCard.charAt(1)/*)*/; 
					}
					if(k>=3){
						tplCard = cardsStacks.get(k-3).peek();
						third = /*(tplCard!=null && (*/face==tplCard.charAt(0) || suit==tplCard.charAt(1)/*))*/;
					}
				}while(!third && !first && k<cardsStacks.size()-1);
								
				//bw.write(cardsStacks.get(k).peek()+"\n");
				/*
				for (int i = 0; i < max+1; i++) {
					bw.write(cardsStacks.get(i)+"");
				}
				bw.write("\n");
				*/
				Stack<String> cs = cardsStacks.get(k);
				int prev = k;
				//bw.write("k:"+k+"\n");
				if(third){
					//bw.write("tercero\n");
					k = k-3;
				}else if(first){
					//bw.write("primero\n");
					k = k-1;
				}else{
					//bw.write("ninguno\n");					
				}
				//bw.write("prev:"+prev+"\n");
				//bw.write("k:"+k+"\n");
				if(prev!=k){
					Stack<String> ns = cardsStacks.get(k);
					ns.push(cs.pop());
					if(cs.isEmpty()){
						cardsStacks.remove(prev);
						max--;
						if(max<k) max = k;
					}
				}
				//bw.write(cardsStacks.get(k).peek()+"\n");
				/*
				for (int i = 0; i < max+1; i++) {
					bw.write(cardsStacks.get(i)+"");
				}
				bw.write("\n");
				*/
			}while(k<cardsStacks.size() && (first||third));
			
			int numberStack = cardsStacks.size();
			String s = "";
			if(numberStack>1){
				s = "s";
			}
			bw.write(numberStack+" pile"+s+" remaining:");
			for (int i = 0; i < cardsStacks.size(); i++) {
				bw.write(" "+cardsStacks.get(i).size());
			}
			bw.write("\n");
		}
				
		br.close();
		bw.close();
	}
}
