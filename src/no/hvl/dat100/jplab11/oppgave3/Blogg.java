package no.hvl.dat100.jplab11.oppgave3;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.*;
import no.hvl.dat100.jplab11.oppgave2.Tekst;

public class Blogg {

	private Innlegg[] innleggtabell;
	private int nesteledig;

	public Blogg() {
		innleggtabell = new Innlegg[20];

	}

	public Blogg(int lengde) {
		innleggtabell = new Innlegg[lengde];
	}

	public int getAntall() {
//		int counter = 0;
//		for (int i = 0; i < innleggtabell.length - 1; i++) {
//
//			if (innleggtabell[i] != null) {
//
//				counter++;
//
//			}
//
//		}
//
//		return counter;

		return nesteledig;
	}

	public Innlegg[] getSamling() {

		return innleggtabell;

	}

	public int finnInnlegg(Innlegg innlegg) {

		for (int i = 0; i < nesteledig; i++) {

			if (innleggtabell[i].erLik(innlegg)) {

				return i;
			}

		}
		return -1;

	}

	public boolean finnes(Innlegg innlegg) {

		// MÅ BRUKE NESTELEDIG, IKKE TABELL.LENGTH PGA KAN IKKE BRUKE
		// erLik-METODEN PÅ "null"
		for (int i = 0; i < nesteledig; i++) {

			if (innleggtabell[i].erLik(innlegg)) {

				return true;
			}

		}
		return false;

		// BRUKER DEN TIDLIGERE METODEN
//			if (finnInnlegg((innlegg)) != -1) {
//
//				return true;
//
//			}

		// return false;
	}

	public boolean ledigPlass() {

		for (int i = 0; i < innleggtabell.length; i++) {

			if (innleggtabell[i] == null) {

				return true;

			}

		}

		return false;

	}

	public boolean leggTil(Innlegg innlegg) {

		if (!finnes(innlegg) && ledigPlass()) {

			innleggtabell[nesteledig] = innlegg;

			nesteledig++;

			return true;

		}

		return false;
	}

	public String toString() {

		String str = getAntall() + "\n";

		for (int i = 0; i < nesteledig; i++) {

			str += innleggtabell[i].toString();

		}
		return str;

	}

	// valgfrie oppgaver nedenfor

	public void utvid() {

		Innlegg[] utvidTab = new Innlegg[innleggtabell.length * 2];

		for (int i = 0; i < nesteledig; i++) {

			utvidTab[i] = innleggtabell[i];

		}

		innleggtabell = utvidTab;

	}

	public boolean leggTilUtvid(Innlegg innlegg) {

		if (!ledigPlass()) {
			utvid();
		}

		return leggTil(innlegg);

	}

	public boolean slett(Innlegg innlegg) {
		
		int pos = finnInnlegg(innlegg);
		
		if (pos > -1) {
			
			nesteledig--;
			innleggtabell[pos] = innleggtabell[nesteledig];
			innleggtabell[nesteledig] = null;
			return true;
			
			
		}
		
		return false;
		
		
	}

	public int[] search(String keyword) {
		
		int[] idTab = new int[innleggtabell.length];

		for (int i = 0; i < innleggtabell.length; i++) {
			
			if (innleggtabell[i].toString().contains(keyword)) {
				
				idTab[i] = innleggtabell[i].getId();
				
			}
			
		}
		
		return idTab;

	}
}