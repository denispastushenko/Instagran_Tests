package units;
import org.apache.commons.io.FilenameUtils;
import java.io.*;
import java.net.URL;

public class ImageDownload {


    public static final String FILE_WAY = "Z:/Test/Test_image.jpg";

    public static File saver(String url1, String destination) throws IOException {
        URL url = new URL(url1);
        String filename = FilenameUtils.getName(url1);
        try (InputStream input = url.openStream();
             OutputStream output = new FileOutputStream(FILE_WAY + filename)) {
            byte[] b = new byte[1024];
            int lenght;
            while ((lenght = input.read(b)) != -1) {
                output.write(b, 0, lenght);
            }
        } catch (FileNotFoundException e) {
            System.err.println("An IOException was caught!");
            e.printStackTrace();
        }
        return (new File(destination));
    }
}

