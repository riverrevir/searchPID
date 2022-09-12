package search.ship.babel.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import search.ship.babel.dto.FileDownloadRequest;
import search.ship.babel.dto.FileUploadRequest;
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
        String imgType = "jpg";
        fileService.downloadImg(imgName, imgType, response);
    }

    @PostMapping("/img/add")
    public void uploadImage(@ModelAttribute FileUploadRequest request, @RequestPart MultipartFile file, HttpServletResponse response) throws Exception {
        String symbolName= request.getSymbolName();
        String designerName= request.getDesignerName();
        String imgName= request.getImgName();
        fileService.uploadImg(symbolName,designerName,imgName,file);
    }
}
