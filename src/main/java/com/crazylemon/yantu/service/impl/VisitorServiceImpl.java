package com.crazylemon.yantu.service.impl;

import com.crazylemon.yantu.entity.Visitor;
import com.crazylemon.yantu.mapper.VisitorMapper;
import com.crazylemon.yantu.service.IVisitorService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.crazylemon.yantu.utils.*;
import com.crazylemon.yantu.vo.ScoreVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 */
@Service
public class VisitorServiceImpl extends ServiceImpl<VisitorMapper, Visitor> implements IVisitorService {
    private final VisitorMapper visitorMapper;

    @Autowired
    public VisitorServiceImpl(VisitorMapper visitorMapper) {
        this.visitorMapper = visitorMapper;
    }

    @Override
    public List<Visitor> getAll() {
        return visitorMapper.getAll();
    }

    @Override
    public ServerResponse register(CellPhoneUtil cellPhoneUtil) {
            Visitor visitor = new Visitor();
            visitor.setVisitorTel(cellPhoneUtil.getCellphone());
            visitor.setVisitorPsw(cellPhoneUtil.getPassword());
            System.out.println(visitor);
            Visitor visitor1 = visitorMapper.getByTel(visitor.getVisitorTel());
            if(visitor1==null){
                Integer registerResult = visitorMapper.register(visitor);
                System.out.println(visitorMapper.getByTel(visitor.getVisitorTel()));
                if(registerResult == 1){
                    System.out.println("注册成功");
                    return new ServerResponse(ResponseCode.SUCCESS.getCode(),visitorMapper.getByTel(visitor.getVisitorTel()),"注册成功");
                }
                else {
                    return new ServerResponse(ResponseCode.ERROR.getCode(),"注册失败");
                }
            }else {
                System.out.println("手机号已经被注册过!");
                return new ServerResponse(ResponseCode.ERROR.getCode(),"手机号已经被注册过!");
            }






    }

    @Override
    public ServerResponse savePerfectInformation(Visitor visitor) {
        Integer result = visitorMapper.savePerfectInformation(visitor);
        if(result > 0){
            Visitor visitor1 = visitorMapper.getById(visitor.getVisitorId());
            System.out.println(visitor1);
            return new ServerResponse(ResponseCode.SUCCESS.getCode(),visitor1,"添加成功");
        }
        return new ServerResponse(ResponseCode.ERROR.getCode(),"添加失败");
    }

    @Override
    public ServerResponse modifyPassword(Visitor visitor) {
        Integer result = visitorMapper.modifyPassword(visitor);
        if(result > 0){
            Visitor visitor1 = visitorMapper.getById(visitor.getVisitorId());
            System.out.println(visitor1);
            return new ServerResponse(ResponseCode.SUCCESS.getCode(),visitor1,"修改成功");
        }
        return new ServerResponse(ResponseCode.ERROR.getCode(),"修改失败");
    }

    @Override
    public Boolean validateCode(String code) {
        return code.equals(SendTelMsgUtil.createRandNum());
    }

    @Override
    public Visitor getByTel(Long visitorTel) {
        return visitorMapper.getByTel(visitorTel);
    }

    @Override
    public ServerResponse queryInformation(Integer visitorId) {
        Visitor visitor = visitorMapper.getById(visitorId);
        if(visitor != null){
            return new ServerResponse(ResponseCode.SUCCESS.getCode(),visitor,"查询成功");
        }
        return new ServerResponse(ResponseCode.ERROR.getCode(),"查询失败");
    }

    @Override
    public ServerResponse modifyNickName(Visitor visitor) {
        Integer result = visitorMapper.modifyNickName(visitor);
        if(result > 0){
            Visitor visitor1 = visitorMapper.getById(visitor.getVisitorId());
            System.out.println(visitor1);
            return new ServerResponse(ResponseCode.SUCCESS.getCode(),visitor1,"修改成功");
        }
        return new ServerResponse(ResponseCode.ERROR.getCode(),"修改失败");
    }

    @Override
    public ServerResponse modifyName(Visitor visitor) {
        Integer result = visitorMapper.modifyName(visitor);
        if(result > 0){
            Visitor visitor1 = visitorMapper.getById(visitor.getVisitorId());
            System.out.println(visitor1);
            return new ServerResponse(ResponseCode.SUCCESS.getCode(),visitor1,"修改成功");
        }
        return new ServerResponse(ResponseCode.ERROR.getCode(),"修改失败");
    }

    @Override
    public ServerResponse modifyPortrait(Visitor visitor) {
        Integer result = visitorMapper.modifyPortrait(visitor);
        if(result > 0){
            Visitor visitor1 = visitorMapper.getById(visitor.getVisitorId());
            System.out.println(visitor1);
            return new ServerResponse(ResponseCode.SUCCESS.getCode(),visitor1,"修改成功");
        }
        return new ServerResponse(ResponseCode.ERROR.getCode(),"修改失败");
    }

    @Override
    public ServerResponse modifyGender(Visitor visitor) {
        Integer result = visitorMapper.modifyGender(visitor);
        if(result > 0){
            Visitor visitor1 = visitorMapper.getById(visitor.getVisitorId());
            System.out.println(visitor1);
            return new ServerResponse(ResponseCode.SUCCESS.getCode(),visitor1,"修改成功");
        }
        return new ServerResponse(ResponseCode.ERROR.getCode(),"修改失败");
    }

    @Override
    public ServerResponse modifyIntroduction(Visitor visitor) {
        Integer result = visitorMapper.modifyIntroduction(visitor);
        if(result > 0){
            Visitor visitor1 = visitorMapper.getById(visitor.getVisitorId());
            System.out.println(visitor1);
            return new ServerResponse(ResponseCode.SUCCESS.getCode(),visitor1,"修改成功");
        }
        return new ServerResponse(ResponseCode.ERROR.getCode(),"修改失败");
    }

    @Override
    public ServerResponse modifyTelPhone(Visitor visitor) {
        Integer result = visitorMapper.modifyTelPhone(visitor);
        if(result > 0){
            Visitor visitor1 = visitorMapper.getById(visitor.getVisitorId());
            System.out.println(visitor1);
            return new ServerResponse(ResponseCode.SUCCESS.getCode(),visitor1,"修改成功");
        }
        return new ServerResponse(ResponseCode.ERROR.getCode(),"修改失败");
    }

    @Override
    public ServerResponse modifyEmail(Visitor visitor) {
        Integer result = visitorMapper.modifyEmail(visitor);
        if(result > 0){
            Visitor visitor1 = visitorMapper.getById(visitor.getVisitorId());
            System.out.println(visitor1);
            return new ServerResponse(ResponseCode.SUCCESS.getCode(),visitor1,"修改成功");
        }
        return new ServerResponse(ResponseCode.ERROR.getCode(),"修改失败");
    }

    @Override
    public ScoreVO getScoreVO(Integer visitorId) {
        return visitorMapper.getScoreVOByVisitorID(visitorId);
    }

}
