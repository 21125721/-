//ѧ����Ϣ����ϵͳ
drop table stu;

create table stu(`stucode` int auto_increment comment 'ѧ��' primary key,
				`name` varchar(20) not null comment '����',
				`sex` int not null comment '�Ա�@1:��/0:Ů',
				`age` tinyint(3) not null comment '����',
				`phoneid` varchar(11) not null comment '�ֻ���')character set utf8 collate utf8_general_ci comment="ѧ����";

select * from stu;
select * from stu limit 1,2;

desc stu;
alter table stu modify column `phoneid` varchar(11) not null;
show tables;


insert into stu(`name`,`sex`,`age`,`phoneid`) values('Rose',0,18,'13487564924');


CREATE PROCEDURE SelectAll() 
BEGIN
	select * from stu;
END
;















