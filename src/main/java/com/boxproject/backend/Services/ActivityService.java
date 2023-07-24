package com.boxproject.backend.Services;

import com.boxproject.backend.Entities.Activity;
import com.boxproject.backend.Entities.ActivityRequest;
import com.boxproject.backend.Exceptions.ActivityNotFoundException;
import com.boxproject.backend.Repos.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityService {
    @Autowired
    private ActivityRepository activityRepository;

    public List<Activity> getall(){
        return activityRepository.findAll();
    }

    public Activity getBYId(Integer id) throws ActivityNotFoundException {
        Activity activity = activityRepository.findByActivity_id(id);
        if (activity!=null) return activity;
        else{
            throw new ActivityNotFoundException("activity not found with id : "+id);
        }
    }

    public List<Activity> findBycityname(String cityname) throws ActivityNotFoundException {
        List<Activity> activityList = activityRepository.findByNameContaining(cityname);
        if(activityList.size()!=0) return activityList;
        else{
            throw new ActivityNotFoundException("activity not found with city : "+cityname);
        }
    }

    public Activity saveActivity(ActivityRequest actReq){
        Activity activity = Activity.build(0,actReq.getActivity_name(),actReq.getActivity_city(),
                actReq.getActivity_address(),actReq.getActivity_state(),actReq.getActivity_price(),
                actReq.getActivity_rating(),actReq.getActivity_owner_name(),actReq.getActivity_ownwer_mobile(),
                actReq.getActivity_owner_address(),actReq.getSlots());
        return activityRepository.save(activity);
    }
}
