import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MengenOperationen {

    //Schnitt (*)
    private static Set schnittMenge(Set setA, Set setB){
        Set <Integer> schnitt = new HashSet<Integer>(setA);
        schnitt.retainAll(setB);
        return schnitt;
    }
    //Differenz (-)
    private static Set differenzMenge(Set setA, Set setB){
        Set <Integer> differenz = new HashSet<Integer>(setA);
        differenz.removeAll(setB);
        return differenz;
    }
    //Vereinigung (+)
    private static Set vereinigungsMenge(Set setA, Set setB){
        Set <Integer> vereinigung = new HashSet<Integer>(setA);
        vereinigung.addAll(setB);
        return vereinigung;
    }

    public static void main(String [] args){

        boolean shouldExit = false;

        Scanner scn = new Scanner(System.in);
        while(!shouldExit){

            System.out.println("Geben Sie zwei Mengen ein: ");

            Set<Integer> setA = new HashSet<Integer>();
            Set<Integer> setB = new HashSet<Integer>();

            String takeIt = "";
            boolean isInputValid = true;

            try {
                takeIt = scn.nextLine();
            }catch(Exception e){
                isInputValid = false;
                System.out.println("Invalid Input: " +e.getMessage());
            }

            if(takeIt == "" && isInputValid){
                shouldExit = true;
            }

            takeIt = takeIt.trim(); //Cuts off spaces
            Pattern pattern = Pattern.compile("\\[([0-9,]*)]([+\\\\*-])\\[([0-9,]*)]");
            Matcher matcher = pattern.matcher(takeIt);
                String firstSet = "";
                String operator = "";
                String secondSet = "";
                while(matcher.find()) {
                    firstSet = matcher.group(1);
                    operator = matcher.group(2);
                    secondSet = matcher.group(3);
                }
                System.out.println("firstSet: " + firstSet);
                System.out.println("Operator: " + operator);
                System.out.println("secondSet: " + secondSet);

                setA.add(firstSet); //Muss noch String -> Int converten und dann zu Set adden bzw converten
                setB.add(secondSet);
                switch(operator){
                    case "+":
                        System.out.println(vereinigungsMenge(setA, setB));
                        break;
                    case "*":
                        System.out.println(schnittMenge(setA, setB));
                        break;
                    case "-":
                        System.out.println(differenzMenge(setA, setB));
                        break;
                }
        }
    }
}
