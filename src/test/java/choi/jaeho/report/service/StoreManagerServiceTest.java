package choi.jaeho.report.service;

import choi.jaeho.report.domain.model.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
class StoreManagerServiceTest {

    @Autowired
    StoreManagerService storeManagerService;

    @Transactional
    @Test
    @DisplayName("sus_01을 기준으로 sus_02 동기화")
    void test1() {
        String standardStoreName = "sus_01";
        String targetStoreName = "sus_02";

        getProductList(standardStoreName);
        getProductList(targetStoreName);

        storeManagerService.sync(standardStoreName, targetStoreName);

        getProductList(standardStoreName);
        getProductList(targetStoreName);

    }


    /**
     * 상품조회 메서드
     */
    void getProductList(String storeName) {
        List<Product> products = storeManagerService.getProductList(storeName);
        for (Product product : products) {
            System.out.println("product = " + product);
        }

    }
}