import java.util.Scanner;

public class Leitura {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();
        System.out.print("Digite sua idade: ");
        int idade = scanner.nextInt();
        System.out.print("Digite o valor que pretende investir esse mes");
        double valor = scanner.nextDouble();
        System.out.print(nome + " que tem " + idade + " anos, irá investir R$ " + valor + " esse mês.");

        scanner.close();

    }
}
