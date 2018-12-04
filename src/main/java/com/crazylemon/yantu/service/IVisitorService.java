package com.crazylemon.yantu.service;

import com.crazylemon.yantu.entity.Visitor;
import com.baomidou.mybatisplus.extension.service.IService;
import com.crazylemon.yantu.utils.CellPhoneUtil;
import com.crazylemon.yantu.utils.LoginForm;
import com.crazylemon.yantu.utils.ServerResponse;
import com.crazylemon.yantu.vo.ScoreVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 */
public interface IVisitorService extends IService<Visitor> {
    List<Visitor> getAll();
    ServerResponse register(CellPhoneUtil cellPhoneUtil);
    ServerResponse savePerfectInformation(Visitor visitor);
    ServerResponse modifyPassword(Visitor visitor);
    Boolean validateCode(String code);
    Visitor getByTel(Long visitorTel);
    ServerResponse queryInformation(Integer visitorId);
    ServerResponse modifyNickName(Visitor visitor);
    ServerResponse modifyName(Visitor visitor);
    ServerResponse modifyPortrait(Visitor visitor);
    ServerResponse modifyGender(Visitor visitor);
    ServerResponse modifyIntroduction(Visitor visitor);
    ServerResponse modifyTelPhone(Visitor visitor);
    ServerResponse modifyEmail(Visitor visitor);
    ScoreVO getScoreVO(Integer visitorId);

}
