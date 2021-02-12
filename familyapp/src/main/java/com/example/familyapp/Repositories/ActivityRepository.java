package com.example.familyapp.Repositories;

import com.example.familyapp.Beans.Activity;
import com.example.familyapp.Utils.Enums.ActivityTypeEnum;
import com.example.familyapp.Utils.Enums.CategoryEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Integer>{
    public List<Activity> getByCategoryAndDateAndType(CategoryEnum categoryEnum, Date date, ActivityTypeEnum type);
}
