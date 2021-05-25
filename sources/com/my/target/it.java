package com.my.target;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.Surface;
import android.view.TextureView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.facebook.internal.AnalyticsEvents;
import com.my.target.is;
public class it implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, TextureView.SurfaceTextureListener, is {
    @NonNull
    public final ik a = ik.J(200);
    @NonNull
    public final a b;
    @NonNull
    public final MediaPlayer c;
    @Nullable
    public is.a d;
    @Nullable
    public Surface e;
    public int f = 0;
    public float g = 1.0f;
    public int h;
    public long i = 0;
    @Nullable
    public fq j;
    @Nullable
    public Uri k;

    @VisibleForTesting
    public static class a implements Runnable {
        @Nullable
        public it a;
        @Nullable
        public is.a b;
        public int c;
        public float d;

        public a(int i) {
        }

        @Override // java.lang.Runnable
        public void run() {
            it itVar = this.a;
            if (itVar != null) {
                float position = ((float) itVar.getPosition()) / 1000.0f;
                float duration = this.a.getDuration();
                if (this.d == position) {
                    this.c++;
                } else {
                    is.a aVar = this.b;
                    if (aVar != null) {
                        aVar.a(position, duration);
                    }
                    this.d = position;
                    if (this.c > 0) {
                        this.c = 0;
                    }
                }
                if (this.c > 50) {
                    is.a aVar2 = this.b;
                    if (aVar2 != null) {
                        aVar2.D();
                    }
                    this.c = 0;
                }
            }
        }
    }

    public it() {
        MediaPlayer mediaPlayer = new MediaPlayer();
        a aVar = new a(50);
        this.c = mediaPlayer;
        this.b = aVar;
        aVar.a = this;
    }

    @NonNull
    public static is fm() {
        return new it();
    }

    @Override // com.my.target.is
    public void M() {
        setVolume(0.2f);
    }

    @Override // com.my.target.is
    public void N() {
        setVolume(0.0f);
    }

    @Override // com.my.target.is
    @SuppressLint({"Recycle"})
    public void a(@NonNull Uri uri, @NonNull Context context) {
        this.k = uri;
        StringBuilder L = a2.b.a.a.a.L("Play video in Android MediaPlayer: ");
        L.append(uri.toString());
        ae.a(L.toString());
        if (this.f != 0) {
            this.c.reset();
            this.f = 0;
        }
        this.c.setOnCompletionListener(this);
        this.c.setOnErrorListener(this);
        this.c.setOnPreparedListener(this);
        this.c.setOnInfoListener(this);
        try {
            this.c.setDataSource(context, uri);
            is.a aVar = this.d;
            if (aVar != null) {
                aVar.C();
            }
            try {
                this.c.prepareAsync();
            } catch (Throwable unused) {
                ae.a("prepareAsync called in wrong state");
            }
            this.a.d(this.b);
        } catch (Throwable th) {
            is.a aVar2 = this.d;
            if (aVar2 != null) {
                aVar2.e(th.toString());
            }
            a2.b.a.a.a.q1(th, a2.b.a.a.a.L("DefaultVideoPlayerUnable to parse video source "));
            this.f = 5;
            th.printStackTrace();
        }
    }

    @Override // com.my.target.is
    @SuppressLint({"Recycle"})
    public void a(@Nullable fq fqVar) {
        c();
        Surface surface = null;
        if (!(fqVar instanceof fq)) {
            this.j = null;
            b(null);
            return;
        }
        this.j = fqVar;
        TextureView textureView = fqVar.getTextureView();
        textureView.getSurfaceTextureListener();
        textureView.setSurfaceTextureListener(this);
        SurfaceTexture surfaceTexture = textureView.isAvailable() ? textureView.getSurfaceTexture() : null;
        if (surfaceTexture != null) {
            surface = new Surface(surfaceTexture);
        }
        b(surface);
    }

    @Override // com.my.target.is
    public void a(@Nullable is.a aVar) {
        this.d = aVar;
        this.b.b = aVar;
    }

    public final void b(@Nullable Surface surface) {
        this.c.setSurface(surface);
        Surface surface2 = this.e;
        if (!(surface2 == null || surface2 == surface)) {
            surface2.release();
        }
        this.e = surface;
    }

    public final void c() {
        fq fqVar = this.j;
        TextureView textureView = fqVar != null ? fqVar.getTextureView() : null;
        if (textureView != null && textureView.getSurfaceTextureListener() == this) {
            textureView.setSurfaceTextureListener(null);
        }
    }

    public final boolean d() {
        int i2 = this.f;
        return i2 >= 1 && i2 <= 4;
    }

    @Override // com.my.target.is
    public void da() {
        setVolume(1.0f);
    }

    @Override // com.my.target.is
    public void destroy() {
        this.d = null;
        this.f = 5;
        this.a.e(this.b);
        c();
        if (d()) {
            try {
                this.c.stop();
            } catch (Throwable unused) {
                ae.a("stop called in wrong state");
            }
        }
        this.c.release();
        this.j = null;
    }

    @Override // com.my.target.is
    public void dk() {
        if (this.g == 1.0f) {
            setVolume(0.0f);
        } else {
            setVolume(1.0f);
        }
    }

    @Override // com.my.target.is
    public void fl() {
        try {
            this.c.start();
            this.f = 1;
        } catch (Throwable unused) {
            ae.a("replay called in wrong state");
        }
        seekTo(0);
    }

    public float getDuration() {
        if (d()) {
            return ((float) this.c.getDuration()) / 1000.0f;
        }
        return 0.0f;
    }

    @Override // com.my.target.is
    public long getPosition() {
        if (!d() || this.f == 3) {
            return 0;
        }
        return (long) this.c.getCurrentPosition();
    }

    @Override // com.my.target.is
    @Nullable
    public Uri getUri() {
        return this.k;
    }

    @Override // com.my.target.is
    public boolean isMuted() {
        return this.g == 0.0f;
    }

    @Override // com.my.target.is
    public boolean isPaused() {
        return this.f == 2;
    }

    @Override // com.my.target.is
    public boolean isPlaying() {
        return this.f == 1;
    }

    @Override // com.my.target.is
    public boolean isStarted() {
        int i2 = this.f;
        return i2 >= 1 && i2 < 3;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        is.a aVar;
        float duration = getDuration();
        this.f = 4;
        if (duration > 0.0f && (aVar = this.d) != null) {
            aVar.a(duration, duration);
        }
        is.a aVar2 = this.d;
        if (aVar2 != null) {
            aVar2.onVideoCompleted();
        }
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
        this.a.e(this.b);
        c();
        b(null);
        String d2 = a2.b.a.a.a.d(i2 == 100 ? "Server died" : "Unknown error", " (reason: ", i3 == -1004 ? "IO error" : i3 == -1007 ? "Malformed error" : i3 == -1010 ? "Unsupported error" : i3 == -110 ? "Timed out error" : i3 == Integer.MIN_VALUE ? "Low-level system error" : AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN, ")");
        a2.b.a.a.a.U0("DefaultVideoPlayerVideo error: ", d2);
        is.a aVar = this.d;
        if (aVar != null) {
            aVar.e(d2);
        }
        if (this.f > 0) {
            try {
                this.c.reset();
            } catch (Throwable unused) {
                ae.a("reset called in wrong state");
            }
        }
        this.f = 0;
        return true;
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public boolean onInfo(MediaPlayer mediaPlayer, int i2, int i3) {
        if (i2 != 3) {
            return false;
        }
        is.a aVar = this.d;
        if (aVar == null) {
            return true;
        }
        aVar.z();
        return true;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        float f2 = this.g;
        mediaPlayer.setVolume(f2, f2);
        this.f = 1;
        try {
            mediaPlayer.start();
            long j2 = this.i;
            if (j2 > 0) {
                seekTo(j2);
            }
        } catch (Throwable unused) {
            ae.a("start called in wrong state");
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        b(new Surface(surfaceTexture));
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        b(null);
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override // com.my.target.is
    public void pause() {
        if (this.f == 1) {
            this.h = this.c.getCurrentPosition();
            this.a.e(this.b);
            try {
                this.c.pause();
            } catch (Throwable unused) {
                ae.a("pause called in wrong state");
            }
            this.f = 2;
            is.a aVar = this.d;
            if (aVar != null) {
                aVar.A();
            }
        }
    }

    @Override // com.my.target.is
    public void resume() {
        if (this.f == 2) {
            this.a.d(this.b);
            try {
                this.c.start();
            } catch (Throwable unused) {
                ae.a("start called in wrong state");
            }
            int i2 = this.h;
            if (i2 > 0) {
                try {
                    this.c.seekTo(i2);
                } catch (Throwable unused2) {
                    ae.a("seekTo called in wrong state");
                }
                this.h = 0;
            }
            this.f = 1;
            is.a aVar = this.d;
            if (aVar != null) {
                aVar.B();
            }
        }
    }

    @Override // com.my.target.is
    public void seekTo(long j2) {
        this.i = j2;
        if (d()) {
            try {
                this.c.seekTo((int) j2);
                this.i = 0;
            } catch (Throwable unused) {
                ae.a("seekTo called in wrong state");
            }
        }
    }

    @Override // com.my.target.is
    public void setVolume(float f2) {
        this.g = f2;
        if (d()) {
            this.c.setVolume(f2, f2);
        }
        is.a aVar = this.d;
        if (aVar != null) {
            aVar.d(f2);
        }
    }

    @Override // com.my.target.is
    public void stop() {
        this.a.e(this.b);
        try {
            this.c.stop();
        } catch (Throwable unused) {
            ae.a("stop called in wrong state");
        }
        is.a aVar = this.d;
        if (aVar != null) {
            aVar.y();
        }
        this.f = 3;
    }
}
