package com.my.target.nativeads.banners;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.my.target.ch;
import com.my.target.common.models.ImageData;
public class NativePromoCard {
    @Nullable
    public final String a;
    @Nullable
    public final String b;
    @Nullable
    public final String c;
    @Nullable
    public final ImageData d;

    public NativePromoCard(@NonNull ch chVar) {
        if (!TextUtils.isEmpty(chVar.getTitle())) {
            this.a = chVar.getTitle();
        } else {
            this.a = null;
        }
        if (!TextUtils.isEmpty(chVar.getDescription())) {
            this.b = chVar.getDescription();
        } else {
            this.b = null;
        }
        if (!TextUtils.isEmpty(chVar.getCtaText())) {
            this.c = chVar.getCtaText();
        } else {
            this.c = null;
        }
        this.d = chVar.getImage();
    }

    @Nullable
    public String getCtaText() {
        return this.c;
    }

    @Nullable
    public String getDescription() {
        return this.b;
    }

    @Nullable
    public ImageData getImage() {
        return this.d;
    }

    @Nullable
    public String getTitle() {
        return this.a;
    }
}
