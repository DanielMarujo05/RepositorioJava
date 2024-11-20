package com.hospital;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Paciente> pacientes = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Incluir Paciente");
            System.out.println("2. Alterar Paciente");
            System.out.println("3. Excluir Paciente");
            System.out.println("4. Consultar Pacientes");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    incluirPaciente(scanner);
                    break;
                case 2:
                    alterarPaciente(scanner);
                    break;
                case 3:
                    excluirPaciente(scanner);
                    break;
                case 4:
                    consultarPacientes();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        } while (opcao != 5);

        scanner.close();
    }

    private static void incluirPaciente(Scanner scanner) {
        System.out.print("Número: ");
        int numero = scanner.nextInt();
        System.out.print("Peso: ");
        double peso = scanner.nextDouble();
        System.out.print("Altura: ");
        double altura = scanner.nextDouble();

        Paciente paciente = new Paciente(numero, peso, altura);
        pacientes.add(paciente);
        System.out.println("Paciente incluído com sucesso!");
    }

    private static void alterarPaciente(Scanner scanner) {
        System.out.print("Número do paciente a alterar: ");
        int numero = scanner.nextInt();
        Paciente paciente = encontrarPaciente(numero);

        if (paciente != null) {
            System.out.print("Novo peso: ");
            double peso = scanner.nextDouble();
            System.out.print("Nova altura: ");
            double altura = scanner.nextDouble();
            paciente.setPeso(peso);
            paciente.setAltura(altura);
            System.out.println("Paciente alterado com sucesso!");
        } else {
            System.out.println("Paciente não encontrado!");
        }
    }

    private static void excluirPaciente(Scanner scanner) {
        System.out.print("Número do paciente a excluir: ");
        int numero = scanner.nextInt();
        Paciente paciente = encontrarPaciente(numero);

        if (paciente != null) {
            pacientes.remove(paciente);
            System.out.println("Paciente excluído com sucesso!");
        } else {
            System.out.println("Paciente não encontrado!");
        }
    }

    private static void consultarPacientes() {
        if (pacientes.isEmpty()) {
            System.out.println("Nenhum paciente cadastrado.");
        } else {
            for (Paciente paciente : pacientes) {
                paciente.listarPaciente();
            }
        }
    }

    private static Paciente encontrarPaciente(int numero) {
        for (Paciente paciente : pacientes) {
            if (paciente.getNumero() == numero) {
                return paciente;
            }
        }
        return null;
    }
}
