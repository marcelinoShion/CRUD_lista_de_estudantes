package org.example.service;

import org.example.entity.Estudante;
import org.example.repository.EstudanteRepository;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class EstudanteService {

    public static  void estudanteFindAll(){
        List<Estudante> estudantes = EstudanteRepository.findAll();
        for (int i = 0 ; i < estudantes.size() ; i ++){
            String linha = "Id : %d |Nome : %s | Idade : %d ".formatted(estudantes.get(i).getId(),estudantes.get(i).getNome(), estudantes.get(i).getIdade());
            System.out.println(linha);
        }
    }
    public static void estudantesFindById(){
        Scanner scanner = new Scanner(System.in);
        try{
            System.out.print("Insira o numero do id :");
            int id = scanner.nextInt();
            List<Estudante> estudantes = EstudanteRepository.findById(id);
            var estudante = estudantes.get(0);
            String linha = "Id : %d | Nome: %s | Idade :%d".formatted(estudante.getId(),estudante.getNome(),estudante.getIdade());
            System.out.println(linha);
        } catch (Exception e) {
            throw new InputMismatchException("Insira o numero do id");
        }

    }
    public static void estudanteSave(){
        Scanner scanner = new Scanner(System.in);
        try{
            System.out.print("Insira o nome : ");
            String nome = scanner.nextLine();
            System.out.print("insira a idade : ");
            int idade = scanner.nextInt();
            Estudante estudante = new Estudante(nome,idade);
            EstudanteRepository.save(estudante);
        } catch (Exception e) {
            throw new InputMismatchException("Insira o mesmo tipo de valor");
        }

    }
    public static void estudanteUpdate(){
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Insira o numero do id :");
            int id = scanner.nextInt();

            System.out.println("insira a idade");
            int idade = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Insira o nome :");
            String nome = scanner.nextLine();
            Estudante estudante = new Estudante(id,nome, idade);
            EstudanteRepository.update(estudante);
        } catch (Exception e) {
            throw new InputMismatchException("Insira o tipo de valor correto");
        }
    }

    public static void estudanteDelete(){
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Insira o numero do id :");
            int id = scanner.nextInt();
            EstudanteRepository.delete(id);
        } catch (Exception e) {
            throw new InputMismatchException("Insira um numero");
        }
    }
    public static void estudantesFindByName() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Insira o nome :");
            String nome = scanner.nextLine();
            List<Estudante> estudantes = EstudanteRepository.findByName(nome);
            var estudante = estudantes.get(0);
            String linha = "Id : %d | Nome: %s | Idade :%d".formatted(estudante.getId(), estudante.getNome(), estudante.getIdade());
            System.out.println(linha);
        } catch (Exception e) {
            throw new InputMismatchException("Insira o numero do id");
        }
    }
}
