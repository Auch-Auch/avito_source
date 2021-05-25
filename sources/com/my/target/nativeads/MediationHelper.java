package com.my.target.nativeads;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.my.target.Cif;
import com.my.target.aq;
import com.my.target.nativeads.views.MediaAdView;
import java.util.List;
import java.util.Objects;
public final class MediationHelper {
    public static void registerView(@NonNull NativeAd nativeAd, @NonNull View view, @Nullable List<View> list, @Nullable MediaAdView mediaAdView) {
        Objects.requireNonNull(nativeAd);
        Cif.a(view, nativeAd);
        aq aqVar = nativeAd.c;
        if (aqVar != null) {
            aqVar.a(view, list, nativeAd.f, mediaAdView);
        }
    }
}
