# Calcular distância consumindo outra API
---
## Pré-requisitos para rodar o projeto.
> Ter uma IDE (Ex:Eclipse).
---
>Obter uma chave em [Geoapify](https://apidocs.geoapify.com/).
---
>Trocar todos os campos de **URL** de **YOUR_KEY** para sua chave.
---


## Sobre o projeto.
---
Projeto Spring Boot Maven com Linguagem Java 11, consumindo duas API's a [Route Matrix](https://apidocs.geoapify.com/docs/route-matrix/#about) e a 
[Batch](https://apidocs.geoapify.com/docs/geocoding/batch/#code-samples), a API **Batch** recebe uma lista de endereço em String fazendo a requisição **POST** ela retorna uma **URL**, sendo nescessário usar uma requisição **GET** para receber valores como longitude e latitude, que são nescessários para a requisição **POST** da API **Route Matrix** que faz cálculos de distância de um ponto ao outro.

#### Pontos a melhorar
Como o projeto ultiliza duas API's, uma depende da outra, sendo assim assíncrona.Há um retardo pois tem que aguardar carregar a URL antes de fazer o GET para receber a latitude e longitude.No máximo 5 endereços podem ser inclusos em uma requisição.
