package com.wangpy.admin.controller;

import com.google.code.kaptcha.Producer;
import com.wangpy.common.constant.Constants;
import com.wangpy.common.core.domain.AjaxResult;
import com.wangpy.common.core.redis.RedisCache;
import com.wangpy.common.utils.sign.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FastByteArrayOutputStream;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Author: wangpy
 * @Description: 验证码控制访问类
 * @Date: Created in 2022/11/1 23:22
 */
@RestController
public class CaptchaController {
    @Autowired
    private RedisCache redisCache;

    @Resource(name = "captchaProducer")
    private Producer captchaProducer;

    // 生成验证码
    @GetMapping(value = "captchaImage")
    public AjaxResult captchaImage() throws IOException {//设置图片高度和宽度
//        BufferedImage image = new BufferedImage(80, 34, BufferedImage.TYPE_INT_RGB);
//        char[] charString = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
//        //获取设置的图片
//        Graphics gh = image.getGraphics();
//        //设置图片颜色
//        gh.setColor(Color.WHITE);
//        //填充矩形背景
//        gh.fillRect(0, 0, 80, 34);
//        //设置字体及大小
//        gh.setFont(new Font("", Font.BOLD, 28));
//        //设置字体颜色
//        gh.setColor(Color.lightGray);
//        //写入文字，调整字体位置坐标
//        String str = "";
//        Random s = new Random();
//        for (int i = 0; i < 4; i++) {
//            str = str + charString[s.nextInt(62)];
//
//        }
//        gh.drawString(str, 5, 30);
//        //写入干扰线
//        Random random = new Random();
//        //drawArc的参数为（坐标X,坐标Y,宽度，高度，起始角度，弧度）
//        for (int i = 0; i < 150; i++) {
//            gh.drawArc(random.nextInt(80), random.nextInt(40), random.nextInt(80), random.nextInt(40), random.nextInt(1), random.nextInt(90));
//        }
//        //转base64 注意前缀data:image/jpg;base64,
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        String uuidKey = UUID.randomUUID().toString();
//        redisCache.setKeyAndValString(Constants.CAPTCHA_CODE_KEY + uuidKey, str, Constants.CAPTCHA_EXPIRATION, TimeUnit.MINUTES);
//        ImageIO.write(image, "png", baos);
//        String imageBase64 = "data:image/jpg;base64," + Base64.getEncoder().encodeToString(baos.toByteArray());

        String capStr = null, code = null;
        BufferedImage image = null;
        capStr = code = captchaProducer.createText();
        image = captchaProducer.createImage(capStr);


        //  redisCache.setCacheObject(verifyKey, code, Constants.CAPTCHA_EXPIRATION, TimeUnit.MINUTES);
        // 转换流信息写出
        FastByteArrayOutputStream os = new FastByteArrayOutputStream();
        try {
            ImageIO.write(image, "jpg", os);
        } catch (IOException e) {
            return AjaxResult.error(e.getMessage());
        }

//        ajax.put("uuid", uuid);
//        ajax.put("img", Base64.encode(os.toByteArray()));
//        return ajax;
        Map<String, Object> map = new HashMap<>();
        String uuidKey = UUID.randomUUID().toString();
        redisCache.setKeyAndValString(Constants.CAPTCHA_CODE_KEY + uuidKey, code, Constants.CAPTCHA_EXPIRATION, TimeUnit.MINUTES);
        map.put("uuid", uuidKey);
        map.put("image", "data:image/jpg;base64," + Base64.encode(os.toByteArray()));
        return AjaxResult.success("OK", map);
    }
}
