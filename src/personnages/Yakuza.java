package personnages;

public class Yakuza extends Humain{
	
	private String clan;
	private int reputation = 0;
	
	public Yakuza(String nom, String boissonFavorite, int argent,String clan) {
		super(nom, boissonFavorite, argent);
		this.clan = clan;
	}
	
	public int getReputation() {
		return reputation;
	}

	public void extorquerCommercant(Commercant victime) {
		parler("Tiens, tiens, ne serait-ce pas un faible marchand qui passe par là ?");
		parler(victime.getNom() + ", si tu tiens à la vie, donne moi ta bourse !");
		int argentExtorque=victime.seFaireExtorquer();
		gagnerArgent(argentExtorque);
		reputation+=1;
		parler("J'ai piqué les " + argentExtorque + " sous de " + victime.getNom() + ", ce qui me fait " + argent 
				+ " sous dans ma poche. Hi ! Hi !");
	}
	
	public int perdre() {
		int argentPerdu=argent;
		perdreArgent(argent);
		reputation-=1;
		parler("J'ai perdu mon duel et mes " + argentPerdu + " sous, snif... J'ai déshonoré le clan " + clan + ".");
		return argentPerdu;
	}
	
	public void gagner(int gain) {
		gagnerArgent(gain);
		reputation+=1;
		parler("Ce ronin pensait vraiment battre " + nom + " du clan " + clan + "? Je l'ai dépouillé de"
				+ " ses " + gain + " sous.");
	}
	
	@Override
	public void direBonjour() {
		super.direBonjour();
		parler("Mon clan est celui de " + clan);
	}
}
