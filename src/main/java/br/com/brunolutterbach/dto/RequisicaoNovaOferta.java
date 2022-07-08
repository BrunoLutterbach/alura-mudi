package br.com.brunolutterbach.dto;

import br.com.brunolutterbach.model.Oferta;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
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

    @Pattern(regexp = "^[0-9]{1,3}\\.[0-9]{2}$", message = "Valor deve estar no formato 99.99")
    @NotNull
    private String valor;

    @Pattern(regexp = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/[0-9]{4}$", message = "Data deve estar no formato 01/01/2022")
    @NotNull
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
