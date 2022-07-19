import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    // APP ALURA. ALUNO: SAULO PEREIRA DA SILVA

    public static void main(String[] args) throws Exception {
        // realizar conexão http e buscar os top 250 filmes
        String url = "https://alura-imdb-api.herokuapp.com/movies";
        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();

        // System.out.println(body);
        // extrair dados (titulo, poster, classificação)

        var parser = new JsonParser();
        // chamar classe JsonParser.java

        List<Map<String, String>> listaDeFilmes = parser.parse(body);
        // System.out.println(listaDeFilmes.size()); //exibir a quantidade de itens
        // System.out.println(listaDeFilmes.get(0));

        // exibir e manipular dados
        for (Map<String, String> filme : listaDeFilmes) {
            console.log("\u001b[37;1m \u001b[44;1m Alura \u001b[m");
            System.out.println(filme.get("title"));
            System.out.println(filme.get("image"));
            System.out.println(filme.get("imDbRatting"));
            System.out.println();
        }

    }
}
