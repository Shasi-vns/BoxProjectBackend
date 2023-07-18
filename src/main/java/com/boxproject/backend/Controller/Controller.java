package com.boxproject.backend.Controller;

import com.boxproject.backend.Entities.Activity;
import com.boxproject.backend.Entities.Slots;
import com.boxproject.backend.Repos.ActivityRepository;
import com.boxproject.backend.Repos.SlotsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    private ActivityRepository activityRepo;
    @Autowired
    private SlotsRepository slotsRepository;

    @GetMapping("/getactivities")
    public List<Activity> findallActivity(){
        return activityRepo.findAll();
    }
    @GetMapping("/getslots")
    public List<Slots> findallTimeSlot(){
        return slotsRepository.findAll();
    }

    @GetMapping("/getactivitiesbycity/{cityname}")
    public List<Activity> findactivitiesByCityName(@PathVariable String cityname){
        return activityRepo.findByNameContaining(cityname);
    }

    @PostMapping("/post")
    public Activity saveActivity(@RequestBody Activity acti){
        return activityRepo.save(acti);

    }


}
