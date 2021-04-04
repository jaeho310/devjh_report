package choi.jaeho.report.domain.dao;

import choi.jaeho.report.domain.model.Store;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StoreDao {
    int getStoreIdByStoreName(String storeName);
}
