package com.hucheng.util.email;


import org.simplejavamail.email.Email;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.Mailer;
import org.simplejavamail.mailer.MailerBuilder;

/**
 * #https://github.com/bbottema/simple-java-mail
 * @author xuchunlin
 * @version V1.0
 * @Title: SendMailUtils
 * @Package com.hucheng.util.email
 * @Description: TODO
 * @date 2018/1/13 11:45
 */
public class SendMailUtils {

    public static void send(String toemail,String subject,String html){
        send(toemail,subject,html,null);
    }

    public static void send(String toemail,String subject,String html,String ...ccAddress){
        Email email=null;
        if(ccAddress!=null && ccAddress.length>0){
            email = EmailBuilder.startingBlank().from("noreply@notice.moduo.io").cc("通知人",ccAddress).to(toemail).withSubject(subject).appendTextHTML(html).buildEmail();
        }else{
            email = EmailBuilder.startingBlank().from("noreply@notice.moduo.io").to(toemail).withSubject(subject).appendTextHTML(html).buildEmail();
        }

        Mailer mailer = MailerBuilder.withSMTPServer("smtpdm.aliyun.com", 465)
                .withSMTPServerUsername("noreply@notice.moduo.io")
                .withSMTPServerPassword("ModuoIo2017")
//                .withTransportStrategy(TransportStrategy.SMTPS)
                .withSessionTimeout(5* 1000)
                .withDebugLogging(false)
                .buildMailer();

        mailer.sendMail(email,true);
    }

    public static void main(String[] args) {
        SendMailUtils.send("903207003@qq.com","玩家网ETH账户余额不足提醒","<h3>代理提款账户0x234234234234234缺少ETH：0.5个，用于支付所有提款账户的总矿工费用。</h3>");
    }
}
