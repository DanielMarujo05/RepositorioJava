import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Hospital {
    private static final String FILE_NAME = "pacientes.txt";

    public static void main(String[] args) {
        Hospital hospital = new Hospital();
        
        // Exemplo de inclusão de pacientes
        Paciente paciente1 = new Paciente(1, 70.5, 1.75);
        hospital.incluirPaciente(paciente1);

        Paciente paciente2 = new Paciente(2, 80.2, 1.80);
        hospital.incluirPaciente(paciente2);

        // Listar todos os pacientes
        System.out.println("Lista de Pacientes:");
        hospital.listarPacientes();

        // Alterar dados de um paciente
        paciente1.setPeso(72.0);
        hospital.alterarPaciente(paciente1);

        // Listar todos os pacientes após alteração
        System.out.println("\nLista de Pacientes após alteração:");
        hospital.listarPacientes();

        // Excluir um paciente
        hospital.excluirPaciente(2);

        // Listar todos os pacientes após exclusão
        System.out.println("\nLista de Pacientes após exclusão:");
        hospital.listarPacientes();
    }

    public void incluirPaciente(Paciente paciente) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(paciente.toString());
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Erro ao incluir paciente: " + e.getMessage());
        }
    }

    public void alterarPaciente(Paciente paciente) {
        List<Paciente> pacientes = lerPacientes();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Paciente p : pacientes) {
                if (p.getNumero() == paciente.getNumero()) {
                    writer.write(paciente.toString());
                } else {
                    writer.write(p.toString());
                }
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Erro ao alterar paciente: " + e.getMessage());
        }
    }

    public void excluirPaciente(int numero) {
        List<Paciente> pacientes = lerPacientes();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Paciente p : pacientes) {
                if (p.getNumero() != numero) {
                    writer.write(p.toString());
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao excluir paciente: " + e.getMessage());
        }
    }

    public void listarPacientes() {
        List<Paciente> pacientes = lerPacientes();
        for (Paciente paciente : pacientes) {
            paciente.listarPaciente();
        }
    }

    private List<Paciente> lerPacientes() {
        List<Paciente> pacientes = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Paciente paciente = Paciente.fromString(line);
                pacientes.add(paciente);
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler pacientes: " + e.getMessage());
        }
        return pacientes;
    }
}
