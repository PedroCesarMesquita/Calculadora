package calculadora;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Interface gráfica
 * @author PedroCesarMesquita
 */
public class GUI extends JFrame {
    
    Tela tela; // campo de texto
    Tecla[] teclas; // vetor contendo as teclas da calculadora
    
    /**
     * Construtor da interface gráfica.
     */
    public GUI() {
        super("Calculadora"); // Define o título da janela como Calculadora
        
        tela = new Tela(); // Tela de escrita e exibição onde será apresentada a expressão e resultado
        tela.setBounds(0, 0, 500, 100); // Define posicionamento e dimensões da tela de exibição
        add(tela); // Adiciona tela de exibição à janela
        
        JPanel teclado = new JPanel(); // Painel que contém as teclas
        teclado.setLayout(new GridLayout(5, 4)); // Define layout do teclado como uma Grid de 5 linhas e 4 colunas
        
        teclas = new Tecla[20]; // Aloca espaço para as 20 teclas no vetor
        teclas[0]  = new Tecla(); // Tecla inutilizada
        teclas[1]  = new Tecla(); // Tecla inutilizada
        teclas[2]  = new Tecla("C", Color.cyan ); // Tecla de limpeza
        teclas[3]  = new Tecla("<-", Color.cyan); // Backspace (apaga último caractere)
        teclas[4]  = new Tecla("7", Color.white); // Número 7
        teclas[5]  = new Tecla("8", Color.white); // Número 8
        teclas[6]  = new Tecla("9", Color.white); // Número 9
        teclas[7]  = new Tecla("/", Color.cyan ); // Operador de divisão
        teclas[8]  = new Tecla("4", Color.white); // Número 4
        teclas[9]  = new Tecla("5", Color.white); // Número 5
        teclas[10] = new Tecla("6", Color.white); // Número 6
        teclas[11] = new Tecla("x", Color.cyan ); // Operador de multiplicação
        teclas[12] = new Tecla("1", Color.white); // Número 1
        teclas[13] = new Tecla("2", Color.white); // Número 2
        teclas[14] = new Tecla("3", Color.white); // Número 3
        teclas[15] = new Tecla("-", Color.cyan ); // Operador de subtração
        teclas[16] = new Tecla(".", Color.cyan ); // Ponto (vírgula)
        teclas[17] = new Tecla("0", Color.white); // Número 0
        teclas[18] = new Tecla("=", Color.cyan ); // Resultado
        teclas[19] = new Tecla("+", Color.cyan ); // Operador de adição
        
        for(Tecla tecla : teclas) { // Percorre vetor de teclas
            tecla.addActionListener(new OuveClique()); // Adiciona evento de clique à tecla
            teclado.add(tecla); // Adiciona tecla ao painel teclado
        }
        teclado.setBounds(0, 100, 500, 400);
        add(teclado); // Adiciona painel teclado à janela
        
        setSize(516, 538); // Define tamanho da janela
        setLayout(null); // Remove layout da janela
        setLocationRelativeTo(null); // Centraliza janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fecha janela ao clicar em sair
        setVisible(true); // Torna janela visível
    }
    
    private class OuveClique implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evento) {
            for(Tecla tecla : teclas) { // Percorre vetor de teclas a fim de encontrar a tecla clicada
                if(tecla == evento.getSource()) { // Testa se tal tecla é a que foi clicada
                    
                    String textoTecla = tecla.getText(); // Pega texto da tecla
                    
                    switch(textoTecla) {
                        case "=": // Caso a tecla clicada seja a de resultado (=)
                            tela.mostraResultado(); // Calcula resultado e apresenta na tela
                            break;
                        case "C": // Caso a tecla clicada seja a de limpeza
                            tela.limpa(); // Limpa a tela
                            break;
                        case "<-": // Caso a tecla clicada seja a de backspace
                            tela.apagaUltimo(); // Apaga o último caractere
                            break;
                        default: // Caso seja um número, operador ou ponto
                            tela.insere(textoTecla); // Adiciona tal caractere à expressão
                    }
                    break; // Para a procura pela tecla
                }
            }
            tela.requestFocus(); // Leva o foco para a tela de exibição
        }
    }
}
