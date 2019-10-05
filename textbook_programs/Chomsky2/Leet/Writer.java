
import java.io.*;

public class Writer {
    private final String PATH;
    private String output;

    public Writer(String PATH, String output) {

        this.PATH = PATH;
        this.output = output;
        try {

            FileOutputStream fos = new FileOutputStream(this.PATH);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            bos.write(output.getBytes());
            bos.flush();
            bos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
