# SpringMVC注解

## `@RequestMaapping`注解

**作用: 路径映射**

**属性:**

`value`/`path` : 映射路径名

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

---

---

## `@RequestBody`注解

**作用: 用于获取请求体内容. 直接使用得到的是`key=value&key=value`结构的数据, `get`请求方式不适用**

**属性:**

`required`: 是否必须有请求体. 默认值为`true`, 当取值为`true`时, `get`方法请求会报错, 如果取值为`false`, `get`请求得到的时`null`.

```java
@RequestMapping(path = "/testRequestBody")
public String testRequestBody(@RequestBody String body){
    System.out.println(body);
    return "success";
}
```

---

---

## `@PathVaribale`注解

**作用: 用于绑定`url`中的占位符. 例如: 请求`url`中 /delete/{id}, 这个{id}就是`url`的占位符. **

**属性: **

`value`/`name`: 用于指定`url`中占位符的名称

`required`: 是否必须提供占位符

```java
@RequestMapping(path = "testPathVariable/{id}")
public String testPathVariable(@PathVariable(name = "id") String id){
    System.out.println(id);
    return "success";
}
```

---

---

## `@RequestHeader`注解

**作用: 用于获取请求消息头**

**属性:**

`value`/`name`:提供消息头名称

`required`: 是否必须有此消息头

```java
@RequestMapping("/testRequestHeader")
public String testRequestHeader(@RequestHeader("Accept") String header){
    System.out.println(header);
    return "success";
}
```

---

---

## `@CookieValue`注解

**作用: 用于把指定`cookie`名称的值传入控制器方法参数**

**属性:**

`value`/`name`: 指定`cookie`的名称

`required`: 是否必须有此`cookie`

```java
@RequestMapping("/testCookieValue")
public String testCookieValue(@CookieValue("JSESSIONID") String cookie){
    System.out.println(cookie);
    return "success";
}
```

---

---

## `@ModelAttribute`注解

**作用: 作用在方法上,表示当前方法会在控制器的方法之前执行. 	作用在参数上, 获取指定的数据给参数赋值**

**属性:**

`value` : 用于获取数据的`key`. `key`可以时`POJO`的属性名称, 也可以是`map`结构的`key`.

作用在方法:

```java
@RequestMapping("/testModelAttribute")
public String testModelAttribute(@ModelAttribute("account") Account account){
    System.out.println("testModelAttribute方法执行了...");
    System.out.println(account);
    return "success";
}

@ModelAttribute
public Account showUser(String username, Map<String, Account> map){
    System.out.println("showUser方法执行了...");
    //模拟查询数据库
    Account account = new Account();
    User user = new User();
    user.setUname("uname");
    user.setAge(20);
    user.setDate(new Date());
    account.setUser(user);
    map.put("account", account);
    return account;
}
```

---

---

## `@SessionAttributes`注解

**作用: 用于多次执行控制方法间的参数共享(作用在类上)**

**属性:**

`value`: 用于指定存入的属性名称

`type`: 用于指定存入的数据类型