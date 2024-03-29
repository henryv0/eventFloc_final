package application.floc.event.eventfloc;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import application.floc.event.eventfloc.Fragments.EndingFragment;
import application.floc.event.eventfloc.Fragments.ExploreFragment;
import application.floc.event.eventfloc.Fragments.SocietiesFragment;

/**
 * Created by henryvo on 9/05/15.
 */
public class TabFragmentPagerAdapter extends FragmentPagerAdapter {
    final int PAGE_COUNT = 3;
    private String tabTitles[] = new String[]{"Explore", "All", "Societies"};
    private Context context;
    private Fragment[] mFragments = {
            new ExploreFragment(),
            new EndingFragment(),
            new SocietiesFragment()
    };

    public TabFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        //return PageFragment.newInstance(position + 1);

        switch (position) {
            case 0:
                ExploreFragment fragment1 = new ExploreFragment();
                return fragment1;
            case 1:
                EndingFragment fragment2 = new EndingFragment();
                return fragment2;
            case 2:
                SocietiesFragment fragment3 = new SocietiesFragment();
                return fragment3;
            default:
                return null;
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }
}