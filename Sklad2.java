import java.util.ArrayList;

public class Sklad {
    int maxSteviloElementov;
    ArrayList<Integer> sklad = new ArrayList();
    
    Sklad(int maxSteviloElementov) {
        this.maxSteviloElementov = maxSteviloElementov;
    }
    
    public void push(int x) {
        if(sklad.size() == maxSteviloElementov) {
            try {
                throw new PolnSkladException("PolnSkladException: Sklad je poln");
            } catch (PolnSkladException e) {
                System.out.println(e.getMessage());
                System.exit(0);
            }
        } else {
            sklad.add(x);
        }
    }
    
    public int pop() {
        int element = sklad.get(sklad.size()-1);
        sklad.remove(element);
        return element;
    }
    
    class PolnSkladException extends Exception {
        public PolnSkladException (String sporocilo) {
            super(sporocilo);
        }
    }
    
    public static void main(String[] args) {
        Sklad s = new Sklad(3); // ustvarimo sklad vel. 3
        s.push(5); s.push(3); s.push(2); // dodamo 3 elemente
        // odstranimo in izpišemo zadnji element (2)
        System.out.println(s.pop());
        s.push(4); // dodamo 3. element
        s.push(8); // ker je sklad poln, se sproži izjema
    }   
}
