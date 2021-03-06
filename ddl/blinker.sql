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
   name                 varchar(32),
   constraint fk_state_customer foreign key (state_id)
      references state (state_id) on delete restrict on update restrict,
   constraint fk_city_customer foreign key (city_id)
      references city (city_id) on delete restrict on update restrict
);

create table user
(
   user_id              int auto_increment primary key,
   employee_id          int not null,
   username             varchar(64),
   password             varchar(64),
   constraint fk_user_employee foreign key (employee_id)
      references employee (employee_id) on delete restrict on update restrict
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
   employment_end_date  date,
   constraint fk_user_employee2 foreign key (user_id)
      references user (user_id) on delete restrict on update restrict
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
   items_info           text,
   constraint fk_invoice_details_invoice2 foreign key (invoice_id)
      references invoice (invoice_id) on delete restrict on update restrict,
   constraint fk_customer_invoice_details foreign key (customer_id)
      references customer (customer_id) on delete restrict on update restrict,
   constraint fk_invoice_details_transport_term foreign key (transport_term_id)
      references transport_term (transport_term_id) on delete restrict on update restrict,
   constraint fk_invoice_details_currency foreign key (currency_id)
      references currency (currency_id) on delete restrict on update restrict,
   constraint fk_employee_invoice_details foreign key (employee_id)
      references employee (employee_id) on delete restrict on update restrict
);

create table invoice
(
   invoice_id           int auto_increment primary key,
   invoice_detail_id    int null,
   constraint fk_invoice_details_invoice foreign key (invoice_detail_id)
      references invoice_details (invoice_detail_id) on delete restrict on update restrict
);

create table product
(
   product_id           int auto_increment primary key,
   category_id          int,
   code                 varchar(32),
   name                 varchar(32),
   description          text,
   price                decimal,
   constraint fk_category_product foreign key (category_id)
      references category (category_id) on delete restrict on update restrict
);

create table product_invoice
(
   product_invoice_id   int auto_increment primary key,
   invoice_id           int,
   product_id           int,
   quantity             int,
   constraint fk_product_product_invoice foreign key (product_id)
      references product (product_id) on delete restrict on update restrict,
   constraint fk_product_invoice_invoice foreign key (invoice_id)
      references invoice (invoice_id) on delete restrict on update restrict
);

