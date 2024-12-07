import java.util.ArrayList;
import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        ArrayList<String> telefones = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String opcao;

        do {
            System.out.println("Escolha uma opção: (a) adicionar telefone, (r) remover telefone, (l) listar telefones, (s) Sair");
            opcao = scanner.nextLine();

            switch (opcao) {
                case "a":
                    System.out.print("Digite o telefone a adicionar: ");
                    String telefone = scanner.nextLine();
                    telefones.add(telefone);
                    System.out.println("Telefone adicionado.");
                    break;
                case "r":
                    System.out.print("Digite a posição do telefone a remover: ");
                    int posicao = scanner.nextInt();
                    scanner.nextLine();
                    if (posicao >= 0 && posicao < telefones.size()) {
                        telefones.remove(posicao);
                        System.out.println("Telefone removido.");
                    } else {
                        System.out.println("Posição inválida.");
                    }
                    break;
                case "l":
                    System.out.println("Lista de telefones:");
                    for (int i = 0; i < telefones.size(); i++) {
                        System.out.println(i + ": " + telefones.get(i));
                    }
                    break;
                case "s":
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (!opcao.equals("s"));

        scanner.close();
    }
}