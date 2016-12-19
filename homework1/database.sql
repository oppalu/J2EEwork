DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`(
	`id` VARCHAR(20) NOT NULL ,
	`name` VARCHAR(255) NOT NULL ,
	`password` VARCHAR(255) NOT NULL ,
	PRIMARY KEY(`id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8;
INSERT INTO student VALUES ('141250030','窦妍','123456');
INSERT INTO student VALUES ('141250031','杜天蛟','123456');
INSERT INTO student VALUES ('141250035','范炜','123456');
INSERT INTO student VALUES ('141250037','高露','123456');

DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`(
	`id` VARCHAR(20) NOT NULL ,
	`coursename` VARCHAR(255) NOT NULL ,
	`year` INT(11) NOT NULL ,
	PRIMARY KEY(`id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8;
INSERT INTO course VALUES ('se001','体系结构',2016);
INSERT INTO course VALUES ('se002','人机交互',2016);
INSERT INTO course VALUES ('se003','软件构造',2016);
INSERT INTO course VALUES ('se004','J2EE',2016);
INSERT INTO course VALUES ('se005','Linux程序设计',2016);
INSERT INTO course VALUES ('se006','电子商务',2016);
INSERT INTO course VALUES ('se007','面向服务',2016);

DROP TABLE IF EXISTS `exam`;
CREATE TABLE `exam`(
	`sid` VARCHAR(20) NOT NULL ,
	`cid` VARCHAR(20) NOT NULL ,
	`score` INT(11) NOT NULL DEFAULT 0,
	`detail` VARCHAR(255),
	PRIMARY KEY(`sid`,`cid`)
) ENGINE = INNODB DEFAULT CHARSET = utf8;

INSERT INTO exam VALUES ('141250030','体系结构',91,'期末:85 实验:80');
INSERT INTO exam VALUES ('141250030','人机交互',90,'卷面:85');
INSERT INTO exam VALUES ('141250030','软件构造',82,'卷面:77');
INSERT INTO exam VALUES ('141250030','J2EE',90,'期末:90 大作业 90');
INSERT INTO exam VALUES ('141250030','Linux程序设计',90);
INSERT INTO exam VALUES ('141250031','体系结构',91,'期末:81 实验:90');
INSERT INTO exam VALUES ('141250031','人机交互',90,'卷面:85');
INSERT INTO exam VALUES ('141250031','软件构造',92,'卷面:90');
INSERT INTO exam VALUES ('141250031','J2EE',92,'期末:94 大作业 90');
INSERT INTO exam VALUES ('141250031','电子商务');
INSERT INTO exam VALUES ('141250035','体系结构',93,'期末:84 实验:90');
INSERT INTO exam VALUES ('141250035','人机交互',90,'卷面:85');
INSERT INTO exam VALUES ('141250035','软件构造',77,'卷面:71');
INSERT INTO exam VALUES ('141250035','面向服务',94,'期末:90 平时 90');
INSERT INTO exam VALUES ('141250035','电子商务');
INSERT INTO exam VALUES ('141250037','体系结构',87,'期末:77 实验:80');
INSERT INTO exam VALUES ('141250037','人机交互',90,'卷面:85');
INSERT INTO exam VALUES ('141250037','软件构造',89,'卷面:89');
INSERT INTO exam VALUES ('141250037','J2EE',90,'期末:90 大作业 90');
INSERT INTO exam VALUES ('141250037','Linux程序设计',91);