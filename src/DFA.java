import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DFA{
    Set<State> Q;
    Set<String> Z;
    Map<State,Map<String,State>>
            T;
    State q0;
    Set<State> F;

    DFA(Set<State> states, Set<String> alphabet, Map<State,Map<String,State>>
            transition, State start, Set<State> accept){
            this.Q = states;
            this.Z = alphabet;
            this.T = transition;
            this.q0 = start;
            this.F = accept;
    }

    public boolean accepts(String input){
        boolean isValid = false;
        if(!Z.contains(input)){
            isValid = false;
        }
        else if(Z.contains(input)){
            isValid = true;
        }
        return isValid;
    }

    public Set<State> acceptStates(){
       Set<State> retset = new HashSet<>();
        for (State s: this.F) {
            retset.add(s);
        }
        return retset;
    }

    public Set<String> alphabet(){
        Set<String> retset = new HashSet<>();
        for (String s: this.Z) {
            retset.add(s);
        }
        return retset;
    }

    public State initialState(){
        return this.q0;
    }

//    public State nextState(State source, String input){
//
//    }

    public static void main(String[] args) {
        State q1 = new State("q1", "zero");
        State q2 = new State("q2", "one");
        Map<State,Map<String,State>> tortillas = new HashMap<>();
        Map<String,State> tinytort = new HashMap<>();
        Set<State> tacos = new HashSet<>();
        Set<String> tortas = new HashSet<>();
        State tamales = new State("chicken", "cheese");
        State tomatillos = new State("dill", "pickle");
        Set<State> tostadas = new HashSet<>();
        tortas.add("a");
        tortas.add("b");
        tortas.add("c");
        tostadas.add(tamales);
        tostadas.add(tomatillos);
        DFA test = new DFA(tacos, tortas, tortillas, tamales, tostadas);
        tinytort.put("a", q1);
        tinytort.put("b", q2);
        tortillas.put(test.q0, tinytort);
        System.out.println(test.accepts("c"));
        System.out.println(test.acceptStates());
        System.out.println(test.alphabet());

    }

}