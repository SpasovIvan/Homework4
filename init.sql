drop table if exists product cascade ;
create table product (id int primary key generated by default as identity, title varchar not null, description text not null, price float4 not null );
drop table if exists orders cascade ;
create table orders (id int primary key generated by default as identity, date_order date not null );
drop table if exists orders_product cascade;
create table orders_product (id int primary key generated by default as identity, product_id int not null, order_id int not null, count int not null, foreign key (product_id) references product(id), foreign key (order_id) references orders(id));

insert into product values (default, 'Ноутбук HP Pavilion', '15.6" экран, процессор Intel Core i5, 8 ГБ оперативной памяти, SSD накопитель', 899.99),
                           (default, 'Наушники Sony WH-1000XM4', 'Беспроводные наушники с активным шумоподавлением и высоким качеством звука', 349.99),
                           (default, 'Фитнес-браслет Fitbit Charge 5', 'Смарт-браслет с мониторингом сердечного ритма, сна и физической активности', 179.95),
                           (default, 'Кофемашина DeLonghi Magnifica', 'Полуавтоматическая кофемашина с функцией приготовления капучино и латте', 599.00),
                           (default, 'Наушники Beats Studio3 Wireless', 'Беспроводные наушники с адаптивным шумоподавлением и до 22 часов работы от одной зарядки', 349.95),
                           (default, 'Смартфон Samsung Galaxy S21 Ultra', 'Флагманский смартфон с 6.8" дисплеем, 5G поддержкой и профессиональной камерой с функцией Space Zoom', 1199.99),
                           (default, 'Смарт-часы Apple Watch Series 7', 'Умные часы с крупным дисплеем, функцией измерения уровня кислорода в крови и множеством приложений', 399.00),
                           (default, 'Фотоаппарат Canon EOS R5', 'Зеркальный фотоаппарат с разрешением 45 мегапикселей, съемкой видео 8K и системой стабилизации изображения', 3899.00);

insert into orders values  (default, '2023-11-19'),
                           (default, current_date),
                           (default, current_date),
                           (default,'2024-02-15'),
                           (default,'2024-03-03'),
                           (default,current_date),
                           (default,'2024-03-20');

insert into orders_product values (default, 1, 1, 10),
                                  (default, 3, 1, 4),
                                  (default, 1, 2, 53),
                                  (default, 3, 3, 21),
                                  (default,2, 2, 2),
                                  (default,4, 2, 1),
                                  (default,3, 4, 10),
                                  (default,1, 4, 3),
                                  (default,5, 5, 2),
                                  (default,6, 5, 1),
                                  (default,1, 6, 1),
                                  (default,2, 6, 3);