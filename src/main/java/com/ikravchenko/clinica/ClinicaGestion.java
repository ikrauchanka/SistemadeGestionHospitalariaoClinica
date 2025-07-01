package com.ikravchenko.clinica;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

@SpringBootApplication
public class ClinicaGestion {

	public static void main(String[] args) {
		SpringApplication.run(ClinicaGestion.class, args);
	}

	@Bean
	public CommandLineRunner testDatabase(DataSource dataSource) {
		return args -> {
			System.out.println("🔍 Testing database connection and tables...");
			try (Connection connection = dataSource.getConnection()) {
				System.out.println("✅ Database connection successful!");
				
				DatabaseMetaData metaData = connection.getMetaData();
				System.out.println("📊 Database: " + metaData.getDatabaseProductName());
				System.out.println("📋 Version: " + metaData.getDatabaseProductVersion());
				
				// Check if tables exist
				ResultSet tables = metaData.getTables(null, null, "%", new String[]{"TABLE"});
				System.out.println("📋 Existing tables:");
				while (tables.next()) {
					String tableName = tables.getString("TABLE_NAME");
					System.out.println("   - " + tableName);
				}
				
				System.out.println("🎉 Database setup completed successfully!");
				
			} catch (SQLException e) {
				System.err.println("❌ Database connection failed!");
				System.err.println("Error: " + e.getMessage());
				e.printStackTrace();
			}
		};
	}
}
