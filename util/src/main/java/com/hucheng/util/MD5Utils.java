package com.hucheng.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 采用MD5加密解密
 * @author xuchunlin
 * @datetime 2016-10-13
 */
public class MD5Utils {
	/**
	 * 根据文件路径获取加密后的路径
	 * @param filepath
	 * @return
	 */
	public static String getMD5Path(String filepath){
		int lastindex=filepath.lastIndexOf("/");
		int index=filepath.lastIndexOf(".");
		String fileName=filepath.substring(lastindex+1);//文件名称（包括后缀）
		String path=filepath.substring(0,lastindex+1);
		String md5FileName=getMd5FileName(fileName);
		if(index!=-1){
			String suffix=filepath.substring(index);//文件后缀
			return path+md5FileName+suffix; 
		}
		return path+md5FileName;
	}
	
	/**
	 * 根据文件名称获取16位MD5加密字符串
	 * @param filename 文件名称（包括后缀）
	 * @return
	 */
	public static String getMd5FileName(String filename){
		return MD5(filename,16);
	}

	/**
	 * 明文加密32位
	 * @param sourceStr
	 * @return
	 */
	public static String MD5(String sourceStr){
		return MD5(sourceStr,32);
	}

	public static String pswd(String sourceStr){
		return MD5(String.format("%s_!vbourse-2018",sourceStr));
	}
	/**
	 * MD5加密算法
	 * @param sourceStr
	 * @param length
	 * @return
	 */
	public static String MD5(String sourceStr,int length) {
        String result = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(sourceStr.getBytes());
            byte b[] = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            result = buf.toString();
            if(length==16){
            	result=buf.toString().substring(8, 24);
            }
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e);
        }
        return result;
    }
    
    
    /**
	 * 获取文件MD5加密串
	 * @param file
	 * @return
	 * @throws FileNotFoundException
	 */
	public static String getMd5ByFile(File file) throws FileNotFoundException {  
        String value = null;  
        FileInputStream in = new FileInputStream(file);  
	    try {  
	        MappedByteBuffer byteBuffer = in.getChannel().map(FileChannel.MapMode.READ_ONLY, 0, file.length());  
	        MessageDigest md5 = MessageDigest.getInstance("MD5");  
	        md5.update(byteBuffer);  
	        BigInteger bi = new BigInteger(1, md5.digest());  
	        value = bi.toString(16);  
	    } catch (Exception e) {  
	        e.printStackTrace();  
	    } finally {  
	            if(null != in) {  
	                try {  
	                in.close();  
	            } catch (IOException e) {  
	                e.printStackTrace();  
	            }  
	        }  
	    }  
	    return value;  
    } 
	
	
}
