package com.my.target;

import a2.l.a.h;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.my.target.ai;
import com.my.target.common.models.AudioData;
import com.my.target.i;
import com.my.target.instreamads.InstreamAudioAd;
import com.my.target.instreamads.InstreamAudioAdPlayer;
import com.yandex.mobile.ads.video.models.vmap.AdBreak;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
public class au {
    @NonNull
    public final InstreamAudioAd a;
    @NonNull
    public final cp b;
    @NonNull
    public final a c;
    @NonNull
    public final ai d;
    @NonNull
    public final hx e;
    @Nullable
    public cr<AudioData> f;
    @Nullable
    public cf<AudioData> g;
    @Nullable
    public InstreamAudioAd.InstreamAudioAdBanner h;
    @Nullable
    public List<InstreamAudioAd.InstreamAdCompanionBanner> i;
    @Nullable
    public List<cf<AudioData>> j;
    @NonNull
    public float[] k = new float[0];
    public float l;
    public int m;
    public int n;
    public int o;

    public class a implements i.b {
        public final /* synthetic */ cr a;
        public final /* synthetic */ float b;

        public a(cr crVar, float f) {
            this.a = crVar;
            this.b = f;
        }

        @Override // com.my.target.b.AbstractC0305b
        public void onResult(@Nullable cn cnVar, @Nullable String str) {
            cp cpVar = (cp) cnVar;
            au auVar = au.this;
            cr<AudioData> crVar = this.a;
            float f = this.b;
            Objects.requireNonNull(auVar);
            if (cpVar == null) {
                if (str != null) {
                    a2.b.a.a.a.U0("loading midpoint services failed: ", str);
                }
                if (crVar == auVar.f && f == auVar.l) {
                    auVar.h(crVar, f);
                    return;
                }
                return;
            }
            cr<AudioData> w = cpVar.w(crVar.getName());
            if (w != null) {
                crVar.b(w);
            }
            if (crVar == auVar.f && f == auVar.l) {
                auVar.e(crVar, f);
            }
        }
    }

    public au(@NonNull InstreamAudioAd instreamAudioAd, @NonNull cp cpVar, @NonNull a aVar) {
        this.a = instreamAudioAd;
        this.b = cpVar;
        this.c = aVar;
        ai q = ai.q();
        this.d = q;
        q.a(new b(null));
        this.e = hx.eC();
    }

    @NonNull
    public static au a(@NonNull InstreamAudioAd instreamAudioAd, @NonNull cp cpVar, @NonNull a aVar) {
        return new au(instreamAudioAd, cpVar, aVar);
    }

    public void a(@NonNull float[] fArr) {
        this.k = fArr;
    }

    @Nullable
    public final bz b(@NonNull InstreamAudioAd.InstreamAdCompanionBanner instreamAdCompanionBanner) {
        String str;
        cf<AudioData> cfVar;
        if (this.i == null || this.h == null || (cfVar = this.g) == null) {
            str = "can't find companion banner: no playing banner";
        } else {
            ArrayList<bz> companionBanners = cfVar.getCompanionBanners();
            int indexOf = this.i.indexOf(instreamAdCompanionBanner);
            if (indexOf >= 0 && indexOf < companionBanners.size()) {
                return companionBanners.get(indexOf);
            }
            str = "can't find companion banner: provided instreamAdCompanionBanner not found in current playing banner";
        }
        ae.a(str);
        return null;
    }

    public final void c(@Nullable cf cfVar, @NonNull String str) {
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

    public final void d(@NonNull cr<AudioData> crVar) {
        if (crVar == this.f) {
            if (AdBreak.BreakId.MIDROLL.equals(crVar.getName())) {
                this.f.t(this.o);
            }
            this.f = null;
            this.g = null;
            this.h = null;
            this.n = -1;
            InstreamAudioAd.InstreamAudioAdListener listener = this.a.getListener();
            if (listener != null) {
                listener.onComplete(crVar.getName(), this.a);
            }
        }
    }

    public void destroy() {
        this.d.destroy();
    }

    public void e(int i2) {
        this.m = i2;
    }

    public final void e(@NonNull cr<AudioData> crVar, float f2) {
        ArrayList arrayList = new ArrayList();
        for (cf<AudioData> cfVar : crVar.ca()) {
            if (cfVar.getPoint() == f2) {
                arrayList.add(cfVar);
            }
        }
        int size = arrayList.size();
        if (size <= 0 || this.n >= size - 1) {
            ArrayList<bp> j2 = crVar.j(f2);
            if (j2.size() > 0) {
                f(j2, crVar, f2);
                return;
            }
            ae.a("There is no one midpoint service for point: " + f2);
            h(crVar, f2);
            return;
        }
        this.j = arrayList;
        g();
    }

    public final void f(@NonNull ArrayList<bp> arrayList, @NonNull cr<AudioData> crVar, float f2) {
        Context context = this.d.getContext();
        if (context == null) {
            ae.a("can't load midpoint services: context is null");
            return;
        }
        ae.a("loading midpoint services for point: " + f2);
        i.a(arrayList, this.c, this.m).a(new a(crVar, f2)).a(context);
    }

    public final void g() {
        List<cf<AudioData>> list;
        cr<AudioData> crVar = this.f;
        if (crVar != null) {
            if (this.o == 0 || (list = this.j) == null) {
                h(crVar, this.l);
                return;
            }
            int i2 = this.n + 1;
            if (i2 < list.size()) {
                this.n = i2;
                cf<AudioData> cfVar = this.j.get(i2);
                if ("statistics".equals(cfVar.getType())) {
                    c(cfVar, "playbackStarted");
                    g();
                    return;
                }
                int i3 = this.o;
                if (i3 > 0) {
                    this.o = i3 - 1;
                }
                this.g = cfVar;
                this.h = InstreamAudioAd.InstreamAudioAdBanner.newBanner(cfVar);
                this.i = new ArrayList(this.h.companionBanners);
                this.d.a(cfVar);
                return;
            }
            h(this.f, this.l);
        }
    }

    @Nullable
    public InstreamAudioAd.InstreamAudioAdBanner getCurrentBanner() {
        return this.h;
    }

    @Nullable
    public InstreamAudioAdPlayer getPlayer() {
        return this.d.getPlayer();
    }

    public float getVolume() {
        return this.d.getVolume();
    }

    public final void h(@NonNull cr<AudioData> crVar, float f2) {
        bp cc = crVar.cc();
        if (cc == null) {
            d(crVar);
        } else if (AdBreak.BreakId.MIDROLL.equals(crVar.getName())) {
            cc.t(true);
            cc.setPoint(f2);
            ArrayList<bp> arrayList = new ArrayList<>();
            arrayList.add(cc);
            ae.a("using doAfter service for point: " + f2);
            f(arrayList, crVar, f2);
        } else {
            Context context = this.d.getContext();
            if (context == null) {
                ae.a("can't load doAfter service: context is null");
                return;
            }
            StringBuilder L = a2.b.a.a.a.L("loading doAfter service: ");
            L.append(cc.getUrl());
            ae.a(L.toString());
            i.a(cc, this.c, this.m).a(new h(this, crVar)).a(context);
        }
    }

    public void handleCompanionClick(@NonNull InstreamAudioAd.InstreamAdCompanionBanner instreamAdCompanionBanner) {
        Context context = this.d.getContext();
        if (context == null) {
            ae.a("can't handle click: context is null");
            return;
        }
        bz b2 = b(instreamAdCompanionBanner);
        if (b2 == null) {
            ae.a("can't handle click: companion banner not found");
        } else {
            this.e.a(b2, context);
        }
    }

    public void handleCompanionClick(@NonNull InstreamAudioAd.InstreamAdCompanionBanner instreamAdCompanionBanner, @NonNull Context context) {
        bz b2 = b(instreamAdCompanionBanner);
        if (b2 == null) {
            ae.a("can't handle click: companion banner not found");
        } else {
            this.e.a(b2, context);
        }
    }

    public void handleCompanionShow(@NonNull InstreamAudioAd.InstreamAdCompanionBanner instreamAdCompanionBanner) {
        Context context = this.d.getContext();
        if (context == null) {
            ae.a("can't handle show: context is null");
            return;
        }
        bz b2 = b(instreamAdCompanionBanner);
        if (b2 == null) {
            ae.a("can't handle show: companion banner not found");
        } else {
            im.a(b2.getStatHolder().K("playbackStarted"), context);
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

    public void setPlayer(@Nullable InstreamAudioAdPlayer instreamAudioAdPlayer) {
        this.d.setPlayer(instreamAudioAdPlayer);
    }

    public void setVolume(float f2) {
        this.d.setVolume(f2);
    }

    public void skip() {
        c(this.g, "closedByUser");
        stop();
    }

    public void skipBanner() {
        c(this.g, "closedByUser");
        this.d.stop();
        g();
    }

    public void start(@NonNull String str) {
        stop();
        cr<AudioData> w = this.b.w(str);
        this.f = w;
        if (w != null) {
            this.d.setConnectionTimeout(w.bY());
            this.o = this.f.bZ();
            this.n = -1;
            this.j = this.f.ca();
            g();
            return;
        }
        a2.b.a.a.a.U0("no section with name ", str);
    }

    public void startMidroll(float f2) {
        stop();
        float[] fArr = this.k;
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
            cr<AudioData> w = this.b.w(AdBreak.BreakId.MIDROLL);
            this.f = w;
            if (w != null) {
                this.d.setConnectionTimeout(w.bY());
                this.o = this.f.bZ();
                this.n = -1;
                this.l = f2;
                e(this.f, f2);
                return;
            }
            return;
        }
        ae.a("attempt to start wrong midpoint, use one of InstreamAd.getMidPoints()");
    }

    public void stop() {
        if (this.f != null) {
            this.d.stop();
            d(this.f);
        }
    }

    public class b implements ai.b {
        public b(h hVar) {
        }

        @Override // com.my.target.ai.b
        public void a(float f, float f2, @NonNull cf cfVar) {
            InstreamAudioAd.InstreamAudioAdListener listener;
            au auVar = au.this;
            if (auVar.f != null && auVar.g == cfVar && auVar.h != null && (listener = auVar.a.getListener()) != null) {
                listener.onBannerTimeLeftChange(f, f2, au.this.a);
            }
        }

        @Override // com.my.target.ai.b
        public void b(@NonNull cf cfVar) {
            au auVar = au.this;
            if (auVar.f != null && auVar.g == cfVar && auVar.h != null) {
                StringBuilder L = a2.b.a.a.a.L("Ad shown, banner Id = ");
                L.append(cfVar.getId());
                ae.a(L.toString());
                InstreamAudioAd.InstreamAudioAdListener listener = au.this.a.getListener();
                if (listener != null) {
                    au auVar2 = au.this;
                    listener.onBannerStart(auVar2.a, auVar2.h);
                }
            }
        }

        @Override // com.my.target.ai.b
        public void c(@NonNull cf cfVar) {
            InstreamAudioAd.InstreamAudioAdListener listener;
            au auVar = au.this;
            if (auVar.f != null && auVar.g == cfVar && auVar.h != null && (listener = auVar.a.getListener()) != null) {
                au auVar2 = au.this;
                listener.onBannerComplete(auVar2.a, auVar2.h);
            }
        }

        @Override // com.my.target.ai.b
        public void d(@NonNull cf cfVar) {
            au auVar = au.this;
            if (auVar.f != null && auVar.g == cfVar && auVar.h != null) {
                InstreamAudioAd.InstreamAudioAdListener listener = auVar.a.getListener();
                if (listener != null) {
                    au auVar2 = au.this;
                    listener.onBannerComplete(auVar2.a, auVar2.h);
                }
                au.this.g();
            }
        }

        @Override // com.my.target.ai.b
        public void a(@NonNull String str, @NonNull cf cfVar) {
            au auVar = au.this;
            if (auVar.f != null && auVar.g == cfVar) {
                InstreamAudioAd.InstreamAudioAdListener listener = auVar.a.getListener();
                if (listener != null) {
                    listener.onError(str, au.this.a);
                }
                au.this.g();
            }
        }
    }
}
