package com.xpeducacao.controller;

import com.xpeducacao.dto.ClienteDTO;
import com.xpeducacao.service.ClienteService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @PostMapping
    public ClienteDTO criar(@RequestBody ClienteDTO dto) {
        return service.salvar(dto);
    }

    @GetMapping
    public Page<ClienteDTO> listar(Pageable pageable) {
        return service.listar(pageable);
    }

    @GetMapping("/{id}")
    public ClienteDTO buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @GetMapping("/buscar")
    public Page<ClienteDTO> buscarPorNome(@RequestParam String nome, Pageable pageable) {
        return service.buscarPorNome(nome, pageable);
    }

    @PutMapping("/{id}")
    public ClienteDTO atualizar(@PathVariable Long id, @RequestBody ClienteDTO dto) {
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