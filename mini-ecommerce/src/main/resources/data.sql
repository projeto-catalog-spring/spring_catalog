INSERT INTO brand (name) value("MarcaReste");
INSERT INTO brand (name) value("FaberCastekll");
INSERT INTO brand (name) value("Santista");

INSERT INTO category (name) value("Roupa");
INSERT INTO category (name) value("Livros");
INSERT INTO category (name) value("Material Esportivo");

INSERT INTO product (name, description, enabled, brand_id, category_id) value("Camiseta", "Camista muito louca", true, 2, 1);
INSERT INTO product (name, description, enabled, brand_id, category_id) value("Livro do Pirula", "bom livro", true, 1, 2);
INSERT INTO product (name, description, enabled, brand_id, category_id) value("Camisa do Santos", "PEEEEIXEEEEEEEE", true, 3, 3);
INSERT INTO product (name, description, enabled, brand_id, category_id) value("Baita produto", "Baita descrição do produto", true, 1, 1);
INSERT INTO product (name, description, enabled, brand_id, category_id) value("Lapis", "Lapis da hora com as bolinha pra não escorrega o dedo", true, 2, 3);
INSERT INTO product (name, description, enabled, brand_id, category_id) value("produto1", "Nem tem isso", false, 2, 1);
INSERT INTO product (name, description, enabled, brand_id, category_id) value("produto2", "BLA BLA", false, 3, 1);
INSERT INTO product (name, description, enabled, brand_id, category_id) value("produto3", "descrição do produto3", false, 3, 2);
INSERT INTO product (name, description, enabled, brand_id, category_id) value("produto4", "descrição do produto4", false, 1, 3);
INSERT INTO product (name, description, enabled, brand_id, category_id) value("produto5", "descrição do produto5", false, 1, 3);

INSERT INTO price (sale_price, price, product_id) value(10.00, 20.00, 1);
INSERT INTO price (sale_price, price, product_id) value(20.50, 30.00, 2);
INSERT INTO price (sale_price, price, product_id) value(60.00, 50.50, 3);
INSERT INTO price (sale_price, price, product_id) value(40.00, 50.25, 4);
INSERT INTO price (sale_price, price, product_id) value(26.00, 96.00, 5);
INSERT INTO price (sale_price, price, product_id) value(40.00, 20.00, 6);
INSERT INTO price (sale_price, price, product_id) value(96.00, 60.00, 7);
INSERT INTO price (sale_price, price, product_id) value(35.00, 50.00, 8);
INSERT INTO price (sale_price, price, product_id) value(2.00, 10.00, 9);
INSERT INTO price (sale_price, price, product_id) value(3.00, 4.00, 10);

INSERT INTO sku (name, description, enabled, stock, product_id) value("SKU4-editando", "desc 4--editada", false, 10510, 1);
INSERT INTO sku (name, description, enabled, stock, product_id) value("HB", "Lápis HB", true, 15000, 2);
INSERT INTO sku (name, description, enabled, stock, product_id) value("B2", "Lápis B2", true, 15000, 2);
INSERT INTO sku (name, description, enabled, stock, product_id) value("B4", "Lápis B4", true, 15000, 2);
INSERT INTO sku (name, description, enabled, stock, product_id) value("Preta", "Confortável", true, 100, 1);
INSERT INTO sku (name, description, enabled, stock, product_id) value("azul", "macia", true, 5000, 3);
INSERT INTO sku (name, description, enabled, stock, product_id) value("SKUzada", "de um prod ai", true, 256, 3);
INSERT INTO sku (name, description, enabled, stock, product_id) value("sku de um produto", "descrição de um produto", true, 1051, 4);
INSERT INTO sku (name, description, enabled, stock, product_id) value("produto aleatorio", "descrição aleatoria", true, 10, 5);
INSERT INTO sku (name, description, enabled, stock, product_id) value("SKU", "SKU desativada", false, 0, 6);