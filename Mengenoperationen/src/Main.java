import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
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
                String[] firstStringSet = firstSet.split(",");
                String[] secondStringSet = secondSet.split(",");
                
                for(String sInt : firstStringSet){
                  setA.add(Integer.parseInt(sInt));
                }
                for(String sInt : secondStringSet){
                  setB.add(Integer.parseInt(sInt));
                }

                switch(operator){
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
                        System.out.print("Operator " + operator + "nicht bekannt");
                        break;
                }
        }
    }
}
