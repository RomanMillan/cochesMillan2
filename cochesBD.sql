CREATE USER 'millan'@'%' IDENTIFIED by 'roman';
CREATE DATABASE IF NOT EXISTS `coches`;
GRANT ALL PRIVILEGES ON `millan`.* TO 'millan'@'%';

CREATE DATABASE coches;

CREATE TABLE coches.userDB( 
	id int(4) AUTO_INCREMENT, 
	user VARCHAR(32), 
	password VARCHAR(32), 
	name VARCHAR(32), 
	surname VARCHAR(32), 
	gender BOOLEAN, 
	birthday DATE, 
	administrator BOOLEAN, 
	CONSTRAINT PK_userDB PRIMARY KEY(id) 
);

CREATE TABLE coches.category(
	id int(4) AUTO_INCREMENT,
	name VARCHAR(32) unique,
	description VARCHAR(100),
	CONSTRAINT PK_category PRIMARY KEY(id)
);

CREATE TABLE coches.elementDB(
	id int(4) AUTO_INCREMENT,
	name VARCHAR(32) unique,
	description VARCHAR(100),
	price int(10),
	id_category int(4),
	CONSTRAINT PK_elementDB PRIMARY KEY(id),
	CONSTRAINT FK_elementDB FOREIGN KEY(id_category) REFERENCES category(id)
);

CREATE TABLE coches.purchase(
	amount int(4),
	price int(12),
	puerchase_date datetime,
	id_element int(4),
	id_user int(4),
	CONSTRAINT PK_purchase PRIMARY KEY (id_element, id_user, puerchase_date),
	CONSTRAINT FK_purchase_element FOREIGN KEY(id_element) REFERENCES elementDB(id),
	CONSTRAINT FK_purchase_user FOREIGN KEY(id_user) REFERENCES userDB(id)
);

insert into coches.category (id, name, description) values (1, 'Subaru', 'penatibus et magnis dis parturient montes');
insert into coches.category (id, name, description) values (2, 'Mazda', 'massa id lobortis convallis tortor risus');
insert into coches.category (id, name, description) values (3, 'BMW', 'justo lacinia eget tincidunt eget tempus vel pede morbi');
insert into coches.category (id, name, description) values (4, 'Honda', 'orci luctus et ultrices posuere cubilia curae nulla');
insert into coches.category (id, name, description) values (5, 'Seat', 'vehicula consequat morbi a ipsum integer a nibh in quis justo maecenas');
insert into coches.category (id, name, description) values (6, 'Suzuki', 'est donec odio justo sollicitudin ut suscipit a feugiat et');
insert into coches.category (id, name, description) values (7, 'Ds', 'vel pede morbi porttitor lorem id ligula suspendisse ornare consequat');
insert into coches.category (id, name, description) values (8, 'Kia', 'phasellus id sapien in sapien iaculis congue vivamus metus');
insert into coches.category (id, name, description) values (9, 'Volkswagen', 'quis justo maecenas rhoncus aliquam lacus morbi quis');
insert into coches.category (id, name, description) values (10, 'Ssangyong', 'mauris viverra diam vitae quam suspendisse potenti');
insert into coches.category (id, name, description) values (11, 'Renault', 'nonummy integer non velit donec diam neque vestibulum eget');
insert into coches.category (id, name, description) values (12, 'Audi', 'erat nulla tempus vivamus in felis eu sapien cursus');
insert into coches.category (id, name, description) values (13, 'Ford', 'sapien arcu sed augue aliquam erat');
insert into coches.category (id, name, description) values (14, 'Jeep', 'parturient montes nascetur ridiculus mus vivamus');
insert into coches.category (id, name, description) values (15, 'Mercedes', 'lobortis sapien sapien non mi integer');
insert into coches.category (id, name, description) values (16, 'Peugeot', 'id turpis integer aliquet massa');
insert into coches.category (id, name, description) values (17, 'Toyota', 'amet sapien dignissim vestibulum vestibulum ante ipsum');



insert into coches.elementDB (id, name, description, price, id_category) values (1, 'Cougar', 'rhoncus mauris enim leo rhoncus sed vestibulum', 172998, 2);
insert into coches.elementDB (id, name, description, price, id_category) values (2, 'Corolla', 'augue vestibulum ante ipsum primis', 144029, 1);
insert into coches.elementDB (id, name, description, price, id_category) values (3, 'GranTurismo', 'cras pellentesque volutpat dui maecenas tristique est et', 97759, 13);
insert into coches.elementDB (id, name, description, price, id_category) values (4, 'M-Class', 'lectus in quam fringilla rhoncus', 48967, 9);
insert into coches.elementDB (id, name, description, price, id_category) values (5, 'VUE', 'morbi odio odio elementum eu interdum', 20821, 8);
insert into coches.elementDB (id, name, description, price, id_category) values (6, '745', 'in hac habitasse platea dictumst', 91511, 13);
insert into coches.elementDB (id, name, description, price, id_category) values (7, 'Fiesta', 'cras mi pede malesuada in imperdiet et commodo', 193665, 1);
insert into coches.elementDB (id, name, description, price, id_category) values (8, 'Sierra 2500', 'ligula nec sem duis aliquam', 40668, 11);
insert into coches.elementDB (id, name, description, price, id_category) values (9, 'Forester', 'orci luctus et ultrices posuere', 198959, 1);
insert into coches.elementDB (id, name, description, price, id_category) values (10, 'CL-Class', 'ultrices posuere cubilia curae duis faucibus accumsan odio', 92928, 10);
insert into coches.elementDB (id, name, description, price, id_category) values (11, 'Town Car', 'neque vestibulum eget vulputate ut ultrices vel', 147186, 15);
insert into coches.elementDB (id, name, description, price, id_category) values (12, 'Monte Carlo', 'mus etiam vel augue vestibulum rutrum rutrum', 183689, 5);
insert into coches.elementDB (id, name, description, price, id_category) values (13, 'TrailBlazer', 'ac diam cras pellentesque volutpat dui maecenas', 28751, 11);
insert into coches.elementDB (id, name, description, price, id_category) values (14, 'Tacoma Xtra', 'massa volutpat convallis morbi odio odio', 21150, 12);
insert into coches.elementDB (id, name, description, price, id_category) values (15, 'SVX', 'vivamus in felis eu sapien cursus vestibulum', 100045, 4);
insert into coches.elementDB (id, name, description, price, id_category) values (16, 'Cabriolet', 'nullam porttitor lacus at turpis donec', 43123, 7);
insert into coches.elementDB (id, name, description, price, id_category) values (17, 'Sky', 'dictumst etiam faucibus cursus urna ut tellus nulla', 115044, 14);
insert into coches.elementDB (id, name, description, price, id_category) values (18, 'Cobalt', 'eget eleifend luctus ultricies eu nibh quisque id', 59841, 10);
insert into coches.elementDB (id, name, description, price, id_category) values (19, 'Reliant', 'in hac habitasse platea dictumst etiam faucibus', 103208, 4);
insert into coches.elementDB (id, name, description, price, id_category) values (20, 'Camry', 'sem mauris laoreet ut rhoncus aliquet pulvinar', 84092, 8);
insert into coches.elementDB (id, name, description, price, id_category) values (21, 'Econoline E250', 'nam nulla integer pede justo lacinia eget', 81353, 16);
insert into coches.elementDB (id, name, description, price, id_category) values (22, 'Escalade', 'justo in hac habitasse platea dictumst', 51804, 3);
insert into coches.elementDB (id, name, description, price, id_category) values (23, 'F250', 'luctus rutrum nulla tellus in sagittis dui', 84114, 4);
insert into coches.elementDB (id, name, description, price, id_category) values (24, 'Esprit', 'interdum in ante vestibulum ante ipsum', 181967, 8);
insert into coches.elementDB (id, name, description, price, id_category) values (25, 'STS', 'pellentesque volutpat dui maecenas tristique', 33194, 3);
insert into coches.elementDB (id, name, description, price, id_category) values (26, 'Arnage', 'habitasse platea dictumst morbi vestibulum velit id', 51648, 2);
insert into coches.elementDB (id, name, description, price, id_category) values (27, 'PT Cruiser', 'vulputate ut ultrices vel augue', 122548, 12);
insert into coches.elementDB (id, name, description, price, id_category) values (28, 'Aztek', 'mi in porttitor pede justo eu massa donec', 16423, 15);
insert into coches.elementDB (id, name, description, price, id_category) values (29, 'Veracruz', 'sollicitudin mi sit amet lobortis sapien sapien', 96411, 11);
insert into coches.elementDB (id, name, description, price, id_category) values (30, 'LR3', 'justo sollicitudin ut suscipit a', 175688, 7);
insert into coches.elementDB (id, name, description, price, id_category) values (31, 'Galaxie', 'et ultrices posuere cubilia curae nulla dapibus', 56735, 4);
insert into coches.elementDB (id, name, description, price, id_category) values (32, 'Challenger', 'mi nulla ac enim in tempor turpis', 132350, 14);
insert into coches.elementDB (id, name, description, price, id_category) values (33, 'FJ Cruiser', 'massa id lobortis convallis tortor risus dapibus augue', 188627, 17);
insert into coches.elementDB (id, name, description, price, id_category) values (34, '430', 'eu orci mauris lacinia sapien quis libero nullam', 70319, 4);
insert into coches.elementDB (id, name, description, price, id_category) values (35, 'Dyy', 'tellus semper interdum mauris ullamcorper', 191405, 16);
insert into coches.elementDB (id, name, description, price, id_category) values (36, 'Eldorado', 'ipsum primis in faucibus orci luctus et ultrices', 61608, 4);
insert into coches.elementDB (id, name, description, price, id_category) values (37, 'RX-7', 'nulla neque libero convallis eget eleifend luctus ultricies', 108258, 16);
insert into coches.elementDB (id, name, description, price, id_category) values (38, 'Bonneville', 'magna vulputate luctus cum sociis natoque penatibus', 49440, 17);
insert into coches.elementDB (id, name, description, price, id_category) values (39, 'C30', 'odio elementum eu interdum eu tincidunt', 130973, 9);
insert into coches.elementDB (id, name, description, price, id_category) values (40, 'IS-F', 'volutpat sapien arcu sed augue aliquam', 42293, 9);
insert into coches.elementDB (id, name, description, price, id_category) values (41, 'Fortesque', 'pharetra magna ac consequat metus sapien', 97601, 16);
insert into coches.elementDB (id, name, description, price, id_category) values (42, 'Montana', 'at lorem integer tincidunt ante', 97430, 2);
insert into coches.elementDB (id, name, description, price, id_category) values (43, 'Elise', 'dui proin leo odio porttitor', 187070, 9);
insert into coches.elementDB (id, name, description, price, id_category) values (44, 'Savana 1500', 'donec ut mauris eget massa', 29954, 16);
insert into coches.elementDB (id, name, description, price, id_category) values (45, 'Tana 100', 'quam a odio in hac habitasse', 82251, 6);
insert into coches.elementDB (id, name, description, price, id_category) values (46, 'GS', 'ante nulla justo aliquam quis turpis', 29308, 10);
insert into coches.elementDB (id, name, description, price, id_category) values (47, 'Regal', 'quis libero nullam sit amet turpis elementum', 146911, 11);
insert into coches.elementDB (id, name, description, price, id_category) values (48, 'Navajo', 'arcu sed augue aliquam erat volutpat in', 120682, 7);
insert into coches.elementDB (id, name, description, price, id_category) values (49, 'Avalon', 'lectus aliquam sit amet diam in magna', 166951, 3);
insert into coches.elementDB (id, name, description, price, id_category) values (50, 'Cooper', 'eros viverra eget congue eget semper rutrum', 48721, 4);

