package view;

import controller.DoacaoController;

import java.util.Scanner;

public class MenuView {

    private Scanner scanner;
    private DoacaoController controller;

    public MenuView() {
        this.scanner = new Scanner(System.in);
        this.controller = new DoacaoController();
    }

    private void filtrarPorCategoria() {

        System.out.println("\n--Filtro por Categoria--");
        System.out.println("Digite o tipo de alimento");
        System.out.println("1 - Perecível");
        System.out.println("2 - Não perecível");

        int opcao = scanner.nextInt();
        scanner.nextLine();

        String categoriaSelecionada;

        if (opcao == 1) {

            categoriaSelecionada = "Perecível";

        } else if (opcao == 2) {

            categoriaSelecionada = "Não Perecível";

        } else {

            System.out.println("Opção Inválida! Escolha 1 ou 2");
            return;

        }

        java.util.List<model.Doacao> lista = controller.filtrarPorCategoria(categoriaSelecionada);

        if (lista.isEmpty()) {

            System.out.println("Categoria inválida (Perecível/Não Perecível");
            return;
        }

        for (model.Doacao f : lista) {

            System.out.println("ID: " + f.getId() +
                    " | Alimento: " + f.getDescricao() +
                    " | Categoria: " + f.getCategoria() +
                    " | Qtd: " + f.getQuantidade() +
                    " | Validade: " + f.getValidade() +
                    " | Status: " + f.getStatus());

        }

    }

    private void listarTodas() {

        System.out.println("\n-- Listagem de Doaçoes--");
        java.util.List<model.Doacao> lista = controller.listarTodas();

        if (lista.isEmpty()) {

            System.out.println("Nenhuma doaçao encontrada no banco");
            return;

        }

        for (model.Doacao d : lista) {

            System.out.println("ID: " + d.getId() +
                    " | Alimento: " + d.getDescricao() +
                    " | Categoria: " + d.getCategoria() +
                    " | Qtd: " + d.getQuantidade() +
                    " | Validade: " + d.getValidade() +
                    " | Status: " + d.getStatus());

        }

    }

    private void cadastrarDoacao() {

        System.out.println("\n--Novo Cadastro de Doação");

        System.out.println("ID do Doador (ex: 1 para Supermercado Central): ");
        int idDoador = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Descrição do Alimento (ex: Caixas de tomate): ");
        String descricao = scanner.nextLine();

        System.out.println("Digite o tipo de alimento");
        System.out.println("Categoria (Perecivel / Nao Perecivel");
        System.out.println("1 - Perecivel");
        System.out.println("2 - Não perecivel");

        int opcao = scanner.nextInt();
        scanner.nextLine();

        String categoriaSelecionada;

        if (opcao == 1) {

            categoriaSelecionada = "Perecivel";

        } else if (opcao == 2) {

            categoriaSelecionada = "Nao Perecivel";

        } else {

            System.out.println("Opção Inválida! Escolha 1 ou 2");
            return;

        }

        System.out.println("Quantidade (ex: 15.5)");
        double quantidade = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Data de validade (AAAA-MM-DD, ex: 2026-12-31)");
        String dataTexto = scanner.nextLine();
        java.time.LocalDate validade = java.time.LocalDate.parse(dataTexto);

        boolean sucesso = controller.cadastrarDoacao(idDoador, descricao, categoriaSelecionada, quantidade, validade);

        if (sucesso) {

            System.out.println("Doação Cadastrada com sucesso no banco de dados!!");

        } else {

            System.out.println("Falha ao cadastrar doação. Verifique os dados informados!!");

        }

    }

    public void atualizarStatus() {

        System.out.println("\n--- Atualizar Status da Doação ---");
        System.out.print("Digite o ID da doação: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Escolha o novo status:");
        System.out.println("1 - DISPONIVEL");
        System.out.println("2 - EM_TRANSITO");
        System.out.println("3 - FINALIZADA");
        System.out.println("4 - CANCELADA");
        System.out.print("Opção: ");
        int opcaoStatus = scanner.nextInt();
        scanner.nextLine();

        String statusSelecionado;

        if (opcaoStatus == 1) {

            statusSelecionado = "DISPONIVEL";

        } else if (opcaoStatus == 2) {

            statusSelecionado = "EM_TRANSITO";

        } else if (opcaoStatus == 3) {

            statusSelecionado = "FINALIZADA";

        } else if (opcaoStatus == 4) {

            statusSelecionado = "CANCELADA";

        } else {

            System.out.println("Opção Inválida! Escolha entre 1 e 4");
            return;

        }

        boolean sucesso = controller.atualizarStatus(id, statusSelecionado);

        if (sucesso) {

            System.out.println("Doação atualizada com sucesso!");

        } else {

            System.out.println("Status da doação não atualizada!");

        }

    }

    public void excluir() {

        System.out.println("Excluindo Doação");
        System.out.println("Digite o ID da doação a ser deletado: ");
        int idDoacao = scanner.nextInt();
        scanner.nextLine();

        boolean sucesso = controller.excluir(idDoacao);

        if (sucesso) {

            System.out.println("Doação deletada com sucesso!");

        } else {

            System.out.println("Doação não pode ser deletada!");

        }

    }

    public void testePolimorfismo() {

        System.out.println("Teste de polimorfismo");

        java.util.List<model.Notificavel> listaNotificaveis = new java.util.ArrayList<>();

        listaNotificaveis.add(new model.Doador("Supermercado Central", "Av. Brasil, 1500", "(44) 3030-1010",
                "contato@central.com", "12.345.678/0001-90", "Super Central"));
        listaNotificaveis.add(new model.Instituicao("Lar dos Idosos", "Rua Esperança, 88", "(44) 9988-1122",
                "contato@lar.org", "45.678.901/0001-23", "Irmã Maria", 250));

        for (model.Notificavel n : listaNotificaveis) {

            n.gerarAlerta();

        }

    }

    public void exibirMenu() {
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n==========================================");
            System.out.println("   FOODSHARE - CENTRAL DE DOAÇÕES");
            System.out.println("==========================================");
            System.out.println("1 - Cadastrar Doacão");
            System.out.println("2 - Listar Todas as Doações");
            System.out.println("3 - Filtrar por Categoria (Perecível/Não)");
            System.out.println("4 - Atualizar Status da Doação");
            System.out.println("5 - Excluir Doação");
            System.out.println("6 - Testar Alerta Polimórfico (Doador/ONG)");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarDoacao();
                    break;
                case 2:
                    listarTodas();
                    break;
                case 3:
                    filtrarPorCategoria();
                    break;
                case 4:
                    atualizarStatus();
                    break;
                case 5:
                    excluir();
                    break;
                case 6:
                    testePolimorfismo();
                    break;
                case 0:
                    System.out.println("Saindo do FoodShare. Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }
}