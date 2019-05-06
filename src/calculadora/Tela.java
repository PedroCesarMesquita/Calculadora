package calculadora;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

/**
 * Tela de escrita e exibição das expressões aritméticas e resultados
 * @author PedroCesarMesquita
 */
public class Tela extends JTextField {
    public Tela() {
        setFont(new Font("Arial", Font.PLAIN, 32)); // Define o tamanho da fonte como 32px
        setHorizontalAlignment(SwingConstants.RIGHT); // Alinha texto à direita
        addKeyListener(new OuveTeclado()); // Adiciona evento de teclado
    }
    
    /**
     * Limpa o conteúdo da tela
     */
    public void limpa() {
        setText("");
    }
    
    /**
     * Apaga último caractere da expressão
     */
    public void apagaUltimo() {
        String expressao = getText(); // Pega a expressão escrita
        int tamanho = expressao.length(); // Pega o tamanho da expressão escrita
        if(tamanho >= 1) // Testa se há pelo menos 1 caractere
            setText(expressao.substring(0, tamanho - 1)); // Apaga último caractere
    }
    
    /**
     * Insere texto (número, operador aritmético ou ponto) no final da expressão
     * @param texto o texto a ser inserido no final da expressão
     */
    public void insere(String texto) {
        setText(getText() + texto);
    }
    
    /**
     * Calcula e mostra o resultado da expressão na tela
     */
    public void mostraResultado() {
        double resultado = Calculo.eval(getText()); // Calcula o resultado da expressão
        if(resultado == (int) resultado) // Testa se o resultado é inteiro
            setText("" + (int) resultado); // Limpa e escreve o resultado na tela sem casas decimais
        else
            setText("" + resultado); // Limpa e escreve o resultado na tela com casas decimais
    }
    
    private class OuveTeclado implements KeyListener {
        @Override
        public void keyPressed(KeyEvent evento) {}
        @Override
        public void keyReleased(KeyEvent evento) {
            char caractere = evento.getKeyChar(); // Pega caractere da tecla solta
            if(caractere == '\n') { // Se a tecla for Enter
                mostraResultado(); // Calcula resultado e apresenta na tela
            } else if(caractere == ',') { // Se a tecla for vírgula
                apagaUltimo(); // Apaga a vírgula
                insere("."); // Insere ponto
            }
        }
        @Override
        public void keyTyped(KeyEvent evento) {}
    }
}
