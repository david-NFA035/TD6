package stock;

import java.util.HashMap;

public class StockArticles {
	private String nom;
	private HashMap<String, Article> articles = new HashMap<String, Article>();
	
	
	public StockArticles(String nom) {
		this.nom = nom;
	}
	
	public void creerArticle(String nom, double prix, String[] tailles){
		Article temp = new Article(nom, prix);
		for (String taille : tailles){
			temp.ajouterTaille(taille);
		}
		articles.put(nom, temp);	
	}
	
	public boolean ajouterQuantite(String nom, String taille, int qt){
		if (! articles.containsKey(nom)){
			return false; 
		}
		else {
			articles.get(nom).ajouterQuantite(taille, qt);
			return true;
		}
	}
	
	public int tailleDuStock(){
	    int total = 0;
	    for (String a : articles.keySet()){
	    	total += articles.get(a).nombreExemplaires();
	    }
	    return total;
	}
	
	public double valeurDuStock(){
	    double total = 0;
	    for (String a : articles.keySet()){
	    	total += articles.get(a).nombreExemplaires() * articles.get(a).getPrix();
	    }
	    return total;
	}
	
	public String getNom() {
		return nom;
	}
}
