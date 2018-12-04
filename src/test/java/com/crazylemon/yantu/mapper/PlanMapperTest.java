package com.crazylemon.yantu.mapper;

import com.crazylemon.yantu.entity.Plan;
import com.crazylemon.yantu.utils.CellPhoneUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.io.IOException;
import java.util.List;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest
public class PlanMapperTest {
    @Autowired
    private PlanMapper planMapper;
    @Test
    public void testGetAll(){
//        List<Plan> visitorList = planMapper.getAll();
//        visitorList.forEach(System.out::println);
    }


    @Test
    public void testa() throws IOException {
        String json = "{\"cellphone\":\"17678762789\",\"password\":\"176\"}";
        ObjectMapper mapper = new ObjectMapper();
        //JsonNode rootNode = mapper.readTree(json);
        //JsonNode usernameNode = rootNode.path("username");
        //String username = mapper.writeValueAsString(usernameNode);
//        JsonNode username = rootNode.path("username");
//        System.out.println("==username==");
//        System.out.println(username.textValue());
        CellPhoneUtil cellPhoneUtil = mapper.readValue(json,CellPhoneUtil.class);
        System.out.println(cellPhoneUtil);
    }
}
