package com.xpeducacao.service;

import com.xpeducacao.dto.ClienteDTO;
import com.xpeducacao.model.Cliente;
import com.xpeducacao.repository.ClienteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public ClienteDTO salvar(ClienteDTO dto) {
        Cliente cliente = new Cliente();
        BeanUtils.copyProperties(dto, cliente);
        repository.save(cliente);
        dto.setId(cliente.getId());
        return dto;
    }

    public Page<ClienteDTO> listar(Pageable pageable) {
        return repository.findAll(pageable).map(this::toDTO);
    }

    public ClienteDTO buscarPorId(Long id) {
        return repository.findById(id).map(this::toDTO).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }

    public Page<ClienteDTO> buscarPorNome(String nome, Pageable pageable) {
        return repository.findByNomeContainingIgnoreCase(nome, pageable).map(this::toDTO);
    }

    public ClienteDTO atualizar(Long id, ClienteDTO dto) {
        Cliente cliente = repository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        cliente.setNome(dto.getNome());
        cliente.setEmail(dto.getEmail());
        repository.save(cliente);
        return toDTO(cliente);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    public long contar() {
        return repository.count();
    }

    private ClienteDTO toDTO(Cliente cliente) {
        ClienteDTO dto = new ClienteDTO();
        BeanUtils.copyProperties(cliente, dto);
        return dto;
    }
}