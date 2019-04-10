import java.util.Set;
import java.util.HashSet;

public class Operationen {

        public void decideOperation(Set setA, Set setB){
            if(setA.contains('*') || setB.contains('*')){
                schnittMenge(setA, setB);
            }else if(setA.contains('-') || setB.contains('-')){
                differenzMenge(setA, setB);
            }else if(setA.contains('+') || setB.contains('+')){
                vereinigungsMenge(setA, setB);
            }
        }

        //Schnitt (*)
        public Set schnittMenge(Set setA, Set setB){
            Set <Integer> schnitt = new HashSet<Integer>(setA);
            schnitt.retainAll(setB);
            return schnitt;
        }
        //Differenz (-)
        public Set differenzMenge(Set setA, Set setB){
            Set <Integer> differenz = new HashSet<Integer>(setA);
            differenz.removeAll(setB);
            return differenz;
        }
        //Vereinigung (+)
        public Set vereinigungsMenge(Set setA, Set setB){
            Set <Integer> vereinigung = new HashSet<Integer>(setA);
            vereinigung.addAll(setB);
            return vereinigung;
        }


}
