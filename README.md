# XPeducacao API

API RESTful desenvolvida em Java 17 utilizando Spring Boot 3.2.0 para gerenciar Clientes, Produtos e Pedidos.

## Tecnologias utilizadas

- Java 17
- Spring Boot 3.2.0
- Spring Data JPA
- Banco de Dados H2 (em memória)
- Swagger OpenAPI 3
- Lombok
- Maven

## Como rodar o projeto

1. Clone ou baixe o projeto.
2. Navegue até a raiz do projeto e execute:

```bash
mvn clean install
mvn spring-boot:run
```

3. Acesse a documentação Swagger UI:

```
http://localhost:8080/swagger-ui.html
```

4. Banco H2 Console:

```
http://localhost:8080/h2-console
```
- JDBC URL: `jdbc:h2:mem:testdb`
- Username: `sa`
- Password: *(deixe vazio)*

## Endpoints principais

### Clientes

- `POST /clientes` - Criar Cliente
- `GET /clientes` - Listar Clientes
- `GET /clientes/{id}` - Buscar Cliente por ID
- `GET /clientes/buscar?nome={nome}` - Buscar Clientes por Nome
- `PUT /clientes/{id}` - Atualizar Cliente
- `DELETE /clientes/{id}` - Deletar Cliente
- `GET /clientes/count` - Contar Clientes

### Produtos

- `POST /produtos` - Criar Produto
- `GET /produtos` - Listar Produtos
- `GET /produtos/{id}` - Buscar Produto por ID
- `PUT /produtos/{id}` - Atualizar Produto
- `DELETE /produtos/{id}` - Deletar Produto
- `GET /produtos/count` - Contar Produtos

### Pedidos

- `POST /pedidos` - Criar Pedido
- `GET /pedidos` - Listar Pedidos
- `GET /pedidos/{id}` - Buscar Pedido por ID
- `PUT /pedidos/{id}` - Atualizar Pedido
- `DELETE /pedidos/{id}` - Deletar Pedido
- `GET /pedidos/count` - Contar Pedidos

## Estrutura do Projeto

```
com.xpeducacao
├── controller
│   ├── ClienteController.java
│   ├── ProdutoController.java
│   └── PedidoController.java
├── dto
│   ├── ClienteDTO.java
│   ├── ProdutoDTO.java
│   └── PedidoDTO.java
├── model
│   ├── Cliente.java
│   ├── Produto.java
│   └── Pedido.java
├── repository
│   ├── ClienteRepository.java
│   ├── ProdutoRepository.java
│   └── PedidoRepository.java
├── service
│   ├── ClienteService.java
│   ├── ProdutoService.java
│   └── PedidoService.java
└── XpeducacaoApiApplication.java
```

## Collection Postman

Uma coleção pronta para testes no Postman está disponível: `xpeducacao_postman_collection_completa.json`

## Diagrama Arquitetural (C4 Model)

- C1: Contexto - Usuários acessando a API
- C2: Containers - API Spring Boot + Banco H2
- C3: Componentes - Controllers, Services, Repositories
- C4: Código - Fluxo Controller -> Service -> Repository -> H2

(Imagens .png incluídas nos arquivos)

## Autor

- Lucas Alcântara Lopes - 2025