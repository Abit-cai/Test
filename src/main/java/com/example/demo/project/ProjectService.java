package com.example.demo.project;

import com.example.demo.pojo.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    @Autowired
    private ProjectMapper projectMapper;
    public int insertProject(Project project){
        return projectMapper.insertProject(project);
    }
    public List<Project> selectProjectByName(String name){
        return projectMapper.selectProjectByName(name);
    }
    public List<Project> selectProjectByPname(String pname){
        return projectMapper.selectProjectByPname(pname);
    }
    public List<Project> selectPnameTimeByLeader(String leader){
        return projectMapper.selectPnameTimeByLeader(leader);
    }
    public void updateProCostByPname(String pname,int cost){
        projectMapper.updateProCostByPname(pname,cost);
    }
}
