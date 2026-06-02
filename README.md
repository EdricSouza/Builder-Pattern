# HTTP Request Builder

Projeto acadêmico da disciplina de Padrões de Projeto — **UCSal**.  
Demonstra o uso do **Builder Pattern** e padrões complementares na construção de um cliente HTTP em Java.

---

## Problema

Construir requisições HTTP com muitos parâmetros opcionais (url, method, headers, body, token…) resulta em construtores difíceis de ler e objetos instáveis quando responsabilidades de construção, validação e envio ficam na mesma classe.

---

## Solução

Separação em camadas com responsabilidade única, aplicando quatro padrões:

| Padrão | Classe | Responsabilidade |
|---|---|---|
| **Builder** | `HttpRequestBuilder` | Monta o objeto passo a passo, valida no `build()` e entrega um `HttpRequest` imutável |
| **Strategy** | `HttpMethodStrategy` | Elimina o `switch/case` — cada método HTTP é uma classe separada |
| **Factory Method** | `HttpMethodStrategyFactory` | Decide qual strategy instanciar sem expor as classes concretas |
| **Facade** | `HttpFacade` | API simplificada para os casos comuns (`get`, `postJson`, `putJson`) |

---

## Princípios SOLID

- **SRP** — cada classe tem uma única razão para mudar.
- **OCP** — adicionar PATCH requer apenas uma nova `PatchStrategy`, sem alterar classes existentes.
- **LSP** — qualquer implementação de `IHttpRequestBuilder` ou `HttpMethodStrategy` é substituível.
- **ISP** — `IHttpRequestBuilder` cobre só construção; envio fica em `HttpClient`.
- **DIP** — dependências apontam para abstrações (`IHttpRequestBuilder`, `HttpMethodStrategy`), não para implementações concretas.

---

## Uso

**Via Facade** — para chamadas diretas:
```java
HttpFacade http = new HttpFacade();
HttpResponse<String> res = http.get("https://jsonplaceholder.typicode.com/users");
HttpResponse<String> res = http.postJson("https://jsonplaceholder.typicode.com/posts", body);
```

**Via Builder** — para controle total:
```java
HttpRequest request = new HttpRequestBuilder()
    .method("GET")
    .url("https://api.exemplo.com/dados")
    .authorizationToken("Bearer meu-token")
    .queryParams(Map.of("pagina", "1"))
    .build();

new HttpClient().send(request);
```

---

## Como executar

**Pré-requisitos:** Java 17+ e Maven 3.8+

```bash
# Compilar e executar
mvn compile
mvn exec:java -Dexec.mainClass="com.ucsal.BuilderPatternApp"
```

A aplicação faz três chamadas reais à API pública `jsonplaceholder.typicode.com` (GET, POST e PUT) e imprime status e body de cada resposta.