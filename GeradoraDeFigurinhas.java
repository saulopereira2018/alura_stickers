import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
//import java.net.URL;
import java.awt.Color;
import java.awt.Font;
import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {

    void cria(InputStream inputStream, String nomeArquivo) throws Exception {

        // leitura da imagem
        // BufferedImage imagemOriginal = ImageIO.read(new
        // File("../entrada/filme.jpg"));

        // pegar direto da URL
        // InputStream inputStream = new URL(
        // "https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_UX128_CR0,3,128,176_AL_.jpg")
        // .openStream();
        ufferedImage imagemOriginal = ImageIO.read(inputStream);

        // cria nova img com transparência e com novo tamanho
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        // copiar a imagem orginal pra nova img (em memoria)
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        // escrever uma frase na imagem
        graphics.drawImage(imagemOriginal, 0, 0, null);

        // setar a fonte
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 26);
        graphics.setColor(Color.YELLOW);
        graphics.setFont(fonte);

        // escrever uma frase na nova imagem
        graphics.drawString("TOPZERA", 0, novaAltura - 80);

        // escrever a nova img em um arquivo

        // salvando com nome especifico
        // ImageIO.write(novaImagem, "png", new File("../saida/figurinha.png"));

        ImageIO.write(novaImagem, "png", new File(nomeArquivo));

    }

    // main foi usado apenas para testar
    // public static void main(String[] args) throws Exception {
    // var geradora = new GeradoraDeFigurinhas();
    // geradora.cria();
    // }

}