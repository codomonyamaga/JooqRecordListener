DROP TABLE IF EXISTS orders;
DROP TYPE IF EXISTS order_status;

CREATE TYPE order_status AS ENUM ('UNAPPROVED', 'APPROVED');

create table orders (
                           id int NOT NULL,
                           name varchar(100) NOT NULL,
                           status order_status NOT NULL,
                           primary key (id)
);