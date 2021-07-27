CREATE TABLE orders
(
    id              BIGINT AUTO_INCREMENT PRIMARY KEY,
    client_username VARCHAR(100) NOT NULL,
    address_from    VARCHAR(100) NOT NULL,
    address_to      VARCHAR(100) NOT NULL,
    driver_username VARCHAR(100),
    status          VARCHAR(100) NOT NULL
);


