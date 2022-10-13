package crud;

import dao.ClienteDao;
import dao.PermissoesDao;
import model.Cliente;
import model.Permissoes;
import model.Viagem;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClienteCrud {

    private static Cliente Cliente1;
    private static int id_permissoes;
	private static int id_Permissao;
	private static List<Cliente> clientes;
	private static PermissoesDao permissaoDao;

    public static void main(String[] args) throws SQLException {

        ClienteDao clienteDao = new ClienteDao();
        setPermissaoDao(new PermissoesDao());

        Scanner input = new Scanner(System.in);

        int opcao = 0;
        int posicao = 0;
        int id = 0;
        setId_Permissao(0);
        String nome = " ";
        String sobrenome = " ";
        String endereco = " ";
        String telefone = " ";
        String cpf = " ";
        String email = " ";
        String senha = " ";

        setClientes(new ArrayList<Cliente>());

        //MENU

        do{
            System.out.println("###CRUD CLIENTE###");
            System.out.println("1- Cadastar Cliente");
            System.out.println("2- Consultar Clientes");
            System.out.println("3- Atualizar Dados do Cliente");
            System.out.println("4- Excluir Cliente");
            System.out.println("0- Sair");


            opcao = input.nextInt();

            switch (opcao){
                case 1:
                    System.out.println("###CADASTRO DE CLIENTE###");
                    System.out.println("Digite o seu nome: ");
                    nome = input.nextLine();
                    input.nextLine();
                    System.out.println("Digite seu sobrenome: ");
                    sobrenome = input.nextLine();
                    System.out.println("Digite seu endereço: ");
                    endereco = input.nextLine();
                    System.out.println("Digite seu telefone: ");
                    telefone = input.nextLine();
                    System.out.println("Digite o CPF: ");
                    cpf = input.nextLine();
                    System.out.println("Digite seu email: ");
                    email = input.nextLine();
                    System.out.println("Digite sua senha: ");
                    senha = input.nextLine();
                    System.out.println("Digite o id:  ");
                    setId_Permissao(input.nextInt());
                    input.nextLine();


                    Permissoes permissoes = PermissoesDao.getPermissoesById(id_permissoes);


                    Cliente cliente = new Cliente(nome, sobrenome, endereco, telefone, cpf, email, senha);


                    ClienteDao.save(cliente);

                    System.out.println("Cliente Cadastrado");
                    break;
                case 2:
                    for (Cliente c : clienteDao.getCliente()) {
                        System.out.println("id: " + c.getId_cliente() + "nome: " + c.getNome() + "Sobrenome: " + c.getSobrenome());
                    }
                    System.out.println("Finalizado");
                    break;

                case 3:
                    System.out.println("Atualizar cadastro de cliente");
                    System.out.println("Digite o Id do cliente: ");
                    id = input.nextInt();
                    input.nextLine();
                    System.out.println("Digite o nome: ");
                    nome = input.nextLine();
                    System.out.println("Digite o sobrenome: ");
                    sobrenome = input.nextLine();
                    System.out.println("Digite o novo endereço: " );
                    endereco = input.nextLine();
                    System.out.println("Digite o novo telefone: ");
                    telefone = input.nextLine();
                    System.out.println("Digite o novo email: ");
                    email = input.nextLine();
                    System.out.println("Digite a nova senha: ");
                    senha = input.nextLine();


                    Cliente cliente1 = new Cliente(id, nome, sobrenome, endereco, telefone, email, senha);

                    clienteDao.update(Cliente1);
                    break;
                case 4:
                    System.out.println("### EXCLUIR CLIENTE###");
                    System.out.println("Digite o di do cliente: ");
                    posicao = input.nextInt();

                    clienteDao.deletebyId(posicao);
                    break;

                default:
                    System.out.println(opcao != 0 ? "Opçao invalida" : " " );
                    break;
            }



        }while(opcao != 0);
            input.close();
    }

	public static int getId_Permissao() {
		return id_Permissao;
	}

	public static void setId_Permissao(int id_Permissao) {
		ClienteCrud.id_Permissao = id_Permissao;
	}

	public static List<Cliente> getClientes() {
		return clientes;
	}

	public static void setClientes(List<Cliente> clientes) {
		ClienteCrud.clientes = clientes;
	}

	public static PermissoesDao getPermissaoDao() {
		return permissaoDao;
	}

	public static void setPermissaoDao(PermissoesDao permissaoDao) {
		ClienteCrud.permissaoDao = permissaoDao;
	}
}
