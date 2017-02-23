package pe.com.gmd.dokkuapp.domain.ro.response;


import pe.com.gmd.dokkuapp.domain.model.User;

/**
 * Created by jmauriciog on 30/12/2016.
 */

public class LoginResponse {

    private User Data;

    public User getData() {
        return Data;
    }

    public void setData(User data) {
        Data = data;
    }

}
