package uren.com.happysleepingbabies.MainFragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;


public class BaseFragment extends Fragment {

    public FragmentNavigation mFragmentNavigation;

    public FragmentNavigation getmFragmentNavigation() {
        return mFragmentNavigation;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FragmentNavigation) {
            mFragmentNavigation = (FragmentNavigation) context;
        }
    }

    public interface FragmentNavigation {
        void pushFragment(Fragment fragment);
        void pushFragment(Fragment fragment, String animationTag);
    }

}