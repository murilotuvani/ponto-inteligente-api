CREATE TABLE `empresa` (
  `empr_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cnpj` varchar(255) NOT NULL,
  `data_atualizacao` datetime NOT NULL,
  `data_criacao` datetime NOT NULL,
  `razao_social` varchar(255) NOT NULL,
  primary key(empr_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `funcionario` (
  `func_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cpf` varchar(255) NOT NULL,
  `data_atualizacao` datetime NOT NULL,
  `data_criacao` datetime NOT NULL,
  `email` varchar(255) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `perfil` ENUM('ROLE_ADMIN','ROLE_USUARIO') NOT NULL,
  `qtd_horas_almoco` float DEFAULT NULL,
  `qtd_horas_trabalho_dia` float DEFAULT NULL,
  `senha` varchar(255) NOT NULL,
  `valor_hora` decimal(19,2) DEFAULT NULL,
  `empr_id` bigint(20) DEFAULT NULL,
   primary key (func_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `lancamento` (
  `lanc_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `data` datetime NOT NULL,
  `data_atualizacao` datetime NOT NULL,
  `data_criacao` datetime NOT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  `localizacao` varchar(255) DEFAULT NULL,
  `tipo` ENUM('INICIO_TRABALHO','TERMINO_TRABALHO','INICIO_ALMOCO','TERMINO_ALMOCO','INICIO_PAUSA','TERMINO_PAUSA') NOT NULL,
  `func_id` bigint(20) DEFAULT NULL,
  primary key (lanc_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for table `funcionario`
--
ALTER TABLE `funcionario`
  ADD CONSTRAINT fk_func_empr FOREIGN KEY `fk_func_empr` (`empr_id`) REFERENCES empresa (empr_id);

--
-- Indexes for table `lancamento`
--
ALTER TABLE `lancamento`
  ADD CONSTRAINT fk_lanc_func FOREIGN KEY `fk_lanc_func` (`func_id`) REFERENCES funcionario (func_id);
