
import java.util.*;

public class Main {

    public static void main(String[] args) {

        String pathInput;
        String pathOutput;
        if (args.length == 2) {
            pathInput = args[0];
            pathOutput = args[1];
            Reader reader = new Reader(pathInput);
            LeetChipher leetChipher = new LeetChipher(reader.getInput());
            Writer writer = new Writer(pathOutput, leetChipher.makeLeetText());
        } else {
            System.out.println("Invalid path");
        }

    }

}
