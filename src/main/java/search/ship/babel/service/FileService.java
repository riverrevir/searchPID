package search.ship.babel.service;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

@Service
public class FileService {
    private static final String root = "ROOT PATH";

    public void downloadImg(String imgName, String imgType, HttpServletResponse response) {
        String imgSrc = new StringBuilder(root).append("/").append(imgName).append(".").append(imgType).toString();
        try (FileInputStream fis = new FileInputStream(imgSrc);
             OutputStream out = response.getOutputStream();
        ) {
            int readCount = 0;
            byte[] buffer = new byte[1024];
            while ((readCount = fis.read(buffer)) != -1) {
                out.write(buffer, 0, readCount);
            }
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("",e);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
