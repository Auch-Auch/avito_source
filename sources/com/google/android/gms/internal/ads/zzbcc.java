package com.google.android.gms.internal.ads;

import a2.b.a.a.a;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.Surface;
import android.view.TextureView;
import com.google.android.gms.ads.internal.zzp;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
@TargetApi(14)
public final class zzbcc extends zzbcp implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnVideoSizeChangedListener, TextureView.SurfaceTextureListener {
    private static final Map<Integer, String> zzeem;
    private final zzbdh zzeen;
    private final boolean zzeeo;
    private int zzeep = 0;
    private int zzeeq = 0;
    private MediaPlayer zzeer;
    private Uri zzees;
    private int zzeet;
    private int zzeeu;
    private int zzeev;
    private int zzeew;
    private int zzeex;
    private zzbdc zzeey;
    private boolean zzeez;
    private int zzefa;
    private zzbcm zzefb;

    static {
        HashMap hashMap = new HashMap();
        zzeem = hashMap;
        hashMap.put(-1004, "MEDIA_ERROR_IO");
        hashMap.put(-1007, "MEDIA_ERROR_MALFORMED");
        hashMap.put(-1010, "MEDIA_ERROR_UNSUPPORTED");
        hashMap.put(-110, "MEDIA_ERROR_TIMED_OUT");
        hashMap.put(3, "MEDIA_INFO_VIDEO_RENDERING_START");
        hashMap.put(100, "MEDIA_ERROR_SERVER_DIED");
        hashMap.put(1, "MEDIA_ERROR_UNKNOWN");
        hashMap.put(1, "MEDIA_INFO_UNKNOWN");
        hashMap.put(700, "MEDIA_INFO_VIDEO_TRACK_LAGGING");
        hashMap.put(701, "MEDIA_INFO_BUFFERING_START");
        hashMap.put(702, "MEDIA_INFO_BUFFERING_END");
        hashMap.put(800, "MEDIA_INFO_BAD_INTERLEAVING");
        hashMap.put(801, "MEDIA_INFO_NOT_SEEKABLE");
        hashMap.put(802, "MEDIA_INFO_METADATA_UPDATE");
        hashMap.put(901, "MEDIA_INFO_UNSUPPORTED_SUBTITLE");
        hashMap.put(902, "MEDIA_INFO_SUBTITLE_TIMED_OUT");
    }

    public zzbcc(Context context, boolean z, boolean z2, zzbdf zzbdf, zzbdh zzbdh) {
        super(context);
        setSurfaceTextureListener(this);
        this.zzeen = zzbdh;
        this.zzeez = z;
        this.zzeeo = z2;
        zzbdh.zzb(this);
    }

    private final void zzat(boolean z) {
        zzaxy.zzei("AdMediaPlayerView release");
        zzbdc zzbdc = this.zzeey;
        if (zzbdc != null) {
            zzbdc.zzzk();
            this.zzeey = null;
        }
        MediaPlayer mediaPlayer = this.zzeer;
        if (mediaPlayer != null) {
            mediaPlayer.reset();
            this.zzeer.release();
            this.zzeer = null;
            zzdj(0);
            if (z) {
                this.zzeeq = 0;
                this.zzeeq = 0;
            }
        }
    }

    private final void zzd(float f) {
        MediaPlayer mediaPlayer = this.zzeer;
        if (mediaPlayer != null) {
            try {
                mediaPlayer.setVolume(f, f);
            } catch (IllegalStateException unused) {
            }
        } else {
            zzbbd.zzfe("AdMediaPlayerView setMediaPlayerVolume() called before onPrepared().");
        }
    }

    private final void zzdj(int i) {
        if (i == 3) {
            this.zzeen.zzzy();
            this.zzefk.zzzy();
        } else if (this.zzeep == 3) {
            this.zzeen.zzzz();
            this.zzefk.zzzz();
        }
        this.zzeep = i;
    }

    private final void zzyu() {
        zzaxy.zzei("AdMediaPlayerView init MediaPlayer");
        SurfaceTexture surfaceTexture = getSurfaceTexture();
        if (this.zzees != null && surfaceTexture != null) {
            zzat(false);
            try {
                zzp.zzlf();
                MediaPlayer mediaPlayer = new MediaPlayer();
                this.zzeer = mediaPlayer;
                mediaPlayer.setOnBufferingUpdateListener(this);
                this.zzeer.setOnCompletionListener(this);
                this.zzeer.setOnErrorListener(this);
                this.zzeer.setOnInfoListener(this);
                this.zzeer.setOnPreparedListener(this);
                this.zzeer.setOnVideoSizeChangedListener(this);
                this.zzeev = 0;
                if (this.zzeez) {
                    zzbdc zzbdc = new zzbdc(getContext());
                    this.zzeey = zzbdc;
                    zzbdc.zza(surfaceTexture, getWidth(), getHeight());
                    this.zzeey.start();
                    SurfaceTexture zzzl = this.zzeey.zzzl();
                    if (zzzl != null) {
                        surfaceTexture = zzzl;
                    } else {
                        this.zzeey.zzzk();
                        this.zzeey = null;
                    }
                }
                this.zzeer.setDataSource(getContext(), this.zzees);
                zzp.zzlg();
                this.zzeer.setSurface(new Surface(surfaceTexture));
                this.zzeer.setAudioStreamType(3);
                this.zzeer.setScreenOnWhilePlaying(true);
                this.zzeer.prepareAsync();
                zzdj(1);
            } catch (IOException | IllegalArgumentException | IllegalStateException e) {
                String valueOf = String.valueOf(this.zzees);
                StringBuilder sb = new StringBuilder(valueOf.length() + 36);
                sb.append("Failed to initialize MediaPlayer at ");
                sb.append(valueOf);
                zzbbd.zzd(sb.toString(), e);
                onError(this.zzeer, 1, 0);
            }
        }
    }

    private final void zzyv() {
        if (this.zzeeo && zzyw() && this.zzeer.getCurrentPosition() > 0 && this.zzeeq != 3) {
            zzaxy.zzei("AdMediaPlayerView nudging MediaPlayer");
            zzd(0.0f);
            this.zzeer.start();
            int currentPosition = this.zzeer.getCurrentPosition();
            long currentTimeMillis = zzp.zzkw().currentTimeMillis();
            while (zzyw() && this.zzeer.getCurrentPosition() == currentPosition && zzp.zzkw().currentTimeMillis() - currentTimeMillis <= 250) {
            }
            this.zzeer.pause();
            zzyx();
        }
    }

    private final boolean zzyw() {
        int i;
        return (this.zzeer == null || (i = this.zzeep) == -1 || i == 0 || i == 1) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzbcp
    public final int getCurrentPosition() {
        if (zzyw()) {
            return this.zzeer.getCurrentPosition();
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbcp
    public final int getDuration() {
        if (zzyw()) {
            return this.zzeer.getDuration();
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzbcp
    public final int getVideoHeight() {
        MediaPlayer mediaPlayer = this.zzeer;
        if (mediaPlayer != null) {
            return mediaPlayer.getVideoHeight();
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbcp
    public final int getVideoWidth() {
        MediaPlayer mediaPlayer = this.zzeer;
        if (mediaPlayer != null) {
            return mediaPlayer.getVideoWidth();
        }
        return 0;
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        this.zzeev = i;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public final void onCompletion(MediaPlayer mediaPlayer) {
        zzaxy.zzei("AdMediaPlayerView completion");
        zzdj(5);
        this.zzeeq = 5;
        zzayh.zzeaj.post(new zzbch(this));
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        Map<Integer, String> map = zzeem;
        String str = map.get(Integer.valueOf(i));
        String str2 = map.get(Integer.valueOf(i2));
        StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + String.valueOf(str).length() + 38);
        sb.append("AdMediaPlayerView MediaPlayer error: ");
        sb.append(str);
        sb.append(":");
        sb.append(str2);
        zzbbd.zzfe(sb.toString());
        zzdj(-1);
        this.zzeeq = -1;
        zzayh.zzeaj.post(new zzbcg(this, str, str2));
        return true;
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public final boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        Map<Integer, String> map = zzeem;
        String str = map.get(Integer.valueOf(i));
        String str2 = map.get(Integer.valueOf(i2));
        StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + String.valueOf(str).length() + 37);
        sb.append("AdMediaPlayerView MediaPlayer info: ");
        sb.append(str);
        sb.append(":");
        sb.append(str2);
        zzaxy.zzei(sb.toString());
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0065, code lost:
        if (r1 > r6) goto L_0x0067;
     */
    @Override // android.view.View
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onMeasure(int r6, int r7) {
        /*
            r5 = this;
            int r0 = r5.zzeet
            int r0 = android.view.TextureView.getDefaultSize(r0, r6)
            int r1 = r5.zzeeu
            int r1 = android.view.TextureView.getDefaultSize(r1, r7)
            int r2 = r5.zzeet
            if (r2 <= 0) goto L_0x0083
            int r2 = r5.zzeeu
            if (r2 <= 0) goto L_0x0083
            com.google.android.gms.internal.ads.zzbdc r2 = r5.zzeey
            if (r2 != 0) goto L_0x0083
            int r0 = android.view.View.MeasureSpec.getMode(r6)
            int r6 = android.view.View.MeasureSpec.getSize(r6)
            int r1 = android.view.View.MeasureSpec.getMode(r7)
            int r7 = android.view.View.MeasureSpec.getSize(r7)
            r2 = 1073741824(0x40000000, float:2.0)
            if (r0 != r2) goto L_0x0047
            if (r1 != r2) goto L_0x0047
            int r0 = r5.zzeet
            int r1 = r0 * r7
            int r2 = r5.zzeeu
            int r3 = r6 * r2
            if (r1 >= r3) goto L_0x003c
            int r0 = r0 * r7
            int r0 = r0 / r2
            goto L_0x006a
        L_0x003c:
            int r1 = r0 * r7
            int r3 = r6 * r2
            if (r1 <= r3) goto L_0x0067
            int r2 = r2 * r6
            int r1 = r2 / r0
            goto L_0x0058
        L_0x0047:
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r0 != r2) goto L_0x005a
            int r0 = r5.zzeeu
            int r0 = r0 * r6
            int r2 = r5.zzeet
            int r0 = r0 / r2
            if (r1 != r3) goto L_0x0057
            if (r0 <= r7) goto L_0x0057
            goto L_0x0067
        L_0x0057:
            r1 = r0
        L_0x0058:
            r0 = r6
            goto L_0x0083
        L_0x005a:
            if (r1 != r2) goto L_0x006c
            int r1 = r5.zzeet
            int r1 = r1 * r7
            int r2 = r5.zzeeu
            int r1 = r1 / r2
            if (r0 != r3) goto L_0x0069
            if (r1 <= r6) goto L_0x0069
        L_0x0067:
            r0 = r6
            goto L_0x006a
        L_0x0069:
            r0 = r1
        L_0x006a:
            r1 = r7
            goto L_0x0083
        L_0x006c:
            int r2 = r5.zzeet
            int r4 = r5.zzeeu
            if (r1 != r3) goto L_0x0078
            if (r4 <= r7) goto L_0x0078
            int r1 = r7 * r2
            int r1 = r1 / r4
            goto L_0x007a
        L_0x0078:
            r1 = r2
            r7 = r4
        L_0x007a:
            if (r0 != r3) goto L_0x0069
            if (r1 <= r6) goto L_0x0069
            int r4 = r4 * r6
            int r1 = r4 / r2
            goto L_0x0058
        L_0x0083:
            r5.setMeasuredDimension(r0, r1)
            com.google.android.gms.internal.ads.zzbdc r6 = r5.zzeey
            if (r6 == 0) goto L_0x008d
            r6.zzm(r0, r1)
        L_0x008d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbcc.onMeasure(int, int):void");
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public final void onPrepared(MediaPlayer mediaPlayer) {
        zzaxy.zzei("AdMediaPlayerView prepared");
        zzdj(2);
        this.zzeen.zzez();
        zzayh.zzeaj.post(new zzbce(this));
        this.zzeet = mediaPlayer.getVideoWidth();
        this.zzeeu = mediaPlayer.getVideoHeight();
        int i = this.zzefa;
        if (i != 0) {
            seekTo(i);
        }
        zzyv();
        int i2 = this.zzeet;
        int i3 = this.zzeeu;
        StringBuilder sb = new StringBuilder(62);
        sb.append("AdMediaPlayerView stream dimensions: ");
        sb.append(i2);
        sb.append(" x ");
        sb.append(i3);
        zzbbd.zzfd(sb.toString());
        if (this.zzeeq == 3) {
            play();
        }
        zzyx();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        zzaxy.zzei("AdMediaPlayerView surface created");
        zzyu();
        zzayh.zzeaj.post(new zzbcj(this));
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        zzaxy.zzei("AdMediaPlayerView surface destroyed");
        MediaPlayer mediaPlayer = this.zzeer;
        if (mediaPlayer != null && this.zzefa == 0) {
            this.zzefa = mediaPlayer.getCurrentPosition();
        }
        zzbdc zzbdc = this.zzeey;
        if (zzbdc != null) {
            zzbdc.zzzk();
        }
        zzayh.zzeaj.post(new zzbcl(this));
        zzat(true);
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        zzaxy.zzei("AdMediaPlayerView surface changed");
        boolean z = true;
        boolean z2 = this.zzeeq == 3;
        if (!(this.zzeet == i && this.zzeeu == i2)) {
            z = false;
        }
        if (this.zzeer != null && z2 && z) {
            int i3 = this.zzefa;
            if (i3 != 0) {
                seekTo(i3);
            }
            play();
        }
        zzbdc zzbdc = this.zzeey;
        if (zzbdc != null) {
            zzbdc.zzm(i, i2);
        }
        zzayh.zzeaj.post(new zzbci(this, i, i2));
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.zzeen.zzc(this);
        this.zzefj.zza(surfaceTexture, this.zzefb);
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        StringBuilder sb = new StringBuilder(57);
        sb.append("AdMediaPlayerView size changed: ");
        sb.append(i);
        sb.append(" x ");
        sb.append(i2);
        zzaxy.zzei(sb.toString());
        this.zzeet = mediaPlayer.getVideoWidth();
        int videoHeight = mediaPlayer.getVideoHeight();
        this.zzeeu = videoHeight;
        if (this.zzeet != 0 && videoHeight != 0) {
            requestLayout();
        }
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i) {
        StringBuilder sb = new StringBuilder(58);
        sb.append("AdMediaPlayerView window visibility changed to ");
        sb.append(i);
        zzaxy.zzei(sb.toString());
        zzayh.zzeaj.post(new Runnable(this, i) { // from class: com.google.android.gms.internal.ads.zzbcf
            private final int zzeax;
            private final zzbcc zzefe;

            {
                this.zzefe = r1;
                this.zzeax = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzefe.zzdk(this.zzeax);
            }
        });
        super.onWindowVisibilityChanged(i);
    }

    @Override // com.google.android.gms.internal.ads.zzbcp
    public final void pause() {
        zzaxy.zzei("AdMediaPlayerView pause");
        if (zzyw() && this.zzeer.isPlaying()) {
            this.zzeer.pause();
            zzdj(4);
            zzayh.zzeaj.post(new zzbcn(this));
        }
        this.zzeeq = 4;
    }

    @Override // com.google.android.gms.internal.ads.zzbcp
    public final void play() {
        zzaxy.zzei("AdMediaPlayerView play");
        if (zzyw()) {
            this.zzeer.start();
            zzdj(3);
            this.zzefj.zzyz();
            zzayh.zzeaj.post(new zzbck(this));
        }
        this.zzeeq = 3;
    }

    @Override // com.google.android.gms.internal.ads.zzbcp
    public final void seekTo(int i) {
        StringBuilder sb = new StringBuilder(34);
        sb.append("AdMediaPlayerView seek ");
        sb.append(i);
        zzaxy.zzei(sb.toString());
        if (zzyw()) {
            this.zzeer.seekTo(i);
            this.zzefa = 0;
            return;
        }
        this.zzefa = i;
    }

    @Override // com.google.android.gms.internal.ads.zzbcp
    public final void setVideoPath(String str) {
        Uri parse = Uri.parse(str);
        zzta zzd = zzta.zzd(parse);
        if (zzd == null || zzd.url != null) {
            if (zzd != null) {
                parse = Uri.parse(zzd.url);
            }
            this.zzees = parse;
            this.zzefa = 0;
            zzyu();
            requestLayout();
            invalidate();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbcp
    public final void stop() {
        zzaxy.zzei("AdMediaPlayerView stop");
        MediaPlayer mediaPlayer = this.zzeer;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            this.zzeer.release();
            this.zzeer = null;
            zzdj(0);
            this.zzeeq = 0;
        }
        this.zzeen.onStop();
    }

    @Override // android.view.View, java.lang.Object
    public final String toString() {
        String name = zzbcc.class.getName();
        String hexString = Integer.toHexString(hashCode());
        return a.s2(a.q0(hexString, name.length() + 1), name, "@", hexString);
    }

    @Override // com.google.android.gms.internal.ads.zzbcp
    public final void zza(zzbcm zzbcm) {
        this.zzefb = zzbcm;
    }

    public final /* synthetic */ void zzdk(int i) {
        zzbcm zzbcm = this.zzefb;
        if (zzbcm != null) {
            zzbcm.onWindowVisibilityChanged(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbcp
    public final String zzyt() {
        String str = this.zzeez ? " spherical" : "";
        return str.length() != 0 ? "MediaPlayer".concat(str) : new String("MediaPlayer");
    }

    @Override // com.google.android.gms.internal.ads.zzbcp, com.google.android.gms.internal.ads.zzbdi
    public final void zzyx() {
        zzd(this.zzefk.getVolume());
    }

    @Override // com.google.android.gms.internal.ads.zzbcp
    public final void zza(float f, float f2) {
        zzbdc zzbdc = this.zzeey;
        if (zzbdc != null) {
            zzbdc.zzb(f, f2);
        }
    }
}
