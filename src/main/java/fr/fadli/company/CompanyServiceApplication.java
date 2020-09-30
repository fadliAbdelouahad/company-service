package fr.fadli.company;

import fr.fadli.company.dao.CompanyRepository;
import fr.fadli.company.entities.Company;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@EnableDiscoveryClient
@SpringBootApplication
public class CompanyServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CompanyServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CompanyRepository companyRepository){
        return args -> {
            Stream.of("A", "B", "C").forEach(s -> {
                companyRepository.save(new Company(null, s, 100 + Math.random() * 900));
            });

            companyRepository.findAll().forEach(System.out :: println);
        };
    }
}
