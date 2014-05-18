package stock;

public class GestionStock {

	public static void main(String[] args) {
		StockArticles st = new StockArticles("entrepot");
		st.creerArticle("veste", 54.99, new String[] {"XS", "S", "M", "L", "XL"});
		st.ajouterQuantite("veste", "L", 13);
		st.ajouterQuantite("veste", "M", 22);
		st.ajouterQuantite("veste", "S", 9);
		
		st.creerArticle("pantalon", 104.99, new String[] {"XS", "S", "M", "L", "XL"});
		st.ajouterQuantite("pantalon", "XL", 44);
		st.ajouterQuantite("pantalon", "M", 52);
		st.ajouterQuantite("pantalon", "XS", 19);
		
		st.ajouterQuantite("pull", "XS", 19);
		
		System.out.println("Taille du stock '" + st.getNom() + "' : " + st.tailleDuStock() + " pièces.\n");
		System.out.println("Valeur du stock '" + st.getNom() + "' : " + st.valeurDuStock() + " euros.\n");
	}

}
