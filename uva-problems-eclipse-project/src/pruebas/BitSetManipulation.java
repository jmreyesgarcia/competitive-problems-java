package pruebas;
import java.util.BitSet;


public class BitSetManipulation {
	public static void main(String[] args){
		int a = 5;
		BitSet bs = BitSet.valueOf(new long[]{a});
		System.out.println(bs.length());
		System.out.println(bs.size());
		System.out.println(bs);
		for(int i=bs.length()-1;i>=0;i--){
			System.out.print((bs.get(i)?1:0)+" ");
		}
		System.out.println("");
		BitSet bs2 = new BitSet(65);
		System.out.println(bs2.length());
		System.out.println(bs2.size());
		for(int i=bs2.size()-1;i>=0;i--){
			System.out.print((bs2.get(i)?1:0)+" ");
		}
		System.out.println("");
		bs2.or(bs);
		for(int i=bs2.size()-1;i>=0;i--){
			System.out.print((bs2.get(i)?1:0)+" ");
		}
		System.out.println("");
	}
}
