create table customer (
  id varchar(60) ,
	name varchar(60),
    email varchar(60),
    checkInDate date,
    CheckOutDate date,
    roomNumber int
);

alter table customer
modify column checkInDate varchar(60);

alter table customer
modify column CheckOutDate varchar(60);

show columns from customer

insert into customer values("123","gahaj","dmmaikd@gmail.com","2023-2-1","330203i4",12);

select * from customer

alter table customer
rename column CheckOutDate to check_out_date

alter table customer
rename column checkInDate to check_in_date

alter table customer
rename column roomNumber to room_number

truncate customer

alter table customer
modify column check_out_date date;

alter table customer
modify column check_in_date date;

