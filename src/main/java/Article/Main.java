package Article;

import Article.controll.BoardApp;
import Article.model.Article;

import java.util.ArrayList;

public class Main {
    ArrayList<Article> articles = new ArrayList<>();

    public static void main(String[] args) {

        BoardApp app = new BoardApp();
        app.start();
    }
}