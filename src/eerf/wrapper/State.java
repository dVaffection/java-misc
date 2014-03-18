package eerf.wrapper;

interface State {

    /**
     * @return current state output
     * @throws StateException if the current state does not support the operation
     */
    Status output() throws StateException;

    /**
     * Clear previous task output data
     *
     * @throws StateException if the current state does not support the operation
     */
    void clear() throws StateException;

    /**
     * Execute a new task feeding it with the provided input data
     *
     * @param id
     * @param input
     * @throws StateException if the current state does not support the operation
     */
    void exec(String id, String input) throws StateException;

    enum StatusName {
        IDLE,
        BUSY,
        OUTPUT,
        TERMINATED,
    }

    class Status {

        private StatusName name;
        private String id;
        private String output;

        Status(StatusName name, String id) {
            this(name, id, null);
        }

        Status(StatusName name, String id, String output) {
            this.name = name;
            this.id = id;
            this.output = output;
        }

        public StatusName getName() {
            return name;
        }

        public String getId() {
            return id;
        }

        public String getOutput() {
            return output;
        }
    }

}
