Feature: Убедиться, что в полученной выборке телефоны только производителя Apple.
  Проверить все страницы. Скрипт должен просматривать все доступные страницы.
  Считаем что страниц может быть от одной до 10.


  @Market
  Scenario: Проверка фильтра
    Given 2 Запустить Chrome
    Then 2 Открыть 'https://market.yandex.ru'
    Then 2 Перейти в раздел мобильные телефоны
    Then 2 Установить фильтр по производителю Apple
    Then 2 Убедиться, что в полученной выборке телефоны 'APPLE'
    Then 2 Закрыть Chrome
