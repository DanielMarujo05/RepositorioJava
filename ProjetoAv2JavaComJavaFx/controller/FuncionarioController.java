package controller;

import model.Funcionario;
import view.FuncionarioView;

public class FuncionarioController {
    private FuncionarioView view;

    public FuncionarioController(FuncionarioView view) {
        this.view = view;
    }

    public void exibirFuncionario(Funcionario funcionario) {
        view.exibirDetalhes(funcionario);
    }
}
