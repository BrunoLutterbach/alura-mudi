package br.com.brunolutterbach.repository;

import br.com.brunolutterbach.model.Pedido;
import br.com.brunolutterbach.model.StatusPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    List<Pedido> findByStatus(StatusPedido status);

}
