package br.com.brunolutterbach.api;

import br.com.brunolutterbach.model.Pedido;
import br.com.brunolutterbach.model.StatusPedido;
import br.com.brunolutterbach.repository.PedidoRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidosRest {

    private final PedidoRepository pedidoRepository;

    public PedidosRest(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @GetMapping("/aguardando")
    public List<Pedido> getPedidosAguardandoOfertas() {
        return pedidoRepository.findByStatus(StatusPedido.AGUARDANDO, PageRequest.of(0, 10, Sort.by("id").descending()));
    }
}
