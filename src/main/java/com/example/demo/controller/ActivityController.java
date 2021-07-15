package com.example.demo.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.pojo.Activity;
import com.example.demo.activity.ActivityService;
import com.example.demo.pojo.ReturnMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("activity")
public class ActivityController {
    @Autowired
    private ActivityService activityService;

    @Transactional
    @CrossOrigin
    @RequestMapping(value="/saveActivity",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String saveActivity(@RequestBody Activity activity){
        ReturnMessage returnMessage=new ReturnMessage();
        try {
            activityService.insertActivity(activity);
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
    @RequestMapping(value = "/deleteActivity", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String deleteActivity(@RequestBody String JSON_name){
        //一样的 需要转化为json再获取name
        ReturnMessage returnMessage=new ReturnMessage();
        JSONObject param = JSONObject.parseObject(JSON_name);
        String name = param.getString("name");
        try {
            activityService.deleteActivity(name);
        }catch (Exception e) {

            returnMessage.setExecuteStatus("0");
            returnMessage.setExecuteMsg("很遗憾，活动未删除！");
            return JSONObject.toJSONString(returnMessage);
        }
        returnMessage.setExecuteStatus("1");
        returnMessage.setExecuteMsg("恭喜你，成功删除活动！");
        return JSONObject.toJSONString(returnMessage);
    }

    @Transactional
    @CrossOrigin
    @RequestMapping(value = "/selectActivity", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String selectAllActivity(){
        //这个函数是因为没有返回值 因为你是void
        List<Activity> activityList = activityService.getAllActivity();
        JSONArray jsonArray = new JSONArray();
        JSONObject result = new JSONObject();
        for (int i=0;i<activityList.size();i++) {
            JSONObject obj = new JSONObject();
            obj.put("name", activityList.get(i).getName());
            obj.put("start", activityList.get(i).getStart());
            obj.put("end",activityList.get(i).getEnd());
            jsonArray.add(obj);
        }
        result.put("msg",jsonArray);
        //System.out.println(result);
        return result.toJSONString();
    }

    @Transactional
    @CrossOrigin
    @RequestMapping(value = "/getActivity", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getActivity(@RequestBody String JSON_name){
        //你传过去的是json 而不是String 你需要转化为json再获取name
        JSONObject param = JSONObject.parseObject(JSON_name);
        String name = param.getString("name");
        List<Activity> activityList = activityService.getActivityByName(name);
        JSONObject result = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        for (int i=0;i<activityList.size();i++) {
            JSONObject obj = new JSONObject();
            obj.put("name", activityList.get(i).getName());
            obj.put("start", activityList.get(i).getStart());
            obj.put("end",activityList.get(i).getEnd());
            jsonArray.add(obj);
        }
        result.put("msg",jsonArray);
        //System.out.println(jsonArray);
        return result.toJSONString();
    }
}
