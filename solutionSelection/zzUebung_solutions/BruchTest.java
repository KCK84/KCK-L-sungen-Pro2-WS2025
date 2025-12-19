package pvl_Vorbereitungsaufgaben;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import bruchTests.Bruch;

class BruchTest {

	private void assertbruch(int zaehler, int nenner, Bruch bruch) {
		assertEquals(zaehler, bruch.zaehler(),"Zaehler falsch");
		assertEquals(nenner, bruch.nenner(),"Nenner falsch");
	}
	
	Bruch bruch1 = new Bruch(2,3);
	Bruch bruch2 = new Bruch(1,3);
	
	@Test
	void testBruchZaehlerUndNenner() {
		assertbruch(2,3, bruch1);
	}
	
	@Test
	void testAddieren() {
			// 2/3 + 1/3 = 3/3=1 = 1/1
		Bruch summe = bruch1.addiere(bruch2);
		assertbruch(1,1, summe);
		//assertEquals(1,summe.zaehler());
		//assertEquals(1,summe.nenner());
	}
	
	@Test
	void testSubtrahieren() {	
			// 2/3 - 1/3 = 1/3
		Bruch subtraktion= bruch1.subtrahiere(bruch2);
		assertbruch(1,3,subtraktion);
	}
	
	@Test
	void testMultiplizieren() {
			// 2/3 * 1/3 = 2/9
		Bruch mult= bruch1.multipliziere(bruch2);
		assertbruch(2,9,mult);
	}
	
	@Test
	void testDivision() {
			// 2/3 : 1/3 = 6/3 = 2/1
		Bruch div=bruch1.dividiere(bruch2);
		assertbruch(2,1,div);
	}
	
	@Test
	void testKehrwert() {
			// 2/3 = 3/2
		Bruch kehr=bruch1.kehrwert();
		assertbruch(3,2,kehr);
		//assertEquals(3,kehr.zaehler());
		//assertEquals(2,kehr.nenner());
	}
	
	@Test
	void testMinus() {
		Bruch negativ = new Bruch(-3,2);
		assertbruch(-3,2,negativ);
	}
	
	@Test
	void testToDouble() {
		Bruch br = new Bruch(3,2);
		double Kommawert = br.toDouble();
		assertEquals(1.5,Kommawert);
	}
	
	@Test
	void testToString() {
		String bruch = bruch1.toString();
		assertEquals("2/3",bruch);
	}
	
	@Test
	void testGrenzfälle() {
		assertThrows(IllegalArgumentException.class,() -> new Bruch(0,0));
	}
	

}
