package br.com.mapped.caremi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "t_exame")
@EntityListeners(AuditingEntityListener.class)
public class Exame {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "templates/exame")
    @SequenceGenerator(name = "templates/exame", sequenceName = "seq_mi_exame", allocationSize = 1)
    @Column(name = "cdExame", length = 9)
    private Long id;

    @NotNull(message = "A data do exame é obrigatória.")
    @Column(name = "dtExame", nullable = false)
    private LocalDate data;

    @NotBlank(message = "A descrição do exame é obrigatória.")
    @Column(name = "dsExame", length = 500, nullable = false)
    private String descricao;

    // RELACIONAMENTOS
    @ManyToOne
    @JoinColumn(name = "cdAtendimento", nullable = false)
    private Atendimento atendimento;

    @OneToOne(mappedBy = "exame", cascade = CascadeType.ALL)
    private ResultadoExame resultadoExame;
}
