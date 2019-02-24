package cc.mrbird.febs.system.dao;

import cc.mrbird.febs.system.domain.DData;
import cc.mrbird.febs.system.domain.DDataExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DDataMapper {
    long countByExample(DDataExample example);

    int deleteByExample(DDataExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DData record);

    int insertSelective(DData record);

    List<DData> selectByExampleWithBLOBs(DDataExample example);

    List<DData> selectByExample(DDataExample example);

    DData selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DData record, @Param("example") DDataExample example);

    int updateByExampleWithBLOBs(@Param("record") DData record, @Param("example") DDataExample example);

    int updateByExample(@Param("record") DData record, @Param("example") DDataExample example);

    int updateByPrimaryKeySelective(DData record);

    int updateByPrimaryKeyWithBLOBs(DData record);

    int updateByPrimaryKey(DData record);
}