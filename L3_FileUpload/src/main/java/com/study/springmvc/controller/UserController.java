package com.study.springmvc.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * @Author Harlan
 * @Date 2020/9/8
 */
@Controller
@RequestMapping("/user")
public class UserController {

    /**
     * 手动上传文件
     * @param request 请求对象
     * @return 成功页面
     * @throws Exception 异常
     */
    @RequestMapping("/fileUpload")
    public String fileUpload(HttpServletRequest request) throws Exception {
        System.out.println("已接受到文件...");
        //设置文件保存路径
        String path = request.getSession().getServletContext().getRealPath("/upload/");
        File file = new File(path);
        if (!file.exists()){
            file.mkdirs();
        }

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


    /**
     * 单服务器上传
     * @param request 请求对象
     * @param file 文件
     * @return 成功页面
     * @throws IOException 异常
     */
    @RequestMapping("/mvcUpload")
    public String mvcUpload(HttpServletRequest request, MultipartFile file) throws IOException {
        //设置保存路径
        String path = request.getSession().getServletContext().getRealPath("/upload/");
        File files = new File(path);
        if (!files.exists()){
            files.mkdirs();
        }

        //获取文件名
        String name = file.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        //保存文件
        file.transferTo(new File(path, uuid+"_"+name));

        return "success";
    }

    /**
     * 多服务器上传
     * @param file 文件
     * @return 成功页面
     * @throws IOException 异常
     */
    @RequestMapping("/serverUpload")
    public String serverUpload(MultipartFile file) throws IOException {
        //定义上传文件服务器路径
        String path = "http://localhost:8080/upload/";
        //获取文件名
        String name = file.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replace("-", "");

        //完成跨服务器上传
        //1.创建客户端的对象
        Client client = Client.create();
        //2.与文件服务器进行连接
        WebResource resource = client.resource(path+name);
        //3.上传文件
        resource.put(file.getBytes());

        return "success";
    }
}
