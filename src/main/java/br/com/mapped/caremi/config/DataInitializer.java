package br.com.mapped.caremi.config;

import br.com.mapped.caremi.model.Usuario;
import br.com.mapped.caremi.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {
    @Bean
    CommandLineRunner initDatabase(UsuarioRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            Usuario admin = new Usuario();
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("admin"));
            userRepository.save(admin);

            Usuario user = new Usuario();
            user.setUsername("user1");
            user.setPassword(passwordEncoder.encode("password"));
            userRepository.save(user);
        };
    }
}