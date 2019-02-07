package uren.com.happysleepingbabies.GeneralUtils;

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

public class GetItemValuesUtil {

    public static int getItemImageId(String comingFrom){
        int imageId;
        switch (comingFrom) {
            case ITEM_REFRIGERATOR:
                imageId = R.drawable.refrigerator;
                break;
            case ITEM_VACUUM_CLEANER:
                imageId = R.drawable.vacuum_cleaner;
                break;
            case ITEM_FIRE:
                imageId = R.drawable.fire;
                break;
            case ITEM_HAIR_DRYER:
                imageId = R.drawable.hair_dryer;
                break;
            case ITEM_FAN:
                imageId = R.drawable.fan;
                break;
            case ITEM_RAIN:
                imageId = R.drawable.rain;
                break;
            case ITEM_CRICKET:
                imageId = R.drawable.cricket;
                break;
            case ITEM_WATERFALL:
                imageId = R.drawable.waterfall;
                break;
            case ITEM_WIND:
                imageId = R.drawable.wind;
                break;
            case ITEM_ELECTRICITY:
                imageId = R.drawable.electricity;
                break;
            case ITEM_WAVE:
                imageId = R.drawable.wave;
                break;
            case ITEM_RIVER:
                imageId = R.drawable.river;
                break;
            case ITEM_WATER:
                imageId = R.drawable.water;
                break;
            case ITEM_UNDERWATER:
                imageId = R.drawable.underwater;
                break;
            default:
                imageId = 0;
                break;
        }
        return imageId;
    }

    public static int getItemSoundId(String comingFrom){
        int imageId;
        switch (comingFrom) {
            case ITEM_REFRIGERATOR:
                imageId = R.raw.refrigerator_sound;
                break;
            case ITEM_VACUUM_CLEANER:
                imageId = R.raw.vacuum_cleaner_sound;
                break;
            case ITEM_FIRE:
                imageId = R.raw.fire_sound;
                break;
            case ITEM_HAIR_DRYER:
                imageId = R.raw.hair_dryer_sound;
                break;
            case ITEM_FAN:
                imageId = R.raw.fan_sound;
                break;
            case ITEM_RAIN:
                imageId = R.raw.rain_sound;
                break;
            case ITEM_CRICKET:
                imageId = R.raw.cricket_sound;
                break;
            case ITEM_WATERFALL:
                imageId = R.raw.waterfall_sound;
                break;
            case ITEM_WIND:
                imageId = R.raw.wind_sound;
                break;
            case ITEM_ELECTRICITY:
                imageId = R.raw.electricity_sound;
                break;
            case ITEM_WAVE:
                imageId = R.raw.wave_sound;
                break;
            case ITEM_RIVER:
                imageId = R.raw.river_sound;
                break;
            case ITEM_WATER:
                imageId = R.raw.water_sound;
                break;
            case ITEM_UNDERWATER:
                imageId = R.raw.underwater_sound;
                break;
            default:
                imageId = 0;
                break;
        }
        return imageId;
    }
}
