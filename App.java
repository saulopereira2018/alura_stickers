import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

public class App {
    // APP ALURA. ALUNO: SAULO PEREIRA DA SILVA

    /**
     * @param args
     * @throws Exception
     */
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
        var geradora = new GeradoraDeFigurinhas();
        for (Map<String, String> filme : listaDeFilmes) {
            // System.out.println(filme.get("image"));
            // System.out.println(filme.get("imDbRatting"));
            String urlImagem = filme.get("image");
            String titulo = filme.get("title");

            InputStream inputStream = new URL(urlImagem).openStream();
            String nomeArquivo = titulo + ".png";

            geradora.cria(inputStream, nomeArquivo);

            System.out.println(titulo);
            System.out.println();
        }

    }
}
