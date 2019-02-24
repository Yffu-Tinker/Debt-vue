package cc.mrbird.febs.system.dao;

public interface DDataHistoryMapper {
    Integer countMonth(Long userId);

    Integer countTotal(Long userId);
}