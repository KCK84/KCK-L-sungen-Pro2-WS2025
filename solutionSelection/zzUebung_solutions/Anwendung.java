package mitarbeiterVerwaltung;

import java.io.File;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Anwendung {
	
	private static ArrayList <Mitarbeiter> mitarbeiter = new ArrayList<>();

	public static void main(String[] args) throws ParseException{
		
		//Einlesen der Datei
		readFile();
		
		long Buchhaltung = mitarbeiter.stream()
							.filter(m -> m.getAbteilung().equals("Buchhaltung"))
							.count();
		System.out.println("Mitarbeiter in der Buchhaltung: " + Buchhaltung + "\n");
		
		
		long OGMitarbeiter = mitarbeiter.stream()
										.filter(n -> n.getAbteilung().equals("Produktion") && n.getBeitrittsdatum()<2010)
										.count();
		System.out.println("Mitarbeiter vor 2010 ingestellt: " + OGMitarbeiter +"\n");
		
		double Gehaltavg = mitarbeiter.stream()
									 .filter(m -> m.getAbteilung().equals("Produktion"))
									 .mapToDouble(m -> m.getGehalt())
									 .average().orElse(0);
		
		System.out.println("Durchschnittsgehalt: " + Gehaltavg +"Euro\n");
		
		
		mitarbeiter.stream().sorted((x,y) -> Float.compare(y.getGehalt(), x.getGehalt()))
							.limit(1)
							.forEach(x -> System.out.println("Topverdiener: " +x.getVorname() + " " + x.getNachname() + "\n"));
		
		
		mitarbeiter.stream().filter(m-> m.getGehalt()>=3000)
				   .sorted((x,y) -> Float.compare(y.getGehalt(), x.getGehalt()))
				   .forEach(x -> System.out.println(x.getVorname() + " " + x.getNachname() +" Gehalt: " + x.getGehalt() + "Euro\n"));
		
		
		mitarbeiter.stream().sorted((x,y) -> x.getNachname().compareTo(y.getNachname()))
							.forEach(System.out::println);
		
		
		
	}
	
	
	
	private static void readFile() {
		try(Scanner scan = new Scanner(new File("Mitarbeiter.csv"))){
			while(scan.hasNextLine()) {
				String line = scan.nextLine();
				String[] felder = line.split(";");
				mitarbeiter.add(new Mitarbeiter(felder[0], felder[1], Float.parseFloat(felder[2]), felder[3],
						Integer.parseInt(felder[4])));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
