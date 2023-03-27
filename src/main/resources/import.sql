insert into tb_users (user_id, username, password, email) values (1, 'will', '$2a$10$gy2YylnoEw27j1PfM9vMNuYtNU/OCNAvK0wPcRxG9gDJgviO2L9FO', '');
insert into tb_users (user_id, username, password, email) values (2, 'mario', '$2a$10$gy2YylnoEw27j1PfM9vMNuYtNU/OCNAvK0wPcRxG9gDJgviO2L9FO', '');

insert into tb_roles (role_id, role_name) values (1, 'ROLE_ADMIN');
insert into tb_roles (role_id, role_name) values (2, 'ROLE_USER');

insert into tb_users_roles (user_id, role_id) values (1,1);
insert into tb_users_roles (user_id, role_id) values (2,2);