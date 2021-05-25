package com.google.android.gms.ads.mediation;

import com.google.android.gms.ads.formats.NativeAd;
import java.util.List;
@Deprecated
public class NativeAppInstallAdMapper extends NativeAdMapper {
    private String zzdrq;
    private String zzeqj;
    private List<NativeAd.Image> zzeqk;
    private String zzeqm;
    private NativeAd.Image zzeqo;
    private double zzeqp;
    private String zzeqq;
    private String zzeqr;

    public final String getBody() {
        return this.zzdrq;
    }

    public final String getCallToAction() {
        return this.zzeqm;
    }

    public final String getHeadline() {
        return this.zzeqj;
    }

    public final NativeAd.Image getIcon() {
        return this.zzeqo;
    }

    public final List<NativeAd.Image> getImages() {
        return this.zzeqk;
    }

    public final String getPrice() {
        return this.zzeqr;
    }

    public final double getStarRating() {
        return this.zzeqp;
    }

    public final String getStore() {
        return this.zzeqq;
    }

    public final void setBody(String str) {
        this.zzdrq = str;
    }

    public final void setCallToAction(String str) {
        this.zzeqm = str;
    }

    public final void setHeadline(String str) {
        this.zzeqj = str;
    }

    public final void setIcon(NativeAd.Image image) {
        this.zzeqo = image;
    }

    public final void setImages(List<NativeAd.Image> list) {
        this.zzeqk = list;
    }

    public final void setPrice(String str) {
        this.zzeqr = str;
    }

    public final void setStarRating(double d) {
        this.zzeqp = d;
    }

    public final void setStore(String str) {
        this.zzeqq = str;
    }
}
