package com.projeto.eco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import javax.annotation.PostConstruct;
import java.sql.Connection;
import java.sql.DriverManager;

@SpringBootApplication
public class Eco {
    
    public static void main(String[] args) {
        SpringApplication.run(Eco.class, args);
    }

    @PostConstruct  // Executa após a inicialização do Spring
    public void testConnection() {
        try (Connection conn = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/eco?useSSL=false",
            "root",
            "manoela1998!")) {
            
            System.out.println("✅ Conexão bem-sucedida!");
        } catch (Exception e) {
            System.err.println("❌ Falha na conexão:");
            e.printStackTrace();
            // Força a parada da aplicação se a conexão falhar
            System.exit(1);
        }
    }
    static {
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (ClassNotFoundException e) {
        throw new RuntimeException("Driver não encontrado!", e);
    }
}
}