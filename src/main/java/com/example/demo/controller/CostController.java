package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.pojo.ReturnMessage;
import com.example.demo.sign.SignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cost")
public class CostController {
    @Autowired
    private SignService signService;

    @Transactional
    @CrossOrigin
    @RequestMapping(value = "/updateCost", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String updateCostByPname(@RequestBody String JSON_pname){
        ReturnMessage returnMessage = new ReturnMessage();
        JSONObject param = JSONObject.parseObject(JSON_pname);
        String pname = param.getString("pname");
        int cost = param.getInteger("cost");
        try {
            signService.updateCostByPname(pname,cost);
        } catch (Exception e) {
            returnMessage.setExecuteStatus("0");
            returnMessage.setExecuteMsg("很遗憾，追加费用失败！");
            return JSONObject.toJSONString(returnMessage);
        }
        returnMessage.setExecuteStatus("1");
        returnMessage.setExecuteMsg("恭喜你，成功追加费用！");
        return JSONObject.toJSONString(returnMessage);
    }

    @Transactional
    @CrossOrigin
    @RequestMapping(value = "/updateCosted", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String updateCostedByPname(@RequestBody String JSON_pname){
        ReturnMessage returnMessage = new ReturnMessage();
        JSONObject param = JSONObject.parseObject(JSON_pname);
        String pname = param.getString("pname");
        int costed = param.getInteger("costed");
        try {
            signService.updateCostedByPname(pname,costed);
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
