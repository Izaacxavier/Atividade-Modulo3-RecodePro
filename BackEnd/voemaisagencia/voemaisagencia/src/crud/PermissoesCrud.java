package crud;

import dao.PermissoesDao;
import model.Permissoes;

import java.util.Scanner;



public class PermissoesCrud {
    private static int id_permissoes;

    public static void main(String[] args) {

        PermissoesDao permissaoDao = new PermissoesDao();

        Scanner input = new Scanner(System.in);
        int opcao = 0;
        int posicao = 0;

        int id = 0;
        String tipo = " ";


        do {
            System.out.println("---CRUD PERMISSOES---");
            System.out.println("1 - CADASTRAR PERMISSOES ");
            System.out.println("2 - CONSULTAR PERMISSOES ");
            System.out.println("3 - EXCLUIR PERMISSOES ");
            System.out.println("4 - ATUALIZAR PERMISSOES ");

            opcao = input.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("CADASTRAR PERMISSOES");
                    System.out.println("Digite o tipo");
                    input.nextLine();
                    tipo = input.nextLine();

                    Permissoes permissao = new PermissoesDao().getPermissoesById(id_permissoes);

                    permissao.setTipo_permissao(tipo);

                    permissaoDao.save(permissao);
                    System.out.println("CADASTRADO");
                    break;

                case 2:
                    System.out.println("CONSULTAR PERMISSAO");
                    for (Permissoes p : permissaoDao.getPermissoes()) {
                        System.out.println("id: " + p.getId_permissoes() + "tipo: " + p.getTipo_permissao());
                    }
                    System.out.println("FINALIZADO");
                    break;

                case 3:
                    System.out.println("DIGITE O ID DA PERMISSAO");
                    posicao = input.nextInt();

                    permissaoDao.deleteById(posicao);
                    break;

                case 4:
                    System.out.println("DIGITE ID DA PERMISSAO");
                    id = input.nextInt();
                    System.out.println("DIGITE O NOVO TIPO DE PERMISSAO");
                    tipo = input.nextLine();

                    Permissoes permissao1 = new Permissoes(id, tipo);
                    permissaoDao.update(permissao1);
                    break;
                case 5:
                    System.out.println("Digite o id da permissao: ");
                    opcao = input.nextInt();
                    input.nextLine();

                    Permissoes permissao2 = PermissoesDao.getPermissoesById(posicao);

                    System.out.println("Tipo de permissao: " + permissao2.getTipo_permissao());
                    break;

                default:
                    System.out.println("OPCAO INVALIDA! DIGITE NOVAMENTE:");
                    break;
            }

        } while (opcao != 0);
        {
            input.close();

        }
    }
}
