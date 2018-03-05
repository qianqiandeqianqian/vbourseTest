package com.hucheng.util;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

/**
 * 通讯录信息加密解密 AES
 * Created by xuchunlin on 2017/8/24.
 */
public class AESHelper {
    private static final String KEY_ALGORITHM = "AES";
    private static final String DEFAULT_CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";//默认的加密算法

    public static byte[] initSecretKey() {

        //返回生成指定算法密钥生成器的 KeyGenerator 对象
        KeyGenerator kg = null;
        try {
            kg = KeyGenerator.getInstance(KEY_ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return new byte[0];
        }
        //初始化此密钥生成器，使其具有确定的密钥大小
        //AES 要求密钥长度为 128
        kg.init(128);
        //生成一个密钥
        SecretKey  secretKey = kg.generateKey();
        return secretKey.getEncoded();
    }

    private static Key toKey(byte[] key){
        //生成密钥
        return new SecretKeySpec(key, KEY_ALGORITHM);
    }

    public static byte[] encrypt(byte[] data,Key key) throws Exception{
        return encrypt(data, key,DEFAULT_CIPHER_ALGORITHM);
    }

    public static byte[] encrypt(byte[] data,byte[] key) throws Exception{
        return encrypt(data, key,DEFAULT_CIPHER_ALGORITHM);
    }

    public static byte[] encrypt(byte[] data,byte[] key,String cipherAlgorithm) throws Exception{
        //还原密钥
        Key k = toKey(key);
        return encrypt(data, k, cipherAlgorithm);
    }

    public static byte[] encrypt(byte[] data,Key key,String cipherAlgorithm) throws Exception{
        //实例化
        Cipher cipher = Cipher.getInstance(cipherAlgorithm);
        //使用密钥初始化，设置为加密模式
        cipher.init(Cipher.ENCRYPT_MODE, key);
        //执行操作
        return cipher.doFinal(data);
    }

    public static byte[] decrypt(byte[] data,byte[] key) throws Exception{
        return decrypt(data, key,DEFAULT_CIPHER_ALGORITHM);
    }

    public static byte[] decrypt(byte[] data,Key key) throws Exception{
        return decrypt(data, key,DEFAULT_CIPHER_ALGORITHM);
    }

    public static byte[] decrypt(byte[] data,byte[] key,String cipherAlgorithm) throws Exception{
        //还原密钥
        Key k = toKey(key);
        return decrypt(data, k, cipherAlgorithm);
    }

    public static byte[] decrypt(byte[] data,Key key,String cipherAlgorithm) throws Exception{
        //实例化
        Cipher cipher = Cipher.getInstance(cipherAlgorithm);
        //使用密钥初始化，设置为解密模式
        cipher.init(Cipher.DECRYPT_MODE, key);
        //执行操作
        return cipher.doFinal(data);
    }

    public static byte[] hex2byte(String strhex) {
        if (strhex == null) {
            return null;
        }
        int l = strhex.length();
        if (l % 2 == 1) {
            return null;
        }
        byte[] b = new byte[l / 2];
        for (int i = 0; i != l / 2; i++) {
            b[i] = (byte) Integer.parseInt(strhex.substring(i * 2, i * 2 + 2),
                    16);
        }
        return b;
    }

    public static String byte2hex(byte[] b) {
        String hs = "";
        String stmp = "";
        for (int n = 0; n < b.length; n++) {
            stmp = (Integer.toHexString(b[n] & 0XFF));
            if (stmp.length() == 1) {
                hs = hs + "0" + stmp;
            } else {
                hs = hs + stmp;
            }
        }
        return hs.toUpperCase();
    }

    /**
     * 根据自动生成的Key 加密
     * @param data
     * @param k
     * @return
     * @throws Exception
     */
    public static String encrypt(String data,Key k) throws Exception{
        byte[] encryptData = encrypt(data.getBytes(), k);//数据加密
        String cncryStr = byte2hex(encryptData);
        return cncryStr;
    }


    /**
     * 获取加密私钥key
     * @return
     */
    public static Key generateKey(){
        byte[] key = initSecretKey();
        String keyStr = byte2hex(key);
        Key k = toKey(hex2byte(keyStr)); //生成秘钥
        return k;
    }

    /**
     * 根据私钥加密
     * @param data
     * @param keyStr
     * @return
     * @throws Exception
     */
    public static String encrypt(String data,String keyStr) throws Exception{
        Key k = toKey(hex2byte(keyStr)); //生成秘钥
        return encrypt(data,k);
    }

    /**
     * 根据私钥字符串解密
     * @param cncryStr
     * @return
     * @throws Exception
     */
    public static String decrypt(String cncryStr,String keyStr) throws Exception{
        Key k = toKey(hex2byte(keyStr));
        byte[] decryptData = decrypt(hex2byte(cncryStr), k);
        return new String(decryptData);
    }

    public static void main(String[] args) throws Exception {
        byte[] key = initSecretKey();
        String keyStr = byte2hex(key);
        keyStr="DE136139CE0A673DE9234817638860FD";//------------------------
        System.out.println("keyStr："+keyStr);
        Key k = toKey(hex2byte(keyStr)); //生成秘钥
        String data ="AESdsafdsafdsa数据";
        System.out.println("加密前数据: string:"+data);
        System.out.println();
        byte[] encryptData = encrypt(data.getBytes(), k);//数据加密
        String cncryStr = byte2hex(encryptData);
        cncryStr="49568A1B77860C11557C4644CD8A9EA59312FAF637FCE4D9828D285999754E4CCBFA22EA98A20C52EA153BDE568D1F1856E07A7F7210696118F8D18F3E4FC3C2A92F0BBD722D189E4D8ED0DB8C60049A9C3F8E5EC3A2682468F2115CE961B6BC8055E755392C8EDC77E274BFD408EBAECF014FDA94BC0668BF7B154B84CDBF68F85B9215291487DF10635E0FC65509BB3BC8DE972A4B5D5D91447E8993C99836B8A7151A46CD1338B955489EBEFA6C10F2FF2D46614F9C0476B0D49399E9AB0FBAC475DDF6B6DA9344BB0ABEBD1CC57271DED15804ECED7886402D135581D9A0EDC73AEE9DEDA852B0C67BB5FB46FE63743CECB64B9D878262FFF6ED2DBB5C016169941E2015143789EA6028343430688783851C5F76FB4BAC603A2768CC6CBB1A5174F704C9773E5F6302B6146B312B167BDD9515DE286449489590EE20820D4A47878E1F8046C86260373B054AB6458196D5B954B06427A6AD57EC61C90B5F830BE4BA57A9F81EFE8E70503CEC60B16DF0065F670C052AEE9E173B2E996C5A";//------------------------
        System.out.println("加密后数据:"+cncryStr);
//       System.out.println("加密后数据: hexStr:"+Hex.encodeHexStr(encryptData));
        System.out.println();
        byte[] decryptData = decrypt(hex2byte(cncryStr), k);//数据解密
        System.out.println("解密后数据: string:"+new String(decryptData));
    }

}
