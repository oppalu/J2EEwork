package Model;

/**
 * Created by phoebegl on 2017/1/3.
 */
public class Score {
    private String sid;
    private String cid;
    private String coursename;
    private int year;
    private double score;
    private String detail;

    public Score() {

    }

    public Score(String sid,String cid,String coursename,int year,double score,String detail) {
        this.sid = sid;
        this.cid = cid;
        this.coursename = coursename;
        this.year = year;
        this.score = score;
        this.detail = detail;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
