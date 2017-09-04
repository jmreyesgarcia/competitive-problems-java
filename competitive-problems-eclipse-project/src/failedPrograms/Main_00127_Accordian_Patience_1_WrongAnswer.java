package failedPrograms;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Stack;


public class Main_00127_Accordian_Patience_1_WrongAnswer {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String line1;
		while(!(line1 = br.readLine()).equals("#")){
			String line2 = br.readLine();
			String[] cards = (line1+" "+line2).split(" ");
			ArrayList<Stack<String>> cardsStacks = new ArrayList<>();
			cardsStacks.add(new Stack<>());
			cardsStacks.get(0).push(cards[0]);
			for (int i = 1; i < cards.length; i++) {
				String current = cards[i];
				bw.write("add "+current+"\n");
				String tplCard = null;
				String oplCard = cardsStacks.get(cardsStacks.size()-1).peek();
				if(cardsStacks.size()>=3){
					tplCard = cardsStacks.get(cardsStacks.size()-3).peek();
				}
				char face = current.charAt(0);
				char suit = current.charAt(1);
				if(tplCard!=null && (face==tplCard.charAt(0) || suit==tplCard.charAt(1))){
					cardsStacks.get(cardsStacks.size()-3).push(current);
				}else if(face==oplCard.charAt(0) || suit==oplCard.charAt(1)){
					cardsStacks.get(cardsStacks.size()-1).push(current);
				}else{
					Stack<String> ns = new Stack<>();
					ns.push(current);
					cardsStacks.add(ns);
				}
				for (int j = 0; j < cardsStacks.size(); j++) {
					bw.write(cardsStacks.get(j)+"");
				}
				bw.write("\n");
				//for (int j = cardsStacks.size()-1;j>=0; j--) {
				for (int j = 0;j<cardsStacks.size(); j++) {
					Stack<String> cs = cardsStacks.get(j);
					int f = cs.peek().charAt(0);
					int s = cs.peek().charAt(1);
					
					boolean removed = false;
					Stack<String> tpls = null;
					if(j-3>=0){
						tpls = cardsStacks.get(j-3);
						while(!cs.isEmpty() && (f==tpls.peek().charAt(0) || s==tpls.peek().charAt(1))){
							tpls.push(cs.pop());
							if(!cs.isEmpty()){
								f = cs.peek().charAt(0);
								s = cs.peek().charAt(1);
							}
						}
						if(cs.isEmpty()){
							cardsStacks.remove(j);
							removed = true;
						}
					}
					if(!removed && j-1>=0){
						tpls = cardsStacks.get(j-1);
						while(!cs.isEmpty() && (f==tpls.peek().charAt(0) || s==tpls.peek().charAt(1))){
							tpls.push(cs.pop());
							if(!cs.isEmpty()){
								f = cs.peek().charAt(0);
								s = cs.peek().charAt(1);
							}
						}
						if(cs.isEmpty()){
							cardsStacks.remove(j);
							removed = true;
						}
					}
					if(removed){
						//j = cardsStacks.size()-1;
						j = 0;
					}
				}
				for (int j = 0; j < cardsStacks.size(); j++) {
					bw.write(cardsStacks.get(j)+"");
				}
				bw.write("\n");
			}
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
