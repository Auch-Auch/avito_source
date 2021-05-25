package com.my.target;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.my.target.common.CustomParams;
public final class a {
    @NonNull
    public final CustomParams a = new CustomParams();
    public long b = 86400000;
    public boolean c = true;
    public boolean d = true;
    public int e = 360;
    public int f;
    @Nullable
    public String g;
    public int h = 0;
    public int i;
    @NonNull
    public volatile String j;

    public a(int i2, @NonNull String str) {
        this.i = i2;
        this.j = str;
    }

    @NonNull
    public static a newConfig(int i2, @NonNull String str) {
        return new a(i2, str);
    }

    public int getBannersCount() {
        return this.f;
    }

    @Nullable
    public String getBidId() {
        return this.g;
    }

    public long getCachePeriod() {
        return this.b;
    }

    public int getCachePolicy() {
        return this.h;
    }

    @NonNull
    public CustomParams getCustomParams() {
        return this.a;
    }

    @NonNull
    public String getFormat() {
        return this.j;
    }

    public int getSlotId() {
        return this.i;
    }

    public int getVideoQuality() {
        return this.e;
    }

    public boolean isMediationEnabled() {
        return this.c;
    }

    public boolean isRefreshAd() {
        return this.d;
    }

    public void setBannersCount(int i2) {
        this.f = i2;
    }

    public void setBidId(@Nullable String str) {
        this.g = str;
    }

    public void setCachePeriod(long j2) {
        if (j2 < 0) {
            this.b = 0;
        } else {
            this.b = j2;
        }
    }

    public void setCachePolicy(int i2) {
        this.h = i2;
    }

    public void setFormat(@NonNull String str) {
        this.j = str;
    }

    public void setMediationEnabled(boolean z) {
        this.c = z;
    }

    public void setRefreshAd(boolean z) {
        this.d = z;
    }

    public void setSlotId(int i2) {
        this.i = i2;
    }

    public void setVideoQuality(int i2) {
        this.e = i2;
    }
}
