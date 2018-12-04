package com.crazylemon.yantu.controller;


import com.crazylemon.yantu.service.IScenicPhotoService;
import com.crazylemon.yantu.service.IScenicService;
import com.crazylemon.yantu.utils.Parser_Tool;
import com.crazylemon.yantu.utils.ServerResponse;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wangzh
 * @since 2018-10-09
 */
@RestController
@RequestMapping("/yantu/scenic")
public class ScenicController {
    private final IScenicService iScenicService;

    @Autowired
    public ScenicController(IScenicService iScenicService) {
        this.iScenicService = iScenicService;
    }

    @GetMapping("/getScenicList")
    public ServerResponse getScenicList(Integer pageCode){
        return iScenicService.getAll(pageCode);
    }

    @GetMapping("/getScenicListByPage/{pageCode}")
    public ServerResponse getByPage(@PathVariable Integer pageCode) {
        System.out.println("getpage 222" +pageCode);
        return    getScenicList(pageCode);
    }
    @GetMapping("/getScenicDetail/{scenicId}")
    public ServerResponse scenicDetail(@PathVariable Integer scenicId) {
        return iScenicService.getById(scenicId);
    }

    @PostMapping("/getScenicByName")
    public ServerResponse getScenicByName(@RequestBody String keywordJson) throws IOException {
        System.out.println(keywordJson);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(keywordJson);
        JsonNode keyword = rootNode.path("keyword");
        System.out.println(keyword.textValue());
        return iScenicService.getByName(keyword.textValue());
    }
    @PostMapping("/getScenicMap")
    public String getScenicMap(@RequestBody String jsonName) throws ClientProtocolException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(jsonName);
        JsonNode name = rootNode.path("name");
        System.out.println(name.textValue());
        JsonNode city = rootNode.path("city");
        System.out.println(city.textValue());
        String ak = "orsN0xHVa8H0VxcMWW0uGf03";
        String url = "http://api.map.baidu.com/geocoder/v2/?address="+city.textValue()+name.textValue()+"&output=json&ak=" + ak;
        //1.地理编码服务，即根据地址来查经度纬度
        String return_value = Parser_Tool.do_get(url);
        System.out.println(return_value);
        return return_value;
    }

}
