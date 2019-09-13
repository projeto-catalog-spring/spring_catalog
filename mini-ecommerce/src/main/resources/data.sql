INSERT INTO brand(name) values('Nike');
INSERT INTO brand(name) values('Adidas');
INSERT INTO brand(name) values('Puma');
INSERT INTO brand(name) values('Vans');
INSERT INTO brand(name) values('Penalty');
INSERT INTO brand(name) values('Faber Castell');

INSERT INTO category (name) values('Calçados');
INSERT INTO category (name) values('Bermudas');
INSERT INTO category (name) values('Camisas');
INSERT INTO category (name) values('Material de Escritório');
INSERT INTO category (name) values('Animais');

INSERT INTO price (sale_price, price) values(17.00, 18.50);
INSERT INTO price (sale_price, price) values(18.50, 30.99);
INSERT INTO price (sale_price, price) values(19.00, 50.55);
INSERT INTO price (sale_price, price) values(10.50, 50.00);
INSERT INTO price (sale_price, price) values(21.00, 96.01);
INSERT INTO price (sale_price, price) values(22.00, 20.15);
INSERT INTO price (sale_price, price) values(100.00, 60.33);
INSERT INTO price (sale_price, price) values(24.00, 50.99);
INSERT INTO price (sale_price, price) values(25.00, 10.99);
INSERT INTO price (sale_price, price) values(1.00, 4.95);

INSERT INTO product (name, description, enabled, brand_id, category_id, price_id) values('Nike Explosion X56', 'Camista boa, leve, macia e uniforme', true, 1, 3, 4);
INSERT INTO product (name, description, enabled, brand_id, category_id, price_id) values('Nike Andante G8', 'Tênis incrível, compacto, confortável e disposto', true, 1, 1, 3);
INSERT INTO product (name, description, enabled, brand_id, category_id, price_id) values('Adidas Cobrinte T54', 'Bermuda arrojada, dinâmica e sentenciada', true, 2, 2, 2);
INSERT INTO product (name, description, enabled, brand_id, category_id, price_id) values('Vans Almorde V90', 'Tenis muito interessante e conservador', true, 4, 1, 5);
INSERT INTO product (name, description, enabled, brand_id, category_id, price_id) values('Lápis Velcro F4', 'Lapis da hora com as bolinhas pra não escorregar do dedo', true, 6, 4, 6);
INSERT INTO product (name, description, enabled, brand_id, category_id, price_id) values('Local de bater o penalty G67', 'Belo local, bem arquiteturado e com a marcação branca bem feita', true, 5, 4, 7);
INSERT INTO product (name, description, enabled, brand_id, category_id, price_id) values('Felino X5', 'Felino perigoso, melhor ter cuidado, inclusive', true, 3, 5, 1);
INSERT INTO product (name, description, enabled, brand_id, category_id, price_id) values('Nike Extint N45', 'Camisa asfáltica, feita com couro lunar da nasa', false, 1, 3, 8);
INSERT INTO product (name, description, enabled, brand_id, category_id, price_id) values('Adidas Lunus T56', 'Bermuda perspicaz bem construída com pele de cordeiro húngaro', false, 2, 2, 9);
INSERT INTO product (name, description, enabled, brand_id, category_id, price_id) values('Nike Never R49', 'Camisa feita de linho tinto dos açoures augúricos', false, 1, 3, 10);

INSERT INTO sku (name, description, enabled, stock, product_id) values('Nike Explosion X56 PV', 'Nike Explosion X56 P verde', false, 10510, 1);
INSERT INTO sku (name, description, enabled, stock, product_id) values('Nike Andante G8 GAP', 'Nike Andante G8 G azul piscina', true, 15000, 2);
INSERT INTO sku (name, description, enabled, stock, product_id) values('Nike Andante G8 MVM', 'Nike Andante G8 M verde musgo', true, 15000, 2);
INSERT INTO sku (name, description, enabled, stock, product_id) values('Nike Andante G8 XAQ', 'Nike Andante G8 XG amarelo queimado', true, 15000, 2);
INSERT INTO sku (name, description, enabled, stock, product_id) values('Nike Explosion X56 PZN', 'Nike Explosion X56 P zapdo nuclear', true, 100, 1);
INSERT INTO sku (name, description, enabled, stock, product_id) values('Adidas Cobrinte T54 MRP', 'Adidas Cobrinte T54 M rosa prateado', true, 5000, 3);
INSERT INTO sku (name, description, enabled, stock, product_id) values('Adidas Cobrinte T54 GXD', 'Adidas Cobrinte T54 G xislo dourado', true, 256, 3);
INSERT INTO sku (name, description, enabled, stock, product_id) values('Vans Almorde V90 P CQ', 'Vans Almorde V90 cinza quente', true, 1051, 4);
INSERT INTO sku (name, description, enabled, stock, product_id) values('Lápis Velcro F4 CA', 'Lápis Velcro F4 cores animadas', true, 10, 5);
INSERT INTO sku (name, description, enabled, stock, product_id) values('Nike Never R49 P VE', 'Nike Never R49 P verde enigmático', false, 0, 6);