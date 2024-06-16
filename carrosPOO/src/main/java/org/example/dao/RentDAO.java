package org.example.dao;

import org.example.model.RentACar;

import java.sql.Connection; // Correção da importação
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RentDAO {

    public List<RentACar> getRent() {
        List<RentACar> carRent = new ArrayList<>();
        String query = "SELECT nome_do_carro, data_inicio, data_devolucao, valor, cor, placa FROM rentACar";

        try (Connection connection = ConnectionFactory.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                String nomeCarro = resultSet.getString("nome_do_carro");
                String dataInicio = resultSet.getString("data_inicio");
                String dataDevolucao = resultSet.getString("data_devolucao");
                double valor = resultSet.getDouble("valor");
                String cor = resultSet.getString("cor");
                String placa = resultSet.getString("placa");

                RentACar car = new RentACar(nomeCarro, dataInicio, dataDevolucao, valor, cor, placa);
                carRent.add(car); // Adiciona o objeto à lista
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return carRent;
    }
}
