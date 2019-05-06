package calculadora;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;

/**
 * Tecla personalizada da calculadora
 * @author PedroCesarMesquita
 */
public class Tecla extends JButton {

    /**
     * Construtor sem parâmetros.
     * Define o texto como vazio e a cor de fundo como cinza claro por padrão.
     */
    public Tecla() {
        this("", Color.lightGray);
    }
    
    /**
     * Construtor com apenas texto como parâmetro.
     * Define a cor de fundo como cinza claro por padrão.
     * @param texto texto da tecla
     */
    public Tecla(String texto) {
        this(texto, Color.lightGray);
    }
    
    /**
     * Construtor com apenas cor de fundo como parâmetro.
     * Define o texto como vazio por padrão.
     * @param cor   cor de fundo da tecla
     */
    public Tecla(Color cor) {
        this("", cor);
    }
    
    /**
     * Construtor com texto e cor de fundo como parâmetros.
     * @param texto texto da tecla
     * @param cor   cor de fundo da tecla
     */
    public Tecla(String texto, Color cor) {
        super(texto);
        setBackground(cor);
        setFont(new Font("Arial", Font.PLAIN, 32)); // Define o tamanho da fonte como 32px
    }
}
