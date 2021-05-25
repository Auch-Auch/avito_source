package com.my.target;

import android.content.Context;
import android.media.AudioManager;
import android.os.Build;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.my.target.en;
import com.my.target.gv;
import java.util.Objects;
public class eg {
    @NonNull
    public final cf a;
    @NonNull
    public final a b;
    @NonNull
    public final gr c;
    @NonNull
    public final ir d;
    @NonNull
    public final ii e;
    public float f;
    public boolean g;
    public boolean h;
    public boolean i;
    @Nullable
    public en.b j;
    public boolean k;
    public boolean l = true;

    public class a implements gv.a {

        /* renamed from: com.my.target.eg$a$a  reason: collision with other inner class name */
        public class RunnableC0306a implements Runnable {
            public final /* synthetic */ int a;

            public RunnableC0306a(int i) {
                this.a = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                eg.b(eg.this, this.a);
            }
        }

        public a() {
        }

        @Override // com.my.target.is.a
        public void A() {
        }

        @Override // com.my.target.is.a
        public void B() {
        }

        @Override // com.my.target.is.a
        public void C() {
        }

        @Override // com.my.target.is.a
        public void D() {
            eg.this.e.eT();
            eg.this.destroy();
            ae.a("Video playing timeout");
            en.b bVar = eg.this.j;
            if (bVar != null) {
                bVar.U();
            }
        }

        @Override // com.my.target.is.a
        public void a(float f, float f2) {
            eg.this.c.setTimeChanged(f);
            eg egVar = eg.this;
            egVar.k = false;
            if (!egVar.i) {
                egVar.i = true;
            }
            if (egVar.h && egVar.a.isAutoPlay() && eg.this.a.getAllowCloseDelay() <= f) {
                eg.this.c.ek();
            }
            eg egVar2 = eg.this;
            float f3 = egVar2.f;
            if (f <= f3) {
                egVar2.d.p(f);
                egVar2.e.d(f, f2);
                if (f == eg.this.f) {
                    onVideoCompleted();
                    return;
                }
                return;
            }
            a(f3, f3);
        }

        @Override // com.my.target.is.a
        public void d(float f) {
            eg.this.c.H(f <= 0.0f);
        }

        @Override // com.my.target.gv.a
        public void de() {
            eg egVar = eg.this;
            if (!egVar.g) {
                egVar.f(egVar.c.getView().getContext());
            }
            eg.c(eg.this);
        }

        public void df() {
            eg egVar = eg.this;
            if (!egVar.g) {
                egVar.e(egVar.c.getView().getContext());
                egVar.c.D(0);
                eg.this.e.P(false);
                eg.this.g = true;
                return;
            }
            egVar.d();
            eg.this.e.P(true);
            eg.this.g = false;
        }

        @Override // com.my.target.gv.a
        public void dg() {
            eg egVar = eg.this;
            egVar.e(egVar.c.getView().getContext());
            eg.this.e.eP();
            eg.this.c.pause();
        }

        @Override // com.my.target.gv.a
        public void dh() {
            eg.this.e.trackResume();
            eg.this.c.resume();
            eg egVar = eg.this;
            if (egVar.g) {
                egVar.e(egVar.c.getView().getContext());
                egVar.c.D(0);
                return;
            }
            egVar.d();
        }

        @Override // com.my.target.gv.a
        public void di() {
            eg.c(eg.this);
        }

        @Override // com.my.target.is.a
        public void e(String str) {
            a2.b.a.a.a.U0("Video playing error: ", str);
            eg.this.e.eS();
            eg egVar = eg.this;
            if (egVar.l) {
                ae.a("Try to play video stream from URL");
                eg egVar2 = eg.this;
                egVar2.l = false;
                eg.c(egVar2);
                return;
            }
            egVar.destroy();
            en.b bVar = eg.this.j;
            if (bVar != null) {
                bVar.U();
            }
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
            if (Build.VERSION.SDK_INT >= 23 ? Looper.getMainLooper().isCurrentThread() : Thread.currentThread() == Looper.getMainLooper().getThread()) {
                eg.b(eg.this, i);
            } else {
                af.c(new RunnableC0306a(i));
            }
        }

        @Override // com.my.target.is.a
        public void onVideoCompleted() {
            eg egVar = eg.this;
            if (!egVar.k) {
                egVar.k = true;
                ae.a("Video playing complete:");
                eg egVar2 = eg.this;
                egVar2.c.ek();
                egVar2.e(egVar2.c.getView().getContext());
                egVar2.c.stop(egVar2.a.isAllowReplay());
                eg egVar3 = eg.this;
                en.b bVar = egVar3.j;
                if (bVar != null) {
                    bVar.r(egVar3.c.getView().getContext());
                }
                eg.this.c.ek();
                eg.this.c.finish();
                eg.this.e.refresh();
            }
        }

        @Override // com.my.target.is.a
        public void y() {
        }

        @Override // com.my.target.is.a
        public void z() {
            eg egVar = eg.this;
            if (egVar.h && egVar.a.getAllowCloseDelay() == 0.0f) {
                eg.this.c.ek();
            }
            eg.this.c.ej();
        }
    }

    public eg(@NonNull cf cfVar, @NonNull gr grVar) {
        this.a = cfVar;
        a aVar = new a();
        this.b = aVar;
        this.c = grVar;
        grVar.setMediaListener(aVar);
        ir c2 = ir.c(cfVar.getStatHolder());
        this.d = c2;
        c2.setView(grVar.getPromoMediaView());
        this.e = ii.b(cfVar, grVar.getPromoMediaView().getContext());
    }

    @NonNull
    public static eg a(@NonNull cf cfVar, @NonNull gr grVar) {
        return new eg(cfVar, grVar);
    }

    public static void b(eg egVar, int i2) {
        Objects.requireNonNull(egVar);
        if (i2 == -3) {
            ae.a("Audiofocus loss can duck, set volume to 0.3");
            if (!egVar.g) {
                egVar.c.D(1);
            }
        } else if (i2 == -2 || i2 == -1) {
            egVar.pause();
            ae.a("Audiofocus loss, pausing");
        } else if (i2 == 1 || i2 == 2 || i2 == 4) {
            ae.a("Audiofocus gain, unmuting");
            if (!egVar.g) {
                egVar.d();
            }
        }
    }

    public static void c(eg egVar) {
        egVar.c.G(egVar.l);
    }

    public void a(ce ceVar) {
        this.c.ek();
        this.c.a(ceVar);
    }

    public void a(@NonNull cf cfVar, @NonNull Context context) {
        bt mediaData = cfVar.getMediaData();
        if (mediaData != null && mediaData.getData() == null) {
            this.l = false;
        }
        boolean isAllowClose = cfVar.isAllowClose();
        this.h = isAllowClose;
        if (isAllowClose && cfVar.getAllowCloseDelay() == 0.0f && cfVar.isAutoPlay()) {
            ae.a("banner is allowed to close");
            this.c.ek();
        }
        this.f = cfVar.getDuration();
        boolean isAutoMute = cfVar.isAutoMute();
        this.g = isAutoMute;
        if (isAutoMute) {
            this.c.D(0);
            return;
        }
        if (cfVar.isAutoPlay()) {
            f(context);
        }
        this.c.D(2);
    }

    public void a(@Nullable en.b bVar) {
        this.j = bVar;
    }

    public final void d() {
        if (this.c.isPlaying()) {
            f(this.c.getView().getContext());
        }
        this.c.D(2);
    }

    public void dc() {
        this.c.stop(true);
        e(this.c.getView().getContext());
        if (this.i) {
            this.e.eR();
        }
    }

    public void destroy() {
        e(this.c.getView().getContext());
        this.c.destroy();
    }

    public final void e(@NonNull Context context) {
        AudioManager audioManager = (AudioManager) context.getApplicationContext().getSystemService("audio");
        if (audioManager != null) {
            audioManager.abandonAudioFocus(this.b);
        }
    }

    public final void f(@NonNull Context context) {
        AudioManager audioManager = (AudioManager) context.getApplicationContext().getSystemService("audio");
        if (audioManager != null) {
            audioManager.requestAudioFocus(this.b, 3, 2);
        }
    }

    public void pause() {
        this.c.pause();
        e(this.c.getView().getContext());
        if (this.c.isPlaying() && !this.c.isPaused()) {
            this.e.eP();
        }
    }

    public void stop() {
        e(this.c.getView().getContext());
    }
}
