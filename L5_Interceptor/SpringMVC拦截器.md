# `SpringMVC`拦截器

## 实现步骤

1. 编写拦截器,实现`HandlerInterceptor`接口

   * ```java
     public class Interceptor1 implements HandlerInterceptor {
     	...
     }
     ```

   * `pubulic boolean preHandle()`方法 - 预处理方法, 在`controller`的方法之前执行, 如果返回`true`则放行并执行下一个拦截器,或执行`controller`方法,返回`false`则不放行, 可通过调用`request`或`response`进行转发(定向) 

     ```java
     /**
      * 预处理方法, controller的方法之前执行
      * @param request request 可进行请求转发
      * @param response response 可进行重定向
      * @param handler handler
      * @return true 放行, false 不放行.
      * @throws Exception 异常
      */
     @Override
     public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
         System.out.println("预处理方法执行了111...");
         //request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request, response);
         return true;
     }
     ```

   * `public void postHandle()`方法 - 后处理方法, 在`controller`的方法执行后, `success.jsp`的方法执行前执行,可以通过调用`request`或`response`进行转发(定向), 此时`controller`中的方法已经执行

     ```java
     /**
      * 后处理方法, controller方法执行后, success.jsp执行前
      * @param request request
      * @param response response
      * @param handler handler
      * @param modelAndView mv
      * @throws Exception 异常
      */
     @Override
     public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
         System.out.println("后处理方法执行了111...");
         //request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request,response);
     }
     ```

   * `public void afterCompletion()`方法 - 最后执行的方法, 在放行到页面后执行的方法, 通常用于释放资源

     ```java
     /**
      * success.jsp页面执行后执行
      * @param request request
      * @param response response
      * @param handler handler
      * @param ex ex
      * @throws Exception 异常
      */
     @Override
     public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
         System.out.println("after方法执行了111...");
     }
     ```

2. 配置拦截器(多个拦截器)

```xml
<!-- 拦截器 -->
<mvc:interceptors>
    <!-- 第一个拦截器 -->
    <mvc:interceptor>
        <!-- 需要拦截的方法 -->
        <mvc:mapping path="/test/**"/>
        
        <!-- 不需要拦截的方法
        <mvc:exclude-mapping path=""/>
        -->
        
        <!-- 配置拦截器对象 -->
        <bean class="com.study.springmvc.interceptor.interceptor.Interceptor1"/>
    </mvc:interceptor>

    <!-- 第二个拦截器 -->
    <mvc:interceptor>
        <mvc:mapping path="/**"/>
        <bean class="com.study.springmvc.interceptor.interceptor.Interceptor2"/>
    </mvc:interceptor>
</mvc:interceptors>
```