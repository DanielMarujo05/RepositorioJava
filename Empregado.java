public class Empregado {
    public String matricula;
    public double salario;

    public String getMatricula() {
        return matricula;
    }


    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }


    public double getSalario() {
        return salario;
    }


    public void setSalario(double salario) {
        if (salario > 0) {
            this.salario = salario;
        }
    }
}
