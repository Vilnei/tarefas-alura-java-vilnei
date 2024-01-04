import java.util.Scanner;

public class Desafio {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nome = "Vilnei M. de Lima";
        String conta = "Corrente";
        double saldo = 2000.00;

        System.out.printf(String.format("""
                ***********************
                Dados iniciais do cliente:
                                
                Nome: %s
                Tipo conta: %s
                Saldo inicial: R$ %.2f
                                        
                ***********************
                """,nome ,conta ,saldo));


        int opcoes = 0;
        while (opcoes != 4) {
            System.out.print("""
                                
                                Operações
                                1- Consultar saldos
                                2- Receber valor
                                3- Transferir valor
                                4- Sair
                                                
                                Digite a opção desejada:
                                """);
            opcoes = scanner.nextInt();

            if (opcoes == 1) {
                System.out.printf(String.format("Saldo atual: %.2f", saldo));
            }

            else if (opcoes == 2) {
                System.out.println("Digite o valor a ser adicionado ao Saldo: ");
                saldo += scanner.nextDouble();
                System.out.printf(String.format("O saldo Atual é de %.2f", saldo));
            }
            else if (opcoes == 3) {
                System.out.println("Digite o valor a ser Transferido do Saldo atual: ");
                double novoSaldo = scanner.nextDouble();
                if (novoSaldo > saldo){
                    System.out.println("Valor requerido é maior que saldo atual.");
                }
                else {
                    saldo -= novoSaldo;
                    System.out.printf(String.format("O saldo Atual é de %.2f", saldo));
                }
            }
            else if (opcoes == 4) {
                System.out.print("Operação finalizada!!!");
            }
            else {
                System.out.println("Valor digitado invalido, tente novamente.");
            }
        }
    }
}
