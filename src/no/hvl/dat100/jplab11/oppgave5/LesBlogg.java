package no.hvl.dat100.jplab11.oppgave5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.*;
import no.hvl.dat100.jplab11.oppgave2.*;
import no.hvl.dat100.jplab11.oppgave3.*;

import javax.swing.JOptionPane;

public class LesBlogg {

	private static String TEKST = "TEKST";
	private static String BILDE = "BILDE";

	public static Blogg les(String mappe, String filnavn) {

		try {
			File fil = new File(mappe + filnavn);
			Scanner reader = new Scanner(fil);

			
			// Antall innlegg
			int antInn = Integer.parseInt(reader.nextLine());

			Blogg samling = new Blogg(antInn);

			Tekst tekst1;
			Bilde bilde1;

			for (int i = 0; i < antInn; i++) {
				String type = reader.nextLine();
				int id = Integer.parseInt(reader.nextLine());
				String bruker = reader.nextLine();
				String dato = reader.nextLine();
				int likes = Integer.parseInt(reader.nextLine());
				String tekst = reader.nextLine();

				if (type.equals(TEKST)) {

					// Vi vet at den har 5 linjer etter TEKST, derfor < 6
					tekst1 = new Tekst(id, bruker, dato, likes, tekst);
					samling.leggTil(tekst1);

				} else if (type.equals(BILDE)) {
					String url = reader.nextLine();
					bilde1 = new Bilde(id, bruker, dato, likes, tekst, url);
					samling.leggTil(bilde1);

				}
			}
			reader.close();
			return samling;
		} catch (FileNotFoundException e) {

		}
		return null;

	}
}
