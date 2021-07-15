package com.example.demo.sign;

import com.example.demo.pojo.Sign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SignService {
    @Autowired
    private SignMapper signMapper;
    
	public int insert(Sign sign){//报名
		return signMapper.insert(sign);
	}
	public List<Sign> selectByUname(String username){
		return signMapper.selectByUname(username);
	}
	public List<Sign> selectByPname(String pname){
		return signMapper.selectByPname(pname);
	}
	public void updateEndedByPname(String pname){//活动情况改变
		signMapper.updateEndedByPname(pname);
	}
	public int selectEndedByPname(String pname){
		return signMapper.selectEndedByPname(pname);
	}
	public void updateCostByPname(String pname,int cost){//追加
		signMapper.updateCostByPname(pname,cost);
	}
	public void updateCostedByPname(String pname,int costed){//缴费
		signMapper.updateCostedByPname(pname,costed);
	}
}
