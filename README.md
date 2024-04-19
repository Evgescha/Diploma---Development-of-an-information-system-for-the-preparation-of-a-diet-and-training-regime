# Разработка информационной системы для составления режима питания и тренировок (2021)

При переходе на главную страницу, пользователю будет отображена информация о сервисе, а также даны будут возможности присоединиться к нему.

 
Рисунок 4.7 – Главная страница

Если на главной странице опуститься ниже, то можно пользователь увидит перед собой секцию с калькулятором. Не важно, это вошедший в систему пользователь или просто гость, он при любом раскладе может воспользоваться данным калькулятором.
Первым делом нужно заполнить все поля, после чего выбрать свой пол и уровень активности и нажать кнопку узнать результат. После этого в поля ниже будет выведен результат о дневной норме калорий и индекс массы тела пользователя с кратким комментарием.
 
Рисунок 4.8 – Калькулятор 

Для дальнейшего пользования системой необходимо войти в нее, или если нет аккаунта – зарегистрироваться.
 
Рисунок 4.9 –  Страница входа и регистрации

Если попытаться войти в систему под данными пользователя, которого не существует – система выдаст сообщение об ошибке.
 
Рисунок 4.10 – Уведомление об ошибке

После заполнения всех полей и нажатия кнопки регистрации появится сообщение об успешной регистрации, после чего можно войти на сайт.
 
Рисунок 4.11 –  Уведомление о регистрации

Самая главная страница для пользователя при работе с системой – это страница расписания. На ней пользователи в зависимости от времени приема пищи будут вносить то, что они съели или какой активностью занимались.
По умолчанию идет переход на сегодняшний день расписания. Если на выбранный день еще не было расписания, то система предложит создать его.
 
Рисунок 4.12 –  Страница расписания

После того, как расписание будет создано, на странице отобразится список приемов пищи (настроенный администратором) и активности. В каждый пункт этого списка пользователь будет вносить свои данные по текущему дню.
 
Рисунок 4.13 –  Страница расписания после создания

Сразу при создании пункты пусты. Чтоб заполнить выбранный период приема пищи, достаточно около него нажать кнопку добавить запись, после чего будет осуществен переход на страницу добавления продукта в выбранный период.
 
Рисунок 4.14 –  Выбор продукта

Так как продуктов в списке много, реализован поиск по названию. Достаточно ввести часть названия и результаты будут отображены ниже. После выбора продукта указывается сколько грамм его было употреблено и все данные отправляются на сервер.
 
Рисунок 4.15 – Результат поиска при выборе продукта

Для внесения активности используется тот же метод на похожей странице.
 
Рисунок 4.16 – Выбор активности

После заполнения выбранного дня данными, под каждым приемом пиши указано общее количество полученных калорий за этот прием,  как и с активностями.
 
Рисунок 4.17 – Заполненная страница расписания

Итоговый результат дня отображен внизу страницы. На нем видна сумма полученных и затраченных калорий, а также разница между ними.
 
Рисунок 4.18 –  Общий результат дня

Если продуктов или активностей в списке окажется недостаточно, пользователь может перейти в пункт продукты и предложить новый продукт.
,-- 
Рисунок 4.19 –  Страница продуктов

Для предложения продукта нужно нажать кнопку предложить, заполнить все поля и нажать кнопку отправить.
 
Рисунок 4.20 –  Предложение нового продукта

После этого предложенный пользователем продукт появится в соответствующем списке и будет ждать одобрения администратора.
 
Рисунок 4.21 – Список предложенных продуктов

Администратор уже может соглашаться на предложенные варианты, редактировать их или удалять, как и остальные продукты или активности.
 
Рисунок 4.22 – Страница продуктов для администратора

Также администратору в соответствующем меню доступна функциональность по управлению пользователями.
 
Рисунок 4.23 – Управление пользователями

При необходимости администратор настраивает какие приемы пищи будут отображаться всем пользователям.
 
Рисунок 4.24 – Управление приемами пищи
