package histoire;

import personnages.Commercant;
import personnages.GrandMere;
import personnages.Humain;
import personnages.Ronin;
import personnages.Samourai;
import personnages.Traitre;
import personnages.Yakuza;

public class HistoireTP5 {
	
	public static void main(String args[]) {
		
		Commercant marco = new Commercant("Marco", 20);
		Commercant chonin = new Commercant("Chonin", 40);
		Commercant kumi = new Commercant("Kumi", 10);
		Yakuza yaku = new Yakuza("Yaku Le Noir", "whisky", 30, "Warsong");
		Ronin roro = new Ronin("Roro", "shochu", 60);
		Samourai akimoto = new Samourai("Miyamoto", "Akimoto", "saké", 80);
		Traitre masako = new Traitre("Miyamoto", "Masako", "whisky", 100);
		GrandMere grandMere = new GrandMere("Grand-Mère", 10);

		
//		marco.faireConnaissanceAvec(roro);
//		marco.faireConnaissanceAvec(chonin);
//		marco.faireConnaissanceAvec(kumi);
//		marco.faireConnaissanceAvec(yaku);
//		marco.listeConnaissances();
//		yaku.listeConnaissances();
		
//		akimoto.faireConnaissanceAvec(marco);
//		akimoto.listeConnaissances();
//		akimoto.boire("chocolat chaud");
		
		
//		masako.faireLeGentil();
//		masako.ranconner(kumi);
//		masako.ranconner(chonin);
//		masako.ranconner(marco);
//		akimoto.faireConnaissanceAvec(masako);
//		masako.ranconner(kumi);
//		masako.faireConnaissanceAvec(yaku);
//		masako.faireLeGentil();
//		masako.faireConnaissanceAvec(roro);
		
		
		grandMere.faireConnaissanceAvec(akimoto);
		grandMere.faireConnaissanceAvec(yaku);
		grandMere.faireConnaissanceAvec(masako);
		grandMere.faireConnaissanceAvec(kumi);
		grandMere.faireConnaissanceAvec(marco);
		grandMere.faireConnaissanceAvec(chonin);
		grandMere.ragoter();
	}
}
