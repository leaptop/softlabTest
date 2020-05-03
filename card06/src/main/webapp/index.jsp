<%--По сути .jsp - это html-код с вкраплениями кода Java. С помощью тегов
<% ... %> мы можем определить код Java на странице JSP.
Чтобы внедрить код java внутрь html-страницы применяются теги <%= %>  --%>
<%
    String header = "My Page";//Объявил переменную. Здесь, как видно, комментарии в джава стиле работают.
%>

<html><!-- Это начальная страничка, которая грузится по умолчанию после запуска приложения. -->
<body>
<h2><%= header%></h2>
<p>Today <%= new java.util.Date() %></p>
<h2>Alekseev Stepan Vladimirovich 32 years old</h2>

<h3>Career Goals:</h3>
To become a valuable specialist in the IT sphere.<br>

I learned at the university:<br>
- Languages: java, C#, C++<br>
- Work in Linux<br>
- Git, Visual Studio, IntelliJIdea<br>
- Agile, Scrum, OOP<br>



<h3>Academic History:</h3>
Siberian State University of Telecommunications and Information Sciences<br>
Bachelor of Science in software development<br>

- A third year student<br>

I used java for solving math: calculus, function graphs etc.<br>

Worked with databases using C#. Created desktop applications with C#.<br>

Created console applications in C, C++<br>

Most of the time was spent on fundamental sciences<br>

<h3>Employment History:</h3>
Academmedia<br>
junior developer 2014-2015<br>
Worked with inner soft of the company - mostly uploading new products to different markets.<br>

Self-employed:<br>
plumber-welder, rope access 2002-2014<br>

<h3>Hobbies & Interests:</h3>
- Watching Conan Show<br>
- Learning English<br>

<h3>Contact Details:</h3>
Telephone: +7-913-389-51-27<br>
Email: stepan-alekseev-87@mail.ru <br>
Novosibirsk, Russian Federation,<br>
facebook.com/alexeevstepan5<br>
vk.com/id9155725<br>
https://github.com/leaptop<br>
skype: stepan-alekseev-<br>
</body>
</html>
