package br.com.brunolutterbach.controller;

import br.com.brunolutterbach.dto.RequisicaoNovoPedido;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
// Todas as requisições de pedido vão para esse controller.
@RequestMapping("pedido")
public class PedidoController {

    @GetMapping("formulario")
    public String formulario() {
        return "pedido/formulario";
        // Abre a página dentro da pasta pedido/formulario.html
    }

    @PostMapping("novo")
    public String novo(RequisicaoNovoPedido requisicaoNovoPedido) {
        return "pedido/formulario";
    }

}
