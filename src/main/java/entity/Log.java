package entity;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

@Entity
@Table
public class Log implements Comparable<Log>{

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    private int user_id;
    
    private Date created_at;
    private String first_name;
    @Column(length = 1000)
    private String message;
    private String second_name;

    public Log(Date created_at, String first_name, String message, String second_name, int user_id) {
        this.created_at = created_at;
        this.first_name = first_name;
        this.message = message;
        this.second_name = second_name;
        this.user_id = user_id;
    }

    public Log() {
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSecond_name() {
        return second_name;
    }

    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String convertData(Date date) {
        String dateString = "";
        SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        dateString = sdf.format(date);
        return dateString;
    }

    @Override
    public String toString() {

        return "PersonLog{" +
                "created_at=" + convertData(getCreated_at()) +
                ", first_name='" + first_name + '\'' +
                ", message='" + message + '\'' +
                ", second_name='" + second_name + '\'' +
                ", user_id=" + user_id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Log log = (Log) o;
        return user_id == log.user_id &&
                created_at.equals(log.created_at) &&
                first_name.equals(log.first_name) &&
                message.equals(log.message) &&
                second_name.equals(log.second_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(created_at, first_name, message, second_name, user_id);
    }

    @Override
    public int compareTo(Log o) {
        return getCreated_at().compareTo(o.getCreated_at());
    }
}
