package pl.com.sebastianbodzak.library.domain;

/**
 * Created by Dell on 2016-10-11.
 */
public interface WorkerRepository {

    void save(Worker worker);
    boolean isLoginOccupied(String login);
}
