
    alter table personAddress 
        drop 
        foreign key FK787C1EDFF7C5D19D

    alter table personAddress 
        drop 
        foreign key FK787C1EDFE641EBEB

    drop table if exists Address

    drop table if exists Person

    drop table if exists personAddress

    create table Address (
        addressid integer not null auto_increment,
        primary key (addressid)
    )

    create table Person (
        personid integer not null auto_increment,
        primary key (personid)
    )

    create table personAddress (
        personid integer not null,
        addressid integer not null,
        primary key (personid, addressid)
    )

    alter table personAddress 
        add index FK787C1EDFF7C5D19D (personid), 
        add constraint FK787C1EDFF7C5D19D 
        foreign key (personid) 
        references Person (personid)

    alter table personAddress 
        add index FK787C1EDFE641EBEB (addressid), 
        add constraint FK787C1EDFE641EBEB 
        foreign key (addressid) 
        references Address (addressid)
