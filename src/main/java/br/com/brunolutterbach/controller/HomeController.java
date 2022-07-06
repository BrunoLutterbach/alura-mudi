package br.com.brunolutterbach.controller;

import br.com.brunolutterbach.model.Pedido;
import br.com.brunolutterbach.model.StatusPedido;
import br.com.brunolutterbach.repository.PedidoRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping(("/home"))
public class HomeController {

    private final PedidoRepository pedidoRepository;

    public HomeController(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @GetMapping
    public String home(Model model, Principal principal) {
        List<Pedido> pedidos = pedidoRepository.findByStatus(StatusPedido.ENTREGUE, Sort.by("dataDaEntrega").descending());
        model.addAttribute("pedidos", pedidos);
        return "home";
    }
}

