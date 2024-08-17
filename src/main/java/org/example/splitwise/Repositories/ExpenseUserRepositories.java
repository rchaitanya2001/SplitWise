package org.example.splitwise.Repositories;

import org.example.splitwise.models.ExpenseUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseUserRepositories extends JpaRepository<ExpenseUser, Long> {
}