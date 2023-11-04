package lk.ijse.spring.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ImagePathWriterUtil {
    public static String projectPath = "D:\\Dev\\Java\\My_Projects\\Car_Rental_System\\Front_End\\assets";

    public String writeImage(MultipartFile file, Path location) throws IOException, URISyntaxException {

        // Write the binary content of the uploaded image to the specified location on the filesystem.
        Files.write(location, file.getBytes());

        file.transferTo(location);

        // Calculate the relative path of the image within the project by removing the 'projectPath' prefix
        // from the absolute 'location' path. This path can be used to access the image from the front-end.
        return location.toString().replace(projectPath, "");

    }
}
