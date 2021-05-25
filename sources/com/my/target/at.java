package com.my.target;

import a2.l.a.g;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.my.target.aj;
import com.my.target.common.models.VideoData;
import com.my.target.f;
import com.my.target.instreamads.InstreamAd;
import com.my.target.instreamads.InstreamAdPlayer;
import com.yandex.mobile.ads.video.models.vmap.AdBreak;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
public class at {
    @NonNull
    public final InstreamAd a;
    @NonNull
    public final co b;
    @NonNull
    public final a c;
    @NonNull
    public final aj d;
    @NonNull
    public final hx e;
    @Nullable
    public cr<VideoData> f;
    @Nullable
    public cf<VideoData> g;
    @Nullable
    public InstreamAd.InstreamAdBanner h;
    @Nullable
    public List<cf<VideoData>> i;
    @NonNull
    public float[] j = new float[0];
    public float k;
    public int l;
    public int m;
    public int n;

    public class a implements f.b {
        public final /* synthetic */ cr a;
        public final /* synthetic */ float b;

        public a(cr crVar, float f) {
            this.a = crVar;
            this.b = f;
        }

        @Override // com.my.target.b.AbstractC0305b
        public void onResult(@Nullable cn cnVar, @Nullable String str) {
            co coVar = (co) cnVar;
            at atVar = at.this;
            cr<VideoData> crVar = this.a;
            float f = this.b;
            Objects.requireNonNull(atVar);
            if (coVar == null) {
                if (str != null) {
                    a2.b.a.a.a.U0("loading midpoint services failed: ", str);
                }
                if (crVar == atVar.f && f == atVar.k) {
                    atVar.g(crVar, f);
                    return;
                }
                return;
            }
            cr<VideoData> v = coVar.v(crVar.getName());
            if (v != null) {
                crVar.b(v);
            }
            if (crVar == atVar.f && f == atVar.k) {
                atVar.d(crVar, f);
            }
        }
    }

    public at(@NonNull InstreamAd instreamAd, @NonNull co coVar, @NonNull a aVar) {
        this.a = instreamAd;
        this.b = coVar;
        this.c = aVar;
        aj u = aj.u();
        this.d = u;
        u.a(new b(null));
        this.e = hx.eC();
    }

    @NonNull
    public static at a(@NonNull InstreamAd instreamAd, @NonNull co coVar, @NonNull a aVar) {
        return new at(instreamAd, coVar, aVar);
    }

    public void a(@NonNull float[] fArr) {
        this.j = fArr;
    }

    public final void b(@Nullable cf cfVar, @NonNull String str) {
        if (cfVar == null) {
            ae.a("can't send stat: banner is null");
            return;
        }
        Context context = this.d.getContext();
        if (context == null) {
            ae.a("can't send stat: context is null");
        } else {
            im.a(cfVar.getStatHolder().K(str), context);
        }
    }

    public final void c(@NonNull cr crVar) {
        if (crVar == this.f) {
            if (AdBreak.BreakId.MIDROLL.equals(crVar.getName())) {
                this.f.t(this.n);
            }
            this.f = null;
            this.g = null;
            this.h = null;
            this.m = -1;
            InstreamAd.InstreamAdListener listener = this.a.getListener();
            if (listener != null) {
                listener.onComplete(crVar.getName(), this.a);
            }
        }
    }

    public final void d(@NonNull cr<VideoData> crVar, float f2) {
        ArrayList arrayList = new ArrayList();
        for (cf<VideoData> cfVar : crVar.ca()) {
            if (cfVar.getPoint() == f2) {
                arrayList.add(cfVar);
            }
        }
        int size = arrayList.size();
        if (size <= 0 || this.m >= size - 1) {
            ArrayList<bp> j2 = crVar.j(f2);
            if (j2.size() > 0) {
                e(j2, crVar, f2);
                return;
            }
            ae.a("There is no one midpoint service for point: " + f2);
            g(crVar, f2);
            return;
        }
        this.i = arrayList;
        f();
    }

    public void destroy() {
        this.d.destroy();
    }

    public void e(int i2) {
        this.l = i2;
    }

    public final void e(@NonNull ArrayList<bp> arrayList, @NonNull cr<VideoData> crVar, float f2) {
        Context context = this.d.getContext();
        if (context == null) {
            ae.a("can't load midpoint services: context is null");
            return;
        }
        ae.a("loading midpoint services for point: " + f2);
        f.a(arrayList, this.c, this.l).a(new a(crVar, f2)).a(context);
    }

    public final void f() {
        List<cf<VideoData>> list;
        cr<VideoData> crVar = this.f;
        if (crVar != null) {
            if (this.n == 0 || (list = this.i) == null) {
                g(crVar, this.k);
                return;
            }
            int i2 = this.m + 1;
            if (i2 < list.size()) {
                this.m = i2;
                cf<VideoData> cfVar = this.i.get(i2);
                if ("statistics".equals(cfVar.getType())) {
                    b(cfVar, "playbackStarted");
                    f();
                    return;
                }
                int i3 = this.n;
                if (i3 > 0) {
                    this.n = i3 - 1;
                }
                this.g = cfVar;
                this.h = InstreamAd.InstreamAdBanner.newBanner(cfVar);
                this.d.a(cfVar);
                return;
            }
            g(this.f, this.k);
        }
    }

    public final void g(@NonNull cr<VideoData> crVar, float f2) {
        bp cc = crVar.cc();
        if (cc == null) {
            c(crVar);
        } else if (AdBreak.BreakId.MIDROLL.equals(crVar.getName())) {
            cc.t(true);
            cc.setPoint(f2);
            ArrayList<bp> arrayList = new ArrayList<>();
            arrayList.add(cc);
            ae.a("using doAfter service for point: " + f2);
            e(arrayList, crVar, f2);
        } else {
            Context context = this.d.getContext();
            if (context == null) {
                ae.a("can't load doAfter service: context is null");
                return;
            }
            StringBuilder L = a2.b.a.a.a.L("loading doAfter service: ");
            L.append(cc.getUrl());
            ae.a(L.toString());
            f.a(cc, this.c, this.l).a(new g(this, crVar)).a(context);
        }
    }

    @Nullable
    public InstreamAdPlayer getPlayer() {
        return this.d.getPlayer();
    }

    public float getVolume() {
        return this.d.getVolume();
    }

    public void handleClick() {
        if (this.g == null) {
            ae.a("can't handle click: no playing banner");
            return;
        }
        Context context = this.d.getContext();
        if (context == null) {
            ae.a("can't handle click: context is null");
        } else {
            this.e.a(this.g, context);
        }
    }

    public void pause() {
        if (this.f != null) {
            this.d.pause();
        }
    }

    public void resume() {
        if (this.f != null) {
            this.d.resume();
        }
    }

    public void setFullscreen(boolean z) {
        b(this.g, z ? "fullscreenOn" : "fullscreenOff");
    }

    public void setPlayer(@Nullable InstreamAdPlayer instreamAdPlayer) {
        this.d.setPlayer(instreamAdPlayer);
    }

    public void setVolume(float f2) {
        this.d.setVolume(f2);
    }

    public void skip() {
        b(this.g, "closedByUser");
        stop();
    }

    public void skipBanner() {
        b(this.g, "closedByUser");
        this.d.stop();
        f();
    }

    public void start(@NonNull String str) {
        stop();
        cr<VideoData> v = this.b.v(str);
        this.f = v;
        if (v != null) {
            this.d.setConnectionTimeout(v.bY());
            this.n = this.f.bZ();
            this.m = -1;
            this.i = this.f.ca();
            f();
            return;
        }
        a2.b.a.a.a.U0("no section with name ", str);
    }

    public void startMidroll(float f2) {
        stop();
        float[] fArr = this.j;
        int length = fArr.length;
        boolean z = false;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                break;
            } else if (Float.compare(fArr[i2], f2) == 0) {
                z = true;
                break;
            } else {
                i2++;
            }
        }
        if (z) {
            cr<VideoData> v = this.b.v(AdBreak.BreakId.MIDROLL);
            this.f = v;
            if (v != null) {
                this.d.setConnectionTimeout(v.bY());
                this.n = this.f.bZ();
                this.m = -1;
                this.k = f2;
                d(this.f, f2);
                return;
            }
            return;
        }
        ae.a("attempt to start wrong midpoint, use one of InstreamAd.getMidPoints()");
    }

    public void stop() {
        if (this.f != null) {
            this.d.stop();
            c(this.f);
        }
    }

    public void swapPlayer(@Nullable InstreamAdPlayer instreamAdPlayer) {
        this.d.swapPlayer(instreamAdPlayer);
    }

    public class b implements aj.c {
        public b(g gVar) {
        }

        @Override // com.my.target.aj.c
        public void a(float f, float f2, @NonNull cf cfVar) {
            InstreamAd.InstreamAdListener listener;
            at atVar = at.this;
            if (atVar.f != null && atVar.g == cfVar && atVar.h != null && (listener = atVar.a.getListener()) != null) {
                listener.onBannerTimeLeftChange(f, f2, at.this.a);
            }
        }

        @Override // com.my.target.aj.c
        public void b(@NonNull cf cfVar) {
            at atVar = at.this;
            if (atVar.f != null && atVar.g == cfVar && atVar.h != null) {
                InstreamAd.InstreamAdListener listener = atVar.a.getListener();
                StringBuilder L = a2.b.a.a.a.L("Ad shown, banner Id = ");
                L.append(cfVar.getId());
                ae.a(L.toString());
                if (listener != null) {
                    at atVar2 = at.this;
                    listener.onBannerStart(atVar2.a, atVar2.h);
                }
            }
        }

        @Override // com.my.target.aj.c
        public void c(@NonNull cf cfVar) {
            InstreamAd.InstreamAdListener listener;
            at atVar = at.this;
            if (atVar.f != null && atVar.g == cfVar && atVar.h != null && (listener = atVar.a.getListener()) != null) {
                at atVar2 = at.this;
                listener.onBannerComplete(atVar2.a, atVar2.h);
            }
        }

        @Override // com.my.target.aj.c
        public void d(@NonNull cf cfVar) {
            at atVar = at.this;
            if (atVar.f != null && atVar.g == cfVar && atVar.h != null) {
                InstreamAd.InstreamAdListener listener = atVar.a.getListener();
                if (listener != null) {
                    at atVar2 = at.this;
                    listener.onBannerComplete(atVar2.a, atVar2.h);
                }
                at.this.f();
            }
        }

        @Override // com.my.target.aj.c
        public void e(@NonNull cf cfVar) {
            InstreamAd.InstreamAdListener listener;
            at atVar = at.this;
            if (atVar.f != null && atVar.g == cfVar && atVar.h != null && (listener = atVar.a.getListener()) != null) {
                at atVar2 = at.this;
                listener.onBannerPause(atVar2.a, atVar2.h);
            }
        }

        @Override // com.my.target.aj.c
        public void f(@NonNull cf cfVar) {
            InstreamAd.InstreamAdListener listener;
            at atVar = at.this;
            if (atVar.f != null && atVar.g == cfVar && atVar.h != null && (listener = atVar.a.getListener()) != null) {
                at atVar2 = at.this;
                listener.onBannerResume(atVar2.a, atVar2.h);
            }
        }

        @Override // com.my.target.aj.c
        public void a(@NonNull String str, @NonNull cf cfVar) {
            at atVar = at.this;
            if (atVar.f != null && atVar.g == cfVar) {
                InstreamAd.InstreamAdListener listener = atVar.a.getListener();
                if (listener != null) {
                    listener.onError(str, at.this.a);
                }
                at.this.f();
            }
        }
    }
}
