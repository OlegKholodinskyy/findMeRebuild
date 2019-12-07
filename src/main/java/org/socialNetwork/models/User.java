package org.socialNetwork.models;

/**
 * Created by oleg on 01.12.2019.
 */
public class User {
    private Long id;
    private String firstName;

    public User() {
    }

    public User(Long id, String firstName) {
        this.id = id;
        this.firstName = firstName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
