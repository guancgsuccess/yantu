package com.crazylemon.yantu.ui;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.crazylemon.yantu.entity.OrderMaster;
import com.crazylemon.yantu.service.impl.OrderMasterServiceImpl;
import com.crazylemon.yantu.service.impl.VisitorServiceImpl;
import com.crazylemon.yantu.vo.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UIController {

    @RequestMapping("/index")
    public String index(){
        return "searchBox";
    }
    @RequestMapping("/")
    public String index1(){
        return "searchBox";
    }
    @RequestMapping("/modifyPassword")
    public String modifyPassword(){
        return "modifyPassword";
    }
    @RequestMapping("/perfectInformation")
    public String perfectInformation(){
        return "perfectInformation";
    }
    @RequestMapping("/modifyInformation")
    public String modifyInformation(){
        return "modifyInformation";
    }
    @RequestMapping("/modifyCellphone")
    public String modifyCellphone(){
        return "modifyCellphone";
    }
    @RequestMapping("/modifyMail")
    public String modifyMail(){
        return "modifyMail";
    }
    @RequestMapping("/forgetPassword")
    public String forgetPassword(){
        return "forgetPassword";
    }
    @RequestMapping("/queryPlanList")
    public String queryPlanList(){
        return "queryPlanList";
    }
    @RequestMapping("/planDetail/{id}")
    public String planDetail(@PathVariable Integer id){
        return "planDetail";
    }
    @RequestMapping("/queryScenicList")
    public String queryScenicList(){
        return "queryScenicList";
    }
    @RequestMapping("/scenicDetail/{id}")
    public String scenicDetail(@PathVariable Integer id){
        return "scenicDetail";
    }
    @RequestMapping("/saveTourist")
    public String saveTourist(){
        return "saveTourist";
    }
    @RequestMapping("/getGuiderList")
    public String getGuiderList(){
        return "getGuiderList";
    }
    @RequestMapping("/privateCustom")
    public String privateCustom(){
        return "privateCustom";
    }
    @RequestMapping("/orderManager")
    public String orderManage(){
        return "orderManager";
    }
    @RequestMapping("/orderDetailManager")
    public String orderDetailManager(){
        return "orderDetailManager";
    }
    @RequestMapping("/orderpay")
    public String orderPay(){
        return "orderPay";
    }
    @RequestMapping("/qiniuImg")
    public String qiniuImg(){
        return "qiniuImg";
    }
    @RequestMapping("/payOrder")
    public String payOrder(){
        return "payOrder";
    }
    @RequestMapping("/score")
    public String score(){
        return "score";
    }

    @RequestMapping("/getScoreGrade")
    public String getScoreGrade(){
        return "getScoreGrade";
    }
}
