__��� ������__
1. �������� � BD � ��������
2. �����������


__�������__
1. �� ���� � ����� ������� ������ � �� � ����������� ��� ���� � ����, �������� ������ � ���������� � ����.
����� ������������ ������ �� ��� �����������? ��� �� ��������� ������������� ������� �� �����������? �� ���� ���������� ������ ����� �� ������ � ��� �����������?
2. � ������� ������� ��� ���
   @Override
   public String toString(String s) {
   return String.format("�������������: %s" + s + "���: %s," + s + "�������: %s," + s + "�������: %s", id, firstName, lastName, phone);
   }
���� � �����-�� ������ � ������ ����������, � ������ ��� - ������� �� �������. �� ��� ������ read �� ����� �������� notebook.model.User@61bbe9ba. 
�� � ������     
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
��� ������������� toString. �� ��� ������� �������� ������ � ���� � ����.