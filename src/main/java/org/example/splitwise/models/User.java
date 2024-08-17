package org.example.splitwise.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name="user_splitwise")
public class User extends BaseModel {
    private String name;
    private String email;
    private String password;
}