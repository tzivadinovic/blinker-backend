alter table category add column last_modified_date timestamp default CURRENT_TIMESTAMP null;
alter table category add column last_modified_by varchar(128) default 'system' null;
alter table category add column created_date timestamp default CURRENT_TIMESTAMP null;
alter table category add column record_status int default 1 null;

alter table city add column last_modified_date timestamp default CURRENT_TIMESTAMP null;
alter table city add column last_modified_by varchar(128) default 'system' null;
alter table city add column created_date timestamp default CURRENT_TIMESTAMP null;
alter table city add column record_status int default 1 null;

alter table currency add column last_modified_date timestamp default CURRENT_TIMESTAMP null;
alter table currency add column last_modified_by varchar(128) default 'system' null;
alter table currency add column created_date timestamp default CURRENT_TIMESTAMP null;
alter table currency add column record_status int default 1 null;

alter table customer add column last_modified_date timestamp default CURRENT_TIMESTAMP null;
alter table customer add column last_modified_by varchar(128) default 'system' null;
alter table customer add column created_date timestamp default CURRENT_TIMESTAMP null;
alter table customer add column record_status int default 1 null;

alter table employee add column last_modified_date timestamp default CURRENT_TIMESTAMP null;
alter table employee add column last_modified_by varchar(128) default 'system' null;
alter table employee add column created_date timestamp default CURRENT_TIMESTAMP null;
alter table employee add column record_status int default 1 null;

alter table invoice add column last_modified_date timestamp default CURRENT_TIMESTAMP null;
alter table invoice add column last_modified_by varchar(128) default 'system' null;
alter table invoice add column created_date timestamp default CURRENT_TIMESTAMP null;
alter table invoice add column record_status int default 1 null;

alter table invoice_details add column last_modified_date timestamp default CURRENT_TIMESTAMP null;
alter table invoice_details add column last_modified_by varchar(128) default 'system' null;
alter table invoice_details add column created_date timestamp default CURRENT_TIMESTAMP null;
alter table invoice_details add column record_status int default 1 null;

alter table product add column last_modified_date timestamp default CURRENT_TIMESTAMP null;
alter table product add column last_modified_by varchar(128) default 'system' null;
alter table product add column created_date timestamp default CURRENT_TIMESTAMP null;
alter table product add column record_status int default 1 null;

alter table product_invoice add column last_modified_date timestamp default CURRENT_TIMESTAMP null;
alter table product_invoice add column last_modified_by varchar(128) default 'system' null;
alter table product_invoice add column created_date timestamp default CURRENT_TIMESTAMP null;
alter table product_invoice add column record_status int default 1 null;

alter table state add column last_modified_date timestamp default CURRENT_TIMESTAMP null;
alter table state add column last_modified_by varchar(128) default 'system' null;
alter table state add column created_date timestamp default CURRENT_TIMESTAMP null;
alter table state add column record_status int default 1 null;

alter table transport_term add column last_modified_date timestamp default CURRENT_TIMESTAMP null;
alter table transport_term add column last_modified_by varchar(128) default 'system' null;
alter table transport_term add column created_date timestamp default CURRENT_TIMESTAMP null;
alter table transport_term add column record_status int default 1 null;

alter table user add column last_modified_date timestamp default CURRENT_TIMESTAMP null;
alter table user add column last_modified_by varchar(128) default 'system' null;
alter table user add column created_date timestamp default CURRENT_TIMESTAMP null;
alter table user add column record_status int default 1 null;