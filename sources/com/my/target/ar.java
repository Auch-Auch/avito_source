package com.my.target;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.my.target.nativeads.NativeBannerAd;
import com.my.target.nativeads.banners.NativeBanner;
import java.util.List;
public interface ar {
    @Nullable
    String ad();

    float ae();

    @Nullable
    NativeBanner ag();

    void registerView(@NonNull View view, @Nullable List<View> list, int i);

    void setMediaListener(@Nullable NativeBannerAd.NativeBannerAdMediaListener nativeBannerAdMediaListener);

    void unregisterView();
}
