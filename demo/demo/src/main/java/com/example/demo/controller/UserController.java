package com.example.demo.controller;

import com.example.demo.DTO.UserRegistrationDTO; // DTO para receber dados
import com.example.demo.model.User;  // Entidade (retorno)
import com.example.demo.service.UserService; // Service com lógica de negócio
import jakarta.validation.Valid;  // Validação automática
import org.springframework.web.bind.annotation.PostMapping; // Anotações para endpoints REST
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Indica que esta classe é um controller REST (retorna dados, não views)
@RestController
@RequestMapping("/api") // Define o prefixo base para todas as rotas deste controller
public class UserController {

    // Dependência do Service (injeção de dependência)
    private  final UserService userService;

    // Construtor para injeção de dependência
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Mapeia requisições POST para /api/users
    @PostMapping("/users")
    public User createUser(@Valid @RequestBody UserRegistrationDTO dto) {
        // @Valid: Ativa as validações definidas no DTO
        // @RequestBody: Converte automaticamente o JSON recebido para o objeto DTO
        // O controller NÃO faz a lógica, apenas repassa para o Service
        return userService.saveUser(dto);
        // Retorna o User salvo (convertido automaticamente para JSON)
    }




}


/*
Crie um endpoint POST /api/users no seu UserController que aceite este DTO. Use @Valid para ativar a validação.
Teste o endpoint com requisições válidas e inválidas (e-mail mal formatado, idade menor que 18, senha curta, etc.) e observe o comportamento.
 */