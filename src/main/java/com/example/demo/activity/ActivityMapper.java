package com.example.demo.activity;

import com.example.demo.pojo.Activity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ActivityMapper {
    public int insertActivity(Activity activity);
    public void deleteActivity(String name);
    public List<Activity> getAllActivity();
    public List<Activity> getActivityByLeader(String leader);
}
