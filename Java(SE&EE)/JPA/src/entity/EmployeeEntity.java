package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "EMPLOYEE", schema = "APP")
public class EmployeeEntity {
    private int empno;
    private String ename;
    private String jobTitle;

    @Id
    @Column(name = "EMPNO")
    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    @Basic
    @Column(name = "ENAME")
    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    @Basic
    @Column(name = "JOB_TITLE")
    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeEntity that = (EmployeeEntity) o;
        return empno == that.empno && Objects.equals(ename, that.ename) && Objects.equals(jobTitle, that.jobTitle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empno, ename, jobTitle);
    }
}
