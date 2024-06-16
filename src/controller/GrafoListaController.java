package controller;

import model.estrutura.grafo.GrafoLista;

public class GrafoListaController {
	public GrafoListaController() {
		super();
	}

	public String teste() throws Exception {
		GrafoLista g = new GrafoLista<>();

		// g.add(0,1);
		// g.add(0,4);
		// g.add(1,2);
		// g.add(1,3);
		// g.add(1,4);
		// g.add(2,3);
		// g.add(3,4);
		// g.remove(1);

		g.add("A", "B");
		g.add("B", "C");
		g.add("A", "D");
		g.add("F", "A");
		g.add("C", "J");
		g.add("J", "N");
		g.add("N", "O");
		g.add("O", "H");
		g.add("H", "D");
		g.add("D", "G");
		g.add("G", "L");
		g.add("L", "K");
		g.add("K", "F");
		g.add("C", "I");
		g.add("I", "J");
		g.add("J", "E");
		g.add("E", "H");
		g.add("F", "H");
		g.add("I", "D");
		g.add("L", "M");
		g.add("M", "N");

		return g.toString();
	}
}