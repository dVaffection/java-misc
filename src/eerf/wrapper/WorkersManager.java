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

    /**
     * Add new task
     *
     * @param id    of a task
     * @param input data
     * @throws WorkersManagerException if task can not be added (no vacant Worker to accept new task)
     * @throws RuntimeException        if found Worker rejects to accept new task
     */
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

    /**
     * Return task status
     *
     * @param id of a task
     * @return State.Status
     * @throws WorkersManagerException if task was not found
     */
    public State.Status getTaskStatus(String id) throws WorkersManagerException {
        Set<String> names = workers.keySet();

        for (String name : names) {
            Worker worker = workers.get(name);
            State.Status status = worker.scan();

            if (status.getId() == id) {
                return status;
            }
        }

        String message = String.format("Task with id \"%s\" was not found", id);
        throw new WorkersManagerException(message);
    }

    /**
     * Remove task from Worker if task state allows to do this
     *
     * @param id of a task
     * @throws WorkersManagerException if task was not found or if task state doesn't allow to be cleaned
     */
    public void removeTask(String id) throws WorkersManagerException {
        Set<String> names = workers.keySet();

        for (String name : names) {
            Worker worker = workers.get(name);
            State.Status status = worker.scan();

            if (status.getId() == id) {
                try {
                    worker.clean();
                } catch (StateException e) {
                    throw new WorkersManagerException(e.getMessage());
                }
                return;
            }
        }

        String message = String.format("Task with id \"%s\" was not found", id);
        throw new WorkersManagerException(message);
    }

}
