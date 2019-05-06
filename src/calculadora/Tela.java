package calculadora;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;

/**
 * Tela de escrita e exibição das expressões aritméticas e resultados
 * @author PedroCesarMesquita
 */
public class Tela extends JTextField {
    public Tela() {
        setFont(new Font("Arial", Font.PLAIN, 32)); // Define o tamanho da fonte como 32px
        setHorizontalAlignment(SwingConstants.RIGHT); // Alinha texto à direita
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
}
