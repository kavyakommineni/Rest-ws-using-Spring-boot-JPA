insert into Customer(Customer_Id,Customer_Address,Customer_Name,Customer_Password) values('KavyaK','Cincinnati,US','Kavya','Kavya@123');
insert into Customer(Customer_Id,Customer_Address,Customer_Name,Customer_Password) values('RamP','Columbus,US','Ram','Ram@123');
insert into Customer(Customer_Id,Customer_Address,Customer_Name,Customer_Password) values('JackC','Florida,US','Jack','Jack@123');
insert into Customer(Customer_Id,Customer_Address,Customer_Name,Customer_Password) values('JohnD','New Jersey,US','John','John@123');
insert into Customer(Customer_Id,Customer_Address,Customer_Name,Customer_Password) values('ClaraE','Chicago,US','Clara','Clara@123');

insert into Orders(Order_Id,Order_Cost,Order_Status,Customer_Id) values('order1',12.24,'Delivered','JackC');
insert into Orders(Order_Id,Order_Cost,Order_Status,Customer_Id) values('order2',53.14,'Cancelled','JackC');
insert into Orders(Order_Id,Order_Cost,Order_Status,Customer_Id) values('order3',14.33,'Delivered','RamP');
insert into Orders(Order_Id,Order_Cost,Order_Status,Customer_Id) values('order4',25.11,'Pending','ClaraE');
insert into Orders(Order_Id,Order_Cost,Order_Status,Customer_Id) values('order5',4.25,'Cancelled','KavyaK');
insert into Orders(Order_Id,Order_Cost,Order_Status,Customer_Id) values('order6',1.88,'Delivered','KavyaK');

insert into Product(Product_Id,Product_Name,Product_Description,Product_Price,Available_Stock,Order_Id) values('Product1','Ipad','Ipad Description',458.22,192,'order5');
insert into Product(Product_Id,Product_Name,Product_Description,Product_Price,Available_Stock,Order_Id) values('Product2','Iphone','Iphone Description',799.56,32,'order2');
insert into Product(Product_Id,Product_Name,Product_Description,Product_Price,Available_Stock,Order_Id) values('Product3','Bluetooth Headphones','Headphones Description',6.47,45,'order5');
insert into Product(Product_Id,Product_Name,Product_Description,Product_Price,Available_Stock,Order_Id) values('Product4','Amazon Echo Dot','Echo Dot Description',85.22,67,'order1');
insert into Product(Product_Id,Product_Name,Product_Description,Product_Price,Available_Stock,Order_Id) values('Product5','Apple watch band','Watch Description',400.21,12,'order3');
insert into Product(Product_Id,Product_Name,Product_Description,Product_Price,Available_Stock,Order_Id) values('Product6','Nike Shoes','Shoes Description',39.01,77,'order4');

insert into Seller(Seller_Id,Seller_Name,Seller_Address,Contact_Number,Seller_Rating,Product_Id) values('Seller1','Amazon.com','Florida,US','1234567890',3.5,'Product5');
insert into Seller(Seller_Id,Seller_Name,Seller_Address,Contact_Number,Seller_Rating,Product_Id) values('Seller2','AMZN Sports','Blue Ash,Cincinnati,Ohio','7778889996',4,'Product2');
insert into Seller(Seller_Id,Seller_Name,Seller_Address,Contact_Number,Seller_Rating,Product_Id) values('Seller3','IMP Shopping Mall','Atlanta,US','1203452016',2.3, 'Product1');
insert into Seller(Seller_Id,Seller_Name,Seller_Address,Contact_Number,Seller_Rating,Product_Id) values('Seller4','Amazon warehouse','Columbus,Ohio','3012478569',3.9, 'Product3');
insert into Seller(Seller_Id,Seller_Name,Seller_Address,Contact_Number,Seller_Rating,Product_Id) values('Seller5','Tiger Tailor','Clifton,Cincinnati,Ohio','5132486248',2.9,'Product4');
insert into Seller(Seller_Id,Seller_Name,Seller_Address,Contact_Number,Seller_Rating,Product_Id) values('Seller6','OpticsPlanet','New York,US','3451289647',4.1,'Product6');

insert into Shipment(Shipment_Id,Shipment_Date,Seller_Id) values('Shipment1','2019-05-01','Seller6');
insert into Shipment(Shipment_Id,Shipment_Date,Seller_Id) values('Shipment2','2019-04-02','Seller4');
insert into Shipment(Shipment_Id,Shipment_Date,Seller_Id) values('Shipment3','2019-03-31','Seller5');