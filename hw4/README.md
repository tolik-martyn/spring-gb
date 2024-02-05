### Описание ДЗ 3:

Создать сервис "RegistrationService", который принимает на вход данные о пользователе (имя, возраст, email), создает пользователя с помощью UserService, затем использует DataProcessingService для добавления пользователя в список и выполнения операций над этим списком. После выполнения каждой операции, использовать NotificationService для вывода информации о выполненной операции.

### Описание ДЗ 4:

Разработайте веб-приложение с использованием Spring MVC и Thymeleaf, которое отображает список пользователей.

*По факту я доработал приложение из ДЗ 3 с использованием Thymeleaf.*

##### *Для Postman:*

*GET:*
- [Filter](http://localhost:8080/api/filter/24)
- [All Users](http://localhost:8080/api/allUsers)
- [Hello](http://localhost:8080/api/hello)

*POST:*
- [Sort](http://localhost:8080/api/sort)
- [Average](http://localhost:8080/api/average)
- [Register](http://localhost:8080/api/register)

*DELETE:*
- [Delete User](http://localhost:8080/api/delete/3)

*PUT:*
- [Update User](http://localhost:8080/api/update/4)

*Данные для Body:*

```json
[
    {
        "name": "Ivan",
        "age": 32,
        "email": "Ivan@mail.ru"
    },
    {
        "name": "Oleg",
        "age": 23,
        "email": "Oleg@mail.ru"
    },
    {
        "name": "Max",
        "age": 29,
        "email": "Max@mail.ru"
    },
    {
        "name": "Olya",
        "age": 25,
        "email": "Olya@mail.ru"
    }
]
```
