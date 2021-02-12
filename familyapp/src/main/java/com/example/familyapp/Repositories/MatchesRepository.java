package com.example.familyapp.Repositories;

import com.example.familyapp.Beans.Matches;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchesRepository extends JpaRepository<Matches, Integer> {
}

