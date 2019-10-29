package com.heeexy.example.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.dao.MenuMapper;
import com.heeexy.example.entity.Menu;
import com.heeexy.example.service.MenuService;
import com.heeexy.example.util.CommonUtil;
import com.heeexy.example.util.model.MenuModel;
import com.heeexy.example.util.model.MomentEnum;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/menu")
public class MenuCotroller {
    @Autowired
    public MenuService menuService;

    @Autowired
    public MenuMapper menuMapper;

    @RequestMapping( value = "/add",method = RequestMethod.POST, produces = "application/json;charset=utf-8" )
    @RequiresPermissions("user:list")
    public JSONObject addMenu(@RequestBody String testForm) throws IOException {
        JSONArray js = JSON.parseArray(testForm);
        List<MenuModel> lists = new ArrayList<>() ;
        for (int i = 0; i < js.size(); i++) {
            MenuModel menuModel = JSON.toJavaObject(js.getJSONObject(i), MenuModel.class);
            lists.add(menuModel);
        }
        lists.stream().forEach(x ->{
            Menu menuM = Menu.builder()
                    .createTime(new Date())
                    .menuData(JSONObject.toJSONString(x.getMorning()))
                    .moment(MomentEnum.MORNING)
                    .time(x.getKey())
                    .build();
            Menu menuN = Menu.builder()
                    .createTime(new Date())
                    .menuData(JSONObject.toJSONString(x.getNooning()))
                    .moment(MomentEnum.NOONING)
                    .time(x.getKey())
                    .build();
            Menu menuNight = Menu.builder()
                    .createTime(new Date())
                    .menuData(JSONObject.toJSONString(x.getNight()))
                    .moment(MomentEnum.NIGHT)
                    .time(x.getKey())
                    .build();
            menuMapper.insert(menuM);
            menuMapper.insert(menuN);
            menuMapper.insert(menuNight);
        } );
        return CommonUtil.successJson();
    }
}
