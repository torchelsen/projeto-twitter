+------------------------------+          +------------------------------+
|           Twitter            |          |           Usuario            |
+------------------------------+          +------------------------------+
| - listaUsuarios: List<Usuario>|          | - nomeUsuario: String        |
|                              |          | - tweets: List<String>       |
+------------------------------+          +------------------------------+
| + adicionarUsuario(nome: String): Usuario  | + adicionarTweet(tweet: String)    |
| + removerUsuario(nome: String): void        | + removerTweet(index: int): String |
| + getUsuarios(): List<Usuario>              | + getNomeUsuario(): String         |
| + getTweets(username: String): List<String>| + getTweets(): List<String>        |
| + listarTweets(n: int): void                |                                  |
| + removeTweet(): void                       |                                  |
+------------------------------+              +------------------------------+
