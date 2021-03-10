package it.polito.tdp.parole.model;

import java.util.*;

public class Parole {
	
	List<String> parole;
		
	public Parole() {
		parole = new LinkedList<String>();
	}
	
	public void addParola(String p) {
		parole.add(p);
	}
	
	public List<String> getElenco() {
		parole.sort((p1, p2) -> p1.compareTo(p2));
		return parole;
	}
	
	public void reset() {
		parole.clear();
	}
	
	public List<String> remove(String word) {
		for(int i = 0; i < parole.size(); i++)
			if(parole.get(i).equals(word))
				parole.remove(i);
		return getElenco();
	}

}
