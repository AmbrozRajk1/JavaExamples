import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.FileNotFoundException;

public class DN06 {
	public static void main(String args[]) throws Exception {
		int a = Integer.parseInt(args[0]);
		
		if(a == 1) {
			File dat = new File(args[1]);
			podatki(dat);
		}
		
		if(a == 2) {
			File dat = new File(args[1]);
			File dat2 = new File(args[2]);
			razlike(dat, dat2);
		}
		
		if(a == 3) {
			File dat = new File(args[1]);
			kontrolnaVsota(dat);
		}
		
		if(a == 4) {
			File dat = new File(args[1]);
			File dat2 = new File(args[2]);
			razlikaVVsebini(dat, dat2);
		}
		
		if(a == 5) {
			File mapa = new File(args[1]);
			System.out.println("Vsebina direktorija " + mapa + ":");
			izpisRekurzivno(mapa);
		}
		
		if(a == 6) {
			File mapa = new File(args[1]);
			System.out.println("Vsebina direktorija " + mapa + ":");
			izpisIterativno(mapa);
		}
		
		if(a == 7) {
			File mapa = new File(args[1]);
			File mapa2 = new File(args[2]);
			
			File podmape[] = mapa.listFiles();
			File podmape2[] = mapa2.listFiles();
			Arrays.sort(podmape);
			Arrays.sort(podmape2);
			int stevec = 0;
			int stevec2 = 0;
			
	zanka:	for(int i=0; i<podmape.length; i++) {
				if(podmape[i-stevec2].isDirectory() && podmape2[i-stevec].isDirectory()) {
					System.out.println("OK /" + podmape[i-stevec2].getName() + " in /" + podmape2[i-stevec].getName());
					File datoteke[] = podmape[i-stevec2].listFiles();
					File datoteke2[] = podmape2[i-stevec].listFiles();
					Arrays.sort(datoteke);
					Arrays.sort(datoteke2);
					for(int j=0; j<datoteke.length; j++) {
						String datIme = datoteke[j].getName();
						String dat2Ime = datoteke2[j].getName();
						
						long datVelikost = datoteke[j].length();
						long dat2Velikost = datoteke2[j].length();
						
						Date prviDatum = new Date(datoteke[j].lastModified());
						Date drugiDatum = new Date(datoteke2[j].lastModified());
						String datDatum = spremeniDatum(prviDatum);
						String dat2Datum = spremeniDatum(drugiDatum);
						
						if(datIme.equals(dat2Ime) && datVelikost == dat2Velikost && datDatum.equals(dat2Datum)) {
							System.out.println("OK /" + podmape[i-stevec2].getName() + "/" + datoteke[j].getName());
						} else {
							System.out.println("! /" + podmape[i-stevec2].getName() + "/" + datoteke[j].getName());
						}
						
						if(!datIme.equals(dat2Ime)) {
							System.out.println("Datoteki se razlikujeta v imenu:");
							System.out.println("(1) " + datIme);
							System.out.println("(2) " + dat2Ime);
						}
						
						if(datVelikost != dat2Velikost) {
							System.out.println("Datoteki se razlikujeta v velikosti:");
							System.out.println("(1) " + datVelikost + " bajtov");
							System.out.println("(2) " + dat2Velikost + " bajtov");
						}
						
						if(!datDatum.equals(dat2Datum)) {
							System.out.println("Datoteki se razlikujeta v datumu zadnje spremembe:");
							System.out.println("(1) " + datDatum);
							System.out.println("(2) " + dat2Datum);
						}
					}
				} else {
					if(!podmape[i-stevec2].getName().equals(podmape2[i-stevec].getName())){
						for(int k=0; k<podmape2.length; k++){
							if(podmape[i-stevec2].getName().equals(podmape2[k].getName())){
								System.out.println("+ /" + podmape2[i-stevec].getName());
								stevec2 += 1;
							}
						}
						for(int h=0; h<podmape.length; h++){
							if(podmape2[i-stevec].getName().equals(podmape[h].getName())){
								System.out.println("- /" + podmape[i-stevec2].getName());
								stevec += 1;
							}
						}
						continue zanka;
					}
					Scanner sc = new Scanner(podmape[i-stevec2]);
					sc.useDelimiter("");
					Scanner sd = new Scanner(podmape2[i-stevec]);
					sd.useDelimiter("");
					int stevec23 = 1;
					String besedilo = "Datoteki se razlikujeta v vsebini pri znaku: ";
					String besedilo2 = "Datoteki se razlikujeta v vsebini pri znaku: ";
					
					while(sc.hasNext() && sd.hasNext() ) {
						String datCrka = sc.next();
						char datC = datCrka.charAt(0);
						String dat2Crka = sd.next();
						char dat2C = dat2Crka.charAt(0);
						
						if(datC != dat2C) {
							besedilo += stevec23;
							break;
						}
						
						stevec23 += 1;
					}
					
					if(besedilo.equals(besedilo2)) {
						System.out.println("OK /" + podmape[i-stevec2].getName());
					} else {
						System.out.println(besedilo);
					}
					sc.close();
					sd.close();
				}
			}
			
		}
			
	}
	
	public static void podatki(File dat){
		System.out.println("Podatki o datoteki:");
		
		System.out.println("- ime: " + dat.getName());
		
		System.out.println("- pot: " + spremeniPot(dat.getAbsolutePath()));
		
		System.out.println("- velikost: " + dat.length() + " bajtov");
		
		Date datum = new Date(dat.lastModified()); 
		System.out.println("- spremenjena: " + spremeniDatum(datum));
	}
	
	public static String spremeniPot(String pot) {
		String tabelaPot [] = pot.split("/");
		String pravaPot = "";
		for(int i=0; i<tabelaPot.length; i++){
			if(i != tabelaPot.length-1) {
				pravaPot += tabelaPot[i];
				if(i != tabelaPot.length-2)
					pravaPot += "/";
			}
		}
		return pravaPot;
	}
	
	public static String spremeniDatum(Date datum) {
		SimpleDateFormat praviDatum = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
		return praviDatum.format(datum);
	}
	
	public static void razlike(File dat, File dat2) {
		String datIme = dat.getName();
		String dat2Ime = dat2.getName();
		
		String datPot = spremeniPot(dat.getAbsolutePath());
		String dat2Pot = spremeniPot(dat2.getAbsolutePath());
		
		long datVelikost = dat.length();
		long dat2Velikost = dat2.length();
		
		Date prviDatum = new Date(dat.lastModified());
		Date drugiDatum = new Date(dat2.lastModified());
		String datDatum = spremeniDatum(prviDatum);
		String dat2Datum = spremeniDatum(drugiDatum);
		
		if(!datIme.equals(dat2Ime)) {
			System.out.println("Datoteki se razlikujeta v imenu:");
			System.out.println("(1) " + datIme);
			System.out.println("(2) " + dat2Ime);
		}
		
		if(datVelikost != dat2Velikost) {
			System.out.println("Datoteki se razlikujeta v velikosti:");
			System.out.println("(1) " + datVelikost + " bajtov");
			System.out.println("(2) " + dat2Velikost + " bajtov");
		}
		
		if(!datDatum.equals(dat2Datum)) {
			System.out.println("Datoteki se razlikujeta v datumu zadnje spremembe:");
			System.out.println("(1) " + datDatum);
			System.out.println("(2) " + dat2Datum);
		}

		if(datIme.equals(dat2Ime) && datVelikost == dat2Velikost && datDatum.equals(dat2Datum)) {
			System.out.println("Datoteki sta enaki:");
			System.out.println("(1) " + dat);
			System.out.println("(2) " + dat2);
		}
	}
	
	public static void kontrolnaVsota(File dat) throws FileNotFoundException {
		Scanner sc = new Scanner(dat);
		sc.useDelimiter("");
		int vsota = 0;
		
		while(sc.hasNext()) {
			String crka = sc.next();
			char c = crka.charAt(0);
			vsota += (int)c;
		}
		
		System.out.println("Kontrolna vsota datoteke je: " + vsota % 1024);
		sc.close();
	}
	
	public static void razlikaVVsebini(File dat, File dat2) throws FileNotFoundException {
		Scanner sc = new Scanner(dat);
		sc.useDelimiter("");
		Scanner sd = new Scanner(dat2);
		sd.useDelimiter("");
		int stevec23 = 1;
		String besedilo = "Datoteki se razlikujeta v vsebini pri znaku: ";
		String besedilo2 = "Datoteki se razlikujeta v vsebini pri znaku: ";
		
		while(sc.hasNext() && sd.hasNext() ) {
			String datCrka = sc.next();
			char datC = datCrka.charAt(0);
			String dat2Crka = sd.next();
			char dat2C = dat2Crka.charAt(0);
			
			if(datC != dat2C) {
				besedilo += stevec23;
				break;
			}
			
			stevec23 += 1;
		}
		
		if(besedilo.equals(besedilo2)) {
			System.out.print("Datoteki imata enako vsebino.");
		} else {
			System.out.println(besedilo);
		}
		sc.close();
		sd.close();
	}
	
	public static void izpisRekurzivno(File mapa) throws FileNotFoundException {
		File podmape[] = mapa.listFiles();
		Arrays.sort(podmape);
		for(int i=0; i<podmape.length; i++) {
			if(podmape[i].isDirectory()) {
				System.out.println(podmape[i]);
				izpisRekurzivno(podmape[i]);
				
			} else {
				System.out.println(podmape[i]);
			}
		}
	}
	
	public static void izpisIterativno(File mapa) throws FileNotFoundException {
		File podmape[] = mapa.listFiles();
		Arrays.sort(podmape);
		for(int i=0; i<podmape.length; i++) {
			if(podmape[i].isDirectory()) {
				System.out.println(podmape[i]);
				File mapica[] = podmape[i].listFiles();
				for(int j=0; j<mapica.length; j++)
					System.out.println(mapica[j]);
			} else {
				System.out.println(podmape[i]);
			}		
		}
	}
}