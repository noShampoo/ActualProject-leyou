package per.bhj.leyou.upload.serice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import per.bhj.leyou.common.enums.ExceptionEnum;
import per.bhj.leyou.common.exception.LyException;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class UploadService {
    private static final List<String> ALLOWED_CONTENT_TYPE = Arrays.asList("image/jpeg", "image/jpg",
            "image/png");

    public String uploadImage(MultipartFile multipartFile) {
        try {
            //校验文件类型
            if (!ALLOWED_CONTENT_TYPE.contains(multipartFile.getContentType())) {
                throw new LyException(ExceptionEnum.INVALID_FILE_TYPE);
            }
            //校验文件内容
            BufferedImage bufferedImage = ImageIO.read(multipartFile.getInputStream());
            if (bufferedImage == null) throw new LyException(ExceptionEnum.INVALID_FILE_TYPE);
            //保存文件到本地
            File file = new File("E:\\Java开发学习\\自学课程\\学习代码\\leyou\\uploadfile", multipartFile.getName());
            multipartFile.transferTo(file);
            //返回路径
            return "http://manage.leyou.com/" + multipartFile.getOriginalFilename();
        } catch (Exception e) {
            log.error("上传文件失败", e);
            throw new LyException(ExceptionEnum.FILE_UPLOAD_FAIL);
        }
    }
}
