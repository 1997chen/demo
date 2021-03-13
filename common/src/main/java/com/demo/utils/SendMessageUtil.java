package com.demo.utils;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import org.json.JSONException;

import java.io.IOException;

/**
 * 腾讯云短信发送验证码工具类
 * @author QQ
 */
public class SendMessageUtil {

	// 短信应用SDK AppID
	int appid = 1400228934; // 1400开头

	// 短信应用SDK AppKey
	String appkey = "e9af5eac88c600cede4b39bf749d1ee9";

	// 短信模板ID，需要在短信应用中申请
	int[] templateId = {370328, 371120}; // NOTE: 这里的模板ID`7839`只是一个示例，真实的模板ID需要在短信控制台中申请

	// 签名
	String smsSign = "弘力科技"; // NOTE: 这里的签名"腾讯云"只是一个示例，真实的签名需要在短信控制台中申请，另外签名参数使用的是`签名内容`，而不是`签名ID`
	
	// 验证码
	String str = "000000";
	
	/**
	 * 发送短信验证码
	 * @param phoneNum 需要发送给哪个手机号码
	 * @param templateIdIndex 模板消息id数组的下标
	 * @return 验证码(若为000000则发送异常)
	 */
	public String sendMessage(String phoneNum, int templateIdIndex) {
		try {
			// 随即6位数赋值验证码
			String strTemp = (int) ((Math.random() * 9 + 1) * 100000) + "";
			
			//数组具体的元素个数和模板中变量个数必须一致，例如事例中templateId:5678对应一个变量，参数数组中元素个数也必须是一个
		    String[] params = {strTemp, "5"};
		    SmsSingleSender ssender = new SmsSingleSender(appid, appkey);
		    SmsSingleSenderResult result = ssender.sendWithParam("86", phoneNum,
		        templateId[templateIdIndex], params, smsSign, "", "");  // 签名参数未提供或者为空时，会使用默认签名发送短信
			System.out.println("result = " + result);
			if (result.result == 0) {
				str = strTemp;
			}
		} catch (HTTPException e1) {
		    // HTTP响应码错误
		    e1.printStackTrace();
		} catch (JSONException e2) {
		    // json解析错误
		    e2.printStackTrace();
		} catch (IOException e3) {
		    // 网络IO错误
		    e3.printStackTrace();
		}
		return str;
	}
	
}
