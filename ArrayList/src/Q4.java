import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Q4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite a quantidade de números a serem adicionados: ");
        int quantidade = scanner.nextInt();
        
        HashSet<Integer> numerosDistintos = new HashSet<>();
        
        while (numerosDistintos.size() < quantidade) {
            int numeroAleatorio = (int) (Math.random() * 100) + 1;
            numerosDistintos.add(numeroAleatorio);
        }
        
        ArrayList<Integer> listaNumeros = new ArrayList<>(numerosDistintos);
        
        System.out.println("Lista original: " + listaNumeros);
        
        Collections.sort(listaNumeros);
        System.out.println("Lista ordenada (crescente): " + listaNumeros);
        
        Collections.reverse(listaNumeros);
        System.out.println("Lista ordenada (decrescente): " + listaNumeros);
        
        scanner.close();
    }
}