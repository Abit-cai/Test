package com.example.demo.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.pojo.ReturnMessage;
import com.example.demo.pojo.Sign;
import com.example.demo.sign.SignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("sign")
public class SignController {
    @Autowired
    private SignService signService;
    //private CostService costService;

    @Transactional
    @CrossOrigin
    @RequestMapping(value = "/saveSign", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String saveSign(@RequestBody Sign sign) {
        ReturnMessage returnMessage = new ReturnMessage();
        try {
            signService.insert(sign);
            //costService.insertCost();
        } catch (Exception e) {
            returnMessage.setExecuteStatus("0");
            returnMessage.setExecuteMsg("很遗憾，报名失败！");
            return JSONObject.toJSONString(returnMessage);
        }
        returnMessage.setExecuteStatus("1");
        returnMessage.setExecuteMsg("恭喜你，成功报名！");
        return JSONObject.toJSONString(returnMessage);
    }

    @Transactional
    @CrossOrigin
    @RequestMapping(value = "/selectSign", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String selectSignByUname(@RequestBody String JSON_username){
        JSONObject param = JSONObject.parseObject(JSON_username);
        String username = param.getString("username");
        List<Sign> signList = signService.selectByUname(username);
        JSONObject result = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        for (int i=0;i<signList.size();i++) {
            JSONObject obj = new JSONObject();
            obj.put("username", signList.get(i).getUsername());
            obj.put("aname", signList.get(i).getAname());
            obj.put("pname", signList.get(i).getPname());
            obj.put("cost", signList.get(i).getCost());
            obj.put("costed", signList.get(i).getCosted());
            obj.put("ended", signList.get(i).getEnded());
            jsonArray.add(obj);
        }
        result.put("msg",jsonArray);
        //System.out.println(jsonArray);
        return result.toJSONString();
    }

    @Transactional
    @CrossOrigin
    @RequestMapping(value = "/updateEnded", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String updateEndedByPname(@RequestBody String JSON_pname){
        ReturnMessage returnMessage = new ReturnMessage();
        JSONObject param = JSONObject.parseObject(JSON_pname);
        String pname = param.getString("pname");
        signService.updateEndedByPname(pname);
        int x=signService.selectEndedByPname(pname);
        if (x==0) {
            returnMessage.setExecuteMsg("很遗憾，活动状态未更新！");
        }
        if(x==1){
            returnMessage.setExecuteMsg("恭喜你，成功更新活动状态！");
        }
        else{
            returnMessage.setExecuteMsg("糟糕，更新成乱七八糟的东西了！");
        }
        return JSONObject.toJSONString(returnMessage);
    }
}
