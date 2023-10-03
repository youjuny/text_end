package Article.model;//Dao
//Repository

import util.Util;

import java.util.ArrayList;

public class ArticleRepository {
    private ArrayList<Article> articles = new ArrayList<>();

    private MemberRepository memberRepository = new MemberRepository();
    private int lastArticleId = 4;


    public ArticleRepository() {
        Article a1 = new Article(1, "안녕하세요 반갑습니다. 자바 공부중이에요.", "열심히 하겠습니다", 1, Util.getCurrentDate());
        Article a2 = new Article(2, "자바 질문좀 할게요~.", "열심히 하겠습니다", 2, Util.getCurrentDate());
        Article a3 = new Article(3, "정처기 따야되나요?", "열심히 하겠습니다", 1, Util.getCurrentDate());

        articles.add(a1);
        articles.add(a2);
        articles.add(a3);
    }


    public void insert(String title, String content, int memberId) {
        Member writer = memberRepository.getMemberById(memberId);
        if (writer == null) {
            System.out.println("존재하지 않는 회원입니다.");
            return;
        }


        Article article = new Article(lastArticleId, title, content, memberId, Util.getCurrentDate());
        articles.add(article);
        lastArticleId++;

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

        for (int i = 0; i < articles.size(); i++) {
            Article article = articles.get(i);
            String title = article.getTitle();

            if (title.contains(keyword)) {
                searchedArticles.add(article);
            }
        }

        return searchedArticles;
    }


    public void update(int articleId, String title, String cotent) {
        Article article = findById(articleId);

        article.setTitle(title);
        article.setContent(cotent);

    }
}
