package notebook.view;

import notebook.controller.UserController;
import notebook.model.User;
import notebook.util.Commands;


import java.util.Scanner;

import static notebook.log.log.writeLog;

public class UserView {
    private final UserController userController;

    public UserView(UserController userController) {
        this.userController = userController;
    }

    public void run() {
        Commands com;

        while (true) {
            String command = prompt("Введите команду: ");
            com = Commands.valueOf(command);
            if (com == Commands.EXIT) return;
            switch (com) {
                case CREATE:
                    User u = createUser();
                    userController.saveUser(u);
                    writeLog(com.toString() + " " + u.toString());
                    break;
                case READ:
                    String id = prompt("Идентификатор пользователя: ");
                    try {
                        User user = userController.readUser(Long.parseLong(id));
                        writeLog(com.toString());
                        System.out.println(user);
                        System.out.println();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case HELP:
                    System.out.println(java.util.Arrays.asList(Commands.values()));
                    writeLog(com.toString() + " HELP");
                    break;
                case DELETE:
                    String del_id = prompt("Идентификатор пользователя: ");
                    Boolean rezultDelete = userController.deleteUser(Long.parseLong(del_id));
                    writeLog(com.toString() + " " + del_id + " " + rezultDelete);
                    if (rezultDelete) {
                        System.out.printf("User", del_id, "deleted");
                    }
                    break;
                case UPDATE:
                    String userId = prompt("Идентификатор пользователя: ");
                    User up = createUser();
                    writeLog(com.toString() + " " + up.toString());
                    userController.updateUser(userId, up);
                    break;
                default:
                    System.out.println("You can use only next command:");
                    System.out.println(java.util.Arrays.asList(Commands.values()));
                    break;
            }
        }
    }

    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }

    private User createUser() {
        String firstName = prompt("Имя: ");
        String lastName = prompt("Фамилия: ");
        String phone = prompt("Номер телефона: ");
        return new User(firstName, lastName, phone);
    }
}
