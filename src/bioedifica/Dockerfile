# ========================================
# Fase 1: Build da aplicação com Maven
# ========================================
FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /app

# Copiar arquivos de configuração do Maven
COPY pom.xml .

# Copiar código-fonte
COPY src ./src

# Compilar aplicação (pular testes para acelerar build)
RUN mvn clean package -DskipTests

# ========================================
# Fase 2: Imagem final otimizada (runtime)
# ========================================
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Copiar apenas o JAR compilado da fase anterior
COPY --from=build /app/target/*.jar app.jar

# Expor porta padrão (Render substitui dinamicamente)
EXPOSE 8080

# Comando de inicialização
ENTRYPOINT ["java", "-jar", "app.jar"]
