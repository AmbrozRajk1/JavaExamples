import java.util.Scanner;
import java.io.File;

class Lik {
    public double povrsina() {
        return 0;
    }
}
class Kvadrat extends Lik {
   double stranica;
   
   Kvadrat(double a) {
       stranica = a;
   }
   
   @Override
   public double povrsina() {
       double povrsina = stranica * stranica;
       return povrsina;
   }
}
class Pravokotnik extends Lik {
   double stranicaA;
   double stranicaB;
   
   Pravokotnik(double a, double b) {
       stranicaA = a;
       stranicaB = b;
   }
   
   @Override
   public double povrsina() {
       double povrsina = stranicaA * stranicaB;
       return povrsina;
   }
}
class Krog extends Lik {
   double radij;
   
   Krog(double r) {
       radij = r;
   }
   
   @Override
   public double povrsina() {
       double povrsina = radij * radij * Math.PI;
       return povrsina;
   }
}

public class DN10 {
    public static void main(String[] args) throws Exception {
        String datoteka = args[0];
        Lik[] Liki = preberi(datoteka);
        izracunaj(Liki);
    }
    
    static Lik[] preberi(String datoteka) throws Exception {
        Scanner dat = new Scanner(new File(datoteka));
        Lik[] Liki = new Lik[100];
        int stevec = 0;
        while (dat.hasNextLine()) {
            String vrstica = dat.nextLine();
            String[] lik = vrstica.split(":");
            if (lik[0].equals("kvadrat")) {
                Kvadrat kv = new Kvadrat(Double.parseDouble(lik[1]));
                kv.povrsina();
                Liki[stevec] = kv;
                stevec++;
            }
            if (lik[0].equals("krog")) {
                Krog kr = new Krog(Double.parseDouble(lik[1]));
                kr.povrsina();
                Liki[stevec] = kr;
                stevec++;
            }
            if (lik[0].equals("pravokotnik")) {
                Pravokotnik pr = new Pravokotnik(Double.parseDouble(lik[1]), Double.parseDouble(lik[2]));
                pr.povrsina();
                Liki[stevec] = pr;
                stevec++;
            }
        }
        dat.close();
        return Liki;
    }
    
    static void izracunaj(Lik[] Liki) {
        double skupnaPovrsina = 0;
        for(int i=0; i<100; i++) {
            if (Liki[i] == null) {
                break;
            }
            skupnaPovrsina += Liki[i].povrsina();
        }
        System.out.printf("%.2f", skupnaPovrsina);
    }
  
}
