import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;


public class Main_10901_FerryLoadingIII {
	public static class Car implements Comparable<Car>{
		int arriveOneSide;
		int arriveOtherSide;
		public Car(int one){
			arriveOneSide = one;
			arriveOtherSide = -1;
		}
		@Override
		public int compareTo(Car o) {
			if(arriveOneSide<o.arriveOneSide){
				return -1;
			}else if(arriveOneSide>o.arriveOneSide){
				return 1;
			}else{
				return 0;
			}
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String line = br.readLine();
		String separator = "";
		int c = Integer.parseInt(line);
		for (int i = 0; i < c; i++) {
			bw.write(separator);
			separator = "\n";
			line = br.readLine();
			String[] values = line.split(" ");
			int n = Integer.parseInt(values[0]);
			int t = Integer.parseInt(values[1]);
			int m = Integer.parseInt(values[2]);
			
			Queue<Car> qLeft  = new LinkedList<>();
			Queue<Car> qRight = new LinkedList<>();
			
			int k = 0;
			Car[] allCars = new Car[m];
			for (int j = 0; j < m; j++) {
				line = br.readLine();
				values = line.split(" ");
				int time = Integer.parseInt(values[0]);
				Car nc = new Car(time);
				if(values[1].equals("left")){
					qLeft.offer(nc);
				}else{
					qRight.offer(nc);					
				}
				allCars[k++] = nc;
			}
			
			//bw.write(q.toString()+"\n");
			//bw.flush();
			
			int currentTime = 0;
			int side = 0; //0 for left and 1 otherwise
			
			@SuppressWarnings("unchecked")
			Queue<Car>[] q = new Queue[]{qLeft,qRight};
			while(!qLeft.isEmpty() || !qRight.isEmpty()){
				//bw.write("\nnow in "+(side?"right":"left")+"\n");
				int capacity = n;
				while(capacity>0 && !q[side].isEmpty() && q[side].peek().arriveOneSide<=currentTime){
					//int timeCar = Math.abs(q.peek());
					Car theCar = q[side].poll();
					//bw.write((currentTime+t)+"\n");
					theCar.arriveOtherSide = currentTime+t;
					//bw.flush();
					capacity--;
				}
				//bw.write("passing the time from "+currentTime+" to "+(currentTime+t)+"\n");
				int otherSide = (side+1)%2;
				if(capacity<n || (!q[otherSide].isEmpty() && q[otherSide].peek().arriveOneSide<=currentTime)){
					side = otherSide;
					currentTime += t;
				}else{
					currentTime += 1;
				}				
			}
			//Arrays.sort(allCars);
			for (int j = 0; j < allCars.length; j++) {
				//bw.write(allCars[j].arriveOneSide+"-"+allCars[j].arriveOtherSide+"\n");
				bw.write(allCars[j].arriveOtherSide+"\n");
			}
		}
		
		bw.close();
		br.close();
	}

}
