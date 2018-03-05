package com.hucheng.util;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
/**
* @Description: Http请求工具类
* @author xuchunlin
* @date 2017/11/28 14:23
* @version V1.0
*/
public class HttpRequestUtil {
	public static String POST="POST";
	public static String GET="GET";
	
	public static String ajaxURL(String urlString,String method) throws Exception {
		StringBuffer buffer=new StringBuffer(); 
		URL url = new URL(urlString);
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		conn.setDoOutput(true);
		conn.setConnectTimeout(10* 1000);//设置访问连接超时
		conn.setReadTimeout(10* 1000);//设置读取数据连接超时
		conn.setRequestProperty("Charset", "UTF-8");//设置文件字符集
		if(method==null || "".equals(method)){
			method="GET";
		}
		conn.setRequestMethod(method);
		BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
		String line;
		while ((line = in.readLine()) != null) {
			buffer.append(line);
		}
		in.close();
		return buffer.toString();
	}

	/**
	 * 获取用户真实IP地址，不使用request.getRemoteAddr();的原因是有可能用户使用了代理软件方式避免真实IP地址,
	 * 参考文章： http://developer.51cto.com/art/201111/305181.htm
	 *
	 * 可是，如果通过了多级反向代理的话，X-Forwarded-For的值并不止一个，而是一串IP值，究竟哪个才是真正的用户端的真实IP呢？
	 * 答案是取X-Forwarded-For中第一个非unknown的有效IP字符串。
	 *
	 * 如：X-Forwarded-For：192.168.1.110, 192.168.1.120, 192.168.1.130,
	 * 192.168.1.100
	 *
	 * 用户真实IP为： 192.168.1.110
	 *
	 * @param request
	 * @return
	 */
	public static String getIpAddress(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		int i = ip.indexOf(",");
		if(i!=-1){//多个
			String[] ips= ip.split(",");
			for (String ip1 : ips){
				int j=ip1.indexOf(".");
				if(j==3){
					ip=ip1;
					break;
				}
			}
			ip=ips[0];
		}
		return ip;
	}

	public static void main(String[] args) {
		try {
		//	String params="email=1204007548@qq.com&email=1418091650@qq.com&email=2575897334@qq.com&theme=哈哈";
			String params="email=1204007548@qq.com";
			HttpRequestUtil.ajaxURL("http://192.168.6.107:8080/hiibook/user/save?"+params,HttpRequestUtil.POST);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
