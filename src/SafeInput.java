import java.util.Scanner;

public class SafeInput {


    public static String getRegExString(Scanner pipe, String prompt, String regEx) {

        System.out.print(prompt);
        return pipe.nextLine();
    }


    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {

        System.out.print(prompt);
        return Integer.parseInt(pipe.nextLine());
    }


    public static String getString(Scanner pipe, String prompt) {
        System.out.print(prompt);
        return pipe.nextLine();
    }


    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        System.out.print(prompt);
        return pipe.nextLine().toUpperCase().startsWith("Y");
    }
}