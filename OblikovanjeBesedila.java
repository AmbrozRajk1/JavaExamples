import java.io.File;
import java.util.Scanner;

interface OblikovalecBesedila {
    String oblikujBesedilo(String vrstica);
}

class OblikovanjeBesedila {
  static void oblikujBesedilo(String imeDatoteke, OblikovalecBesedila oblikovalec) throws Exception  {
    Scanner sc = new Scanner(new File(imeDatoteke));
    int stevec = 0;
    
    while (sc.hasNextLine()) {
      String vrstica = sc.nextLine();
      if (stevec == 0) {
          String crka = vrstica.substring(0, 1).toUpperCase();
          String ostalo = vrstica.substring(1, vrstica.length());
          vrstica = crka;
          vrstica += ostalo;
          stevec++;
      }
      vrstica = oblikovalec.oblikujBesedilo(vrstica);
      System.out.println(vrstica);
    }
    sc.close();
  }
}


public class DN11 {
  
  public static void main(String[] args) throws Exception {
    if (args.length != 2) {
      System.out.println("Napacno stevilo argumentov.");
      System.exit(1);
    }
    if (args[0].equals("OblikaStavka")) {
        String datoteka = args[1];
        OblikaStavka oblikovalec = new OblikaStavka();
        OblikovanjeBesedila.oblikujBesedilo(datoteka, oblikovalec);
    }
    if (args[0].equals("OblikaNaslova")) {
        String datoteka = args[1];
        OblikaNaslova oblikovalec = new OblikaNaslova();
        OblikovanjeBesedila.oblikujBesedilo(datoteka, oblikovalec);
    }
  }
}

class OblikaStavka implements OblikovalecBesedila {
    static boolean zastavica = false;
    static boolean prvaBeseda = false;
    static int vrstice = 0;
    @Override
    public String oblikujBesedilo(String besedilo) {
        String stavek = "";
        char pika = '.';
        Scanner xd = new Scanner(besedilo);
        while (xd.hasNext()) {
            String beseda = xd.next();
            if (zastavica == true || vrstice == 0) {
                stavek += beseda.substring(0, 1).toUpperCase();
                stavek += beseda.substring(1, beseda.length()).toLowerCase();
                stavek += " ";
                zastavica = false;
            } else {
                stavek += beseda.substring(0, beseda.length()).toLowerCase();
                String zadnjiZnak = beseda.substring(beseda.length()-1, beseda.length());
                if (zadnjiZnak.charAt(0) == pika) {
                    zastavica = true;
                }
                stavek += " ";
            }
            vrstice++;
        }
        return stavek;
    }
}

class OblikaNaslova implements OblikovalecBesedila {
    @Override
    public String oblikujBesedilo(String besedilo) {
        String stavek = "";
        Scanner xd = new Scanner(besedilo);
        while (xd.hasNext()) {
            String beseda = xd.next();
            stavek += beseda.substring(0, 1).toUpperCase();
            stavek += beseda.substring(1, beseda.length()).toLowerCase();
            stavek += " ";
        }
        return stavek;
    }
}