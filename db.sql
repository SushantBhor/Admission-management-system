CREATE TABLE student(
    sform_no int PRIMARY KEY,
    sname varchar(30) NOT NULL,
    email varchar(30) ,
    mob_no varchar(30), 
    scid int,
    doc_status varchar(30),
    constraint f11 foreign key fk_cid(scid) references course(ccid)
)


CREATE TABLE course(
    ccid int primary key,
    cname varchar(30) not null,
    cdesc varchar(100) ,
    course_mod varchar(30),
    course_criteria varchar(50),
    fees double(9,2),
)

CREATE TABLE result(
    rform_no int,
    rank int,
    alloc_center varchar(30),
    constraint f12 foreign key fk_rform(rform_no) references student(sform_no)
)

CREATE TABLE payment(
    payment_id int primary key,
    amount double(9,2),
    amt_status varchar(30),
    payment_date date,
    pform_no int, 
    constraint f13 foreign key fk_pform(pform_no) references student(sform_no)
)