# MIARBServer
Данный
проект является серверной частью приложения. Обеспечивает CRUD-интерфейс на основе запросов клиентской части.
## Руковдство по запуску сервера
Для запуска сервера и дальнейшей работы с дазой данных и клентской частью необходимо следующее:

1. Создание конфигурационных файлов;
2. Установление соединения с БД;
3. Поднять сервер.

Для завершения работы сервера необходимо:

1. Завершить работу системы.

Создание конфигурационных файлов
---
Перед настройкой необходимо произвести настройку базы данных. 

В данном проекте используется база данных компании [Intersystems](http://www.intersystems.com/) - [Caché](http://www.intersystems.com/our-products/cache/cache-overview/).
Возможно, в случае дальнейшего развития проект будет добавлена возможноть поддержки и других СУБД
 
Физическая модель базы данных выглядит следующим образом:

![Физическая модель БД](https://4.downloader.disk.yandex.ru/disk/1160b36954953612ab8300c8d91385f527fe1cb71c980fe85825f458191fde29/597b70b0/JiACiOGiE0Tu1cxKpYZWNbPc-Odq9O6FJ9O-1mYNHGtgAXYH24EJTKZ2GzA7CXyU8iMSKR2FO3XaXLP50xYx-w%3D%3D?uid=0&filename=temp.png&disposition=inline&hash=&limit=0&content_type=image%2Fpng&fsize=101951&hid=a287434854b2ba85feae3ebf68c167e8&media_type=image&tknv=v2&etag=4e33585c5ac3dfa737926cd584178811)

    P.S. Т.к. Caché является объектно-ориентированной БД (за что, собственно, я ее и выбрал для разнообразия) необязательно придерживаться данной модели - возможно построение объектно-ориентированной модели данных.
     
Имея в арсенале корректную БД для использования в проекте можно приступить непосредственно к генерацции конфигурации:

Запускаем приложение и переходим к генрации

![Переход к генерации](https://3.downloader.disk.yandex.ru/disk/36c98b19b6948b3cb0896423ebc9fa2dc29fb394588b8ca3f8fceca06bb40fe1/597b7299/JiACiOGiE0Tu1cxKpYZWNd7podzdER60QZlEPQhmUkVhVEdiC3piR2lRGGwAciNmP1oCK74Itlo8sv8GAwSVAg%3D%3D?uid=0&filename=mainFrom.PNG&disposition=inline&hash=&limit=0&content_type=image%2Fpng&fsize=15117&hid=c7dcd0b9116389afc57946cd43d5d8e1&media_type=image&tknv=v2&etag=2cbe361a27120933641e16159c971ae4)

Генерируем новый ключ, выбираем место сохранения. Позже этот ключ понадобится дял работы клиентской части.

После успешной генерации создаем файл конфигурации БД (url, login, password)
 
![Настройка конфигурации БД](https://3.downloader.disk.yandex.ru/disk/554efcd33f8c9555faa7e56ebb8f153e5d51327c919849a9809b17841873b668/597b72b1/JiACiOGiE0Tu1cxKpYZWNS6DnRjYRuW71iE3js7ddXB4mIPd9ijhQJeLni1qO54SAa-hCOVSARwViBNIENgQqg%3D%3D?uid=0&filename=generateKey.PNG&disposition=inline&hash=&limit=0&content_type=image%2Fpng&fsize=9297&hid=ce69e1f92c1050c2e892989f660613f3&media_type=image&tknv=v2&etag=0c7ff9101f18ca452c44251ce6488f81)

![Форма ввода данных для соединения с БД](https://3.downloader.disk.yandex.ru/disk/50744dcb590298422fb532f9c2fb87bb0c0c3bb7636dbdb4bf41c7c8e9c10f09/597b736f/JiACiOGiE0Tu1cxKpYZWNRxp6okPYniqeQgQKXG2p-OwEjKt5ExBqH3XNjbU7yyjJuQiE9CBT6J2HNouS8rbPg%3D%3D?uid=0&filename=dbSetting.PNG&disposition=inline&hash=&limit=0&content_type=image%2Fpng&fsize=8708&hid=14e52edeae916dbd45ec46c8142d3076&media_type=image&tknv=v2&etag=3940d7cfc1e6a98087497b9d20e4c55a)

Возвращаемся и создаем файл подключения. Позже он понадобится для работы клиентской части.

На этом с конфигурацией все!

Установление соединения с БД
---
На основной форме нажимаем соответствующую кнопку и смотрим в лог-окно, а так же на статус соединения.

![Соединение с БД](https://1.downloader.disk.yandex.ru/disk/65e0a03bb57e0556c9a7f2b22bd2f868b1f87f25364f39d0fca0a9acedf38dfd/597b755f/JiACiOGiE0Tu1cxKpYZWNYH9obdhEjcB96BDSgApWoNkAyAPTL2fPu2iquhhUjdUFNfPYbBtLKHojdzxJxv5SQ%3D%3D?uid=0&filename=dbConnect.PNG&disposition=inline&hash=&limit=0&content_type=image%2Fpng&fsize=16280&hid=eec2e4a9f6c12130165e71e6b1f756d0&media_type=image&tknv=v2&etag=dfa19f399e6c6419a3bea634e59589ab)

    Просто, верно ? ;)

Запуск сервера
---
Все так же как и с соединением с БД - на основной форме нажимаем нужную кнопку.

![Запуск сервера](https://4.downloader.disk.yandex.ru/disk/3e60aa705c42aa83d9577f3d7f5a6c344c1f2286be82b06056f6e6cfb12c8c0e/597b7606/JiACiOGiE0Tu1cxKpYZWNbqcGFiqQ52-snis64bnyndktZ68TADqfJBs3w9VPdqPO7jDSR3DSfNj4hojSphRnA%3D%3D?uid=0&filename=serverStart.PNG&disposition=inline&hash=&limit=0&content_type=image%2Fpng&fsize=17256&hid=f6dad9a86c6934ec43025c679b9f9618&media_type=image&tknv=v2&etag=fd60e079936da77c8b88289782c07751)

Завершение работы системы
---
Завершение работы происходит выполнением действий, обратных запуску.

![Завершение работы](https://2.downloader.disk.yandex.ru/disk/5dc5202c8e065811eed8a293fac7af5f01e7369c003176f0e0b029095620bf4c/597b75f7/JiACiOGiE0Tu1cxKpYZWNbiSEg5cgIx-W3jrCf7G56i9w8OyHABtBuRC4a775PCjBN-iRNp0PlpYQOH2V8om1Q%3D%3D?uid=0&filename=serverOff.PNG&disposition=inline&hash=&limit=0&content_type=image%2Fpng&fsize=20309&hid=94747919181da574c6bc78bb118d6a77&media_type=image&tknv=v2&etag=dee181d09b6da4cceeddbcd35102b2c9)

## Разработка
Раздел содержит различную информацию об элементах, использованных в разработке и самом процессе разработки.

Испльзовано при разработке
---
* [JavaFX](http://docs.oracle.com/javase/8/javafx/get-started-tutorial/jfx-overview.htm#JFXST784) - Платформа на основе Java для создания RIA-приложений
* [Cache JDBC](http://docs.intersystems.com/latest/csp/docbook/DocBook.UI.Page.cls?KEY=BGJD_intro) - Библиотека, реализующая объектно-ориентированный доступ к БД 
* [MHA](https://github.com/TachD/MacroHashAlgorithm) - Библиотека, реализующая шифрование MacroHash  
* [Maven](https://maven.apache.org/) - Фреймворк для автоматизации сборки проектов

Версия
---
На данный момент (28.07.2017) проект находится в стадии Альфа-тестировании.

Авторы
---
* Alexander Govor - Development to the Alpha version - [TachD](https://github.com/TachD)

Лицензия
---
Для получения данных о лицензии ознакомтесь с [лицензией](https://github.com/TachD/MIARBServer/blob/master/LICENSE).
