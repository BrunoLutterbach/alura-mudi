package br.com.brunolutterbach.api;

import br.com.brunolutterbach.dto.RequisicaoNovaOferta;
import br.com.brunolutterbach.model.Oferta;
import br.com.brunolutterbach.model.Pedido;
import br.com.brunolutterbach.repository.PedidoRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/ofertas")
public class OfertasRest {

    private final PedidoRepository pedidoRepository;

    public OfertasRest(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @PostMapping
    public Oferta criaOferta(@RequestBody RequisicaoNovaOferta requisicao) {

        Optional<Pedido> pedidoBuscado = pedidoRepository.findById(requisicao.getPedidoId());
        if (!pedidoBuscado.isPresent()) {
            throw new IllegalArgumentException("Pedido não encontrado");
        }
        Pedido pedido = pedidoBuscado.get();

        Oferta nova = requisicao.toOferta();
        nova.setPedido(pedido);
        pedido.getOfertas().add(nova);
        pedidoRepository.save(pedido);

        return nova;
    }

}
