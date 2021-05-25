package com.vk.sdk.util;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import androidx.annotation.Nullable;
import com.adjust.sdk.Constants;
import com.vk.sdk.api.VKParameters;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
public class VKUtil {
    @Nullable
    public static Map<String, String> explodeQueryString(@Nullable String str) {
        if (str == null) {
            return null;
        }
        String[] split = str.split("&");
        HashMap hashMap = new HashMap(split.length);
        for (String str2 : split) {
            String[] split2 = str2.split("=");
            hashMap.put(split2[0], split2[1]);
        }
        return hashMap;
    }

    public static String fileToString(String str) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(str));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                sb.append(readLine);
            } else {
                bufferedReader.close();
                return sb.toString();
            }
        }
    }

    public static String getApplicationName(Context context) {
        try {
            PackageManager packageManager = context.getApplicationContext().getPackageManager();
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 0);
            return (String) (applicationInfo != null ? packageManager.getApplicationLabel(applicationInfo) : "(unknown)");
        } catch (Exception unused) {
            return null;
        }
    }

    public static String[] getCertificateFingerprint(Context context, String str) {
        if (context != null) {
            try {
                if (context.getPackageManager() != null) {
                    Signature[] signatureArr = context.getPackageManager().getPackageInfo(str, 64).signatures;
                    String[] strArr = new String[signatureArr.length];
                    int length = signatureArr.length;
                    int i = 0;
                    int i2 = 0;
                    while (i < length) {
                        Signature signature = signatureArr[i];
                        MessageDigest instance = MessageDigest.getInstance("SHA");
                        instance.update(signature.toByteArray());
                        int i3 = i2 + 1;
                        byte[] digest = instance.digest();
                        BigInteger bigInteger = new BigInteger(1, digest);
                        strArr[i2] = String.format("%0" + (digest.length << 1) + "X", bigInteger);
                        i++;
                        i2 = i3;
                    }
                    return strArr;
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static String getHost(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        int indexOf = str.indexOf("//");
        int i = indexOf == -1 ? 0 : indexOf + 2;
        int indexOf2 = str.indexOf(47, i);
        if (indexOf2 < 0) {
            indexOf2 = str.length();
        }
        int indexOf3 = str.indexOf(58, i);
        if (indexOf3 > 0 && indexOf3 < indexOf2) {
            indexOf2 = indexOf3;
        }
        return str.substring(i, indexOf2);
    }

    public static boolean isAppInstalled(Context context, String str) {
        try {
            context.getPackageManager().getPackageInfo(str, 1);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static boolean isIntentAvailable(Context context, String str) {
        return context.getPackageManager().queryIntentActivities(new Intent(str), 65536).size() > 0;
    }

    public static Map<String, Object> mapFrom(Object... objArr) {
        int length = objArr.length % 2;
        LinkedHashMap linkedHashMap = new LinkedHashMap(objArr.length / 2);
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (i2 >= objArr.length) {
                return linkedHashMap;
            }
            if (!(objArr[i] == null || objArr[i2] == null || !(objArr[i] instanceof String))) {
                linkedHashMap.put((String) objArr[i], objArr[i2]);
            }
            i += 2;
        }
    }

    public static String md5(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance(Constants.MD5);
            instance.update(str.getBytes());
            byte[] digest = instance.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                String hexString = Integer.toHexString(b & 255);
                while (hexString.length() < 2) {
                    hexString = "0" + hexString;
                }
                sb.append(hexString);
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException unused) {
            return "";
        }
    }

    public static VKParameters paramsFrom(Object... objArr) {
        return new VKParameters(mapFrom(objArr));
    }

    public static void stringToFile(String str, String str2) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(str));
            bufferedWriter.write(str2);
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (Exception unused) {
        }
    }
}
