package com.hucheng.service.impl;

import com.hucheng.common.entity.DandanMyzc;
import com.hucheng.dao.DandanMyzcMapperDao;
import com.hucheng.service.DandanMyzcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xuchunlin
 * @version V1.0
 * @Title: DandanAdminServiceImpl
 * @Package com.hucheng.service.impl
 * @Description: TODO
 * @date 2017/11/29 17:11
 */
@Service
public class DandanMyzcServiceImpl implements DandanMyzcService {

    @Autowired
    private DandanMyzcMapperDao dandanMyzcMapperDao;

    public List<DandanMyzc> findPeddingTibList() throws Exception {
        return dandanMyzcMapperDao.findAll("findPeddingTibList",new DandanMyzc());
    }

    public int updateDandanMyzc(DandanMyzc dandanMyzc) throws Exception {
        return dandanMyzcMapperDao.update("updateByPrimaryKeySelective", dandanMyzc);
    }

    public DandanMyzc findDandanMyzc(Integer id) throws Exception {
        return dandanMyzcMapperDao.find(id);
    }
}
