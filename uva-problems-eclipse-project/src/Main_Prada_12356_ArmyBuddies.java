import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main_Prada_12356_ArmyBuddies {

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new FileReader("12356_ArmyBuddies_input_1.txt"));
		BufferedWriter out = new BufferedWriter(new FileWriter("outputPrada_1.txt"));

		String linea = "";

		while (!(linea = in.readLine()).equals("0 0")) {

			StringTokenizer valores = new StringTokenizer(linea);

			int soldados = Integer.parseInt(valores.nextToken());
			int reportes = Integer.parseInt(valores.nextToken());

			int[] armyL = new int[soldados + 1];
			int[] armyH = new int[soldados + 1];

			while (reportes > 0) {
				StringTokenizer rep = new StringTokenizer(in.readLine());
				int ini = Integer.parseInt(rep.nextToken());
				int fin = Integer.parseInt(rep.nextToken());

				if (ini - 1 > 0) {

					if (armyL[ini - 1] == 0) {
						armyL[ini] = ini - 1;
					} else {
						armyL[ini] = armyL[ini - 1];
						if (fin + 1 < armyL.length) {
							if (armyL[ini - 1] != -1) {
								if(armyH[armyL[ini - 1] + 1] == 0){
									armyH[armyL[ini - 1] + 1] = fin + 1;
								}else{
									if(armyH[fin+1] == -1 || armyH[fin+1]>fin+1){
										armyH[armyL[ini - 1] + 1] = armyH[fin + 1];
									}else{
										armyH[armyL[ini - 1] + 1] = fin + 1;
									}
								}
							}
						} else {
							if (armyL[ini - 1] != -1) {
								armyH[armyL[ini - 1] + 1] = -1;
							}
						}
					}
				} else {
					armyL[ini] = -1;
				}

				if (fin + 1 < armyL.length) {
					if (armyH[fin + 1] == 0) {
						armyH[fin] = fin + 1;
					} else {
						armyH[fin] = armyH[fin + 1];
						if (ini - 1 > 0) {
							if (armyH[fin + 1] != -1) {
								if(armyL[armyH[fin + 1] - 1] ==0){
									armyL[armyH[fin + 1] - 1] = ini - 1;
								}else{
									if(armyL[ini-1] == -1 || armyL[ini-1]>ini-1){
										armyL[armyH[fin + 1] - 1] = armyL[ini - 1];
									}else{
										armyL[armyH[fin + 1] - 1] = ini - 1;
									}
								}
							}
						} else {
							if (armyH[fin + 1] != -1) {
								armyL[armyH[fin + 1] - 1] = -1;
							}
						}
					}
				} else {
					armyH[fin] = -1;
				}

				if (ini + 1 < armyL.length && fin + 1 < armyL.length) {
					if (armyH[ini + 1] == 0) {
						if (armyH[fin + 1] == 0) {
							armyH[ini] = fin + 1;
						} else {
							armyH[ini] = armyH[fin + 1];
						}
					} else {
						armyH[ini] = armyH[ini + 1];
					}

				} else {
					armyH[ini] = -1;
				}

				if (fin - 1 > 0 && ini - 1 > 0) {
					if (armyL[fin - 1] == 0) {

						if (armyL[ini - 1] == 0) {
							armyL[fin] = ini - 1;
						} else {
							armyL[fin] = armyL[ini - 1];
						}

					} else {
						armyL[fin] = armyL[fin - 1];
					}
				} else {
					armyL[fin] = -1;
				}

				String answ = "";
				if (armyL[ini] != -1) {
					answ += armyL[ini] + " ";
				} else {
					answ += "* ";
				}

				if (armyH[ini] != -1) {
					answ += armyH[ini];
				} else {
					answ += "*";
				}
				out.write(answ + "\n");
				reportes--;
			}

			out.write("-\n");

		}

		out.flush();
		out.close();
		in.close();

	}
}