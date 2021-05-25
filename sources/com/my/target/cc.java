package com.my.target;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
public class cc extends ca {
    @Nullable
    public String i;
    public float j;

    @NonNull
    public static cc fromCompanion(@NonNull bz bzVar) {
        cc newBanner = newBanner();
        newBanner.setId(bzVar.getId());
        newBanner.setSource(bzVar.getHtmlResource());
        newBanner.getStatHolder().a(bzVar.getStatHolder(), 0.0f);
        newBanner.trackingLink = bzVar.trackingLink;
        return newBanner;
    }

    @NonNull
    public static cc newBanner() {
        return new cc();
    }

    @Nullable
    public String getSource() {
        return this.i;
    }

    public float getTimeToReward() {
        return this.j;
    }

    public void setSource(@Nullable String str) {
        this.i = str;
    }

    public void setTimeToReward(float f) {
        this.j = f;
    }
}
