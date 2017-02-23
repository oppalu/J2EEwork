package com.phoebe.Model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by phoebegl on 2017/2/21.
 */
@Entity
@IdClass(ScorePK.class)
@Table(name = "score",schema = "homework1")
public class Score implements Serializable {
    private String cid;
    private String sid;
    private String coursename;
    private int year;
    private Double score;
    private String detail;

    @Id
    @Column(name = "cid", nullable = false, length = 20)
    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    @Id
    @Column(name = "sid", nullable = false, length = 20)
    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    @Basic
    @Column(name = "coursename", nullable = false, length = 255)
    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    @Basic
    @Column(name = "year", nullable = false)
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Basic
    @Column(name = "score", nullable = true, precision = 0)
    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    @Basic
    @Column(name = "detail", nullable = true, length = 255)
    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Score score1 = (Score) o;

        if (year != score1.year) return false;
        if (cid != null ? !cid.equals(score1.cid) : score1.cid != null) return false;
        if (sid != null ? !sid.equals(score1.sid) : score1.sid != null) return false;
        if (coursename != null ? !coursename.equals(score1.coursename) : score1.coursename != null) return false;
        if (score != null ? !score.equals(score1.score) : score1.score != null) return false;
        if (detail != null ? !detail.equals(score1.detail) : score1.detail != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cid != null ? cid.hashCode() : 0;
        result = 31 * result + (sid != null ? sid.hashCode() : 0);
        result = 31 * result + (coursename != null ? coursename.hashCode() : 0);
        result = 31 * result + year;
        result = 31 * result + (score != null ? score.hashCode() : 0);
        result = 31 * result + (detail != null ? detail.hashCode() : 0);
        return result;
    }
}
