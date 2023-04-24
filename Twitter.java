public class Twitter {
    public static void main(String[] args) {
        
        Usuario u1 = new Usuario("Gustavo", "chelsen", "gustavo@gmail.com", "123456")
       

        
    }
}

import java.util.ArrayList;
import java.util.List;

public class Application {
    private List<User> users;

    public Application() {
        users = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void sendTweet(String username, String tweet) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                user.sendTweet(tweet);
            }
        }
    }

    
}


