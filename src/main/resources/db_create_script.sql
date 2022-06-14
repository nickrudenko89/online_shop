CREATE SCHEMA `online_shop` ;
CREATE TABLE `online_shop`.`products` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `category` VARCHAR(45) NOT NULL,
  `subcategory` VARCHAR(45) NOT NULL,
  `brand` VARCHAR(45) NOT NULL,
  `model` VARCHAR(45) NOT NULL,
  `amount` SMALLINT UNSIGNED NOT NULL,
  `price` DECIMAL UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE);
  
CREATE TABLE `online_shop`.`users` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(45) NOT NULL,
  `password` BINARY(60) NOT NULL,
  `name` VARCHAR(20) NOT NULL,
  `surname` VARCHAR(45) NULL,
  `birthdate` DATE NULL,
  `phone_number` VARCHAR(20) NULL,
  `role` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE);
  
CREATE TABLE `online_shop`.`cart` (
  `id` INT UNSIGNED NOT NULL,
  `total_products_amount` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE);

CREATE TABLE `online_shop`.`cart_items` (
  `cart_id` INT UNSIGNED NOT NULL,
  `product_id` INT UNSIGNED NOT NULL,
  `product_amount` SMALLINT UNSIGNED NOT NULL,
  PRIMARY KEY (`cart_id`, `product_id`));

CREATE TABLE `online_shop`.`orders` (
  `order_number` VARCHAR(150) NOT NULL,
  `user_id` INT UNSIGNED NOT NULL,
  `date` DATETIME NOT NULL,
  `address` VARCHAR(100) NOT NULL,
  `total_cost` SMALLINT UNSIGNED NOT NULL,
  PRIMARY KEY (`order_number`),
  UNIQUE INDEX `order_number_UNIQUE` (`order_number` ASC) VISIBLE);

CREATE TABLE `online_shop`.`ordered_products` (
  `order_number` VARCHAR(150) NOT NULL,
  `brand` VARCHAR(45) NOT NULL,
  `model` VARCHAR(45) NOT NULL,
  `amount` SMALLINT UNSIGNED NOT NULL,
  `price` DECIMAL UNSIGNED NOT NULL,
  PRIMARY KEY (`order_number`, `brand`, `model`));
