public class Usuario {
    private String nome;
    private String login;
    private String email;
    private String senha;
    private List<String> tweets;

    public Usuario(String nome, String login, String email, String senha) {
        this.nome = nome;
        this.login = login;
        this.email = email;
        this.senha = senha;
    }
    
    public User(String login, String senha) {
        this.username = username;
        this.password = password;
        tweets = new ArrayList<>();
    }

    //
    public String getUsername() {
        return username;
    }

    //3 - logar usuário
    public boolean login(String senha) {
        return this.password.equals(password);
    }

    //5 - tweetar
    public void tweet(String tweet) {
        tweets.add(tweet);
    }

    //6 - mostrar últimos N tweets do feed
    public void listTweets() {
        System.out.println("Tweets by " + username + ":");
        for (String tweet : tweets) {
            System.out.println(tweet);
        }
    }

    //2 - listar usuários
    public static void listUsers(List<User> users) {
        System.out.println("Users:");
        for (User user : users) {
            System.out.println(user.getUsername());
        }
    }

    //7 - remover tweet de um usuário
    public void removeTweet(String tweet) {
        tweets.remove(tweet);
    }    
    public boolean sendTweet(String username, String tweet) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                boolean sent = user.sendTweet(tweet);
                if (!sent) {
                    return false; // Tweet failed to send
                }
                return true; // Tweet sent successfully
            }
        }
        return false; // User not found
    }

    //8 - alterar senha de um usuário
    public void trocarSenha(String novaSenha) {
        senha = novaSenha;
    }

    public boolean removeUser(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                users.remove(user);
                return true; // User removed successfully
            }
        }
        return false; // User not found
    }
    

}
/*A classe Twitter será responsável pelo fluxo de execução e deverá apresentar um menu com as
seguintes opções:
    1- cadastrar usuário
    
    4- deslogar usuário
    
    9- remover um usuário
    10- imprimir estatísticas
    0- finalizar programa*/

        
