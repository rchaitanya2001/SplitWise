package org.example.splitwise.Strategies;

import java.util.List;
import java.util.Map;
import org.example.splitwise.Dtos.Transaction;

public interface SettleUpStrategy {
    List<Transaction> settleUpGroup(Map<Long, Integer> map);
}