package com.my.target;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.my.target.common.models.ImageData;
import com.my.target.common.models.VideoData;
import java.util.ArrayList;
import java.util.List;
public class ce extends ca {
    @NonNull
    public final bu i = bu.bs();
    @NonNull
    public final List<cb> j = new ArrayList();
    @Nullable
    public cf<VideoData> k;
    @Nullable
    public ca l;
    @Nullable
    public ImageData m;
    @Nullable
    public String n;
    public boolean o = true;
    public boolean p = false;
    public int q;

    @NonNull
    public static ce newBanner() {
        return new ce();
    }

    public void addInterstitialAdCard(@NonNull cb cbVar) {
        this.j.add(cbVar);
    }

    @Nullable
    public ImageData getAdIcon() {
        return this.m;
    }

    @Nullable
    public String getAdIconClickLink() {
        return this.n;
    }

    @Nullable
    public ca getEndCard() {
        return this.l;
    }

    @NonNull
    public List<cb> getInterstitialAdCards() {
        return this.j;
    }

    @NonNull
    public bu getPromoStyleSettings() {
        return this.i;
    }

    public int getStyle() {
        return this.q;
    }

    @Nullable
    public cf<VideoData> getVideoBanner() {
        return this.k;
    }

    public boolean isCloseOnClick() {
        if (this.k != null) {
            return false;
        }
        return this.o;
    }

    public boolean isVideoRequired() {
        return this.p;
    }

    public void setAdIcon(@Nullable ImageData imageData) {
        this.m = imageData;
    }

    public void setAdIconClickLink(@Nullable String str) {
        this.n = str;
    }

    public void setCloseOnClick(boolean z) {
        this.o = z;
    }

    public void setEndCard(@Nullable ca caVar) {
        this.l = caVar;
    }

    public void setStyle(int i2) {
        this.q = i2;
    }

    public void setVideoBanner(@Nullable cf<VideoData> cfVar) {
        this.k = cfVar;
    }

    public void setVideoRequired(boolean z) {
        this.p = z;
    }
}
