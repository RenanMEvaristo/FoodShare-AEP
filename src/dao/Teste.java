package dao;

import java.sql.Connection;

public class Teste {
    public static void main(String[] args) {
        System.out.println("Tentando conectar com o MySQL...");
        try (Connection conn = ConnectionFactory.getConnection()) {
            if (conn != null) {
                System.out.println("SUCESSO: Conectado ao banco foodshare_db!");
            }
        } catch (Exception e) {
            System.out.println("ERRO ao conectar:");
            e.printStackTrace();
        }
    }
}