# Usa imagem base do JDK 17 leve
FROM eclipse-temurin:17-jdk-alpine
  
  # Define diretório de trabalho no container
WORKDIR /app
  
  # Copia todos os arquivos do projeto
COPY . .
  
  # Dá permissão para executar o mvnw
RUN chmod +x mvnw
  
  # Compila o projeto e gera o .jar
RUN ./mvnw clean package -DskipTests
  
  # Expõe a porta padrão do Spring Boot
EXPOSE 8080
  
  # Comando para rodar a aplicação
CMD ["java", "-jar", "target/ecommerce-0.0.1-SNAPSHOT.jar"]
