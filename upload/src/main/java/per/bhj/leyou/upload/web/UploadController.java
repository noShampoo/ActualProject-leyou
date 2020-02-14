package per.bhj.leyou.upload.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import per.bhj.leyou.upload.serice.UploadService;

@RestController
@RequestMapping("upload")
public class UploadController {
    @Autowired
    private UploadService uploadService;

    /**
     * 上传照片
     * @param multipartFile
     * @return
     */
    @PostMapping("image")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile multipartFile) {
        return ResponseEntity.ok(uploadService.uploadImage(multipartFile));
    }
}
