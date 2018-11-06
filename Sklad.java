import java.util.Scanner;

abstract class Stack {
    abstract void push(String var);
    abstract void echo();
    abstract void stack();
    abstract void clear();
    abstract void space();
    abstract void pop();
    abstract void dup();
    abstract void dup2();
    abstract void swap();
    abstract void reverse();
    abstract void even();
    abstract void odd();
    abstract void factorial();
    abstract void len();
    abstract void notEqual();
    abstract void less();
    abstract void lessEqual();
    abstract void equal();
    abstract void more();
    abstract void moreEqual();
    abstract void plus();
    abstract void minus();
    abstract void multiply();
    abstract void devide();
    abstract void procent();
    abstract void dot();
    abstract void Then();
    abstract void Else();
    abstract void fun();
    abstract void run();
}

abstract class Stack_Reserved {
    abstract void push(String var);
    abstract void seefun();
    abstract void clearfun();
}

class PomozniSklad extends Stack_Reserved {
    String sklad[] = new String[64];
    int kazalec = 0;

    @Override
    void push(String var) {
        sklad[kazalec] = var;
        kazalec ++;
    }

    @Override
    void seefun() {
        if(kazalec == 0) {
            System.out.println();
        } else {
            for(int i=0; i<kazalec; i++) {
                System.out.print(sklad[i] + " ");
            }
            System.out.print("\n");
        }
    }

    @Override
    void clearfun() {
        for(int i=0; i<kazalec; i++) {
            sklad[i] = null;
            kazalec = 0;
        }
    }
}

class GlavniSklad extends Stack {
    String sklad[] = new String[64];
    boolean pogoj = false;
    int kazalec = 0;
    int funNumber = 0;
    int runNumber = 0;
    @Override
    void push (String var) {
       sklad[kazalec] = var;
       kazalec ++;
    }

    @Override
    void echo() {
        if(kazalec == 0) {
            System.out.println();
        } else {
            System.out.println(sklad[kazalec-1]);
            sklad[kazalec-1] = null;
            kazalec--;
        }
    }

    @Override
    void stack() {
        if(kazalec == 0) {
            System.out.println();
        } else {
            for(int i=0; i<kazalec; i++) {
                System.out.print(sklad[i] + " ");
            }
            System.out.print("\n");
        }
    }

    @Override
    void clear() {
        for(int i=0; i<kazalec; i++) {
            sklad[i] = null;
            kazalec = 0;
        }
    }

    @Override
    void space() {
        sklad[kazalec] = " ";
        kazalec ++;
    }

    @Override
    void pop() {
        sklad[kazalec-1] = null;
        kazalec--;
    }

    @Override
    void dup() {
        sklad[kazalec] = sklad[kazalec-1];
        kazalec++;  
    }

    @Override
    void dup2() {
        sklad[kazalec] = sklad[kazalec-2];
        sklad[kazalec+1] = sklad[kazalec-1];
        kazalec += 2;
    }

    @Override
    void swap() {
        String prvi = sklad[kazalec-2];
        sklad[kazalec-2] = sklad[kazalec-1];
        sklad[kazalec-1] = prvi;
    }

    @Override
    void reverse() {
        int ks1 = 0;
        String s1[] = new String[64];
        while(kazalec != 0) {
            s1[ks1] = sklad[kazalec-1];
            ks1++;
            kazalec--;
        }

        int ks2 = 0;
        String s2[] = new String[64];
        while(ks1 != 0) {
            s2[ks2] = s1[ks1-1];
            ks2++;
            ks1--;
        }

        while(ks2 != 0) {
            sklad[kazalec] = s2[ks2-1];
            kazalec++;
            ks2--;
        }
    }

    @Override
    void even() {
        if(Integer.parseInt(sklad[kazalec-1]) % 2 == 0) {
            sklad[kazalec-1] = "1";
        } else {
            sklad[kazalec-1] = "0";
        }
    }

    @Override
    void odd() {
        if(Integer.parseInt(sklad[kazalec-1]) % 2 == 0) {
            sklad[kazalec-1] = "0";
        } else {
            sklad[kazalec-1] = "1";
        }
    }

    @Override
    void factorial() {
        int vrh = Integer.parseInt(sklad[kazalec-1]);
        int fact = 1;
        for(int i=2; i<=vrh; i++) {
            fact *= i;
        }
        sklad[kazalec-1] = "" + fact;
    }

    @Override
    void len() {
        sklad[kazalec-1] = "" + sklad[kazalec-1].length();
    }

    @Override
    void notEqual() {
        int x = Integer.parseInt(sklad[kazalec-2]);
        int y = Integer.parseInt(sklad[kazalec-1]);
        pop();
        pop();

        if(x == y) {
            sklad[kazalec] = "0";
        } else {
            sklad[kazalec] = "1";
        }
        kazalec++;
    }

    @Override
    void less() {
        int x = Integer.parseInt(sklad[kazalec-2]);
        int y = Integer.parseInt(sklad[kazalec-1]);
        pop();
        pop();

        if(x < y) {
            sklad[kazalec] = "1";
        } else {
            sklad[kazalec] = "0";
        }
        kazalec++;
    }

    @Override
    void lessEqual() {
        int x = Integer.parseInt(sklad[kazalec-2]);
        int y = Integer.parseInt(sklad[kazalec-1]);
        pop();
        pop();

        if(x <= y) {
            sklad[kazalec] = "1";
        } else {
            sklad[kazalec] = "0";
        }
        kazalec++;
    }

    @Override
    void equal() {
        int x = Integer.parseInt(sklad[kazalec-2]);
        int y = Integer.parseInt(sklad[kazalec-1]);
        pop();
        pop();

        if(x == y) {
            sklad[kazalec] = "1";
        } else {
            sklad[kazalec] = "0";
        }
        kazalec++;
    }

    @Override
    void more() {
        int x = Integer.parseInt(sklad[kazalec-2]);
        int y = Integer.parseInt(sklad[kazalec-1]);
        pop();
        pop();

        if(x > y) {
            sklad[kazalec] = "1";
        } else {
            sklad[kazalec] = "0";
        }
        kazalec++;
    }

    @Override
    void moreEqual() {
        int x = Integer.parseInt(sklad[kazalec-2]);
        int y = Integer.parseInt(sklad[kazalec-1]);
        pop();
        pop();

        if(x >= y) {
            sklad[kazalec] = "1";
        } else {
            sklad[kazalec] = "0";
        }
        kazalec++;
    }

    @Override
    void plus() {
        int x = Integer.parseInt(sklad[kazalec-2]);
        int y = Integer.parseInt(sklad[kazalec-1]);
        pop();
        pop();

        int rezultat = x + y;
        sklad[kazalec] = "" + rezultat;
        kazalec++;
    }

    @Override
    void minus() {
        int x = Integer.parseInt(sklad[kazalec-2]);
        int y = Integer.parseInt(sklad[kazalec-1]);
        pop();
        pop();

        int rezultat = x - y;
        sklad[kazalec] = "" + rezultat;
        kazalec++;
    }

    @Override
    void multiply() {
        int x = Integer.parseInt(sklad[kazalec-2]);
        int y = Integer.parseInt(sklad[kazalec-1]);
        pop();
        pop();

        int rezultat = x * y;
        sklad[kazalec] = "" + rezultat;
        kazalec++;
    }

    @Override
    void devide() {
        int x = Integer.parseInt(sklad[kazalec-2]);
        int y = Integer.parseInt(sklad[kazalec-1]);
        pop();
        pop();

        int rezultat = x / y;
        sklad[kazalec] = "" + rezultat;
        kazalec++;
    }

    @Override
    void procent() {
        int x = Integer.parseInt(sklad[kazalec-2]);
        int y = Integer.parseInt(sklad[kazalec-1]);
        pop();
        pop();

        int rezultat = x % y;
        sklad[kazalec] = "" + rezultat;
        kazalec++;
    }

    @Override
    void dot() {
        String x = sklad[kazalec-2];
        String y = sklad[kazalec-1];
        pop();
        pop();

        sklad[kazalec] = "" + x + y;
        kazalec++;
    }

    @Override
    void Then() {
        if(!sklad[kazalec-1].equals("0")) {
            pogoj = true;
        }
        pop();
    }

    @Override
    void Else() {
        pogoj = !pogoj;
    }

    @Override
    void fun() {
        funNumber = Integer.parseInt(sklad[kazalec-1]);
        pop();
    }

    @Override
    void run() {
        runNumber = Integer.parseInt(sklad[kazalec-1]);
    }
}

public class Naloga1 {
    static GlavniSklad gs = new GlavniSklad();
    static PomozniSklad ps = new PomozniSklad();
    
    static void glavniProgram(String argumenti){
        Scanner sc = new Scanner(argumenti);
        while (sc.hasNext()) {
            String command = sc.next();
            char c = command.charAt(0);
            if(c == '?') {
                command = command.substring(1, command.length());
                if (gs.pogoj) {
                   if (command.equals("echo")) {
                        gs.echo();
                        continue;
                    }
                    if (command.equals("stack")) {
                        gs.stack();
                        continue;
                    }
                    if (command.equals("clear")) {
                        gs.clear();
                        continue;
                    }
                    if (command.equals("space")) {
                        gs.space();
                        continue;
                    }
                    if (command.equals("pop")) {
                        gs.pop();
                        continue;
                    }
                    if (command.equals("dup")) {
                        gs.dup();
                        continue;
                    }
                    if (command.equals("dup2")) {
                        gs.dup2();
                        continue;
                    }
                    if (command.equals("swap")) {
                        gs.swap();
                        continue;
                    }
                    if (command.equals("reverse")) {
                        gs.reverse();
                        continue;
                    }
                    if (command.equals("even")) {
                        gs.even();
                        continue;
                    }
                    if (command.equals("odd")) {
                        gs.odd();
                        continue;
                    }
                    if (command.equals("!")) {
                        gs.factorial();
                        continue;
                    }
                    if (command.equals("len")) {
                        gs.len();
                        continue;
                    }
                    if (command.equals("<>")) {
                        gs.notEqual();
                        continue;
                    } 
                    if (command.equals("<")) {
                        gs.less();
                        continue;
                    } 
                    if (command.equals("<=")) {
                        gs.lessEqual();
                        continue;
                    } 
                    if (command.equals("==")) {
                        gs.equal();
                        continue;
                    } 
                    if (command.equals(">")) {
                        gs.more();
                        continue;
                    } 
                    if (command.equals(">=")) {
                        gs.moreEqual();
                        continue;
                    } 
                    if (command.equals("+")) {
                        gs.plus();
                        continue;
                    } 
                    if (command.equals("-")) {
                        gs.minus();
                        continue;
                    } 
                    if (command.equals("*")) {
                        gs.multiply();
                        continue;
                    } 
                    if (command.equals("/")) {
                        gs.devide();
                        continue;
                    } 
                    if (command.equals("%")) {
                        gs.procent();
                        continue;
                    } 
                    if (command.equals(".")) {
                        gs.dot();
                        continue;
                    }
                    if (command.equals("then")) {
                        gs.Then();
                        continue;
                    }
                    if (command.equals("else")) {
                        gs.Else();
                        continue;
                    }
                    if (command.equals("fun")) {
                        gs.fun();
                        for(int i=0; i<gs.funNumber; i++) {
                            String command2 = sc.next();
                            ps.push(command2);
                        }
                        continue;
                    }
                        if (command.equals("seefun")) {
                        ps.seefun();
                        continue;
                    }
                    if (command.equals("clearfun")) {
                        ps.clearfun();
                        continue;
                    }
                    if (command.equals("run")) {
                        gs.run();
                        for(int i=0; i<gs.runNumber; i++) {
                            for(int j=0; j<64; j++) {
                                if(ps.sklad[j] != null) {
                                    String psCommand = ps.sklad[j];
                                } else {
                                    break;
                                }
                            }
                        }
                        continue;
                    }
                    else {
                        gs.push(command);
                        continue;
                    } 
                }
                 
            } else {
                if (command.equals("echo")) {
                    gs.echo();
                    continue;
                }
                if (command.equals("stack")) {
                    gs.stack();
                    continue;
                }
                if (command.equals("clear")) {
                    gs.clear();
                    continue;
                }
                if (command.equals("space")) {
                    gs.space();
                    continue;
                }
                if (command.equals("pop")) {
                    gs.pop();
                    continue;
                }
                if (command.equals("dup")) {
                    gs.dup();
                    continue;
                }
                if (command.equals("dup2")) {
                    gs.dup2();
                    continue;
                }
                if (command.equals("swap")) {
                    gs.swap();
                    continue;
                }
                if (command.equals("reverse")) {
                    gs.reverse();
                    continue;
                }
                if (command.equals("even")) {
                    gs.even();
                    continue;
                }
                if (command.equals("odd")) {
                    gs.odd();
                    continue;
                }
                if (command.equals("!")) {
                    gs.factorial();
                    continue;
                }
                if (command.equals("len")) {
                    gs.len();
                    continue;
                }
                if (command.equals("<>")) {
                    gs.notEqual();
                    continue;
                } 
                if (command.equals("<")) {
                    gs.less();
                    continue;
                } 
                if (command.equals("<=")) {
                    gs.lessEqual();
                    continue;
                } 
                if (command.equals("==")) {
                    gs.equal();
                    continue;
                } 
                if (command.equals(">")) {
                    gs.more();
                    continue;
                } 
                if (command.equals(">=")) {
                    gs.moreEqual();
                    continue;
                } 
                if (command.equals("+")) {
                    gs.plus();
                    continue;
                } 
                if (command.equals("-")) {
                    gs.minus();
                    continue;
                } 
                if (command.equals("*")) {
                    gs.multiply();
                    continue;
                } 
                if (command.equals("/")) {
                    gs.devide();
                    continue;
                } 
                if (command.equals("%")) {
                    gs.procent();
                    continue;
                } 
                if (command.equals(".")) {
                    gs.dot();
                    continue;
                }
                if (command.equals("then")) {
                    gs.Then();
                    continue;
                }
                if (command.equals("else")) {
                    gs.Else();
                    continue;
                }
                if (command.equals("fun")) {
                        gs.fun();
                        for(int i=0; i<gs.funNumber; i++) {
                            String command2 = sc.next();
                            ps.push(command2);
                        }
                        continue;
                }
                if (command.equals("seefun")) {
                    ps.seefun();
                    continue;
                }
                if (command.equals("clearfun")) {
                    ps.clearfun();
                    continue;
                }
                if (command.equals("run")) {
                        gs.run();
                        continue;
                    }
                else {
                    gs.push(command);
                    continue;
                } 
            }
            
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if(args[0].equals("calc")) {
            while (sc.hasNextLine()) {
                glavniProgram(sc.nextLine());
                gs = new GlavniSklad();
            }
        }  
    } 
}