package com.my.target;

import android.view.View;
import androidx.annotation.NonNull;
import com.my.target.nativeads.INativeAd;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;
/* renamed from: com.my.target.if  reason: invalid class name */
public class Cif {
    @NonNull
    public static final WeakHashMap<View, WeakReference<INativeAd>> a = new WeakHashMap<>();

    public static void a(@NonNull View view, @NonNull INativeAd iNativeAd) {
        INativeAd iNativeAd2;
        a(iNativeAd);
        WeakHashMap<View, WeakReference<INativeAd>> weakHashMap = a;
        WeakReference<INativeAd> weakReference = weakHashMap.get(view);
        if (!(weakReference == null || (iNativeAd2 = weakReference.get()) == null)) {
            iNativeAd2.unregisterView();
        }
        weakHashMap.put(view, new WeakReference<>(iNativeAd));
    }

    public static void a(@NonNull INativeAd iNativeAd) {
        INativeAd iNativeAd2;
        for (Map.Entry<View, WeakReference<INativeAd>> entry : a.entrySet()) {
            View key = entry.getKey();
            WeakReference<INativeAd> value = entry.getValue();
            if (value != null && ((iNativeAd2 = value.get()) == null || iNativeAd2 == iNativeAd)) {
                a.remove(key);
                return;
            }
        }
    }
}
