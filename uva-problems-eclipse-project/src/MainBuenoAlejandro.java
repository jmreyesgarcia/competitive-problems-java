import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class MainBuenoAlejandro {

	public static interface IPila<T> {

		public abstract void push(T nuevo);

		public abstract void pop();

		public abstract NodoPila<T> top();

		public abstract boolean isEmpty();

	}

	public static class Pila<T> implements IPila<T> {

		private NodoPila<T> top;

		public Pila() {
			top = null;
		}
		
		public String toString(){
			String cad = "";
			NodoPila<T> actual = top;
			String sep = "";
			while(actual!=null){
				cad = actual.getItem() + sep + cad;
				sep = ", ";
				actual = actual.getSiguiente();
			}
			cad = "["+cad+"]";
			return cad;
		}

		@Override
		public void push(T nuevo) {
			// TODO Auto-generated method stub
			NodoPila<T> t = top;
			top = new NodoPila<T>(nuevo, t);
		}

		@Override
		public void pop() {
			// TODO Auto-generated method stub
			if (!isEmpty()) {
				top = top.getSiguiente();
			}
		}

		@Override
		public NodoPila<T> top() {
			// TODO Auto-generated method stub
			return top;
		}

		@Override
		public boolean isEmpty() {
			// TODO Auto-generated method stub
			return top == null;
		}

		public int size() {
			int size = 0;
			while (!isEmpty()) {
				this.pop();
				size++;
			}
			return size;
		}

	}

	public static class NodoPila<T> {

		private T item;

		private NodoPila<T> siguiente;

		public NodoPila(T i, NodoPila<T> sig) {
			item = i;
			siguiente = sig;
		}

		public T getItem() {
			return item;
		}

		public void setItem(T item) {
			this.item = item;
		}

		public NodoPila<T> getSiguiente() {
			return siguiente;
		}

		public void setSiguiente(NodoPila<T> siguiente) {
			this.siguiente = siguiente;
		}

	}

	public static void main(String[] args) {

		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		int lineas = 0;
		String juego = "";
		ArrayList<String> juegos = new ArrayList<String>();
		try {
			String linea = reader.readLine();
			while (!linea.equals("#")) {
				juego += linea + " ";
				lineas++;
				if (lineas == 2) {
					juegos.add(juego);
					lineas = 0;
					juego = "";
				}
				linea = reader.readLine();
			}

			for (int a = 0; a < juegos.size(); a++) {
				ArrayList<Pila<String>> pilas = new ArrayList<Pila<String>>();

				String[] cards = juegos.get(a).split(" ");

				int c = 0;

				while (c < cards.length) {
					for (int i = 0; i < pilas.size(); i++) {
						System.out.print(pilas.get(i));
					}
					System.out.println("");
					
					Pila<String> nueva = new Pila<String>();
					nueva.push(cards[c]);
					pilas.add(nueva);

					for (int i = 0; i < pilas.size(); i++) {
						int i1 = i - 1;
						int i2 = i - 3;
						boolean cambio = false;
						String act2 = (String) (pilas.get(i).top().getItem());
						if (i2 >= 0) {
							String ant2 = (String) (pilas.get(i2).top()
									.getItem());
							if (ant2.charAt(0) == act2.charAt(0)
									|| ant2.charAt(1) == act2.charAt(1)) {
								String cambis = pilas.get(i).top().getItem();
								pilas.get(i).pop();
								pilas.get(i2).push(cambis);
								if (pilas.get(i).isEmpty()) {
									pilas.remove(i);
								}
								cambio = true;
								i -= 4;
							}
							if (i1 >= 0 && !cambio) {
								String ant = (String) (pilas.get(i1).top()
										.getItem());
								if (ant.charAt(0) == act2.charAt(0)
										|| ant.charAt(1) == act2.charAt(1)) {
									String cambis = pilas.get(i).top()
											.getItem();
									pilas.get(i).pop();
									pilas.get(i1).push(cambis);
									if (pilas.get(i).isEmpty()) {
										pilas.remove(i);
									}
									cambio = true;
									i -= 2;
								}

							}

						}
						if (i1 >= 0 && !cambio) {
							String ant = (String) (pilas.get(i1).top()
									.getItem());
							if (ant.charAt(0) == act2.charAt(0)
									|| ant.charAt(1) == act2.charAt(1)) {
								String cambis = pilas.get(i).top().getItem();
								pilas.get(i).pop();
								pilas.get(i1).push(cambis);
								if (pilas.get(i).isEmpty()) {
									pilas.remove(i);
								}
								i -= 2;
							}

						}

					}
					c++;
				}

				String salida = "";
				if (pilas.size() == 1) {
					salida = pilas.size() + " pile remaining:";
				} else {
					salida = pilas.size() + " piles remaining:";
				}

				for (int j = 0; j < pilas.size(); j++) {
					salida += " " + pilas.get(j).size();
				}
				System.out.println(salida);

				reader.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
