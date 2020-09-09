# `SpringMVC`-文件上传

## 单服务器代码实现

在`springmvc.xml`中配置文件解析器对象

```xml
<bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
    <!-- 最大文件大小 -->
    <property name="maxUploadSize" value="10485760"/>
</bean>
```

<font color=red>注意：其`id`值只能为`multipartResolve`，不能将其改变，否则无效。</font>

----

在`Controller`中编写业务代码，在形参中添加`MultipartFile`对象，将其命名为请求参数名

```java
@RequestMapping("/mvcUpload")
//添加MultipartFile对象
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
```

----

---

## 多服务器代码实现

实现一个应用服务器向文件服务器上传文件

在`prom.xml`中导入坐标

```xml
<dependency>
  <groupId>com.sun.jersey</groupId>
  <artifactId>jersey-core</artifactId>
  <version>1.18.1</version>
</dependency>

<dependency>
  <groupId>com.sun.jersey</groupId>
  <artifactId>jersey-client</artifactId>
  <version>1.18.1</version>
</dependency>
```

---

在`Controller`中实现业务代码

```java
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
```