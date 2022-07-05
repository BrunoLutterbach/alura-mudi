package br.com.brunolutterbach.controller;

import br.com.brunolutterbach.dto.RequisicaoNovoPedido;
import br.com.brunolutterbach.model.Pedido;
import br.com.brunolutterbach.model.User;
import br.com.brunolutterbach.repository.PedidoRepository;
import br.com.brunolutterbach.repository.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
// Todas as requisições de pedido vão para esse controller.
@RequestMapping("pedido")
public class PedidoController {

    private final PedidoRepository pedidoRepository;
    private final UserRepository userRepository;

    public PedidoController(PedidoRepository pedidoRepository, UserRepository userRepository) {
        this.pedidoRepository = pedidoRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("formulario")
    public String formulario(RequisicaoNovoPedido requisicaoNovoPedido) {
        return "pedido/formulario";
        // Abre a página dentro da pasta pedido/formulario.html
    }

    @PostMapping("novo")
    public String novo(@Valid RequisicaoNovoPedido requisicaoNovoPedido, BindingResult result) {
        if (result.hasErrors()) {
            return "pedido/formulario";
        }

        // Pega o usuário logado no sistema.
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUserName(username);

        Pedido pedido = requisicaoNovoPedido.toPedido();
        pedido.setUser(user);
        pedidoRepository.save(pedido);

        return "redirect:/home";
    }

}
