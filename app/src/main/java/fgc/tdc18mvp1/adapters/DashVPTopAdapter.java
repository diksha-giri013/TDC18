package fgc.tdc18mvp1.adapters;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;

import fgc.tdc18mvp1.R;
import fgc.tdc18mvp1.fragments.DashVPTopFrag;

public class DashVPTopAdapter extends AppCompatActivity {


        public static class MyPagerAdapter extends FragmentPagerAdapter {
            public MyPagerAdapter(FragmentManager fm) {
                super(fm);
            }

            @Override
            public android.support.v4.app.Fragment getItem(int pos) {
                switch (pos) {
                    case 0:
                        return DashVPTopFrag.newInstance("Festive.Social Promo", "Like Our FB Page to gain entry!",  R.drawable.layer);
                    case 1:
                        return DashVPTopFrag.newInstance("Title 2", "Subtitle", R.drawable.layer);
                    case 2:
                        return DashVPTopFrag.newInstance("Title 3", "Subtitle", R.drawable.layer);
                    default:
                        return DashVPTopFrag.newInstance("Title 1", "Subtitle", R.drawable.layer);
                }
            }

            @Override
            public int getCount() {
                return 3;
            }
        }

    }
