package dao;

import java.io.Serializable;

public interface LogDaoInterface <T, Id extends Serializable> {

     void persist(T entity);
}
