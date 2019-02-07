package uren.com.happysleepingbabies.Fragments;

import android.annotation.SuppressLint;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import butterknife.BindView;
import butterknife.ButterKnife;
import uren.com.happysleepingbabies.GeneralUtils.AdMobUtils;
import uren.com.happysleepingbabies.GeneralUtils.ShapeUtil;
import uren.com.happysleepingbabies.MainFragments.BaseFragment;
import uren.com.happysleepingbabies.R;

import static uren.com.happysleepingbabies.Constants.StringConstant.ITEM_CRICKET;
import static uren.com.happysleepingbabies.Constants.StringConstant.ITEM_ELECTRICITY;
import static uren.com.happysleepingbabies.Constants.StringConstant.ITEM_FAN;
import static uren.com.happysleepingbabies.Constants.StringConstant.ITEM_FIRE;
import static uren.com.happysleepingbabies.Constants.StringConstant.ITEM_HAIR_DRYER;
import static uren.com.happysleepingbabies.Constants.StringConstant.ITEM_RAIN;
import static uren.com.happysleepingbabies.Constants.StringConstant.ITEM_REFRIGERATOR;
import static uren.com.happysleepingbabies.Constants.StringConstant.ITEM_RIVER;
import static uren.com.happysleepingbabies.Constants.StringConstant.ITEM_UNDERWATER;
import static uren.com.happysleepingbabies.Constants.StringConstant.ITEM_VACUUM_CLEANER;
import static uren.com.happysleepingbabies.Constants.StringConstant.ITEM_WATER;
import static uren.com.happysleepingbabies.Constants.StringConstant.ITEM_WATERFALL;
import static uren.com.happysleepingbabies.Constants.StringConstant.ITEM_WAVE;
import static uren.com.happysleepingbabies.Constants.StringConstant.ITEM_WIND;

public class MainFragment extends BaseFragment implements View.OnClickListener {

    View mView;

    @BindView(R.id.refrigeratorLayout)
    LinearLayout refrigeratorLayout;
    @BindView(R.id.vacuumCleanerLayout)
    LinearLayout vacuumCleanerLayout;
    @BindView(R.id.fireLayout)
    LinearLayout fireLayout;
    @BindView(R.id.hairDryerLayout)
    LinearLayout hairDryerLayout;
    @BindView(R.id.fanLayout)
    LinearLayout fanLayout;
    @BindView(R.id.rainLayout)
    LinearLayout rainLayout;
    @BindView(R.id.cricketLayout)
    LinearLayout cricketLayout;
    @BindView(R.id.waterfallLayout)
    LinearLayout waterfallLayout;
    @BindView(R.id.windLayout)
    LinearLayout windLayout;
    @BindView(R.id.electricityLayout)
    LinearLayout electricityLayout;
    @BindView(R.id.waveLayout)
    LinearLayout waveLayout;
    @BindView(R.id.riverLayout)
    LinearLayout riverLayout;
    @BindView(R.id.waterLayout)
    LinearLayout waterLayout;
    @BindView(R.id.underwaterLayout)
    LinearLayout underwaterLayout;
    @BindView(R.id.adView)
    AdView adView;

    public MainFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if (mView == null) {
            mView = inflater.inflate(R.layout.fragment_main, container, false);
            ButterKnife.bind(this, mView);
            init();
            setShapes();
            AdMobUtils.loadBannerAd(adView);
        }
        return mView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    private void init() {
        refrigeratorLayout.setOnClickListener(this);
        vacuumCleanerLayout.setOnClickListener(this);
        fireLayout.setOnClickListener(this);
        hairDryerLayout.setOnClickListener(this);
        fanLayout.setOnClickListener(this);
        rainLayout.setOnClickListener(this);
        cricketLayout.setOnClickListener(this);
        waterfallLayout.setOnClickListener(this);
        windLayout.setOnClickListener(this);
        electricityLayout.setOnClickListener(this);
        waveLayout.setOnClickListener(this);
        riverLayout.setOnClickListener(this);
        waterLayout.setOnClickListener(this);
        underwaterLayout.setOnClickListener(this);
        MobileAds.initialize(getContext(), getActivity().getResources().getString(R.string.ADMOB_APP_ID));
    }

    private void setShapes() {
        refrigeratorLayout.setBackground(ShapeUtil.getShape(getResources().getColor(R.color.TransparentLightBlue, null),
                getResources().getColor(R.color.White, null), GradientDrawable.RECTANGLE, 40, 2));
        vacuumCleanerLayout.setBackground(ShapeUtil.getShape(getResources().getColor(R.color.TransparentLightBlue, null),
                getResources().getColor(R.color.White, null), GradientDrawable.RECTANGLE, 40, 2));
        fireLayout.setBackground(ShapeUtil.getShape(getResources().getColor(R.color.TransparentLightBlue, null),
                getResources().getColor(R.color.White, null), GradientDrawable.RECTANGLE, 40, 2));
        hairDryerLayout.setBackground(ShapeUtil.getShape(getResources().getColor(R.color.TransparentLightBlue, null),
                getResources().getColor(R.color.White, null), GradientDrawable.RECTANGLE, 40, 2));
        fanLayout.setBackground(ShapeUtil.getShape(getResources().getColor(R.color.TransparentLightBlue, null),
                getResources().getColor(R.color.White, null), GradientDrawable.RECTANGLE, 40, 2));
        rainLayout.setBackground(ShapeUtil.getShape(getResources().getColor(R.color.TransparentLightBlue, null),
                getResources().getColor(R.color.White, null), GradientDrawable.RECTANGLE, 40, 2));
        cricketLayout.setBackground(ShapeUtil.getShape(getResources().getColor(R.color.TransparentLightBlue, null),
                getResources().getColor(R.color.White, null), GradientDrawable.RECTANGLE, 40, 2));
        waterfallLayout.setBackground(ShapeUtil.getShape(getResources().getColor(R.color.TransparentLightBlue, null),
                getResources().getColor(R.color.White, null), GradientDrawable.RECTANGLE, 40, 2));
        windLayout.setBackground(ShapeUtil.getShape(getResources().getColor(R.color.TransparentLightBlue, null),
                getResources().getColor(R.color.White, null), GradientDrawable.RECTANGLE, 40, 2));
        electricityLayout.setBackground(ShapeUtil.getShape(getResources().getColor(R.color.TransparentLightBlue, null),
                getResources().getColor(R.color.White, null), GradientDrawable.RECTANGLE, 40, 2));
        waveLayout.setBackground(ShapeUtil.getShape(getResources().getColor(R.color.TransparentLightBlue, null),
                getResources().getColor(R.color.White, null), GradientDrawable.RECTANGLE, 40, 2));
        riverLayout.setBackground(ShapeUtil.getShape(getResources().getColor(R.color.TransparentLightBlue, null),
                getResources().getColor(R.color.White, null), GradientDrawable.RECTANGLE, 40, 2));
        waterLayout.setBackground(ShapeUtil.getShape(getResources().getColor(R.color.TransparentLightBlue, null),
                getResources().getColor(R.color.White, null), GradientDrawable.RECTANGLE, 40, 2));
        underwaterLayout.setBackground(ShapeUtil.getShape(getResources().getColor(R.color.TransparentLightBlue, null),
                getResources().getColor(R.color.White, null), GradientDrawable.RECTANGLE, 40, 2));
    }

    @Override
    public void onClick(View v) {
        if (v == refrigeratorLayout) {
            if (mFragmentNavigation != null)
                mFragmentNavigation.pushFragment(new PlaySoundFragment(ITEM_REFRIGERATOR));
        }

        if (v == vacuumCleanerLayout) {
            if (mFragmentNavigation != null)
                mFragmentNavigation.pushFragment(new PlaySoundFragment(ITEM_VACUUM_CLEANER));
        }

        if (v == fireLayout) {
            if (mFragmentNavigation != null)
                mFragmentNavigation.pushFragment(new PlaySoundFragment(ITEM_FIRE));
        }

        if (v == hairDryerLayout) {
            if (mFragmentNavigation != null)
                mFragmentNavigation.pushFragment(new PlaySoundFragment(ITEM_HAIR_DRYER));
        }

        if (v == fanLayout) {
            if (mFragmentNavigation != null)
                mFragmentNavigation.pushFragment(new PlaySoundFragment(ITEM_FAN));
        }

        if (v == rainLayout) {
            if (mFragmentNavigation != null)
                mFragmentNavigation.pushFragment(new PlaySoundFragment(ITEM_RAIN));
        }

        if (v == cricketLayout) {
            if (mFragmentNavigation != null)
                mFragmentNavigation.pushFragment(new PlaySoundFragment(ITEM_CRICKET));
        }

        if (v == waterfallLayout) {
            if (mFragmentNavigation != null)
                mFragmentNavigation.pushFragment(new PlaySoundFragment(ITEM_WATERFALL));
        }

        if (v == windLayout) {
            if (mFragmentNavigation != null)
                mFragmentNavigation.pushFragment(new PlaySoundFragment(ITEM_WIND));
        }

        if (v == electricityLayout) {
            if (mFragmentNavigation != null)
                mFragmentNavigation.pushFragment(new PlaySoundFragment(ITEM_ELECTRICITY));
        }

        if (v == waveLayout) {
            if (mFragmentNavigation != null)
                mFragmentNavigation.pushFragment(new PlaySoundFragment(ITEM_WAVE));
        }

        if (v == riverLayout) {
            if (mFragmentNavigation != null)
                mFragmentNavigation.pushFragment(new PlaySoundFragment(ITEM_RIVER));
        }

        if (v == waterLayout) {
            if (mFragmentNavigation != null)
                mFragmentNavigation.pushFragment(new PlaySoundFragment(ITEM_WATER));
        }

        if (v == underwaterLayout) {
            if (mFragmentNavigation != null)
                mFragmentNavigation.pushFragment(new PlaySoundFragment(ITEM_UNDERWATER));
        }
    }
}