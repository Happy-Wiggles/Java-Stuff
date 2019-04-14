import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MengenOperationen {
    public static void main(String[] args) {

        boolean shouldExit = false;

        Scanner scn = new Scanner(System.in);
        while (!shouldExit) {

            System.out.println("Geben Sie zwei Mengen zum kalkulieren ein: ");

            Set<Integer> setA = new HashSet<Integer>();
            Set<Integer> setB = new HashSet<Integer>();

            String takeIt = "";
            boolean isInputValid = true;

            try {
                takeIt = scn.nextLine();
            } catch (Exception e) {
                isInputValid = false;
                System.out.println("Invalider Input: " + takeIt + " " + e.getMessage()); //Programm schmiert nicht ab
            }

            if (takeIt.equals("") || takeIt.equals(" ") && isInputValid) { //Eingabetaste, leer+Eingabe oder !valid = Programmende
                shouldExit = true;
            }

            takeIt = takeIt.replaceAll("\\s", ""); //Alle spaces = nix
            //takeIt = takeIt.replaceAll("[a-z]"," "); //Funktioniert aus irgendeinem Grund nicht...
            Pattern pattern = Pattern.compile("\\[([0-9,]*)]([+\\\\*-])\\[([0-9,]*)]");
            Matcher matcher = pattern.matcher(takeIt);

            String firstSet = "";
            String operator = "";
            String secondSet = "";

            while (matcher.find()) {            //String in Gruppen aufteilen
                firstSet = matcher.group(1);
                operator = matcher.group(2);
                secondSet = matcher.group(3);
            }

            String[] firstStringSet = firstSet.split(",");
            String[] secondStringSet = secondSet.split(",");

            try {
                for (String sInt : firstStringSet) {            //StringArrays in Integer umwandeln und Sets zuweisen
                    if(!sInt.equals("")){
                        setA.add(Integer.parseInt(sInt));
                    }
                }
                for (String sInt : secondStringSet) {
                    if(!sInt.equals("")) {
                        setB.add(Integer.parseInt(sInt));
                    }
                }
            } catch (Exception ex) {
                isInputValid = false;
                System.out.println("Umrechnung nicht moeglich! " + ex.getMessage());
            }

            if(isInputValid){
                switch (operator) {
                    case "+":
                        System.out.println(Operatoren.vereinigungsMenge(setA, setB));
                        break;
                    case "*":
                        System.out.println(Operatoren.schnittMenge(setA, setB));
                        break;
                    case "-":
                        System.out.println(Operatoren.differenzMenge(setA, setB));
                        break;
                    default:
                        if(!takeIt.equals("")){
                            System.out.println("Operator " + operator + "nicht bekannt! ");
                        }
                        break;
                }
            }else{
                System.out.println("Keine Operation moeglich!");
            }
        }
    }
}
