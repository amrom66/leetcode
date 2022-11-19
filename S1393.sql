use leetcode;
Create Table If Not Exists Stocks (stock_name varchar(15), operation ENUM('Sell', 'Buy'), operation_day int, price int);
Truncate table Stocks;
insert into Stocks (stock_name, operation, operation_day, price) values ('Leetcode', 'Buy', '1', '1000');
insert into Stocks (stock_name, operation, operation_day, price) values ('Corona Masks', 'Buy', '2', '10');
insert into Stocks (stock_name, operation, operation_day, price) values ('Leetcode', 'Sell', '5', '9000');
insert into Stocks (stock_name, operation, operation_day, price) values ('Handbags', 'Buy', '17', '30000');
insert into Stocks (stock_name, operation, operation_day, price) values ('Corona Masks', 'Sell', '3', '1010');
insert into Stocks (stock_name, operation, operation_day, price) values ('Corona Masks', 'Buy', '4', '1000');
insert into Stocks (stock_name, operation, operation_day, price) values ('Corona Masks', 'Sell', '5', '500');
insert into Stocks (stock_name, operation, operation_day, price) values ('Corona Masks', 'Buy', '6', '1000');
insert into Stocks (stock_name, operation, operation_day, price) values ('Handbags', 'Sell', '29', '7000');
insert into Stocks (stock_name, operation, operation_day, price) values ('Corona Masks', 'Sell', '10', '10000');


select tmp.stock_name, max(tmp.price)-min(tmp.price) as capital_gain_loss FROM
(
(select stock_name, min(price) price from Stocks where operation = 'Buy' group by stock_name)
union
(select stock_name, max(price) price from Stocks where operation = 'Sell' group by stock_name)
)
tmp
GROUP BY tmp.stock_name;


SELECT tmp.stock_name, tmp.price2 -tmp.price1 as capital_gain_loss FROM
(
SELECT t1.stock_name, t1.price as price1, t2.price as price2 FROM
(select stock_name, SUM(price) price from Stocks where operation = 'Buy' group by stock_name) t1
left join 
(select stock_name, SUM(price) price from Stocks where operation = 'Sell' group by stock_name) t2
on t1.stock_name = t2.stock_name
) tmp 