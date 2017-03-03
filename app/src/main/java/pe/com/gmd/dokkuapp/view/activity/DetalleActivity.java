package pe.com.gmd.dokkuapp.view.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import pe.com.gmd.dokkuapp.R;
import pe.com.gmd.dokkuapp.view.fragment.FirstMapFragment;
import pe.com.gmd.dokkuapp.view.fragment.InformacionGeneralFragment;

public class DetalleActivity extends AppCompatActivity {

    @Bind(R.id.pager)
    ViewPager mViewPager;
    @Bind(R.id.texto_toolbar_tituloboton)
    TextView textoToolbarTituloboton;
    @Bind(R.id.tabs)
    TabLayout tabs;
    @Bind(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbar;
    @Bind(R.id.appbar)
    AppBarLayout appbar;
    @Bind(R.id.coordinator)
    CoordinatorLayout coordinator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        ButterKnife.bind(this);

        setupViewPager(mViewPager);
        tabs.setupWithViewPager(mViewPager);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        textoToolbarTituloboton.setText("METROPOLITANO");


    }


    private void setupViewPager(ViewPager viewPager) {
        SectionsPagerAdapter adapter = new SectionsPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(FirstMapFragment.newInstance(), "MAPA");
        adapter.addFragment(InformacionGeneralFragment.newInstance("S", ""), "PARADEROS");
        adapter.addFragment(InformacionGeneralFragment.newInstance("S", ""), "RUTAS");

        viewPager.setAdapter(adapter);

    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragments = new ArrayList<>();
        private final List<String> mFragmentTitles = new ArrayList<>();


        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            return mFragments.get(position);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitles.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragments.add(fragment);
            mFragmentTitles.add(title);

        }


        @Override
        public int getItemPosition(Object object) {
            return super.getItemPosition(object);
        }
    }
}
