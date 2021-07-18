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
slf4j 18.07.2021 12:10:45.123 [http-nio-8082-exec-7] DEBUG r.a.m.c.C.UserRestController - getJsonUser. argument :Petr
slf4j 18.07.2021 12:10:46.241 [http-nio-8082-exec-7] INFO  r.a.m.c.s.DbServiceUserImpl - selected user: User{id=1, name='Petr', password='123', mail='Petr@dot.com'}
slf4j 18.07.2021 12:10:55.172 [http-nio-8082-exec-8] DEBUG r.a.m.c.C.UserRestController - getJsonUser. argument :root
slf4j 18.07.2021 12:10:55.371 [http-nio-8082-exec-8] INFO  r.a.m.c.s.DbServiceUserImpl - selected user: User{id=3, name='Root', password='@#$', mail='admin@factory.com'}
slf4j 18.07.2021 12:11:10.036 [http-nio-8082-exec-9] DEBUG r.a.m.c.C.UserRestController - getJsonUser. argument :Basyl
slf4j 18.07.2021 12:11:10.194 [http-nio-8082-exec-9] INFO  r.a.m.c.s.DbServiceUserImpl - selected user: User{id=2, name='Basyl', password='ABC', mail='XXX@YYY.com'}
slf4j 18.07.2021 12:11:19.686 [http-nio-8082-exec-10] DEBUG r.a.m.c.C.UserRestController - getJsonUser. argument :TestUser
slf4j 18.07.2021 12:11:19.844 [http-nio-8082-exec-10] INFO  r.a.m.c.s.DbServiceUserImpl - selected user: null
