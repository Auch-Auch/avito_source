package com.my.target.nativeads.banners;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.my.target.cj;
import com.my.target.common.models.ImageData;
public class NativeAppwallBanner {
    @Nullable
    public final ImageData A;
    @Nullable
    public final ImageData B;
    public boolean C;
    @NonNull
    public final String a;
    @NonNull
    public final String b;
    @NonNull
    public final String c;
    @Nullable
    public final String d;
    @Nullable
    public final String e;
    @Nullable
    public final String f;
    @Nullable
    public final String g;
    public final int h;
    public final int i;
    public final int j;
    public final int k;
    public final int l;
    public final float m;
    public final boolean n;
    public final boolean o;
    public final boolean p;
    public final boolean q;
    public final boolean r;
    public final boolean s;
    public final boolean t;
    @Nullable
    public final ImageData u;
    @Nullable
    public final ImageData v;
    @Nullable
    public final ImageData w;
    @Nullable
    public final ImageData x;
    @Nullable
    public final ImageData y;
    @Nullable
    public final ImageData z;

    public NativeAppwallBanner(@NonNull cj cjVar) {
        this.a = cjVar.getId();
        this.b = cjVar.getDescription();
        this.c = cjVar.getTitle();
        this.d = cjVar.getBubbleId();
        this.e = cjVar.getLabelType();
        this.f = cjVar.getStatus();
        this.g = cjVar.getPaidType();
        this.h = cjVar.getMrgsId();
        this.i = cjVar.getCoins();
        this.j = cjVar.getCoinsIconBgColor();
        this.k = cjVar.getCoinsIconTextColor();
        this.l = cjVar.getVotes();
        this.m = cjVar.getRating();
        this.C = cjVar.isHasNotification();
        this.n = cjVar.isMain();
        this.o = cjVar.isRequireCategoryHighlight();
        this.p = cjVar.isItemHighlight();
        this.q = cjVar.isBanner();
        this.r = cjVar.isRequireWifi();
        this.s = cjVar.isSubItem();
        this.t = cjVar.isAppInstalled();
        this.u = cjVar.getIcon();
        this.v = cjVar.getCoinsIcon();
        this.w = cjVar.getLabelIcon();
        this.x = cjVar.getGotoAppIcon();
        this.y = cjVar.getStatusIcon();
        this.z = cjVar.getBubbleIcon();
        this.A = cjVar.getItemHighlightIcon();
        this.B = cjVar.getCrossNotifIcon();
    }

    @NonNull
    public static NativeAppwallBanner newBanner(@NonNull cj cjVar) {
        return new NativeAppwallBanner(cjVar);
    }

    @Nullable
    public ImageData getBubbleIcon() {
        return this.z;
    }

    @Nullable
    public String getBubbleId() {
        return this.d;
    }

    public int getCoins() {
        return this.i;
    }

    @Nullable
    public ImageData getCoinsIcon() {
        return this.v;
    }

    public int getCoinsIconBgColor() {
        return this.j;
    }

    public int getCoinsIconTextColor() {
        return this.k;
    }

    @Nullable
    public ImageData getCrossNotifIcon() {
        return this.B;
    }

    @NonNull
    public String getDescription() {
        return this.b;
    }

    @Nullable
    public ImageData getGotoAppIcon() {
        return this.x;
    }

    @Nullable
    public ImageData getIcon() {
        return this.u;
    }

    @NonNull
    public String getId() {
        return this.a;
    }

    @Nullable
    public ImageData getItemHighlightIcon() {
        return this.A;
    }

    @Nullable
    public ImageData getLabelIcon() {
        return this.w;
    }

    @Nullable
    public String getLabelType() {
        return this.e;
    }

    public int getMrgsId() {
        return this.h;
    }

    @Nullable
    public String getPaidType() {
        return this.g;
    }

    public float getRating() {
        return this.m;
    }

    @Nullable
    public String getStatus() {
        return this.f;
    }

    @Nullable
    public ImageData getStatusIcon() {
        return this.y;
    }

    @NonNull
    public String getTitle() {
        return this.c;
    }

    public int getVotes() {
        return this.l;
    }

    public boolean isAppInstalled() {
        return this.t;
    }

    public boolean isBanner() {
        return this.q;
    }

    public boolean isHasNotification() {
        return this.C;
    }

    public boolean isItemHighlight() {
        return this.p;
    }

    public boolean isMain() {
        return this.n;
    }

    public boolean isRequireCategoryHighlight() {
        return this.o;
    }

    public boolean isRequireWifi() {
        return this.r;
    }

    public boolean isSubItem() {
        return this.s;
    }

    public void setHasNotification(boolean z2) {
        this.C = z2;
    }
}
