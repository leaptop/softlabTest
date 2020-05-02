package ru.alexeev.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

@Configuration//annotation indicates that a class declares one or more @Bean methods and may be processed by the
// Spring container to generate bean definitions and service requests for those beans at runtime.
@ComponentScan("ru.alexeev")// передаём информацию о том, где лежат наши компоненты и контроллер. При этом сканируется
//не только данная папка, но и все лежащие в ней папки.
@EnableWebMvc// соответствует тегу <mvc:annotation-driven/> из applicationContextMVC.xml
public class SpringConfig implements WebMvcConfigurer {//WebMvcConfigurer реализуется, когда мы хотим настроить Spring MVC под себя
    //в данном случае мы хотим вместо стандартного шаблонизатора использовать шаблонизатор Thymeleaf.  В третьем методе мы его задаём.

    private final ApplicationContext applicationContext;

    @Autowired//с помощью этой аннотации внедряем applicationContext(Spring это сделает за нас). Он будет использован в бине templateReslover
    //для настройки нашего ThymeLeaf
    public SpringConfig(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Bean
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setApplicationContext(applicationContext);
        templateResolver.setPrefix("/WEB-INF/views/");//задаём папку, в которой будут лежать наши представления
        templateResolver.setSuffix(".html");//задаём расширения этих представлений
        return templateResolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        templateEngine.setEnableSpringELCompiler(true);
        return templateEngine;
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(templateEngine());
        registry.viewResolver(resolver);
    }
}
//всё, что здесь написано эквивалентно файлу applicationContextMVC.xml, лежавшему
// в C:\Users\stepa\softlabTest\card06\src\main\webapp\WEB-INF\views:
/*
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:mvc="http://www.springframework.org/schema/mvc"
       xsi:schemaLocation="
		http://www.springframework.org/schema/beans
    	http://www.springframework.org/schema/beans/spring-beans.xsd
    	http://www.springframework.org/schema/context
    	http://www.springframework.org/schema/context/spring-context.xsd
    	http://www.springframework.org/schema/mvc
        http://www.springframework.org/schema/mvc/spring-mvc.xsd">

    <context:component-scan base-package="ru.alexeev"/><!--Передаём путь до наших компонентов. -->

    <mvc:annotation-driven/><!--Включает необходимые аннотации для spring MVC приложения. -->

    <!--Создаю три бина, чтобы работал шаблонизатор Thymeleaf-->
    <bean id="templateResolver" class="org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver">
        <property name="prefix" value="/WEB-INF/views/"/>
        <property name="suffix" value=".html"/><!-- .html отвечает за то, какие расширения будут у наших файлов представлений. В итоге
        можно будет не указывать расширение и полный путь до представления(указано с помощью /WEB-INF/views/-->
    </bean>

    <bean id="templateEngine" class="org.thymeleaf.spring5.SpringTemplateEngine">
        <property name="templateResolver" ref="templateResolver"/>
        <property name="enableSpringELCompiler" value="true"/>
    </bean>

    <bean class="org.thymeleaf.spring5.view.ThymeleafViewResolver">
        <property name="templateEngine" ref="templateEngine"/>
        <property name="order" value="1"/>
        <property name="viewNames" value="*"/>
    </bean>
</beans>
-------------------------------------------------------------------------------------------------------------------------------
А вот содержимеое C:\Users\stepa\softlabTest\card06\src\main\webapp\WEB-INF\web.xml:

<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd"
         id="WebApp_ID" version="3.1">

  <display-name>spring-mvc-app1</display-name>

  <absolute-ordering/>

  <servlet><!-- Создём DispatcherServlet с названием dispatcher  -->
    <servlet-name>dispatcher</servlet-name>
    <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
    <init-param>
      <param-name>contextConfigLocation</param-name>
      <param-value>/WEB-INF/applicationContextMVC.xml</param-value>
    </init-param>
    <load-on-startup>1</load-on-startup><!-- говорит о том, что этот dispatcherservlet надо загружать в  первую очередь  -->
  </servlet>

  <servlet-mapping>
    <servlet-name>dispatcher</servlet-name>
    <url-pattern>/</url-pattern><!-- Любой URL, направляемый е=на наш сервер должен направляться на наш диспатчерСервлет  -->
  </servlet-mapping>

</web-app>
 */