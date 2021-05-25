package com.yandex.mobile.ads.impl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
public final class ea {
    private static final Comparator<ScanResult> a = new Comparator<ScanResult>() { // from class: com.yandex.mobile.ads.impl.ea.1
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public final /* bridge */ /* synthetic */ int compare(ScanResult scanResult, ScanResult scanResult2) {
            return scanResult.level - scanResult2.level;
        }
    };

    @SuppressLint({"MissingPermission"})
    public static Integer a(Context context) {
        try {
            String substring = ((TelephonyManager) context.getSystemService("phone")).getNetworkOperator().substring(0, 3);
            if (!TextUtils.isEmpty(substring)) {
                return Integer.valueOf(Integer.parseInt(substring));
            }
        } catch (Exception unused) {
        }
        return null;
    }

    @SuppressLint({"MissingPermission"})
    public static Integer b(Context context) {
        try {
            String substring = ((TelephonyManager) context.getSystemService("phone")).getNetworkOperator().substring(3);
            if (!TextUtils.isEmpty(substring)) {
                return Integer.valueOf(Integer.parseInt(substring));
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static String c(Context context) {
        try {
            String networkOperatorName = ((TelephonyManager) context.getSystemService("phone")).getNetworkOperatorName();
            if (!TextUtils.isEmpty(networkOperatorName)) {
                return networkOperatorName;
            }
            return null;
        } catch (Exception unused) {
        }
    }

    @Nullable
    public static String d(@NonNull Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo.getType() != 0) {
                return activeNetworkInfo.getTypeName();
            }
            return activeNetworkInfo.getSubtypeName();
        } catch (Exception unused) {
            return null;
        }
    }

    @SuppressLint({"MissingPermission"})
    public static Integer e(Context context) {
        try {
            int cid = ((GsmCellLocation) ((TelephonyManager) context.getSystemService("phone")).getCellLocation()).getCid();
            if (-1 != cid) {
                return Integer.valueOf(cid & 65535);
            }
        } catch (Exception unused) {
        }
        return null;
    }

    @SuppressLint({"MissingPermission"})
    public static Integer f(Context context) {
        try {
            int lac = ((GsmCellLocation) ((TelephonyManager) context.getSystemService("phone")).getCellLocation()).getLac();
            if (-1 != lac) {
                return Integer.valueOf(lac & 65535);
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static String g(Context context) {
        try {
            WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
            if (!wifiManager.isWifiEnabled()) {
                return null;
            }
            List<ScanResult> scanResults = wifiManager.getScanResults();
            ScanResult[] scanResultArr = (ScanResult[]) id.a(scanResults.toArray(new ScanResult[scanResults.size()]));
            Arrays.sort(scanResultArr, Collections.reverseOrder(a));
            if (scanResultArr.length > 0) {
                StringBuilder sb = new StringBuilder();
                int min = Math.min(3, scanResultArr.length);
                int i = 0;
                while (i < min) {
                    sb.append(scanResultArr[i].BSSID);
                    sb.append(",");
                    sb.append(scanResultArr[i].level);
                    i++;
                    sb.append(i < min ? ";" : "");
                }
                return sb.toString();
            }
            return null;
        } catch (Exception unused) {
        }
    }

    public static Integer h(Context context) {
        try {
            Intent registerReceiver = context.getApplicationContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (registerReceiver == null) {
                return null;
            }
            int intExtra = registerReceiver.getIntExtra(FirebaseAnalytics.Param.LEVEL, -1);
            int intExtra2 = registerReceiver.getIntExtra("scale", -1);
            if (intExtra < 0 || intExtra2 <= 0) {
                return null;
            }
            return Integer.valueOf(Math.round((((float) intExtra) / ((float) intExtra2)) * 100.0f));
        } catch (Exception unused) {
            return null;
        }
    }

    public static int i(@NonNull Context context) {
        Point j = j(context);
        return Math.min(j.x, j.y);
    }

    public static Point j(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getRealMetrics(displayMetrics);
        return new Point(displayMetrics.widthPixels, displayMetrics.heightPixels);
    }
}
