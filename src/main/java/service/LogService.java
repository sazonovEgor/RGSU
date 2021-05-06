package service;

import dao.LogDAO;
import entity.Log;

import java.util.List;

public class LogService {

    private static LogDAO logDAO;

    public LogService() {
        logDAO = new LogDAO();
    }

    public void persist(List<Log> logs) {
        logDAO.openCurrentSessionWithTransaction();

        for (Log log : logs) {
            logDAO.persist(log);
        }
        logDAO.closeCurrentSessionWithTransaction();
    }
}
