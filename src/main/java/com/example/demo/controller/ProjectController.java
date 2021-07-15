package com.example.demo.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.pojo.ReturnMessage;
import com.example.demo.pojo.Project;
import com.example.demo.project.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @Transactional
    @CrossOrigin
    @RequestMapping(value = "/saveProject", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String saveProject(@RequestBody Project project) {
        ReturnMessage returnMessage = new ReturnMessage();
        try {
            projectService.insertProject(project);
        } catch (Exception e) {
            returnMessage.setExecuteStatus("0");
            returnMessage.setExecuteMsg("很遗憾，创建活动失败！");
            return JSONObject.toJSONString(returnMessage);
        }
        returnMessage.setExecuteStatus("1");
        returnMessage.setExecuteMsg("恭喜你，成功创建活动！");
        return JSONObject.toJSONString(returnMessage);
    }

    @Transactional
    @CrossOrigin
    @RequestMapping(value = "/selectProject", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String selectProjectByName(@RequestBody String JSON_name){
        JSONObject param = JSONObject.parseObject(JSON_name);
        String name = param.getString("name");
        List<Project> projectList = projectService.selectProjectByName(name);
        JSONObject result = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        for (int i=0;i<projectList.size();i++) {
            JSONObject obj = new JSONObject();
            obj.put("name", projectList.get(i).getName());
            obj.put("pname", projectList.get(i).getPname());
            obj.put("time", projectList.get(i).getTime());
            obj.put("site",projectList.get(i).getSite());
            jsonArray.add(obj);
        }
        result.put("msg",jsonArray);
        //System.out.println(jsonArray);
        return result.toJSONString();
    }

    @Transactional
    @CrossOrigin
    @RequestMapping(value = "/selectPnameTime", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String selectPnameTimeByLeader(@RequestBody String JSON_leader){
        JSONObject param = JSONObject.parseObject(JSON_leader);
        String leader = param.getString("leader");
        List<Project> projectList = projectService.selectPnameTimeByLeader(leader);
        JSONObject result = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        for (int i=0;i<projectList.size();i++) {
            JSONObject obj = new JSONObject();
            obj.put("pname", projectList.get(i).getPname());
            obj.put("time", projectList.get(i).getTime());
            jsonArray.add(obj);
        }
        result.put("msg",jsonArray);
        //System.out.println(jsonArray);
        return result.toJSONString();
    }

    @Transactional
    @CrossOrigin
    @RequestMapping(value = "/updateProCost", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String updateProCostByPname(@RequestBody String JSON_pname){
        ReturnMessage returnMessage = new ReturnMessage();
        JSONObject param = JSONObject.parseObject(JSON_pname);
        String pname = param.getString("pname");
        int cost = param.getInteger("cost");
        try {
            projectService.updateProCostByPname(pname,cost);
        } catch (Exception e) {
            returnMessage.setExecuteStatus("0");
            returnMessage.setExecuteMsg("很遗憾，追加费用失败！");
            return JSONObject.toJSONString(returnMessage);
        }
        returnMessage.setExecuteStatus("1");
        returnMessage.setExecuteMsg("恭喜你，成功追加费用！");
        return JSONObject.toJSONString(returnMessage);
    }
}
