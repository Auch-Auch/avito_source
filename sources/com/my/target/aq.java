package com.my.target;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.my.target.nativeads.NativeAd;
import com.my.target.nativeads.banners.NativePromoBanner;
import com.my.target.nativeads.views.MediaAdView;
import java.util.List;
public interface aq {
    void a(@NonNull View view, @Nullable List<View> list, int i, @Nullable MediaAdView mediaAdView);

    @Nullable
    String ad();

    float ae();

    @Nullable
    NativePromoBanner af();

    void setMediaListener(@Nullable NativeAd.NativeAdMediaListener nativeAdMediaListener);

    void unregisterView();
}
