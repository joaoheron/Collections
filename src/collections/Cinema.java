package collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Cinema {
	
    public List<Assento> assentos = new ArrayList<>();
    
	static final Comparator<Assento> PRICE_ORDER = new Comparator<Assento>() {
		@Override
		public int compare(Assento a1, Assento a2) {
			if (a1.getPreco() > a2.getPreco()) {
				return 1;
			}
			else if (a1.getPreco() < a2.getPreco()) {
				return -1;
			}
			return 0;
		}
	};

    public Cinema(int numFileiras, int assentosPorFileira) {
    	// Realizando iteracao utilizando char
        int ultimaFileira = 'A' + (numFileiras -1);
        for (char fileira = 'A'; fileira <= ultimaFileira; fileira++) {
            for(int numAssento = 1; numAssento <= assentosPorFileira; numAssento++) {
            	double price = 10.00;
            	if (fileira > 'D') {
            		price = 15.00;
            	}
                Assento assento = new Assento(fileira + String.format("%02d", numAssento), price);
                assentos.add(assento);
            }
        }
    }
    
    public Collection<Assento> getAssentos() {
    	return this.assentos;
    }

    public boolean reservarAssento(String num) {
    	Assento assentoPretendido = new Assento(num, 0);
    	// Utilizacao de busca binaria para encontrar mais eficientemente os assento pretenddido
    	int assentoEncontrado = Collections.binarySearch(assentos, assentoPretendido, null);
    	if(assentoEncontrado >= 0 ) {
    		return assentos.get(assentoEncontrado).reservar();
    	}
    	else {
    		System.out.println("Assento nao encontrado");
    		return false;
    	}
    }

    public class Assento implements Comparable<Assento> {
        private final String numero;
        private double preco;
        private boolean reservado = false;

        public Assento(String numero, double preco) {
            this.numero = numero;
            this.preco = preco;
        }
        
        public Assento(String numero) {
        	this.numero = numero;
        }
        
        public double getPreco() {
        	return this.preco;
        }

        @Override
        public int compareTo(Assento seat) {
            return this.numero.compareToIgnoreCase(seat.getNumAssento());
        }

        public boolean reservar() {
            if(!this.reservado) {
                this.reservado = true;
                System.out.println("Assento " + numero + " reservado com sucesso.");
                return true;
            } else {
                return false;
            }
        }

        public boolean cancelarReserva() {
            if(this.reservado) {
                this.reservado = false;
                System.out.println("Reserva do assento " + numero + " cancelada.");
                return true;
            } else {
                return false;
            }
        }

        public String getNumAssento() {
            return numero;
        }
    }
}
