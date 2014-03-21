package eerf.wrapper;

import java.util.HashMap;
import java.util.Set;

public class WorkersManager {

    HashMap<String, Worker> workers;

    WorkersManager() {
        workers = new HashMap<>();
    }

    public void addWorker(String name, Worker worker) {
        workers.put(name, worker);
    }

    public boolean removeWorker(String name) {
        Worker worker = workers.get(name);

        if (!(worker instanceof Worker)) {
            String message = String.format("Worker \"%s\" was not found", name);
            throw new RuntimeException(message);
        }

        State.Status status = worker.scan();
        if (status.getName() == State.StatusName.IDLE) {
            workers.remove(name);
            return true;
        } else {
            return false;
        }
    }

    public void addTask(String id, String input) throws WorkersManagerException {
        Worker worker = findIdleWorker();

        if (!(worker instanceof Worker)) {
            throw new WorkersManagerException("Can not add task, no idle worker found");
        }

        try {
            worker.exec(id, input);
        } catch (StateException e) {
            State.Status status = worker.scan();
            String statusName = status.getName().toString();
            String message = "Apparently worker is not IDLE anymore, that's weird. Current worker status: " + statusName;
            throw new RuntimeException(message);
        }
    }

    private Worker findIdleWorker() {
        Set<String> names = workers.keySet();

        for (String name : names) {
            Worker worker = workers.get(name);
            State.Status status = worker.scan();

            if (status.getName() == State.StatusName.IDLE) {
                return worker;
            }
        }

        return null;
    }

}
