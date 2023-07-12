package com.cursosdeti.apicursosdeti.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

import java.util.List;


@Configuration
public class OpenAPIConfig {
    @Value("${rodrigoNascimento.openapi.dev-url}")
    private String devUrl;


    @Bean
    public OpenAPI myOpenAPI() {
        Server devServer = new Server();
        devServer.setUrl(devUrl);
        devServer.setDescription("Server URL in Development environment");


        License mitLicense = new License().name("MIT License").url("https://choosealicense.com/licenses/mit/");

        Info info = new Info()
                .title("API Course Ti Types")
                .version("1.0")
                .description("A API \"Cursos de TI\" fornece acesso a informações sobre diferentes tipos de cursos relacionados à Tecnologia da Informação (TI). Por meio dessa API, os usuários podem obter detalhes sobre os diversos cursos disponíveis, como programação, banco de dados, segurança da informação, redes, desenvolvimento web, inteligência artificial e muito mais. Cada tipo de curso possui informações relevantes, como descrição, requisitos, duração, certificações associadas e possíveis áreas de atuação após a conclusão do curso. Os desenvolvedores podem utilizar a API \"Cursos de TI\" para exibir os tipos de cursos disponíveis em seus aplicativos, sites ou sistemas, fornecendo aos usuários acesso atualizado e detalhado sobre as opções de aprendizado em TI.").termsOfService("https://www.bezkoder.com/terms")
                .license(mitLicense);

        return new OpenAPI().info(info).servers(List.of(devServer));
    }
}