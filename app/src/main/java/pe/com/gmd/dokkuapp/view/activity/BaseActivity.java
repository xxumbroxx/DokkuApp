package pe.com.gmd.dokkuapp.view.activity;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import pe.com.gmd.dokkuapp.R;
import pe.com.gmd.dokkuapp.domain.model.User;
import pe.com.gmd.dokkuapp.service.business.UserService;
import pe.com.gmd.dokkuapp.service.business.impl.UserServiceImpl;

/**
 * Created by innovagmd on 25/01/17.
 */

public class BaseActivity extends AppCompatActivity {
    BaseActivity activity;
    UserService userService;
    User user;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = this;;
        userService= (UserService) new UserServiceImpl();
        user = userService.getCurrentUser();
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public User getUser() {
        return user;
    }



    protected void callActivity(final String classCalled) {
        Bundle bundle = new Bundle();
        callActivity(classCalled, bundle);
    }

    public void callActivity(final String classCalled, Bundle bundle) {
        Intent intent = new Intent();
        intent.setClassName(this, classCalled);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void callActivity(final String classCalled, Bundle bundle,
                             final int requestCode) {
        Intent intent = new Intent();
        intent.setClassName(this, classCalled);
        intent.putExtras(bundle);
        startActivityForResult(intent, requestCode);
    }

    public void toastShow(int resId) {

     //   ToastUtils.showShortToast(resId);
        Toast.makeText(activity, resId, Toast.LENGTH_SHORT).show();
    }

    public void toastShow(String resId) {
        Toast.makeText(activity, resId, Toast.LENGTH_SHORT).show();
       // ToastUtils.showShortToast(resId);
    }

    public ProgressDialog progressDialog;

    public ProgressDialog showProgressDialog() {
        progressDialog = new ProgressDialog(activity);
        progressDialog.setMessage(getString(R.string.mensaje_progress_dialog));
        progressDialog.show();
        return progressDialog;
    }

    public ProgressDialog showProgressDialog(CharSequence message) {
        progressDialog = new ProgressDialog(activity);
        progressDialog.setMessage(message);
        progressDialog.show();
        return progressDialog;
    }

    public void dismissProgressDialog() {
        if (progressDialog != null && progressDialog.isShowing()) {
            // progressDialog.hide();会导致android.view.WindowLeaked
            progressDialog.dismiss();
        }
    }


    public  void getUsuarioActivo(){

    }

    public  void getIdUsuarioActivo(){

    }

    protected void addFragment(int containerViewId, Fragment fragment) {
        final FragmentTransaction fragmentTransaction = this.getFragmentManager().beginTransaction();
        fragmentTransaction.add(containerViewId, fragment);
        fragmentTransaction.commit();
    }

}
