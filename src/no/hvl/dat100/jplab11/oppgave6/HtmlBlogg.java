package no.hvl.dat100.jplab11.oppgave6;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.Innlegg;
import no.hvl.dat100.jplab11.oppgave3.Blogg;

public class HtmlBlogg extends Blogg {

	public HtmlBlogg() {
		super();
	}
	
	private static String HTMLPREFIX = 
			"<html>\n\t<head>\n\t\t<title>DAT100 Blogg</title>\n\t</head>\n\t<body>\n";
	
	private static String HTMLPOSTFIX = 
			"\t</body>\n</html>";
	
	Innlegg[] samling = super.getSamling();
	int nesteledig = super.getAntall();
	
	@Override
	public String toString() {
		
		String str = "";
		String lokke = "";
		int nesteledig = super.getAntall();
		
		//NESTELEDIG FUNKER IKKE ??? MEN SAMLING FUNKER???
		for (int i = 0; i < nesteledig; i++) {
			
			
			lokke += samling[i].toHTML();
			
		}
		
		str = HTMLPREFIX + lokke + HTMLPOSTFIX;
		
		return str;
		
	}
}
