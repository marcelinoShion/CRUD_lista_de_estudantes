package org.example.repository;

import org.example.connection.DbConnector;
import org.example.entity.Estudante;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EstudanteRepository {
    public static void save(Estudante estudante){
        String sql = "INSERT INTO public.\"Estudante\"(\n" +
                "\t nome, idade)\n" +
                "\tVALUES ( '%s', %d); ".formatted(estudante.getNome(),estudante.getIdade());
        try(Connection connection = DbConnector.getConnection();
            Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void delete(int id){
        String sql = "DELETE FROM public.\"Estudante\"\n" +
                "\tWHERE id = %s;".formatted(id);
        try(Connection connection = DbConnector.getConnection();
            Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void update(Estudante estudante){
        String sql = "UPDATE public.\"Estudante\"\n" +
                "\tSET  nome='%s', idade= '%d'\n WHERE id = '%d';".formatted(estudante.getNome(),estudante.getIdade(),estudante.getId());
        try(Connection connection = DbConnector.getConnection();
            Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static List<Estudante> findAll(){
        String sql = "SELECT id, nome, idade\n" +
                "\tFROM public.\"Estudante\";";
        List<Estudante> estudantes = new ArrayList<>();
        try(Connection connection = DbConnector.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                int idade = resultSet.getInt("idade");
                Estudante estudante = new Estudante(id,nome,idade);
                estudantes.add(estudante);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return estudantes;
    }
    public static List<Estudante> findById(int id){
        String sql = "SELECT id, nome, idade\n" +
                "\tFROM public.\"Estudante\" where id = %d;".formatted(id);
        List<Estudante> estudantes = new ArrayList<>();
        try(Connection connection = DbConnector.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()){
                int estudanteId = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                int idade = resultSet.getInt("idade");
                Estudante estudante = new Estudante(estudanteId,nome,idade);
                estudantes.add(estudante);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return estudantes;
    }
    public static List<Estudante> findByName(String nome){
        String sql = "SELECT id, nome, idade\n" +
                "\tFROM public.\"Estudante\" Where nome like '%s';".formatted(nome);
        List<Estudante> estudantes = new ArrayList<>();
        try(Connection connection = DbConnector.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String estudanteNome = resultSet.getString("nome");
                int idade = resultSet.getInt("idade");
                Estudante estudante = new Estudante(id,nome,idade);
                estudantes.add(estudante);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return estudantes;
    }
}
