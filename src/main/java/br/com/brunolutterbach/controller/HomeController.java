package br.com.brunolutterbach.controller;

import br.com.brunolutterbach.model.Pedido;
import br.com.brunolutterbach.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.beans.BeanProperty;
import java.util.List;

@Controller
@RequestMapping(("/home"))
public class HomeController {

    // Autowired injeta o objeto PedidoRepository.
    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping
    public String home(Model model) {
        List<Pedido> pedidos = pedidoRepository.findAll();
        model.addAttribute("pedidos", pedidos);
        return "home";
    }

    @GetMapping("aguardando")
    public String aguardando(Model model) {
        List<Pedido> pedidos = pedidoRepository.findAll();
        model.addAttribute("pedidos", pedidos);
        return "home";
    }
}
