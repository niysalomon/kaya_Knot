package kaya_knot.kayaKnot.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Objects;

public class AppUtils {
    public static byte[] convertBase64String(String base64String) {
        String[] base64Image = base64String.split(",");
   return Base64.getDecoder().decode(base64Image[1]);
    }
    public static File convertMultipartFileToFile(MultipartFile multipartFile) throws IOException {
        File convertedFile = new File(Objects.requireNonNull(multipartFile.getOriginalFilename()));
        boolean isFileCreated = convertedFile.createNewFile();
        if(isFileCreated){
            try(FileOutputStream fos = new FileOutputStream(convertedFile)){
                fos.write(multipartFile.getBytes());
            }
        }
        return convertedFile;
    }

}
