package com.irs.service;

import com.irs.pojo.ApplySearch;
import com.irs.util.ResultUtil;

import java.util.List;
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
    public ResultUtil selApplies(Integer page, Integer limit, ApplySearch search);

    /**
     * 判断是否已申请过该商铺
     *
     * @param id
     * @return
     */
    public boolean isRepeat(String id);

    /**
     * 审批通过该申请
     *
     * @param id
     * @return
     */
    public boolean passApply(String id);

    /**
     * 统计信息
     *
     * @return
     */
    public Map<String, Integer> infoStatis();

    /**
     * 展示数据
     *
     * @return
     */
    public Map<String, Object> dataShow();
}
