package pe.com.gmd.dokkuapp.view.activity;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;


import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import com.viewpagerindicator.CirclePageIndicator;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pe.com.gmd.dokkuapp.R;
import pe.com.gmd.dokkuapp.domain.model.Slide;
import pe.com.gmd.dokkuapp.util.AppPreferences;
import pe.com.gmd.dokkuapp.view.adapter.AdapterSlide;

import static pe.com.gmd.dokkuapp.util.Constants.GETSLIDE;


/**
 * Created by innovagmd on 30/11/16.
 */

public class SlideActivity extends BaseActivity implements ViewPager.OnPageChangeListener {


    @Bind(R.id.viewPager)
    ViewPager viewPager;
    @Bind(R.id.indicator)
    CirclePageIndicator indicator;
    @Bind(R.id.omitir)
    TextView omitir;
    @Bind(R.id.bt_back)
    ImageButton btBack;
    @Bind(R.id.bt_next)
    Button btNext;
    private int position = 0;
    private Context context;
    List<Slide> items;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide);
        ButterKnife.bind(this);
        getSupportActionBar().hide();
        context = this;
        btBack.setVisibility(View.GONE);
        items = GETSLIDE();

        viewPager.setAdapter(new AdapterSlide(this, items));
        // mViewPager.addOnPageChangeListener(
        viewPager.addOnPageChangeListener(this);
        indicator.setViewPager(viewPager);
        saveFlagOnboarding();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @OnClick({R.id.omitir, R.id.bt_back, R.id.bt_next})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.omitir:
                goToHistoriasActivity();
                break;
            case R.id.bt_back:
                viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
                break;
            case R.id.bt_next:
                if (position == items.size() - 1) {
                    goToHistoriasActivity();
                } else {
                    viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                }
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
        this.position = position;

        if (position == items.size() - 1) {
            btNext.setText(getString(R.string.slide_finalizar));
            omitir.setVisibility(View.GONE);
        } else {
            btNext.setText(getString(R.string.siguiente));
            omitir.setVisibility(View.VISIBLE);
        }

        if (position == 0) {
            btBack.setVisibility(View.GONE);
        } else {
            btBack.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    private void saveFlagOnboarding() {
        AppPreferences.getInstance(context).savePreference(AppPreferences.FLAG_ONBOARDING, true);
    }

    private void goToHistoriasActivity() {
        callActivity(LoginActivity.class.getName());
        finish();
    }

    @Override
    public void onBackPressed() {
        // disable
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Slide Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
