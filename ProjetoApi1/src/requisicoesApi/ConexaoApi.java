package requisicoesApi;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class ConexaoApi {
    public void buscaHttpOmbd() {


        Scanner leitura = new Scanner(System.in);// aqui a gnt instancia a classe Scanner com a referencia leitura
        System.out.println("Digite um nome de filme: ");// apenas a saida (label) do scanner
        String busca = leitura.nextLine();// faremos a leitura da "proximaLinha"

        String endereco = "http://www.omdbapi.com/?t=" + busca + "&apikey=eedaf58e";// esse é o endereço da API

        HttpClient client = HttpClient.newHttpClient();// aqui e a forma de acessar essa API
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();

        HttpResponse<String> response;

        try { // aqui é apenas umas excessao quaso de algum problema n para o programa
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Não conseguimos acessar esse Filme");
        }
        String json = response.body();
        System.out.println(json);

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .create();
    }
}
