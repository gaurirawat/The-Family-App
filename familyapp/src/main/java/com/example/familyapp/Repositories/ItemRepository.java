package com.example.familyapp.Repositories;

import com.example.familyapp.Beans.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}

