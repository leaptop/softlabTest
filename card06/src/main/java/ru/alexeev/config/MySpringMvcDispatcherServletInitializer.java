package ru.alexeev.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
//Этот класс позволяет избавиться от файла web.xml. Если пройтись вверх по иерархии наследования, то станет ясно, что этот класс
//реализует интерфейс WebApplicationInitializer, который может использоваться как замена web.xml.
public class MySpringMvcDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {//в этих классах нужно передать какую-то конфигурацию
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {//здесь будет замена для applicationContextMVC.xml
        return new Class[] {SpringConfig.class};//теперь наш класс, исполняющий роль web.xml знает где
        // находится Spring конфигурация(в классе SpringConfig)
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};//эквивалентно тому, как мы все запросы(из адресной строки) посылали на dispatcherServlet в web.xml
    }
}
