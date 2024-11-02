package br.com.mapped.caremi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "t_medico")
@EntityListeners(AuditingEntityListener.class)
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "templates/medico")
    @SequenceGenerator(name = "templates/medico", sequenceName = "seq_mi_medico", allocationSize = 1)
    @Column(name = "cdMedico", length = 9)
    private Long id;

    @NotBlank(message = "O nome do médico é obrigatório.")
    @Size(max = 100, message = "O nome do médico deve ter no máximo 100 caracteres.")
    @Column(name = "nmMedico", length = 100, nullable = false)
    private String nome;

    @NotBlank(message = "A especialização do médico é obrigatória.")
    @Size(max = 200, message = "A especialização deve ter no máximo 200 caracteres.")
    @Column(name = "dsEspecializacao", length = 200, nullable = false)
    private String especializacao;

    @NotBlank(message = "O CRM do médico é obrigatório.")
    @Size(max = 15, message = "O CRM deve ter no máximo 15 caracteres.")
    @Column(name = "dsCrm", length = 15, nullable = false)
    private String crm;

    @NotBlank(message = "O email do médico é obrigatório.")
    @Email(message = "O email deve ser um endereço de email válido.")
    @Size(max = 100, message = "O email deve ter no máximo 100 caracteres.")
    @Column(name = "dsEmail", length = 100, nullable = false)
    private String email;

    @NotBlank(message = "O celular do médico é obrigatório.")
    @Size(max = 15, message = "O celular deve ter no máximo 15 caracteres.")
    @Column(name = "nrCelular", length = 15, nullable = false)
    private String celular;

    //RELACIONAMENTOS
    @OneToMany(mappedBy = "medico", cascade = CascadeType.ALL)
    private List<Atendimento> atendimentos;
}
