-- todas as instruções DML de SQL neste arquivo são executadas assim que a API inicia
-- DML: insert, delete, update
-- este arquivo deve, necessariamente, se chamar 'data.sql' e estar na pasta 'resources'

-- cada instrução deve estar finalizada com ; (ponto e vírgula)
insert into pokemon (id, forca, nome, solto)
values
(null, 1000, 'Monstro 1', false),
(null, 22000, 'Monstro 22', false),
(null, 333000, 'Monstro 333', true);

insert into treinador_pokemon (id, nome, idade, pokemons_capturados)
values
(null, 'Ash', 10, 6),
(null, 'Grey', 11, 16);