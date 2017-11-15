INSERT INTO public.seg_role(id_role, role) VALUES (1, 'ADMIN');
INSERT INTO public.seg_role(id_role, role) VALUES (2, 'USER');
INSERT INTO public.seg_usuario(id_usuario, ativo, cpf, data_criacao, email, login, nome, password, ultimo_nome) VALUES (1, true, '87455814364', now(), 'admin@devwebtecnologia.com', 'sistema.admin', 'Administrador', '$2a$10$Fk0JqwWLsH85v6APMw7Vi.APnGHpjZOtm3b7N14jW4xsJFRaOgw9O', 'do Sistema');
INSERT INTO public.seg_usuario(id_usuario, ativo, cpf, data_criacao, email, login, nome, password, ultimo_nome) VALUES (2, true, '61713047861', now(), 'user@devwebtecnologia.com', 'sistema.user', 'Usuário', '$2a$10$Fk0JqwWLsH85v6APMw7Vi.APnGHpjZOtm3b7N14jW4xsJFRaOgw9O', 'do Sistema');
INSERT INTO public.seg_usuario_role(id_usuario, id_role) VALUES (1, 1);
INSERT INTO public.seg_usuario_role(id_usuario, id_role) VALUES (1, 2);
INSERT INTO public.seg_usuario_role(id_usuario, id_role) VALUES (2, 2);
    