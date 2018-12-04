package com.crazylemon.yantu.mapper;

import com.crazylemon.yantu.entity.Visitor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest
public class VisitorMapperTest {
    @Autowired
    private VisitorMapper visitorMapper;
    @Test
    public void testGetAll(){
        List<Visitor> visitorList = visitorMapper.getAll();
        visitorList.forEach(System.out::println);
    }
    @Test
    public void testSave(){
        Visitor visitor = new Visitor();
        visitor.setVisitorTel(1000000l);
        visitor.setVisitorPsw("kleis");
        visitor.setVisitorNickname("kleis");
        System.out.println(visitorMapper.register(visitor));
    }
    @Test
    public void testSavePerfectInformation(){
        Visitor visitor = new Visitor();
        visitor.setVisitorId(2);
        visitor.setVisitorName("hello");
        visitor.setVisitorEmail("192168@163.com");
        visitor.setVisitorPortrait("touxiang.jpg");
        visitor.setVisitorGender(2);
        visitor.setVisitorIntroduction("测试数据hello");
        System.out.println(visitorMapper.savePerfectInformation(visitor));
    }
    @Test
    public void testModifyBaseInformation(){
        Visitor visitor = new Visitor();
        visitor.setVisitorId(2);
        visitor.setVisitorTel(17678627809l);
        visitor.setVisitorPsw("123");
        visitor.setVisitorName("hello");
        visitor.setVisitorEmail("192168117@163.com");
        visitor.setVisitorPortrait("textPortrait.jpg");
        visitor.setVisitorGender(1);
        visitor.setVisitorIntroduction("测试数据modify");
        System.out.println(visitorMapper.modifyVisitorInformation(visitor));
    }
//    @Test
//    public void testModifyPassword(){
//        Visitor visitor = new Visitor();
//        visitor.setVisitorId(2);
//        visitor.setVisitorPsw("123");
//        visitorMapper.modifyPassword(visitor);
//    }
//    @Test
//    public void testModifyTelPhone(){
//        Visitor visitor = new Visitor();
//        visitor.setVisitorId(2);
//        visitor.setVisitorTel(17678627809l);
//        visitorMapper.modifyTelPhone(visitor);
//    }
//    @Test
//    public void testModifyEmail(){
//        Visitor visitor = new Visitor();
//        visitor.setVisitorId(2);
//        visitor.setVisitorEmail("kleislove@gmail.com");
//        visitorMapper.modifyEmail(visitor);
//    }
    @Test
    public void testRemove(){
        visitorMapper.remove(2);
    }
    @Test
    public void testGetByTel(){
        System.out.println(visitorMapper.getByTel(17678627809l));
    }
    @Test
    public void testGetByEmail(){
        System.out.println(visitorMapper.getByEmail("kleislove@gmail.com"));
    }
    @Test
    public void testGetById(){
        System.out.println(visitorMapper.getById(2));
    }

}
