package ru.ok.android.sdk.util;

import android.content.Context;
import android.provider.Settings;
import java.lang.reflect.InvocationTargetException;
public class OkDevice {
    public static String getAdvertisingId(Context context) {
        String str = null;
        try {
            Object invoke = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient").getMethod("getAdvertisingIdInfo", Context.class).invoke(null, context);
            if (invoke != null) {
                str = (String) invoke.getClass().getMethod("getId", new Class[0]).invoke(invoke, new Object[0]);
            }
        } catch (ClassNotFoundException unused) {
            throw new IllegalStateException("A dependency on com.google.android.gms:play-services-ads is required in order to use OkDevice.getAdvertisingId");
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
        }
        return str == null ? Settings.Secure.getString(context.getContentResolver(), "android_id") : str;
    }
}
