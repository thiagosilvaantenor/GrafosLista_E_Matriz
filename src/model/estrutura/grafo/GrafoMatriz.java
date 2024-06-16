package model.estrutura.grafo;

import java.util.*;

public class GrafoMatriz<T> {
	private int[][] matriz;
	private String[] labels;

	// GrafoMatriz(String[]): Construtor, tem que receber os elementos
	// link: Liga os elementos na matriz
	// toString(): Imprime os elementos.

	public GrafoMatriz(String[] labels) {
		this.labels = labels;
		this.matriz = new int[labels.length][labels.length];
	}

	public void link(String label1, String label2) {
		int index_label1 = Arrays.asList(this.labels).indexOf(label1);
		int index_label2 = Arrays.asList(this.labels).indexOf(label2);

		this.matriz[index_label1][index_label2] = 1;
		this.matriz[index_label2][index_label2] = 1;
	}

	public void remover(T elemento) {
		int indice = indiceLabel(elemento);
		int x = 0;
		int y = 0;
		int[][] novaM = new int[this.matriz.length - 1][this.matriz.length - 1];

		for (int i = 0; i < this.matriz.length; i++) {
			if (i == indice) {
				i++;
				if (i > this.matriz.length - 1 || x > novaM.length - 1) {
					break;
				}
			}
			if (i == 0) {
				x = 0;
			} else {
				x++;
			}
			for (int j = 0; j < this.matriz.length; j++) {

				if (j == 0)
					y = 0;

				if (j == indice) {
					j++;
					if (j > this.matriz.length - 1 || y > novaM.length - 1) {
						break;
					}
				}
				novaM[x][y] = this.matriz[i][j];
				y++;
			}
		}

		String[] novoV = new String[this.labels.length - 1];
		y = 0;

		for (x = 0; x < novoV.length; x++) {
			if (labels[x].equals(elemento)) {
				x++;
				if (x > labels.length - 1) {
					break;
				}
			}
			novoV[y] = labels[x];
			y++;
		}
		this.matriz = novaM;
		this.labels = novoV;

	}

	private int indiceLabel(T elemento) throws IllegalArgumentException {
		int i = 0;
		boolean achou = false;
		for (i = 0; i < labels.length; i++) {
			if (labels[i].equals(elemento)) {
				achou = true;
				break;
			}
		}
		if (!achou) {
			throw new IllegalArgumentException("Elemento não está no vetor");
		}
		return i;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();

		for (int i = 0; i < this.labels.length; i++) {
			builder.append(this.labels[i] + ": ");
			for (int j = 0; j < this.labels.length; j++) {
				if (this.matriz[i][j] == 1) {
					builder.append(this.labels[j] + " ");
				}
			}
			builder.append("\r\n");
		}
		return (builder.toString());

	}
}