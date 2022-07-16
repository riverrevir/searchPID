package search.ship.babel.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import search.ship.babel.dto.FileDownloadRequest;
import search.ship.babel.service.FileService;

import javax.servlet.http.HttpServletResponse;

@RequiredArgsConstructor
@Controller
@RequestMapping("/api")
public class FileController {
    private final FileService fileService;

    @GetMapping("/img")
    public void downloadImage(@ModelAttribute FileDownloadRequest request, HttpServletResponse response) {
        String imgName = request.getImgName();
        String imgType = "JPG";
        fileService.downloadImg(imgName, imgType, response);
    }
}
