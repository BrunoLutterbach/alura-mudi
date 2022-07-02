package br.com.brunolutterbach.dto;

import br.com.brunolutterbach.model.Pedido;
import br.com.brunolutterbach.model.StatusPedido;
import lombok.*;

import javax.validation.constraints.NotBlank;

 @Getter
 @Setter
 @ToString
 @RequiredArgsConstructor
public class RequisicaoNovoPedido {

    @NotBlank(message = "Este campo não deve estar em branco!")
    private String nomeProduto;

    @NotBlank(message = "Este campo não deve estar em branco!")
    private String urlProduto;

    @NotBlank(message = "Este campo não deve estar em branco!")
    private String urlImagem;
    private String descricao;


    // Retorna um Pedido com os dados da requisição.
    public Pedido toPedido() {
        Pedido pedido = new Pedido();
        pedido.setNomeProduto(nomeProduto);
        pedido.setUrlProduto(urlProduto);
        pedido.setUrlImagem(urlImagem);
        pedido.setDescricao(descricao);
        pedido.setStatus(StatusPedido.AGUARDANDO);
        return pedido;
    }
}
