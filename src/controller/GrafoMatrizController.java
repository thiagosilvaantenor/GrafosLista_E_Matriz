package controller;

import model.estrutura.grafo.GrafoMatriz;

public class GrafoMatrizController {
	public GrafoMatrizController() {
		super();
	}

	public String teste() throws Exception {
		String[] routers = new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O" };
		GrafoMatriz g = new GrafoMatriz(routers);

		g.link("A", "B");
		g.link("B", "C");
		g.link("A", "D");
		g.link("F", "A");
		g.link("C", "J");
		g.link("J", "N");
		g.link("N", "O");
		g.link("O", "H");
		g.link("H", "D");
		g.link("D", "G");
		g.link("G", "L");
		g.link("L", "K");
		g.link("K", "F");
		g.link("C", "I");
		g.link("I", "J");
		g.link("J", "E");
		g.link("E", "H");
		g.link("F", "H");
		g.link("I", "D");
		g.link("L", "M");
		g.link("M", "N");

		// g.link("A", "B");
		// g.link("A", "D");
		// g.link("B", "C");
		// g.link("C", "D");
		// g.remover("C");

		return g.toString();
	}
}