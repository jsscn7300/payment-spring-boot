package com.enongm.dianji.payment.wechat.v3.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import lombok.Data;
import lombok.SneakyThrows;

/**
 * @author Dax
 * @since 16:34
 */
@Data
public class BaseModel {

    /**
     * 商品描述
     * Image形象店-深圳腾大-QQ公仔
     */
    private String description;
    /**
     * 商户系统内部订单号，只能是数字、大小写字母_-*且在同一个商户号下唯一，详见【商户订单号】。
     * 示例值：1217752501201407033233368018
     */
    private String outTradeNo;
    /**
     * 订单失效时间 YYYY-MM-DDTHH:mm:ss+TIMEZONE
     */
    private String timeExpire;
    /**
     * 附加数据，在查询API和支付通知中原样返回，可作为自定义参数使用
     */
    private String attach;
    /**
     * 通知URL必须为直接可访问的URL，不允许携带查询串。
     */
    private String notifyUrl;
    /**
     * 订单优惠标记
     */
    private String goodsTag;
    /**
     * 支付金额
     */
    private Amount amount;

    @SneakyThrows
    public String jsonBody() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return objectMapper.writeValueAsString(this);
    }
}
