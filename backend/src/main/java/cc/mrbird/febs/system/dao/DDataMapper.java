package cc.mrbird.febs.system.dao;

import cc.mrbird.febs.common.config.MyMapper;
import cc.mrbird.febs.system.domain.DData;

public interface DDataMapper extends MyMapper<DData> {

    void updateOperator(String[] dataIds, Integer userId);
}