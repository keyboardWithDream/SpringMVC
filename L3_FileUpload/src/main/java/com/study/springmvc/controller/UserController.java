package com.study.springmvc.controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.UUID;

/**
 * @Author Harlan
 * @Date 2020/9/8
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/fileUpload")
    public String fileUpload(HttpServletRequest request) throws Exception {
        System.out.println("已接受到文件...");
        //设置文件保存路径
        String path = request.getSession().getServletContext().getRealPath("/upload/");
        File file = new File(path);
        if (!file.exists()){
            file.mkdirs();
        }

        System.out.println();

        //获取文件,获取上传文件项
        System.out.println("正在解析文件...");
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        List<FileItem> items = upload.parseRequest(request);
        for (FileItem item : items) {
            //判断是否为表单项
            if (item.isFormField()){
                System.out.println("普通表单项");
            }else {
                String name = item.getName();
                String uuid = UUID.randomUUID().toString().replace("-","");
                item.write(new File(path, name+"_"+uuid));
                //删除临时文件
                item.delete();
            }
        }
        System.out.println("文件已保存...");
        return "success";
    }
}
