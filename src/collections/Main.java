package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import collections.Cinema.Assento;

public class Main {
	
	 public static void main(String[] args) {
		 
		 Cinema cinema = new Cinema(14, 14);
		 cinema.reservarAssento("A08");
		 cinema.reservarAssento("A27");
		 cinema.reservarAssento("H13");
		 cinema.reservarAssento("T01");
		 
		 List<Assento> copiaReferenciaDeCinema = new ArrayList<>(cinema.getAssentos()); // *
		 copiaReferenciaDeCinema.get(0).reservar();
		 if(cinema.reservarAssento("A01")) {
			 System.out.println("Assento reservado com sucesso.");
		 } else {
			 // O assento havia sido reservado pelo objeto copiaDeCinema
			 // O assento esta indisponivel pois a lista copiaDeCinema carrega referencia ao mesmo espaco de memoria de cinema.assentos
			 System.out.println("Assento indisponivel."); 
		 }
		 
		 System.out.println("Collection em ordem reversa\n"); 
		 Collections.reverse(copiaReferenciaDeCinema); 
		 printList(copiaReferenciaDeCinema);
		 
		 System.out.println("Collection embaralhada\n"); 
		 Collections.shuffle(copiaReferenciaDeCinema); 
		 printList(copiaReferenciaDeCinema);
		 
		 List<Integer> listaDeInteiros = new ArrayList<>();
		 listaDeInteiros.add(0, 3); 
		 listaDeInteiros.add(1, 8);
		 listaDeInteiros.add(2, 1029);
		 
		 // So é possível utilizar o metodo Collections.copy caso o destination ja tenha o mesmo numero de objetos e inicializados
		 List<Integer> copiaListaDeInteiros =  new ArrayList<>();
		 for (int i = 0; i < listaDeInteiros.size(); i++) {
			 copiaListaDeInteiros.add(i);
		 }
		 Collections.copy(copiaListaDeInteiros, listaDeInteiros); 
		 copiaListaDeInteiros.add(2, -15);
		 
		 System.out.println("Lista de inteiros index 2:" + listaDeInteiros.get(2) + "\n");
		 System.out.println("Copia lista de inteiros index 2:" + copiaListaDeInteiros.get(2) + "\n");

	 }
	 
	 public static void printList(List<Assento> lista) {
		 for(Assento a: lista) {
			 System.out.println(" " + a.getNumAssento());
		 }
		 System.out.println("_________________________________________________________________________________________________");
	 }
	 
	 

}