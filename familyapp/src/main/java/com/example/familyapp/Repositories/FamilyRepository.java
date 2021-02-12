package com.example.familyapp.Repositories;

import com.example.familyapp.Beans.Family;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FamilyRepository extends JpaRepository<Family, Integer> {
}

