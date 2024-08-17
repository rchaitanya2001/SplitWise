package org.example.splitwise.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Getter
@AllArgsConstructor
public class Transaction {
    Long fromUserId;
    Long toUserId;
    Integer amount;
}