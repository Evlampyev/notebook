__Что сделал__
1. Хранение в BD с пробелом
2. Логирование


__Вопросы__
1. по сути в нашем проекте работа с БД и логирование это одно и тоже, собираем строку и записываем в файл.
Можно использовать методы БД для логирования? Это же получится архитектурный паттерн не соблюдается? То есть необходимо писать такие же методы и для логирования?
2. Я пытался сделать вот так
   @Override
   public String toString(String s) {
   return String.format("Идентафикатор: %s" + s + "Имя: %s," + s + "Фамилия: %s," + s + "Телефон: %s", id, firstName, lastName, phone);
   }
чтоб в какой-то момент в строку передавать, в другой раз - разбить по строкам. Но при методе read на экран вывелось notebook.model.User@61bbe9ba. 
Но в методе     
@ Override
   public User __toOutput__(String s) {
   String[] lines = s.split(",");
   long id;
   if (isDigit(lines[0])) {
   id = Long.parseLong(lines[0]);
   return new User(id, lines[1], lines[2], lines[3]);
   }
   throw new NumberFormatException("Id must be a large number");
   } 
нет использования toString. Но мне кажется проблема именно в этом и была.