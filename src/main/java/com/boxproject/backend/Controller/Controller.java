package com.boxproject.backend.Controller;

import com.boxproject.backend.Entities.Activity;
import com.boxproject.backend.Entities.ActivityRequest;
import com.boxproject.backend.Entities.Slots;
import com.boxproject.backend.Exceptions.ActivityNotFoundException;
import com.boxproject.backend.Repos.ActivityRepository;
import com.boxproject.backend.Repos.SlotsRepository;
import com.boxproject.backend.Services.ActivityService;
import com.boxproject.backend.Services.SlotsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    private ActivityService activityService;
    @Autowired
    private SlotsService slotsService;

    @GetMapping("/getactivities")
    public List<Activity> findallActivity(){
        return activityService.getall();
    }

    @GetMapping("/getactivity/{id}")
    public Activity findactivityById(@PathVariable Integer id) throws ActivityNotFoundException {

        return activityService.getBYId(id);
    }

    @GetMapping("/getslots")
    public List<Slots> findallTimeSlot(){
        return slotsService.findallslots();
    }

    @GetMapping("/getactivitiesbycity/{cityname}")
    public List<Activity> findactivitiesByCityName(@PathVariable String cityname) throws ActivityNotFoundException {
        return activityService.findBycityname(cityname);
    }
    @PostMapping("/post")
    public Activity saveActivity(@RequestBody @Valid ActivityRequest acti){

        return activityService.saveActivity(acti);
    }

}
