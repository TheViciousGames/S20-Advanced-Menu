package com.theviciousgames.s20advancedmenutrial;

import android.app.Activity;
import android.util.DisplayMetrics;

public class Device {
    public static class Screen {
        public static class RefreshRate {
            public static String getRefreshRate(Activity activity) {
                return activity.getWindowManager().getDefaultDisplay().getRefreshRate() + "";
            }

            public static void setRefreshRate(int val) {
                switch (val) {
                    case 48:
                        Superuser.executeCommandSU(Resources.SCREEN_DEFAULT_MODES_SET_TO_0 + "& " + Resources.SCREEN_HZ_CHANGE_TO_48_MIN + "& " + Resources.SCREEN_HZ_CHANGE_TO_48_PEAK);
                        break;

                    case 60:
                        Superuser.executeCommandSU(Resources.SCREEN_DEFAULT_MODES_SET_TO_0 + "& " + Resources.SCREEN_HZ_CHANGE_TO_60_MIN + "& " + Resources.SCREEN_HZ_CHANGE_TO_60_PEAK);
                        break;

                    case 96:
                        Superuser.executeCommandSU(Resources.SCREEN_DEFAULT_MODES_SET_TO_2 + " & " + Resources.SCREEN_HZ_CHANGE_TO_96_MIN + "& " + Resources.SCREEN_HZ_CHANGE_TO_96_PEAK);
                        break;

                    case 120:
                        Superuser.executeCommandSU(Resources.SCREEN_DEFAULT_MODES_SET_TO_2 + " & " + Resources.SCREEN_HZ_CHANGE_TO_120_MIN + "& " + Resources.SCREEN_HZ_CHANGE_TO_120_PEAK);
                        break;

                }
            }
        }

        public static class Resolution {
            public static int getVerticalPixel(Activity activity) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                return displayMetrics.heightPixels;
            }

            public static void setResolution(String val) {
                switch (val) {
                    case "HD":
                        Superuser.executeCommandSU(Resources.SCREEN_RESOLUTION_CHANGE_TO_HD);
                        break;

                    case "FHD":
                        Superuser.executeCommandSU(Resources.SCREEN_RESOLUTION_CHANGE_TO_FHD);
                        break;

                    case "WQHD":
                        Superuser.executeCommandSU(Resources.SCREEN_RESOLUTION_CHANGE_TO_WQHD);
                        break;
                }
            }
        }
    }

    public static class Power {
        public static boolean getPowerMode() {
            return Superuser.executeCommandSU(Resources.POWER_SAVE_MODE_STATUS).contains("1");
        }
    }

    public static class Other {
        public static boolean getADBStatus() {
            return Superuser.executeCommandSU(Resources.ADB_DEBUGGING_STATUS).contains("1");
        }

        public static void setADBStatus(boolean status) {
            if (status) {
                Superuser.executeCommandSU(Resources.ADB_DEBUGGING_ENABLE);
            } else {
                Superuser.executeCommandSU(Resources.ADB_DEBUGGING_DISABLE);
            }
        }

        public static String reboot(String mode) {
            if (mode.equals("1")) {
                return Superuser.executeCommandSU(Resources.REBOOT);
            } else if (mode.equals("2")) {
                return Superuser.executeCommandSU(Resources.REBOOT_RECOVERY);
            } else {
                return Superuser.executeCommandSU(Resources.REBOOT_DOWNLOAD);
            }
        }
    }
}


