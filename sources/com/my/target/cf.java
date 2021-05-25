package com.my.target;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.my.target.bt;
import com.my.target.common.models.AudioData;
import com.my.target.common.models.ImageData;
import com.my.target.common.models.ShareButtonData;
import com.my.target.common.models.VideoData;
import java.util.ArrayList;
public final class cf<T extends bt> extends by {
    @NonNull
    public final ArrayList<bz> e = new ArrayList<>();
    @NonNull
    public final ArrayList<ShareButtonData> f = new ArrayList<>();
    @Nullable
    public T g;
    @Nullable
    public String h;
    @Nullable
    public ImageData i;
    @NonNull
    public String j = "Close";
    @NonNull
    public String k = "Replay";
    @NonNull
    public String l = "Ad can be skipped after %ds";
    public boolean m = false;
    public boolean n = true;
    public boolean o = true;
    public boolean p = true;
    public boolean q = true;
    public boolean r = true;
    public boolean s = false;
    public boolean t = false;
    public boolean u = false;
    public boolean v = true;
    public float w = 0.0f;
    public float x;
    public float y;

    @NonNull
    public static cf<AudioData> newAudioBanner() {
        return newBanner();
    }

    @NonNull
    public static <T extends bt> cf<T> newBanner() {
        return new cf<>();
    }

    @NonNull
    public static cf<VideoData> newVideoBanner() {
        return newBanner();
    }

    public void addCompanion(@NonNull bz bzVar) {
        this.e.add(bzVar);
    }

    public void addShareButtonData(@NonNull ShareButtonData shareButtonData) {
        this.f.add(shareButtonData);
    }

    @Nullable
    public String getAdText() {
        return this.h;
    }

    public float getAllowCloseDelay() {
        return this.w;
    }

    @NonNull
    public String getCloseActionText() {
        return this.j;
    }

    @NonNull
    public String getCloseDelayActionText() {
        return this.l;
    }

    @NonNull
    public ArrayList<bz> getCompanionBanners() {
        return new ArrayList<>(this.e);
    }

    @Override // com.my.target.by
    public int getHeight() {
        T t2 = this.g;
        if (t2 != null) {
            return t2.getHeight();
        }
        return 0;
    }

    @Nullable
    public T getMediaData() {
        return this.g;
    }

    public float getPoint() {
        return this.x;
    }

    public float getPointP() {
        return this.y;
    }

    @Nullable
    public ImageData getPreview() {
        return this.i;
    }

    @NonNull
    public String getReplayActionText() {
        return this.k;
    }

    @NonNull
    public ArrayList<ShareButtonData> getShareButtonDatas() {
        return new ArrayList<>(this.f);
    }

    @Override // com.my.target.by
    public int getWidth() {
        T t2 = this.g;
        if (t2 != null) {
            return t2.getWidth();
        }
        return 0;
    }

    public boolean isAllowClose() {
        return this.r;
    }

    public boolean isAllowPause() {
        return this.v;
    }

    public boolean isAllowReplay() {
        return this.p;
    }

    public boolean isAllowSeek() {
        return this.s;
    }

    public boolean isAllowSkip() {
        return this.t;
    }

    public boolean isAllowTrackChange() {
        return this.u;
    }

    public boolean isAutoMute() {
        return this.m;
    }

    public boolean isAutoPlay() {
        return this.n;
    }

    public boolean isHasCtaButton() {
        return this.o;
    }

    public boolean isShowPlayerControls() {
        return this.q;
    }

    public void setAdText(@Nullable String str) {
        this.h = str;
    }

    public void setAllowClose(boolean z) {
        this.r = z;
    }

    public void setAllowCloseDelay(float f2) {
        this.w = f2;
    }

    public void setAllowPause(boolean z) {
        this.v = z;
    }

    public void setAllowReplay(boolean z) {
        this.p = z;
    }

    public void setAllowSeek(boolean z) {
        this.s = z;
    }

    public void setAllowSkip(boolean z) {
        this.t = z;
    }

    public void setAllowTrackChange(boolean z) {
        this.u = z;
    }

    public void setAutoMute(boolean z) {
        this.m = z;
    }

    public void setAutoPlay(boolean z) {
        this.n = z;
    }

    public void setCloseActionText(@NonNull String str) {
        this.j = str;
    }

    public void setCloseDelayActionText(@NonNull String str) {
        this.l = str;
    }

    public void setHasCtaButton(boolean z) {
        this.o = z;
    }

    public void setMediaData(@Nullable T t2) {
        this.g = t2;
    }

    public void setPoint(float f2) {
        this.x = f2;
    }

    public void setPointP(float f2) {
        this.y = f2;
    }

    public void setPreview(@Nullable ImageData imageData) {
        this.i = imageData;
    }

    public void setReplayActionText(@NonNull String str) {
        this.k = str;
    }

    public void setShowPlayerControls(boolean z) {
        this.q = z;
    }
}
