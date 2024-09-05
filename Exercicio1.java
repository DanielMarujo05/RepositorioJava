import java.util.Scanner;
import java.text.DecimalFormat;  

public class Exercicio1{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.00");

        Empregado empregado1 = new Empregado();  
        Empregado empregado2 = new Empregado(); 

        // Leitura de dados para o primeiro empregado
        System.out.print("Digite a matrícula do primeiro empregado: ");
        String matricula = scanner.nextLine();
        empregado1.setMatricula(matricula);

        System.out.print("Digite o salário do primeiro empregado: ");
        Double salario = scanner.nextDouble();
        empregado1.setSalario(salario);

        // Consome a nova linha pendente após nextDouble
        scanner.nextLine();

        // Leitura de dados para o segundo empregado
        System.out.print("Digite a matrícula do segundo empregado: ");
        String matricula2 = scanner.nextLine();
        empregado2.setMatricula(matricula2);

        System.out.print("Digite o salário do segundo empregado: ");
        Double salario2 = scanner.nextDouble();
        empregado2.setSalario(salario2);

        // Cálculo dos valores
        double desconto = empregado1.getSalario() * 0.05;
        double acrescimo = empregado2.getSalario() * 0.09;

        double salarioFinal1 = empregado1.getSalario() - desconto;
        double salarioFinal2 = empregado2.getSalario() + acrescimo;

        // Exibição dos resultados
        System.out.println("Valor do desconto do primeiro empregado: " + df.format(desconto));
        System.out.println("Valor do acréscimo do segundo empregado: " + df.format(acrescimo));
        System.out.println("Salário final do primeiro empregado: " + df.format(salarioFinal1));
        System.out.println("Salário final do segundo empregado: " + df.format(salarioFinal2));

        scanner.close();  // Fechar o scanner ao final
    }
}
