package bruchTests;

/**
 * Diese Klasse erstellt Brüche und verarbeitet diese mathematisch durch subtrahieren etc.
 * 
 * @author Marcus Deininger
 */
public class Bruch implements Comparable<Bruch> {
	
	private final int zaehler;
	private final int nenner;

	public Bruch(int zaehler, int nenner) {
		if (nenner == 0)
	        throw new IllegalArgumentException("Nenner darf nicht 0 sein!");
		
		if (nenner < 0) {
			zaehler = -zaehler;
			nenner = -nenner;
		}
		
		int divisor = ggT(zaehler, nenner);

		this.zaehler = zaehler / divisor;
		this.nenner = nenner / divisor;
	}
	
	public int zaehler() {
		return zaehler;
	}
	
	public int nenner() {
		return nenner;
	}
	
	/**
	 * Wenn ein Wert im Bruch negativ ist wird der ganze Bruch negativ
	 * @return negierten Bruch
	 */
	
	public Bruch minus() {
		return new Bruch(-this.zaehler, this.nenner);
	}

	/**
	 * Erstellt den Kehrwert des Bruches
	 * @return Kehrwert eines Bruches
	 */
	public Bruch kehrwert() {
		return new Bruch(this.nenner, this.zaehler);
	}

	/**
	 * Addiert 2 Brüche miteinander
	 * @param b
	 * @return Addierten bruch
	 */
	public Bruch addiere(Bruch b) {
		return new Bruch(this.zaehler * b.nenner + b.zaehler * this.nenner, this.nenner * b.nenner);
	}

	/**
	 * Subtrahiert 2 Brüche miteinander
	 * @param b
	 * @return Subtrahierten Bruch
	 */
	public Bruch subtrahiere(Bruch b) {
		return this.addiere(b.minus());
	}

	/**
	 * Multipliziert 2 Brüche miteinander
	 * @param b
	 * @return Produkt von 2 Brüchen
	 */
	public Bruch multipliziere(Bruch b) {
		return new Bruch(this.zaehler * b.zaehler, this.nenner * b.nenner);
	}

	/**
	 * Dividiert 2 Brüche miteinandner
	 * @param b
	 * @return Dividierten Bruch von 2 brüchen
	 */
	public Bruch dividiere(Bruch b) {
		return this.multipliziere(b.kehrwert());
	}

	/**
	 * Findet den größten gemeinsamen Teiler
	 * @param a
	 * @param b
	 * @return Größter gemeinsamer Teiler
	 */
	private static int ggT(int a, int b) {
		if(a < 0)
			return ggT(-a, b);
		else if (b < 0)
			return ggT(a, -b);
		else if (a < b)
			return ggT(b, a);
		else if(b == 0)
			return a;
		else
			return ggT(b, a%b);
	}
	
	/**
	 * Berechnet den Wert eines Bruches
	 * @return double Wert des  Bruches in Ganz-/ oder Kommazahlformat
	 */
	public double toDouble() {
		return (double)zaehler/nenner;
	}

	@Override
	public String toString() {
		if (nenner == 1)
			return zaehler + "";
		else
			return zaehler + "/" + nenner;
	}

	@Override
	public int compareTo(Bruch bruch) {
		return this.zaehler * bruch.nenner - bruch.zaehler * this.nenner;
	}
}
