package org.example.splitwise.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name="group_splitwise")
public class Group extends BaseModel {
    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "group", cascade = CascadeType.ALL)
    private List <Expense> expenses;
    @ManyToOne
    private User createdBy;
}