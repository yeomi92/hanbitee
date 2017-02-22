-- seq,id,title,content,regdate,read_count --
drop table article;
drop Sequence art_seq;
--CREATE SEQUENCE--
CREATE SEQUENCE art_seq
	START WITH 1
	INCREMENT BY 1
	NOCACHE
	NOCYCLE;
--CREATE TABLE--
CREATE TABLE Article(
	art_seq DECIMAL PRIMARY KEY,
	pat_id VARCHAR2(10) NOT NULL,
	title VARCHAR2(30) NOT NULL,
	content VARCHAR2(100) NOT NULL,
	regdate VARCHAR2(10) NOT NULL,
	read_count VARCHAR2(50) NOT NULL,
	FOREIGN KEY(pat_id) REFERENCES Patient(pat_id)
);
--INSERT(11건)--
INSERT INTO Article(art_seq,pat_id,title,content,regdate,read_count) VALUES(art_seq.nextval,'pahn','안녕하세요','안녕하세요 content','2017-01-01','0');
INSERT INTO Article(art_seq,pat_id,title,content,regdate,read_count) VALUES(art_seq.nextval,'pahn','방갑습니다','방갑습니다 content','2017-01-11','0');
INSERT INTO Article(art_seq,pat_id,title,content,regdate,read_count) VALUES(art_seq.nextval,'pahn','hello','hello content','2017-02-02','0');
INSERT INTO Article(art_seq,pat_id,title,content,regdate,read_count) VALUES(art_seq.nextval,'plee','야호','야호 content','2017-02-03','0');
INSERT INTO Article(art_seq,pat_id,title,content,regdate,read_count) VALUES(art_seq.nextval,'plee','화이팅','화이팅 content','2017-02-04','0');
INSERT INTO Article(art_seq,pat_id,title,content,regdate,read_count)
VALUES(art_seq.nextval,'pchoi','환영합니다','환영합니다 content','2017-02-05','0');
INSERT INTO Article(art_seq,pat_id,title,content,regdate,read_count)
VALUES(art_seq.nextval,'pchoi','방가방가','방가방가 content','2017-02-05','0');
INSERT INTO Article(art_seq,pat_id,title,content,regdate,read_count)
VALUES(art_seq.nextval,'pjeong','정보처리기사','정보처리기사 content','2017-02-10','0');
INSERT INTO Article(art_seq,pat_id,title,content,regdate,read_count)
VALUES(art_seq.nextval,'pjeong','정보처리기능사','정보처리기능사 content','2017-02-11','0');
INSERT INTO Article(art_seq,pat_id,title,content,regdate,read_count)
VALUES(art_seq.nextval,'poh','안녕하세요','안녕하세요 content','2017-02-11','0');
INSERT INTO Article(art_seq,pat_id,title,content,regdate,read_count)
VALUES(art_seq.nextval,'psong','랄랄랄','랄랄랄 content','2017-02-14','0');
--READ ONE--
select * from article where art_seq='1';
--READ ALL--
select * from article;
--READ SOME--
select title from article where regdate like '%02%';
--UPDATE--
update ARTICLE set title='' where art_seq='';
--DELETE--
delete from ARTICLE where art_seq='1'; 