package com.xpeducacao.service;

import com.xpeducacao.dto.PedidoDTO;
import com.xpeducacao.model.Cliente;
import com.xpeducacao.model.Pedido;
import com.xpeducacao.model.Produto;
import com.xpeducacao.repository.ClienteRepository;
import com.xpeducacao.repository.PedidoRepository;
import com.xpeducacao.repository.ProdutoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {
    private final PedidoRepository pedidoRepository;
    private final ClienteRepository clienteRepository;
    private final ProdutoRepository produtoRepository;

    public PedidoService(PedidoRepository pedidoRepository, ClienteRepository clienteRepository, ProdutoRepository produtoRepository) {
        this.pedidoRepository = pedidoRepository;
        this.clienteRepository = clienteRepository;
        this.produtoRepository = produtoRepository;
    }

    public PedidoDTO salvar(PedidoDTO dto) {
        Pedido pedido = new Pedido();
        pedido.setDescricao(dto.getDescricao());
        pedido.setValorTotal(dto.getValorTotal());
        pedido.setCliente(clienteRepository.findById(dto.getClienteId()).orElseThrow());
        pedido.setProdutos(produtoRepository.findAllById(dto.getProdutoIds()));
        pedido = pedidoRepository.save(pedido);
        dto.setId(pedido.getId());
        return dto;
    }

    public Page<PedidoDTO> listar(Pageable pageable) {
        return pedidoRepository.findAll(pageable).map(this::toDTO);
    }

    public PedidoDTO buscarPorId(Long id) {
        return pedidoRepository.findById(id).map(this::toDTO).orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
    }

    public PedidoDTO atualizar(Long id, PedidoDTO dto) {
        Pedido pedido = pedidoRepository.findById(id).orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
        pedido.setDescricao(dto.getDescricao());
        pedido.setValorTotal(dto.getValorTotal());
        pedido.setCliente(clienteRepository.findById(dto.getClienteId()).orElseThrow());
        pedido.setProdutos(produtoRepository.findAllById(dto.getProdutoIds()));
        pedidoRepository.save(pedido);
        return toDTO(pedido);
    }

    public void deletar(Long id) {
        pedidoRepository.deleteById(id);
    }

    public long contar() {
        return pedidoRepository.count();
    }

    private PedidoDTO toDTO(Pedido pedido) {
        PedidoDTO dto = new PedidoDTO();
        dto.setId(pedido.getId());
        dto.setDescricao(pedido.getDescricao());
        dto.setValorTotal(pedido.getValorTotal());
        dto.setClienteId(pedido.getCliente().getId());
        dto.setProdutoIds(pedido.getProdutos().stream().map(Produto::getId).toList());
        return dto;
    }
}