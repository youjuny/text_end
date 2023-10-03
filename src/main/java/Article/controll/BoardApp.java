package Article.controll;

import Article.model.Member;

import java.util.Scanner;


public class BoardApp {

    ArticleController articleController = new ArticleController();
    MemberController memberController = new MemberController();

    Scanner scan = new Scanner(System.in);

    public void start() {

        while (true) {
            Member logindeMember = memberController.getLogInedMember();
            articleController.setLoginedMember(logindeMember);
            if (logindeMember == null) {
                System.out.print("메뉴입력 : ");
            } else {
                System.out.printf("메뉴입력[%s(%s)] : ",logindeMember.getLoginId(),logindeMember.getNickname());
            }
            String command = scan.nextLine();
            if (command.equals("exit")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else if (command.equals("add")) {
                articleController.add();
            } else if (command.equals("list")) {
                articleController.list();
            } else if (command.equals("update")) {
                articleController.update();
            } else if (command.equals("delete")) {
                articleController.delete();
            } else if (command.equals("detail")) {
                articleController.detail();
            } else if(command.equals("search")) {
                articleController.search();
            } else if(command.equals("signup")) {
                memberController.signup();
            } else if(command.equals("login")) {
                memberController.login();
            } else if(command.equals("logout")) {
                memberController.logout();
            } else if (command.equals("sort")) {

            }
        }

    }



}