package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import com.google.android.gms.ads.MediaContent;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
public final class zzze implements MediaContent {
    private final VideoController zzcjj = new VideoController();
    private final zzadr zzcki;

    public zzze(zzadr zzadr) {
        this.zzcki = zzadr;
    }

    @Override // com.google.android.gms.ads.MediaContent
    public final float getAspectRatio() {
        try {
            return this.zzcki.getAspectRatio();
        } catch (RemoteException e) {
            zzbbd.zzc("", e);
            return 0.0f;
        }
    }

    @Override // com.google.android.gms.ads.MediaContent
    public final float getCurrentTime() {
        try {
            return this.zzcki.getCurrentTime();
        } catch (RemoteException e) {
            zzbbd.zzc("", e);
            return 0.0f;
        }
    }

    @Override // com.google.android.gms.ads.MediaContent
    public final float getDuration() {
        try {
            return this.zzcki.getDuration();
        } catch (RemoteException e) {
            zzbbd.zzc("", e);
            return 0.0f;
        }
    }

    @Override // com.google.android.gms.ads.MediaContent
    public final Drawable getMainImage() {
        try {
            IObjectWrapper zzsf = this.zzcki.zzsf();
            if (zzsf != null) {
                return (Drawable) ObjectWrapper.unwrap(zzsf);
            }
            return null;
        } catch (RemoteException e) {
            zzbbd.zzc("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.MediaContent
    public final VideoController getVideoController() {
        try {
            if (this.zzcki.getVideoController() != null) {
                this.zzcjj.zza(this.zzcki.getVideoController());
            }
        } catch (RemoteException e) {
            zzbbd.zzc("Exception occurred while getting video controller", e);
        }
        return this.zzcjj;
    }

    @Override // com.google.android.gms.ads.MediaContent
    public final boolean hasVideoContent() {
        try {
            return this.zzcki.hasVideoContent();
        } catch (RemoteException e) {
            zzbbd.zzc("", e);
            return false;
        }
    }

    @Override // com.google.android.gms.ads.MediaContent
    public final void setMainImage(Drawable drawable) {
        try {
            this.zzcki.zzo(ObjectWrapper.wrap(drawable));
        } catch (RemoteException e) {
            zzbbd.zzc("", e);
        }
    }

    public final zzadr zzqu() {
        return this.zzcki;
    }
}
