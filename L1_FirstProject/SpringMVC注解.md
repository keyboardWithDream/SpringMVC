# SpringMVC注解

## `@RequestMaapping`注解

**作用: 路径映射**

**属性:**

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

***

***

## `@RequestParam`注解

**作用: 把请求中指定名称的参数给控制器中的形参赋值**

**属性:**

`value`/`name`: 请求参数中的名称

`required`: 请求参数中是否必须提供此参数, 默认值为`true`. 表示必须提供,如果不提供将报错.

```java
@RequestMapping(path = "/testRequestParam")
public String testRequestParam(@RequestParam(name = "name", , required = false) String username){
    System.out.println(username);
    return "success";
}
```