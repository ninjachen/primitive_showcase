package club.jijigugu.onecan.admin.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Logger;


/**
 * Use the commond to test
 * http -f POST localhost:8000/image/primitive file@./java_road_map.jpg n=100 m=7
 * browser localhost:8000/image/view/xxxx
 */
@RestController
@RequestMapping("/image")
public class ImageController {
    static Logger logger = Logger.getLogger(ImageController.class.getName());

    @PostMapping("/primitive")
    public HashMap primitive(@RequestParam("file") MultipartFile file,
                         @RequestParam(value = "n", defaultValue = "100") int n,
                         @RequestParam(value = "m", defaultValue = "7") int m) throws IOException, InterruptedException {
        Thread.sleep(1000);
        HashMap<String, String> resp = new HashMap<>();
        resp.put("url", "https://api.meaningless.cn/image/view/my_picture_after");
        resp.put("msg", "n is number. \n m is type. \n 0=combo 1=triangle 2=rect 3=ellipse 4=circle 5=rotatedrect 6=beziers 7=rotatedellipse 8=polygon (default 1)");
        return resp;
//
//
//        File dir = new File("/tmp/ninja/");
//        if (!dir.exists())
//            dir.mkdirs();
//
//        String fileName = file.getOriginalFilename();
//        if (fileName == null || fileName.isEmpty()) {
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            fileName = sdf.format(new Date());
//        }
//        File sourceFile = new File(dir, fileName);
//        file.transferTo(sourceFile);
//
//        // primitive -i IMG_20181026_115438.jpg -o IMG_20181026_115438_deal_3.jpg -n 200 -m 8
//        long l = System.currentTimeMillis();
//        String input = sourceFile.getAbsolutePath();
//        File newFile = new File(dir, l + ".png");
//        String output = newFile.getAbsolutePath();
//        String cmd = String.format("primitive -i %s -o %s -n %d -m %d", input, output, n, m);
//        exec(cmd);
//        String url = buildImageUrl(newFile.getName());
//        HashMap<String, String> resp = new HashMap<>();
//        resp.put("url", url);
//        resp.put("msg", "n is number. \n m is type. \n 0=combo 1=triangle 2=rect 3=ellipse 4=circle 5=rotatedrect 6=beziers 7=rotatedellipse 8=polygon (default 1)");
//        return resp;
    }

    @GetMapping("/view/{filename}")
    public ResponseEntity view(@PathVariable("filename") String fileName) throws IOException {
        File file = new File("/tmp/ninja/", fileName);
        byte[] bytes = Files.readAllBytes(file.toPath());
        return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(bytes);
    }

    private String buildImageUrl(String fileName) {
        return String.format("http://image.rnd.app/image/view/"+fileName);
    }

    private void exec(String cmd) {
        Runtime runtime = Runtime.getRuntime();
        try {
            logger.info(cmd);
            Process process = runtime.exec(cmd);
            process.waitFor();
            int exitVal = process.exitValue();
            System.out.println("process exit value is " + exitVal);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
