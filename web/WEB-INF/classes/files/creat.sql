SELECT *
FROM t_user_v2;
SELECT *
FROM t_admin_v2;

CREATE TABLE t_user_v2 (
  id       VARCHAR2(10) PRIMARY KEY,
  username VARCHAR2(20) UNIQUE NOT NULL,
  password VARCHAR2(20)        NOT NULL,
  age      NUMBER(3)           NOT NULL,
  email    VARCHAR2(20)        NOT NULL,
  address  VARCHAR2(50)        NOT NULL
);
DROP TABLE t_user_v2;

CREATE TABLE t_admin_v2 (
  adminname VARCHAR2(20) PRIMARY KEY,
  password  VARCHAR2(20)

);

CREATE SEQUENCE user_v2_seq START WITH 100;

INSERT INTO t_user_v2 VALUES (user_v2_seq.nextval, 'zhangSan', '123456', 18, 'zs@163.com', '北京市海淀区');
INSERT INTO t_user_v2 VALUES (user_v2_seq.nextval, 'liSi', '123456', 22, 'ls@163.com', '北京市海淀区');
INSERT INTO t_user_v2 VALUES (user_v2_seq.nextval, 'wangWu', '123456', 18, 'ww@163.com', '北京市朝阳区');
INSERT INTO t_admin_v2 VALUES ('me', '123123');