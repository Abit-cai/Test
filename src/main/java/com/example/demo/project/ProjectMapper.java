package com.example.demo.project;

import com.example.demo.pojo.Project;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProjectMapper {
    int insertProject(Project project);
    List<Project> selectProjectByName(String name);
    List<Project> selectProjectByPname(String pname);
    List<Project> selectPnameTimeByLeader(String leader);
    void  updateProCostByPname(String pname,int cost);
}
