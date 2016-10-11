package pl.com.sebastianbodzak.library.api;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.com.sebastianbodzak.library.domain.Worker;
import pl.com.sebastianbodzak.library.domain.WorkerRepository;

/**
 * Created by Dell on 2016-10-11.
 */
@Service
public class WorkerManager {

    private WorkerRepository workerRepository;

    public WorkerManager(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    @Transactional
    public void addWorker(String login, String password, String profession) {
        workerRepository.save(new Worker(null, profession, login, password));
    }
}
