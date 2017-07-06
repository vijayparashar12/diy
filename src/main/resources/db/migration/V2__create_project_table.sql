CREATE TABLE IF NOT EXISTS diy.PROJECTS
(
    id UUID NOT NULL default uuid_generate_v4(),
    title varchar(400) NOT NULL,
    description varchar(2000) NOT NULL,
    user_id UUID REFERENCES diy.USERS(id) ON DELETE CASCADE,
    CONSTRAINT "PROJECT_pkey" PRIMARY KEY (id)
);