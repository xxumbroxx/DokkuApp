package pe.com.gmd.dokkuapp.service.business.impl;


/**
 * Created by jmauriciog on 01/06/2016.
 */
public class UserServiceImpl {

//    UserDAO userDao = new UserDAOImpl();
//
//    @Override
//    public void login(final Context ctx, String username, String password) {
//        LoginRequest loginRequest = new LoginRequest(username,password);
//        Call<LoginResponse> call = AndroidApplication.getInstance().getService().login(loginRequest);
//        call.enqueue(new Callback<LoginResponse>() {
//            @Override
//            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
//                if(response.isSuccessful()){
//                    LoginResponse loginResponse = response.body();
//                    LogUtil.d("LoginResponse", "LoginResponse" + response.body().toString());
//
//                    EventBus.getDefault().post(loginResponse);
//                   // RedirectManager.returnToCallback(ctx, loginResponse, callback);
//                }
//                else{
//
//                }
//            }
//            @Override
//            public void onFailure(Call<LoginResponse> call, Throwable t) {
//                Log.e("error", t.toString());
//                LoginResponse loginResponse=new LoginResponse();
//
//                EventBus.getDefault().post(loginResponse);
//            }
//        });
//    }
//
//    @Override
//    public User getCurrentUser(){
//        return userDao.getCurrentUser();
//    }
//
//    @Override
//    public void logout() {
//        userDao.logout();
//    }


}
