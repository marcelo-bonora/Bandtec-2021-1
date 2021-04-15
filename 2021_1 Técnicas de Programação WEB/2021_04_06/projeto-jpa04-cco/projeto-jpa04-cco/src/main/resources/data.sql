-- data.sql na pasta resources
insert into filme
(titulo, diretor, custo_producao, data_lancamento, classico)
values
('Filme uva A', 'AA', 100000, '2010-01-01', true),
('Filme uva BB', 'BB', 200000, '2012-02-02', true),
('Filme morango BB', 'BB', 300000, '2012-02-02', false),
('Filme morango CCC', 'AA', 400000, '2013-02-03', false),
('Filme morango DDDD', 'DD', 500000, '2014-04-04', false),
('Filme abacaxi EEEEE', 'Filho do AA Silva', 500000, '2014-04-04', false),
('Filme pêra FFFFFF', 'AA Júnior', 500000, '2014-04-04', true)
;