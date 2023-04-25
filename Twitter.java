//import das bibliotecas necessarias
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//cria a aplicacao, no caso chamada de Twitter
public class Twitter {

    static Scanner leitor = new Scanner(System.in); //seta o leitor para ler input
    static ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>(); //cria um array pra armazenar os usuarios

    public static void main(String[] args) {
        int selecao; //variavel para armazenar a selecao
        do{
            mostraMenu();            
            selecao = leitor.nextInt();
            leitor.nextLine();
            
            //ação de acordo com a seleção
            switch (selecao) {
                case 1:
                    cadastrarUsuario(); //cadastra novo usuário
                    break;
                case 2:
                    listaUsuarios(); //lista todos usuários
                    break;
                case 3:
                    login(); //faz login de um usuário
                    break;
                case 4:
                    logout(); //faz logout de um usuário
                    break;
                case 5:
                    tweet(); //faz um tweet
                    break;
                case 6:
                    listarTweets(); //lista todos os tweets (feed)
                    break;
                /*
                case 7:
                    removeTweet();  //remove um tweet
                    break;
                case 8:
                    trocarSenha(); //troca a senha de um usuário
                    break;
                case 9:
                    removeUser(); //remove um usuário
                    break;
                case 10:
                    imprimir(); //imprime as estatísticas
                    break;
                    */
                case 0:
                    System.exit(0); //sai da aplicação
                    break;
                default:
                    System.out.println("Opção inválida.\n");
                    break;
            }
        }while (selecao != 0);
    }
    
    //Menu de seleções
    private static void mostraMenu() { 
        System.out.println("Escolha qual acao deseja realizar:");
        System.out.println("-------------------------\n");
        System.out.println("1 - cadastrar usuário");
        System.out.println("2 - listar usuários");
        System.out.println("3 - logar usuário ");
        System.out.println("4 - deslogar usuário");
        System.out.println("5 - tweetar");
        System.out.println("6 - mostrar últimos N tweets do feed");
        System.out.println("7 - remover tweet de um usuário");
        System.out.println("8 - alterar senha de um usuário");
        System.out.println("9 - remover um usuário");
        System.out.println("10 - imprimir estatísticas");
        System.out.println("0 - finalizar programa");
    }

    //1 - método para criar o usuário
    private static void cadastrarUsuario() {
        System.out.println("Escreva o nome:");
        String nome = leitor.nextLine();
        System.out.println("Escreva o email:");
        String email = leitor.nextLine();
        System.out.println("Escreva o login:");
        String login = leitor.nextLine();
        System.out.println("Escreva a Senha:");
        String senha = leitor.nextLine();
        Usuario usuario = new Usuario(nome, email, login, senha);
        listaUsuarios.add(usuario);
        System.out.println("Usuario criado: " + usuario.getLogin() + "\n");
    }

    //2 - método para listar os usuários
    private static void listaUsuarios() {
        System.out.println("Lista de usuários:");
        for (Usuario usuario : listaUsuarios) {
            System.out.println(usuario.getLogin());
        }
    }

    //3 - método para fazer login
    public static void login() {
        System.out.println("Digite o login: ");
        String login = leitor.nextLine();
        System.out.println("Digite a senha: ");
        String senha = leitor.nextLine();
        Usuario usuarioEncontrado = null;
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getLogin().equals(login) && usuario.getSenha().equals(senha)) {
                usuarioEncontrado = usuario;
            }
        }
        if (usuarioEncontrado != null) {
            usuarioEncontrado.logar();
            System.out.println("Usuário " + usuarioEncontrado.getLogin() + " logado com sucesso.\n");
        } else {
            System.out.println("Usuário não encontrado ou senha incorreta.\n");
        }
    }

    //4 - método para fazer logout
    private static void logout() {
        System.out.println("Digite o login: ");
        String login = leitor.nextLine();
        Usuario usuario = procuraUsuario(login);
        if (usuario == null) {
            System.out.println("Usuário não encontrado.\n");
        } else {
            usuario.deslogar();
            System.out.println("Logout bem sucedido.\n");
        }
    }

    //método para procurar um usuário
    private static Usuario procuraUsuario(String login) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getLogin().equals(login)) {
                return usuario;
            }
        }
        return null;
    }
    
    //5 - método para tweetar
    public static void tweet() {
        System.out.println("Digite seu username:");
        String login = leitor.nextLine(); //lê o username do usuário que deseja tweetar
    
        System.out.println("Digite seu tweet:");
        String tweet = leitor.nextLine(); //lê o tweet que o usuário deseja enviar
    
        //procura o usuário na lista de usuários
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getLogin().equals(login)) {
                usuario.tweet(tweet); //envia o tweet para o usuário encontrado
                System.out.println("Tweet enviado com sucesso!\n"); //exibe mensagem de sucesso
                return;
            }
        }
        System.out.println("Usuário não encontrado.\n"); //se não encontrar usuário, exibe mensagem de erro
    }

    //6 - método para listar os últimos n tweets do feed
    private static void listarTweets() {
        System.out.println("Digite o número de tweets que deseja exibir:");
        int n = leitor.nextInt();
        System.out.println("Lista dos últimos " + n + " tweets:");
        for (Usuario usuario : listaUsuarios) {
            List<String> tweets = usuario.getTweets(n);
            for (int i = tweets.size() - 1; i >= 0 && n > 0; i--) {
                System.out.println(usuario.getLogin() + ": " + tweets.get(i));
                n--;
            }
            if (n <= 0) {
                break;
            }
        }
    }

    //7 - método para remover um tweet
    

}


