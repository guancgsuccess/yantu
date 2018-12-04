package com.crazylemon.yantu.controller;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradePayModel;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.response.AlipayTradePagePayResponse;
import com.crazylemon.yantu.entity.OrderMaster;
import com.crazylemon.yantu.service.impl.OrderMasterServiceImpl;
import com.crazylemon.yantu.utils.AlipayConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 支付宝支付Controller
 * @author linhongcun
 *
 */
@Slf4j
@Controller
@RequestMapping("/alipay")
public class AlipayController {

    @Autowired
    private OrderMasterServiceImpl orderMasterService;

    // 获取配置文件的信息
    String app_id = AlipayConfig.app_id;
    String private_key = AlipayConfig.merchant_private_key;
    String notify_url = AlipayConfig.notify_url;
    String return_url = AlipayConfig.return_url;
    String url = AlipayConfig.gatewayUrl;
    String charset = AlipayConfig.charset;
    String format = AlipayConfig.format;
    String public_key = AlipayConfig.alipay_public_key;
    String signtype = AlipayConfig.sign_type;

    /**
     * 支付请求
     *
     * @param orderId
     * @param response
     * @param response
     * @throws Exception
     */
    @GetMapping("/pay/{orderId}")
    public void pay(@PathVariable("orderId") Integer orderId, HttpServletResponse response) {
        OrderMaster orderMaster = orderMasterService.getById(orderId);
        System.out.println("orderMaster"+orderMaster);
        Integer orderNo = orderMaster.getOrderId(); // 生成订单号
        Double totalAmount = orderMaster.getOrderPrice(); // 支付总金额
        String subject = "Yantu"+orderMaster.getOrderId(); // 订单名称
        String body = "yantuTrip"; // 商品描述

        // 封装请求客户端
        AlipayClient client = new DefaultAlipayClient(url, app_id, private_key, format, charset, public_key, signtype);

        // 支付请求
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(return_url);
        alipayRequest.setNotifyUrl(notify_url);
        AlipayTradePayModel model = new AlipayTradePayModel();
        model.setProductCode("FAST_INSTANT_TRADE_PAY"); // 设置销售产品码
        model.setOutTradeNo(String.valueOf(orderNo)); // 设置订单号
        model.setSubject(subject); // 订单名称
        model.setTotalAmount((String.valueOf(totalAmount))); // 支付总金额

        model.setBody(body); // 设置商品描述
        alipayRequest.setBizModel(model);

        log.info(model.toString());
        alipayRequest.setBizContent("{\"out_trade_no\":\""+ orderNo +"\","
                + "\"total_amount\":\""+ totalAmount +"\","
                + "\"subject\":\""+ subject +"\","
                + "\"body\":\""+ body +"\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

        try{
            // 3、生成支付表单
            AlipayTradePagePayResponse alipayResponse = client.pageExecute(alipayRequest);
            if(alipayResponse.isSuccess()) {
                String result = alipayResponse.getBody();
                response.setContentType("text/html;charset=" + charset);
                response.getWriter().write(result); // 直接将完整的表单html输出到页面
                response.getWriter().flush();
                response.getWriter().close();

            } else {
                log.error("【支付表单生成】失败，错误信息：{}", alipayResponse.getSubMsg());
                response.getWriter().write("error");
            }
        } catch (Exception e) {
            log.error("【支付表单生成】异常，异常信息：{}", e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * 同步跳转
     *
     * @param request
     * @throws Exception
     */
    @RequestMapping("/returnUrl")
    public ModelAndView returnUrl(HttpServletRequest request) throws Exception {
        ModelAndView mav = new ModelAndView();

        // 获取支付宝GET过来反馈信息（官方固定代码）
        Map<String, String> params = new HashMap<String, String>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
            }
            params.put(name, valueStr);
        }
        System.out.println(requestParams);
        boolean signVerified = AlipaySignature.rsaCheckV1(params, public_key, charset, signtype); // 调用SDK验证签名

        // 返回界面
        if (signVerified) {
            // 修改数据库
            orderMasterService.updateOrderStatusToSuccess(Integer.parseInt(params.get("out_trade_no")));
            System.out.println("前往支付成功页面");
            mav.setViewName("orderManager");
        } else {
            System.out.println("前往支付失败页面");
            mav.setViewName("index");
        }
        return mav;
    }

    /**
     * 支付宝服务器异步通知
     *
     * @param request
     * @throws Exception
     */
    @RequestMapping("/notifyUrl")
    public void notifyUrl(HttpServletRequest request) throws Exception {

        // 获取支付宝GET过来反馈信息
        Map<String, String>  params= new HashMap<>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
            }
            params.put(name, valueStr);
        }

        boolean signVerified = AlipaySignature.rsaCheckV1(params, public_key, charset, signtype); // 调用SDK验证签名

        if (signVerified) { // 验证成功 更新订单信息
            System.out.println("异步通知成功");
            // 商户订单号
            String out_trade_no = request.getParameter("out_trade_no");
            // 交易状态
            String trade_status = request.getParameter("trade_status");

            System.out.println("out_trade_no="+out_trade_no);
            System.out.println("trade_status="+trade_status);
        } else {
            System.out.println("异步通知失败");
        }
    }

}