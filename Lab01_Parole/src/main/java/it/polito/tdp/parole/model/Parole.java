package it.polito.tdp.parole.model;


import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Parole {
		LinkedList<String> listaParole = new LinkedList<String>();
		
	public Parole() {
		
	}
	
	public void addParola(String p) {
		listaParole.add(p);
		Collections.sort(listaParole);
		
	}
	
	public List<String> getElenco() {
		
		return listaParole;
	}
	
	public void reset() {
		listaParole.removeAll(listaParole);
		
	}

	public void removeParola(String p) {
		for(Object s : listaParole.toArray()) {
    		if(s.equals(p)) {
    			listaParole.remove(s);
    		}
    	}
	}
}
