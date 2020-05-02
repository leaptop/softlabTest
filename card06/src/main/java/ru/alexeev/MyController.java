package ru.alexeev;
/*
Контроллеры обрабатывают запросы от пользователя(входящие http запросы). Они обмениваются данными с моделью.
Показывают пользователю правильное(нужное) представление. Могут переадресовывать пользователя на другие страницы.
 */
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller//теперь этот класс стал контроллером благодаря аннотации. Эта аннотация наследуется от @Component,
//поэтому @ComponentScan работает с @Controller так же, как и просто с @Component. Когда @ComponentScan видит
// аннотацию @Controller, она создаёт бин из этого помеченного java класса. Т.е. @Controller - тот же @Component,
//но с дополнительными возможностями. Внутри контроллеров находятся методы. Обычно, (но не всегда) каждый метод
//соответсвует одному URL. Обычно(но не всегда), методы возвращают строку (String) - название представления,
// которое надо показать пользователю.
/*
Если код такой:
@Controller
@RequestMapping("/people")
public class PersonController{
То здесь для обращения к любому методу класса сначала надо добавлять префикс /people
 */
public class MyController {

    @GetMapping("/hello-world")//указывает как обратьтися к этому методу(по URL /hello-world)
    public String sayHello(){
       return "hello_world"; //вернём пользователю представление(view с именем hello_world)
    }
}
