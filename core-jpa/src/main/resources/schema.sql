DROP TABLE IF EXISTS `user`;
DROP TABLE IF EXISTS `role`;
DROP TABLE IF EXISTS `user_role`;
DROP TABLE IF EXISTS `role_permission`;
DROP TABLE IF EXISTS `permission`;
DROP TABLE IF EXISTS `DICT_LIST_TAB`;
DROP TABLE IF EXISTS `DICT_LIST_VAL_TAB`;

CREATE TABLE `user` (
`id` bigint(11) NOT NULL AUTO_INCREMENT,
`username` varchar(255) NOT NULL,
`password` varchar(255) NOT NULL,
PRIMARY KEY (`id`)
);
CREATE TABLE `role` (
`id` bigint(11) NOT NULL AUTO_INCREMENT,
`name` varchar(255) NOT NULL,
PRIMARY KEY (`id`)
);
CREATE TABLE `user_role` (
`user_id` bigint(11) NOT NULL,
`role_id` bigint(11) NOT NULL
);
CREATE TABLE `role_permission` (
`role_id` bigint(11) NOT NULL,
`permission_id` bigint(11) NOT NULL
);
CREATE TABLE `permission` (
`id` bigint(11) NOT NULL AUTO_INCREMENT,
`url` varchar(255) NOT NULL,
`name` varchar(255) NOT NULL,
`description` varchar(255) NULL,
`pid` bigint(11) NOT NULL,
PRIMARY KEY (`id`)
);
create table DICT_LIST_TAB
(
  id          VARCHAR2(50) not null,
  classid     VARCHAR2(50),
  name        VARCHAR2(500),
  showtype    VARCHAR2(50) default 'LIST',
  valuetype   VARCHAR2(50) default 'CHAR',
  modifylevel VARCHAR2(50) default 'SYS',
  memo        VARCHAR2(4000),
  ordernum    NUMBER
);
create table DICT_LIST_VAL_TAB
(
  id            VARCHAR2(50) not null,
  listid        VARCHAR2(50),
  name          VARCHAR2(500),
  value         VARCHAR2(500),
  valuenum      NUMBER,
  iconname      VARCHAR2(500),
  iconpath      VARCHAR2(50),
  treenodevalid NUMBER,
  treenodetype  VARCHAR2(50),
  isleaf        NUMBER,
  parentid      VARCHAR2(50) default 'ROOTNODE',
  memo          VARCHAR2(4000),
  ordernum      NUMBER,
  code          VARCHAR2(50),
  ordernumshow  NUMBER,
  aliasname     VARCHAR2(4000),
  unit          VARCHAR2(50),
  flag          VARCHAR2(50)
);

INSERT INTO user (id, username, password) VALUES (1,'user','$2a$10$CZYwz7JJtZStzW2V7Fi0eOGL.971KsC6SH3un7aNqJhn0.B6WBowK');
INSERT INTO user (id, username , password) VALUES (2,'admin','$2a$10$CZYwz7JJtZStzW2V7Fi0eOGL.971KsC6SH3un7aNqJhn0.B6WBowK');
INSERT INTO user (id, username , password) VALUES (3,'admin1','$2a$10$CZYwz7JJtZStzW2V7Fi0eOGL.971KsC6SH3un7aNqJhn0.B6WBowK');
INSERT INTO user (id, username , password) VALUES (4,'admin2','$2a$10$CZYwz7JJtZStzW2V7Fi0eOGL.971KsC6SH3un7aNqJhn0.B6WBowK');
INSERT INTO user (id, username , password) VALUES (5,'admin3','$2a$10$CZYwz7JJtZStzW2V7Fi0eOGL.971KsC6SH3un7aNqJhn0.B6WBowK');
INSERT INTO user (id, username , password) VALUES (6,'admin4','$2a$10$CZYwz7JJtZStzW2V7Fi0eOGL.971KsC6SH3un7aNqJhn0.B6WBowK');
INSERT INTO user (id, username , password) VALUES (7,'admin5','$2a$10$CZYwz7JJtZStzW2V7Fi0eOGL.971KsC6SH3un7aNqJhn0.B6WBowK');
INSERT INTO user (id, username , password) VALUES (8,'admin6','$2a$10$CZYwz7JJtZStzW2V7Fi0eOGL.971KsC6SH3un7aNqJhn0.B6WBowK');
INSERT INTO user (id, username , password) VALUES (9,'admin7','$2a$10$CZYwz7JJtZStzW2V7Fi0eOGL.971KsC6SH3un7aNqJhn0.B6WBowK');
INSERT INTO user (id, username , password) VALUES (10,'admin8','$2a$10$CZYwz7JJtZStzW2V7Fi0eOGL.971KsC6SH3un7aNqJhn0.B6WBowK');
INSERT INTO user (id, username , password) VALUES (11,'admin9','$2a$10$CZYwz7JJtZStzW2V7Fi0eOGL.971KsC6SH3un7aNqJhn0.B6WBowK');
INSERT INTO user (id, username , password) VALUES (12,'admin10','$2a$10$CZYwz7JJtZStzW2V7Fi0eOGL.971KsC6SH3un7aNqJhn0.B6WBowK');
INSERT INTO role (id, name) VALUES (1,'USER');
INSERT INTO role (id, name) VALUES (2,'ADMIN');
INSERT INTO permission (id, url, name, pid) VALUES (1,'/user/common','common',0);
INSERT INTO permission (id, url, name, pid) VALUES (2,'/user/admin','admin',0);
INSERT INTO user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO user_role (user_id, role_id) VALUES (2, 2);
INSERT INTO role_permission (role_id, permission_id) VALUES (1, 1);
INSERT INTO role_permission (role_id, permission_id) VALUES (2, 1);
INSERT INTO role_permission (role_id, permission_id) VALUES (2, 2);
INSERT INTO dict_list_val_tab (id, listid,name,value) VALUES (1,'listid','name','uservalue');
INSERT INTO dict_list_val_tab (id, listid,name,value) VALUES (2,'listid','name1','uservalue1');
INSERT INTO dict_list_val_tab (id, listid,name,value) VALUES (3,'listid','name2','uservalue2');
