package org.example.splitwise.models;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity
public class Expense extends BaseModel {
    private String description;
    private int amount;

    @ManyToOne
    private User createdBy;

    @Enumerated(EnumType.ORDINAL)
    private ExpenseType expenseType;

    @ManyToOne
    private Group group;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "expense", cascade = CascadeType.ALL)
    List<ExpenseUser> expenseUsers;
}