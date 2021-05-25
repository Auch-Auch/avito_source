package com.my.target;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.my.target.common.models.ImageData;
import com.my.target.common.models.VideoData;
import java.util.ArrayList;
import java.util.List;
public class cg extends by {
    @NonNull
    public final List<ch> e = new ArrayList();
    @Nullable
    public cf<VideoData> f;
    @Nullable
    public ci g;
    @NonNull
    public String h = "Try to play";
    @Nullable
    public ImageData i;

    @NonNull
    public static cg newBanner() {
        return new cg();
    }

    public void addNativeAdCard(@NonNull ch chVar) {
        this.e.add(chVar);
    }

    @Nullable
    public ci getContent() {
        return this.g;
    }

    @Nullable
    public ImageData getCtcIcon() {
        return this.i;
    }

    @NonNull
    public String getCtcText() {
        return this.h;
    }

    @NonNull
    public List<ch> getNativeAdCards() {
        return new ArrayList(this.e);
    }

    @Nullable
    public cf<VideoData> getVideoBanner() {
        return this.f;
    }

    public void setContent(@Nullable ci ciVar) {
        this.g = ciVar;
    }

    public void setCtcIcon(@Nullable ImageData imageData) {
        this.i = imageData;
    }

    public void setCtcText(@NonNull String str) {
        this.h = str;
    }

    public void setVideoBanner(@Nullable cf<VideoData> cfVar) {
        this.f = cfVar;
    }
}
