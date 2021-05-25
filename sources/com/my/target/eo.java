package com.my.target;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.my.target.common.models.ImageData;
import com.my.target.common.models.VideoData;
import com.my.target.ej;
import com.my.target.em;
import com.my.target.eq;
import com.my.target.hf;
import com.my.target.hj;
import java.util.List;
public class eo implements ej, em.a, eq.a, hf.a, hj.a {
    @NonNull
    public final ce a;
    @NonNull
    public final b b;
    @NonNull
    public final hj c;
    @NonNull
    public final d d;
    @NonNull
    public final hh e;
    @NonNull
    public final Handler f;
    @Nullable
    public eh g;
    @NonNull
    public c h;
    public long i;
    public long j;
    public boolean k;
    public boolean l;
    @NonNull
    public final Runnable m = new a();

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            eo eoVar = eo.this;
            if (eoVar.k) {
                eoVar.f();
                eoVar.c.O(false);
                eoVar.c.ev();
                eoVar.k = false;
            }
        }
    }

    public interface b extends ej.a {
        void U();

        void r(@NonNull Context context);
    }

    public enum c {
        DISABLED,
        RULED_BY_POST,
        RULED_BY_VIDEO
    }

    public static class d implements Runnable {
        @NonNull
        public final eo a;

        public d(@NonNull eo eoVar) {
            this.a = eoVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            eo eoVar = this.a;
            c cVar = eoVar.h;
            boolean z = true;
            if (cVar != c.DISABLED) {
                if (cVar == c.RULED_BY_POST) {
                    eoVar.i -= 200;
                }
                if (eoVar.i > 0) {
                    z = false;
                }
            }
            if (z) {
                eoVar.e();
            } else {
                eoVar.b();
            }
        }
    }

    public eo(@NonNull he heVar, @NonNull ce ceVar, @NonNull b bVar) {
        c cVar;
        c cVar2 = c.DISABLED;
        this.h = cVar2;
        this.a = ceVar;
        this.b = bVar;
        this.f = heVar.et();
        hh eq = heVar.eq();
        this.e = eq;
        eq.setColor(ceVar.getPromoStyleSettings().by());
        hf a3 = heVar.a(this);
        a3.setBanner(ceVar);
        cf<VideoData> videoBanner = ceVar.getVideoBanner();
        List<cb> interstitialAdCards = ceVar.getInterstitialAdCards();
        if (!interstitialAdCards.isEmpty()) {
            hv er = heVar.er();
            heVar.a(er, interstitialAdCards, this);
            this.c = heVar.a(ceVar, a3.eu(), eq.eu(), er, this);
        } else if (videoBanner != null) {
            fq ep = heVar.ep();
            hj a4 = heVar.a(ceVar, a3.eu(), eq.eu(), ep, this);
            this.c = a4;
            ep.d(videoBanner.getWidth(), videoBanner.getHeight());
            this.g = heVar.a(videoBanner, ep, this);
            eq.setMaxTime(videoBanner.getDuration());
            ImageData preview = videoBanner.getPreview();
            a4.setBackgroundImage(preview == null ? ceVar.getImage() : preview);
        } else {
            hj a5 = heVar.a(ceVar, a3.eu(), eq.eu(), null, this);
            this.c = a5;
            a5.ev();
            a5.setBackgroundImage(ceVar.getImage());
        }
        this.c.setBanner(ceVar);
        this.d = new d(this);
        cf<VideoData> videoBanner2 = ceVar.getVideoBanner();
        if (videoBanner2 != null && videoBanner2.isAutoPlay()) {
            if (videoBanner2.isAllowClose()) {
                long allowCloseDelay = (long) (videoBanner2.getAllowCloseDelay() * 1000.0f);
                this.j = allowCloseDelay;
                this.i = allowCloseDelay;
                cVar = allowCloseDelay > 0 ? c.RULED_BY_VIDEO : cVar;
                e();
                bVar.a(ceVar, this.c.eu());
            }
            this.c.ew();
            bVar.a(ceVar, this.c.eu());
        } else if (ceVar.isAllowClose()) {
            long allowCloseDelay2 = (long) (ceVar.getAllowCloseDelay() * 1000.0f);
            this.j = allowCloseDelay2;
            this.i = allowCloseDelay2;
            if (allowCloseDelay2 > 0) {
                StringBuilder L = a2.b.a.a.a.L("banner will be allowed to close in ");
                L.append(this.i);
                L.append(" millis");
                ae.a(L.toString());
                cVar = c.RULED_BY_POST;
            } else {
                ae.a("banner is allowed to close");
                e();
                bVar.a(ceVar, this.c.eu());
            }
        } else {
            this.h = cVar2;
            this.c.ew();
            bVar.a(ceVar, this.c.eu());
        }
        this.h = cVar;
        b();
        bVar.a(ceVar, this.c.eu());
    }

    public static eo a(@NonNull he heVar, @NonNull ce ceVar, @NonNull b bVar) {
        return new eo(heVar, ceVar, bVar);
    }

    @Override // com.my.target.em.a
    public void A() {
        this.c.O(true);
        this.c.a(0, (String) null);
        this.c.N(false);
    }

    @Override // com.my.target.em.a
    public void B() {
        this.c.O(false);
        this.c.M(false);
        this.c.ev();
        this.c.N(false);
    }

    @Override // com.my.target.em.a
    public void C() {
        this.c.O(true);
        this.c.ev();
        this.c.M(false);
        this.c.N(true);
        this.e.setVisible(true);
    }

    @Override // com.my.target.em.a
    public void U() {
        this.b.U();
        this.c.O(false);
        this.c.M(true);
        this.c.ev();
        this.c.N(false);
        this.c.ex();
        this.e.setVisible(false);
        e();
    }

    @Override // com.my.target.em.a
    public void a(float f2, float f3) {
        if (this.h == c.RULED_BY_VIDEO) {
            this.i = (long) (((float) this.j) - (1000.0f * f2));
        }
        this.e.setTimeChanged(f2);
    }

    public final void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                Context context = this.c.eu().getContext();
                if (!(context instanceof Activity)) {
                    intent.addFlags(268435456);
                }
                context.startActivity(intent);
            } catch (Throwable th) {
                ae.a(th.getMessage());
            }
        }
    }

    public final void b() {
        this.f.removeCallbacks(this.d);
        this.f.postDelayed(this.d, 200);
        long j2 = this.j;
        long j3 = this.i;
        this.c.a((int) ((j3 / 1000) + 1), (((float) j2) - ((float) j3)) / ((float) j2));
    }

    @Override // com.my.target.eq.a, com.my.target.hf.a, com.my.target.hj.a
    public void c(@Nullable by byVar) {
        if (byVar != null) {
            this.b.b(byVar, null, cZ().getContext());
        } else {
            this.b.b(this.a, null, cZ().getContext());
        }
    }

    @Override // com.my.target.ej
    @NonNull
    public View cZ() {
        return this.c.eu();
    }

    @Override // com.my.target.eq.a
    public void d(@NonNull by byVar) {
        im.a(byVar.getStatHolder().K("playbackStarted"), this.c.eu().getContext());
        im.a(byVar.getStatHolder().K("show"), this.c.eu().getContext());
    }

    @Override // com.my.target.hj.a
    public void dA() {
        eh ehVar = this.g;
        if (ehVar != null) {
            ehVar.dm();
        }
        f();
        this.b.p();
    }

    @Override // com.my.target.hf.a, com.my.target.hj.a
    public void dB() {
        f();
        a(this.a.getAdIconClickLink());
    }

    @Override // com.my.target.hj.a
    public void dC() {
        f();
        bo adChoices = this.a.getAdChoices();
        if (adChoices != null) {
            a(adChoices.aW());
        }
    }

    @Override // com.my.target.hj.a
    public void dD() {
        if (!this.l) {
            this.c.O(true);
            this.c.a(1, (String) null);
            this.c.N(false);
            f();
            this.f.postDelayed(this.m, 4000);
            this.k = true;
        } else if (this.a.getClickArea().dN) {
            c(null);
        }
    }

    @Override // com.my.target.hj.a
    public void dE() {
        boolean z = this.k;
        if (z && z) {
            f();
            this.c.O(false);
            this.c.ev();
            this.k = false;
        }
    }

    @Override // com.my.target.ej
    public void destroy() {
        eh ehVar = this.g;
        if (ehVar != null) {
            ehVar.destroy();
        }
        f();
    }

    @Override // com.my.target.hj.a
    public void df() {
        eh ehVar = this.g;
        if (ehVar != null) {
            ehVar.dk();
        }
    }

    @Override // com.my.target.em.a
    public void ds() {
        this.c.O(true);
        this.c.a(0, (String) null);
        this.c.N(false);
        this.e.setVisible(false);
    }

    @Override // com.my.target.em.a
    public void dt() {
        this.c.O(false);
        this.c.M(false);
        this.c.ev();
        this.c.N(false);
        this.e.setVisible(true);
    }

    public final void e() {
        this.c.dG();
        this.f.removeCallbacks(this.d);
        this.h = c.DISABLED;
    }

    @Override // com.my.target.eq.a
    public void e(@NonNull by byVar) {
        im.a(byVar.getStatHolder().K("render"), this.c.eu().getContext());
    }

    public final void f() {
        this.k = false;
        this.f.removeCallbacks(this.m);
    }

    @Override // com.my.target.em.a
    public void onVideoCompleted() {
        cf<VideoData> videoBanner = this.a.getVideoBanner();
        if (videoBanner != null) {
            if (videoBanner.isAllowReplay()) {
                this.c.a(2, !TextUtils.isEmpty(videoBanner.getReplayActionText()) ? videoBanner.getReplayActionText() : null);
                this.c.O(true);
            } else {
                this.l = true;
            }
        }
        this.c.M(true);
        this.c.N(false);
        this.e.setVisible(false);
        this.e.setTimeChanged(0.0f);
        this.b.r(this.c.eu().getContext());
        e();
    }

    @Override // com.my.target.em.a
    public void onVolumeChanged(float f2) {
        this.c.setSoundState(f2 != 0.0f);
    }

    @Override // com.my.target.ej
    public void pause() {
        eh ehVar = this.g;
        if (ehVar != null) {
            ehVar.dj();
        }
        this.f.removeCallbacks(this.d);
        f();
    }

    @Override // com.my.target.ej
    public void resume() {
        if (this.h != c.DISABLED && this.i > 0) {
            b();
        }
        f();
    }

    public void start() {
        eh ehVar = this.g;
        if (ehVar != null) {
            ehVar.init();
        }
    }

    @Override // com.my.target.ej
    public void stop() {
        eh ehVar = this.g;
        if (ehVar != null) {
            ehVar.dj();
        }
        f();
    }

    @Override // com.my.target.hj.a
    public void y(int i2) {
        eh ehVar = this.g;
        if (ehVar != null) {
            ehVar.dl();
        }
        f();
    }

    @Override // com.my.target.hj.a
    public void y(boolean z) {
        bu promoStyleSettings = this.a.getPromoStyleSettings();
        int bx = promoStyleSettings.bx();
        int argb = Color.argb((int) (promoStyleSettings.bz() * 255.0f), Color.red(bx), Color.green(bx), Color.blue(bx));
        hj hjVar = this.c;
        if (z) {
            bx = argb;
        }
        hjVar.setPanelColor(bx);
    }
}
