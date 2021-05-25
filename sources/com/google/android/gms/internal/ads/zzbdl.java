package com.google.android.gms.internal.ads;

import a2.b.a.a.a;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.view.Surface;
import android.view.TextureView;
import com.google.android.gms.ads.internal.zzp;
import java.nio.ByteBuffer;
import java.util.Arrays;
@TargetApi(16)
public final class zzbdl extends zzbcp implements TextureView.SurfaceTextureListener, zzbei {
    private Surface zzblg;
    private final zzbdh zzeen;
    private final boolean zzeeo;
    private int zzeet;
    private int zzeeu;
    private int zzeew;
    private int zzeex;
    private zzbdc zzeey;
    private final boolean zzeez;
    private zzbcm zzefb;
    private final zzbde zzefm;
    private String[] zzefz;
    private final zzbdf zzeiw;
    private zzbeb zzeix;
    private String zzeiy;
    private boolean zzeiz;
    private int zzeja = 1;
    private boolean zzejb;
    private boolean zzejc;
    private float zzejd;

    public zzbdl(Context context, zzbdh zzbdh, zzbde zzbde, boolean z, boolean z2, zzbdf zzbdf) {
        super(context);
        this.zzeeo = z2;
        this.zzefm = zzbde;
        this.zzeen = zzbdh;
        this.zzeez = z;
        this.zzeiw = zzbdf;
        setSurfaceTextureListener(this);
        zzbdh.zzb(this);
    }

    private final void zza(Surface surface, boolean z) {
        zzbeb zzbeb = this.zzeix;
        if (zzbeb != null) {
            zzbeb.zza(surface, z);
        } else {
            zzbbd.zzfe("Trying to set surface before player is initalized.");
        }
    }

    private final zzbeb zzaab() {
        return new zzbeb(this.zzefm.getContext(), this.zzeiw);
    }

    private final String zzaac() {
        return zzp.zzkp().zzs(this.zzefm.getContext(), this.zzefm.zzzt().zzbra);
    }

    private final boolean zzaad() {
        zzbeb zzbeb = this.zzeix;
        return (zzbeb == null || zzbeb.zzaaq() == null || this.zzeiz) ? false : true;
    }

    private final boolean zzaae() {
        return zzaad() && this.zzeja != 1;
    }

    private final void zzaaf() {
        String str;
        if (this.zzeix == null && (str = this.zzeiy) != null && this.zzblg != null) {
            if (str.startsWith("cache:")) {
                zzbev zzfj = this.zzefm.zzfj(this.zzeiy);
                if (zzfj instanceof zzbfg) {
                    zzbeb zzaav = ((zzbfg) zzfj).zzaav();
                    this.zzeix = zzaav;
                    if (zzaav.zzaaq() == null) {
                        zzbbd.zzfe("Precached video player has been released.");
                        return;
                    }
                } else if (zzfj instanceof zzbfh) {
                    zzbfh zzbfh = (zzbfh) zzfj;
                    String zzaac = zzaac();
                    ByteBuffer byteBuffer = zzbfh.getByteBuffer();
                    boolean zzaaw = zzbfh.zzaaw();
                    String url = zzbfh.getUrl();
                    if (url == null) {
                        zzbbd.zzfe("Stream cache URL is null.");
                        return;
                    }
                    zzbeb zzaab = zzaab();
                    this.zzeix = zzaab;
                    zzaab.zza(new Uri[]{Uri.parse(url)}, zzaac, byteBuffer, zzaaw);
                } else {
                    String valueOf = String.valueOf(this.zzeiy);
                    zzbbd.zzfe(valueOf.length() != 0 ? "Stream cache miss: ".concat(valueOf) : new String("Stream cache miss: "));
                    return;
                }
            } else {
                this.zzeix = zzaab();
                String zzaac2 = zzaac();
                Uri[] uriArr = new Uri[this.zzefz.length];
                int i = 0;
                while (true) {
                    String[] strArr = this.zzefz;
                    if (i >= strArr.length) {
                        break;
                    }
                    uriArr[i] = Uri.parse(strArr[i]);
                    i++;
                }
                this.zzeix.zza(uriArr, zzaac2);
            }
            this.zzeix.zza(this);
            zza(this.zzblg, false);
            if (this.zzeix.zzaaq() != null) {
                int playbackState = this.zzeix.zzaaq().getPlaybackState();
                this.zzeja = playbackState;
                if (playbackState == 3) {
                    zzaag();
                }
            }
        }
    }

    private final void zzaag() {
        if (!this.zzejb) {
            this.zzejb = true;
            zzayh.zzeaj.post(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzbdk
                private final zzbdl zzeiv;

                {
                    this.zzeiv = r1;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zzeiv.zzaap();
                }
            });
            zzyx();
            this.zzeen.zzez();
            if (this.zzejc) {
                play();
            }
        }
    }

    private final void zzaah() {
        zzo(this.zzeet, this.zzeeu);
    }

    private final void zzaai() {
        zzbeb zzbeb = this.zzeix;
        if (zzbeb != null) {
            zzbeb.zzaw(true);
        }
    }

    private final void zzaaj() {
        zzbeb zzbeb = this.zzeix;
        if (zzbeb != null) {
            zzbeb.zzaw(false);
        }
    }

    private final void zzo(int i, int i2) {
        float f = i2 > 0 ? ((float) i) / ((float) i2) : 1.0f;
        if (this.zzejd != f) {
            this.zzejd = f;
            requestLayout();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbcp
    public final int getCurrentPosition() {
        if (zzaae()) {
            return (int) this.zzeix.zzaaq().zzek();
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbcp
    public final int getDuration() {
        if (zzaae()) {
            return (int) this.zzeix.zzaaq().getDuration();
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbcp
    public final int getVideoHeight() {
        return this.zzeeu;
    }

    @Override // com.google.android.gms.internal.ads.zzbcp
    public final int getVideoWidth() {
        return this.zzeet;
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        float f = this.zzejd;
        if (f != 0.0f && this.zzeey == null) {
            float f2 = (float) measuredWidth;
            float f3 = f2 / ((float) measuredHeight);
            if (f > f3) {
                measuredHeight = (int) (f2 / f);
            }
            if (f < f3) {
                measuredWidth = (int) (((float) measuredHeight) * f);
            }
        }
        setMeasuredDimension(measuredWidth, measuredHeight);
        zzbdc zzbdc = this.zzeey;
        if (zzbdc != null) {
            zzbdc.zzm(measuredWidth, measuredHeight);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        if (this.zzeez) {
            zzbdc zzbdc = new zzbdc(getContext());
            this.zzeey = zzbdc;
            zzbdc.zza(surfaceTexture, i, i2);
            this.zzeey.start();
            SurfaceTexture zzzl = this.zzeey.zzzl();
            if (zzzl != null) {
                surfaceTexture = zzzl;
            } else {
                this.zzeey.zzzk();
                this.zzeey = null;
            }
        }
        Surface surface = new Surface(surfaceTexture);
        this.zzblg = surface;
        if (this.zzeix == null) {
            zzaaf();
        } else {
            zza(surface, true);
            if (!this.zzeiw.zzehu) {
                zzaai();
            }
        }
        if (this.zzeet == 0 || this.zzeeu == 0) {
            zzo(i, i2);
        } else {
            zzaah();
        }
        zzayh.zzeaj.post(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzbdr
            private final zzbdl zzeiv;

            {
                this.zzeiv = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzeiv.zzaal();
            }
        });
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        pause();
        zzbdc zzbdc = this.zzeey;
        if (zzbdc != null) {
            zzbdc.zzzk();
            this.zzeey = null;
        }
        if (this.zzeix != null) {
            zzaaj();
            Surface surface = this.zzblg;
            if (surface != null) {
                surface.release();
            }
            this.zzblg = null;
            zza((Surface) null, true);
        }
        zzayh.zzeaj.post(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzbdt
            private final zzbdl zzeiv;

            {
                this.zzeiv = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzeiv.zzaak();
            }
        });
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        zzbdc zzbdc = this.zzeey;
        if (zzbdc != null) {
            zzbdc.zzm(i, i2);
        }
        zzayh.zzeaj.post(new Runnable(this, i, i2) { // from class: com.google.android.gms.internal.ads.zzbdq
            private final int zzeax;
            private final int zzeay;
            private final zzbdl zzeiv;

            {
                this.zzeiv = r1;
                this.zzeax = r2;
                this.zzeay = r3;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzeiv.zzp(this.zzeax, this.zzeay);
            }
        });
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.zzeen.zzc(this);
        this.zzefj.zza(surfaceTexture, this.zzefb);
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i) {
        StringBuilder sb = new StringBuilder(57);
        sb.append("AdExoPlayerView3 window visibility changed to ");
        sb.append(i);
        zzaxy.zzei(sb.toString());
        zzayh.zzeaj.post(new Runnable(this, i) { // from class: com.google.android.gms.internal.ads.zzbds
            private final int zzeax;
            private final zzbdl zzeiv;

            {
                this.zzeiv = r1;
                this.zzeax = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzeiv.zzdr(this.zzeax);
            }
        });
        super.onWindowVisibilityChanged(i);
    }

    @Override // com.google.android.gms.internal.ads.zzbcp
    public final void pause() {
        if (zzaae()) {
            if (this.zzeiw.zzehu) {
                zzaaj();
            }
            this.zzeix.zzaaq().zzf(false);
            this.zzeen.zzzz();
            this.zzefk.zzzz();
            zzayh.zzeaj.post(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzbdo
                private final zzbdl zzeiv;

                {
                    this.zzeiv = r1;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zzeiv.zzaam();
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbcp
    public final void play() {
        if (zzaae()) {
            if (this.zzeiw.zzehu) {
                zzaai();
            }
            this.zzeix.zzaaq().zzf(true);
            this.zzeen.zzzy();
            this.zzefk.zzzy();
            this.zzefj.zzyz();
            zzayh.zzeaj.post(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzbdp
                private final zzbdl zzeiv;

                {
                    this.zzeiv = r1;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zzeiv.zzaan();
                }
            });
            return;
        }
        this.zzejc = true;
    }

    @Override // com.google.android.gms.internal.ads.zzbcp
    public final void seekTo(int i) {
        if (zzaae()) {
            this.zzeix.zzaaq().seekTo((long) i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbcp
    public final void setVideoPath(String str) {
        if (str != null) {
            this.zzeiy = str;
            this.zzefz = new String[]{str};
            zzaaf();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbcp
    public final void stop() {
        if (zzaad()) {
            this.zzeix.zzaaq().stop();
            if (this.zzeix != null) {
                zza((Surface) null, true);
                zzbeb zzbeb = this.zzeix;
                if (zzbeb != null) {
                    zzbeb.zza((zzbei) null);
                    this.zzeix.release();
                    this.zzeix = null;
                }
                this.zzeja = 1;
                this.zzeiz = false;
                this.zzejb = false;
                this.zzejc = false;
            }
        }
        this.zzeen.zzzz();
        this.zzefk.zzzz();
        this.zzeen.onStop();
    }

    public final /* synthetic */ void zzaak() {
        zzbcm zzbcm = this.zzefb;
        if (zzbcm != null) {
            zzbcm.zzzb();
        }
    }

    public final /* synthetic */ void zzaal() {
        zzbcm zzbcm = this.zzefb;
        if (zzbcm != null) {
            zzbcm.zzyy();
        }
    }

    public final /* synthetic */ void zzaam() {
        zzbcm zzbcm = this.zzefb;
        if (zzbcm != null) {
            zzbcm.onPaused();
        }
    }

    public final /* synthetic */ void zzaan() {
        zzbcm zzbcm = this.zzefb;
        if (zzbcm != null) {
            zzbcm.zzyz();
        }
    }

    public final /* synthetic */ void zzaao() {
        zzbcm zzbcm = this.zzefb;
        if (zzbcm != null) {
            zzbcm.zzza();
        }
    }

    public final /* synthetic */ void zzaap() {
        zzbcm zzbcm = this.zzefb;
        if (zzbcm != null) {
            zzbcm.zzez();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbcp
    public final void zzb(String str, String[] strArr) {
        if (str != null) {
            if (strArr == null) {
                setVideoPath(str);
            }
            this.zzeiy = str;
            this.zzefz = (String[]) Arrays.copyOf(strArr, strArr.length);
            zzaaf();
        }
    }

    public final /* synthetic */ void zzc(boolean z, long j) {
        this.zzefm.zza(z, j);
    }

    @Override // com.google.android.gms.internal.ads.zzbcp
    public final void zzdl(int i) {
        zzbeb zzbeb = this.zzeix;
        if (zzbeb != null) {
            zzbeb.zzaat().zzds(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbcp
    public final void zzdm(int i) {
        zzbeb zzbeb = this.zzeix;
        if (zzbeb != null) {
            zzbeb.zzaat().zzdt(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbcp
    public final void zzdn(int i) {
        zzbeb zzbeb = this.zzeix;
        if (zzbeb != null) {
            zzbeb.zzaat().zzdn(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbcp
    public final void zzdo(int i) {
        zzbeb zzbeb = this.zzeix;
        if (zzbeb != null) {
            zzbeb.zzaat().zzdo(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbcp
    public final void zzdp(int i) {
        zzbeb zzbeb = this.zzeix;
        if (zzbeb != null) {
            zzbeb.zzdp(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbei
    public final void zzdq(int i) {
        if (this.zzeja != i) {
            this.zzeja = i;
            if (i == 3) {
                zzaag();
            } else if (i == 4) {
                if (this.zzeiw.zzehu) {
                    zzaaj();
                }
                this.zzeen.zzzz();
                this.zzefk.zzzz();
                zzayh.zzeaj.post(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzbdn
                    private final zzbdl zzeiv;

                    {
                        this.zzeiv = r1;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zzeiv.zzaao();
                    }
                });
            }
        }
    }

    public final /* synthetic */ void zzdr(int i) {
        zzbcm zzbcm = this.zzefb;
        if (zzbcm != null) {
            zzbcm.onWindowVisibilityChanged(i);
        }
    }

    public final /* synthetic */ void zzfk(String str) {
        zzbcm zzbcm = this.zzefb;
        if (zzbcm != null) {
            zzbcm.zzm("ExoPlayerAdapter error", str);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbei
    public final void zzn(int i, int i2) {
        this.zzeet = i;
        this.zzeeu = i2;
        zzaah();
    }

    public final /* synthetic */ void zzp(int i, int i2) {
        zzbcm zzbcm = this.zzefb;
        if (zzbcm != null) {
            zzbcm.zzk(i, i2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbcp
    public final String zzyt() {
        String str = this.zzeez ? " spherical" : "";
        return str.length() != 0 ? "ExoPlayer/3".concat(str) : new String("ExoPlayer/3");
    }

    @Override // com.google.android.gms.internal.ads.zzbcp, com.google.android.gms.internal.ads.zzbdi
    public final void zzyx() {
        zza(this.zzefk.getVolume(), false);
    }

    private final void zza(float f, boolean z) {
        zzbeb zzbeb = this.zzeix;
        if (zzbeb != null) {
            zzbeb.zzb(f, z);
        } else {
            zzbbd.zzfe("Trying to set volume before player is initalized.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbei
    public final void zzb(boolean z, long j) {
        if (this.zzefm != null) {
            zzbbi.zzedy.execute(new Runnable(this, z, j) { // from class: com.google.android.gms.internal.ads.zzbdv
                private final boolean zzegf;
                private final zzbdl zzeiv;
                private final long zzejh;

                {
                    this.zzeiv = r1;
                    this.zzegf = r2;
                    this.zzejh = r3;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zzeiv.zzc(this.zzegf, this.zzejh);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbcp
    public final void zza(zzbcm zzbcm) {
        this.zzefb = zzbcm;
    }

    @Override // com.google.android.gms.internal.ads.zzbcp
    public final void zza(float f, float f2) {
        zzbdc zzbdc = this.zzeey;
        if (zzbdc != null) {
            zzbdc.zzb(f, f2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbei
    public final void zza(String str, Exception exc) {
        String canonicalName = exc.getClass().getCanonicalName();
        String message = exc.getMessage();
        StringBuilder K = a.K(a.q0(message, a.q0(canonicalName, a.q0(str, 2))), str, "/", canonicalName, ":");
        K.append(message);
        String sb = K.toString();
        String valueOf = String.valueOf(sb);
        zzbbd.zzfe(valueOf.length() != 0 ? "ExoPlayerAdapter error: ".concat(valueOf) : new String("ExoPlayerAdapter error: "));
        this.zzeiz = true;
        if (this.zzeiw.zzehu) {
            zzaaj();
        }
        zzayh.zzeaj.post(new Runnable(this, sb) { // from class: com.google.android.gms.internal.ads.zzbdm
            private final String zzdft;
            private final zzbdl zzeiv;

            {
                this.zzeiv = r1;
                this.zzdft = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzeiv.zzfk(this.zzdft);
            }
        });
    }
}
