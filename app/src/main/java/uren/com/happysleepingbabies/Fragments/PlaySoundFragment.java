package uren.com.happysleepingbabies.Fragments;


import android.annotation.SuppressLint;
import android.graphics.drawable.GradientDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import uren.com.happysleepingbabies.GeneralUtils.AdMobUtils;
import uren.com.happysleepingbabies.GeneralUtils.GetItemValuesUtil;
import uren.com.happysleepingbabies.GeneralUtils.ShapeUtil;
import uren.com.happysleepingbabies.Interfaces.AdLoadCallback;
import uren.com.happysleepingbabies.MainFragments.BaseFragment;
import uren.com.happysleepingbabies.R;

import static uren.com.happysleepingbabies.Constants.NumericConstant.DEFAULT_PLAY_VALUE;
import static uren.com.happysleepingbabies.Constants.StringConstant.DEFAULT_PLAY_DURATION;
import static uren.com.happysleepingbabies.Constants.StringConstant.TIMES;

@SuppressLint("ValidFragment")
public class PlaySoundFragment extends BaseFragment {

    View mView;

    @BindView(R.id.durationTv)
    TextView durationTv;
    @BindView(R.id.itemLayout)
    LinearLayout itemLayout;
    @BindView(R.id.itemImgv)
    ImageView itemImgv;
    @BindView(R.id.chooseTimeLayout)
    RelativeLayout chooseTimeLayout;
    @BindView(R.id.timeSpinner)
    Spinner timeSpinner;
    @BindView(R.id.playImgv)
    ImageView playImgv;
    @BindView(R.id.adView)
    AdView adView;

    private String comingFrom;
    private String selectedTime = DEFAULT_PLAY_DURATION;
    private ArrayAdapter<String> timeSpinnerAdapter;
    private long selectedTimeInMillis = DEFAULT_PLAY_VALUE * 60 * 1000;
    private boolean spinnerCheck = false;

    private MediaPlayer mediaPlayer;
    private CountDownTimer countDownTimer;

    public PlaySoundFragment(String comingFrom) {
        this.comingFrom = comingFrom;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if (mView == null) {
            mView = inflater.inflate(R.layout.fragment_content_item, container, false);
            ButterKnife.bind(this, mView);
            init();
            setShapes();
            AdMobUtils.loadBannerAd(adView);
            setImage();
            setListeners();
            setSpinnerAdapter();
            setCountDownTimer();
            playAudio();
            loadInterstitialAd();
        }
        return mView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    private void init() {
        MobileAds.initialize(getContext(), getActivity().getResources().getString(R.string.ADMOB_APP_ID));
    }

    private void loadInterstitialAd() {
        AdMobUtils.loadInterstitialAd(getContext(), new AdLoadCallback() {
            @Override
            public void onLoaded(boolean loaded) {
                if(loaded)
                    pauseSound();
            }

            @Override
            public void onClosed() {
                startSound();
            }
        });
    }

    private void setShapes() {
        itemLayout.setBackground(ShapeUtil.getShape(getResources().getColor(R.color.transparentBlack, null),
                0, GradientDrawable.RECTANGLE, 40, 0));
        chooseTimeLayout.setBackground(ShapeUtil.getShape(getResources().getColor(R.color.transparent_white, null),
                0, GradientDrawable.RECTANGLE, 40, 0));
        playImgv.setBackground(ShapeUtil.getShape(getResources().getColor(R.color.transparentBlack, null),
                getResources().getColor(R.color.White, null), GradientDrawable.OVAL, 50, 3));
    }

    private void setImage() {
        Glide.with(getContext())
                .load(GetItemValuesUtil.getItemImageId(comingFrom))
                .apply(RequestOptions.fitCenterTransform())
                .into(itemImgv);
        Glide.with(getContext())
                .load(R.drawable.icon_pause)
                .apply(RequestOptions.fitCenterTransform())
                .into(playImgv);
    }

    private void setListeners() {
        playImgv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer != null) {
                    if (mediaPlayer.isPlaying())
                        pauseSound();
                    else
                        startSound();
                }
            }
        });
    }

    private void pauseSound() {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
            cancelCountDownTimer();
            Glide.with(getContext())
                    .load(R.drawable.icon_play)
                    .apply(RequestOptions.fitCenterTransform())
                    .into(playImgv);
        }
    }

    private void startSound() {
        if (mediaPlayer != null && !mediaPlayer.isPlaying()) {
            mediaPlayer.start();
            startCountDownTimer();
            Glide.with(getContext())
                    .load(R.drawable.icon_pause)
                    .apply(RequestOptions.fitCenterTransform())
                    .into(playImgv);
        }
    }

    private void setSpinnerAdapter() {
        timeSpinnerAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, TIMES);
        timeSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        timeSpinner.setAdapter(timeSpinnerAdapter);

        timeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (spinnerCheck) {
                    cancelCountDownTimer();
                    selectedTime = TIMES[position];
                    selectedTimeInMillis = Integer.parseInt(selectedTime) * 60 * 1000;
                    setCountDownTimer();

                    if (mediaPlayer != null && !mediaPlayer.isPlaying())
                        playAudio();
                } else
                    spinnerCheck = true;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    private void startCountDownTimer() {
        if (countDownTimer != null)
            countDownTimer.start();
    }

    private void cancelCountDownTimer() {
        if (countDownTimer != null)
            countDownTimer.cancel();
    }

    private void setCountDownTimer() {
        countDownTimer = new CountDownTimer(selectedTimeInMillis, 1000) {

            public void onTick(long millisUntilFinished) {
                durationTv.setText("" + String.format("%d : %d",
                        TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished),
                        TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) -
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))));
            }

            public void onFinish() {
                if (getContext() != null) {
                    stopSound();
                    durationTv.setText(getContext().getResources().getString(R.string.DONE));
                }
            }
        }.start();
    }

    private void playAudio() {
        if (getContext() != null) {
            mediaPlayer = MediaPlayer.create(getContext(), GetItemValuesUtil.getItemSoundId(comingFrom));
            mediaPlayer.setLooping(true);
            mediaPlayer.start();
        }
    }

    private void stopSound() {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            try {
                mediaPlayer.stop();
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
            try {
                mediaPlayer.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
            mediaPlayer = null;
            mediaPlayer = new MediaPlayer();
        }
    }

    public void clearMediaPlayer() {
        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying())
                mediaPlayer.stop();
            try {
                mediaPlayer.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
            mediaPlayer = null;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        cancelCountDownTimer();
        stopSound();
        clearMediaPlayer();
    }
}
