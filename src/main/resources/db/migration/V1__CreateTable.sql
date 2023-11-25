CREATE TABLE  Users (
    id SERIAL PRIMARY KEY ,
    name VARCHAR(30) NOT NULL,
    surname varchar(30) NOT NULL ,
    inn varchar(12) NOT NULL UNIQUE,
    phone varchar (15) NOT NULL UNIQUE,
    snils varchar(11) NOT NULL UNIQUE,
    fk_company INT,
    fk_passport INT,
    fk_address INT,

   UNIQUE (fk_passport) --связь 1 к  1. У двух разных пользователей не будет ссылки на 1 паспорт
);
--вопрос, правильно ли что fk_company и fk_pasport не not null - потому что при записи юзера данные по паспорту
--и компании могут быть еще не созданы. Не знаю порядок создания объектов
--надо ли прописывать ON DELETE RESTRICT во нешних ключах? вроде итак идет запрет удаление записей  если есть ссылки в других таблицах
CREATE TABLE Companies (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    inn VARCHAR(10) NOT NULL UNIQUE,
    phone varchar (15) NOT NULL UNIQUE,
    fk_address int

);

CREATE TABLE Passports
(
    id serial PRIMARY KEY,
    series VARCHAR(4),
    number VARCHAR(6),
    date_of_issue DATE NOT NULL ,
    issued_by TEXT NOT NULL
);
--правильно ли, что ключ составной, а не суррогатный

CREATE TABLE  Addresses (
    id serial PRIMARY KEY,
    country VARCHAR(20) NOT NULL,
    city VARCHAR(20) NOT NULL,
    street VARCHAR(50) NOT NULL,
    building_number varchar(5) NOT NULL,
    room_number int,

    UNIQUE (country,city,street,building_number,room_number)
);
--здесь использую составной ключ, чтобы в других таблицах внешний ключ был 1 поле а не улица + дом и т д
--номер квартиры - int или varchar


ALTER TABLE Users ADD CONSTRAINT fk_company_id FOREIGN KEY (fk_company) REFERENCES Companies(id);
ALTER TABLE Users ADD CONSTRAINT fk_passport FOREIGN KEY (fk_passport) REFERENCES Passports(id);
ALTER TABLE  Users ADD CONSTRAINT  fk_address FOREIGN KEY (fk_address) REFERENCES Addresses(id);
ALTER TABLE  Companies ADD CONSTRAINT fk_address FOREIGN KEY (fk_address) REFERENCES Addresses(id)