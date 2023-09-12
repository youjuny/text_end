import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> titles = new ArrayList<>();
        ArrayList<String> contents = new ArrayList<>();
        int articleNum = 1;

        while (true) {
            System.out.println("메뉴 입력:");
            Scanner scan = new Scanner(System.in);
            String command = scan.nextLine();

            if (command.equals("a")) {
                System.out.println("기능1");
            } else if (command.equals("b")) {
                System.out.println("기능2");
            } else if (command.equals("help")) {
                System.out.println("a : 기능1");
                System.out.println("b : 기능2");
                System.out.println("exit : 종료");
                System.out.println("add : 게시물 추가");
                System.out.println("list : 게시물 조회하기");
                System.out.println("update : 게시물 수정하기");
                System.out.println("delete : 게시물 삭제하기");
            } else if (command.equals("add")) {
                System.out.printf("게시물 제목을 입력해주세요: ");
                String title = scan.nextLine();
                System.out.printf("게시물 내용을 입력해주세요: ");
                String content = scan.nextLine();

                titles.add(title);
                contents.add(content);
                articleNum++;

            } else if (command.equals("list")) {
                System.out.println("=============");
                for (int i = 0; i < titles.size(); i++) {
                    System.out.printf("번호 : %d\n", i + 1); //
                    System.out.printf("제목 : %s\n", titles.get(i));
                    System.out.printf("내용 : %s\n", contents.get(i));
                    System.out.println("=============");
                }
            } else if (command.equals("update")) {
                System.out.printf("수정할 게시물 번호 : ");
                int updateArticleNumber = scan.nextInt();

                scan.nextLine(); //// 제목이랑 내용 같은 줄에 안나오게 하기

                if (updateArticleNumber >= 1 && updateArticleNumber <= titles.size()) {
                    System.out.printf("새로운 게시물 제목을 입력해주세요 : ");
                    String newTitle = scan.nextLine();
                    System.out.printf("새로운 게시물 내용을 입력해주세요 : ");
                    String newContent = scan.nextLine();

                    titles.set(updateArticleNumber - 1, newTitle);
                    contents.set(updateArticleNumber - 1, newContent);
                    System.out.printf("%d번 게시물이 수정되었습니다.\n", updateArticleNumber);

                } else {
                    System.out.println("없는 게시물번호입니다.");
                }
            } else if (command.equals("delete")) {
                System.out.println("삭제할 게시물 번호 : ");
                int deleteArticleNumber = scan.nextInt();

                scan.nextLine();

                if (deleteArticleNumber >= 1 && deleteArticleNumber<=titles.size()) {
                    titles.remove(deleteArticleNumber - 1);
                    contents.remove(deleteArticleNumber -1);
                    System.out.printf("%d번 게시물이 삭제되었습니다.\n",deleteArticleNumber);
                }else {
                    System.out.println("없는 게시물 번호입니다.");
                }


            } else if (command.equals("exit")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
        }
    }
}