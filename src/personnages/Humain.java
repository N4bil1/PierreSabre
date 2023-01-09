package personnages;

public class Humain {
	
	public static final int TAILLEMEMOIRE=30;
	
	protected String nom;
	protected String boissonFavorite;
	protected int argent;
	protected int nbConnaissances=0;
	private int personnesOubliees=0;
	protected Humain[] memoire= new Humain[TAILLEMEMOIRE];
	
	public Humain(String nom, String boissonFavorite, int argent) {
		this.nom = nom;
		this.boissonFavorite = boissonFavorite;
		this.argent = argent;
	}
	
	public String getNom() {
		return nom;
	}
	public int getArgent() {
		return argent;
	}
	
	protected void parler(String texte) {
		System.out.println("(" + nom + ") - " + texte);
	}
	
	protected void gagnerArgent(int gain) {
		argent+=gain;
	}
	
	protected void perdreArgent(int perte) {
		argent-=perte;
	}
	
	public void direBonjour() {
		parler("Bonjour, je m'appelle " + nom + " et j'aime boire du " + boissonFavorite + ".");
	}
	
	public void boire() {
		parler("Mmm, un bon verre de " + boissonFavorite + " ! GLOUPS !");
	}
	
	public void acheter(String bien, int prix) {
		if (argent>=prix) {
			parler("J'ai " + argent + " sous en poche. Je vais pouvoir m'acheter " + bien + " à " + prix + " sous!");
			argent-=prix;
		} else {
			parler("Je n'ai plus que " + argent + " sous en poche. Je ne peux même pas m'offrir un " + bien + " à " + prix + " sous.");
		}	
	}
	
	public void faireConnaissanceAvec(Humain autreHumain) {
		direBonjour();
		repondre(autreHumain);
		autreHumain.memoriser(this);
		memoriser(autreHumain);
	}
	
	private void repondre(Humain autreHumain) {
		autreHumain.direBonjour();
	}
	
	protected void memoriser(Humain autreHumain) {
		if (nbConnaissances<TAILLEMEMOIRE) {
			memoire[nbConnaissances]=autreHumain;
			nbConnaissances+=1;
		} else {
			memoire[(nbConnaissances+personnesOubliees)%TAILLEMEMOIRE]=autreHumain;
			personnesOubliees+=1;
		}
	}
	
	public void listeConnaissances() {
		parler("Je connais beaucoup de monde dont : ");
		for (int i=0; i<nbConnaissances-1; i++) {
			parler(memoire[i].getNom() + ", ");
		}
		parler(memoire[nbConnaissances-1].getNom() + ".");
	}
}
