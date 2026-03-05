package com.example.demo.DTO;

import jakarta.validation.constraints.*;

public class UserRegistrationDTO {
    /*
    ESQUEMA DE VALIDAÇÃO
     * username: @NotBlank, tamanho entre 5 e 20 caracteres.
     * email: @NotBlank, @Email.
     * password: @NotBlank, tamanho mínimo de 8 caracteres.
     * age: @NotNull, @Min(18).

      // Aqui poderia ter lógica de negócio:
        // - Verificar se email já existe
        // - Criptografar senha
        // - Validar regras de negócio
        // - Calcular algo

     */
    @NotBlank(message = "O nome de usuário não pode estar em branco.")
    @Size(min = 5, max = 20, message = "O tamanho deve ser entre 5 e 20 caracteres.")
    private String username;

    @NotBlank(message = "O email não pode estar em branco.")
    @Email(message = "O campo deve conter um endereço de e-mail válido.")
    private String email;

    @NotBlank(message = "A senha do usuário não pode estar em branco.")
    @Size(min = 8, message = "Tamanho mínimo de {min} caracteres.")
    private String password;

    @NotNull(message = "A idade não pode estar em branco.")
    @Min(value = 18, message = "A idade mínima é 18 anos.")
    private Integer age;

    // Construtor vazio obrigatório para o Spring
    public UserRegistrationDTO() {}

    //Constructor para inicializar as variaveis
    public UserRegistrationDTO( String username, String email, String password, Integer age) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.age = age;
    }

    //Getters
    public String getUsername() {return username;}
    public String getEmail() {return email;}
    public String getPassword() {return password;}
    public Integer getAge() {return age;}
}
