-- Create CustomerOrder table
CREATE TABLE IF NOT EXISTS CustomerOrder (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    customer_email VARCHAR(255),
    customer_address VARCHAR(255),
    order_date DATE,
    delivery_status VARCHAR(50)
);

-- Create OrderItem table
CREATE TABLE IF NOT EXISTS OrderItem (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    customer_order_id BIGINT,
    product_id BIGINT,
    quantity INT,
    product_price DECIMAL(10, 2),
    CONSTRAINT fk_customer_order
        FOREIGN KEY (customer_order_id)
        REFERENCES CustomerOrder(id)
);

-- Insert data into CustomerOrder table
INSERT INTO CustomerOrder (id, customer_email, customer_address, order_date, delivery_status)
VALUES
(1, 'customer1@example.com', '123 Main St', '2023-01-01', 'Pending'),
(2, 'customer2@example.com', '456 Elm St', '2023-02-01', 'Pending');

-- Insert data into OrderItem table
INSERT INTO OrderItem (id, customer_order_id, product_id, quantity, product_price)
VALUES
(1, 1, 101, 2, 10.00),
(2, 1, 102, 1, 20.00),
(3, 2, 103, 5, 5.00);
