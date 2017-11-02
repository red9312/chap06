
    create table id_gen (
       seq_name varchar(255) not null,
        nextval bigint,
        primary key (seq_name)
    ) engine=MyISAM;

    create table tbl_dept (
       deptno integer not null,
        dname varchar(255),
        loc varchar(255),
        regdate datetime,
        updatedate datetime,
        primary key (deptno)
    ) engine=MyISAM;

    create table tbl_emp (
       empno integer not null,
        comm decimal(19,2),
        ename varchar(255),
        gender varchar(255),
        hiredate date,
        job varchar(255),
        sal decimal(19,2),
        deptno integer,
        mgr integer,
        primary key (empno)
    ) engine=MyISAM;

    create table tbl_webboard (
       bno bigint not null,
        content varchar(255),
        regdate datetime,
        title varchar(255),
        updatedate datetime,
        writer varchar(255),
        primary key (bno)
    ) engine=MyISAM;

    alter table tbl_emp 
       add constraint FKi7oweqfp7jnfmu9u18gb191dl 
       foreign key (deptno) 
       references tbl_dept (deptno);

    alter table tbl_emp 
       add constraint FK40s7ax4ribn767fneuqeu8s41 
       foreign key (mgr) 
       references tbl_emp (empno);
