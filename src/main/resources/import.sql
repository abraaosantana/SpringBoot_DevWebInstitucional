INSERT INTO public.seg_role(id_role, role) VALUES (1, 'ADMIN');
INSERT INTO public.seg_role(id_role, role) VALUES (2, 'USER');

INSERT INTO public.seg_usuario(id_usuario, ativo, data_criacao, cpf, email, nome, password, ultimo_nome) VALUES (1, true, now(), '87455814364', 'admin@devwebtecnologia.com', 'Administrador', '$2a$10$ES7Gc1Lv7XUGJXGwjZDv5uyobXmM/0Na4evoS1b9..ApL5cqE68QK', 'do Sistema');

INSERT INTO public.seg_usuario_role(id_usuario, id_role) VALUES (1, 1);
INSERT INTO public.seg_usuario_role(id_usuario, id_role) VALUES (1, 2);
    