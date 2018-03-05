package com.hucheng.util;

import javax.mail.*;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Calendar;
import java.util.Properties;

/**
* @Description: 邮件发送工具类
* @author xuchunlin
* @date 2017/11/28 14:46
* @version V1.0
*/
public class MailUtils {
    public static void sendMessage(String smtpHost,String port, String from,
                                   String fromUserPassword, String to, String subject,
                                   String messageText, String messageType) throws MessagingException {
        String _port="25";
        if(port!=null && !"".equals(port)){
            _port=port;
        }
        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "smtp");
        props.put("mail.smtp.host", smtpHost);
//        props.put("mail.smtp.starttls.enable", "true");// 使用 STARTTLS安全连接
         props.put("mail.smtp.port", _port); //google使用465或587端口
        props.put("mail.smtp.auth", "true"); // 使用验证
        // props.put("mail.debug", "true");
        Session mailSession = Session.getInstance(props, new MyAuthenticator(
                from, fromUserPassword));

        // 第二步：编写消息
        InternetAddress fromAddress = new InternetAddress(from);
        InternetAddress toAddress = new InternetAddress(to);

        MimeMessage message = new MimeMessage(mailSession);

        message.setFrom(fromAddress);
        message.addRecipient(RecipientType.TO, toAddress);

        message.setSentDate(Calendar.getInstance().getTime());
        message.setSubject(subject);
        message.setContent(messageText, messageType);

        // 第三步：发送消息
        Transport transport = mailSession.getTransport("smtp");
        transport.connect(smtpHost, from, fromUserPassword);
        transport.send(message, message.getRecipients(RecipientType.TO));

    }

    public static void main(String[] args) {
        try {
            MailUtils.sendMessage("smtpdm.aliyun.com", "25","noreply@notice.moduo.io",
                    "ModuoIo2017", "903207003@qq.com", "邮件标题-周报",
                    "--------------测试咯-wrwe-----------",
                    "text/html;charset=gb2312");
        } catch (MessagingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    static class MyAuthenticator extends Authenticator {
        String userName = "";
        String password = "";

        public MyAuthenticator() {

        }

        public MyAuthenticator(String userName, String password) {
            this.userName = userName;
            this.password = password;
        }

        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(userName, password);
        }
    }

}


