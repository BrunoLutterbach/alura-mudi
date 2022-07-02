package br.com.brunolutterbach.controller;

import br.com.brunolutterbach.model.Pedido;
import br.com.brunolutterbach.model.StatusPedido;
import br.com.brunolutterbach.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("{status}")
    public String aguardando(@PathVariable("status") String status, Model model) {
        List<Pedido> pedidos = pedidoRepository.findByStatus(StatusPedido.valueOf(status.toUpperCase()));
        model.addAttribute("pedidos", pedidos);
        model.addAttribute("status", status);
        return "home";
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String onErro() {
        return "redirect:/home";
    }

}

