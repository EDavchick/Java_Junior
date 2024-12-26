package org.dav.less03.task2;

import java.io.Serializable;

public class ToDoV1 implements Serializable {
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

    public ToDoV1(){
    }

    public ToDoV1(String title) {
        this.title = title;
        isDone = false;
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
