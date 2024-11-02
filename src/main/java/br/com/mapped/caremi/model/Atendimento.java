package br.com.mapped.caremi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "t_atendimento")
@EntityListeners(AuditingEntityListener.class)
public class Atendimento {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "templates/atendimento")
    @SequenceGenerator(name = "templates/atendimento", sequenceName = "seq_mi_atendimento", allocationSize = 1)
    @Column(name = "cdAtendimento", length = 9)
    private Long id;

    @NotBlank(message = "A descrição é obrigatória.")
    @Size(max = 500, message = "A descrição não pode ter mais de 500 caracteres.")
    @Column(name = "dsDescricao", nullable = false)
    private String descricao;

    @NotNull(message = "A quantidade de dias é obrigatória.")
    @Min(value = 1, message = "A quantidade de dias deve ser pelo menos 1.")
    @Column(name = "qtDias", nullable = false)
    private Integer dias;

    @NotBlank(message = "O hábito é obrigatório.")
    @Size(max = 100, message = "O hábito não pode ter mais de 100 caracteres.")
    @Column(name = "dsHabito", nullable = false)
    private String habito;

    @NotBlank(message = "O tempo de sono é obrigatório.")
    @Size(max = 10, message = "O tempo de sono não pode ter mais de 10 caracteres.")
    @Column(name = "dsTempoSono", nullable = false)
    private String tempoSono;

    @NotBlank(message = "O histórico hereditário é obrigatório.")
    @Size(max = 50, message = "O histórico hereditário não pode ter mais de 50 caracteres.")
    @Column(name = "dsHereditario", nullable = false)
    private String hereditario;

    @NotNull(message = "A data de envio é obrigatória.")
    @Column(name = "dtEnvio", nullable = false)
    private LocalDate dataEnvio;

    @Column(name = "fgAtivo")
    private Integer ativo;

    // RELACIONAMENTOS
    @ManyToOne
    @JoinColumn(name = "cdPaciente", nullable = false)
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "cdMedico", nullable = false)
    private Medico medico;

    @OneToMany(mappedBy = "atendimento", cascade = CascadeType.ALL)
    private List<Exame> exames;
}
