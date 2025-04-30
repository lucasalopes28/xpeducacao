package com.xpeducacao.controller;

import com.xpeducacao.dto.PedidoDTO;
import com.xpeducacao.service.PedidoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    private final PedidoService service;

    public PedidoController(PedidoService service) {
        this.service = service;
    }

    @PostMapping
    public PedidoDTO criar(@RequestBody PedidoDTO dto) {
        return service.salvar(dto);
    }

    @GetMapping
    public Page<PedidoDTO> listar(Pageable pageable) {
        return service.listar(pageable);
    }

    @GetMapping("/{id}")
    public PedidoDTO buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public PedidoDTO atualizar(@PathVariable Long id, @RequestBody PedidoDTO dto) {
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }

    @GetMapping("/count")
    public long contar() {
        return service.contar();
    }
}