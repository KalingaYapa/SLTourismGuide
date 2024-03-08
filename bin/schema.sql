CREATE TABLE IF NOT EXISTS public.user_account
(
    user_id integer NOT NULL,
    email character varying(255) COLLATE pg_catalog."default",
    first_name character varying(255) COLLATE pg_catalog."default",
    last_name character varying(255) COLLATE pg_catalog."default",
    password character varying(255) COLLATE pg_catalog."default",
    user_name character varying(255) COLLATE pg_catalog."default",
    user_status integer,
    user_type integer,
    created_time date,
    last_updated_time date,
    CONSTRAINT user_account_pkey PRIMARY KEY (user_id)
);

