DROP TABLE IF EXISTS store;
DROP TABLE IF EXISTS product;

CREATE TABLE product
(
    id              INT             NOT NULL AUTO_INCREMENT,
    product_name    VARCHAR(50)     NOT NULL,
    price           INT             NOT NULL,
    manufacturer    VARCHAR(50)     NOT NULL,
    nutrition_info  VARCHAR(200)    NOT NULL,
    img             VARCHAR(50)     NOT NULL,
    store_id        INT             NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE store
(
    id              INT             NOT NULL AUTO_INCREMENT,
    store_name      VARCHAR(50)     NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO store(store_name) VALUES('sus_01');
INSERT INTO store(store_name) VALUES('sus_02');

INSERT INTO product(product_name, price, manufacturer, nutrition_info, img, store_id)
VALUES('코카콜라', 1000, '코카콜라 컴퍼니', '160kcal', '콜라.png', 1);

INSERT INTO product(product_name, price, manufacturer, nutrition_info, img, store_id)
VALUES('코카콜라', 1500, '코카콜라 컴퍼니', '160kcal', '콜라.png', 2);

INSERT INTO product(product_name, price, manufacturer, nutrition_info, img, store_id)
VALUES('환타', 1200, '코카콜라 컴퍼니', '160kcal', '환타.png', 1);
