/**
 * FibonacciMemoization
 * 
 * Esta classe implementa o cálculo do n-ésimo número de Fibonacci usando memoização.
 * 
 * por Felipe Campelo
 * https://www.felipecampelo.com.br
 */

import java.util.HashMap;
import java.util.Map;

public class FibonacciMemoization {

    // Memo para guardar os chamadas já calculadas
    private Map<Integer, Long> memo;

    // O construtor inicializa o memo
    public FibonacciMemoization() {
        memo = new HashMap<>();
    }

    // A função recursiva que calcula o n-ésimo número de Fibonacci
    // Long: proximo de n=50 o valor de Fibonacci excede o limite de um inteiro
    public long fibonacci(int n) {
        
        // Casos base:
        // F(0) = 0
        // F(1) = 1
        if (n <= 1)
            return n;
        
        // Se o valor já foi calculado, retorna o valor armazenado
        if (memo.containsKey(n))
            return memo.get(n);
        
        // Se não, calcula o valor e armazena no memo
        long result = fibonacci(n - 1) + fibonacci(n - 2);

        // Armazena o valor calculado com a chave n
        memo.put(n, result);

        return result;
    }

    public static void main(String[] args) {
        FibonacciMemoization fibMemo = new FibonacciMemoization();
        int n = 50; // You can change this to any number you want to compute
        long fib = fibMemo.fibonacci(n);
        System.out.println("/nFibonacci number at position " + n + " is: " + fib);
    }
}
