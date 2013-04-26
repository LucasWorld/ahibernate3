alter table personaddress 
        drop 
        foreign key FK154386FFCE89D1FA

    alter table personaddress 
        drop 
        foreign key FK154386FF4348E6B3

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
        person integer unique,
        primary key (addressid)
    )

    alter table personaddress 
        add index FK154386FFCE89D1FA (person), 
        add constraint FK154386FFCE89D1FA 
        foreign key (person) 
        references Person (personid)

    alter table personaddress 
        add index FK154386FF4348E6B3 (addressid), 
        add constraint FK154386FF4348E6B3 
        foreign key (addressid) 
        references Address (addressid)
