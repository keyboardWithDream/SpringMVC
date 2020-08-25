# SpringMVC注解

## `@RequestMaapping`注解

`path` : 映射路径名

`method` : 接收的请求方式

`params` : 指定限制请求参数的条件(必须包含的参数或值)

`headers` : 请求头必须包含的参数

```java
@RequestMapping(path = "/hello", method = {RequestMethod.GET, RequestMethod.POST}, params = {"hello", "who=SpringMVC"}, headers = {"User-Agent"})
public String sayHello(){
    System.out.println("Hello SpringMVC!");
    return "success";
}
```