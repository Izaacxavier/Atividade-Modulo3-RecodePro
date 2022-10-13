package crud;

import dao.ViagemDao;
import model.Viagem;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ViagemCrud {

    public static void main(String[] args) throws SQLException {

        ViagemDao viagemDao = new ViagemDao();

        Scanner input = new Scanner(System.in);

        int opcao = 0;
        int posicao = 0;

        int id = 0;
        String destino = "";
        String dataIda = " ";
        String dataVolta = " ";

        List<Viagem> viagem = new ArrayList<Viagem>();

        //MENU

        do{
            System.out.println("### VIAGEM ###");
            System.out.println("#### CADASTRAR VIAGEM ####");
            System.out.println("1 - Cadastrar viagem");
            System.out.println("2 - pesquisar viagem");
            System.out.println("3 - Deletar viagem");
            System.out.println("4 - Atualizar viagem");
            System.out.println("0 - sair");

            opcao = input.nextInt();

            switch(opcao){
                case 1:
                    System.out.println("###CADASTRO DE VIAGEM###");
                    System.out.println("Digite o destino: ");
                    destino = input.nextLine();
                    destino = input.nextLine();
                    System.out.println("Digite a data de ida: ");
                    dataIda = input.nextLine();
                    System.out.println("Digite a data de Volta: ");
                    dataVolta = input.nextLine();

                    Viagem viagens = new Viagem(destino);

                    viagens.setDestinos(destino);
                    viagens.setData_ida((dataIda));
                    viagens.setData_volta((dataVolta));

                    viagemDao.save(viagens);

                    System.out.println("Destino cadastrado");
                    break;

                case 2:
                    for (Viagem v : viagemDao.getViagem()) {
                        System.out.println("id: " + v.getId_viagem() + "Destino: " + v.getDestinos());
                    }
                    System.out.println("Finalizado");
                    break;

                case 3:
                    System.out.println("EXCLUIR DESTINO");
                    System.out.println("Digite o id do Destino");
                    posicao = input.nextInt();
                    System.out.println("Destino excluido");
                    viagemDao.deleteById(posicao);
                    break;

                case 4:
                    System.out.println("UPDADE DE DESTINO");
                    System.out.println("Digite o id do destino");
                    id = input.nextInt();
                    System.out.println("Digite o novo nome do destino");
                    destino = input.nextLine();
                    destino = input.nextLine();

                    Viagem viagem1 = new Viagem(id, destino);
                    viagemDao.update(viagem1);


                default:
                    System.out.println(opcao != 0 ? "\n Opcao invalida" : " ");
                    break;

            }
        }while (opcao != 0);
            input.close();
            System.out.println("Fim");


    }
}
