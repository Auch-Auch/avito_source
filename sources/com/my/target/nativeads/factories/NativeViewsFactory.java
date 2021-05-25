package com.my.target.nativeads.factories;

import android.content.Context;
import androidx.annotation.NonNull;
import com.my.target.nativeads.views.IconAdView;
import com.my.target.nativeads.views.MediaAdView;
import com.my.target.nativeads.views.NativeAdCardView;
import com.my.target.nativeads.views.NativeAdChoicesView;
import com.my.target.nativeads.views.NativeAdView;
import com.my.target.nativeads.views.NativeBannerAdView;
import com.my.target.nativeads.views.PromoCardRecyclerView;
public class NativeViewsFactory {
    @NonNull
    public static IconAdView getIconAdView(@NonNull Context context) {
        return new IconAdView(context);
    }

    @NonNull
    public static MediaAdView getMediaAdView(@NonNull Context context) {
        return new MediaAdView(context);
    }

    @NonNull
    public static NativeAdCardView getNativeAdCardView(@NonNull Context context) {
        return new NativeAdCardView(context);
    }

    @NonNull
    public static NativeAdChoicesView getNativeAdChoicesView(@NonNull Context context) {
        return new NativeAdChoicesView(context);
    }

    @NonNull
    public static NativeAdView getNativeAdView(@NonNull Context context) {
        return new NativeAdView(context, null, 0, false);
    }

    @NonNull
    public static NativeAdView getNativeAdViewWithExtendedCards(@NonNull Context context) {
        return new NativeAdView(context, null, 0, true);
    }

    @NonNull
    public static NativeBannerAdView getNativeBannerAdView(@NonNull Context context) {
        return new NativeBannerAdView(context);
    }

    @NonNull
    public static PromoCardRecyclerView getPromoCardRecyclerView(@NonNull Context context) {
        return new PromoCardRecyclerView(context);
    }
}
