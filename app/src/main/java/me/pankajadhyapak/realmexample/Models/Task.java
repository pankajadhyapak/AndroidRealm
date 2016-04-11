package me.pankajadhyapak.realmexample.Models;

import io.realm.RealmObject;
import io.realm.annotations.Required;

/**
 * Created by pankaj on 11/04/16.
 */
public class Task extends RealmObject {

    @Required
    private String name;

    @Required
    private Boolean completed;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}
