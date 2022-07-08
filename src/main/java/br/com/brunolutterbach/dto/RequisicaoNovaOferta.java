package br.com.brunolutterbach.dto;

import br.com.brunolutterbach.model.Oferta;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
public class RequisicaoNovaOferta {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private Long pedidoId;

    private String valor;

    private String dataDaEntrega;

    private String comentario;

    public Oferta toOferta() {
        Oferta oferta = new Oferta();
        oferta.setComentario(this.comentario);
        oferta.setDataDaEntrega(LocalDate.parse(this.dataDaEntrega, FORMATTER));
        oferta.setValor(new BigDecimal(this.valor).setScale(2, RoundingMode.HALF_EVEN));
        return oferta;
    }
}
