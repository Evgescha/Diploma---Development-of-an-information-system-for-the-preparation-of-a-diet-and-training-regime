# Разработка информационной системы для составления режима питания и тренировок (2021)

При переходе на главную страницу, пользователю будет отображена информация о сервисе, а также даны будут возможности присоединиться к нему.

 ![image](https://github.com/Evgescha/Diploma---Development-of-an-information-system-for-the-preparation-of-a-diet-and-training-regime/assets/38140129/b342b257-cdb9-4df0-a4c3-240dea83071f)

Рисунок 4.7 – Главная страница

Если на главной странице опуститься ниже, то можно пользователь увидит перед собой секцию с калькулятором. Не важно, это вошедший в систему пользователь или просто гость, он при любом раскладе может воспользоваться данным калькулятором.
Первым делом нужно заполнить все поля, после чего выбрать свой пол и уровень активности и нажать кнопку узнать результат. После этого в поля ниже будет выведен результат о дневной норме калорий и индекс массы тела пользователя с кратким комментарием.
 
 ![image](https://github.com/Evgescha/Diploma---Development-of-an-information-system-for-the-preparation-of-a-diet-and-training-regime/assets/38140129/70241289-6de5-4787-a7fa-d26990af28a3)

Рисунок 4.8 – Калькулятор 

Для дальнейшего пользования системой необходимо войти в нее, или если нет аккаунта – зарегистрироваться.
 
 ![image](https://github.com/Evgescha/Diploma---Development-of-an-information-system-for-the-preparation-of-a-diet-and-training-regime/assets/38140129/fa99fd15-2fe8-40ad-97b2-fb0e882585ec)

Рисунок 4.9 –  Страница входа и регистрации

Если попытаться войти в систему под данными пользователя, которого не существует – система выдаст сообщение об ошибке.
 
 ![image](https://github.com/Evgescha/Diploma---Development-of-an-information-system-for-the-preparation-of-a-diet-and-training-regime/assets/38140129/96b0c900-f41f-4e77-84a4-2cccd77a0d6b)

Рисунок 4.10 – Уведомление об ошибке

После заполнения всех полей и нажатия кнопки регистрации появится сообщение об успешной регистрации, после чего можно войти на сайт.
 
 ![image](https://github.com/Evgescha/Diploma---Development-of-an-information-system-for-the-preparation-of-a-diet-and-training-regime/assets/38140129/45223b77-904b-4a59-b500-d5d1e62751a9)

Рисунок 4.11 –  Уведомление о регистрации

Самая главная страница для пользователя при работе с системой – это страница расписания. На ней пользователи в зависимости от времени приема пищи будут вносить то, что они съели или какой активностью занимались.
По умолчанию идет переход на сегодняшний день расписания. Если на выбранный день еще не было расписания, то система предложит создать его.
 
 ![image](https://github.com/Evgescha/Diploma---Development-of-an-information-system-for-the-preparation-of-a-diet-and-training-regime/assets/38140129/d17cedf0-1f0f-464c-bd3f-88f399102580)

Рисунок 4.12 –  Страница расписания

После того, как расписание будет создано, на странице отобразится список приемов пищи (настроенный администратором) и активности. В каждый пункт этого списка пользователь будет вносить свои данные по текущему дню.
 
 ![image](https://github.com/Evgescha/Diploma---Development-of-an-information-system-for-the-preparation-of-a-diet-and-training-regime/assets/38140129/ae1dd5ef-1438-4f64-918c-a0f0d4a76253)

Рисунок 4.13 –  Страница расписания после создания

Сразу при создании пункты пусты. Чтоб заполнить выбранный период приема пищи, достаточно около него нажать кнопку добавить запись, после чего будет осуществен переход на страницу добавления продукта в выбранный период.
 
 ![image](https://github.com/Evgescha/Diploma---Development-of-an-information-system-for-the-preparation-of-a-diet-and-training-regime/assets/38140129/caa5409d-1b3e-42c0-82e7-8010c62789d1)

Рисунок 4.14 –  Выбор продукта

Так как продуктов в списке много, реализован поиск по названию. Достаточно ввести часть названия и результаты будут отображены ниже. После выбора продукта указывается сколько грамм его было употреблено и все данные отправляются на сервер.
 
 ![image](https://github.com/Evgescha/Diploma---Development-of-an-information-system-for-the-preparation-of-a-diet-and-training-regime/assets/38140129/b66bd5bc-533d-4dc5-8948-428552afb55b)

Рисунок 4.15 – Результат поиска при выборе продукта

Для внесения активности используется тот же метод на похожей странице.
 
 ![image](https://github.com/Evgescha/Diploma---Development-of-an-information-system-for-the-preparation-of-a-diet-and-training-regime/assets/38140129/34c091ff-4a8e-4058-92f6-43647a57becc)

Рисунок 4.16 – Выбор активности

После заполнения выбранного дня данными, под каждым приемом пиши указано общее количество полученных калорий за этот прием,  как и с активностями.
 
 ![image](https://github.com/Evgescha/Diploma---Development-of-an-information-system-for-the-preparation-of-a-diet-and-training-regime/assets/38140129/222c2286-8baf-4564-9977-c2edcaecdf7f)

Рисунок 4.17 – Заполненная страница расписания

Итоговый результат дня отображен внизу страницы. На нем видна сумма полученных и затраченных калорий, а также разница между ними.
 
 ![image](https://github.com/Evgescha/Diploma---Development-of-an-information-system-for-the-preparation-of-a-diet-and-training-regime/assets/38140129/79b47326-2ec4-49d2-b75d-06e3141286c0)

Рисунок 4.18 –  Общий результат дня

Если продуктов или активностей в списке окажется недостаточно, пользователь может перейти в пункт продукты и предложить новый продукт.

![image](https://github.com/Evgescha/Diploma---Development-of-an-information-system-for-the-preparation-of-a-diet-and-training-regime/assets/38140129/3a65f758-43d8-4186-81f9-e2ced13acd80)

Рисунок 4.19 –  Страница продуктов

Для предложения продукта нужно нажать кнопку предложить, заполнить все поля и нажать кнопку отправить.
 
 ![image](https://github.com/Evgescha/Diploma---Development-of-an-information-system-for-the-preparation-of-a-diet-and-training-regime/assets/38140129/ff5adfc3-95c6-4d6d-8289-4ac5bcb3e719)

Рисунок 4.20 –  Предложение нового продукта

После этого предложенный пользователем продукт появится в соответствующем списке и будет ждать одобрения администратора.
 
 ![image](https://github.com/Evgescha/Diploma---Development-of-an-information-system-for-the-preparation-of-a-diet-and-training-regime/assets/38140129/b9547ca3-3969-4bc2-a042-6d9597db7873)

Рисунок 4.21 – Список предложенных продуктов

Администратор уже может соглашаться на предложенные варианты, редактировать их или удалять, как и остальные продукты или активности.
 
 ![image](https://github.com/Evgescha/Diploma---Development-of-an-information-system-for-the-preparation-of-a-diet-and-training-regime/assets/38140129/49f652fc-0b26-439c-972c-c185d0bcb433)

Рисунок 4.22 – Страница продуктов для администратора

Также администратору в соответствующем меню доступна функциональность по управлению пользователями.
 
 ![image](https://github.com/Evgescha/Diploma---Development-of-an-information-system-for-the-preparation-of-a-diet-and-training-regime/assets/38140129/32fd63dc-65e2-40b6-94a6-394c3eb8163f)

Рисунок 4.23 – Управление пользователями

При необходимости администратор настраивает какие приемы пищи будут отображаться всем пользователям.
 
 ![image](https://github.com/Evgescha/Diploma---Development-of-an-information-system-for-the-preparation-of-a-diet-and-training-regime/assets/38140129/5a2f6013-952b-495e-9daa-c99036b3e1e6)

Рисунок 4.24 – Управление приемами пищи
