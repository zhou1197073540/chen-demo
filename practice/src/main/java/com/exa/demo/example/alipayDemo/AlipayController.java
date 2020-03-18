package com.exa.demo.example.alipayDemo;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
public class AlipayController {



    @RequestMapping(value = "/index", method= RequestMethod.GET)
    public String index(){
        System.out.println("....index...");
        return "index";
    }

    @RequestMapping(value = "/alipay.trade.page.pay", method= RequestMethod.POST)
    public ModelAndView trade_pay(HttpServletRequest request){
        System.out.println("....trade_pay...");
        ModelAndView mv=new ModelAndView();
        try {
            AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
            //商户订单号，商户网站订单系统中唯一订单号，必填
            String out_trade_no = request.getParameter("WIDout_trade_no");
            //付款金额，必填
            String total_amount =request.getParameter("WIDtotal_amount");
            //订单名称，必填
            String subject = request.getParameter("WIDsubject");
            //商品描述，可空
            String body = request.getParameter("WIDbody");

            //设置请求参数
            AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
            alipayRequest.setReturnUrl(AlipayConfig.return_url);
            alipayRequest.setNotifyUrl(AlipayConfig.notify_url);

            alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
                    + "\"total_amount\":\""+ total_amount +"\","
                    + "\"subject\":\""+ subject +"\","
                    + "\"body\":\""+ body +"\","
                    + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

            String result = alipayClient.pageExecute(alipayRequest).getBody();
            mv.addObject("result",result);
        } catch (AlipayApiException e) {
            log.info("AlipayApiException exception...");
            e.printStackTrace();
        }
        mv.setViewName("alipay.trade.page.pay");
        return mv;
    }

    @RequestMapping(value = "/alipay.trade.fastpay.refund.query", method= RequestMethod.POST)
    public String trade_precreate(){
        System.out.println("....alipay.trade.fastpay.refund.query...");
        return "alipay.trade.fastpay.refund.query";
    }

    @RequestMapping(value = "/alipay.trade.query", method= RequestMethod.POST)
    public String trade_query(){
        System.out.println("....alipay.trade.query...");
        return "alipay.trade.query";
    }

    @RequestMapping(value = "/alipay.trade.refund", method= RequestMethod.POST)
    public String trade_refund(){
        System.out.println("....alipay.trade.refund...");
        return "alipay.trade.refund";
    }

    @RequestMapping(value = "/notify_url", method= RequestMethod.GET)
    public String notify_url(){
        System.out.println("....notify_url...");
        return "notify_url";
    }

    @RequestMapping(value = "/return_url", method= RequestMethod.GET)
    public String return_url(){
        System.out.println("....return_url...");
        return "return_url";
    }
}
