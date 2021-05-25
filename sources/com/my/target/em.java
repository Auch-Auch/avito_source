package com.my.target;

import android.content.Context;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.my.target.common.models.VideoData;
import com.my.target.fq;
import com.my.target.is;
import java.util.Objects;
public class em implements AudioManager.OnAudioFocusChangeListener, eh, fq.a, is.a {
    @NonNull
    public final a a;
    @NonNull
    public fq b;
    @NonNull
    public final cf<VideoData> c;
    @NonNull
    public final is d;
    @NonNull
    public final ir e;
    @NonNull
    public final ii f;
    public final float g;
    public boolean h;

    public interface a {
        void A();

        void B();

        void C();

        void U();

        void a(float f, float f2);

        void ds();

        void dt();

        void onVideoCompleted();

        void onVolumeChanged(float f);
    }

    public class b implements Runnable {
        public final /* synthetic */ int a;

        public b(int i) {
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            em emVar = em.this;
            int i = this.a;
            Objects.requireNonNull(emVar);
            if (i == -2 || i == -1) {
                emVar.dj();
                ae.a("Audiofocus loss, pausing");
            }
        }
    }

    public em(@NonNull cf<VideoData> cfVar, @NonNull fq fqVar, @NonNull a aVar, @NonNull is isVar) {
        this.a = aVar;
        this.b = fqVar;
        this.d = isVar;
        fqVar.setAdVideoViewListener(this);
        this.c = cfVar;
        ir c2 = ir.c(cfVar.getStatHolder());
        this.e = c2;
        this.f = ii.b(cfVar, fqVar.getContext());
        c2.setView(fqVar);
        this.g = cfVar.getDuration();
        isVar.a(this);
        isVar.setVolume(cfVar.isAutoMute() ? 0.0f : 1.0f);
    }

    @NonNull
    public static em a(@NonNull cf<VideoData> cfVar, @NonNull fq fqVar, @NonNull a aVar, @NonNull is isVar) {
        return new em(cfVar, fqVar, aVar, isVar);
    }

    @Override // com.my.target.is.a
    public void A() {
        this.a.A();
    }

    @Override // com.my.target.is.a
    public void B() {
        this.a.B();
    }

    @Override // com.my.target.is.a
    public void C() {
        this.a.C();
    }

    @Override // com.my.target.is.a
    public void D() {
        ae.a("Video playing timeout");
        this.f.eT();
        this.a.U();
        this.d.stop();
        this.d.destroy();
    }

    @Override // com.my.target.fq.a
    public void J() {
        if (this.d instanceof iu) {
            this.b.setViewMode(1);
            this.d.a(this.b);
            VideoData mediaData = this.c.getMediaData();
            if (this.d.isPlaying() && mediaData != null) {
                if (mediaData.getData() != null) {
                    this.h = true;
                }
                b(mediaData);
                return;
            }
            return;
        }
        e("Playback within no hardware accelerated view is available only with ExoPlayer");
    }

    @Override // com.my.target.is.a
    public void a(float f2, float f3) {
        float f4 = this.g;
        if (f2 <= f4) {
            if (f2 != 0.0f) {
                this.a.a(f2, f3);
                this.f.d(f2, f3);
                this.e.p(f2);
            }
            if (f2 == f3) {
                if (this.d.isPlaying()) {
                    onVideoCompleted();
                }
                this.d.stop();
                return;
            }
            return;
        }
        a(f3, f4);
    }

    public final void b(@NonNull VideoData videoData) {
        String str = (String) videoData.getData();
        this.b.d(videoData.getWidth(), videoData.getHeight());
        if (str != null) {
            this.h = true;
            this.d.a(Uri.parse(str), this.b.getContext());
            return;
        }
        this.h = false;
        this.d.a(Uri.parse(videoData.getUrl()), this.b.getContext());
    }

    public final void c(@NonNull Context context) {
        AudioManager audioManager = (AudioManager) context.getApplicationContext().getSystemService("audio");
        if (audioManager != null) {
            audioManager.requestAudioFocus(this, 3, 2);
        }
    }

    @Override // com.my.target.is.a
    public void d(float f2) {
        this.a.onVolumeChanged(f2);
    }

    public void dd() {
        VideoData mediaData = this.c.getMediaData();
        this.f.refresh();
        if (mediaData != null) {
            if (!this.d.isMuted()) {
                c(this.b.getContext());
            }
            this.d.a(this);
            this.d.a(this.b);
            b(mediaData);
        }
    }

    @Override // com.my.target.eh
    public void destroy() {
        dj();
        this.d.destroy();
        this.e.destroy();
    }

    @Override // com.my.target.eh
    public void dj() {
        AudioManager audioManager = (AudioManager) this.b.getContext().getApplicationContext().getSystemService("audio");
        if (audioManager != null) {
            audioManager.abandonAudioFocus(this);
        }
        this.d.pause();
    }

    @Override // com.my.target.eh
    public void dk() {
        this.d.dk();
        this.f.P(!this.d.isMuted());
    }

    @Override // com.my.target.eh
    public void dl() {
        if (this.d.isPlaying()) {
            dj();
            this.f.eP();
        } else if (this.d.getPosition() > 0) {
            resume();
            this.f.trackResume();
        } else {
            dd();
        }
    }

    @Override // com.my.target.eh
    public void dm() {
        this.f.eR();
        destroy();
    }

    @Override // com.my.target.is.a
    public void e(String str) {
        a2.b.a.a.a.U0("Video playing error: ", str);
        this.f.eS();
        if (this.h) {
            ae.a("Try to play video stream from URL");
            this.h = false;
            VideoData mediaData = this.c.getMediaData();
            if (mediaData != null) {
                this.d.a(Uri.parse(mediaData.getUrl()), this.b.getContext());
                return;
            }
        }
        this.a.U();
        this.d.stop();
        this.d.destroy();
    }

    @Override // com.my.target.eh
    public void init() {
        if (this.c.isAutoPlay()) {
            this.a.C();
            dd();
            return;
        }
        this.a.ds();
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public void onAudioFocusChange(int i) {
        if (!(Build.VERSION.SDK_INT >= 23 ? Looper.getMainLooper().isCurrentThread() : Thread.currentThread() == Looper.getMainLooper().getThread())) {
            af.c(new b(i));
        } else if (i == -2 || i == -1) {
            dj();
            ae.a("Audiofocus loss, pausing");
        }
    }

    @Override // com.my.target.is.a
    public void onVideoCompleted() {
        this.a.onVideoCompleted();
        this.d.stop();
    }

    public void resume() {
        this.d.resume();
        if (this.d.isMuted()) {
            AudioManager audioManager = (AudioManager) this.b.getContext().getApplicationContext().getSystemService("audio");
            if (audioManager != null) {
                audioManager.abandonAudioFocus(this);
            }
        } else if (this.d.isPlaying()) {
            c(this.b.getContext());
        }
    }

    @Override // com.my.target.is.a
    public void y() {
    }

    @Override // com.my.target.is.a
    public void z() {
        this.a.dt();
    }
}
