package com.hucheng.service.impl;

import com.hucheng.common.entity.DandanEthTransfer;
import com.hucheng.common.view.WalletUser;
import com.hucheng.dao.DandanEthTransferMapperDao;
import com.hucheng.service.DandanEthTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xuchunlin
 * @version V1.0
 * @Title: DandanAdminServiceImpl
 * @Package com.hucheng.service.impl
 * @Description: TODO
 * @date 2017/11/29 17:11
 */
@Service
public class DandanEthTransferServiceImpl implements DandanEthTransferService {

    @Autowired
    private DandanEthTransferMapperDao dandanEthTransferMapperDao;

    public int saveDandanEthTransfer(DandanEthTransfer dandanEthTransfer) throws Exception {
        return dandanEthTransferMapperDao.insertSelective(dandanEthTransfer);
    }

    public int updateByTransfer(DandanEthTransfer dandanEthTransfer) throws Exception {
        return dandanEthTransferMapperDao.update("updateByTransfer",dandanEthTransfer);
    }

    public int updateByTransactionHash(DandanEthTransfer dandanEthTransfer) throws Exception {
        return dandanEthTransferMapperDao.update("updateByTransactionHash",dandanEthTransfer);
    }

    public void updateByTransactionHash(List<DandanEthTransfer> dandanEthTransfer) throws Exception {
        dandanEthTransferMapperDao.update("updateBatchByTransactionHash",dandanEthTransfer);
    }

    public DandanEthTransfer findDandanEthTransferByTransactionHash(String transactionHash) throws Exception {
        DandanEthTransfer dandanEthTransfer=new DandanEthTransfer();
        dandanEthTransfer.setTransactionhash(transactionHash);
        return dandanEthTransferMapperDao.find("findDandanEthTransferByTransactionHash", dandanEthTransfer);
    }

    public List<DandanEthTransfer> findDandanEthTransferFinishList() throws Exception {
        return dandanEthTransferMapperDao.findAll("findDandanEthTransferFinishList",new DandanEthTransfer());
    }

    public List<WalletUser> findDandanEthTransferNoToMainList() throws Exception {
        return dandanEthTransferMapperDao.findAll("findDandanEthTransferNoToMainList",new HashMap());
    }

    public void executeTransferAutoAddCoin(Integer id) throws Exception {
        Map map=new HashMap();
        map.put("id",id);
        dandanEthTransferMapperDao.find("executeTransferAutoAddCoin",map);
    }
}
