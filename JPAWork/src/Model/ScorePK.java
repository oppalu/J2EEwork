package Model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by phoebegl on 2017/2/20.
 */
public class ScorePK implements Serializable {
    private String cid;
    private String sid;

    @Column(name = "cid")
    @Id
    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    @Column(name = "sid")
    @Id
    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ScorePK scorePK = (ScorePK) o;

        if (cid != null ? !cid.equals(scorePK.cid) : scorePK.cid != null) return false;
        if (sid != null ? !sid.equals(scorePK.sid) : scorePK.sid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cid != null ? cid.hashCode() : 0;
        result = 31 * result + (sid != null ? sid.hashCode() : 0);
        return result;
    }
}
