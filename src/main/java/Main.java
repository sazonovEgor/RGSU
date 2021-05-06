import service.LogService;
import view.ConsoleView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        LogService logService = new LogService();
        ConsoleView consoleView = new ConsoleView();
        Parser parser = new Parser();
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите дату за которую хотите получить логи: ");
        String dateLog = sc.nextLine();
        try {
            parser.parseJSON(parser.getHTML(dateLog));
            consoleView.showLog(parser.getLogs());
            logService.persist(parser.getLogs());
        } catch (Exception e) {
            System.out.println(parser.getHTML(dateLog));
        }
    }
}
