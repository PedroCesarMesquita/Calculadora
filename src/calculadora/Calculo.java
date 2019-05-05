package calculadora;

/**
 * Cálculos aritméticos
 * @author PedroCesarMesquita
 */
public class Calculo {

    /**
     * Resolve uma expressão aritmética com dois números apenas.
     * @param exp   expressão a ser resolvida
     * @return  resultado da expressão
     */
    public static double eval(String exp) {
        int len = exp.length(); // Pega o tamanho da string da expressão
        char operador = ' ';
        double n1 = 0.0, n2 = 0.0;
        for(int i = 1; i < len; i++) { // Percorre string a fim de achar o operador
            char c = exp.charAt(i); // Pega o caractere na i-ésima posição da string
            if(ehOperador(c)) { // Testa se o caractere é um operador
                operador = c; // Armazena operador
                n1 = Double.parseDouble(exp.substring(0, i)); // Pega número que vem antes do operador
                n2 = Double.parseDouble(exp.substring(i + 1, len)); // Pega número que vem depois do operador
                break; // Para a procura pelo operador
            }
        }
        if(operador == '+') return n1 + n2; // Retorna a soma dos dois números se o operador for de adição
        if(operador == '-') return n1 - n2; // Retorna a diferença se o operador for de subtração
        if(operador == '*' || operador == 'x' || operador == 'X') return n1 * n2; // Retorna o produto se o operador for de multiplicação
        if(operador == '/' || operador == ':') return n1 / n2; // Retorna a divisão se o operador for de divisão
        return exp.length() > 0 ? Double.parseDouble(exp) : 0.0; // Retorna a própria expressão como número se não for encontrado um operador
    }
    
    /**
     * Valida um caractere como operador aritmético.
     * @param caractere caractere a ser validado
     * @return  se o caractere é um operador aritmético
     */
    public static boolean ehOperador(char caractere) {
        return caractere == '+' || caractere == '-' || caractere == '*' || caractere == 'x' || caractere == 'X' || caractere == '/' || caractere == ':';
    }
}
