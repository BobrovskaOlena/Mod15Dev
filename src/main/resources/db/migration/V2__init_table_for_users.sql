CREATE TABLE roles(
id BIGSERIAL PRIMARY KEY,
name VARCHAR(50) NOT NULL
);

CREATE TABLE users(
id BIGSERIAL PRIMARY KEY,
username VARCHAR(100) NOT NULL UNIQUE CHECK(LENGTH(username)>=2 AND LENGTH(username)<=100),
password VARCHAR(100) NOT NULL
);

CREATE TABLE user_roles(
id BIGSERIAL PRIMARY KEY,
user_id BIGINT NOT NULL,
role_id BIGINT NOT NULL,
UNIQUE (user_id, role_id)
);
ALTER TABLE note ADD COLUMN user_id BIGINT;
ALTER TABLE public.note ADD CONSTRAINT note_fk FOREIGN KEY (user_id) REFERENCES public.users(id) ON DELETE CASCADE;
ALTER TABLE public.user_roles ADD CONSTRAINT user_role_fk FOREIGN KEY (user_id) REFERENCES public.users(id) ON DELETE CASCADE;
ALTER TABLE public.user_roles ADD CONSTRAINT role_user_fk FOREIGN KEY (role_id) REFERENCES public.roles(id) ON DELETE CASCADE;

INSERT INTO public.roles (name) VALUES ('SUPER_ADMIN'), ('ADMIN'), ('USER');

INSERT INTO public.users (username, password)
VALUES ('admin', '$2a$10$.IeRI/Gy/8UscmtMmMHyDe2PDe0TMLn.9vb6WUSS2FVtzGmEZzcj2'),
       ('user', '$2a$10$uZ/R0BFKt2MqlybEAcO2NebJkdp5qWI3G2SnssNn3HcMHEZAC61Nu');

INSERT INTO public.user_roles (user_id, role_id) VALUES (1, 2), (2, 3);