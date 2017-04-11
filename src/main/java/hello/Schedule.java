package hello;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.security.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by jonas on 05/04/2017.
 */
@Entity
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    @JsonBackReference
    @CreatedBy
    private Person person;

    @LastModifiedDate
    private Date lastModifiedDt;

    @Column
    private String program;

    public Schedule() {}

    public Schedule(Person person, String program, Date lastModifiedDt) {
        this.person = person;
        this.program = program;
        this.lastModifiedDt = lastModifiedDt;
    }

    public Long getid() {
        return id;
    }

    public void setid(Long id) {
        id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getLastModifiedDt() {
        final DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        return df.format(lastModifiedDt);
    }

    public void setLastModifiedDt(Date lastModifiedDt) {
        this.lastModifiedDt = lastModifiedDt;
    }
}
