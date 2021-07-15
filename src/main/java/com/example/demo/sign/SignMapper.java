package com.example.demo.sign;

import com.example.demo.pojo.Sign;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SignMapper {
	int insert(Sign sign);//报名
    List<Sign> selectByUname(String username);
    List<Sign> selectByPname(String pname);
    void updateEndedByPname(String pname);//活动情况改变
    int selectEndedByPname(String pname);
    void updateCostByPname(String pname,int cost);//追加
    void updateCostedByPname(String pname,int costed);//缴费
}