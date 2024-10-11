# Etapa 1: Construir o aplicativo
FROM eclipse-temurin:17-jdk AS build

# Instala o Maven no contêiner
RUN apt-get update && apt-get install -y maven

# Define o diretório de trabalho
WORKDIR /app

# Copia o arquivo pom.xml para resolver as dependências do Maven
COPY pom.xml .

# Baixa as dependências do Maven
RUN mvn dependency:go-offline

# Copia todo o código fonte para o diretório de trabalho do contêiner
COPY src ./src

# Executa o comando de build do Maven
RUN mvn package -DskipTests

# Etapa 2: Executar o aplicativo
FROM eclipse-temurin:17-jre

# Define o diretório de trabalho
WORKDIR /app

# Copia o arquivo JAR do build anterior para o contêiner
COPY --from=build /app/target/demo-0.0.1-SNAPSHOT.jar /app/demo.jar

# Expõe a porta que será usada pela aplicação
EXPOSE 8080

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "/app/demo.jar"]
