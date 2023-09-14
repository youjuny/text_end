import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    ArrayList<Article> articles = new ArrayList<>();

    public static void main(String[] args) {

        BoardApp app = new BoardApp();
        app.start();
    }
}