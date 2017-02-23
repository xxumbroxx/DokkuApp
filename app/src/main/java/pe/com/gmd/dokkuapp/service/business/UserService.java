package pe.com.gmd.dokkuapp.service.business;

import android.content.Context;

import pe.com.gmd.dokkuapp.domain.model.User;


/**
 * Created by jmauriciog on 01/06/2016.
 */
public interface UserService {

    public void login(final Context ctx, String username, String password);

    public User getCurrentUser();
    public void logout();

}
