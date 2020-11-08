package com.theviciousgames.s20advancedmenutrial;

public class Resources {
    public static final String SCREEN_HZ_CHANGE_TO_48_MIN = "settings put system min_refresh_rate 48.0 ";
    public static final String SCREEN_HZ_CHANGE_TO_48_PEAK = "settings put system peak_refresh_rate 48.0 ";
    public static final String SCREEN_HZ_CHANGE_TO_60_MIN = "settings put system min_refresh_rate 60.0 ";
    public static final String SCREEN_HZ_CHANGE_TO_60_PEAK = "settings put system peak_refresh_rate 60.0 ";
    public static final String SCREEN_HZ_CHANGE_TO_96_MIN = "settings put system min_refresh_rate 96.0 ";
    public static final String SCREEN_HZ_CHANGE_TO_96_PEAK = "settings put system peak_refresh_rate 96.0 ";
    public static final String SCREEN_HZ_CHANGE_TO_120_MIN = "settings put system min_refresh_rate 120.0 ";
    public static final String SCREEN_HZ_CHANGE_TO_120_PEAK = "settings put system peak_refresh_rate 120.0 ";

    public static final String SCREEN_RESOLUTION_CHANGE_TO_HD = "wm size 720x1600 & wm density 300 ";
    public static final String SCREEN_RESOLUTION_CHANGE_TO_FHD = "wm size 1080x2400 & wm density 450 ";
    public static final String SCREEN_RESOLUTION_CHANGE_TO_WQHD = "wm size 1440x3200 & wm density 600 ";

    public static final String SCREEN_DEFAULT_MODES_SET_TO_0 = "settings put secure refresh_rate_mode 0 ";
    public static final String SCREEN_DEFAULT_MODES_SET_TO_2 = "settings put secure refresh_rate_mode 2 ";

    public static final int SCREEN_RESOLUTION_VERTICAL_PIXELS_HD = 1461;
    public static final int SCREEN_RESOLUTION_VERTICAL_PIXELS_FHD = 2192;
    public static final int SCREEN_RESOLUTION_VERTICAL_PIXELS_WQHD = 2923;

    public static final String POWER_SAVE_MODE_STATUS = "settings get global low_power";

    public static final String ADB_DEBUGGING_STATUS = "settings get global adb_enabled";
    public static final String ADB_DEBUGGING_ENABLE = "settings put global adb_enabled 1";
    public static final String ADB_DEBUGGING_DISABLE = "settings put global adb_enabled 0";

    public static final String REBOOT = "reboot";
    public static final String REBOOT_RECOVERY = "reboot recovery";
    public static final String REBOOT_DOWNLOAD = "reboot download";


}
