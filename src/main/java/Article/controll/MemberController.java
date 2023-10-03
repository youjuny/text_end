package Article.controll;

import Article.model.Member;
import Article.model.MemberRepository;

import java.util.Scanner;

public class MemberController {
    private Scanner scan = new Scanner(System.in);

    private MemberRepository memberRepository = new MemberRepository();

    private Member logInedMember = null;


    public void signup(){
        System.out.println("==== 회원 가입을 진행합니다 ====");
        System.out.print("아이디를 입력해주세요 : ");
        String loginId = scan.nextLine();
        System.out.print("패스워드를 입력해주세요 : ");
        String loginPw = scan.nextLine();
        System.out.print("닉네임을 입력해주세요 : ");
        String nickname = scan.nextLine();

        memberRepository.insert(loginId,loginPw,nickname);

        System.out.println("==== 회원가입이 완료되었습니다. ====");

    }

    public void login() {
        System.out.print("아이디 : ");
        String loginId = scan.nextLine();
        System.out.print("패스워드 : ");
        String loginPw = scan.nextLine();

        Member member = memberRepository.gerMemberByLoginId(loginId);

        String failMsg = "잘못된 회원정보입니다.";

        if (member == null) {
            System.out.println(failMsg);
            return;
        }

        if (!member.getLoginPw().equals(loginPw)) {
            System.out.println(failMsg);
            return;
        }

        System.out.printf("%s님 환영합니다.\n",member.getNickname());

        logInedMember = member;


    }

    public void logout() {

        if (logInedMember != null) {
            System.out.print("정말로 로그아웃 하시겠습니까? (y/n) : ");
            String isAgree = scan.nextLine();

            if (isAgree.equals("y")) {
                logInedMember = null;
                System.out.println("로그아웃 되었습니다.");
            }
        } else {
            System.out.println("로그인 상태가 아닙니다.");
        }

    }



    public Member getLogInedMember() {
        return logInedMember;
    }

}
