package com.my.target;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.my.target.common.models.ImageData;
public class cj extends by {
    @Nullable
    public String e;
    @Nullable
    public String f;
    @Nullable
    public String g;
    public int h;
    public int i;
    public int j = -552418;
    public int k = -1;
    public boolean l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public boolean q;
    public boolean r;
    public boolean s;
    @Nullable
    public ImageData t;
    @Nullable
    public ImageData u;
    @Nullable
    public ImageData v;
    @Nullable
    public ImageData w;
    @Nullable
    public ImageData x;
    @Nullable
    public ImageData y;
    @Nullable
    public ImageData z;

    @NonNull
    public static cj newBanner() {
        return new cj();
    }

    @Nullable
    public ImageData getBubbleIcon() {
        return this.x;
    }

    @Nullable
    public String getBubbleId() {
        return this.e;
    }

    public int getCoins() {
        return this.i;
    }

    @Nullable
    public ImageData getCoinsIcon() {
        return this.t;
    }

    public int getCoinsIconBgColor() {
        return this.j;
    }

    public int getCoinsIconTextColor() {
        return this.k;
    }

    @Nullable
    public ImageData getCrossNotifIcon() {
        return this.z;
    }

    @Nullable
    public ImageData getGotoAppIcon() {
        return this.v;
    }

    @Nullable
    public ImageData getItemHighlightIcon() {
        return this.y;
    }

    @Nullable
    public ImageData getLabelIcon() {
        return this.u;
    }

    @Nullable
    public String getLabelType() {
        return this.f;
    }

    public int getMrgsId() {
        return this.h;
    }

    @Nullable
    public String getStatus() {
        return this.g;
    }

    @Nullable
    public ImageData getStatusIcon() {
        return this.w;
    }

    public boolean isAppInstalled() {
        return this.s;
    }

    public boolean isBanner() {
        return this.p;
    }

    public boolean isHasNotification() {
        return this.l;
    }

    public boolean isItemHighlight() {
        return this.o;
    }

    public boolean isMain() {
        return this.m;
    }

    public boolean isRequireCategoryHighlight() {
        return this.n;
    }

    public boolean isRequireWifi() {
        return this.q;
    }

    public boolean isSubItem() {
        return this.r;
    }

    public void setAppInstalled(boolean z2) {
        this.s = z2;
    }

    public void setBanner(boolean z2) {
        this.p = z2;
    }

    public void setBubbleIcon(@Nullable ImageData imageData) {
        this.x = imageData;
    }

    public void setBubbleId(@Nullable String str) {
        this.e = str;
    }

    public void setCoins(int i2) {
        this.i = i2;
    }

    public void setCoinsIcon(@Nullable ImageData imageData) {
        this.t = imageData;
    }

    public void setCoinsIconBgColor(int i2) {
        this.j = i2;
    }

    public void setCoinsIconTextColor(int i2) {
        this.k = i2;
    }

    public void setCrossNotifIcon(@Nullable ImageData imageData) {
        this.z = imageData;
    }

    public void setGotoAppIcon(@Nullable ImageData imageData) {
        this.v = imageData;
    }

    public void setHasNotification(boolean z2) {
        this.l = z2;
    }

    public void setItemHighlight(boolean z2) {
        this.o = z2;
    }

    public void setItemHighlightIcon(@Nullable ImageData imageData) {
        this.y = imageData;
    }

    public void setLabelIcon(@Nullable ImageData imageData) {
        this.u = imageData;
    }

    public void setLabelType(@Nullable String str) {
        this.f = str;
    }

    public void setMain(boolean z2) {
        this.m = z2;
    }

    public void setMrgsId(int i2) {
        this.h = i2;
    }

    public void setRequireCategoryHighlight(boolean z2) {
        this.n = z2;
    }

    public void setRequireWifi(boolean z2) {
        this.q = z2;
    }

    public void setStatus(@Nullable String str) {
        this.g = str;
    }

    public void setStatusIcon(@Nullable ImageData imageData) {
        this.w = imageData;
    }

    public void setSubItem(boolean z2) {
        this.r = z2;
    }
}
