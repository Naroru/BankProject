 удалить ограничение на примари кии по серии номеру
ALTER TABLE Passports ADD  COLUMN id INT;
ALTER TABLE Passports ADD CONSTRAINT id_primary_key PRIMARY KEY (id);

ALTER TABLE Users DROP COLUMN passport_series, passport_number;
ALTER TABLE Users ADD FOREIGN KEY (fk_passport) REFERENCES Passports;