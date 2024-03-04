package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Estudante {
    private Integer id;
    private  String nome ;
    private int idade ;

    public Estudante(String nome , int idade){
        this.nome = nome ;
        this.idade = idade ;

    }
}
