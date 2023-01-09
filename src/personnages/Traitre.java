package personnages;

import java.util.Random;

public class Traitre extends Samourai{
	private int niveauTraitrise=0;

	public Traitre(String seigneur, String nom, String boissonFavorite, int argent) {
		super(seigneur, nom, boissonFavorite, argent);
	}
	
	@Override
	public void direBonjour() {
		super.direBonjour();
		parler("Mais je suis un traitre et mon niveau de traitrise est de " + niveauTraitrise + ". Chut!");
	}
	
	public void ranconner(Commercant commercant) {
		if (niveauTraitrise<3) {
			int argentRanconne;
			int argentCommercant;
			argentCommercant=commercant.getArgent();
			argentRanconne= 2*argentCommercant/10;
			commercant.perdreArgent(argentRanconne);
			gagnerArgent(argentRanconne);
			niveauTraitrise++;
			parler("Si tu veux ma protection contre les yakuzas, il va falloir payer ! Donne-moi " +
			argentRanconne + " sous ou gare a toi !");
			commercant.parler("Tout de suite, grand " + getNom() + ".");
		} else {
			parler("Mince, je ne peux plus ranconner personne sinon un samourai risque de me demasquer!");
		}
	}
	
	public void faireLeGentil() {
		if (nbConnaissances<1) {
			parler("Je ne peux faire ami-ami avec personne car je ne connais personne! Snif.");
		} else {
			Random random = new Random();
			int rangAmi=random.nextInt(0,nbConnaissances);
			int don = argent/20;
			String nomAmi=memoire[rangAmi].getNom();
			parler("Il faut absolument remonter ma cote de confiance. Je vais faire ami-ami avec " + nomAmi + ".");
			parler("Bonjour l'ami!  Je voudrais vous aider en vous donnant " + don + " sous.");
			perdreArgent(don);
			memoire[rangAmi].gagnerArgent(don);
			memoire[rangAmi].parler("Merci " + nom + ". Vous etes quelqu'un de bien.");
			if (niveauTraitrise>1) {
				niveauTraitrise--;
			}
		}
	}
}
