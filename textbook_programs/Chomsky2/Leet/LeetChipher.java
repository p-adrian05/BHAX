
import java.util.HashMap;
import java.util.Map;

public class LeetChipher {

    private Map<String, String[]> leetAlphabet;
    private String input;

    public LeetChipher(String input) {
        this.input = input;
        leetAlphabet = new HashMap<String, String[]>();

        leetAlphabet.put("A", new String[] { "4", "/-\\", "/_\\", "@", "/\\" });
        leetAlphabet.put("B", new String[] { "8", "13", "|}", "|:", "|8", "|3", "18", "6", "|B", "|8", "lo", "|o" });
        leetAlphabet.put("C", new String[] { "<", "{", "[", "(" });
        leetAlphabet.put("D", new String[] { "|)", "|}", "|]" });
        leetAlphabet.put("E", new String[] { "3" });
        leetAlphabet.put("F", new String[] { "|=", "ph", "|#", "|\"" });
        leetAlphabet.put("G", new String[] { "[", "-", "[+", "6", "C" });
        leetAlphabet.put("H", new String[] { "4", "|-|", "[-]", "{-}", "|=|", "[=]", "{=}", "|+|", "/-/" });
        leetAlphabet.put("I", new String[] { "1", "|", "!", "9" });
        leetAlphabet.put("J", new String[] { "_|", "_/", "_7", "_)", "_]", "_}" });
        leetAlphabet.put("K", new String[] { "|<", "l<", "|{", "l{" });
        leetAlphabet.put("L", new String[] { "|_", "|", "1", "][" });
        leetAlphabet.put("M", new String[] { "44", "|\\/|", "^^", "/\\/\\", "/X\\", "[]\\/][", "[]V[]", "(V)", "//.",
                ".\\\\", "N\\" });
        leetAlphabet.put("N", new String[] { "|\\|", "/\\/", "/V", "][\\\\][" });
        leetAlphabet.put("O", new String[] { "0", "()", "[]", "{}", "<>" });
        leetAlphabet.put("P", new String[] { "|o", "|O", "|>", "|*", "|°", "|D", "/o", "|7", "[]D" });
        leetAlphabet.put("Q", new String[] { "O_", "9", "(,)", "0" });
        leetAlphabet.put("R", new String[] { "|2", "12", ".-", "|^", "l2" });
        leetAlphabet.put("S", new String[] { "5", "$", "§" });
        leetAlphabet.put("T", new String[] { "7", "+", "~|~", "-|-" });
        leetAlphabet.put("U", new String[] { "|_|", "\\_\\", "/_/", "\\_/", "(_)", "[_]", "{_}" });
        leetAlphabet.put("V", new String[] { "\\/" });
        leetAlphabet.put("W",
                new String[] { "\\/\\/", "(/\\)", "\\^/", "|/\\|", "\\X/", "\\\\’", "’//", "VV", "\\_|_/" });
        leetAlphabet.put("X", new String[] { "%", "*", "><", "}{", ")(" });
        leetAlphabet.put("Y", new String[] { "'/" });
        leetAlphabet.put("Z", new String[] { "2", "5", "7", ">", "(/)" });

    }

    public String makeLeetText() {
        StringBuilder output = new StringBuilder();
        int ascii;

        for (int i = 0; i < input.length(); i++) {
            ascii = (int) input.charAt(i);

            if (ascii == 32) {
                output.append(" ");
            }
            if (ascii >= 48 && ascii <= 57) {
                output.append(input.charAt(i));
            }
            if (ascii == 10) {
                output.append("\n");
            }

            for (String key : leetAlphabet.keySet()) {
                if (input.toUpperCase().charAt(i) == key.charAt(0)) {
                    output.append(leetAlphabet.get(key)[getRandomNum(leetAlphabet.get(key).length)]);

                }
            }
        }

        return output.toString();
    }

    private int getRandomNum(int length) {
        int min = 0;
        int max = length - 1;
        return (int) (Math.random() * (max - min + 1)) + min;
    }

}
