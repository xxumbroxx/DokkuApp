package pe.com.gmd.dokkuapp.domain.ro.response;

/**
 * Created by glarab on 03/06/2016.
 */

public class BaseResponse {

  //  @SerializedName("IsSuccess")
    private int resultCode;

   // @SerializedName("Exception")
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

}
