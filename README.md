# MVCRest
Спроектирован WEB сервис (Spring MVC), находится в контроллере UserRestController.
Пример обращения к веб сервису
http://localhost:8082/get-json-user/NameUser
система выберет данные по пользователю из СУБД MSSQL, использована технология JDBC
и верет данные в формате json, например:
{
    "id": 1,
    "name": "Petr",
    "password": "123",
    "mail": "Petr@dot.com"
}

Подключено логирование slf4j в файл и в консоль, пример:
slf4j 18.07.2021 12:10:45.123 [http-nio-8082-exec-7] DEBUG r.a.m.c.C.UserRestController - 
getJsonUser. argument :Petr
slf4j 18.07.2021 12:10:46.241 [http-nio-8082-exec-7] INFO  r.a.m.c.s.DbServiceUserImpl - 
selected user: User{id=1, name='Petr', password='123', mail='Petr@dot.com'}
