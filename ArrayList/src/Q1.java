import java.util.ArrayList;
import java.util.Scanner;

class Cliente {
    private int id;
    private String nome;
    private int idade;
    private String telefone;

    public Cliente(int id, String nome, int idade, String telefone) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "ID=" + id +
                ", Nome='" + nome + '\'' +
                ", Idade=" + idade +
                ", Telefone='" + telefone + '\'' +
                '}';
    }
}

public class Q1 {
    public static void main(String[] args) {
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Digite o ID do cliente (negativo para sair): ");
            int id = scanner.nextInt();
            if (id < 0) {
                break;
            }

            System.out.print("Digite o nome do cliente: ");
            String nome = scanner.next();
            System.out.print("Digite a idade do cliente: ");
            int idade = scanner.nextInt();
            System.out.print("Digite o telefone do cliente: ");
            String telefone = scanner.next();

            Cliente cliente = new Cliente(id, nome, idade, telefone);
            listaClientes.add(cliente);
        }

        System.out.println("\nLista de Clientes:");
        for (Cliente cliente : listaClientes) {
            System.out.println(cliente);
        }

        scanner.close();
    }
}