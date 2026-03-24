# SmartRH

Aplicação Java JDBC para sistema de RH.

## Sobre o projeto

A aplicação é para fins didáticos, não há frontend, o objetivo é exercicitar a lógica de programação
e orientação a objetos, sendo possível realizar:

- CRUD com filtros dos funcionários
- Cálculo de salário
- Classes específicas para cada cargo(com atributos específicos) herdando de uma classe pai

## Tecnologias utilizadas

- Java 11
- Maven
- PostgreSQL

## Instruções SQL

```sql
-- Criação tabela de funcionarios
CREATE TABLE funcionarios (
     id serial4 NOT NULL,
     nome varchar(100) NOT NULL,
     email varchar(100) NOT NULL,
     salario_base float4 NULL,
     cpf varchar(11) NOT NULL,
     cargo varchar(150) NULL,
     CONSTRAINT funcionarios_pkey PRIMARY KEY (id)
);

-- Criação da tabela de gerentes
CREATE TABLE gerentes (
     id serial4 NOT NULL,
     id_funcionario int4 NULL,
     area varchar(100) NOT NULL,
     CONSTRAINT gerentes_pkey PRIMARY KEY (id),
     CONSTRAINT fk_funcionario FOREIGN KEY (id_funcionario) REFERENCES funcionarios(id)
);

-- Criação da tabela de desenvolvedores
CREATE TABLE desenvolvedores (
    id serial4 NOT NULL,
    linguagem varchar(50) NOT NULL,
    id_funcionario int4 NOT NULL,
    CONSTRAINT desenvolvedores_pkey PRIMARY KEY (id),
    CONSTRAINT fk_funcionario FOREIGN KEY (id_funcionario) REFERENCES funcionarios(id)
);

-- Criação da tabela de assistentes
CREATE TABLE public.assistentes (
    id serial4 NOT NULL,
    senioridade varchar(10) NULL,
    id_funcionario int4 NULL,
    CONSTRAINT assistentes_pkey PRIMARY KEY (id),
    CONSTRAINT fk_funcionario FOREIGN KEY (id_funcionario) REFERENCES funcionarios(id)
);
```