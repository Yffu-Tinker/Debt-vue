package cc.mrbird.febs.system.service.impl;


import cc.mrbird.febs.common.domain.QueryRequest;
import cc.mrbird.febs.common.service.impl.BaseService;
import cc.mrbird.febs.common.utils.FebsUtil;
import cc.mrbird.febs.system.domain.DData;
import cc.mrbird.febs.system.domain.DDataHistory;
import cc.mrbird.febs.system.service.DDataHistoryService;
import cc.mrbird.febs.system.service.DDataService;
import com.wuwenze.poi.util.BeanUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

@Slf4j
@Service("dDataService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class DDataServiceImpl extends BaseService<DData> implements DDataService {

    @Autowired
    DDataHistoryService dDataHistoryService;

    @Override
    @Transactional
    public List<DData> findDData(QueryRequest queryRequest, DData dData) {
        Example example = new Example(DData.class);
        Example.Criteria criteria = example.createCriteria();
        if (dData.getOperatorId() != null) {
            criteria.andCondition("operator_id=", dData.getOperatorId());
        }
        FebsUtil.handleSort(queryRequest, example, "CREATE_TIME");
        return this.selectByExample(example);
    }

    @Override
    public void createDData(DData dData) {
        dData.setCreateTime(new Date());
        this.save(dData);
    }

    @Override
    public void updateDData(DData dData) {
        dData.setLastOperatTime(new Date());
        this.save(dData);
    }

    @Override
    public void deleteDData(Integer dataId) {
        this.delete(dataId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void finishData(DData dData) throws Exception {
        DDataHistory dDataHistory = new DDataHistory();
        BeanUtil.copyProperties(dDataHistory, dData);

        this.dDataHistoryService.save(dDataHistory);
        this.delete(dData.getId());
    }
}
