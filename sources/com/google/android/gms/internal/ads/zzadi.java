package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
public final class zzadi extends zzadv {
    private final int height;
    private final Uri uri;
    private final int width;
    private final Drawable zzdcq;
    private final double zzdcr;

    public zzadi(Drawable drawable, Uri uri2, double d, int i, int i2) {
        this.zzdcq = drawable;
        this.uri = uri2;
        this.zzdcr = d;
        this.width = i;
        this.height = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzadw
    public final int getHeight() {
        return this.height;
    }

    @Override // com.google.android.gms.internal.ads.zzadw
    public final double getScale() {
        return this.zzdcr;
    }

    @Override // com.google.android.gms.internal.ads.zzadw
    public final Uri getUri() throws RemoteException {
        return this.uri;
    }

    @Override // com.google.android.gms.internal.ads.zzadw
    public final int getWidth() {
        return this.width;
    }

    @Override // com.google.android.gms.internal.ads.zzadw
    public final IObjectWrapper zzsd() throws RemoteException {
        return ObjectWrapper.wrap(this.zzdcq);
    }
}
