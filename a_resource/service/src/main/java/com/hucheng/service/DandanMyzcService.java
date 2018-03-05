package com.hucheng.service;

import com.hucheng.common.entity.DandanMyzc;

import java.util.List;

/**
 * @author xuchunlin
 * @version V1.0
 * @Title: DandanUserService
 * @Package com.hucheng.service
 * @Description: TODO
 * @date 2017/11/28 16:10
 */
public interface DandanMyzcService {

    /**
     * 查询等待自动入币的转出记录
     * @return
     * @throws Exception
     */
    List<DandanMyzc> findPeddingTibList() throws Exception;


    /**
     * 修改转出表记录
     * @param dandanMyzc
     * @return
     * @throws Exception
     */
    int updateDandanMyzc(DandanMyzc dandanMyzc) throws Exception;

    /**
     * 根据ID查询转出记录
     * @param id
     * @return
     * @throws Exception
     */
    DandanMyzc findDandanMyzc(Integer id) throws Exception;
}
