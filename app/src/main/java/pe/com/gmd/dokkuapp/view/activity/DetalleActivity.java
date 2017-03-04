package pe.com.gmd.dokkuapp.view.activity;

import android.graphics.PorterDuff;
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
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import pe.com.gmd.dokkuapp.R;
import pe.com.gmd.dokkuapp.view.fragment.FirstMapFragment;
import pe.com.gmd.dokkuapp.view.fragment.InformacionGeneralFragment;
import pe.com.gmd.dokkuapp.view.fragment.RutasFragment;

public class DetalleActivity extends AppCompatActivity {

    @Bind(R.id.pager)
    ViewPager mViewPager;

    @Bind(R.id.texto_toolbar_tituloboton)
    TextView textoToolbarTituloboton;

    @Bind(R.id.tabs)
    TabLayout tabLayout;

    @Bind(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbar;
    @Bind(R.id.appbar)
    AppBarLayout appbar;
    @Bind(R.id.coordinator)
    CoordinatorLayout coordinator;
    @Bind(R.id.closeDetalle)
    ImageButton closeDetalle;

    private static final int[] ICONS = new int[]{R.drawable.ic_map,R.drawable.ic_paraderos, R.drawable.ic_rutas/*, R.drawable.ic_contract,R.drawable.ic_constcenter*/};

    final List<Fragment> fragments = new ArrayList<>();
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private final int COUNT_OPTIONS_TOOLBAR= 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        ButterKnife.bind(this);

        fragments.add(FirstMapFragment.newInstance());
        fragments.add(InformacionGeneralFragment.newInstance("S", ""));
        fragments.add(RutasFragment.newInstance("S", ""));

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager(),fragments);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        tabLayout.setupWithViewPager(mViewPager);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
//
                View view = tab.getCustomView();
                ((ImageView)view.findViewById(R.id.icon_tab_options)).setColorFilter(getResources().getColor(android.R.color.white), PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                View view = tab.getCustomView();
                ((ImageView)view.findViewById(R.id.icon_tab_options)).setColorFilter(getResources().getColor(R.color.colorSombra), PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        customIconTab();
        initTab();
        mViewPager.setCurrentItem(0);
        textoToolbarTituloboton.setText("METROPOLITANO");

        closeDetalle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    void initTab(){
        View view = tabLayout.getTabAt(0).getCustomView();
        ((ImageView)view.findViewById(R.id.icon_tab_options)).setColorFilter(getResources().getColor(android.R.color.white), PorterDuff.Mode.SRC_IN);
        //pintar deseleccionados
        View viewTab2 = tabLayout.getTabAt(1).getCustomView();
        ((ImageView)viewTab2.findViewById(R.id.icon_tab_options)).setColorFilter(getResources().getColor(R.color.colorSombra), PorterDuff.Mode.SRC_IN);
        View viewTab3 = tabLayout.getTabAt(2).getCustomView();
        ((ImageView)viewTab3.findViewById(R.id.icon_tab_options)).setColorFilter(getResources().getColor(R.color.colorSombra), PorterDuff.Mode.SRC_IN);

    }

    public void customIconTab(){
        for(int i = 0; i < COUNT_OPTIONS_TOOLBAR;i++){
            View view = getLayoutInflater().from(this).inflate(R.layout.tab_item_selected_toolbar, null, false);
            ImageView imageView = (ImageView)view.findViewById(R.id.icon_tab_options);

            imageView.setImageDrawable(getResources().getDrawable(ICONS[i]));
            tabLayout.getTabAt(i).setCustomView(view);
            //para setear iconos
            tabLayout.getTabAt(i).setIcon(getResources().getDrawable(ICONS[i]));
        }
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        List<Fragment> fragments;

        public SectionsPagerAdapter(FragmentManager fm,List<Fragment> fragments) {
            super(fm);
            this.fragments = fragments;

        }

        @Override
        public Fragment getItem(int position){
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).

            return fragments.get(position);
        }
        @Override
        public int getCount() {
            // Show 3 total pages.
            return COUNT_OPTIONS_TOOLBAR;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            //    switch (position) {
            //        case 0:
            //            return "SECTION 1";
            //        case 1:
            //            return "SECTION 2";
            //        case 2:
            //            return "SECTION 3";
            //        case 3:
            //            return "SECTION 4";
            //    }
            return null;
        }
    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_detalle);
//        ButterKnife.bind(this);
//
//        setupViewPager(mViewPager);
//        tabs.setupWithViewPager(mViewPager);
//
//        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });
//
//        textoToolbarTituloboton.setText("METROPOLITANO");
//
//
//    }
//
//    private void setupViewPager(ViewPager viewPager) {
//        SectionsPagerAdapter adapter = new SectionsPagerAdapter(getSupportFragmentManager());
//        adapter.addFragment(FirstMapFragment.newInstance(), "MAPA");
//        adapter.addFragment(InformacionGeneralFragment.newInstance("S", ""), "PARADEROS");
//        adapter.addFragment(RutasFragment.newInstance("S", ""), "RUTAS");
//
//        viewPager.setAdapter(adapter);
//
//    }
//
//    public class SectionsPagerAdapter extends FragmentPagerAdapter {
//        private final List<Fragment> mFragments = new ArrayList<>();
//        private final List<String> mFragmentTitles = new ArrayList<>();
//
//
//        public SectionsPagerAdapter(FragmentManager fm) {
//            super(fm);
//        }
//
//        @Override
//        public Fragment getItem(int position) {
//
//            return mFragments.get(position);
//        }
//
//        @Override
//        public CharSequence getPageTitle(int position) {
//            return mFragmentTitles.get(position);
//        }
//
//        @Override
//        public int getCount() {
//            return mFragments.size();
//        }
//
//        public void addFragment(Fragment fragment, String title) {
//            mFragments.add(fragment);
//            mFragmentTitles.add(title);
//
//        }
//
//
//        @Override
//        public int getItemPosition(Object object) {
//            return super.getItemPosition(object);
//        }
//    }



}
