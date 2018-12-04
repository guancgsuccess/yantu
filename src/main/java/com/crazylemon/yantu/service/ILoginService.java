package com.crazylemon.yantu.service;

import com.crazylemon.yantu.entity.Login;
import com.baomidou.mybatisplus.extension.service.IService;
import com.crazylemon.yantu.entity.Visitor;
import com.crazylemon.yantu.utils.CellPhoneUtil;
import com.crazylemon.yantu.utils.LoginBean;
import com.crazylemon.yantu.utils.LoginForm;
import com.crazylemon.yantu.utils.ServerResponse;

/**
 * <p>
 *  服务类
 * </p>
 */
public interface ILoginService extends IService<Login> {
    ServerResponse<Visitor> login(CellPhoneUtil cellPhoneUtil);
}
