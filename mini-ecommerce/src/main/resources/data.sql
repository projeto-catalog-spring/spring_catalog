INSERT INTO BRAND(name) values('MarcaReste');
INSERT INTO brand(name) values('FaberCastekll');
INSERT INTO brand(name) values('Santista');

INSERT INTO category (name) values('Roupa');
INSERT INTO category (name) values('Livros');
INSERT INTO category (name) values('Material Esportivo');

INSERT INTO price (sale_price, price) values(10.00, 20.00);
INSERT INTO price (sale_price, price) values(20.50, 30.00);
INSERT INTO price (sale_price, price) values(60.00, 50.50);
INSERT INTO price (sale_price, price) values(40.00, 50.25);
INSERT INTO price (sale_price, price) values(26.00, 96.00);
INSERT INTO price (sale_price, price) values(40.00, 20.00);
INSERT INTO price (sale_price, price) values(96.00, 60.00);
INSERT INTO price (sale_price, price) values(35.00, 50.00);
INSERT INTO price (sale_price, price) values(2.00, 10.00);
INSERT INTO price (sale_price, price) values(3.00, 4.00);

INSERT INTO product (name, description, enabled, brand_id, category_id, price_id) values('Camiseta', 'Camista muito louca', true, 2, 1, 1);
INSERT INTO product (name, description, enabled, brand_id, category_id, price_id) values('Livro do Pirula', 'bom livro', true, 1, 2, 2);
INSERT INTO product (name, description, enabled, brand_id, category_id, price_id) values('Camisa do Santos', 'PEEEEIXEEEEEEEE', true, 3, 3, 3);
INSERT INTO product (name, description, enabled, brand_id, category_id, price_id) values('Baita produto', 'Baita descrição do produto', true, 1, 1, 4);
INSERT INTO product (name, description, enabled, brand_id, category_id, price_id) values('Lapis', 'Lapis da hora com as bolinha pra não escorrega o dedo', true, 2, 3, 5);
INSERT INTO product (name, description, enabled, brand_id, category_id, price_id) values('produto1', 'Nem tem isso', false, 2, 1, 6);
INSERT INTO product (name, description, enabled, brand_id, category_id, price_id) values('produto2', 'BLA BLA', false, 3, 1, 7);
INSERT INTO product (name, description, enabled, brand_id, category_id, price_id) values('produto3', 'descrição do produto3', false, 3, 2, 8);
INSERT INTO product (name, description, enabled, brand_id, category_id, price_id) values('produto4', 'descrição do produto4', false, 1, 3, 9);
INSERT INTO product (name, description, enabled, brand_id, category_id, price_id) values('produto5', 'descrição do produto5', false, 1, 3, 10);

INSERT INTO sku (name, description, enabled, stock, product_id) values('SKU4-editando', 'desc 4--editada', false, 10510, 1);
INSERT INTO sku (name, description, enabled, stock, product_id) values('HB', 'Lápis HB', true, 15000, 2);
INSERT INTO sku (name, description, enabled, stock, product_id) values('B2', 'Lápis B2', true, 15000, 2);
INSERT INTO sku (name, description, enabled, stock, product_id) values('B4', 'Lápis B4', true, 15000, 2);
INSERT INTO sku (name, description, enabled, stock, product_id) values('Preta', 'Confortável', true, 100, 1);
INSERT INTO sku (name, description, enabled, stock, product_id) values('azul', 'macia', true, 5000, 3);
INSERT INTO sku (name, description, enabled, stock, product_id) values('SKUzada', 'de um prod ai', true, 256, 3);
INSERT INTO sku (name, description, enabled, stock, product_id) values('sku de um produto', 'descrição de um produto', true, 1051, 4);
INSERT INTO sku (name, description, enabled, stock, product_id) values('produto aleatorio', 'descrição aleatoria', true, 10, 5);
INSERT INTO sku (name, description, enabled, stock, product_id) values('SKU', 'SKU desativada', false, 0, 6);