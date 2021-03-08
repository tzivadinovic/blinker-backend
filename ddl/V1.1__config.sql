alter table customer add constraint fk_state_customer foreign key (state_id)
      references state (state_id);
alter table customer add constraint fk_city_customer foreign key (city_id)
      references city (city_id);


alter table user add constraint fk_user_employee foreign key (employee_id)
      references employee (employee_id);


alter table employee add constraint fk_user_employee foreign key (user_id)
      references user (user_id);



alter table invoice_details add constraint fk_customer_invoice_details foreign key (customer_id)
      references customer (customer_id);
alter table invoice_details add constraint fk_invoice_details_transport_term foreign key (transport_term_id)
      references transport_term (transport_term_id);
alter table invoice_details add constraint fk_invoice_details_currency foreign key (currency_id)
      references currency (currency_id);
alter table invoice_details add constraint fk_employee_invoice_details foreign key (employee_id)
      references employee (employee_id);


alter table invoice add constraint fk_invoice_details_invoice foreign key (invoice_detail_id)
      references invoice_details (invoice_detail_id) on update cascade on delete cascade;


alter table product add constraint fk_category_product foreign key (category_id)
      references category (category_id);


alter table product_invoice add constraint fk_product_product_invoice foreign key (product_id)
      references product (product_id);
alter table product_invoice add constraint fk_product_invoice_invoice foreign key (invoice_id)
      references invoice (invoice_id);