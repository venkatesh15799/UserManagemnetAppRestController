insert into COUNTRY_MASTER values(1,'INDIA');
insert into COUNTRY_MASTER values(1,'USA');

insert into STATE_MASTER values(1,'TELANGANA',1);
insert into STATE_MASTER values(2,'TAMILNADU',1);
insert into STATE_MASTER values(3,'NEW_JERSY',2);
insert into STATE_MASTER values(4,'WASHINGTON',2);

insert into CITY_MASTER values(1,'HYDERABAD',1);
insert into CITY_MASTER values(2,'NIAZAMABAD',1);
insert into CITY_MASTER values(3,'CHENNAI',2);
insert into CITY_MASTER values(4,'VELLORU',2);
insert into CITY_MASTER values(5,'JERSY',3);
insert into CITY_MASTER values(6,'TOMS_RIVER',3);
insert into CITY_MASTER values(7,'SEATTLE',4);
insert into CITY_MASTER values(8,'TAKOMA',4);



spring.mail.host = smtp.gmail.com
spring.mail.port = 587
spring.mail.properties.mail.smtp.starttls.enable = true
spring.mail.username = example@gmail.com
spring.mail.password = examplepassword
spring.mail.properties.mail.smtp.starttls.required = true
spring.mail.properties.mail.smtp.auth = true
spring.mail.properties.mail.smtp.connectiontimeout = 5000
spring.mail.properties.mail.smtp.timeout = 5000
spring.mail.properties.mail.smtp.writetimeout = 5000

https://stackabuse.com/spring-security-email-verification-registration/