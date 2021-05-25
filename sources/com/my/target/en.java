package com.my.target;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.my.target.common.models.VideoData;
import com.my.target.ej;
import com.my.target.gs;
import java.util.List;
public class en implements ej {
    @NonNull
    public final ce a;
    @NonNull
    public final d b;
    @NonNull
    public final gs c;
    @NonNull
    public final Handler d;
    @Nullable
    public gr e;
    @Nullable
    public hb f;
    @Nullable
    public ed g;
    @Nullable
    public eg h;
    public long i;
    public long j;
    @NonNull
    public final b k;

    public static class a implements View.OnClickListener {
        public en a;

        public a(en enVar) {
            this.a = enVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            eg egVar = this.a.h;
            if (egVar != null) {
                egVar.dc();
            }
            this.a.du().p();
        }
    }

    public interface b extends ej.a {
        @Override // com.my.target.eo.b
        void U();

        @Override // com.my.target.eo.b
        void r(@NonNull Context context);
    }

    public static class c implements gs.a {
        @NonNull
        public final en a;

        public c(@NonNull en enVar) {
            this.a = enVar;
        }

        @Override // com.my.target.gs.a
        public void dy() {
            this.a.du().b(this.a.dw(), null, this.a.cZ().getContext());
        }
    }

    public static class d implements Runnable {
        @NonNull
        public final gs a;

        public d(@NonNull gs gsVar) {
            this.a = gsVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            ae.a("banner became just closeable");
            this.a.ek();
        }
    }

    public en(@NonNull ce ceVar, boolean z, @NonNull b bVar, @NonNull Context context) {
        hb hbVar;
        this.a = ceVar;
        this.k = bVar;
        Handler handler = new Handler(Looper.getMainLooper());
        this.d = handler;
        c cVar = new c(this);
        cf<VideoData> videoBanner = ceVar.getVideoBanner();
        if (!ceVar.getInterstitialAdCards().isEmpty()) {
            hb hbVar2 = new hb(context);
            this.f = hbVar2;
            this.c = hbVar2;
        } else {
            gr guVar = (videoBanner == null || ceVar.getStyle() != 1) ? new gu(context, z) : new gw(context, z);
            this.e = guVar;
            this.c = guVar;
        }
        gs gsVar = this.c;
        d dVar = new d(gsVar);
        this.b = dVar;
        gsVar.setInterstitialPromoViewListener(cVar);
        this.c.getCloseButton().setOnClickListener(new a(this));
        gr grVar = this.e;
        if (!(grVar == null || videoBanner == null)) {
            eg a3 = eg.a(videoBanner, grVar);
            this.h = a3;
            a3.a(videoBanner, context);
            if (videoBanner.isAutoPlay()) {
                this.j = 0;
            }
        }
        this.c.setBanner(ceVar);
        this.c.setClickArea(ceVar.getClickArea());
        if (videoBanner == null || !videoBanner.isAutoPlay()) {
            long allowCloseDelay = (long) (ceVar.getAllowCloseDelay() * 1000.0f);
            this.i = allowCloseDelay;
            if (allowCloseDelay > 0) {
                StringBuilder L = a2.b.a.a.a.L("banner will be allowed to close in ");
                L.append(this.i);
                L.append(" millis");
                ae.a(L.toString());
                long j2 = this.i;
                handler.removeCallbacks(dVar);
                this.j = System.currentTimeMillis();
                handler.postDelayed(dVar, j2);
            } else {
                ae.a("banner is allowed to close");
                this.c.ek();
            }
        }
        List<cb> interstitialAdCards = ceVar.getInterstitialAdCards();
        if (!interstitialAdCards.isEmpty() && (hbVar = this.f) != null) {
            this.g = ed.a(interstitialAdCards, hbVar);
        }
        eg egVar = this.h;
        if (egVar != null) {
            egVar.a(bVar);
        }
        ed edVar = this.g;
        if (edVar != null) {
            edVar.a(bVar);
        }
        bVar.a(ceVar, this.c.getView());
    }

    @NonNull
    public static en a(@NonNull ce ceVar, boolean z, @NonNull b bVar, @NonNull Context context) {
        return new en(ceVar, z, bVar, context);
    }

    @Override // com.my.target.ej
    @NonNull
    public View cZ() {
        return this.c.getView();
    }

    @Override // com.my.target.ej
    public void destroy() {
        this.d.removeCallbacks(this.b);
        eg egVar = this.h;
        if (egVar != null) {
            egVar.destroy();
        }
    }

    @NonNull
    public b du() {
        return this.k;
    }

    @NonNull
    public ce dw() {
        return this.a;
    }

    public void dx() {
        eg egVar = this.h;
        if (egVar != null) {
            egVar.a(this.a);
        }
    }

    @Override // com.my.target.ej
    public void pause() {
        eg egVar = this.h;
        if (egVar != null) {
            egVar.pause();
        }
        this.d.removeCallbacks(this.b);
        if (this.j > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.j;
            if (currentTimeMillis > 0) {
                long j2 = this.i;
                if (currentTimeMillis < j2) {
                    this.i = j2 - currentTimeMillis;
                    return;
                }
            }
            this.i = 0;
        }
    }

    @Override // com.my.target.ej
    public void resume() {
        if (this.h == null) {
            long j2 = this.i;
            if (j2 > 0) {
                this.d.removeCallbacks(this.b);
                this.j = System.currentTimeMillis();
                this.d.postDelayed(this.b, j2);
            }
        }
    }

    @Override // com.my.target.ej
    public void stop() {
        eg egVar = this.h;
        if (egVar != null) {
            egVar.stop();
        }
    }
}
