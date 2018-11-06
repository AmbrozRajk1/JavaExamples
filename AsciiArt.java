import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DN12 {
    public static void main(String[] args) {
        try {
            File datoteka = new File(args[0]);
            byte vsebina[] = new byte[(int) datoteka.length()];
            FileInputStream fis = new FileInputStream(datoteka);
            fis.read(vsebina);
            fis.close();
            String besedilo = new String(vsebina);
            String tip = "[P][6]\\s\\d+ \\d+\\s[2][5][5]\n";
            int prviznak = 3 + vrniVelikost(datoteka).length() + 5;
            String glava = "";
            if(besedilo.length() < prviznak) {
                try {
                    throw new AsciiArtException("AsciiArtException: Napacen format slike!");
                } catch (AsciiArtException e) {
                    System.out.println(e.getMessage());
                    System.exit(0);
                }
            } else {
                glava = besedilo.substring(0,prviznak);
            }
            if (glava.matches(tip) == false) {
                try {
                    throw new AsciiArtException("AsciiArtException: Napacen format slike!");
                } catch (AsciiArtException e) {
                    System.out.println(e.getMessage());
                    System.exit(0);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        if (args.length == 2) {
            try {
                File datoteka = new File(args[0]);
                int velikost = Integer.parseInt(args[1]);
                byte vsebina[] = new byte[(int) datoteka.length()];
                FileInputStream fis = new FileInputStream(datoteka);
                fis.read(vsebina);
                fis.close();
                String sirinaVisina = vrniVelikost(datoteka);
                String[] sv = sirinaVisina.split(" ");
                int sirina = Integer.parseInt(sv[0]);
                int stevec = 0;
                char[] Z = {' ', '.', '\'', ':', 'o', '&', '8', '#', '@'};
                int[] S = {230, 200, 180, 160, 130, 100, 70, 50};
                if (velikost == 1) {
                    int prviznak = 3 + vrniVelikost(datoteka).length() + 5;
                    char znak = ' ';
                    for(int i = prviznak; i<datoteka.length()-1; i+=3) {
                        int prvi = vsebina[i];
                        if (prvi < 0) {
                            prvi = 255 - Math.abs(prvi) + 1;
                        }
                        int drugi = vsebina[i+1];
                        if (drugi < 0) {
                            drugi = 255 - Math.abs(drugi) + 1;
                        }
                        int tretji = vsebina[i+2];
                        if (tretji < 0) {
                            tretji = 255 - Math.abs(tretji) + 1;
                        }
                        //System.out.println(prvi + " " + drugi + " " + tretji);
                        int sivina = (prvi+drugi+tretji)/3;
                        //System.out.println(sivina);
                        for (int j=0; j<8; j++) {
                            if (sivina >= S[j]) {
                                znak = Z[j];
                                break;
                            } else {
                                znak = Z[8];
                            }
                        }
                        System.out.print(znak);
                        stevec += 3;
                        if(stevec == sirina * 3) {
                            System.out.println();
                            stevec = 0;
                        }
                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        if (args.length == 3 && args[2].equals("-size")) {
            File datoteka = new File(args[0]);
            String besedilo = vrniVelikost(datoteka);
            System.out.printf("%s\n", besedilo);
        }
    }
    
    static String vrniVelikost(File datoteka) {
        String besedilo = "";
        try {
            byte vsebina[] = new byte[(int) datoteka.length()];
            FileInputStream fis = new FileInputStream(datoteka);
            fis.read(vsebina);
            fis.close();
            for(int i=3; i<100; i++) {
                String znak = ""+vsebina[i];
                if (!znak.equals("10")) {
                    char c = (char)vsebina[i];
                    besedilo += c;
                } else {
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return besedilo;
    }
}

class AsciiArtException extends Exception {
    public AsciiArtException(String sporocilo) {
         super(sporocilo);
    }
}
