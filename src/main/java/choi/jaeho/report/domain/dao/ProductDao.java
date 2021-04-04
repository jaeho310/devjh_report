package choi.jaeho.report.domain.dao;

import choi.jaeho.report.domain.model.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ProductDao {
    List<Product> getProductsByStoreId(int storeId);

    int getCntByStoreIdAndProductName(Product product);

    int updateByStandardProduct(Product product);

    int insertByStandardProduct(Product product);

    List<Product> getAll();
}
