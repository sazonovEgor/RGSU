package view;

import entity.Log;

import java.io.File;
import java.util.List;

public class FileView implements Viewable<Log> {

    @Override
    public void showLog(List<Log> logs) {
        File file = new File("resources/logs.txt");
    }
}
