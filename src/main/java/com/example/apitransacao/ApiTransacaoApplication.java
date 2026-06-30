package com.example.apitransacao;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "API de Transações",
                version = "1.0",
                description = "API para gerenciamento de transações.",
                contact = @Contact(
                        name = "Thiago",
                        email = "thiago@email.com"
                )
        )
)
public class ApiTransacaoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiTransacaoApplication.class, args);
    }

}
