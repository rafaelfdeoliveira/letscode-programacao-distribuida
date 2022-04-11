    package com.letscode.reflection;

    import javax.persistence.Entity;

    @Entity(name = "teste")
    public class Pessoa {
        private String nome;
        private Integer idade;
        private String cpf;

        public Pessoa() {

        }

        public Pessoa(String nome) {
            this.nome = nome;
        }
    }
