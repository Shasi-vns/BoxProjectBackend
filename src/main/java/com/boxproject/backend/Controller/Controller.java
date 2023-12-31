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
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class Controller {
    @Autowired
    private ActivityService activityService;
    @Autowired
    private SlotsService slotsService;

    @GetMapping("/getactivities")
    public ResponseEntity<List<Activity>> findallActivity(){
        List<Activity> activityList=activityService.getall();
        return new ResponseEntity<>(activityList,HttpStatus.OK);
    }

    @GetMapping("/getactivity/{id}")
    public ResponseEntity<Optional<Activity>> findactivityById(@PathVariable Integer id) throws ActivityNotFoundException {
        Optional<Activity> activity=activityService.getBYId(id);
        return new ResponseEntity<>(activity,HttpStatus.OK);
    }

    @GetMapping("/getslots")
    public ResponseEntity<List<Slots>> findallTimeSlot(){
        List<Slots> slotsList = slotsService.findallslots();
        return new ResponseEntity<>(slotsList,HttpStatus.OK);
    }

    @GetMapping("/getcities")
    public ResponseEntity<List<String>> findallcities(){
        List<String> listofCities = activityService.getallcities();
        return new ResponseEntity<>(listofCities,HttpStatus.OK);
    }

    @GetMapping("/activitiesincity/{cityname}") //this method return only activity name in a city
    public ResponseEntity<List<String>> findallactivitiesincity(@PathVariable String cityname) throws ActivityNotFoundException{
        List<String> activitiesinCity = activityService.getallactivitiesinCity(cityname);
        return new ResponseEntity<>(activitiesinCity,HttpStatus.OK);
    }
 
    @GetMapping("/getactivitiesbycity/{cityname}") //this method return entire activity in a city
    public ResponseEntity<List<Activity>> findactivitiesByCityName(@PathVariable String cityname) throws ActivityNotFoundException {
        List<Activity> activityList = activityService.findBycityname(cityname);
        return new ResponseEntity<>(activityList,HttpStatus.OK);
    }
    @PostMapping("/post")
    public ResponseEntity<Activity> saveActivity(@RequestBody @Valid ActivityRequest acti){
        Activity activity = activityService.saveActivity(acti);
        return new ResponseEntity<>(activity,HttpStatus.OK);

//                  INput be like in post man
//        {
//                "activity_name": "cricket",                               //not null
//                "activity_city": "Hyderabad",                             //not null
//                "activity_address": "opp paradise secundrabad",           //not null
//                "activity_state": "Telangana",                               //not null
//                "activity_price": 350,                                    //min 150 to max 400
//                "activity_rating": 4,                                     //min 1 to max 5
//                "activity_owner_name": "Sreenath",                        //not null
//                "activity_ownwer_mobile": 8142872949,                        //not null
//                "activity_owner_address": "11/7g tolichowki hyderabad",       //not null
//                "slots": [                                                    //no validations
//            {
//                "slot_time": "10 AM",
//                    "slot_status_Available_Today":"no",
//                    "slot_status_Available_Tomorrow":"no"
//            },
//            {
//                "slot_time": "12 PM",
//                    "slot_status_Available_Today":"yes",
//                    "slot_status_Available_Tomorrow":"yes"
//            },
//            {
//                "slot_time": "2 PM",
//                    "slot_status_Available_Today":"yes",
//                    "slot_status_Available_Tomorrow":"yes"
//            },
//            {
//                "slot_time": "4 PM",
//                    "slot_status_Available_Today":"no",
//                    "slot_status_Available_Tomorrow":"no"
//            }
//  ]
//        }
    }


    @PostMapping("/edit")
    public ResponseEntity<Activity> editActivity(@RequestBody Activity activity) throws ActivityNotFoundException{
        Activity act = activityService.editActivity(activity);
        return new ResponseEntity<>(activity,HttpStatus.OK);
    }

    @DeleteMapping("/deleteActivity/{id}")
        public ResponseEntity<String> deleteActivtiy(@PathVariable Integer id) throws ActivityNotFoundException{
            String message = activityService.deleteActivityById(id);
            return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
