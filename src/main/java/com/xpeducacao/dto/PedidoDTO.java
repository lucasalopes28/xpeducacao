package com.xpeducacao.dto;

import lombok.Data;
import java.util.List;

@Data
public class PedidoDTO {
    private Long id;
    private String descricao;
    private Double valorTotal;
    private Long clienteId;
    private List<Long> produtoIds;
}