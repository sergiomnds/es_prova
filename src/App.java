import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        Mapa mapa = new Mapa();
        boolean sair = false;
        System.out.println("Bem vindo a Gerência de Telegramas");
        while (!sair) {
            System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
            System.out.println("▒▒ 1 - Cadastro de Telegrama              ▒▒");
            System.out.println("▒▒ 2 - Remover Telegrama                  ▒▒");
            System.out.println("▒▒ 3 - Consultar Telegramas               ▒▒");
            System.out.println("▒▒ 4 - Sair                               ▒▒");
            System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
            int opcao = 0;
            boolean executado = false;
            do {
                try {

                    System.out.println("Digite a opção desejada: ");
                    opcao = in.nextInt();
                    in.nextLine();
                    executado = true;
                } catch (Exception e) {
                    in = new Scanner(System.in);// reseta o scanner para que o usuario possa tentar novamente
                    System.out.println("Opção inválida, tente novamente!");
                    continue;
                }
            } while (!executado);

            do {
                try {
                    switch (opcao) {
                        default:
                            System.out.println("Opção inválida, tente novamente!");
                            break;
                        case 1:
                            String destinatario = null;
                            String remetente = null;
                            String mensagem = null;
                            String rua = null;
                            String bairro = null;
                            int numero = 0;
                            String cidade = null;
                            UF uf = null;
                            String endereco = null;

                            boolean valido = false;
                            do {
                                try {
                                    System.out.println("Escreva o nome do Destinatário: ");
                                    destinatario = in.nextLine();
                                    
                                    valido = true;
                                   
                                } catch (Exception e) {
                                    in = new Scanner(System.in);// reseta o scanner para que o usuario possa tentar
                                                                // novamente
                                    System.out.println("Destinatário inválido, tente novamente!");
                                    continue;
                                }
                            } while (!valido);

                            valido = false;
                            do {
                                try {
                                    System.out.println("Escreva o nome do Remetente: ");
                                    remetente = in.nextLine();
                                    valido = true;
                                } catch (Exception e) {
                                    in = new Scanner(System.in);// reseta o scanner para que o usuario possa tentar
                                                                // novamente
                                    System.out.println("Remetente inválido, tente novamente!");
                                    continue;
                                }
                            } while (!valido);

                            valido = false;
                            do {
                                try {
                                    System.out.println("Escreva sua Mensagem: ");
                                    mensagem = in.nextLine();
                                    valido = true;
                                } catch (Exception e) {
                                    in = new Scanner(System.in);// reseta o scanner para que o usuario possa tentar
                                                                // novamente
                                    System.out.println("Mensagem inválida, tente novamente!");
                                    continue;
                                }
                            } while (!valido);
                            valido = false;
                            do {
                                try {
                                    System.out.println("Específique o endereço: ");
                                    System.out.println("Escreva o a Rua de destino: ");
                                    rua = in.nextLine();
                                    
                                    valido = true;
                                } catch (Exception e) {
                                    in = new Scanner(System.in);// reseta o scanner para que o usuario possa tentar
                                                                // novamente
                                    System.out.println("Rua inválida, tente novamente!");
                                    continue;
                                }
                            } while (!valido);
                            valido = false;
                            do {
                                try {
                                    System.out.println("Escreva o número da casa/apto: ");
                                    numero = in.nextInt();
                                    in.nextLine();
                                    valido = true;
                                } catch (Exception e) {
                                    in = new Scanner(System.in);// reseta o scanner para que o usuario possa tentar
                                                                // novamente
                                    System.out.println("Número inválido, tente novamente!");
                                    continue;
                                }
                            } while (!valido);
                            valido = false;
                            do {
                                try {
                                    System.out.println("Escreva o Bairro de destino: ");
                                    bairro = in.nextLine();
                                    
                                    valido = true;
                                } catch (Exception e) {
                                    in = new Scanner(System.in);// reseta o scanner para que o usuario possa tentar
                                                                // novamente
                                    System.out.println("Bairro inválido, tente novamente!");
                                    continue;
                                }
                            } while (!valido);
                            valido = false;
                            do {
                                try {
                                    System.out.println("Escreva a Cidade de destino: ");
                                    cidade = in.nextLine();
                                    valido = true;
                                } catch (Exception e) {
                                    in = new Scanner(System.in);// reseta o scanner para que o usuario possa tentar
                                                                // novamente
                                    System.out.println("Cidade inválida, tente novamente!");
                                    continue;
                                }
                            } while (!valido);
                            valido = false;
                            do {
                                try {
                                    System.out.println("Escolha o Estado de Destino: ");
                                    for (UF t : UF.values()) {
                                        System.out.println(t.ordinal() + " - " + t.getDescricao());
                                    }
                                    int UFSelecionado = in.nextInt();
                                    uf = UF.values()[UFSelecionado];

                                    endereco = rua + ", " + numero + ", " + bairro + ", " + cidade + ", " + uf;

                                    Telegrama telegrama = new Telegrama(destinatario, remetente, mensagem, endereco);
                                    if (mapa.adicionar(uf, telegrama)) {
                                        System.out.println("Telegrama cadastrado com sucesso!");
                                        valido = true;
                                    }
                                } catch (Exception e) {
                                    in = new Scanner(System.in);// reseta o scanner para que o usuario possa tentar
                                                                // novamente
                                    System.out.println("Estado inválido, tente novamente!");
                                    continue;
                                }
                            } while (!valido);
                            break;
                        case 2:
                            valido = false;
                            do {
                                try {
                                    System.out.println("Digite o identificador do telegrama que deseja remover: ");
                                    int identificador = in.nextInt();
                                    if (mapa.remover(identificador)) {
                                        System.out.println("Contêiner desempilhado com sucesso!");
                                        valido = true;
                                    }
                                } catch (Exception e) {
                                    in = new Scanner(System.in);
                                    System.out.println("Identificador inválido, tente novamente");
                                    continue;
                                }
                            } while (!valido);
                            break;
                        case 3:
                            System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
                            System.out.println("▒▒ A - Consultar dado de um Telegrama                      ▒▒");
                            System.out.println("▒▒ B - Encontrar ocorrência de texto na mensagem           ▒▒");
                            System.out.println("▒▒ C - Quantidade de Telegramas para alguma UF             ▒▒");
                            System.out.println("▒▒ D - Percentual de Telegramas por Unidade de Destino     ▒▒");
                            System.out.println("▒▒ E - UFs com maior e menor quantidade de telegramas      ▒▒");
                            System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");

                            System.out.println("Digite a opção desejada: ");
                            opcao = in.next().toUpperCase().charAt(0);

                            switch (opcao) {
                                default:
                                    System.out.println("Opção inválida, tente novamente!");
                                    break;
                                case 'A':
                                    valido = false;
                                    do {
                                        try {
                                            System.out.println(
                                                    "Digite o identificador do telegrama que deseja consultar: ");
                                            int identificador = in.nextInt();

                                            System.out.println(mapa.consultarTelegrama(identificador));
                                            valido = true;
                                        } catch (Exception e) {
                                            in = new Scanner(System.in);
                                            System.out.println("Identificador inválido, tente novamente");
                                            continue;
                                        }
                                    } while (!valido);
                                    break;
                                /*
                                 * case 'B':
                                 * System.out.println("Digite o texto que deseja procurar: ");
                                 * String texto = in.nextLine();
                                 * System.out.println("Ocorrências: " + mapa.encontrarOcorrencia(texto));
                                 * break;
                                 * case 'C':
                                 * System.out.println("Digite a sigla do Estado: ");
                                 * String sigla = in.nextLine();
                                 * System.out.println("Quantidade de Telegramas: " +
                                 * mapa.quantidadeTelegramas(sigla));
                                 * break;
                                 * case 'D':
                                 * System.out.println("Digite a sigla do Estado: ");
                                 * String sigla2 = in.nextLine();
                                 * System.out
                                 * .println("Percentual de Telegramas: " + mapa.percentualTelegramas(sigla2));
                                 * break;
                                 * case 'E':
                                 * System.out.println(
                                 * "Quantidade de Telegramas: " + mapa.maiorMenorQuantidadeTelegramas());
                                 * break;
                                 */
                            }
                            break;
                        case 4:
                            sair = true;
                    }
                    executado = true;
                } catch (Exception e) {
                    in = new Scanner(System.in);// * reseta o scanner para que o usuario possa tentar novamente
                    System.out.println("Erro inesperado, Falha ao executar operação, por favor, tente novamente");
                    System.out.println("Caso o erro persista, contate o suporte");
                    System.out.println("Erro:");
                    System.out.println(e.getMessage());
                    continue;
                }
            } while (!executado);
        }
        in.close();
    }
}