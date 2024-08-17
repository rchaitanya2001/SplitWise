package org.example.splitwise.Strategies;

import org.example.splitwise.Dtos.Transaction;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
class Pair implements Comparable<Pair>{
    Integer amount;
    Long userId;

    public Pair(int amount, Long userId) {
        this.amount = amount;
        this.userId = userId;
    }

    @Override
    public int compareTo(Pair o) {
        if(this.amount <= o.amount){
            return -1;
        }
        return 1;
    }
}
@Component
public class HeapSettleUpStrategy implements SettleUpStrategy {
    @Override
    public List<Transaction> settleUpGroup(Map<Long, Integer> map) {

        PriorityQueue<Pair> giver = new PriorityQueue<Pair>();
        PriorityQueue<Pair> receiver = new PriorityQueue<Pair>();

        for(Long userId : map.keySet()){
            Integer amount = map.get(userId);
            if(amount > 0){
                receiver.add(new Pair(amount, userId));
            }else{
                giver.add(new Pair(-1*amount, userId));
            }
        }

        List<Transaction> transactions = new ArrayList<>();
        while(giver.size() > 0 && receiver.size() > 0){
            Pair maxReceive = receiver.poll();
            Pair maxGive = giver.poll();


            if(maxReceive.amount > maxGive.amount){
                transactions.add(new Transaction(maxGive.userId, maxReceive.userId, maxGive.amount));
                receiver.add(new Pair(maxReceive.amount-maxGive.amount, maxReceive.userId));
            }else if(maxReceive.amount < maxGive.amount){
                transactions.add(new Transaction(maxGive.userId, maxReceive.userId, maxReceive.amount));
                giver.add(new Pair(maxGive.amount -maxReceive.amount, maxGive.userId));
            }else{
                transactions.add(new Transaction(maxGive.userId, maxReceive.userId, maxReceive.amount));
            }
        }
        System.out.println("Checkougn");
        return transactions;
    }
}