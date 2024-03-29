## Use to run mysql db docker image, optional if you're not using a local mysqldb
# docker run --name mysqldb -p 3306:3306 -e MYSQL_ALLOW_EMPTY_PASSWORD=yes -d mysql

# connect to mysql and run as root user
#Create Databases
CREATE DATABASE sfg_petclinic_dev;
CREATE DATABASE sfg_petclinic_prod;

#Create database service accounts
CREATE USER 'sfg_petclinic_dev_user'@'localhost' IDENTIFIED BY 'haowei';
CREATE USER 'sfg_petclinic_prod_user'@'localhost' IDENTIFIED BY 'haowei';
CREATE USER 'sfg_petclinic_dev_user'@'%' IDENTIFIED BY 'haowei';
CREATE USER 'sfg_petclinic_prod_user'@'%' IDENTIFIED BY 'haowei';

#Database grants
GRANT SELECT ON sfg_petclinic_dev.* to 'sfg_petclinic_dev_user'@'localhost';
GRANT INSERT ON sfg_petclinic_dev.* to 'sfg_petclinic_dev_user'@'localhost';
GRANT DELETE ON sfg_petclinic_dev.* to 'sfg_petclinic_dev_user'@'localhost';
GRANT UPDATE ON sfg_petclinic_dev.* to 'sfg_petclinic_dev_user'@'localhost';
GRANT SELECT ON sfg_petclinic_prod.* to 'sfg_petclinic_prod_user'@'localhost';
GRANT INSERT ON sfg_petclinic_prod.* to 'sfg_petclinic_prod_user'@'localhost';
GRANT DELETE ON sfg_petclinic_prod.* to 'sfg_petclinic_prod_user'@'localhost';
GRANT UPDATE ON sfg_petclinic_prod.* to 'sfg_petclinic_prod_user'@'localhost';
GRANT SELECT ON sfg_petclinic_dev.* to 'sfg_petclinic_dev_user'@'%';
GRANT INSERT ON sfg_petclinic_dev.* to 'sfg_petclinic_dev_user'@'%';
GRANT DELETE ON sfg_petclinic_dev.* to 'sfg_petclinic_dev_user'@'%';
GRANT UPDATE ON sfg_petclinic_dev.* to 'sfg_petclinic_dev_user'@'%';
GRANT SELECT ON sfg_petclinic_prod.* to 'sfg_petclinic_prod_user'@'%';
GRANT INSERT ON sfg_petclinic_prod.* to 'sfg_petclinic_prod_user'@'%';
GRANT DELETE ON sfg_petclinic_prod.* to 'sfg_petclinic_prod_user'@'%';
GRANT UPDATE ON sfg_petclinic_prod.* to 'sfg_petclinic_prod_user'@'%';