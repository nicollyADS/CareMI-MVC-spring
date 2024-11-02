package br.com.mapped.caremi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name="t_usuario")
@EntityListeners(AuditingEntityListener.class)
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "templates/usuario")
    @SequenceGenerator(name = "templates/usuario", sequenceName = "seq_mi_usuario", allocationSize = 1)
    @Column(name = "cdUsuario", length = 9)
    private Long id;

    @Column(name = "nmUsuario", length = 20, nullable = false, unique = true)
    private String username;

    @Column(name = "dsSenha", length = 100, nullable = false)
    private String password;

    public Usuario(String username, String password) {
        this.username = username;
        this.password = password;
    }
}