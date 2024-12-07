import java.util.ArrayList;
import java.util.Scanner;

class Contato {
    String nome;
    String email;
    String telefone;

    public Contato(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Email: " + email + ", Telefone: " + telefone;
    }
}

class Agenda {
    private ArrayList<Contato> contatos;

    public Agenda() {
        contatos = new ArrayList<>();
    }

    public void incluir(Contato contato) {
        contatos.add(contato);
    }

    public void excluir(String nome) {
        contatos.removeIf(contato -> contato.nome.equalsIgnoreCase(nome));
    }

    public void listar() {
        if (contatos.isEmpty()) {
            System.out.println("Nenhum contato cadastrado.");
        } else {
            for (Contato contato : contatos) {
                System.out.println(contato);
            }
        }
    }

    public void pesquisar(String parteNome) {
        boolean encontrado = false;
        for (Contato contato : contatos) {
            if (contato.nome.toLowerCase().contains(parteNome.toLowerCase())) {
                System.out.println(contato);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("Nenhum contato encontrado com a parte do nome: " + parteNome);
        }
    }
}

public class Q5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Agenda agenda = new Agenda();
        int opcao;

        do {
            System.out.println("\nMenu:");
            System.out.println("[1] Incluir Contato");
            System.out.println("[2] Excluir Contato");
            System.out.println("[3] Listar Contatos");
            System.out.println("[4] Pesquisar Contato");
            System.out.println("[0] Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Telefone: ");
                    String telefone = scanner.nextLine();
                    agenda.incluir(new Contato(nome, email, telefone));
                    break;
                case 2:
                    System.out.print("Nome do contato a excluir: ");
                    String nomeExcluir = scanner.nextLine();
                    agenda.excluir(nomeExcluir);
                    break;
                case 3:
                    agenda.listar();
                    break;
                case 4:
                    System.out.print("Parte do nome a pesquisar: ");
                    String parteNome = scanner.nextLine();
                    agenda.pesquisar(parteNome);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}