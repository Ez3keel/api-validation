package com.example.demo.service;

import com.example.demo.DTO.UserRegistrationDTO; // Import da classe DTO
import com.example.demo.model.User; // Import da entidade User
import com.example.demo.repository.UserRepository; // Import do repositório
import org.springframework.stereotype.Service;  // Import da anotação Service

@Service // Anotação que marca esta classe como um bean de serviço do Spring
public class UserService {
    // Declaração da dependência como final (boa prática)
    private final UserRepository userRepository;

    //Injeção de dependência via constructor
    //É quando o Spring cria e fornece os objetos que sua classe precisa, em vez de você mesmo criá-los com new.
    public UserService(UserRepository userRepository) {
        // O Spring vê que o construtor precisa de um UserRepository
        // Ele automaticamente procura um bean do tipo UserRepository e fornece aqui
        this.userRepository = userRepository; // Atribui à variável de instância
    }

    public User saveUser(UserRegistrationDTO dto) {
            //Converte DTO para Entity
            User user = new User(
                    dto.getUsername(),
                    dto.getEmail(),
                    dto.getPassword(),
                    dto.getAge()
            );
            return userRepository.save(user);
    }
}
