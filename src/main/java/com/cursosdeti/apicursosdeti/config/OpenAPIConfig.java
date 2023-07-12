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
                .description("A API \"Cursos de TI\" fornece acesso a informa��es sobre diferentes tipos de cursos relacionados � Tecnologia da Informa��o (TI). Por meio dessa API, os usu�rios podem obter detalhes sobre os diversos cursos dispon�veis, como programa��o, banco de dados, seguran�a da informa��o, redes, desenvolvimento web, intelig�ncia artificial e muito mais. Cada tipo de curso possui informa��es relevantes, como descri��o, requisitos, dura��o, certifica��es associadas e poss�veis �reas de atua��o ap�s a conclus�o do curso. Os desenvolvedores podem utilizar a API \"Cursos de TI\" para exibir os tipos de cursos dispon�veis em seus aplicativos, sites ou sistemas, fornecendo aos usu�rios acesso atualizado e detalhado sobre as op��es de aprendizado em TI.").termsOfService("https://www.bezkoder.com/terms")
                .license(mitLicense);

        return new OpenAPI().info(info).servers(List.of(devServer));
    }
}