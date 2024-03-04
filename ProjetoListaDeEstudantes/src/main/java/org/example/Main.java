package org.example;
import org.example.service.EstudanteService;

import java.util.InputMismatchException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        boolean  menuPrincipal = true ;
        int escolha = 0 ;
        while (menuPrincipal){
            System.out.println("_____________________________________");
            System.out.println();
            System.out.println("[1] Inserir um estudante");
            System.out.println("[2] Vizualizar todos os estudantes");
            System.out.println("[3] Encontrar estudante pelo id");
            System.out.println("[4] Encontrar estudante pelo nome");
            System.out.println("[5] Alterar estudante ");
            System.out.println("[6] Remover estudante");
            System.out.println("[0] Sair");
            System.out.println();
            System.out.println("_____________________________________");
            try{
                escolha = scanner.nextInt();

            } catch (Exception e) {
                throw  new InputMismatchException("Insira um numero");
            }finally {
                if (escolha == 1){
                    EstudanteService.estudanteSave();
                } else if (escolha == 2) {
                    EstudanteService.estudanteFindAll();

                } else if (escolha == 3) {
                    EstudanteService.estudantesFindById();

                } else if (escolha == 4) {

                    EstudanteService.estudantesFindByName();
                } else if (escolha == 5) {
                    EstudanteService.estudanteUpdate();
                } else if ( escolha == 6) {
                    EstudanteService.estudanteDelete();
                } else if (escolha == 0) {
                    menuPrincipal = false ;
                } else {
                    System.out.println("Numero Incorreto");
                }
            }
        }

    }
}