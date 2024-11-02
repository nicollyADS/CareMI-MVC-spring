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
@Table(name = "t_paciente")
@EntityListeners(AuditingEntityListener.class)
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "templates/paciente")
    @SequenceGenerator(name = "templates/paciente", sequenceName = "seq_mi_paciente", allocationSize = 1)
    @Column(name = "cdPaciente", length = 9)
    private Long id;

    @NotBlank(message = "O nome do paciente é obrigatório.")
    @Size(max = 100, message = "O nome do paciente deve ter no máximo 100 caracteres.")
    @Column(name = "nmPaciente", length = 100, nullable = false)
    private String nome;

    @NotNull(message = "A data de nascimento é obrigatória.")
    @Column(name = "dtNascimento", nullable = false)
    private LocalDate dataNascimento;

    @NotBlank(message = "O CPF é obrigatório.")
    @Column(name = "nrCpf", length = 15, nullable = false)
    private String cpf;

    @NotBlank(message = "O RG é obrigatório.")
    @Column(name = "nrRg", length = 15, nullable = false)
    private String rg;

    @Enumerated(EnumType.STRING)
    @Column(name = "dsEstadoCivil", length = 100)
    private EstadoCivil estadoCivil;

    @NotNull(message = "O peso é obrigatório.")
    @Positive(message = "O peso deve ser um número positivo.")
    @Column(name = "nrPeso", nullable = false)
    private Integer peso;

    @NotNull(message = "A altura é obrigatória.")
    @Positive(message = "A altura deve ser um número positivo.")
    @Column(name = "nrAltura", nullable = false)
    private Integer altura;

    @NotBlank(message = "O grupo sanguíneo é obrigatório.")
    @Size(max = 6, message = "O grupo sanguíneo deve ter no máximo 6 caracteres.")
    @Column(name = "nmGrupoSanguineo", length = 6, nullable = false)
    private String grupoSanguineo;

    @Enumerated(EnumType.STRING)
    @Column(name = "flSexoBiologico", length = 15, nullable = false)
    private SexoBiologico sexoBiologico;

    // RELACIONAMENTOS
    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
    private List<Atendimento> atendimentos;
}
