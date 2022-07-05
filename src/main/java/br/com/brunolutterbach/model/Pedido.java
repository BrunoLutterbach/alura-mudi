package br.com.brunolutterbach.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeProduto;
    private BigDecimal valorNegociado;
    private LocalDate dataDaEntrega;
    private String urlProduto;
    private String urlImagem;
    private String descricao;

    @Enumerated(EnumType.STRING)
    private StatusPedido status;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
