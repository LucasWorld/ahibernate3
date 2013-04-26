
    alter table personaddress 
        drop 
        foreign key FK154386FF1F5C69A9

    alter table personaddress 
        drop 
        foreign key FK154386FFCC944E4

    drop table if exists Address

    drop table if exists Person

    drop table if exists personaddress

    create table Address (
        addressid integer not null auto_increment,
        primary key (addressid)
    )

    create table Person (
        personid integer not null auto_increment,
        primary key (personid)
    )

    create table personaddress (
        addressid integer not null,
        person integer,
        primary key (addressid)
    )

    alter table personaddress 
        add index FK154386FF1F5C69A9 (person), 
        add constraint FK154386FF1F5C69A9 
        foreign key (person) 
        references Person (personid)

    alter table personaddress 
        add index FK154386FFCC944E4 (addressid), 
        add constraint FK154386FFCC944E4 
        foreign key (addressid) 
        references Address (addressid)