package ru.alexeev;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller//теперь этот класс стал контроллером благодаря аннотации
public class MyController {

    @GetMapping("/hello-world")//указывает как обратьтися к этому методу(по URL /hello-world)
    public String sayHello(){
       return "hello_world"; //вернём пользователю представление(view с именем hello_world)
    }
}
