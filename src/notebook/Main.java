package notebook;

import notebook.controller.UserController;
import notebook.dao.impl.FileOperation;
import notebook.repository.GBRepository;
import notebook.repository.impl.UserRepository;
import notebook.view.UserView;

import static notebook.util.DBConnector.DB_PATH;
import static notebook.util.DBConnector.createDB;
import static notebook.log.log.createLog;

public class Main {
    public static void main(String[] args) {
        createDB();
        createLog();
        FileOperation fileOperation = new FileOperation(DB_PATH);
        GBRepository repository = new UserRepository(fileOperation);
        UserController controller = new UserController(repository);
        UserView view = new UserView(controller);
        view.run();
    }
}
