package choi.jaeho.report.domain.model;

import lombok.Data;

@Data
public class Product {

    private int id;

    private String productName;

    private int price;

    private String manufacturer;

    private String nutritionInfo;

    private String img;

    private int storeId;
}
