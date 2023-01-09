package personnages;

import java.util.Random;

public class GrandMere extends Humain{
	
	private enum TypeHumain {
		COMMERCANT("un commercant"), RONIN("un ronin"), SAMOURAI("un samourai"), 
		YAKUZA("un yakuza"), GRANDMERE("une grand-mere"), HUMAIN("un habitant");
		
		private String nom;
		
		private TypeHumain(String nom) {
			this.nom=nom;
		}

		public String getNom() {
			return nom;
		}
	}


	public GrandMere(String nom, int argent) {
		super(nom, "tisane", argent);
	}
	
	@Override
	protected void memoriser(Humain autreHumain) {
		if (nbConnaissances<5) {
			memoire[nbConnaissances]=autreHumain;
			nbConnaissances+=1;
		} else {
			parler("Oh ma tete ! Je ne peux plus retenir le nom d'une personne supplementaire !");
		}
	}
	
	public String humainHasard() {
		Random random = new Random();
		TypeHumain[] types = TypeHumain.values();
		String typehumain = types[random.nextInt(0,types.length)].getNom();
		return typehumain;
	}
	
	public void ragoter() {
		for(int i=0; i<nbConnaissances; i++) {
			if (memoire[i] instanceof Traitre) {
				parler("Je sais que " + memoire[i].getNom() + " est un traitre.");
			} else {
				parler("Je crois que " + memoire[i].getNom() + " est " + humainHasard() + "." );
			}
		}
	}
}
