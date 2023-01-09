package personnages;

public class Commercant extends Humain {

	public Commercant(String nom, int argent) {
		super(nom, "thé", argent);
	}
	
	public int seFaireExtorquer() {
		int argentperdu=argent;
		perdreArgent(argent);
		parler("J'ai tout perdu ! Le monde est trop injuste...");
		return argentperdu;
	}
	
	public void recevoirArgent(int argentrecu) {
		gagnerArgent(argentrecu);
		parler(argentrecu + " sous ! Je te remercie genereux donateur !");
	}
	
}
