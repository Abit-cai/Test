package com.example.demo.activity;

import com.example.demo.pojo.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityService {
    @Autowired
    private ActivityMapper activityMapper;

    public int insertActivity(Activity activity){
        return activityMapper.insertActivity(activity);
    }
    public void deleteActivity(String name) {
        activityMapper.deleteActivity(name);
    }
    public List<Activity>getAllActivity(){
        return activityMapper.getAllActivity();
    }
    public List<Activity> getActivityByLeader(String leader){
        return activityMapper.getActivityByLeader(leader);
    }
}
