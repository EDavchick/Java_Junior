package org.dav.less03.task2;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class ToDo implements Externalizable {

    // region Fields

    /**
     * Task name
     */
    private String title;
    /**
     * Task status
     */
    private boolean isDone;
    // endregion

    //region Constructors

    public ToDo(){
    }

    public ToDo(String title) {
        this.title = title;
        isDone = false;
    }
    // endregion

    // region Externalizable implementation
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(title);
        out.writeBoolean(isDone);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        title = (String) in.readObject();
        isDone = in.readBoolean();
    }
    // endregion

    // region Methods

    /**
     * Get name of task
     * @return name of task
     */
    public String getTitle() {
        return title;
    }

    /**
     * Get the status of tasks
     * @return task progress status
     */
    public boolean isDone() {
        return isDone;
    }

    /**
     * Change the status of tasks
     * @param done new the status of task
     */
    public void setDone(boolean done) {
        isDone = done;
    }
    // endregion
}
