insert into tb_users (user_id, username, password, email) values (1, 'admin@master', '$2a$10$gy2YylnoEw27j1PfM9vMNuYtNU/OCNAvK0wPcRxG9gDJgviO2L9FO', 'admin@master');
insert into tb_users (user_id, username, password, email) values (2, 'mario', '$2a$10$gy2YylnoEw27j1PfM9vMNuYtNU/OCNAvK0wPcRxG9gDJgviO2L9FO', 'user@user');

insert into tb_roles (role_id, role_name) values (1, 'ROLE_ADMIN');
insert into tb_roles (role_id, role_name) values (2, 'ROLE_USER');

insert into tb_users_roles (user_id, role_id) values (1,1);
insert into tb_users_roles (user_id, role_id) values (2,2);

insert into tb_cidade (id, estado, nome, website) values (1, 'PE', 'Porto de galinhas', 'www.portodegalinhas.com.br');
insert into tb_cidade (id, estado, nome, website) values (2, 'AL', 'Maragogi', 'www.maragogi.com.br');
insert into tb_cidade (id, estado, nome, website) values (3, 'RJ', 'Trindade', 'www.trindade.com.br');
insert into tb_cidade (id, estado, nome, website) values (4, 'RJ', 'Rio de Janeiro', 'www.rio.com.br');
insert into tb_cidade (id, estado, nome, website) values (5, 'SP', 'São Paulo', 'www.sp.com.br');
insert into tb_cidade (id, estado, nome, website) values (6, 'MT', 'Bonito', 'www.bonito.com.br');
insert into tb_cidade (id, estado, nome, website) values (7, 'PE', 'Campos do Jordão', 'www.camposjordao.com.br');

insert into tb_hotel (id, nome, valor_diaria, cidade_id) values (1, 'IBIS', 150.00, 1);
insert into tb_hotel (id, nome, valor_diaria, cidade_id) values (2, 'All Inn', 250.00, 2);
insert into tb_hotel (id, nome, valor_diaria, cidade_id) values (3, 'Hotel Evidencias', 300.00, 3);
insert into tb_hotel (id, nome, valor_diaria, cidade_id) values (4, 'Beira Mar', 350.00, 4);
insert into tb_hotel (id, nome, valor_diaria, cidade_id) values (5, 'Por do Sol', 150.00, 5);
insert into tb_hotel (id, nome, valor_diaria, cidade_id) values (6, 'All Inn Internacional', 150.00, 6);
insert into tb_hotel (id, nome, valor_diaria, cidade_id) values (7, 'Copacabana Palace', 850.00, 7);
insert into tb_hotel (id, nome, valor_diaria, cidade_id) values (8, 'VogueSquare', 950.00, 1);
insert into tb_hotel (id, nome, valor_diaria, cidade_id) values (9, 'Hotel Atlantico Tower', 298.00, 2);
insert into tb_hotel (id, nome, valor_diaria, cidade_id) values (10, 'Vila Rica', 550.00, 3);
insert into tb_hotel (id, nome, valor_diaria, cidade_id) values (11, 'Windsor Hotel', 150.00, 4);

insert into tb_restaurante (id, nome, valor_refeicao, cidade_id) values (1, 'Aroma e sabor', 50.00, 1);
insert into tb_restaurante (id, nome, valor_refeicao, cidade_id) values (2, 'Salles Grill', 60.00, 2);
insert into tb_restaurante (id, nome, valor_refeicao, cidade_id) values (3, 'Tempero Manero', 70.00, 3);
insert into tb_restaurante (id, nome, valor_refeicao, cidade_id) values (4, 'Gaucho', 85.00, 4);
insert into tb_restaurante (id, nome, valor_refeicao, cidade_id) values (5, 'Arriba Muchacho', 50.00, 5);
insert into tb_restaurante (id, nome, valor_refeicao, cidade_id) values (6, 'Coco Bambu', 110.00, 6);
insert into tb_restaurante (id, nome, valor_refeicao, cidade_id) values (7, 'Outback', 125.00, 7);
insert into tb_restaurante (id, nome, valor_refeicao, cidade_id) values (8, 'NightDog', 90.00, 1);
insert into tb_restaurante (id, nome, valor_refeicao, cidade_id) values (9, 'Bar do Alemão', 125.00, 2);
insert into tb_restaurante (id, nome, valor_refeicao, cidade_id) values (10, 'Japas Grill', 130.00, 3);
insert into tb_restaurante (id, nome, valor_refeicao, cidade_id) values (11, 'Montanna', 90.00, 4);

insert into tb_pacote (id, data_viagem, dias_permanencia, refeicoes_por_dia, cidade_id, hotel_id, restaurante_id) values (1, '2023-07-14 10:27:37.306', 4, 2, 1, 1, 1);
insert into tb_pacote (id, data_viagem, dias_permanencia, refeicoes_por_dia, cidade_id, hotel_id, restaurante_id) values (2, '2023-07-14 10:27:37.306', 4, 2, 2, 2, 2);
insert into tb_pacote (id, data_viagem, dias_permanencia, refeicoes_por_dia, cidade_id, hotel_id, restaurante_id) values (3, '2023-07-14 10:27:37.306', 4, 2, 3, 3, 3);
insert into tb_pacote (id, data_viagem, dias_permanencia, refeicoes_por_dia, cidade_id, hotel_id, restaurante_id) values (4, '2023-07-14 10:27:37.306', 4, 2, 4, 4, 4);
insert into tb_pacote (id, data_viagem, dias_permanencia, refeicoes_por_dia, cidade_id, hotel_id, restaurante_id) values (5, '2023-07-14 10:27:37.306', 6, 2, 5, 5, 5);
insert into tb_pacote (id, data_viagem, dias_permanencia, refeicoes_por_dia, cidade_id, hotel_id, restaurante_id) values (6, '2023-07-14 10:27:37.306', 6, 2, 6, 6, 6);
insert into tb_pacote (id, data_viagem, dias_permanencia, refeicoes_por_dia, cidade_id, hotel_id, restaurante_id) values (7, '2023-07-14 10:27:37.306', 6, 2, 7, 7, 7);
insert into tb_pacote (id, data_viagem, dias_permanencia, refeicoes_por_dia, cidade_id, hotel_id, restaurante_id) values (8, '2023-07-14 10:27:37.306', 6, 4, 1, 8, 8);
insert into tb_pacote (id, data_viagem, dias_permanencia, refeicoes_por_dia, cidade_id, hotel_id, restaurante_id) values (9, '2022-07-14 10:27:37.306', 8, 4, 2, 9, 9);
insert into tb_pacote (id, data_viagem, dias_permanencia, refeicoes_por_dia, cidade_id, hotel_id, restaurante_id) values (10, '2022-07-14 10:27:37.306', 8, 4, 3, 10, 10);
insert into tb_pacote (id, data_viagem, dias_permanencia, refeicoes_por_dia, cidade_id, hotel_id, restaurante_id) values (11, '2022-07-14 10:27:37.306', 8, 4, 4, 11, 11);
insert into tb_pacote (id, data_viagem, dias_permanencia, refeicoes_por_dia, cidade_id, hotel_id, restaurante_id) values (12, '2022-07-14 10:27:37.306', 10, 4, 6, 1, 1);
insert into tb_pacote (id, data_viagem, dias_permanencia, refeicoes_por_dia, cidade_id, hotel_id, restaurante_id) values (13, '2022-07-14 10:27:37.306', 10, 4, 5, 2, 2);
insert into tb_pacote (id, data_viagem, dias_permanencia, refeicoes_por_dia, cidade_id, hotel_id, restaurante_id) values (14, '2022-07-14 10:27:37.306', 10, 4, 7, 3, 3);
insert into tb_pacote (id, data_viagem, dias_permanencia, refeicoes_por_dia, cidade_id, hotel_id, restaurante_id) values (15, '2022-07-14 10:27:37.306', 10, 4, 1, 4, 4);
insert into tb_pacote (id, data_viagem, dias_permanencia, refeicoes_por_dia, cidade_id, hotel_id, restaurante_id) values (16, '2022-07-14 10:27:37.306', 10, 4, 2, 5, 5);



