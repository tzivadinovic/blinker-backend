create table category
(
   category_id          int auto_increment primary key,
   name                 varchar(32)
);

create table city
(
   city_id              int auto_increment primary key,
   city                 varchar(32),
   zipcode              varchar(32)
);

create table currency
(
   currency_id          int auto_increment primary key,
   currency             varchar(32)
);

create table state
(
   state_id             int auto_increment primary key,
   name                 varchar(32)
);

create table customer
(
   customer_id          int auto_increment primary key,
   state_id             int not null,
   city_id              int not null,
   name                 varchar(32)
);

create table user
(
   user_id              int auto_increment primary key,
   employee_id          int not null,
   username             varchar(64),
   password             varchar(64)
);

create table employee
(
   employee_id          int auto_increment primary key,
   user_id              int,
   first_name           varchar(32),
   last_name            varchar(32),
   position             varchar(64),
   bank                 varchar(64),
   bank_account         varchar(64),
   phone_number         varchar(16),
   address              varchar(128),
   employment_start_date date,
   employment_end_date  date
);

create table transport_term
(
   transport_term_id    int auto_increment primary key,
   term                 varchar(64)
);

create table invoice_details
(
   invoice_detail_id    int auto_increment primary key,
   transport_term_id    int not null,
   currency_id          int not null,
   employee_id          int not null,
   invoice_id           int not null,
   customer_id          int not null,
   number               varchar(16),
   date                 date,
   payment_conditions   varchar(32),
   box_number           int,
   total_boxes          int,
   remarks              varchar(32),
   gross_weight         decimal,
   net_weight           decimal,
   shipping_fees        decimal,
   total_price          decimal,
   items_info           text
);

create table invoice
(
   invoice_id           int auto_increment primary key,
   invoice_detail_id    int null
);

create table product
(
   product_id           int auto_increment primary key,
   category_id          int,
   code                 varchar(32),
   name                 varchar(32),
   description          text,
   price                decimal
);

create table product_invoice
(
   product_invoice_id   int auto_increment primary key,
   invoice_id           int,
   product_id           int,
   quantity             int
);

