# Testes Unitários - BioEdifica Backend

## 📋 Visão Geral

Este diretório contém testes unitários simples para a camada de **Service** do BioEdifica, utilizando **JUnit 5** e **Mockito**.

> **📚 Documentação Completa:** Consulte o arquivo `TESTES-JUNIT.md` na raiz do projeto para guia detalhado sobre como criar e executar testes.

## 🧪 Estrutura de Testes

### Services Testados

| Service | Testes | Descrição |
|---------|--------|-----------|
| **EstadoService** | 7 | CRUD estados brasileiros, verificação de existência |
| **CidadeService** | 5 | CRUD cidades |
| **ProjetoService** | 6 | CRUD projetos de edificação |

**Total: 18 testes unitários**

## 🚀 Executando os Testes

### Executar todos os testes

```bash
# Com Maven wrapper (Linux/Mac)
./mvnw test

# Com Maven wrapper (Windows)
mvnw.cmd test

# Com Maven instalado
mvn test
```

### Executar testes de um service específico

```bash
# Exemplo: testar apenas EstadoService
./mvnw test -Dtest=EstadoServiceTest

# Windows
mvnw.cmd test -Dtest=EstadoServiceTest
```

### Executar um teste específico

```bash
./mvnw test -Dtest=EstadoServiceTest#testSalvarEstado
```

## 🛠️ Tecnologias Utilizadas

- **JUnit 5**: Framework de testes unitários
- **Mockito**: Framework para criação de mocks (objetos simulados)
- **AssertJ**: Assertions mais fluentes e legíveis
- **Spring Boot Test**: Suporte a testes no Spring Boot
- **Lombok**: Builders para criação de DTOs nos testes

## 📁 Estrutura de Arquivos

```
src/test/java/com/edifica/bioedifica/
└── service/
    ├── EstadoServiceTest.java       # 7 testes - CRUD estados
    ├── CidadeServiceTest.java       # 5 testes - CRUD cidades
    └── ProjetoServiceTest.java      # 6 testes - CRUD projetos
```

## 🔧 Configuração dos Testes

Os testes utilizam **Mockito** para simular as dependências:

```java
@ExtendWith(MockitoExtension.class)  // Habilita Mockito
class EstadoServiceTest {
    
    @Mock  // Cria mock do repository
    private IEstadoRepository estadoRepository;
    
    @InjectMocks  // Injeta mocks no service
    private EstadoService estadoService;
    
    @BeforeEach  // Executa antes de cada teste
    void setUp() {
        // Preparar dados de teste
    }
}
```

## 📊 Padrão AAA (Arrange-Act-Assert)

Todos os testes seguem este padrão:

```java
@Test
@DisplayName("Deve salvar estado com sucesso")
void testSalvarEstado() {
    // ARRANGE (Preparar): Configurar mocks e dados
    EstadoDTO estadoDTO = EstadoDTO.builder()
        .uf("MG")
        .nome("Minas Gerais")
        .build();
    
    Estado estado = new Estado();
    estado.setId(1L);
    estado.setUf("MG");
    
    when(estadoRepository.save(any(Estado.class))).thenReturn(estado);

    // ACT (Executar): Chamar o método testado
    EstadoDTO resultado = estadoService.salvar(estadoDTO);

    // ASSERT (Verificar): Validar resultado
    assertNotNull(resultado);
    assertEquals("MG", resultado.getUf());
    verify(estadoRepository, times(1)).save(any(Estado.class));
}
```

### Exemplo: Teste de Busca

```java
@Test
@DisplayName("Deve buscar estado por ID")
void testBuscarEstadoPorId() {
    // Arrange
    Estado estado = new Estado();
    estado.setId(1L);
    estado.setUf("MG");
    
    when(estadoRepository.findById(1L)).thenReturn(Optional.of(estado));

    // Act
    Optional<EstadoDTO> resultado = estadoService.buscarPorId(1L);

    // Assert
    assertTrue(resultado.isPresent());
    assertEquals("MG", resultado.get().getUf());
    verify(estadoRepository, times(1)).findById(1L);
}
```

### Exemplo: Teste de Lista Vazia

```java
@Test
@DisplayName("Deve retornar vazio quando estado não existe")
void testBuscarEstadoInexistente() {
    // Arrange
    when(estadoRepository.findById(999L)).thenReturn(Optional.empty());

    // Act
    Optional<EstadoDTO> resultado = estadoService.buscarPorId(999L);

    // Assert
    assertFalse(resultado.isPresent());
    verify(estadoRepository, times(1)).findById(999L);
}
```

## 🎯 Cobertura de Testes

### EstadoService (7 testes)
- ✅ Salvar estado
- ✅ Listar todos os estados
- ✅ Buscar estado por ID
- ✅ Buscar estado inexistente (retorna vazio)
- ✅ Buscar estado por UF
- ✅ Verificar se estado existe por UF
- ✅ Deletar estado

### CidadeService (5 testes)
- ✅ Salvar cidade
- ✅ Listar todas as cidades
- ✅ Buscar cidade por ID
- ✅ Buscar cidade inexistente (retorna vazio)
- ✅ Deletar cidade

### ProjetoService (6 testes)
- ✅ Criar projeto
- ✅ Buscar projeto por ID
- ✅ Listar projetos do usuário
- ✅ Buscar projeto inexistente (retorna vazio)
- ✅ Deletar projeto

## 🐛 Troubleshooting

### Erro: NullPointerException no teste
**Causa:** Mock não configurado  
**Solução:** Verifique se o mock está anotado com `@Mock` e o comportamento foi configurado com `when()`

### Erro: UnnecessaryStubbingException
**Causa:** Mock configurado mas não usado no teste  
**Solução:** Remova o `when()` não utilizado ou use-o no teste

### Teste passa mas não deveria
**Causa:** Falta de assertions  
**Solução:** Sempre valide o resultado com `assertNotNull()`, `assertEquals()`, etc.

## 📚 Referências

- [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide/)
- [Mockito Documentation](https://javadoc.io/doc/org.mockito/mockito-core/latest/org/mockito/Mockito.html)
- [Spring Boot Testing](https://docs.spring.io/spring-boot/docs/current/reference/html/features.html#features.testing)

## 👥 Contribuindo

Ao adicionar novos testes de service:

1. Crie arquivo `NomeServiceTest.java` em `src/test/java/.../service/`
2. Use `@ExtendWith(MockitoExtension.class)`
3. Mock os repositories com `@Mock`
4. Injete mocks com `@InjectMocks` no service
5. Siga padrão de nomenclatura: `test[Ação][Resultado]()` 
6. Use `@DisplayName` para descrição legível
7. Siga padrão AAA (Arrange-Act-Assert)
8. Atualize este README com a contagem de testes

## 📚 Documentação Completa

Para guia completo sobre JUnit e Mockito, consulte:
- **TESTES-JUNIT.md** na raiz do projeto

---

**Última atualização:** Novembro 2025  
**Cobertura total:** 18 testes unitários cobrindo 3 services
