package br.com.mapped.caremi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "t_resultado_exame")
@EntityListeners(AuditingEntityListener.class)
public class ResultadoExame {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "resultadoExame")
    @SequenceGenerator(name = "resultadoExame", sequenceName = "seq_mi_rs_exame", allocationSize = 1)
    @Column(name = "cdResultado", length = 9)
    private Long id;

    @NotBlank(message = "A descrição do resultado é obrigatória.")
    @Size(max = 500, message = "A descrição do resultado deve ter no máximo 500 caracteres.")
    @Column(name = "dsResultado", length = 500, nullable = false)
    private String descricaoExame;

    @NotBlank(message = "As observações são obrigatórias.")
    @Size(max = 100, message = "As observações devem ter no máximo 100 caracteres.")
    @Column(name = "dsObservacoes", length = 100, nullable = false)
    private String observacao;

    @NotNull(message = "O resultado é obrigatório.")
    @Min(value = 0, message = "O resultado deve ser um número positivo.")
    @Column(name = "vrResultado", nullable = false)
    private Integer resultado;

    @NotNull(message = "O número de glóbulos vermelhos é obrigatório.")
    @Min(value = 0, message = "O número de glóbulos vermelhos deve ser positivo.")
    @Column(name = "nrGlobulosVermelhos", nullable = false)
    private Integer globulosVermelhos;

    @NotNull(message = "O número de glóbulos brancos é obrigatório.")
    @Min(value = 0, message = "O número de glóbulos brancos deve ser positivo.")
    @Column(name = "nrGlobulosBrancos", nullable = false)
    private Integer globulosBrancos;

    @NotNull(message = "O número de plaquetas é obrigatório.")
    @Min(value = 0, message = "O número de plaquetas deve ser positivo.")
    @Column(name = "nrPlaquetas", nullable = false)
    private Integer plaquetas;

    @NotNull(message = "O nível de hemoglobina glicada é obrigatório.")
    @Min(value = 0, message = "O nível de hemoglobina glicada deve ser positivo.")
    @Column(name = "nrHomoglobinaGlicada", nullable = false)
    private Integer homoglobinaGlicada;

    @NotNull(message = "O nível de creatina é obrigatório.")
    @Min(value = 0, message = "O nível de creatina deve ser positivo.")
    @Column(name = "nrCreatina", nullable = false)
    private Integer creatina;

    @NotNull(message = "O nível de colesterol total é obrigatório.")
    @Min(value = 0, message = "O nível de colesterol total deve ser positivo.")
    @Column(name = "nrColesterolTotal", nullable = false)
    private Integer colesterolTotal;

    @NotNull(message = "O nível de colesterol HDL é obrigatório.")
    @Min(value = 0, message = "O nível de colesterol HDL deve ser positivo.")
    @Column(name = "nrColesterolHDL", nullable = false)
    private Integer colesterolHDL;

    @NotNull(message = "O nível de colesterol LDL é obrigatório.")
    @Min(value = 0, message = "O nível de colesterol LDL deve ser positivo.")
    @Column(name = "nrColesterolLDL", nullable = false)
    private Integer colesterolLDL;

    @NotNull(message = "O nível de triglicerídeos é obrigatório.")
    @Min(value = 0, message = "O nível de triglicerídeos deve ser positivo.")
    @Column(name = "nrTeglicerides", nullable = false)
    private Integer teglicerides;

    @NotNull(message = "O nível de TSH é obrigatório.")
    @Min(value = 0, message = "O nível de TSH deve ser positivo.")
    @Column(name = "nrHormonioTrioEstimulanteTSH", nullable = false)
    private Integer hormonioTrioestimulanteTSH;

    // RELACIONAMENTOS
    @OneToOne
    @JoinColumn(name = "cdExame", referencedColumnName = "cdExame", nullable = false)
    private Exame exame;
}
