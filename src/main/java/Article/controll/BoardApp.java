package Article;

import Article.Model.Article;
import Article.Model.ArticleRepository;
import Article.View.ArticleView;

import java.util.ArrayList;
import java.util.Scanner;

public class BoardApp {

    ArticleView articleView = new ArticleView();
    ArticleRepository articleRepository = new ArticleRepository();

    public void start() {


        Scanner scan = new Scanner(System.in);
        int lastArticleId = 4;

        while (true) {
            System.out.print("메뉴입력 : ");
            String command = scan.nextLine();
            if (command.equals("exit")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else if (command.equals("add")) {
                System.out.print("게시물 제목을 입력해주세요 : ");
                String title = scan.nextLine();
                System.out.print("게시물 내용을 입력해주세요 : ");
                String content = scan.nextLine();

                Article article = new Article(lastArticleId, title, content, Util.getCurrentDate());
                articleRepository.insert(article);

                System.out.println("게시물이 등록되었습니다.");
                lastArticleId++;
            } else if (command.equals("list")) {
                ArrayList<Article> articles = articleRepository.findAllArticles();
                articleView.printArticles(articles);

            } else if (command.equals("update")) {
                System.out.print("수정할 게시물 번호 : ");
                int targetId = scan.nextInt();

                scan.nextLine();

                Article article = articleRepository.findById(targetId);

                if (article == null) {
                    System.out.println("없는 게시물입니다.");
                } else {
                    System.out.print("제목 : ");
                    String newTitle = scan.nextLine();
                    System.out.print("내용 : ");
                    String newContent = scan.nextLine();

                    article.setTitle(newTitle);
                    article.setContent(newContent);

                    System.out.println("수정이 완료되었습니다.");
                }


            } else if (command.equals("delete")) {
                System.out.print("삭제할 게시물 번호 : ");
                int targetId = scan.nextInt();

                scan.nextLine();

                Article article = articleRepository.findById(targetId);

                if (article == null) {
                    System.out.println("없는 게시물입니다.");
                } else {
                    //articles.remove(i); // 위치 기반으로 삭제

                }

            } else if (command.equals("detail")) {
                // 중복 -> 함수

                System.out.print("상세보기 할 게시물 번호를 입력해주세요 : ");
                int targetId = scan.nextInt();
                Article article = articleRepository.findById(targetId);

                scan.nextLine();

                if (article == null) {
                    System.out.println("존재하지 않는 게시물입니다.");
                } else {

                    article.setHit(article.getHit()+1);
                    articleView.printArticleDetail(article);

                }
            } else if(command.equals("search")) {
                System.out.print("검색 키워드를 입력해주세요 : ");
                String keyword = scan.nextLine();

                ArrayList<Article> searchedArticles = articleRepository.findByTitle(keyword);
                articleView.printArticles(searchedArticles);
            }
        }

    }



}