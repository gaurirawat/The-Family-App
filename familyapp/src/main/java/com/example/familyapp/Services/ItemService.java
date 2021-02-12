package com.example.familyapp.Services;

import com.example.familyapp.Beans.Item;
import com.example.familyapp.Repositories.ChecklistRepository;
import com.example.familyapp.Repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;
    @Autowired
    ChecklistRepository checklistRepository;

    public Item set(int checkListId, String description) {
        Item item = new Item(checklistRepository.getOne(checkListId), description);
        return itemRepository.save(item);
    }

    public void delete(int id) {
        itemRepository.deleteById(id);
    }

    public void markActive(int id) {
        Item current = itemRepository.getOne(id);
        current.setActive(true);
        itemRepository.save(current);
    }

    public void markInactive(int id) {
        Item current = itemRepository.getOne(id);
        current.setActive(false);
        itemRepository.save(current);
    }
}
