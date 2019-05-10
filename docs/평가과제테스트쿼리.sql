--* 장르리스트
-- 1 소설
-- 2 수필
-- 3 컴퓨터/IT
-- 4 인문
-- 5 경제        
-- 6 예술

--* 책리스트
        
--        books[0] = new Book( 1, "트와일라잇", "스테파니메이어" );
--        books[1] = new Book( 2,"뉴문", "스테파니메이어" );
--        books[2] = new Book( 3,"이클립스","스테파니메이어");
--        books[3] = new Book( 4,"브레이킹던","스테파니메이어");
--        books[4] = new Book( 5,"아리랑","조정래");
--        books[5] = new Book( 6,"젊은그들","김동인");
--        books[6] = new Book( 7,"아프니깐 청춘이다","김난도");
--        books[7] = new Book( 8,"귀천","천상병");
--        books[8] = new Book( 9,"태백산맥","조정래");
--        books[9] = new Book( 10,"풀하우스","원수연");

--* 과제목록
회원리스트
카테고리리스트
상품리스트 
카트리스트
주문리스트
주문도서리스트


-- insert category
insert into category values(null, "소설");
insert into category values(null, "수필");
insert into category values(null, "컴퓨터/IT");
insert into category values(null, "인문");
insert into category values(null, "경제");
insert into category values(null, "예술");

-- select category
select * from category;


-- 도서등록                               

insert into book values(null, "트와일라잇",11700, 1);
insert into book values(null, "아프니까 청춘이다",20000, 2);
insert into book values(null, "뉴문",15000, 1);

-- 상품리스트
select book_no, title, price, (select name from category where a.category_no=category_no) as category_name 
from book a



-- 회원등록
insert into member values(null, "임수빈","010-3449-0918","isb9082@naver.com",password(1234));
insert into member values(null, "임유빈","010-3449-0918","isb9082@naver.com",password(1234));
insert into member values(null, "베리","010-5259-0918","isb9082@daum.net",password(1234));



select * from member;

-- 회원리스트
select member_no, name, tel, email from member;


-- 카테고리등록
insert into category values(null, "수험서");

-- 카테고리리스트
select category_no, name from category;


-- 카트담기
insert into cart values(2,5,4); 

-- 카트리스트
select c.name, b.title, a.quantity
from cart a
join book b
ON a.book_no = b.book_no
join member c
ON a.member_no = c.member_no
where a.member_no = 1;




-- 주문넣기
insert into orders values (null, (select SUM(b.price* a.quantity) as price
from cart a
join book b
ON a.book_no = b.book_no
where a.member_no = 2
GROUP BY a.member_no), "서울특별시 노원구 34-24",2,now(),concat(date_format(now(), '%Y%m%d'),"-",lpad((last_insert_id()+1),3,0)));

delete from orders where orders_no =3;
select * from orders; 


select last_insert_id();
SELECT 
FROM
WHERE 

-- 주문리스트
select orders_code, name, address,price , orders_date 
from orders 
JOIN member
USING (member_no)
where member_no=1;  


alter table orders add orders_code VARCHAR(14);

select * from orders;


-- 금액
select SUM(b.price* a.quantity) as price
from cart a
join book b
ON a.book_no = b.book_no
where a.member_no = 1
GROUP BY a.member_no

insert into order_book

-- 주문도서리스트

