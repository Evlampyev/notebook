package notebook.dao;

import java.util.List;

/**
 * Data Access Object (DAO) слой с методом бд
 * @param <T> тип, подходящий для конвертации E
 */
public interface Operation<T> {
    List<T> readAll();
    void saveAll(List<T> data);
}
