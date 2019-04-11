import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class MengenOperationen {

    public static void main(String [] args){

        boolean shouldExit = false;

        Scanner scn = new Scanner(System.in);
        while(! shouldExit){
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

            takeIt = takeIt.trim();
            Pattern pattern = Pattern.compile("\\[([0-9,]*)\\]([+\\\\*-])\\[([0-9,]*)\\]");
            Matcher matcher = pattern.matcher(takeIt);
            boolean valid = m.matches();
            if(valid){
                String firstSet = "";
                String Operator = "";
                String secondSet = "";
                while(matcher.find()) {
                    firstSet = matcher.group(1);
                    Operator = matcher.group(2);
                    secondSet = matcher.group(3);
                }
                System.out.println("firstSet: " + firstSet);
                System.out.println("Operator: " + Operator);
                System.out.println("secondSet: " + secondSet);
                Operationen ops= new Operationen();


            }else{
                System.out.println("Input does not match the pattern.");
            }
        }
    }
}
