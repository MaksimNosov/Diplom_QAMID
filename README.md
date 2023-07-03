# Дипломный проект "Инженер по тестированию"

##### [Задание](https://github.com/netology-code/qamid-diplom)

#### [План тестирования](https://github.com/MaksimNosov/Diplom_QAMID/blob/master/Plan.md)

#### [Чек-лист проекта](https://github.com/MaksimNosov/Diplom_QAMID/blob/master/Check.xlsx)

#### [Тест-кейсы с отметками о покрытии](https://github.com/MaksimNosov/Diplom_QAMID/blob/master/Cases.xlsx)

---

## Процедура запуска автотестов:

#### 1. Предварительные условия

- на ПК должны быть установлены IntelliJ IDEA и Appium.
- тесты написаны в редакторе кода IntelliJ IDEA при помощи Appium

#### 2. Подключение устройства и запуск программ

- запустить Appium Server
- ОПЦИОНАЛЬНО - в случае возникновения проблем с подключением запустить команду appium doctor
- запустить IntelliJ IDEA
- подключить физическое устройство в режиме отладки к компьютеру или запустить эмулятор с установленным тестовым приложением

#### 3. Запуск тестов

- перейти в папку: app\src\test\java\ru\iteco\fmhandroid\tests
- открыть тестовые файлы из указанной папки (тестовые файлы разделены по соответствующим разделам тестируемого приложения)
- *Для запуска всех тестов* - кликнуть по папке tests ПКМ и нажать Run;
  *Для запуска группы тестов* - открыть интересующий файл и нажать на кнопку запуска тестов рядом с названием класса;
  *Для запуска каждого теста по отдельности* - нажать на кнопку запуска интересующего теста.
