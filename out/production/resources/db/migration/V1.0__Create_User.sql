create table `user` (
    `id` int unsigned primary key auto_increment,
    `username` varchar(255) not null unique,
    `password` varchar(128) not null ,
    `age` int(11) unsigned not null default 0,
    `sex` varchar(128) not null
) ENGINE=InnoDB DEFAULT CHARSET=utf8