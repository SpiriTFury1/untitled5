import java.util.Scanner;

public class StringCalc {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        System.out.println(calc(str));

        //String str  =     "Hi World" + "Hi World"
        //String str1 =     "Hi World" - "Wor";     "Hi World" - "Hi"      "Hi World" - "World"
        //String str2 =     "Hi World" * 5
        //String str3 =     "Hi World" / 2
    }

    public static String calc(String all) throws Exception {
        String multiplication = "*"; // *
        String division = "/"; // /
        String plus = "+"; // +
        String minus = "-"; // -
        String result = "";
        String rightnumbers = "";
        String rightWord2 = "";

        int x1 = all.indexOf('"');
        String leftWord = all.substring(1);
        int x2 = leftWord.indexOf('"');
        String leftWord2 = leftWord.substring(x1, x2);
        if (leftWord2.length() > 10) {
            throw new Exception();
        }
        String operation = leftWord.substring(x2 + 2, x2 + 3);
        int j = 0;
        String rightWord = leftWord.substring(x2 + 5);
        int x3 = rightWord.indexOf('"');
        if (x3 == -1) {
            if (operation.equals(plus) || operation.equals(minus)) {
                throw new Exception();
            }
            rightnumbers = leftWord.substring(x2 + 4);
            j = Integer.valueOf(rightnumbers);
            if (j < 1 || j > 10) {
                throw new Exception();
            }
            System.out.println("\"" + leftWord2 + "\"" + " " + operation + " " + rightnumbers);

        } else {
            if (operation.equals(division) || operation.equals(multiplication)) {
                throw new Exception();
            }

            rightWord2 = rightWord.substring(0, x3);
            if (rightWord2.length() > 10) {
                throw new Exception();
            }
            System.out.println("\"" + leftWord2 + "\"" + " " + operation + " " + "\"" + rightWord2 + "\"");
        }






        if (operation.equals(plus)) {
            result = (leftWord2 + rightWord2);


        } else if (operation.equals(minus)) {
            int x4 = leftWord2.indexOf(rightWord2);
            if (x4 == -1) {
                result = (leftWord2);
            } else {
                int x5 = rightWord2.length();
                result = (leftWord2.substring(0, x4) + leftWord2.substring((x4 + x5), x2));
            }


        } else if (operation.equals(multiplication)) {
            for (int i = 0; i < j; i++) {
                result += leftWord2;
            }
        } else if (operation.equals(division)) {
            int x5 = leftWord2.length();
            int x6 = x5 / j;
            result = leftWord2.substring(0, x6);
        } else {
            throw new Exception();

        }
        if (result.length() > 38) {
            result = result.substring(0, 38) + "...";

        }
        return "\"" + result + "\"";
    }
}