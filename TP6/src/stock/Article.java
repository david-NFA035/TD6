package stock;

import java.util.ArrayList;
import java.util.HashMap;

public class Article {
	
	private String nom;
	private ArrayList<String>tailles; //{"XXS", "XS", "S", "M", "L", "XL", "XXL"};
	private double prix;
	private HashMap<String, Integer> quantites;
	
	public String getNom() {
		return nom;
	}
	public double getPrix() {
		return prix;
	}
	
	public void afficheTaillesDisponibles(){
		for (String s : tailles.toArray(new String[tailles.size()])){
			if (quantites.get(s) != 0) System.out.println(s + ", ");
		}
	}
	
	public void ajouterTaille(String taille){
		taille = taille.toUpperCase();
		if (! tailles.contains(taille)){
		    tailles.add(taille);
		    quantites.put(taille, 0);
		}
	}
	
	public void ajouterQuantite(String taille, int qt){
		taille = taille.toUpperCase();
		ajouterTaille(taille);
		quantites.put(taille, quantites.get(taille) + qt);
		
	}
	
	public void retirerQuantite(String taille, int qt){
		taille = taille.toUpperCase();
		if (quantites.get(taille) >= qt){
		    quantites.put(taille, quantites.get(taille) - qt);
		}
		else throw new RuntimeException();
	}
	
	public int quantiteDisponible(String taille){
		taille = taille.toUpperCase();
		return quantites.get(taille);
	}
	
	void afficheDetailArticle(){
		System.out.println(nom + " #######################\n" +
	                       prix + "\n");
		for (String s : tailles.toArray(new String[tailles.size()])){
			System.out.println(s + " : " + quantiteDisponible(s) + " disponibles\n");
		}
	}
	
	public Article(String nom, double prix) {
		this.nom = nom;
		this.prix = prix;
		this.tailles = new ArrayList<String>();
		this.quantites = new HashMap<String, Integer>();
	}
	
	public void afficheExemplaires(){
		
	    int total = 0;
	    for (String s : tailles.toArray(new String[tailles.size()])){
			total += quantiteDisponible(s);
		}
		System.out.println(nom + " : " + total + " en stock\n");
		
		
	}
	
    public int nombreExemplaires(){
		
	    int total = 0;
	    for (String s : tailles.toArray(new String[tailles.size()])){
			total += quantiteDisponible(s);
		}
		return total;
		
		
	}

}
