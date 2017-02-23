package pe.com.gmd.dokkuapp.domain.model;



/**
 * Created by jmauriciog on 02/06/2016.
 */
public class FcmToken  {

    private String gcmId;
    private int state; // 1 - enviado, 0 - no enviado

    public FcmToken(){

    }

    public FcmToken(String gcmId, int state) {
        this.gcmId = gcmId;
        this.state = state;
    }

    public String getGcmId() {
        return gcmId;
    }

    public void setGcmId(String gcmId) {
        this.gcmId = gcmId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
