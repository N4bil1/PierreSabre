package personnages;

public class Ronin extends Humain {
	
	private int honneur=1;

	public Ronin(String nom, String boissonFavorite, int argent) {
		super(nom, boissonFavorite, argent);
	}
	
	public void donner(Commercant beneficiaire) {
		int argentDonne = argent/10;
		parler(beneficiaire.getNom() + ", prend ces " + argentDonne + " sous.");
		beneficiaire.recevoirArgent(argentDonne);
		perdreArgent(argentDonne);
	}
	
	public void provoquer(Yakuza adversaire) {
		int force=2*honneur;
		parler("Viens te battre, vermine !");
		if (force >= adversaire.getReputation()) {
			parler("Je t'ai eu petit yakuza !");
			gagnerArgent(adversaire.perdre());
			honneur+=1;
		} else {
			parler("J'ai perdu contre ce yakuza, mon honneur et ma bourse en ont pris un coup.");
			adversaire.gagner(argent);
			perdreArgent(argent);
			honneur-=1;
		}
	}
	
}
