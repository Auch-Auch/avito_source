package com.my.target;

import android.content.Context;
import android.media.AudioManager;
import android.net.Uri;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.my.target.common.models.ImageData;
import com.my.target.common.models.VideoData;
import com.my.target.fk;
import com.my.target.fq;
import com.my.target.ge;
import com.my.target.is;
import com.my.target.nativeads.views.MediaAdView;
import java.lang.ref.WeakReference;
public class am implements fk.a, fq.a, ge.d, is.a {
    @NonNull
    public final cf<VideoData> a;
    @NonNull
    public final VideoData b;
    @NonNull
    public final AudioManager.OnAudioFocusChangeListener c;
    @NonNull
    public final cg d;
    public final boolean e;
    @NonNull
    public final ir f;
    @NonNull
    public Uri g;
    @NonNull
    public final ii h;
    @Nullable
    public View.OnClickListener i;
    @Nullable
    public WeakReference<MediaAdView> j;
    @Nullable
    public WeakReference<fk> k;
    @Nullable
    public WeakReference<ge> l;
    @Nullable
    public WeakReference<Context> m;
    public int n;
    public boolean o;
    public boolean p;
    public boolean q;
    public boolean r;
    @Nullable
    public b s;
    @Nullable
    public is t;
    public boolean u;
    public long v;
    public boolean w;
    public boolean x;

    public interface b {
        void R();

        void S();

        void T();

        void U();
    }

    public class c implements AudioManager.OnAudioFocusChangeListener {
        public c(a aVar) {
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
            if (i == -3) {
                am amVar = am.this;
                is isVar = amVar.t;
                if (isVar != null && !amVar.r) {
                    isVar.M();
                }
            } else if (i == -2 || i == -1) {
                am.this.d();
                ae.a("Audiofocus loss, pausing");
            } else if ((i == 1 || i == 2 || i == 4) && am.this.p) {
                ae.a("Audiofocus gain, unmuting");
                is isVar2 = am.this.t;
                if (isVar2 != null) {
                    isVar2.da();
                }
            }
        }
    }

    public am(@NonNull cg cgVar, @NonNull cf<VideoData> cfVar, @NonNull VideoData videoData, boolean z) {
        this.a = cfVar;
        this.d = cgVar;
        this.e = z;
        this.b = videoData;
        String str = (String) videoData.getData();
        this.g = Uri.parse(str == null ? videoData.getUrl() : str);
        this.o = cfVar.isAutoPlay();
        this.r = cfVar.isAutoMute();
        this.f = ir.c(cfVar.getStatHolder());
        this.h = ii.h(cfVar);
        this.c = new c(null);
    }

    @Override // com.my.target.is.a
    public void A() {
        Context context;
        MediaAdView a3 = a();
        if (a3 != null) {
            context = a3.getContext();
            if (!this.w) {
                a3.getPlayButtonView().setVisibility(0);
            }
            a3.getProgressBarView().setVisibility(8);
        } else {
            context = null;
        }
        d();
        if (a3 != null) {
            g(context);
        }
        b bVar = this.s;
        if (bVar != null) {
            bVar.S();
        }
    }

    @Override // com.my.target.is.a
    public void B() {
    }

    @Override // com.my.target.is.a
    public void C() {
        WeakReference<ge> weakReference;
        ge geVar;
        this.n = 4;
        MediaAdView a3 = a();
        if (a3 != null) {
            if (!this.w) {
                a3.getProgressBarView().setVisibility(0);
            }
            a3.getPlayButtonView().setVisibility(8);
        }
        if (this.p && (weakReference = this.l) != null && (geVar = weakReference.get()) != null) {
            geVar.dY();
        }
    }

    @Override // com.my.target.is.a
    public void D() {
        this.h.eT();
        b bVar = this.s;
        if (bVar != null) {
            bVar.U();
        }
    }

    @Override // com.my.target.ge.d
    public void E() {
        fk fkVar;
        WeakReference<fk> weakReference = this.k;
        if (!(weakReference == null || (fkVar = weakReference.get()) == null)) {
            fkVar.getContext();
            e();
            this.h.trackResume();
        }
        b bVar = this.s;
        if (bVar != null) {
            bVar.R();
        }
    }

    @Override // com.my.target.ge.d
    public void F() {
        ge geVar;
        e();
        WeakReference<ge> weakReference = this.l;
        if (!(weakReference == null || (geVar = weakReference.get()) == null)) {
            geVar.eb();
        }
        b bVar = this.s;
        if (bVar != null) {
            bVar.R();
        }
    }

    @Override // com.my.target.ge.d
    public void G() {
        if (this.n == 1) {
            d();
            this.n = 2;
            b bVar = this.s;
            if (bVar != null) {
                bVar.S();
            }
            WeakReference<fk> weakReference = this.k;
            if (weakReference != null && weakReference.get() != null) {
                this.h.eP();
            }
        }
    }

    @Override // com.my.target.ge.d
    public void H() {
        WeakReference<fk> weakReference = this.k;
        fk fkVar = weakReference == null ? null : weakReference.get();
        if (fkVar != null && fkVar.isShowing()) {
            fkVar.dismiss();
        }
    }

    @Override // com.my.target.ge.d
    public void I() {
        is isVar = this.t;
        if (isVar == null) {
            this.r = !this.r;
        } else if (isVar.isMuted()) {
            this.t.da();
            this.h.P(true);
            this.r = false;
        } else {
            this.t.N();
            this.h.P(false);
            this.r = true;
        }
    }

    @Override // com.my.target.fq.a
    public void J() {
        ae.a("Native Ad Views without hardware acceleration is not currently supported");
        b bVar = this.s;
        if (bVar != null) {
            bVar.U();
        }
    }

    @Nullable
    public final MediaAdView a() {
        WeakReference<MediaAdView> weakReference = this.j;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // com.my.target.is.a
    public void a(float f2, float f3) {
        is isVar;
        is isVar2;
        ge geVar;
        z();
        this.f.p(f2);
        this.h.d(f2, f3);
        if (!this.q) {
            b bVar = this.s;
            if (bVar != null) {
                bVar.R();
            }
            this.q = true;
        }
        float duration = this.a.getDuration();
        WeakReference<ge> weakReference = this.l;
        if (!(weakReference == null || (geVar = weakReference.get()) == null)) {
            geVar.a(f2, duration);
        }
        if (f2 <= duration) {
            if (f2 > 0.0f && (isVar2 = this.t) != null) {
                this.v = isVar2.getPosition();
            }
            if (f2 == duration && (isVar = this.t) != null) {
                if (this.x) {
                    isVar.fl();
                    return;
                }
                y();
                this.n = 3;
                this.o = false;
                this.t.stop();
                b bVar2 = this.s;
                if (bVar2 != null) {
                    bVar2.T();
                }
                this.h.refresh();
                return;
            }
            return;
        }
        a(duration, duration);
    }

    @Override // com.my.target.fk.a
    public void a(@NonNull fk fkVar, @NonNull FrameLayout frameLayout) {
        ge geVar = new ge(frameLayout.getContext());
        this.n = 4;
        this.k = new WeakReference<>(fkVar);
        geVar.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        frameLayout.addView(geVar);
        this.l = new WeakReference<>(geVar);
        geVar.a(this.d, this.b);
        geVar.setVideoDialogViewListener(this);
        geVar.E(this.r);
        this.h.trackFullscreen(true);
        f(geVar.getAdVideoView(), this.r);
    }

    public void a(@NonNull MediaAdView mediaAdView, @Nullable Context context) {
        fq fqVar;
        WeakReference<Context> weakReference;
        ae.a("register video ad with view " + mediaAdView);
        if (!this.p) {
            WeakReference<MediaAdView> weakReference2 = this.j;
            if (weakReference2 == null || weakReference2.get() != mediaAdView || (weakReference = this.m) == null || weakReference.get() != context || !(mediaAdView.getChildAt(1) instanceof fq)) {
                unregister();
                this.h.setContext(context);
                this.j = new WeakReference<>(mediaAdView);
                this.m = new WeakReference<>(context);
                fq fqVar2 = new fq(mediaAdView.getContext().getApplicationContext());
                mediaAdView.addView(fqVar2, 1);
                fqVar = fqVar2;
            } else {
                fqVar = (fq) mediaAdView.getChildAt(1);
            }
            fqVar.setAdVideoViewListener(this);
            this.f.setView(fqVar);
            if (this.o) {
                C();
            } else {
                y();
            }
        }
    }

    @Override // com.my.target.fk.a
    public void a(boolean z) {
        is isVar = this.t;
        if (isVar != null && !z) {
            this.v = isVar.getPosition();
            b();
            A();
        }
    }

    public final void b() {
        is isVar = this.t;
        if (isVar != null) {
            isVar.a((is.a) null);
            this.t.destroy();
            this.t = null;
        }
    }

    @Override // com.my.target.ge.d
    public void b(View view) {
        if (this.n == 1) {
            is isVar = this.t;
            if (isVar != null) {
                isVar.pause();
            }
            A();
        }
        View.OnClickListener onClickListener = this.i;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    public final void c() {
        is isVar = this.t;
        if (isVar != null) {
            isVar.N();
        }
    }

    public final void d() {
        WeakReference<ge> weakReference;
        if (this.p && (weakReference = this.l) != null) {
            this.n = 2;
            ge geVar = weakReference.get();
            if (geVar != null) {
                is isVar = this.t;
                if (isVar != null) {
                    isVar.pause();
                }
                geVar.dZ();
            }
        }
    }

    @Override // com.my.target.is.a
    public void d(float f2) {
        ge geVar;
        WeakReference<ge> weakReference = this.l;
        if (weakReference != null && (geVar = weakReference.get()) != null) {
            geVar.E(f2 <= 0.0f);
        }
    }

    public final void e() {
        WeakReference<ge> weakReference;
        WeakReference<ge> weakReference2;
        is isVar = this.t;
        if (isVar != null && isVar.isPaused()) {
            MediaAdView a3 = a();
            if (a3 == null) {
                ae.a("Trying to play video in unregistered view");
                b();
                return;
            }
            fq fqVar = null;
            if (this.p && (weakReference2 = this.l) != null) {
                fqVar = weakReference2.get().getAdVideoView();
            } else if (a3.getChildAt(1) instanceof fq) {
                fqVar = (fq) a3.getChildAt(1);
            }
            if (fqVar == null) {
                b();
                return;
            }
            fqVar.d(this.b.getWidth(), this.b.getHeight());
            this.t.a(fqVar);
            this.t.resume();
        } else if (this.p && (weakReference = this.l) != null) {
            f(weakReference.get().getAdVideoView(), this.r);
        }
        C();
    }

    @Override // com.my.target.is.a
    public void e(String str) {
        this.h.eS();
        VideoData mediaData = this.a.getMediaData();
        if (mediaData == null || !this.g.toString().equals(mediaData.getData())) {
            b bVar = this.s;
            if (bVar != null) {
                bVar.U();
                return;
            }
            return;
        }
        ae.a("Try to play video stream from URL");
        this.g = Uri.parse(mediaData.getUrl());
        WeakReference<Context> weakReference = this.m;
        Context context = weakReference != null ? weakReference.get() : null;
        is isVar = this.t;
        if (isVar != null && context != null) {
            isVar.a(this.g, context);
        }
    }

    public final void f(@NonNull fq fqVar, boolean z) {
        if (this.t == null) {
            is ah = this.e ? iu.ah(fqVar.getContext()) : it.fm();
            this.t = ah;
            ah.a(this);
        }
        if (z) {
            c();
        } else {
            is isVar = this.t;
            if (isVar != null) {
                isVar.da();
            }
        }
        this.t.a(fqVar);
        fqVar.d(this.b.getWidth(), this.b.getHeight());
        if (!this.t.isPlaying()) {
            this.t.a(this.g, fqVar.getContext());
            long j2 = this.v;
            if (j2 > 0) {
                this.t.seekTo(j2);
                return;
            }
            return;
        }
        z();
    }

    public final void g(@NonNull Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (audioManager != null) {
            audioManager.abandonAudioFocus(this.c);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0038, code lost:
        if ((r2 instanceof com.my.target.fq) != false) goto L_0x003a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005b, code lost:
        if ((r2 instanceof com.my.target.fq) != false) goto L_0x003a;
     */
    @Override // com.my.target.fk.a
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void o() {
        /*
            r7 = this;
            java.lang.String r0 = "Dismiss dialog"
            com.my.target.ae.a(r0)
            r0 = 0
            r7.k = r0
            r1 = 0
            r7.p = r1
            r7.c()
            com.my.target.nativeads.views.MediaAdView r2 = r7.a()
            if (r2 != 0) goto L_0x0015
            return
        L_0x0015:
            android.content.Context r3 = r2.getContext()
            r7.g(r3)
            int r3 = r7.n
            r4 = 4
            r5 = 1
            if (r3 == r5) goto L_0x0046
            r6 = 2
            if (r3 == r6) goto L_0x0040
            r6 = 3
            if (r3 == r6) goto L_0x0040
            if (r3 == r4) goto L_0x002d
            r7.o = r1
            goto L_0x005e
        L_0x002d:
            r7.o = r5
            r7.C()
            android.view.View r2 = r2.getChildAt(r5)
            boolean r3 = r2 instanceof com.my.target.fq
            if (r3 == 0) goto L_0x005e
        L_0x003a:
            com.my.target.fq r2 = (com.my.target.fq) r2
            r7.f(r2, r5)
            goto L_0x005e
        L_0x0040:
            r7.o = r1
            r7.y()
            goto L_0x005e
        L_0x0046:
            r7.n = r4
            r7.z()
            com.my.target.cf<com.my.target.common.models.VideoData> r3 = r7.a
            boolean r3 = r3.isAutoPlay()
            if (r3 == 0) goto L_0x0055
            r7.o = r5
        L_0x0055:
            android.view.View r2 = r2.getChildAt(r5)
            boolean r3 = r2 instanceof com.my.target.fq
            if (r3 == 0) goto L_0x005e
            goto L_0x003a
        L_0x005e:
            com.my.target.ii r2 = r7.h
            r2.trackFullscreen(r1)
            r7.l = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.my.target.am.o():void");
    }

    @Override // com.my.target.is.a
    public void onVideoCompleted() {
        MediaAdView a3 = a();
        if (a3 != null) {
            a3.getProgressBarView().setVisibility(8);
            if (!this.w) {
                a3.getPlayButtonView().setVisibility(0);
            }
        }
        this.v = 0;
    }

    public void unregister() {
        MediaAdView mediaAdView;
        x();
        this.f.setView(null);
        this.h.setContext(null);
        b();
        WeakReference<MediaAdView> weakReference = this.j;
        if (weakReference != null && (mediaAdView = weakReference.get()) != null && (mediaAdView.getChildAt(1) instanceof fq)) {
            mediaAdView.removeViewAt(1);
        }
    }

    public void w() {
        MediaAdView a3 = a();
        if (a3 == null) {
            ae.a("Trying to play video in unregistered view");
            b();
        } else if (a3.getWindowVisibility() != 0) {
            if (this.n == 1) {
                is isVar = this.t;
                if (isVar != null) {
                    this.v = isVar.getPosition();
                }
                b();
                this.n = 4;
                this.u = false;
                C();
                return;
            }
            b();
        } else if (!this.u) {
            WeakReference<Context> weakReference = this.m;
            fq fqVar = null;
            Context context = weakReference != null ? weakReference.get() : null;
            if (context != null) {
                a(a3, context);
            }
            this.u = true;
            if (a3.getChildAt(1) instanceof fq) {
                fqVar = (fq) a3.getChildAt(1);
            }
            if (fqVar == null) {
                b();
                return;
            }
            is isVar2 = this.t;
            if (isVar2 != null && !this.g.equals(isVar2.getUri())) {
                b();
            }
            if (!this.o) {
                if (!this.w) {
                    a3.getPlayButtonView().setVisibility(0);
                }
                a3.getProgressBarView().setVisibility(8);
            }
            if (this.o && !this.p) {
                is isVar3 = this.t;
                if (isVar3 == null || !isVar3.isPaused()) {
                    f(fqVar, true);
                } else {
                    this.t.a(fqVar);
                    fqVar.d(this.b.getWidth(), this.b.getHeight());
                    this.t.a(this);
                    this.t.resume();
                }
                c();
            }
        }
    }

    public void x() {
        is isVar;
        if (this.u && !this.p) {
            this.u = false;
            if (this.n == 1 && (isVar = this.t) != null) {
                isVar.pause();
                this.n = 2;
            }
            is isVar2 = this.t;
            if (isVar2 != null) {
                isVar2.a((is.a) null);
                this.t.a((fq) null);
            }
        }
    }

    @Override // com.my.target.is.a
    public void y() {
        Context context;
        WeakReference<ge> weakReference;
        ge geVar;
        this.q = false;
        this.v = 0;
        MediaAdView a3 = a();
        if (a3 != null) {
            ImageView imageView = a3.getImageView();
            ImageData image = this.a.getImage();
            if (image != null) {
                imageView.setImageBitmap(image.getBitmap());
            }
            imageView.setVisibility(0);
            if (!this.w) {
                a3.getPlayButtonView().setVisibility(0);
            }
            a3.getProgressBarView().setVisibility(8);
            context = a3.getContext();
        } else {
            context = null;
        }
        if (!(!this.p || (weakReference = this.l) == null || (geVar = weakReference.get()) == null)) {
            geVar.dX();
            context = geVar.getContext();
        }
        if (context != null) {
            g(context);
        }
    }

    @Override // com.my.target.is.a
    public void z() {
        WeakReference<ge> weakReference;
        ge geVar;
        if (this.n != 1) {
            this.n = 1;
            MediaAdView a3 = a();
            if (a3 != null) {
                a3.getProgressBarView().setVisibility(8);
                a3.getPlayButtonView().setVisibility(8);
            }
            if (this.p && (weakReference = this.l) != null && (geVar = weakReference.get()) != null) {
                if (this.t != null) {
                    fq adVideoView = geVar.getAdVideoView();
                    adVideoView.d(this.b.getWidth(), this.b.getHeight());
                    this.t.a(adVideoView);
                }
                geVar.ea();
            }
        }
    }
}
