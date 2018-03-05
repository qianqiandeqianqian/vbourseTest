package com.hucheng.api.auth;

import com.auth0.jwt.JWTSigner;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.JWTVerifyException;
import com.auth0.jwt.internal.com.fasterxml.jackson.databind.ObjectMapper;
import com.hucheng.common.exception.TokenTimeoutException;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xuchunlin
 * @version V1.0
 * @Title: Jwt
 * @Package com.hucheng.api.auth
 * @Description: JWT验证
 * @date 2017/11/30 11:46
 */
public class Jwt {

    private static final String SECRET = "!qazModuoio-2017";

    private static final String EXP = "exp";

    private static final String PAYLOAD = "payload";

    //加密，传入一个对象和有效期
    public static <T> String sign(T object, long maxAge) {
        try {
            final JWTSigner signer = new JWTSigner(SECRET);
            final Map<String, Object> claims = new HashMap<String, Object>();
            ObjectMapper mapper = new ObjectMapper();
            String jsonString = mapper.writeValueAsString(object);
            claims.put(PAYLOAD, jsonString);
            claims.put(EXP, System.currentTimeMillis() + maxAge);
            return signer.sign(claims);
        } catch(Exception e) {
            return null;
        }
    }

    //解密，传入一个加密后的token字符串和解密后的类型
    public static<T> T unsign(String jwt, Class<T> classT) throws Exception {
        final JWTVerifier verifier = new JWTVerifier(SECRET);
        final Map<String,Object> claims= verifier.verify(jwt);
        if (claims.containsKey(EXP) && claims.containsKey(PAYLOAD)) {
            long exp = (Long)claims.get(EXP);
            long currentTimeMillis = System.currentTimeMillis();
            if (exp > currentTimeMillis) {
                String json = (String)claims.get(PAYLOAD);
                ObjectMapper objectMapper = new ObjectMapper();
                return objectMapper.readValue(json, classT);
            }
            throw new TokenTimeoutException("Token time out!");
        }
        return null;
    }

    public static void main(String[] args) {
        Map map=new HashMap();
        map.put("userid",1);
        map.put("username","xuchunlin");
        map.put("role","xuchunlin");
        map.put("truename","xuchunlin");
        map.put("moble","xuchunlin");
        String token=Jwt.sign(map, 60L*1000L*30L);//半小时
        System.out.println("token:"+token);
        try {
            Map maps=Jwt.unsign(token,Map.class);
            System.out.println("=="+maps);
        }catch (TokenTimeoutException e){
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }

    }

}
