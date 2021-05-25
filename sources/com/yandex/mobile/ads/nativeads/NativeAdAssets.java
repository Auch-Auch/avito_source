package com.yandex.mobile.ads.nativeads;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import com.yandex.mobile.ads.impl.ot;
import com.yandex.mobile.ads.impl.ov;
public abstract class NativeAdAssets {
    @Nullable
    private NativeAdMedia a;
    private String b;
    private String c;
    private String d;
    private String e;
    private NativeAdImage f;
    private NativeAdImage g;
    private NativeAdImage h;
    private String i;
    private Float j;
    private String k;
    private String l;
    private String m;
    private String n;

    public final void a(@Nullable String str) {
        this.b = str;
    }

    public final void b(@Nullable String str) {
        this.c = str;
    }

    public final void c(@Nullable String str) {
        this.d = str;
    }

    public final void d(@Nullable String str) {
        this.e = str;
    }

    public final void e(@Nullable String str) {
        this.i = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            NativeAdAssets nativeAdAssets = (NativeAdAssets) obj;
            NativeAdMedia nativeAdMedia = this.a;
            if (nativeAdMedia == null ? nativeAdAssets.a != null : !nativeAdMedia.equals(nativeAdAssets.a)) {
                return false;
            }
            String str = this.b;
            if (str == null ? nativeAdAssets.b != null : !str.equals(nativeAdAssets.b)) {
                return false;
            }
            String str2 = this.c;
            if (str2 == null ? nativeAdAssets.c != null : !str2.equals(nativeAdAssets.c)) {
                return false;
            }
            String str3 = this.d;
            if (str3 == null ? nativeAdAssets.d != null : !str3.equals(nativeAdAssets.d)) {
                return false;
            }
            String str4 = this.e;
            if (str4 == null ? nativeAdAssets.e != null : !str4.equals(nativeAdAssets.e)) {
                return false;
            }
            NativeAdImage nativeAdImage = this.f;
            if (nativeAdImage == null ? nativeAdAssets.f != null : !nativeAdImage.equals(nativeAdAssets.f)) {
                return false;
            }
            NativeAdImage nativeAdImage2 = this.g;
            if (nativeAdImage2 == null ? nativeAdAssets.g != null : !nativeAdImage2.equals(nativeAdAssets.g)) {
                return false;
            }
            NativeAdImage nativeAdImage3 = this.h;
            if (nativeAdImage3 == null ? nativeAdAssets.h != null : !nativeAdImage3.equals(nativeAdAssets.h)) {
                return false;
            }
            String str5 = this.i;
            if (str5 == null ? nativeAdAssets.i != null : !str5.equals(nativeAdAssets.i)) {
                return false;
            }
            Float f2 = this.j;
            if (f2 == null ? nativeAdAssets.j != null : !f2.equals(nativeAdAssets.j)) {
                return false;
            }
            String str6 = this.k;
            if (str6 == null ? nativeAdAssets.k != null : !str6.equals(nativeAdAssets.k)) {
                return false;
            }
            String str7 = this.l;
            if (str7 == null ? nativeAdAssets.l != null : !str7.equals(nativeAdAssets.l)) {
                return false;
            }
            String str8 = this.m;
            if (str8 == null ? nativeAdAssets.m != null : !str8.equals(nativeAdAssets.m)) {
                return false;
            }
            String str9 = this.n;
            String str10 = nativeAdAssets.n;
            if (str9 != null) {
                return str9.equals(str10);
            }
            if (str10 == null) {
                return true;
            }
        }
        return false;
    }

    public final void f(@Nullable String str) {
        if (str != null) {
            try {
                this.j = Float.valueOf(Float.parseFloat(str));
            } catch (NumberFormatException unused) {
                String.format("Could not parse rating value. Rating value is %s", str);
            }
        }
    }

    public final void g(@Nullable String str) {
        this.k = str;
    }

    public String getAge() {
        return this.b;
    }

    public String getBody() {
        return this.c;
    }

    public String getCallToAction() {
        return this.d;
    }

    public String getDomain() {
        return this.e;
    }

    public NativeAdImage getFavicon() {
        return this.f;
    }

    public NativeAdImage getIcon() {
        return this.g;
    }

    public NativeAdImage getImage() {
        return this.h;
    }

    @Nullable
    public NativeAdMedia getMedia() {
        return this.a;
    }

    public String getPrice() {
        return this.i;
    }

    public Float getRating() {
        return this.j;
    }

    public String getReviewCount() {
        return this.k;
    }

    public String getSponsored() {
        return this.l;
    }

    public String getTitle() {
        return this.m;
    }

    public String getWarning() {
        return this.n;
    }

    public final void h(@Nullable String str) {
        this.l = str;
    }

    public int hashCode() {
        NativeAdMedia nativeAdMedia = this.a;
        int i2 = 0;
        int hashCode = (nativeAdMedia != null ? nativeAdMedia.hashCode() : 0) * 31;
        String str = this.b;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.c;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.d;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.e;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
        NativeAdImage nativeAdImage = this.f;
        int hashCode6 = (hashCode5 + (nativeAdImage != null ? nativeAdImage.hashCode() : 0)) * 31;
        NativeAdImage nativeAdImage2 = this.g;
        int hashCode7 = (hashCode6 + (nativeAdImage2 != null ? nativeAdImage2.hashCode() : 0)) * 31;
        NativeAdImage nativeAdImage3 = this.h;
        int hashCode8 = (hashCode7 + (nativeAdImage3 != null ? nativeAdImage3.hashCode() : 0)) * 31;
        String str5 = this.i;
        int hashCode9 = (hashCode8 + (str5 != null ? str5.hashCode() : 0)) * 31;
        Float f2 = this.j;
        int hashCode10 = (hashCode9 + (f2 != null ? f2.hashCode() : 0)) * 31;
        String str6 = this.k;
        int hashCode11 = (hashCode10 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.l;
        int hashCode12 = (hashCode11 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.m;
        int hashCode13 = (hashCode12 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.n;
        if (str9 != null) {
            i2 = str9.hashCode();
        }
        return hashCode13 + i2;
    }

    public final void i(@Nullable String str) {
        this.m = str;
    }

    public final void j(@Nullable String str) {
        this.n = str;
    }

    @VisibleForTesting
    @Nullable
    private static NativeAdImage d(@Nullable ot otVar, @NonNull j jVar) {
        if (otVar == null) {
            return null;
        }
        NativeAdImage nativeAdImage = new NativeAdImage();
        nativeAdImage.a(otVar.b());
        nativeAdImage.b(otVar.a());
        nativeAdImage.a(otVar.d());
        nativeAdImage.a(jVar.a(otVar));
        return nativeAdImage;
    }

    public final void a(@Nullable ot otVar, @NonNull j jVar) {
        this.f = d(otVar, jVar);
    }

    public final void b(@Nullable ot otVar, @NonNull j jVar) {
        this.g = d(otVar, jVar);
    }

    public final void c(@Nullable ot otVar, @NonNull j jVar) {
        this.h = d(otVar, jVar);
    }

    public final void a(@Nullable ov ovVar) {
        this.a = ovVar != null ? new NativeAdMedia(ovVar.b()) : null;
    }
}
