package com.xpeducacao.service;

import com.xpeducacao.dto.ProdutoDTO;
import com.xpeducacao.model.Produto;
import com.xpeducacao.repository.ProdutoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {
    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public ProdutoDTO salvar(ProdutoDTO dto) {
        Produto entity = new Produto();
        BeanUtils.copyProperties(dto, entity);
        repository.save(entity);
        dto.setId(entity.getId());
        return dto;
    }

    public Page<ProdutoDTO> listar(Pageable pageable) {
        return repository.findAll(pageable).map(this::toDTO);
    }

    public ProdutoDTO buscarPorId(Long id) {
        return repository.findById(id).map(this::toDTO).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    public ProdutoDTO atualizar(Long id, ProdutoDTO dto) {
        Produto entity = repository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        entity.setNome(dto.getNome());
        entity.setPreco(dto.getPreco());
        repository.save(entity);
        return toDTO(entity);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    public long contar() {
        return repository.count();
    }

    private ProdutoDTO toDTO(Produto produto) {
        ProdutoDTO dto = new ProdutoDTO();
        BeanUtils.copyProperties(produto, dto);
        return dto;
    }
}