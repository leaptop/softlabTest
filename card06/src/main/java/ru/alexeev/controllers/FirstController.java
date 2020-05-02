package ru.alexeev.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller// эта аннотация будет отсканирована с помощью @ComponentScan("ru.alexeev") в SpringConfig.java
@RequestMapping("/first")//теперь адреса всех методов этого класса должны иметь префикс /first
public class FirstController {
    @GetMapping("/hello")//хотим принимать get-запросы
    public String helloPage(){
        return "first/hello";  //возвращаем страницу представления
    }
    @GetMapping("/goodbye")//срабатывает во время вызова /goodbye в адресной строке
    public String goodByePage(){
        return "first/goodbye";//хорошая практика - класть представления first-контроллера
        // в представление, лежащее в папке first
    }
}
