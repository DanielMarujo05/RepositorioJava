package model;

public class GerenteDesenvolvedor extends Funcionario implements Desenvolve, Gerencia {

    public GerenteDesenvolvedor(int id, String nome, double salario) {
        super(id, nome, salario);
    }

    @Override
    public void codar() {
        System.out.println(getNome() + " está codando.");
    }

    @Override
    public void resolverProblemas() {
        System.out.println(getNome() + " está resolvendo problemas.");
    }

    @Override
    public void organizarEquipe() {
        System.out.println(getNome() + " está organizando a equipe.");
    }

    @Override
    public void conduzirReunioes() {
        System.out.println(getNome() + " está conduzindo reuniões.");
    }

    @Override
    public void mostrarDetalhes() {
        System.out.println("Gerente Desenvolvedor [ID=" + getId() + ", Nome=" + getNome() + ", Salário=" + getSalario() + "]");
    }
}
