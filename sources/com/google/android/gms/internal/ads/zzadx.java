package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
public final class zzadx extends NativeAd.Image {
    private final int height;
    private final Uri uri;
    private final int width;
    private final double zzdcr;
    private final zzadw zzdcw;
    private final Drawable zzdcx;

    public zzadx(zzadw zzadw) {
        Drawable drawable;
        int i;
        this.zzdcw = zzadw;
        Uri uri2 = null;
        try {
            IObjectWrapper zzsd = zzadw.zzsd();
            if (zzsd != null) {
                drawable = (Drawable) ObjectWrapper.unwrap(zzsd);
                this.zzdcx = drawable;
                uri2 = this.zzdcw.getUri();
                this.uri = uri2;
                double d = 1.0d;
                d = this.zzdcw.getScale();
                this.zzdcr = d;
                int i2 = -1;
                i = this.zzdcw.getWidth();
                this.width = i;
                i2 = this.zzdcw.getHeight();
                this.height = i2;
            }
        } catch (RemoteException e) {
            zzbbd.zzc("", e);
        }
        drawable = null;
        this.zzdcx = drawable;
        try {
            uri2 = this.zzdcw.getUri();
        } catch (RemoteException e2) {
            zzbbd.zzc("", e2);
        }
        this.uri = uri2;
        double d = 1.0d;
        try {
            d = this.zzdcw.getScale();
        } catch (RemoteException e3) {
            zzbbd.zzc("", e3);
        }
        this.zzdcr = d;
        int i2 = -1;
        try {
            i = this.zzdcw.getWidth();
        } catch (RemoteException e4) {
            zzbbd.zzc("", e4);
            i = -1;
        }
        this.width = i;
        try {
            i2 = this.zzdcw.getHeight();
        } catch (RemoteException e5) {
            zzbbd.zzc("", e5);
        }
        this.height = i2;
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.Image
    public final Drawable getDrawable() {
        return this.zzdcx;
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.Image
    public final int getHeight() {
        return this.height;
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.Image
    public final double getScale() {
        return this.zzdcr;
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.Image
    public final Uri getUri() {
        return this.uri;
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.Image
    public final int getWidth() {
        return this.width;
    }
}
