import com.hucheng.rmi.service.RmiWalletInterface;

import java.rmi.Naming;

/**
 * @author xuchunlin
 * @version V1.0
 * @Title: TestRmiWallet
 * @Package PACKAGE_NAME
 * @Description: TODO
 * @date 2017/12/27 11:45
 */
public class TestRmiWallet {

    public static void main(String[] args) {
        try {
            // 在RMI服务注册表中查找名称为RHello的对象，并调用其上的方法
            RmiWalletInterface rhello = (RmiWalletInterface) Naming.lookup("rmi://192.168.123.104:9400/rmiWalletService");
//            rhello.transfer(EnumCoin.llt,"world", BigInteger.valueOf(0));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
