import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;


public class TestCasesGenerator_12356_ArmyBuddies {
	public static final int MAX_CASES = 1;
	
	public static class Pair<K, V> {

	    private final K element0;
	    private final V element1;

	    public static <K, V> Pair<K, V> createPair(K element0, V element1) {
	        return new Pair<K, V>(element0, element1);
	    }

	    public Pair(K element0, V element1) {
	        this.element0 = element0;
	        this.element1 = element1;
	    }

	    public K getElement0() {
	        return element0;
	    }

	    public V getElement1() {
	        return element1;
	    }

	}
	
	public static void main(String[] args) throws IOException{
		BufferedWriter bw = new BufferedWriter(new FileWriter("12356_ArmyBuddies_input.txt"));
		
		for(int i=0;i<MAX_CASES;i++){
			System.out.println("inicio de caso "+i);
			int s = 1 + (int)(Math.random()*100000);
			int possibleB = 1 + (int)(Math.random()*s);
			ArrayList<Pair<Integer,Integer>> intervals = new ArrayList<>();
			intervals.add(new Pair<>(1,s));
			int j=0;
			LinkedList<Pair<Integer,Integer>> reports = new LinkedList<>();
			while(j<possibleB && intervals.size()>0){
				System.out.println("caso "+i+", generando el reporte "+j+" de "+possibleB+" posibles");
				int posCurrentInterval = (int)(Math.random()*intervals.size());
				Pair<Integer,Integer> currentInterval = intervals.get(posCurrentInterval);
				int l = currentInterval.getElement0() + (int)(Math.random()*(currentInterval.getElement1()-currentInterval.getElement0()+1));
				int r = l + (int)(Math.random()*(currentInterval.getElement1()-l+1));
				reports.offer(new Pair<>(l, r));
				j++;
			}
			bw.write(s+" "+j+"\n");
			while(!reports.isEmpty()){
				Pair<Integer,Integer> p = reports.poll();
				bw.write(p.getElement0()+" "+p.getElement1()+"\n");
			}
		}
		bw.write("0 0");
		bw.close();
	}
}
