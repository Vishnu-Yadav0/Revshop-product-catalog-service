-- Product Data Refresh (Starting from ID 2)
-- NOTE: Prices are in Indian Rupees (INR)
-- Data Preservation: Product ID 1 and Categories are left intact.

-- Cleanup previous additions for fresh bulk insert
DELETE FROM product_images WHERE product_id > 1;
DELETE FROM products WHERE product_id > 1;

-- 2: Mobiles
INSERT INTO products (product_id, name, description, mrp, selling_price, stock_quantity, threshold_quantity, is_active, image_url, category_id, seller_id, created_at, updated_at) VALUES
(2,'Samsung Galaxy S24 Ultra','Samsung Galaxy S24 Ultra 5G AI Smartphone (Titanium Gray, 12GB, 256GB Storage)',134999,129999,50,5,1,'https://rukminim1.flixcart.com/image/1600/2140/xif0q/mobile/j/m/z/-original-imahgfmxumntk7sy.jpeg?q=60',2,2,NOW(),NOW()),
(3,'Apple iPhone 15 Pro','Apple iPhone 15 Pro (128 GB) - Natural Titanium',134900,127990,40,5,1,'https://rukminim1.flixcart.com/image/1600/2140/xif0q/mobile/z/4/r/-original-imagtc4g22rcatjg.jpeg?q=60',2,2,NOW(),NOW()),
(4,'Google Pixel 8 Pro','Google Pixel 8 Pro with Gemini AI (Bay, 128 GB)',106999,99999,30,5,1,'https://rukminim1.flixcart.com/image/1600/2140/xif0q/mobile/3/q/3/-original-imahegqhgnafpbzh.jpeg?q=60',2,2,NOW(),NOW()),
(5,'OnePlus 12','OnePlus 12 (Flowy Emerald, 16GB RAM, 512GB Storage)',69999,64999,60,10,1,'https://images.unsplash.com/photo-1512941937669-90a1b58e7e9c?w=800&q=80',2,2,NOW(),NOW()),
(6,'Xiaomi 14 Ultra','Xiaomi 14 Ultra (Black, 16GB RAM, 512GB Storage) Leica Optics',119999,99999,25,5,1,'https://images.unsplash.com/photo-1511707171634-5f897ff02aa9?w=800&q=80',2,2,NOW(),NOW()),
(7,'Nothing Phone (2)','Nothing Phone (2) 5G (Dark Grey, 12GB RAM, 256GB Storage)',49999,39999,80,10,1,'https://rukminim1.flixcart.com/image/1600/2140/xif0q/mobile/v/d/g/-original-imahgr295uvptwq7.jpeg?q=60',2,2,NOW(),NOW()),
(8,'Samsung Galaxy Z Fold 5','Samsung Galaxy Z Fold5 5G (Phantom Black, 12GB RAM, 256GB Storage)',164999,154999,15,5,1,'https://images.unsplash.com/photo-1610945415295-d9baf060e1df?w=800&q=80',2,2,NOW(),NOW()),
(9,'Motorola Edge 50 Pro','Motorola Edge 50 Pro 5G (Luxe Lavender, 12GB RAM, 256GB Storage)',41999,35999,100,20,1,'https://rukminim1.flixcart.com/image/1600/2140/xif0q/mobile/g/i/n/-original-imagzhspjy5g8nh3.jpeg?q=60',2,2,NOW(),NOW());

-- 3: Laptops
INSERT INTO products (product_id, name, description, mrp, selling_price, stock_quantity, threshold_quantity, is_active, image_url, category_id, seller_id, created_at, updated_at) VALUES
(10,'MacBook Air M3','Apple 2024 MacBook Air Laptop with M3 chip: 13.6-inch Liquid Retina Display',114900,104900,45,5,1,'https://rukminim1.flixcart.com/image/1600/2140/xif0q/computer/a/q/h/-original-imagypv6prbgkfzg.jpeg?q=60',3,2,NOW(),NOW()),
(11,'Dell XPS 13','Dell XPS 13 9340 Laptop, Intel Core Ultra 7 Processor, 16GB, 512GB SSD',159990,144990,20,5,1,'https://images.unsplash.com/photo-1588872657578-7efd1f1555ed?w=800&q=80',3,2,NOW(),NOW()),
(12,'HP Spectre x360','HP Spectre x360 2-in-1 Laptop, 14-inch OLED Touch, Core Ultra 7',174999,164999,15,3,1,'https://images.unsplash.com/photo-1544006659-f0b21f04cb1d?w=800&q=80',3,2,NOW(),NOW()),
(13,'ASUS Zenbook 14 OLED','ASUS Zenbook 14 OLED (2024), Intel Core Ultra 5, 16GB, 1TB SSD',109990,94990,30,5,1,'https://images.unsplash.com/photo-1496181133206-80ce9b88a853?w=800&q=80',3,2,NOW(),NOW()),
(14,'Lenovo ThinkPad X1 Carbon','Lenovo ThinkPad X1 Carbon Gen 11, Intel Core i7-1355U, 32GB RAM',215000,189999,10,2,1,'https://images.unsplash.com/photo-1525547719571-a2d4ac8945e2?w=800&q=80',3,2,NOW(),NOW()),
(15,'Acer Predator Helios Neo 16','Acer Predator Helios Neo 16 Gaming Laptop, Intel Core i7-13700HX, RTX 4060',149999,124999,25,5,1,'https://images.unsplash.com/photo-1603302576837-37561b2e2302?w=800&q=80',3,2,NOW(),NOW()),
(16,'Microsoft Surface Laptop 5','Microsoft Surface Laptop 5 - 13.5", Intel Core i5, 8GB RAM, 256GB SSD',107900,92900,40,5,1,'https://images.unsplash.com/photo-1496181133206-80ce9b88a853?w=800&q=80',3,2,NOW(),NOW()),
(17,'Razer Blade 15','Razer Blade 15 Gaming Laptop: NVIDIA GeForce RTX 3070 Ti - 12th Gen Intel 14-Core i7',285000,249999,5,2,1,'https://images.unsplash.com/photo-1593642632823-8f785ba67e45?w=800&q=80',3,2,NOW(),NOW());

-- 4: Audio
INSERT INTO products (product_id, name, description, mrp, selling_price, stock_quantity, threshold_quantity, is_active, image_url, category_id, seller_id, created_at, updated_at) VALUES
(18,'Sony WH-1000XM5','Sony WH-1000XM5 Wireless Industry Leading Noise Cancelling Headphones',34990,29990,100,10,1,'https://rukminim1.flixcart.com/image/1600/2140/xif0q/headphone/v/d/g/-original-imahgr295uvptwq7.jpeg?q=60',4,2,NOW(),NOW()),
(19,'Bose QuietComfort Ultra','Bose QuietComfort Ultra Headphones, Wireless Noise Cancelling Over-the-Ear',35900,32900,80,10,1,'https://images.unsplash.com/photo-1546435770-a3e426bf472b?w=800&q=80',4,2,NOW(),NOW()),
(20,'Apple AirPods Pro (2nd Gen)','Apple AirPods Pro (2nd Generation) with MagSafe Case (USB-C)',24900,22900,150,20,1,'https://images.unsplash.com/photo-1588423770973-522e5586011e?w=800&q=80',4,2,NOW(),NOW()),
(21,'Sennheiser Momentum 4','Sennheiser Momentum 4 Wireless Headphones - 60h Battery Life',34990,27990,60,10,1,'https://images.unsplash.com/photo-1590658268037-6bf12165a8df?w=800&q=80',4,2,NOW(),NOW()),
(22,'JBL Flip 6','JBL Flip 6, Wireless Portable Bluetooth Speaker, Pro Sound',14999,11999,200,30,1,'https://images.unsplash.com/photo-1608043152269-423dbba4e7e1?w=800&q=80',4,2,NOW(),NOW()),
(23,'Sony WF-1000XM5','Sony WF-1000XM5 Truly Wireless Noise Cancelling Earbuds',29990,24990,120,15,1,'https://images.unsplash.com/photo-1590658006244-857003488d01?w=800&q=80',4,2,NOW(),NOW()),
(24,'Marshall Stanmore III','Marshall Stanmore III Wireless Bluetooth Home Speaker - Black',41999,35999,30,5,1,'https://images.unsplash.com/photo-1589003077984-894e133dabab?w=800&q=80',4,2,NOW(),NOW()),
(25,'Samsung Galaxy Buds2 Pro','Samsung Galaxy Buds2 Pro - Bora Purple',19999,14999,100,15,1,'https://images.unsplash.com/photo-1590603730722-e3a1f736270e?w=800&q=80',4,2,NOW(),NOW());

-- 7: Mens Wear
INSERT INTO products (product_id, name, description, mrp, selling_price, stock_quantity, threshold_quantity, is_active, image_url, category_id, seller_id, created_at, updated_at) VALUES
(34,'Levi 511 Slim Fit','Levi''s Men''s 511 Slim Fit Jeans - Rigid Dragon',4999,3999,200,30,1,'https://m.media-amazon.com/images/I/61FWpb5rkgL._AC_UL480_FMwebp_QL65_.jpg',7,2,NOW(),NOW()),
(35,'Nike Tech Fleece','Nike Sportswear Tech Fleece Men''s Full-Zip Hoodie',9995,8495,100,15,1,'https://rukminim1.flixcart.com/image/1600/2140/xif0q/track-pant/u/f/y/l-if0722-063-nike-original-imahgwwaznsyhxkt.jpeg?q=60',7,2,NOW(),NOW()),
(36,'Ralph Lauren Polo','Polo Ralph Lauren Men''s Custom Slim Fit Mesh Polo',8900,7500,150,20,1,'https://images.unsplash.com/photo-1581655353564-df123a1eb820?w=800&q=80',7,2,NOW(),NOW()),
(37,'Tommy Hilfiger Shirt','Tommy Hilfiger Men''s Regular Fit Solid Oxford Shirt',4599,3299,120,15,1,'https://images.unsplash.com/photo-1596755094514-f87e34085b2c?w=800&q=80',7,2,NOW(),NOW()),
(38,'Allen Solly Blazer','Allen Solly Men''s Slim Fit Single Breasted Blazer',6999,5499,50,10,1,'https://images.unsplash.com/photo-1594932224456-802d92673323?w=800&q=80',7,2,NOW(),NOW()),
(39,'Adidas Tiro Pants','Adidas Men''s Soccer Tiro 21 Track Pants',3599,2899,180,25,1,'https://images.unsplash.com/photo-1491336477066-31156b5e4f35?w=800&q=80',7,2,NOW(),NOW()),
(40,'H&M Denim Jacket','H&M Men''s Denim Jacket Regular Fit - Light Denim',2999,2299,90,15,1,'https://images.unsplash.com/photo-1516259762381-22954d7d3ad2?w=800&q=80',7,2,NOW(),NOW()),
(41,'USPA T-Shirt','U.S. Polo Assn. Men''s Solid V-Neck T-Shirt',1599,1299,300,50,1,'https://images.unsplash.com/photo-1521572163474-6864f9cf17ab?w=800&q=80',7,2,NOW(),NOW()),
(42,'Van Heusen Formal Pant','Van Heusen Men''s Slim Fit Formal Trousers',2499,1999,150,20,1,'https://images.unsplash.com/photo-1594633312681-425c7b97ccd1?w=800&q=80',7,2,NOW(),NOW()),
(43,'Peter England Suit','Peter England Men''s Slim Fit Two Piece Suit',8999,6999,40,5,1,'https://images.unsplash.com/photo-1594932224456-802d92673323?w=800&q=80',7,2,NOW(),NOW());

-- 8: Womens Wear
INSERT INTO products (product_id, name, description, mrp, selling_price, stock_quantity, threshold_quantity, is_active, image_url, category_id, seller_id, created_at, updated_at) VALUES
(44,'Zara Floral Dress','Zara Women''s Floral Print Long Midi Dress',4590,3990,80,10,1,'https://rukminim1.flixcart.com/image/1600/2140/xif0q/dress/g/3/1/l-m2157-metronaut-original-imahkvk5tugc8g9m.jpeg?q=60',8,2,NOW(),NOW()),
(45,'H&M Cashmere Sweater','H&M Women''s Cashmere-blend Turtleneck Sweater',7999,6499,60,10,1,'https://images.unsplash.com/photo-1434389677669-e08b4cac3105?w=800&q=80',8,2,NOW(),NOW()),
(46,'Levis 711 Skinny','Levi''s Women''s 711 Mid Rise Skinny Jeans',3999,2999,120,15,1,'https://images.unsplash.com/photo-1541099649105-f69ad21f3246?w=800&q=80',8,2,NOW(),NOW()),
(47,'Adidas Originals Top','Adidas Originals Women''s Adicolor Classics Trefoil Hoodie',5999,4799,100,15,1,'https://images.unsplash.com/photo-1515886657613-9f3515b0c78f?w=800&q=80',8,2,NOW(),NOW()),
(48,'Mango Satin Blouse','Mango Women''s V-Neck Satin Finish Blouse',3490,2590,90,15,1,'https://images.unsplash.com/photo-1584998316204-3b1e3b1895ae?w=800&q=80',8,2,NOW(),NOW()),
(49,'Biba Anarkali Suit','Biba Women''s Rayon Printed Anarkali Salwar Suit',5995,4495,70,10,1,'https://images.unsplash.com/photo-1583391733956-3750e0ff4e8b?w=800&q=80',8,2,NOW(),NOW()),
(50,'FabIndia Silk Saree','FabIndia Women''s Tussar Silk Solid Saree - Gold',12000,9500,30,5,1,'https://images.unsplash.com/photo-1610030469915-9a88e470813d?w=800&q=80',8,2,NOW(),NOW()),
(51,'Forever 21 Bodycon','Forever 21 Women''s Ribbed Knit Bodycon Dress',2499,1899,150,20,1,'https://images.unsplash.com/photo-1595777457583-95e059d581b8?w=800&q=80',8,2,NOW(),NOW()),
(52,'Only Leather Jacket','ONLY Women''s Faux Leather Moto Biker Jacket',4999,3999,50,10,1,'https://images.unsplash.com/photo-1525507119028-ed4c629a60a3?w=800&q=80',8,2,NOW(),NOW()),
(53,'W Kurta Set','W Women''s Cotton Floral Printed Kurta Set',3599,2699,110,15,1,'https://images.unsplash.com/photo-1583391733956-3750e0ff4e8b?w=800&q=80',8,2,NOW(),NOW());

-- 9: Footwear
INSERT INTO products (product_id, name, description, mrp, selling_price, stock_quantity, threshold_quantity, is_active, image_url, category_id, seller_id, created_at, updated_at) VALUES
(54,'Nike Air Jordan 1','Nike Air Jordan 1 Retro High OG - Chicago Lost & Found',18995,17995,40,5,1,'https://m.media-amazon.com/images/I/71EzRGyfLgL._AC_UL1500_.jpg',9,2,NOW(),NOW()),
(55,'Adidas Ultraboost 22','Adidas Men''s Ultraboost 22 Road Running Shoes',17999,14399,100,15,1,'https://images.unsplash.com/photo-1551107696-a4b0c5a0d9a2?w=800&q=80',9,2,NOW(),NOW()),
(56,'Puma RS-X','Puma RS-X Reinvention Unisex Suede Sneakers',9999,7499,120,20,1,'https://images.unsplash.com/photo-1608231387042-66d1773070a5?w=800&q=80',9,2,NOW(),NOW()),
(57,'Converse Chuck Taylor','Converse Chuck Taylor All Star High Top Unisex Sneakers',4999,3999,250,30,1,'https://images.unsplash.com/photo-1595950653106-6c9ebd614d3a?w=800&q=80',9,2,NOW(),NOW()),
(58,'Vans Old Skool','Vans Unisex Old Skool Classic Skate Shoes',5999,4799,200,30,1,'https://images.unsplash.com/photo-1525966222134-fcfa99b8ae77?w=800&q=80',9,2,NOW(),NOW()),
(59,'Bata Leather Loafers','Bata Men''s Premium Leather Formal Loafers',2999,2399,150,25,1,'https://images.unsplash.com/photo-1533867617858-e7b97e060509?w=800&q=80',9,2,NOW(),NOW()),
(60,'Crocs Classic Clog','Crocs Unisex Classic Clogs - Black/White',3995,2995,300,50,1,'https://images.unsplash.com/photo-1603787081207-362bcef7c144?w=800&q=80',9,2,NOW(),NOW()),
(61,'Reebok Nano X3','Reebok Men''s Nano X3 Cross Training Shoes',10999,8249,80,10,1,'https://images.unsplash.com/photo-1541597473841-49603504334b?w=800&q=80',9,2,NOW(),NOW()),
(62,'New Balance 574','New Balance Unisex 574 Core Sneakers - Grey',8999,7649,110,15,1,'https://images.unsplash.com/photo-1539185441755-769473a23570?w=800&q=80',9,2,NOW(),NOW()),
(63,'Under Armour Curry 10','Under Armour Curry Flow 10 Basketball Shoes',14999,12749,40,5,1,'https://images.unsplash.com/photo-1542291026-7eec264c27ff?w=800&q=80',9,2,NOW(),NOW());

-- 11: Appliances
INSERT INTO products (product_id, name, description, mrp, selling_price, stock_quantity, threshold_quantity, is_active, image_url, category_id, seller_id, created_at, updated_at) VALUES
(64,'LG Side-by-Side Fridge','LG 655L Frost Free Inverter Side-by-Side Refrigerator',119990,89990,20,3,1,'https://rukminim2.flixcart.com/image/1600/2140/xif0q/refrigerator-new/x/6/f/-original-imagx6h7zmbbggfx.jpeg',11,2,NOW(),NOW()),
(65,'Samsung Washing Machine','Samsung 8kg Front Load AI Ecobubble Washing Machine',45900,36900,35,5,1,'https://m.media-amazon.com/images/I/71FfzqsfwlL._SL1500_.jpg',11,2,NOW(),NOW()),
(66,'Sony Bravia 4K TV','Sony Bravia 55 inch 4K Ultra HD Smart LED Google TV',84900,64990,40,5,1,'https://m.media-amazon.com/images/I/81Vs1ZXn43L._SL1500_.jpg',11,2,NOW(),NOW()),
(67,'Dyson V15 Detect','Dyson V15 Detect Cord-Free Vacuum Cleaner',55900,52900,25,3,1,'https://images.unsplash.com/photo-1527515637462-cff94eecc1ac?w=800&q=80',11,2,NOW(),NOW()),
(68,'Philips Air Fryer','Philips Digital Air Fryer with Touch Panel, 4.1L',12999,8999,100,10,1,'https://m.media-amazon.com/images/I/41Z5ldkAeYL._SL1000_.jpg',11,2,NOW(),NOW()),
(69,'Whirlpool Microwave','Whirlpool 25L Convection Microwave Oven',18900,14900,50,8,1,'https://images.unsplash.com/photo-1574269909862-7e1d70bb8078?w=800&q=80',11,2,NOW(),NOW()),
(70,'Kent RO Water Purifier','Kent Grand Plus RO+UV+UF+TDS Controller Water Purifier',19500,16500,60,10,1,'https://images.unsplash.com/photo-1584622781564-1d987f7333c1?w=800&q=80',11,2,NOW(),NOW()),
(71,'Blue Star 1.5 Ton AC','Blue Star 1.5 Ton 3 Star Inverter Split AC',52000,39990,30,5,1,'https://images.unsplash.com/photo-1594913785162-e6785b49dea3?w=800&q=80',11,2,NOW(),NOW());

-- 12: Furniture
INSERT INTO products (product_id, name, description, mrp, selling_price, stock_quantity, threshold_quantity, is_active, image_url, category_id, seller_id, created_at, updated_at) VALUES
(72,'IKEA Strandmon Wing Chair','IKEA Strandmon Wing Chair in Nordvalla Dark Grey',18990,16990,25,3,1,'https://m.media-amazon.com/images/I/51KhLDfGHaL._AC_UL1500_.jpg',12,2,NOW(),NOW()),
(73,'Urban Ladder L-Sofa','Urban Ladder Apollo L-Shaped Fabric Sofa Sectional',65000,54999,10,2,1,'https://images.unsplash.com/photo-1555041469-a586c61ea9bc?w=800&q=80',12,2,NOW(),NOW()),
(74,'Wakefit Queen Bed','Wakefit Jupiter Sheesham Wood Queen Size Bed',25000,18999,20,3,1,'https://images.unsplash.com/photo-1505691938895-1758d7eaa511?w=800&q=80',12,2,NOW(),NOW()),
(75,'Home Centre Dining Set','Home Centre Dining Table with 6 Chairs - Walnut Finish',45900,38900,15,2,1,'https://images.unsplash.com/photo-1530018607912-eff2df114f11?w=800&q=80',12,2,NOW(),NOW()),
(76,'Featherlite Office Chair','Featherlite Liberate High Back Ergonomic Mesh Chair',18000,14999,50,5,1,'https://images.unsplash.com/photo-1592078615290-033ee584e267?w=800&q=80',12,2,NOW(),NOW()),
(77,'Nilkamal Plastic Chair','Nilkamal Crystal Premium High Back Plastic Chair (Set of 4)',8000,5999,100,10,1,'https://images.unsplash.com/photo-1503602642458-232111445657?w=800&q=80',12,2,NOW(),NOW()),
(78,'Sleepyhead Memory Mattress','Sleepyhead Original- 3 Layered Orthopedic Memory Foam Mattress',15999,12999,60,10,1,'https://images.unsplash.com/photo-1584144445888-293e6a9ee865?w=800&q=80',12,2,NOW(),NOW()),
(79,'Godrej Steel Almirah','Godrej Interio Slimline 3 Door Steel Almirah',28000,24500,12,2,1,'https://images.unsplash.com/photo-1595428774223-ef52624120ec?w=800&q=80',12,2,NOW(),NOW());

-- 13: Beauty & Personal Care
INSERT INTO products (product_id, name, description, mrp, selling_price, stock_quantity, threshold_quantity, is_active, image_url, category_id, seller_id, created_at, updated_at) VALUES
(80,'Dior Sauvage','Dior Sauvage Eau de Parfum for Men - 100ml',12900,11900,40,5,1,'https://m.media-amazon.com/images/I/51BPsI71DBL._AC_UL1500_.jpg',13,2,NOW(),NOW()),
(81,'Estée Lauder Serum','Estée Lauder Advanced Night Repair Synchronized Recovery Complex',9500,8500,60,10,1,'https://images.unsplash.com/photo-1620916566398-39f1143ab7be?w=800&q=80',13,2,NOW(),NOW()),
(82,'MAC Matte Lipstick','MAC Retro Matte Lipstick - Ruby Woo',2200,1950,200,30,1,'https://images.unsplash.com/photo-1586776977607-310e9c725c37?w=800&q=80',13,2,NOW(),NOW()),
(83,'L''Oreal Hair Mask','L''Oreal Professionnel Absolut Repair Hair Mask',999,850,300,50,1,'https://images.unsplash.com/photo-1512496015851-a90fb38ba796?w=800&q=80',13,2,NOW(),NOW()),
(84,'Phillips Trimmer','Phillips Multigroom Series 7000 13-in-1 Face, Hair and Body Trimmer',4995,3995,150,20,1,'https://images.unsplash.com/photo-1621607512214-68297480165e?w=800&q=80',13,2,NOW(),NOW()),
(85,'Forest Essentials Cream','Forest Essentials Soundarya Radiance Cream with 24K Gold',5400,4900,45,5,1,'https://images.unsplash.com/photo-1594125350485-c558c89b674b?w=800&q=80',13,2,NOW(),NOW()),
(86,'Cetaphil Gentle Cleanser','Cetaphil Gentle Skin Cleanser for All Skin Types - 250ml',650,550,500,50,1,'https://images.unsplash.com/photo-1556228720-195a672e8a03?w=800&q=80',13,2,NOW(),NOW()),
(87,'The Body Shop Butter','The Body Shop Shea Body Butter - 200ml',1595,1295,120,15,1,'https://images.unsplash.com/photo-1610030014585-39d49486c9ec?w=800&q=80',13,2,NOW(),NOW());

-- 14: Books
INSERT INTO products (product_id, name, description, mrp, selling_price, stock_quantity, threshold_quantity, is_active, image_url, category_id, seller_id, created_at, updated_at) VALUES
(88,'The Alchemist','The Alchemist by Paulo Coelho - 25th Anniversary Edition',499,350,500,50,1,'https://images.unsplash.com/photo-1544947950-fa07a98d237f?w=800&q=80',14,2,NOW(),NOW()),
(89,'Atomic Habits','Atomic Habits by James Clear: Tiny Changes, Remarkable Results',699,499,400,50,1,'https://m.media-amazon.com/images/I/91bYsX41DVL._AC_UL1500_.jpg',14,2,NOW(),NOW()),
(90,'The Psychology of Money','The Psychology of Money by Morgan Housel: Timeless lessons on wealth',599,399,450,50,1,'https://images.unsplash.com/photo-1544947950-fa07a98d237f?w=800&q=80',14,2,NOW(),NOW()),
(91,'Sapiens','Sapiens: A Brief History of Humankind by Yuval Noah Harari',799,550,300,40,1,'https://images.unsplash.com/photo-1544947950-fa07a98d237f?w=800&q=80',14,2,NOW(),NOW()),
(92,'Harry Potter Box Set','Harry Potter Complete Collection (Books 1-7) Box Set',4999,3499,100,10,1,'https://images.unsplash.com/photo-1614613535308-eb5fbd3d2c17?w=800&q=80',14,2,NOW(),NOW()),
(93,'Ikigai','Ikigai: The Japanese Secret to a Long and Happy Life',550,399,350,40,1,'https://images.unsplash.com/photo-1544947950-fa07a98d237f?w=800&q=80',14,2,NOW(),NOW()),
(94,'Rich Dad Poor Dad','Rich Dad Poor Dad by Robert Kiyosaki - What the Rich Teach Their Kids',499,350,500,50,1,'https://images.unsplash.com/photo-1589829085413-56de8ae18c73?w=800&q=80',14,2,NOW(),NOW()),
(95,'Think and Grow Rich','Think and Grow Rich by Napoleon Hill: The Landmark Bestseller',350,250,600,60,1,'https://images.unsplash.com/photo-1544947950-fa07a98d237f?w=800&q=80',14,2,NOW(),NOW()),
(96,'Brief Answers to Big Questions','Brief Answers to Big Questions by Stephen Hawking',699,499,200,30,1,'https://images.unsplash.com/photo-1512820790803-83ca734da794?w=800&q=80',14,2,NOW(),NOW()),
(97,'Dune','Dune (Dune Chronicles, Book 1) by Frank Herbert',799,599,150,20,1,'https://images.unsplash.com/photo-1531988042231-d39a9cc12a9a?w=800&q=80',14,2,NOW(),NOW());

-- 15: Sports & Fitness
INSERT INTO products (product_id, name, description, mrp, selling_price, stock_quantity, threshold_quantity, is_active, image_url, category_id, seller_id, created_at, updated_at) VALUES
(98,'Nivia Football','Nivia Storm Football - Size 5 (Yellow/Blue)',1200,850,300,30,1,'https://m.media-amazon.com/images/I/413t41aFpJL._AC_UL1500_.jpg',15,2,NOW(),NOW()),
(99,'Spalding Basketball','Spalding NBA Street Outdoor Basketball - Size 7',2500,1899,150,20,1,'https://images.unsplash.com/photo-1519861531158-2863f4510ba4?w=800&q=80',15,2,NOW(),NOW()),
(100,'Adidas Cricket Bat','Adidas Incurza Cricket Bat - English Willow',15000,12999,50,5,1,'https://images.unsplash.com/photo-1531415074968-036ba1b575da?w=800&q=80',15,2,NOW(),NOW()),
(101,'Yonex Badminton Racket','Yonex Astrox 88D Play Badminton Racket with Full Cover',4990,3990,120,15,1,'https://images.unsplash.com/photo-1626225967045-2c8c0f56d78a?w=800&q=80',15,2,NOW(),NOW()),
(102,'Bowflex SelectTech 552','Bowflex SelectTech 552 Adjustable Dumbbells (Pair)',45000,39999,20,3,1,'https://images.unsplash.com/photo-1583454110551-21f2fa2ec617?w=800&q=80',15,2,NOW(),NOW()),
(103,'Manduka Yoga Mat','Manduka PRO Yoga Mat 6mm - Black Mat PRO',12000,9999,60,10,1,'https://images.unsplash.com/photo-1544367567-0f2fcb009e0b?w=800&q=80',15,2,NOW(),NOW()),
(104,'Speedo Goggles','Speedo Vanquisher 2.0 Mirrored Goggles - Smoke',2500,1999,200,30,1,'https://images.unsplash.com/photo-1530549387634-e797eb99f47e?w=800&q=80',15,2,NOW(),NOW()),
(105,'Nike Gym Gloves','Nike Ultimate Men''s Gym Gloves - Large Black',2200,1650,250,40,1,'https://images.unsplash.com/photo-1540206351-d6465b3ac5c1?w=800&q=80',15,2,NOW(),NOW()),
(106,'Decathlon Bicycle','Rockrider ST100 Mountain Bike (27.5", Grey)',19999,17499,30,5,1,'https://images.unsplash.com/photo-1485965120184-e220f721d03e?w=800&q=80',15,2,NOW(),NOW()),
(107,'Wilson Tennis Racket','Wilson Roger Federer Junior Tennis Racket',3500,2899,90,10,1,'https://images.unsplash.com/photo-1622279457486-62dcc473d05e?w=800&q=80',15,2,NOW(),NOW());

-- Additional Product Images (4-5 per product)
INSERT INTO product_images (product_id, image_url) VALUES
-- ID 2 (Samsung S24)
(2, 'https://rukminim1.flixcart.com/image/1600/2140/xif0q/mobile/j/m/z/-original-imahgfmxumntk7sy.jpeg?q=60'),
(2, 'https://rukminim1.flixcart.com/image/1600/2140/xif0q/mobile/5/c/x/-original-imahggevnsn9ubah.jpeg?q=60'),
(2, 'https://rukminim1.flixcart.com/image/1600/2140/xif0q/mobile/y/s/g/-original-imahgfmy2zgqvjmy.jpeg?q=60'),
(2, 'https://rukminim1.flixcart.com/image/1600/2140/xif0q/mobile/w/r/z/-original-imahgfmysgtszenh.jpeg?q=60'),
-- ID 3 (iPhone 15)
(3, 'https://rukminim1.flixcart.com/image/1600/2140/xif0q/mobile/z/4/r/-original-imagtc4g22rcatjg.jpeg?q=60'),
(3, 'https://rukminim1.flixcart.com/image/1600/2140/xif0q/mobile/r/t/r/-original-imagtc4gtzyretcs.jpeg?q=60'),
(3, 'https://rukminim1.flixcart.com/image/1600/2140/xif0q/mobile/d/m/n/-original-imagtc4gmpfhfzky.jpeg?q=60'),
(3, 'https://rukminim1.flixcart.com/image/1600/2140/xif0q/mobile/7/e/s/-original-imagtc3kknyq2b95.jpeg?q=60'),
-- ID 4 (Pixel 8)
(4, 'https://rukminim1.flixcart.com/image/1600/2140/xif0q/mobile/3/q/3/-original-imahegqhgnafpbzh.jpeg?q=60'),
(4, 'https://rukminim1.flixcart.com/image/1600/2140/xif0q/mobile/i/y/u/-original-imahegqhm57az8hu.jpeg?q=60'),
(4, 'https://rukminim1.flixcart.com/image/1600/2140/xif0q/mobile/n/a/n/-original-imahegqh8xafftfa.jpeg?q=60'),
(4, 'https://rukminim1.flixcart.com/image/1600/2140/xif0q/mobile/t/s/u/-original-imahegqhghhfgpcf.jpeg?q=60'),
-- ID 9 (Motorola Edge 50 Pro) - FIXING BROKEN IMAGE
(9, 'https://rukminim1.flixcart.com/image/1600/2140/xif0q/mobile/g/i/n/-original-imagzhspjy5g8nh3.jpeg?q=60'),
(9, 'https://rukminim1.flixcart.com/image/1600/2140/xif0q/mobile/j/u/7/-original-imagzhspnmqcy7qk.jpeg?q=60'),
(9, 'https://rukminim1.flixcart.com/image/1600/2140/xif0q/mobile/z/u/z/-original-imagzhspkzhzgcpb.jpeg?q=60'),
(9, 'https://rukminim1.flixcart.com/image/1600/2140/xif0q/mobile/e/i/v/-original-imagzhspm6zvfaeh.jpeg?q=60'),
-- ID 10 (MacBook Air)
(10, 'https://rukminim1.flixcart.com/image/1600/2140/xif0q/computer/a/q/h/-original-imagypv6prbgkfzg.jpeg?q=60'),
(10, 'https://rukminim1.flixcart.com/image/1600/2140/xif0q/computer/d/0/t/-original-imagypv6wzxgag4f.jpeg?q=60'),
(10, 'https://rukminim1.flixcart.com/image/1600/2140/xif0q/computer/x/z/r/-original-imagypv6wdbpqysj.jpeg?q=60'),
(10, 'https://rukminim1.flixcart.com/image/1600/2140/xif0q/computer/1/n/p/-original-imagypv6mgewjynr.jpeg?q=60'),
-- ID 18 (Sony WH-XM5)
(18, 'https://rukminim1.flixcart.com/image/1600/2140/xif0q/headphone/v/d/g/-original-imahgr295uvptwq7.jpeg?q=60'),
(18, 'https://rukminim1.flixcart.com/image/1600/2140/xif0q/headphone/w/q/w/-original-imahgr296huaxwty.jpeg?q=60'),
(18, 'https://rukminim1.flixcart.com/image/1600/2140/xif0q/headphone/m/9/r/-original-imahgr29snkwgqqn.jpeg?q=60'),
(18, 'https://rukminim1.flixcart.com/image/1600/2140/xif0q/headphone/c/r/m/-original-imahgr29jghr6wqd.jpeg?q=60'),
-- ID 54 (Air Jordan)
(54, 'https://m.media-amazon.com/images/I/71EzRGyfLgL._AC_UL1500_.jpg'),
(54, 'https://m.media-amazon.com/images/I/71CZoaI19aL._AC_UL1500_.jpg'),
(54, 'https://m.media-amazon.com/images/I/71Xm0+7FfKL._AC_UL1500_.jpg'),
(54, 'https://m.media-amazon.com/images/I/71CiRMWQDxL._AC_UL1500_.jpg'),
-- ID 64 (LG Fridge)
(64, 'https://rukminim2.flixcart.com/image/1600/2140/xif0q/refrigerator-new/x/6/f/-original-imagx6h7zmbbggfx.jpeg'),
(64, 'https://rukminim2.flixcart.com/image/1600/2140/xif0q/refrigerator-new/7/2/t/-original-imagpfqjzgesrk5v.jpeg'),
(64, 'https://rukminim2.flixcart.com/image/1600/2140/xif0q/refrigerator-new/2/m/b/-original-imagv2z9y8fmry3w.jpeg'),
(64, 'https://rukminim2.flixcart.com/image/1600/2140/xif0q/refrigerator-new/j/3/x/-original-imagv2z9s84eqc5g.jpeg'),
-- ID 65 (Samsung Wash)
(65, 'https://m.media-amazon.com/images/I/71FfzqsfwlL._SL1500_.jpg'),
(65, 'https://m.media-amazon.com/images/I/71pKoDnoiuL.jpg'),
(65, 'https://m.media-amazon.com/images/I/61gAyLV4tBL.jpg'),
-- ID 72 (IKEA Chair)
(72, 'https://m.media-amazon.com/images/I/51KhLDfGHaL._AC_UL1500_.jpg'),
(72, 'https://m.media-amazon.com/images/I/41MrR9tYarL._AC_UL1500_.jpg'),
(72, 'https://m.media-amazon.com/images/I/41Ls6u04V-L._AC_UL1500_.jpg'),
-- ID 80 (Dior Sauvage)
(80, 'https://m.media-amazon.com/images/I/51BPsI71DBL._AC_UL1500_.jpg'),
(80, 'https://m.media-amazon.com/images/I/71Dbh8Sdq2L._AC_UL1500_.jpg'),
(80, 'https://m.media-amazon.com/images/I/51h804phoFL._AC_UL1500_.jpg'),
-- ID 89 (Atomic Habits)
(89, 'https://m.media-amazon.com/images/I/91bYsX41DVL._AC_UL1500_.jpg'),
(89, 'https://m.media-amazon.com/images/I/419waaL8WgL._AC_UL1500_.jpg'),
-- ID 98 (Nivia Football)
(98, 'https://m.media-amazon.com/images/I/413t41aFpJL._AC_UL1500_.jpg'),
(98, 'https://m.media-amazon.com/images/I/51qMOqpgapL._AC_UL1500_.jpg');

-- Attributes (Comprehensive JSON for better comparison)
-- Mobiles
UPDATE products SET attributes = '{"brand": "Samsung", "color": "Titanium Gray", "display": "6.8 inch OLED", "processor": "Snapdragon 8 Gen 3", "ram": "12GB"}' WHERE product_id = 2;
UPDATE products SET attributes = '{"brand": "Apple", "color": "Natural Titanium", "display": "6.1 inch OLED", "chip": "A17 Pro", "ram": "8GB"}' WHERE product_id = 3;
UPDATE products SET attributes = '{"brand": "Google", "color": "Bay", "display": "6.7 inch OLED", "chip": "Tensor G3", "ram": "12GB"}' WHERE product_id = 4;
UPDATE products SET attributes = '{"brand": "Motorola", "color": "Luxe Lavender", "display": "6.7 inch OLED", "processor": "Snapdragon 7 Gen 3", "ram": "12GB"}' WHERE product_id = 9;
UPDATE products SET attributes = '{"brand": "Levi''s", "style": "Slim Fit", "color": "Rigid Dragon", "material": "99% Cotton, 1% Elastane"}' WHERE product_id = 34;
UPDATE products SET attributes = '{"brand": "Nike", "type": "Full-Zip Hoodie", "material": "Tech Fleece", "color": "Grey"}' WHERE product_id = 35;
UPDATE products SET attributes = '{"brand": "Zara", "type": "Midi Dress", "pattern": "Floral", "material": "Viscose"}' WHERE product_id = 44;
UPDATE products SET attributes = '{"brand": "Nike", "model": "Air Jordan 1", "color": "Lost & Found", "material": "Leather"}' WHERE product_id = 54;
UPDATE products SET attributes = '{"brand": "LG", "capacity": "655L", "type": "Side-by-Side", "inverter": "Yes"}' WHERE product_id = 64;
UPDATE products SET attributes = '{"brand": "Samsung", "capacity": "8kg", "type": "Front Load", "AI": "Ecobubble"}' WHERE product_id = 65;
UPDATE products SET attributes = '{"brand": "Sony", "screen_size": "55 inch", "resolution": "4K Ultra HD", "smart_tv": "Google TV"}' WHERE product_id = 66;
UPDATE products SET attributes = '{"brand": "Philips", "capacity": "4.1L", "control": "Touch Panel", "tech": "Rapid Air"}' WHERE product_id = 68;
UPDATE products SET attributes = '{"brand": "IKEA", "model": "Strandmon", "color": "Dark Grey", "material": "Fabric"}' WHERE product_id = 72;
UPDATE products SET attributes = '{"brand": "Dior", "type": "Eau de Parfum", "size": "100ml", "gender": "Men"}' WHERE product_id = 80;
UPDATE products SET attributes = '{"author": "James Clear", "format": "Hardcover", "pages": "320", "genre": "Self-help"}' WHERE product_id = 89;
UPDATE products SET attributes = '{"brand": "Nivia", "size": "5", "material": "TPE", "ideal_for": "Training"}' WHERE product_id = 98;

-- Laptops
UPDATE products SET attributes = '{"brand": "Apple", "processor": "M3", "ram": "8GB", "storage": "256GB SSD", "display": "13.6 inch Retina"}' WHERE product_id = 10;
UPDATE products SET attributes = '{"brand": "Dell", "processor": "Core Ultra 7", "ram": "16GB", "storage": "512GB SSD", "display": "13.4 inch FHD+"}' WHERE product_id = 11;
UPDATE products SET attributes = '{"brand": "HP", "processor": "Core Ultra 7", "ram": "16GB", "storage": "1TB SSD", "display": "14 inch OLED Touch"}' WHERE product_id = 12;
UPDATE products SET attributes = '{"brand": "ASUS", "processor": "Core Ultra 5", "ram": "16GB", "storage": "1TB SSD", "display": "14 inch OLED"}' WHERE product_id = 13;
UPDATE products SET attributes = '{"brand": "Lenovo", "processor": "Core i7-1355U", "ram": "32GB", "storage": "1TB SSD", "display": "14 inch WUXGA"}' WHERE product_id = 14;
UPDATE products SET attributes = '{"brand": "Acer", "processor": "Core i7-13700HX", "ram": "16GB", "storage": "1TB SSD", "gpu": "RTX 4060"}' WHERE product_id = 15;
UPDATE products SET attributes = '{"brand": "Microsoft", "processor": "Core i5", "ram": "8GB", "storage": "256GB SSD", "display": "13.5 inch PixelSense"}' WHERE product_id = 16;
UPDATE products SET attributes = '{"brand": "Razer", "processor": "Core i7-12800H", "ram": "16GB", "storage": "1TB SSD", "gpu": "RTX 3070 Ti"}' WHERE product_id = 17;

-- Audio
UPDATE products SET attributes = '{"brand": "Sony", "type": "Over-Ear", "noise_cancelling": "Yes", "battery_life": "30 hrs"}' WHERE product_id = 18;
UPDATE products SET attributes = '{"brand": "Bose", "type": "Over-Ear", "noise_cancelling": "Yes", "battery_life": "24 hrs"}' WHERE product_id = 19;
UPDATE products SET attributes = '{"brand": "Apple", "type": "In-Ear", "noise_cancelling": "Yes", "battery_life": "6 hrs"}' WHERE product_id = 20;
UPDATE products SET attributes = '{"brand": "Sennheiser", "type": "Over-Ear", "noise_cancelling": "Yes", "battery_life": "60 hrs"}' WHERE product_id = 21;

-- Default attributes for others
UPDATE products SET attributes = '{"brand": "Generic", "material": "High Quality"}' WHERE attributes IS NULL AND product_id > 1;
