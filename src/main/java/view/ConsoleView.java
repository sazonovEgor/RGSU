package view;

import entity.Log;

import java.util.List;

public class ConsoleView implements Viewable<Log> {

    @Override
    public void showLog(List<Log> logs) {

        for (Log log : logs) {
            System.out.println(log.toString() + "\n");
        }
    }
}
