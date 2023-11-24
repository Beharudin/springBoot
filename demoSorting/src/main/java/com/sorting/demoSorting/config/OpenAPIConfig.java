package com.sorting.demoSorting.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(info = @Info(
        contact = @Contact(
                name = "Bhr Mmd",
                email = "bhr@gmail.com",
                url = "https://bhrwebsite.com/products"
        ),
       description = "OpenAPI documentation for products",
        title = "OpenAPI specifications-Products",
        license = @License(
                name = "My license name",
                url = "https://mylicence.com"
        ),
        termsOfService = "Terms of service",
        version = "1.0"
),
        servers = {
            @Server(
                    description = "Local Env",
                    url = "http://localhost:8080"
            ),
            @Server(
                    description = "Prod Env",
                    url = "https://bhrwebsite.com/server"
            )
        }
)
public class OpenAPIConfig {
}
