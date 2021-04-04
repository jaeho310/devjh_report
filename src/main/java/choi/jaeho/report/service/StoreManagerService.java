package choi.jaeho.report.service;

import choi.jaeho.report.domain.dao.ProductDao;
import choi.jaeho.report.domain.dao.StoreDao;
import choi.jaeho.report.domain.model.Product;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StoreManagerService {

    private ProductDao productDao;

    private StoreDao storeDao;


    public StoreManagerService(ProductDao productDao, StoreDao storeDao) {
        this.productDao = productDao;
        this.storeDao = storeDao;
    }

    /**
     * 기준이되는 상점을 기준을 상품이 없다면 insert, 없다면 update 로직을 진행하는 메서드
     * DBMS에 종속적이지 않도록 merge 구문이나 upsert 대신 비즈니스로직에 모두 풀었습니다.
     * Transactional 메서드를 통해 트랜잭션 관리를 하였습니다.
     * @param standardName 기준 상점의 이름
     * @param targetName 동기화할 상점의 이름
     */
    @Transactional
    public void sync(String standardName, String targetName) {
        String standardStoreName = standardName;
        String targetStoreName = targetName;

        int sus01StoreId = storeDao.getStoreIdByStoreName(standardStoreName);
        int sus02StoreId = storeDao.getStoreIdByStoreName(targetStoreName);
        List<Product> products = productDao.getProductsByStoreId(sus01StoreId);
        for (Product product : products) {
            product.setStoreId(sus02StoreId);
            int cnt = productDao.getCntByStoreIdAndProductName(product);
            // sus_02에 같은 상품 존재
            if (cnt != 0){
                int result = productDao.updateByStandardProduct(product);
                if (result != 1) {
                    throw new RuntimeException("시스템 오류가 발생하였습니다.");
                }
            } else {
                // 상품이 sus_01에만 있고 sus_02에 없는경우
                productDao.insertByStandardProduct(product);
            }
        }
    }

    /**
     * 상품검색 메서드
     * sync 전후 점포별 상품을 확인하는 용도입니다.
     * @return 점포별 상점 list
     */
    public List<Product> getProductList(String storeName){
        int storeIdByStoreName = storeDao.getStoreIdByStoreName(storeName);
        return productDao.getProductsByStoreId(storeIdByStoreName);
    }
}
