drop table if exists users;
drop table if exists menu_dishes;
drop table if exists dish_ingredients;
drop table if exists menus;
drop table if exists dishes;
drop table if exists ingredients;


-- users (id, username, first_name, last_name, password)

create table users (
  id              integer auto_increment,
  username        VARCHAR(255),
  first_name      varchar(255),
  last_name       varchar(255),
  password        varchar(255),
  primary key(id)
);

-- syntax for auto_increment, must include field names to skip providing id
insert into users (username, first_name, last_name, password)
values ('admin', 'Jane', 'Doe', 'password');
insert into users (username, first_name, last_name, password)
values ('david','David', 'Doe', '12345');

-- menus (id, name)

CREATE TABLE menus(
  id              INTEGER AUTO_INCREMENT,
  name            VARCHAR(255),
  PRIMARY KEY(id)
);

INSERT INTO menus (name) VALUES ('appetizers');
INSERT INTO menus (name) VALUES ('dinner menu');
INSERT INTO menus (name) VALUES ('desserts');

-- dishes (id, name)

CREATE TABLE dishes (
  id              INTEGER AUTO_INCREMENT,
  name            VARCHAR(255),
  PRIMARY KEY (id)
);

INSERT INTO dishes (name) VALUES ('Salad');
INSERT INTO dishes (name) VALUES ('Fettuccine Alfredo');
INSERT INTO dishes (name) VALUES ('Grilled Chicken Breasts');
INSERT INTO dishes (name) VALUES ('Tiramisu');
-- INSERT INTO dishes (name) VALUES ('Creme Brulee');
-- INSERT INTO dishes (name) VALUES ('Spaghetti with Meat Sauce');

-- ingredients (id, name, price)

CREATE TABLE ingredients(
  id              INTEGER AUTO_INCREMENT,
  name            VARCHAR(255),
  price           DOUBLE,
  PRIMARY KEY (id)
);

INSERT INTO ingredients (name, price) VALUES ('garlic', 1.5);
INSERT INTO ingredients (name, price) VALUES ('cheese', 5);
INSERT INTO ingredients (name, price) VALUES ('cream', 3);
INSERT INTO ingredients (name, price) VALUES ('chocolate', 6);
INSERT INTO ingredients (name, price) VALUES ('fettuccine', 2);
INSERT INTO ingredients (name, price) VALUES ('spaghetti', 2);
INSERT INTO ingredients (name, price) VALUES ('chicken breasts', 10);
INSERT INTO ingredients (name, price) VALUES ('meat balls', 3);
INSERT into ingredients (name, price) VALUES ('sugar', 2);
INSERT INTO ingredients (name, price) VALUES ('salt', 2);
INSERT INTO ingredients (name, price) VALUES ('eggs', 2);
INSERT INTO ingredients (name, price) VALUES ('milk', 2);
INSERT INTO ingredients (name, price) VALUES ('onions', 2);
INSERT INTO ingredients (name, price) VALUES ('coffee', 5);
INSERT INTO ingredients (name, price) VALUES ('tomatoes', 2);
INSERT INTO ingredients (name, price) VALUES ('lettuce', 2);
INSERT INTO ingredients (name, price) VALUES ('lemon', 3);
INSERT INTO ingredients (name, price) VALUES ('pepper', 1);

-- menu_dishes (menu_id, dish_id)

CREATE TABLE menu_dishes (
  menu_id         INTEGER REFERENCES menus(id),
  dish_id         INTEGER REFERENCES dishes(id),
  FOREIGN KEY (menu_id) REFERENCES menus(id),
  FOREIGN KEY (dish_id) REFERENCES dishes(id) on delete cascade
);

INSERT INTO menu_dishes (menu_id, dish_id) VALUES (1, 1);
INSERT INTO menu_dishes (menu_id, dish_id) VALUES (2, 2);
INSERT INTO menu_dishes (menu_id, dish_id) VALUES (2, 3);
INSERT INTO menu_dishes (menu_id, dish_id) VALUES (3, 4);
-- INSERT INTO menu_dishes (menu_id, dish_id) VALUES (3, 5);

-- dish_ingredients(dish_id, ingredient_id, quantity)

CREATE TABLE dish_ingredients (
  dish_id         INTEGER REFERENCES dishes(id),
  ingredient_id   INTEGER REFERENCES ingredients(id),
  quantity        DOUBLE,
  FOREIGN KEY (dish_id) REFERENCES dishes(id) on delete cascade,
  FOREIGN KEY (ingredient_id) REFERENCES ingredients(id)
);

INSERT INTO dish_ingredients (dish_id, ingredient_id, quantity)
    VALUES (1, 16, 1);
INSERT INTO dish_ingredients (dish_id, ingredient_id, quantity)
    VALUES (1, 15, 1);
INSERT INTO dish_ingredients (dish_id, ingredient_id, quantity)
    VALUES (1, 13, 1);
INSERT INTO dish_ingredients (dish_id, ingredient_id, quantity)
    VALUES (1, 7, 1);
INSERT INTO dish_ingredients (dish_id, ingredient_id, quantity)
    VALUES (2, 1, 2);
INSERT INTO dish_ingredients (dish_id, ingredient_id, quantity)
    VALUES (2, 2, 3.4);
INSERT INTO dish_ingredients (dish_id, ingredient_id, quantity)
    VALUES (2, 3, 3.0);
INSERT INTO dish_ingredients (dish_id, ingredient_id, quantity)
    VALUES (2, 5, 4);
INSERT INTO dish_ingredients (dish_id, ingredient_id, quantity)
    VALUES (3, 7, 2);
INSERT INTO dish_ingredients (dish_id, ingredient_id, quantity)
    VALUES (3, 10, 4);
INSERT INTO dish_ingredients (dish_id, ingredient_id, quantity)
    VALUES (3, 17, 4);
INSERT INTO dish_ingredients (dish_id, ingredient_id, quantity)
    VALUES (3, 18, 4);
INSERT INTO dish_ingredients (dish_id, ingredient_id, quantity)
    VALUES (4, 3, 2);
INSERT INTO dish_ingredients (dish_id, ingredient_id, quantity)
    VALUES (4, 4, 1);
INSERT INTO dish_ingredients (dish_id, ingredient_id, quantity)
    VALUES (4, 9, 2);
INSERT INTO dish_ingredients (dish_id, ingredient_id, quantity)
    VALUES (4, 11, 1);
INSERT INTO dish_ingredients (dish_id, ingredient_id, quantity)
    VALUES (4, 14, 1);
