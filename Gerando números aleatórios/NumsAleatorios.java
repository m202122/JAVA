import java.util.Random;

/*
    Na verdade a classe Random gera números pseudoaleatórios com base em cálculos matemáticos complexos - a
sequência de números parece ser aleatória. O cálculo que produz os números utiliza o horário do dia atual. 
*/

public class NumsAleatorios {
   
    public static void main(String[] args) 
    {
        // Idéia:   
        // number = valorDoDeslocamento + diferençaEntreValores * randomNumbers.nextInt(fatorDeDeslocamento)
        
        int getNumber = 0;
        Random randomNumbers = new Random();
        getNumber = randomNumbers.nextInt(6); // Gera número entre 0 e 5
        getNumber = 1 + randomNumbers.nextInt(6); // Gera número entre 1 e 6
        getNumber = 2 + 3*randomNumbers.nextInt(5); // Produz um número da sequência 2,5,8,11 e 14
        
    }
    
}
