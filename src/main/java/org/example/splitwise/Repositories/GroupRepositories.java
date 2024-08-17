package org.example.splitwise.Repositories;

import org.example.splitwise.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepositories extends JpaRepository<Group, Long> {
}