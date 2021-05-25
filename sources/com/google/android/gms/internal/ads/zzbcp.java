package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.TextureView;
@TargetApi(14)
public abstract class zzbcp extends TextureView implements zzbdi {
    public final zzbcz zzefj = new zzbcz();
    public final zzbdj zzefk;

    public zzbcp(Context context) {
        super(context);
        this.zzefk = new zzbdj(context, this);
    }

    public abstract int getCurrentPosition();

    public abstract int getDuration();

    public abstract int getVideoHeight();

    public abstract int getVideoWidth();

    public abstract void pause();

    public abstract void play();

    public abstract void seekTo(int i);

    public abstract void setVideoPath(String str);

    public abstract void stop();

    public abstract void zza(float f, float f2);

    public abstract void zza(zzbcm zzbcm);

    public void zzb(String str, String[] strArr) {
        setVideoPath(str);
    }

    public void zzdl(int i) {
    }

    public void zzdm(int i) {
    }

    public void zzdn(int i) {
    }

    public void zzdo(int i) {
    }

    public void zzdp(int i) {
    }

    public abstract String zzyt();

    @Override // com.google.android.gms.internal.ads.zzbdi
    public abstract void zzyx();
}
