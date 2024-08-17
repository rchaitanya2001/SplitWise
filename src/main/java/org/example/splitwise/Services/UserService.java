package org.example.splitwise.Services;


import org.example.splitwise.Repositories.GroupRepositories;
import org.example.splitwise.Strategies.HeapSettleUpStrategy;
import org.example.splitwise.models.Expense;
import org.example.splitwise.models.ExpenseUser;
import org.example.splitwise.models.ExpenseUserType;
import org.example.splitwise.models.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.splitwise.Dtos.Transaction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private GroupRepositories groupRepositories;
    @Autowired
    private HeapSettleUpStrategy settleUpStrategy;

    public List<Transaction> settleUser(Long userId){
        //We get user
        // We userExpenses of this user - PAID/ HAD_TO_PAY
        // userExpenses fetch all expense user is part of
        //Get all user expenses from expenses list
        //Balance Map
        //Heap settle up logic
        return null;
    }

    public List<Transaction> settleUpGroup(Long groupId) {
        //We get group
        //Get all expense of the group
        //Get all userExpense of each expense
        //Balance Map ()

        Optional<Group> groupOpt = groupRepositories.findById(groupId);

        if(groupOpt.isEmpty()){
            System.out.println("Throw an group empty error");
            return null;
        }

        Group group = groupOpt.get();


        //If EAGER fetch was not there, then had to fetch expense
        //like this: expenseRepo.findByGroup(groupId)
        List<Expense> expenseList = group.getExpenses();

        Map<Long, Integer> balanceMap = new HashMap<Long, Integer>();

        for(Expense expense :  expenseList){

            List<ExpenseUser> expenseUserList = expense.getExpenseUsers();

            for(ExpenseUser expenseUser : expenseUserList){

                Long userId = expenseUser.getUser().getId();
                balanceMap.putIfAbsent(userId, 0);

                if(expenseUser.getExpenseUserType().equals(ExpenseUserType.PAID)){
                    balanceMap.put(userId, balanceMap.get(userId) + expenseUser.getAmount());
                }else{
                    balanceMap.put(userId, balanceMap.get(userId) - expenseUser.getAmount());
                }

            }

            List<Transaction> transactionList = settleUpStrategy.settleUpGroup(balanceMap);
            return transactionList;
        }

        return null;
    }
}