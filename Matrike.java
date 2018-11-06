
import java.util.Scanner;

public class Naloga3 {
    public static void main(String[] args) {
        Scanner sc1 = new Scanner(System.in);
        String vse = "";
        while (sc1.hasNextLine()) {
            vse += sc1.nextLine() + "\n";
        }
        
        String[] povezave = vse.split("\n");
        
        if (args.length == 2) {
            String vrsta = args[0];
            String akcija = args[1];
            
            if (vrsta.equals("directed")) {
                if (akcija.equals("info")) {
                    int stVozlisc = Integer.parseInt(povezave[0]);
                    int stPovezav = povezave.length-1;
                    int klike = stVozlisc*stVozlisc-stPovezav;
                    
                    String vhodne = "";
                    String izhodne = "";
                    for(int i=1; i<povezave.length; i++) {
                        String[] splitano = povezave[i].split(" ");
                        vhodne += splitano[0] + " ";
                        izhodne += splitano[1] + " ";
                    }
                    String[] vhodniIndeksi = vhodne.split(" ");
                    String[] izhodniIndeksi = izhodne.split(" ");
         
                    System.out.println(stVozlisc+" "+stPovezav+" "+klike);
                    for(int i=0; i<stVozlisc; i++) {
                        int stevecVhod = 0;
                        int stevecIzhod = 0;
                        
                        for(String element : vhodniIndeksi) {
                            if(Integer.parseInt(element) == i) {
                                stevecVhod++;
                            }
                        }
                        
                        for(String element : izhodniIndeksi) {
                            if(Integer.parseInt(element) == i) {
                                stevecIzhod++;
                            }
                        }
                        System.out.println(i+" "+stevecVhod+" "+stevecIzhod);           
                    }
                }
                if (akcija.equals("dfs")) {
                    
                }
                if (akcija.equals("bfs")) {
                    
                }
                if (akcija.equals("comp")) {
                    
                }
            }
            if (vrsta.equals("undirected")) {
                if (akcija.equals("info")) {
                    int stVozlisc = Integer.parseInt(povezave[0]);
                    
                    int vsePovezave[][] = new int[stVozlisc][stVozlisc];
                    
                    //int stPovezav = povezave.length-1;
                    //int klike = stVozlisc * (stVozlisc + 1) / 2 - stPovezav;
                    
                    //
                    
                    String vhodne = "";
                    String izhodne = "";
                    for(int i=1; i<povezave.length; i++) {
                        String[] splitano = povezave[i].split(" ");
                        vhodne += splitano[0] + " ";
                        izhodne += splitano[1] + " ";
                    }
                    String[] vhodniIndeksi = vhodne.split(" ");
                    String[] izhodniIndeksi = izhodne.split(" ");
                    
                    int stPovezav = 0;
                    for(int i=0; i<vhodniIndeksi.length; i++) {
                        vsePovezave[Integer.parseInt(vhodniIndeksi[i])][Integer.parseInt(izhodniIndeksi[i])] = 1;
                        vsePovezave[Integer.parseInt(izhodniIndeksi[i])][Integer.parseInt(vhodniIndeksi[i])] = 1;
                    }
                    
                    for(int i=0; i<stVozlisc; i++) {
                        for(int j=0; j<stVozlisc; j++) {
                            if(vsePovezave[i][j] == 1) {
                                stPovezav++;
                            }
                        }
                    }

                    stPovezav = stPovezav/2;
                    int klike = stVozlisc * (stVozlisc + 1) / 2 - stPovezav;
                    
                    System.out.println(stVozlisc+" "+stPovezav+" "+klike);
                    
                    for(int i=0; i<stVozlisc; i++) {
                        int stevec = 0;
                        for(int j=0; j<vsePovezave[i].length; j++) {
                            if(vsePovezave[i][j] == 1) {
                                stevec++;
                            }
                        }
                        System.out.println(i+" "+stevec);           
                    }
                    
                }
                if (akcija.equals("dfs")) {
                    
                }
                if (akcija.equals("bfs")) {
                    
                }
                if (akcija.equals("comp")) {
                    
                }
            }
        }
        if (args.length == 3) {
            String vrsta = args[0];
            String akcija = args[1];
            int parameter = Integer.parseInt(args[2]);
            
            if (vrsta.equals("directed")) {
                if (akcija.equals("walks")) {
                    int stVozlisc = Integer.parseInt(povezave[0]);
                    int vsePovezave[][] = new int[stVozlisc][stVozlisc];
                    
                    for(int i=1; i<povezave.length; i++) {
                        String[] splitano = povezave[i].split(" ");
                        vsePovezave[Integer.parseInt(splitano[0])][Integer.parseInt(splitano[1])] = 1;
                    }
                    
                    int pravaMatrika[][] = zmnoziMatriki(vsePovezave, vsePovezave);
                    for(int i=1; i<parameter-1; i++) {
                        int matrika[][] = zmnoziMatriki(pravaMatrika, vsePovezave);
                        for(int g=0; g<stVozlisc; g++) {
                            for(int k=0; k<stVozlisc; k++) {
                                pravaMatrika[g][k] = matrika[g][k];
                            }
                        }
                    }
                    

                    for(int i=0; i<stVozlisc; i++) {
                        for(int j=0; j<stVozlisc; j++) {
                            System.out.print(pravaMatrika[i][j] + " ");
                        }
                        System.out.print("\n");
                    }
                }
                if (akcija.equals("sp")) {
                    
                }
            }
            if (vrsta.equals("undirected")) {
                if (akcija.equals("walks")) {
                    int stVozlisc = Integer.parseInt(povezave[0]);
                    int vsePovezave[][] = new int[stVozlisc][stVozlisc];
                    
                    for(int i=1; i<povezave.length; i++) {
                        String[] splitano = povezave[i].split(" ");
                        vsePovezave[Integer.parseInt(splitano[0])][Integer.parseInt(splitano[1])] = 1;
                        vsePovezave[Integer.parseInt(splitano[1])][Integer.parseInt(splitano[0])] = 1;
                    }
                    
                    int pravaMatrika[][] = zmnoziMatriki(vsePovezave, vsePovezave);
                    for(int i=1; i<parameter-1; i++) {
                        int matrika[][] = zmnoziMatriki(pravaMatrika, vsePovezave);
                        for(int g=0; g<stVozlisc; g++) {
                            for(int k=0; k<stVozlisc; k++) {
                                pravaMatrika[g][k] = matrika[g][k];
                            }
                        }
                    }
                    

                    for(int i=0; i<stVozlisc; i++) {
                        for(int j=0; j<stVozlisc; j++) {
                            System.out.print(pravaMatrika[i][j] + " ");
                        }
                        System.out.print("\n");
                    }
                }
                if (akcija.equals("sp")) {
                    
                }
            }
        }
    }
    
    public static int[][] zmnoziMatriki(int[][] matrika1, int[][] matrika2) {
        int dolzina = matrika1.length;
        
        int[][] novaMatrika = new int[dolzina][dolzina];
        for (int i = 0; i < dolzina; i++) { // aRow
            for (int j = 0; j < dolzina; j++) { // bColumn
                for (int k = 0; k < dolzina; k++) { // aColumn
                    novaMatrika[i][j] += matrika1[i][k] * matrika2[k][j];
                }
            }
        }
        return novaMatrika;
    }
}