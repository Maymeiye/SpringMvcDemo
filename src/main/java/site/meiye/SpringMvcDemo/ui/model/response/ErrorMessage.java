package site.meiye.SpringMvcDemo.ui.model.response;

import java.util.Date;

public class ErrorMessage {
    private Date timeStamp;
    private String messgae;

    public ErrorMessage() {
    }

    public ErrorMessage(Date timeStamp, String messgae) {
        this.timeStamp = timeStamp;
        this.messgae = messgae;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getMessgae() {
        return messgae;
    }

    public void setMessgae(String messgae) {
        this.messgae = messgae;
    }
}
