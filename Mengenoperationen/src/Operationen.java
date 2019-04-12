import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Operatoren{

    //Schnitt (*)
    public static Set schnittMenge(Set setA, Set setB){
        setA.retainAll(setB);
        return setA;
    }
    //Differenz (-)
    public static Set differenzMenge(Set setA, Set setB){
        setA.removeAll(setB);
        return setA;
    }
    //Vereinigung (+)
    public static Set vereinigungsMenge(Set setA, Set setB){
        setA.addAll(setB);
        return setA;

    }
}
