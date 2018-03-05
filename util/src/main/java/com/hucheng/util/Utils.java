package com.hucheng.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
* @Description: 项目基本工具类
* @author xuchunlin
* @date 2017/11/28 14:27
* @version V1.0
*/
public class Utils {
	
	/**
	 * 判断是否是数字类型
	 * @param str
	 * @return
	 */
	public static boolean isNumber(String str){
	   Pattern pattern=Pattern.compile("[0-9]*");
	   Matcher match=pattern.matcher(str);
	   if(match.matches()==false){
	      return false;
	   }else{
	      return true;
	   }
	 }

	/**
	 * 验证金额
	 * @param str
	 * @return
	 */
    public static boolean isMoney(String str){ 
        Pattern pattern=Pattern.compile("^(([1-9]{1}\\d*)|([0]{1}))(\\.(\\d){0,2})?$"); // 判断小数点后一位的数字的正则表达式
        Matcher match=pattern.matcher(str); 
        if(match.matches()==false){ 
           return false; 
        }else{ 
           return true; 
        } 
    }

	/**
	 * 验证密码，6-12位密码
	 * @param str
	 * @return
	 */
	public static boolean isPswd(String str){
        Pattern pattern=Pattern.compile("^[\\da-zA-Z-_]{6,12}$");
        Matcher match=pattern.matcher(str); 
        if(match.matches()==false){ 
           return false; 
        }else{ 
           return true; 
        } 
    }

	/**
	 * 将字符串数组转换成以#号隔开的字符串，空的去除
	 * @param array 字符串数组
	 * @return
	 */
	public static String arrToString(String[] array,String chars){
		String str= StringUtils.join(array,chars);
		String srcReg="#{1,}";
        Pattern srcPattern = Pattern.compile(srcReg);  
        Matcher srcMatcher = srcPattern.matcher(str); 
        while(srcMatcher.find()) {  
        	str=str.replace(srcMatcher.group()+"", chars);
        }
		return str;
	}
	
	
	 /**  
     * 计算两个日期之间相差的天数  
     * @param smdate 较小的时间 
     * @param bdate  较大的时间 
     * @return 相差天数 
     * @throws ParseException  
     */    
    public static int daysBetween(Date smdate,Date bdate) throws ParseException    
    {    
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
        smdate=sdf.parse(sdf.format(smdate));  
        bdate=sdf.parse(sdf.format(bdate));  
        Calendar cal = Calendar.getInstance();    
        cal.setTime(smdate);    
        long time1 = cal.getTimeInMillis();                 
        cal.setTime(bdate);    
        long time2 = cal.getTimeInMillis();         
        long between_days=(time2-time1)/(1000*3600*24);  
            
       return Integer.parseInt(String.valueOf(between_days));           
    }    
      
	/** 
	*字符串的日期格式的计算 
	*/  
    public static int daysBetween(String smdate,String bdate) throws ParseException{  
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
        Calendar cal = Calendar.getInstance();    
        cal.setTime(sdf.parse(smdate));    
        long time1 = cal.getTimeInMillis();                 
        cal.setTime(sdf.parse(bdate));    
        long time2 = cal.getTimeInMillis();         
        long between_days=(time2-time1)/(1000*3600*24);  
            
       return Integer.parseInt(String.valueOf(between_days));     
    }

	/**
	 * 得到文件的后缀名
	 * @param fileName
	 * @return
	 */
	public static String fileSuffix(String fileName){
		int i=fileName.lastIndexOf(".");
		if(i!=-1){
			return fileName.substring(i+1);
		}
    	return fileName;
	}

	/**
	 * 格式化路径, 把windows路径替换成标准路径
	 * @param input 待格式化的路径
	 * @return 格式化后的路径
	 */
	public static String pathFormat( String input ) {
		return input.replace( "\\", "/" );
		
	}

	/**
	 * 检测是否是email
	 * @param email
	 * @return
	 */
	public static boolean isEmail(String email){
		if(email.matches("^[\\w\\.\\-]+@([\\w\\-]+\\.)+[\\w\\-]+$")){
			//^[A-Za-z0-9\u4e00-\u9fa5._-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$
			return true;
		}
		return false;
	}


	/**
	 * 手机号码格式验证
	 * @param mobiles 手机号码
	 * @return 正确格式返回true
	 */
	public static boolean isMobile(String mobiles){
		Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9])|(177))\\d{8}$");
		Matcher m = p.matcher(mobiles);
		return m.matches();
	}

}
