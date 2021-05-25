package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;
import com.yandex.mobile.ads.nativeads.MediaView;
import com.yandex.mobile.ads.nativeads.j;
public final class ls {
    @NonNull
    private final j a;
    @NonNull
    private final lu b;

    public ls(@NonNull j jVar, @NonNull lu luVar) {
        this.a = jVar;
        this.b = luVar;
    }

    @Nullable
    public static lm<String> a(@Nullable TextView textView) {
        mj mjVar = textView != null ? new mj(textView) : null;
        if (mjVar != null) {
            return new lo(mjVar);
        }
        return null;
    }

    @Nullable
    public final lm<os> b(@Nullable TextView textView) {
        md mdVar = textView != null ? new md(textView, this.a) : null;
        if (mdVar != null) {
            return new lq(mdVar);
        }
        return null;
    }

    @Nullable
    public final lm<ot> a(@Nullable ImageView imageView) {
        me meVar = imageView != null ? new me(imageView, this.a) : null;
        if (meVar != null) {
            return new lq(meVar);
        }
        return null;
    }

    @Nullable
    public final lm<ow> a(@Nullable ImageView imageView, @Nullable MediaView mediaView) {
        me meVar = imageView != null ? new me(imageView, this.a) : null;
        mf a3 = mediaView != null ? this.b.a(mediaView, this.a) : null;
        if (meVar == null && a3 == null) {
            return null;
        }
        return new lr(meVar, a3);
    }
}
