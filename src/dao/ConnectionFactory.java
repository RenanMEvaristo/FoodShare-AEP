package dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

    private static String url = "jdbc:mysql://localhost:3306/foodshare_db?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static String user = "root";
    private static String password = "";

    static {
        try (FileInputStream input = new FileInputStream("db.properties")) {
            Properties prop = new Properties();
            prop.load(input);

            url = prop.getProperty("db.url", url);
            user = prop.getProperty("db.user", user);
            password = prop.getProperty("db.password", password);
        } catch (IOException e) {
            System.out.println("[AVISO] Arquivo db.properties nao encontrado. Usando configuracoes padrao de conexao.");
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}