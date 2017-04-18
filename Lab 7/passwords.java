import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@javax.persistence.Entity
@javax.persistence.Table(name = "passwords")

public class passwords {
    @Id
    @GeneratedValue
    String userid;
    String scheme;
    Double time_per_unit;
    String state;
    String time_taken_c1;
    String state_c1;
    String time_taken_c2;
    String state_c2;
    String time_taken_c3;
    String state_c3;
    String time_taken_c7;
    String state_c7;
    String time_taken_c4;
    String state_c4;
    String time_taken_c5;
    String state_c5;
    String time_taken_c6;
    String state_c6;

    public String getUserid() {
        return userid;
    }

    public String getScheme() {
        return scheme;
    }

    public Double getTime_per_unit() {
        return time_per_unit;
    }

    public String getState() {
        return state;
    }

    public String getTime_taken_c1() {
        return time_taken_c1;
    }

    public String getState_c1() {
        return state_c1;
    }

    public String getTime_taken_c2() {
        return time_taken_c2;
    }

    public String getState_c2() {
        return state_c2;
    }

    public String getTime_taken_c3() {
        return time_taken_c3;
    }

    public String getState_c3() {
        return state_c3;
    }

    public String getTime_taken_c7() {
        return time_taken_c7;
    }

    public String getState_c7() {
        return state_c7;
    }

    public String getTime_taken_c4() {
        return time_taken_c4;
    }

    public String getState_c4() {
        return state_c4;
    }

    public String getTime_taken_c5() {
        return time_taken_c5;
    }

    public String getState_c5() {
        return state_c5;
    }

    public String getTime_taken_c6() {
        return time_taken_c6;
    }

    public String getState_c6() {
        return state_c6;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    public void setTime_per_unit(Double time_per_unit) {
        this.time_per_unit = time_per_unit;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setTime_taken_c1(String time_taken_c1) {
        this.time_taken_c1 = time_taken_c1;
    }

    public void setState_c1(String state_c1) {
        this.state_c1 = state_c1;
    }

    public void setTime_taken_c2(String time_taken_c2) {
        this.time_taken_c2 = time_taken_c2;
    }

    public void setState_c2(String state_c2) {
        this.state_c2 = state_c2;
    }

    public void setTime_taken_c3(String time_taken_c3) {
        this.time_taken_c3 = time_taken_c3;
    }

    public void setState_c3(String state_c3) {
        this.state_c3 = state_c3;
    }

    public void setTime_taken_c7(String time_taken_c7) {
        this.time_taken_c7 = time_taken_c7;
    }

    public void setState_c7(String state_c7) {
        this.state_c7 = state_c7;
    }

    public void setTime_taken_c4(String time_taken_c4) {
        this.time_taken_c4 = time_taken_c4;
    }

    public void setState_c4(String state_c4) {
        this.state_c4 = state_c4;
    }

    public void setTime_taken_c5(String time_taken_c5) {
        this.time_taken_c5 = time_taken_c5;
    }

    public void setState_c5(String state_c5) {
        this.state_c5 = state_c5;
    }

    public void setTime_taken_c6(String time_taken_c6) {
        this.time_taken_c6 = time_taken_c6;
    }

    public void setState_c6(String state_c6) {
        this.state_c6 = state_c6;
    }

}
