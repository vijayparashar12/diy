CREATE TABLE IF NOT EXISTS diy.USERS
(
    id UUID NOT NULL default uuid_generate_v4(),
    user_email varchar(40) NOT NULL,
    user_password varchar(60) NOT NULL,
    CONSTRAINT "USERS_pkey" PRIMARY KEY (id)
);