package org.socialNetwork.models;

import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.Size;

public class User {
    private Long id;

    @NotBlank (message = "Name is required")
    @Size(min=2, max = 20, message = "Name should be from 2 to 20 symbols")
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
