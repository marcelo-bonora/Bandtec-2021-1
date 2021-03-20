-- todas as instruções DML de SQL neste arquivo são executadas assim que a API inicia
-- DML: insert, delete, update
-- este arquivo deve, necessariamente, se chamar 'data.sql' e estar na paste 'resources'

-- cada instrução deve estar finalizada com ; (ponto e vírgula)

insert into musica (nome, ano, nacional)
values
('musica 1', 1991, true),
('musica 22', 1982, false),
('musica 333', 2013, true),
('musica 4444', 2014, false);