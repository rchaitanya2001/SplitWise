package org.example.splitwise.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class UserGroup extends BaseModel {
    @ManyToOne
    private User user;
    @ManyToOne
    private Group group;
}