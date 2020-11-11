create table owners (id bigint not null auto_increment, first_name varchar(255), last_name varchar(255), address varchar(255), city varchar(255), telephone varchar(255), primary key (id)) engine=InnoDB;
create table pets (id bigint not null auto_increment, birth_date date, name varchar(255), owner_id bigint, type_id bigint, primary key (id)) engine=InnoDB;
create table specialties (id bigint not null auto_increment, description varchar(255), primary key (id)) engine=InnoDB;
create table types (id bigint not null auto_increment, name varchar(255), primary key (id)) engine=InnoDB;
create table vet_specialties (vet_id bigint not null, speciality_id bigint not null, primary key (vet_id, speciality_id)) engine=InnoDB;
create table vets (id bigint not null auto_increment, first_name varchar(255), last_name varchar(255), primary key (id)) engine=InnoDB;
create table visits (id bigint not null auto_increment, date date, description varchar(255), pet_id bigint, primary key (id)) engine=InnoDB;
alter table pets add constraint FK6teg4kcjcnjhduguft56wcfoa foreign key (owner_id) references owners (id);
alter table pets add constraint FKtmmh1tq8pah5vxf8kuqqplo4p foreign key (type_id) references types (id);
alter table vet_specialties add constraint FKo5tqp1wacih7hp646pyh85kbn foreign key (speciality_id) references specialties (id);
alter table vet_specialties add constraint FKby1c0fbaa0byaifi63vt18sx9 foreign key (vet_id) references vets (id);
alter table visits add constraint FK6jcifhlqqlsfseu67utlouauy foreign key (pet_id) references pets (id);
create table owners (id bigint not null auto_increment, first_name varchar(255), last_name varchar(255), address varchar(255), city varchar(255), telephone varchar(255), primary key (id)) engine=InnoDB
create table pets (id bigint not null auto_increment, birth_date date, name varchar(255), owner_id bigint, type_id bigint, primary key (id)) engine=InnoDB
create table specialties (id bigint not null auto_increment, description varchar(255), primary key (id)) engine=InnoDB
create table types (id bigint not null auto_increment, name varchar(255), primary key (id)) engine=InnoDB
create table vet_specialties (vet_id bigint not null, speciality_id bigint not null, primary key (vet_id, speciality_id)) engine=InnoDB
create table vets (id bigint not null auto_increment, first_name varchar(255), last_name varchar(255), primary key (id)) engine=InnoDB
create table visits (id bigint not null auto_increment, date date, description varchar(255), pet_id bigint, primary key (id)) engine=InnoDB
alter table pets add constraint FK6teg4kcjcnjhduguft56wcfoa foreign key (owner_id) references owners (id)
alter table pets add constraint FKtmmh1tq8pah5vxf8kuqqplo4p foreign key (type_id) references types (id)
alter table vet_specialties add constraint FKo5tqp1wacih7hp646pyh85kbn foreign key (speciality_id) references specialties (id)
alter table vet_specialties add constraint FKby1c0fbaa0byaifi63vt18sx9 foreign key (vet_id) references vets (id)
alter table visits add constraint FK6jcifhlqqlsfseu67utlouauy foreign key (pet_id) references pets (id)
