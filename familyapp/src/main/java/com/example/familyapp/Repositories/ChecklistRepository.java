package com.example.familyapp.Repositories;

import com.example.familyapp.Beans.Checklist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChecklistRepository extends JpaRepository<Checklist, Integer> {
}

