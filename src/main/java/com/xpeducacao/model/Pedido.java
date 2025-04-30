package com.xpeducacao.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;
    private Double valorTotal;

    @ManyToOne
    private Cliente cliente;

    @ManyToMany
    private List<Produto> produtos;
}