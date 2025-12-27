1. Я создал API онлайн библиотеки. С помощью него можно добавить автора (нужно указать его ID, имя и фамилию), добавить автору книгу (указать её ID, название, ID её автора и год выпуска), показать все книги автора (указать его ID) и удалить автора с его книгами (указать его ID).

API методы:
GET	/library/books	Получить список всех книг
POST	/library/authors	Создать нового автора
POST	/library/books	Добавить книгу (требует ID существующего автора)
GET	/library/authors/{id}/books	Найти все книги конкретного автора
DELETE	/library/authors/{id}	Удалить автора и все его книги

Примеры использования (тестирование):
Посмотреть всех авторов (GET):
Просто открой в браузере: http://localhost:8080/library/books (вернет пустой список, если ничего не добавлено).
Добавить автора (POST через PowerShell):
powershell
Invoke-RestMethod -Method Post -Uri "http://localhost:8080/library/authors" -ContentType "application/json" -Body '{"id": 1, "firstName": "Lev", "lastName": "Tolstoy"}'
Use code with caution.

Добавить книгу (POST):
powershell
Invoke-RestMethod -Method Post -Uri "http://localhost:8080/library/books" -ContentType "application/json" -Body '{"id": 10, "title": "War and Peace", "authorId": 1, "year": 1869}'
Use code with caution.

Поиск книг конкретного автора:
http://localhost:8080/library/authors/1/books.
