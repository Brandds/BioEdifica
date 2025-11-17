# Guia de Perfis de Aplicação Spring Boot

## 📋 Visão Geral

Este projeto utiliza **Spring Profiles** para gerenciar diferentes configurações de ambiente. Existem dois perfis principais:

- **`default`** (desenvolvimento local com H2)
- **`prod`** (produção com PostgreSQL no Render)

---

## 🔧 Arquivo `application-prod.properties`

### O que ele faz?

O arquivo `application-prod.properties` contém as configurações específicas para o ambiente de **produção**. Ele é ativado quando você executa a aplicação com o perfil `prod`.

### Principais Configurações

#### 1️⃣ **CORS (Cross-Origin Resource Sharing)**
```properties
cors.allowed-origins=https://bioedifica.vercel.app,https://bioedifica.netlify.app,...
```
- Define quais domínios podem acessar a API
- Inclui URLs de produção e localhost para testes

#### 2️⃣ **Conexão com PostgreSQL (Render)**
```properties
spring.datasource.url=jdbc:postgresql://dpg-d4af7fkhg0os738127rg-a.oregon-postgres.render.com:5432/bioedifica1
spring.datasource.username=bioedifica1_user
spring.datasource.password=UzxZsr45P8G1S1EOvjA0KBzYf9TrBMjl
```
- Conecta ao banco PostgreSQL hospedado no Render
- **⚠️ ATENÇÃO**: Nunca compartilhe essas credenciais publicamente (considere usar variáveis de ambiente)

#### 3️⃣ **Pool de Conexões (HikariCP)**
```properties
spring.datasource.hikari.maximum-pool-size=10
spring.datasource.hikari.minimum-idle=2
spring.datasource.hikari.connection-timeout=30000
```
- Otimiza o uso de conexões com o banco
- Evita sobrecarga em ambientes de produção

#### 4️⃣ **Controle de Schema (DDL)**
```properties
spring.jpa.hibernate.ddl-auto=validate
```
- **`validate`**: Apenas valida se o schema existe (NÃO cria/altera tabelas)
- Seguro para produção, evita perda de dados

#### 5️⃣ **Scripts SQL de Dados Iniciais**
```properties
spring.sql.init.mode=always
spring.sql.init.data-locations=classpath:db/data/*.sql
```
- Executa scripts SQL de `src/main/resources/db/data/` na inicialização
- Popula dados iniciais (usuários, projetos, etc.)
- **⚠️ IMPORTANTE**: Após primeira execução, mude para `never` para evitar duplicação

#### 6️⃣ **Logs Desabilitados**
```properties
spring.jpa.show-sql=false
logging.level.org.hibernate.SQL=WARN
```
- Reduz logs em produção para melhor performance

---

## 🏠 Como Executar em Desenvolvimento (H2 Local)

### Opção 1: Executar sem especificar perfil (padrão)
```bash
mvn spring-boot:run
```
ou
```bash
./mvnw spring-boot:run
```

### Opção 2: Especificar perfil explicitamente
```bash
mvn spring-boot:run -Dspring-boot.run.profiles=default
```

### O que acontece?
- Usa o arquivo `application.properties` (configuração padrão)
- Banco de dados **H2 em memória**
- Console H2 disponível em: `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:mem:testdb`
- Username: `sa`
- Password: *(vazio)*

---

## 🚀 Como Executar em Produção (PostgreSQL)

### Comando
```bash
mvn spring-boot:run -Dspring-boot.run.profiles=prod
```
ou
```bash
./mvnw spring-boot:run -Dspring-boot.run.profiles=prod
```

### O que acontece?
- Usa o arquivo `application-prod.properties`
- Conecta ao banco PostgreSQL no Render
- Executa scripts SQL de `db/data/`
- CORS configurado para domínios de produção

---

## 📂 Estrutura de Arquivos de Configuração

```
src/main/resources/
├── application.properties          # Configuração padrão (H2)
├── application-prod.properties     # Configuração de produção (PostgreSQL)
└── db/
    └── data/
        ├── 01-usuarios.sql         # Dados iniciais de usuários
        ├── 02-projetos.sql         # Dados iniciais de projetos
        └── ...
```

---

## ⚙️ Configuração do `application.properties` (Desenvolvimento)

Certifique-se de que seu arquivo padrão tenha estas configurações:

```properties
# H2 Database
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

# JPA/Hibernate
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.defer-datasource-initialization=true

# H2 Console
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

# Scripts SQL
spring.sql.init.mode=always
spring.sql.init.data-locations=classpath:db/data/*.sql

# Logs
spring.jpa.show-sql=true
logging.level.org.hibernate.SQL=DEBUG
```

---

## 🔄 Alternando Entre Ambientes

### Durante Desenvolvimento
```bash
# Usar H2 (padrão)
mvn spring-boot:run
```

### Para Testar Produção Localmente
```bash
# Usar PostgreSQL do Render
mvn spring-boot:run -Dspring-boot.run.profiles=prod
```

### No Render (Deploy Automático)
O Render detecta automaticamente o perfil `prod` através da variável de ambiente:
```
SPRING_PROFILES_ACTIVE=prod
```

---

## ⚠️ Boas Práticas

### 1. **Nunca commitar senhas**
Considere usar variáveis de ambiente:
```properties
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}
```

### 2. **Scripts SQL em Produção**
Após primeira execução, altere:
```properties
spring.sql.init.mode=never
```

### 3. **Validação de Schema**
Em produção, sempre use:
```properties
spring.jpa.hibernate.ddl-auto=validate
```

### 4. **Backup antes de Migrar**
Sempre faça backup do banco antes de executar scripts em produção.

---

## 🐛 Troubleshooting

### Erro: "Table already exists"
- Os scripts SQL estão sendo executados novamente
- Solução: Mude `spring.sql.init.mode=never` em produção

### Não consigo acessar H2 Console
- Verifique se `spring.h2.console.enabled=true`
- Acesse: `http://localhost:8080/h2-console`

### Erro de conexão com PostgreSQL
- Verifique se as credenciais estão corretas
- Teste conectividade com o servidor Render

---

## 📚 Referências

- [Spring Boot Profiles](https://docs.spring.io/spring-boot/docs/current/reference/html/features.html#features.profiles)
- [H2 Database](https://www.h2database.com/)
- [HikariCP Configuration](https://github.com/brettwooldridge/HikariCP#configuration-knobs-baby)
