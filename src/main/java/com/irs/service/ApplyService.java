package com.irs.service;

import com.irs.util.ResultUtil;

import java.util.Map;

public interface ApplyService {
    /**
     * 申请商铺
     *
     * @param id
     */
    public void apply(String id);

    /**
     * 获取当前登陆用户的申请列表
     *
     * @param page
     * @param limit
     * @return
     */
    public ResultUtil selapplysByUser(Integer page, Integer limit);

    /**
     * 获取申请列表
     *
     * @param page
     * @param limit
     * @param search
     * @return
     */
    public ResultUtil selApplies(Integer page, Integer limit, Map<String, Object> search);
}
