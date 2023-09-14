package Article;//Dao
//Repository

import Article.Article;

import java.util.ArrayList;

public class ArticleRepository {
    ArrayList<Article> articles = new ArrayList<>();

    ArticleRepository() {
        Article a1 = new Article(1, "안녕하세요 반갑습니다. 자바 공부중이에요.", "열심히 하겠습니다", Util.getCurrentDate());
        Article a2 = new Article(2, "자바 질문좀 할게요~.", "열심히 하겠습니다", Util.getCurrentDate());
        Article a3 = new Article(3, "정처기 따야되나요?", "열심히 하겠습니다", Util.getCurrentDate());

        articles.add(a1);
        articles.add(a2);
        articles.add(a3);
    }



    public void insert(Article article) {
        articles.add(article);
    }

    public void delete(Article article) {
        articles.remove(article);
    }


    public ArrayList<Article> findAllArticles() {
        return articles;
    }

    public Article findById(int id) {

        Article target = null;

        for (int i = 0; i < articles.size(); i++) {
            Article article = articles.get(i);
            if (id == article.getId()) {
                target = article;
            }
        }
        return target;
    }

    public ArrayList<Article> findByTitle(String keyword) {
        ArrayList<Article> searchedArticles = new ArrayList<>();

        for(int i = 0; i < articles.size(); i++) {
            Article article = articles.get(i);
            String title = article.getTitle();

            if(title.contains(keyword)) {
                searchedArticles.add(article);
            }
        }

        return searchedArticles;
    }


}
