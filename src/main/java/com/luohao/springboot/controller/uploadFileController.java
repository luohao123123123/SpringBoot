package com.luohao.springboot.controller;

import com.luohao.springboot.R.R;
import com.luohao.springboot.R.Renum;
import com.luohao.springboot.utils.FilesUtil;
import com.luohao.springboot.utils.RUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.concurrent.TimeUnit;

@Slf4j
@Controller
public class uploadFileController {
    // 当前项目绝对路径
    private static final String PROJECT_PATH = new File("E:\\idea专业版\\SpringBoot\\src\\main\\resources").getAbsolutePath();
    // 文件上传的路径
    private static final String UPLOAD_PATH = PROJECT_PATH + "\\upload\\";

    // 最好手动在项目里创建文件夹，如果不想手动创建，加上这段代码
    static {
        // 项目里没有upload这个文件夹时，会自动创建
        File file = new File(UPLOAD_PATH);
        if (!file.exists()){
            if (!file.mkdirs()) {
                throw new RuntimeException("创建文件夹失败");
            }
        }
    }

    /**
     * 文件上传
     */
    @ResponseBody
    @PostMapping("/uploadFile")
    // 使用数组可以实现多文件上传，单文件的话不用数组
    public R<Object> uploadFile(@RequestParam(value = "file",required = false) MultipartFile[] multipartFile) throws IOException {
        for (MultipartFile file : multipartFile) {
            String fileLocation = UPLOAD_PATH + file.getOriginalFilename();
            FilesUtil.upload(file.getInputStream(), new File(fileLocation));
            log.info("{}  上传成功",file.getOriginalFilename());
        }
        return  RUtils.success( "文件上传成功");
    }

    /**
     * 文件下载
     */
    @ResponseBody
    @GetMapping("/downloadFile/fileName/{fileName}")
    public void download(HttpServletRequest request, HttpServletResponse response, @PathVariable String fileName) {

        try {
            FilesUtil.download(UPLOAD_PATH + fileName, fileName, request, response, false);
            log.info("{}  下载成功",fileName);
//            return RUtils.success( "文件下载成功");  //这里最好不要有返回值，不然会报错，改为void
        } catch (Exception e) {
            e.printStackTrace();
            log.error("{}  下载失败",fileName);
//            return  RUtils.error(Renum.UnKnow_Error.getCode(), "文件下载失败");
        }
    }

    /**
     * 在线查看文件
     */
    @ResponseBody
    @GetMapping("/watchFile/fileName/{fileName}")
    public void watch(HttpServletRequest request, HttpServletResponse response, @PathVariable String fileName) {

        try {
            FilesUtil.download(UPLOAD_PATH + fileName, fileName, request, response, true);
            log.info("{}  文件查看成功",fileName);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("{}  文件查看失败",fileName);
        }
    }

}
