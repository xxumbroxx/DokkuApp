package pe.com.gmd.dokkuapp.view.activity;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import pe.com.gmd.dokkuapp.R;

public class MainActivity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;
    private static final int[] ICONS = new int[]{R.drawable.ic_resumen,R.drawable.ic_principal, R.drawable.ic_notificaciones/*, R.drawable.ic_contract,R.drawable.ic_constcenter*/};
    private final int COUNT_OPTIONS_TOOLBAR= 3;
    TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        setTitle("DOKKU");
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 0:
                        setTitle("Selección de campos");break;
                    case 1:
                        setTitle("Estado de campos");break;
                    case 2:
                        setTitle("Notificaciones");break;
//                    case 3:
//                        setTitle("Centro de Costos");break;
                }
                View view = tab.getCustomView();
                ((ImageView)view.findViewById(R.id.icon_tab_options)).setColorFilter(getResources().getColor(android.R.color.white), PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                View view = tab.getCustomView();
                ((ImageView)view.findViewById(R.id.icon_tab_options)).setColorFilter(getResources().getColor(R.color.red_tab_selected_icon), PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        customIconTab();

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.shape:
                return true;
            case R.id.logOut:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.section_label);

            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position){
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).

            return PlaceholderFragment.newInstance(position + 1);
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
}
