import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nome;
    private String login;
    private String email;
    private String senha;
    private List<String> tweets;
    private Boolean logado;

    public Usuario(String nome, String email, String login, String senha) {
        this.nome = nome;
        this.email = email;
        this.login = login;
        this.senha = senha;
        tweets = new ArrayList<>();
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public void logar() {
        this.logado = true;
    }

    public void deslogar() {
        this.logado = false;
    }
    
    public void tweet(String tweet) {
        tweets.add(tweet);
    }

    public List<String> getTweets(int n) {
        List<String> tweets = new ArrayList<>();
        int count = 0;
        for (int i = this.tweets.size() - 1; i >= 0 && count < n; i--) {
            tweets.add(this.tweets.get(i));
            count++;
        }
        return tweets;
    }

  

    /*
    //7 - remover tweet de um usuário
    public void removeTweet(String tweet) {
        tweets.remove(tweet);
    }    

    //8 - alterar senha de um usuário
    public void trocarSenha(String novaSenha) {
        senha = novaSenha;
    }

    //9 - remover um usuário
    public boolean removeUser(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                users.remove(user);
                return true; // User removed successfully
            }
        }
        return false; // User not found
    }
    //10 - imprimir estatisticas
    */

}

/*A classe Twitter será responsável pelo fluxo de execução e deverá apresentar um menu com as
seguintes opções:
    1- cadastrar usuário
    4- deslogar usuário
    10- imprimir estatísticas
    0- finalizar programa*/

        
