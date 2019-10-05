
import java.io.*;

public class Reader {

    private final String PATH;
    private StringBuilder input;

    public Reader(String PATH) {
        this.PATH = PATH;
        input = new StringBuilder();
        try {
            FileInputStream fis = new FileInputStream(this.PATH);
            BufferedInputStream bis = new BufferedInputStream(fis);
            int i;

            while ((i = bis.read()) != -1) {
                input.append((char) i);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getInput() {
        return input.toString();
    }
}
