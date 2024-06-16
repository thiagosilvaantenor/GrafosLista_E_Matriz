package model.estrutura.grafo;

import java.util.*;
import model.estrutura.listaencadeada.ListaEncadeadaSimples;
import model.estrutura.listaencadeada.No;

public class GrafoLista<T> {
	// Vou escolher para este exemplo uma lista por LABEL
	private Map<T, ListaEncadeadaSimples<T>> map = new HashMap<>();

	// add: Adiciona um novo elemento
	// has: verifica se existe um elemento
	// size: Retorna o número de elemento
	// toString(): imprime na tela
	//

	public void add(T source) {
		map.put(source, new ListaEncadeadaSimples<T>());
	}

	public void add(T source, T destination) {
		// Verifica se já existe um item com essa chave, caso não cria um(Ex:
		// source(A):destination(B))
		if (!map.containsKey(source))
			add(source);
		// Verifica se já existe um item cuja a chave é o valor do item da chave
		// (source) Ex: existe um source(B)? Se não, cria um
		if (!map.containsKey(destination))
			add(destination);
		// Coloca o valor associada a chave Ex: A:B
		map.get(source).append(destination);
		// Faz o caminho inverso da linha de cima, Ex: B:A
		map.get(destination).append(source);
	}

	public boolean has(T s) {
		return map.containsKey(s);
	}

	public boolean has(T s, T d) throws IllegalArgumentException {
		ListaEncadeadaSimples<T> achado = map.get(s);
		if (achado == null) {
			throw new IllegalArgumentException("Chave inexistente");
		}
		No<T> buffer = achado.getInicio();

		while (buffer != null) {
			if (buffer.getValor().equals(d)) {
				break;
			}
			buffer = buffer.getProximo();
		}

		if (buffer == null)
			return false;
		else
			return true;
	}

	public int size() {
		return map.keySet().size();
	}

	public void remove(T key) {
		// remove da lista
		map.remove(key);
		for (T item: map.keySet()) {
			ListaEncadeadaSimples<T> listaItem = map.get(item);
			No<T> buffer = listaItem.getInicio();
			while (buffer != null){
				if(buffer.getValor().equals(key)){
					int indice = listaItem.index(key);
					listaItem.remove(indice);
				}
				buffer = buffer.getProximo();
			}
		}

	}

	// Escrever um output do grafo
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();

		for (T v : map.keySet()) {
			builder.append(v.toString() + ": ");
			No<T> buffer = map.get(v).getInicio();
			while (buffer != null) {
				builder.append(buffer.toString() + " ");
				buffer = buffer.getProximo();
			}
			builder.append("\n");
		}
		return (builder.toString());
	}

}