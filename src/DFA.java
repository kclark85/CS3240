import java.util.*;

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

    public boolean accepts(String input) {
        boolean isValid = false;
        if(F.contains(q0) && (input == null || input.length() ==0)){
            return true;
        }
        State currentState = q0;
        for(int i = 0; i < input.length(); i++){
            //this.nextState(currentState, input.substring(i,i+1)).increment();
            currentState = this.nextState(currentState, input.substring(i,i+1));
            currentState.increment();

        }
        if(this.F.contains(currentState)){
            isValid = true;
        }
        return isValid;
    }
    public Set<State> acceptStates(){
        return this.F;
    }

    public Set<String> alphabet(){
        return this.Z;
    }

    public State initialState(){
        return this.q0;
    }

    public State nextState(State source, String input){
        if (!this.Q.contains(source) || !this.Z.contains(input)) {
            throw new NoSuchElementException("State or input not found");
        }
        return T.get(source).get(input);
    }

    public Set<State> states(){
        return this.Q;
    }
    public Map<State,Map<String,State>> transitionFunction(){
        return this.T;
    }

//    public static void main(String[] args) {
////        State q0 = new State("q0", "start");
//        State q1 = new State("q1", "zero");
//        State q2 = new State("q2", "one");
//        Map<State,Map<String,State>> tortillas = new HashMap<>();
//        Map<String,State> tinytort = new HashMap<>();
//        Set<State> tacos = new HashSet<>();
//        Set<String> tortas = new HashSet<>();
//        State tamales = new State("chicken", "cheese");
//        State tomatillos = new State("dill", "pickle");
//        Set<State> tostadas = new HashSet<>();
//        tortas.add("a");
//        tortas.add("b");
//        tortas.add("c");
//        tostadas.add(tamales);
//        tostadas.add(tomatillos);
//        DFA test = new DFA(tacos, tortas, tortillas, tamales, tostadas);
//        tinytort.put("a", q1);
//        tinytort.put("b", q2);
//        tortillas.put(test.q0, tinytort);
//        System.out.println(test.accepts("c"));
//        System.out.println(test.acceptStates());
//        System.out.println(test.alphabet());
//        System.out.println(test.initialState());
//
//    }

}