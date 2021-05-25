package com.my.target;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
public class bz extends by {
    public int e;
    public int f;
    public int g;
    public int h;
    @Nullable
    public String i;
    @Nullable
    public String j;
    @Nullable
    public String k;
    @Nullable
    public String l;
    @Nullable
    public String m;
    @Nullable
    public String n;

    public bz() {
        this.type = "companion";
    }

    @NonNull
    public static bz newBanner() {
        return new bz();
    }

    @Nullable
    public String getAdSlotID() {
        return this.m;
    }

    @Nullable
    public String getApiFramework() {
        return this.l;
    }

    public int getAssetHeight() {
        return this.f;
    }

    public int getAssetWidth() {
        return this.e;
    }

    public int getExpandedHeight() {
        return this.h;
    }

    public int getExpandedWidth() {
        return this.g;
    }

    @Nullable
    public String getHtmlResource() {
        return this.k;
    }

    @Nullable
    public String getIframeResource() {
        return this.j;
    }

    @Nullable
    public String getRequired() {
        return this.n;
    }

    @Nullable
    public String getStaticResource() {
        return this.i;
    }

    public void setAdSlotID(@Nullable String str) {
        this.m = str;
    }

    public void setApiFramework(@Nullable String str) {
        this.l = str;
    }

    public void setAssetHeight(int i2) {
        this.f = i2;
    }

    public void setAssetWidth(int i2) {
        this.e = i2;
    }

    public void setExpandedHeight(int i2) {
        this.h = i2;
    }

    public void setExpandedWidth(int i2) {
        this.g = i2;
    }

    public void setHtmlResource(@Nullable String str) {
        this.k = str;
    }

    public void setIframeResource(@Nullable String str) {
        this.j = str;
    }

    public void setRequired(@Nullable String str) {
        this.n = str;
    }

    public void setStaticResource(@Nullable String str) {
        this.i = str;
    }
}
