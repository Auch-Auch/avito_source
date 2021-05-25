package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.List;
public final class zzdlx {
    private final zzamv zzhcj;

    public zzdlx(zzamv zzamv) {
        this.zzhcj = zzamv;
    }

    public final void destroy() throws zzdlr {
        try {
            this.zzhcj.destroy();
        } catch (Throwable th) {
            throw new zzdlr(th);
        }
    }

    public final zzyg getVideoController() throws zzdlr {
        try {
            return this.zzhcj.getVideoController();
        } catch (Throwable th) {
            throw new zzdlr(th);
        }
    }

    public final View getView() throws zzdlr {
        try {
            return (View) ObjectWrapper.unwrap(this.zzhcj.zzto());
        } catch (Throwable th) {
            throw new zzdlr(th);
        }
    }

    public final boolean isInitialized() throws zzdlr {
        try {
            return this.zzhcj.isInitialized();
        } catch (Throwable th) {
            throw new zzdlr(th);
        }
    }

    public final void onContextChanged(Context context) throws zzdlr {
        try {
            this.zzhcj.zzs(ObjectWrapper.wrap(context));
        } catch (Throwable th) {
            throw new zzdlr(th);
        }
    }

    public final void pause() throws zzdlr {
        try {
            this.zzhcj.pause();
        } catch (Throwable th) {
            throw new zzdlr(th);
        }
    }

    public final void resume() throws zzdlr {
        try {
            this.zzhcj.resume();
        } catch (Throwable th) {
            throw new zzdlr(th);
        }
    }

    public final void setImmersiveMode(boolean z) throws zzdlr {
        try {
            this.zzhcj.setImmersiveMode(z);
        } catch (Throwable th) {
            throw new zzdlr(th);
        }
    }

    public final void showInterstitial() throws zzdlr {
        try {
            this.zzhcj.showInterstitial();
        } catch (Throwable th) {
            throw new zzdlr(th);
        }
    }

    public final void showVideo() throws zzdlr {
        try {
            this.zzhcj.showVideo();
        } catch (Throwable th) {
            throw new zzdlr(th);
        }
    }

    public final void zza(Context context, zzvj zzvj, zzvc zzvc, String str, zzana zzana) throws zzdlr {
        try {
            this.zzhcj.zza(ObjectWrapper.wrap(context), zzvj, zzvc, str, zzana);
        } catch (Throwable th) {
            throw new zzdlr(th);
        }
    }

    public final void zzb(Context context, zzvc zzvc, String str, zzana zzana) throws zzdlr {
        try {
            this.zzhcj.zzb(ObjectWrapper.wrap(context), zzvc, str, zzana);
        } catch (Throwable th) {
            throw new zzdlr(th);
        }
    }

    public final void zzc(Context context, zzvc zzvc, String str, zzana zzana) throws zzdlr {
        try {
            this.zzhcj.zzc(ObjectWrapper.wrap(context), zzvc, str, zzana);
        } catch (Throwable th) {
            throw new zzdlr(th);
        }
    }

    public final void zzch(Context context) throws zzdlr {
        try {
            this.zzhcj.zzt(ObjectWrapper.wrap(context));
        } catch (Throwable th) {
            throw new zzdlr(th);
        }
    }

    public final zzand zztp() throws zzdlr {
        try {
            return this.zzhcj.zztp();
        } catch (Throwable th) {
            throw new zzdlr(th);
        }
    }

    public final zzani zztq() throws zzdlr {
        try {
            return this.zzhcj.zztq();
        } catch (Throwable th) {
            throw new zzdlr(th);
        }
    }

    public final boolean zztt() throws zzdlr {
        try {
            return this.zzhcj.zztt();
        } catch (Throwable th) {
            throw new zzdlr(th);
        }
    }

    public final zzanj zztv() throws zzdlr {
        try {
            return this.zzhcj.zztv();
        } catch (Throwable th) {
            throw new zzdlr(th);
        }
    }

    @Nullable
    public final zzapo zztw() throws zzdlr {
        try {
            return this.zzhcj.zztw();
        } catch (Throwable th) {
            throw new zzdlr(th);
        }
    }

    @Nullable
    public final zzapo zztx() throws zzdlr {
        try {
            return this.zzhcj.zztx();
        } catch (Throwable th) {
            throw new zzdlr(th);
        }
    }

    public final void zza(Context context, zzvc zzvc, String str, zzana zzana) throws zzdlr {
        try {
            this.zzhcj.zza(ObjectWrapper.wrap(context), zzvc, str, zzana);
        } catch (Throwable th) {
            throw new zzdlr(th);
        }
    }

    public final void zza(Context context, zzvj zzvj, zzvc zzvc, String str, String str2, zzana zzana) throws zzdlr {
        try {
            this.zzhcj.zza(ObjectWrapper.wrap(context), zzvj, zzvc, str, str2, zzana);
        } catch (Throwable th) {
            throw new zzdlr(th);
        }
    }

    public final void zza(Context context, zzvc zzvc, String str, String str2, zzana zzana) throws zzdlr {
        try {
            this.zzhcj.zza(ObjectWrapper.wrap(context), zzvc, str, str2, zzana);
        } catch (Throwable th) {
            throw new zzdlr(th);
        }
    }

    public final void zza(Context context, zzvc zzvc, String str, zzaua zzaua, String str2) throws zzdlr {
        try {
            this.zzhcj.zza(ObjectWrapper.wrap(context), zzvc, (String) null, zzaua, str2);
        } catch (Throwable th) {
            throw new zzdlr(th);
        }
    }

    public final void zza(zzvc zzvc, String str) throws zzdlr {
        try {
            this.zzhcj.zza(zzvc, str);
        } catch (Throwable th) {
            throw new zzdlr(th);
        }
    }

    public final void zza(Context context, zzvc zzvc, String str, String str2, zzana zzana, zzadm zzadm, List<String> list) throws zzdlr {
        try {
            this.zzhcj.zza(ObjectWrapper.wrap(context), zzvc, str, str2, zzana, zzadm, list);
        } catch (Throwable th) {
            throw new zzdlr(th);
        }
    }

    public final void zza(Context context, zzaua zzaua, List<String> list) throws zzdlr {
        try {
            this.zzhcj.zza(ObjectWrapper.wrap(context), zzaua, list);
        } catch (Throwable th) {
            throw new zzdlr(th);
        }
    }

    public final void zza(Context context, zzaih zzaih, List<zzaip> list) throws zzdlr {
        try {
            this.zzhcj.zza(ObjectWrapper.wrap(context), zzaih, list);
        } catch (Throwable th) {
            throw new zzdlr(th);
        }
    }
}
