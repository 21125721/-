
drop table stu;

create table stu(`stucode` int auto_increment comment '学号' primary key,
				`name` varchar(20) not null comment '姓名',
				`sex` varchar(4) not null comment '性别男/女',
				`age` tinyint(3) not null comment '年龄',
				`phoneid` varchar(11) not null comment '手机号'
				)character set utf8 collate utf8_general_ci comment="学生表";

update score set `C` =0 where stucode  = 4;
update score set `Html`=0 where stucode=5;
				
drop table score;
create table score(`stucode` int not null auto_increment primary key comment '学号',
					`existence` int not null comment'是否存在',
					`C` int default null comment 'C语言',
					`Java` int default null comment 'Java语言',
					`Oracle` int default null comment 'Oracle数据库',
					`PS` int default null comment 'PS',
					`Html` int default null comment 'HTML',
					foreign key(`stucode`) references `stu`(`stucode`) 
				)character set utf8 collate utf8_general_ci comment="成绩表";
				
create table clazz(
				`stucode` int not null auto_increment primary key comment '学号',
				`clazz1` varchar()
				)character set utf8 collate utf8_general_ci comment="成绩表2";
				
insert into score(`C`,`Java`,`Oracle`,`PS`,`Html`) values(98,89,95);
insert into score(`C`,`Java`,`Oracle`,`PS`,`Html`) values(88,92,87);
insert into score(`C`,`Java`,`Oracle`,`PS`,`Html`) values(92,91,82);
insert into score(`C`,`Java`,`Oracle`,`PS`,`Html`) values(85,81,89);

select * from score;

SELECT `stu`.*, `score`.Chinese,`score`.Math FROM `stu`
	LEFT JOIN `score` ON `stu`.stucode = `score`.stucode;


	
select * from stu;
select * from stu limit 1,2;

desc stu;
alter table stu modify column `phoneid` varchar(11) not null;
show tables;

insert into stu(`name`,`sex`,`age`,`phoneid`) values('Jack','男',18,'13487564924');
insert into stu(`name`,`sex`,`age`,`phoneid`) values('Mike','男',19,'13487564924');
insert into stu(`name`,`sex`,`age`,`phoneid`) values('Rose','女',18,'13487564924');
insert into stu(`name`,`sex`,`age`,`phoneid`) values('Jane','女',19,'13487564924');

CREATE PROCEDURE SelectAll() 
BEGIN
	select * from stu;
END
;















