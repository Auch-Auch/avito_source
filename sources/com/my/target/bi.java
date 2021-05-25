package com.my.target;

import a2.l.a.j;
import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.my.target.ads.MyTargetView;
import com.my.target.ag;
import com.my.target.as;
import com.my.target.es;
import com.my.target.et;
import com.my.target.iq;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
public class bi implements as {
    @NonNull
    public final MyTargetView a;
    @NonNull
    public final ck b;
    @NonNull
    public final Context c;
    @NonNull
    public final et.a d = new b();
    @NonNull
    public final ArrayList<cx> e;
    @NonNull
    public final iq f;
    @Nullable
    public et g;
    @Nullable
    public as.a h;
    public boolean i;
    @NonNull
    public final ag j;

    public class a implements ag.b {
        public a() {
        }

        @Override // com.my.target.ag.b
        public void i(@NonNull Context context) {
            bi biVar = bi.this;
            im.a(biVar.b.getStatHolder().K("closedByUser"), biVar.c);
            as.a aVar = biVar.h;
            if (aVar != null) {
                aVar.aj();
            }
        }
    }

    public static class c implements es.c {
        @NonNull
        public final bi a;

        public c(@NonNull bi biVar) {
            this.a = biVar;
        }

        @Override // com.my.target.es.c
        public void a(float f, float f2, @NonNull ck ckVar, @NonNull Context context) {
            bi biVar = this.a;
            if (!biVar.e.isEmpty()) {
                float f3 = f2 - f;
                ArrayList arrayList = new ArrayList();
                Iterator<cx> it = biVar.e.iterator();
                while (it.hasNext()) {
                    cx next = it.next();
                    float cu = next.cu();
                    if (cu < 0.0f && next.cv() >= 0.0f) {
                        cu = (f2 / 100.0f) * next.cv();
                    }
                    if (cu >= 0.0f && cu <= f3) {
                        arrayList.add(next);
                        it.remove();
                    }
                }
                im.a(arrayList, context);
            }
        }

        @Override // com.my.target.es.c
        public void ah() {
            as.a aVar = this.a.h;
            if (aVar != null) {
                aVar.ah();
            }
        }

        @Override // com.my.target.es.c
        public void ai() {
            as.a aVar = this.a.h;
            if (aVar != null) {
                aVar.ai();
            }
        }

        @Override // com.my.target.es.c
        public void onLoad() {
            as.a aVar = this.a.h;
            if (aVar != null) {
                aVar.onLoad();
            }
        }

        @Override // com.my.target.es.c
        public void onNoAd(@NonNull String str) {
            as.a aVar = this.a.h;
            if (aVar != null) {
                aVar.onNoAd(str);
            }
        }

        @Override // com.my.target.es.c
        public void a(@NonNull String str, @NonNull ck ckVar, @NonNull Context context) {
            Objects.requireNonNull(this.a);
            im.a(ckVar.getStatHolder().K(str), context);
        }
    }

    public bi(@NonNull MyTargetView myTargetView, @NonNull ck ckVar) {
        this.a = myTargetView;
        this.b = ckVar;
        this.c = myTargetView.getContext();
        ArrayList<cx> arrayList = new ArrayList<>();
        this.e = arrayList;
        arrayList.addAll(ckVar.getStatHolder().cA());
        this.f = iq.a(ckVar.getViewability(), ckVar.getStatHolder());
        this.j = ag.a(ckVar.getAdChoices());
    }

    @NonNull
    public static bi a(@NonNull MyTargetView myTargetView, @NonNull ck ckVar) {
        return new bi(myTargetView, ckVar);
    }

    @Override // com.my.target.as
    public void a(@NonNull MyTargetView.AdSize adSize) {
        et etVar = this.g;
        if (etVar != null) {
            etVar.dJ().f(adSize.getWidthPixels(), adSize.getHeightPixels());
        }
    }

    @Override // com.my.target.as
    public void a(@Nullable as.a aVar) {
        this.h = aVar;
    }

    @Override // com.my.target.as
    @Nullable
    public String ad() {
        return "myTarget";
    }

    @Override // com.my.target.as
    public float ae() {
        return 0.0f;
    }

    public final void b(@NonNull fv fvVar) {
        if (this.g != null) {
            MyTargetView.AdSize size = this.a.getSize();
            this.g.dJ().f(size.getWidthPixels(), size.getHeightPixels());
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        fvVar.setLayoutParams(layoutParams);
        this.a.removeAllViews();
        this.a.addView(fvVar);
        if (this.b.getAdChoices() != null) {
            this.j.a(fvVar.getAdChoicesView(), new a());
        }
    }

    @Override // com.my.target.as
    public void destroy() {
        et etVar = this.g;
        if (etVar != null) {
            etVar.destroy();
            this.g = null;
        }
        this.f.fj();
        this.j.unregister();
    }

    @Override // com.my.target.as
    public void pause() {
        et etVar = this.g;
        if (etVar != null) {
            etVar.pause();
        }
        this.i = false;
        this.f.fj();
    }

    @Override // com.my.target.as
    public void prepare() {
        eu euVar;
        es esVar;
        if ("mraid".equals(this.b.getType())) {
            et etVar = this.g;
            if (etVar instanceof es) {
                esVar = (es) etVar;
            } else {
                if (etVar != null) {
                    etVar.a((et.a) null);
                    this.g.destroy();
                }
                esVar = es.e(this.a);
                esVar.a(this.d);
                this.g = esVar;
                b(esVar.dJ());
            }
            esVar.a(new c(this));
            esVar.a(this.b);
            return;
        }
        et etVar2 = this.g;
        if (etVar2 instanceof ev) {
            euVar = (eu) etVar2;
        } else {
            if (etVar2 != null) {
                etVar2.a((et.a) null);
                this.g.destroy();
            }
            euVar = ev.A(this.c);
            euVar.a(this.d);
            this.g = euVar;
            b(euVar.dJ());
        }
        euVar.a(new j(this));
        euVar.a(this.b);
    }

    @Override // com.my.target.as
    public void resume() {
        et etVar = this.g;
        if (etVar != null) {
            etVar.resume();
        }
        this.i = true;
        this.f.m(this.a);
    }

    @Override // com.my.target.as
    public void start() {
        this.i = true;
        et etVar = this.g;
        if (etVar != null) {
            etVar.start();
        }
    }

    @Override // com.my.target.as
    public void stop() {
        et etVar = this.g;
        if (etVar != null) {
            etVar.stop();
        }
    }

    public class b implements et.a {

        public class a extends iq.b {
            public a() {
            }

            @Override // com.my.target.iq.b
            public void aa() {
                StringBuilder L = a2.b.a.a.a.L("Ad shown, banner Id = ");
                L.append(bi.this.b.getId());
                ae.a(L.toString());
                as.a aVar = bi.this.h;
                if (aVar != null) {
                    aVar.aa();
                }
            }
        }

        public b() {
        }

        @Override // com.my.target.et.a
        public void a(@NonNull by byVar) {
            bi.this.f.fj();
            bi.this.f.a(new a());
            bi biVar = bi.this;
            if (biVar.i) {
                biVar.f.m(biVar.a);
            }
            im.a(byVar.getStatHolder().K("playbackStarted"), bi.this.a.getContext());
        }

        @Override // com.my.target.et.a
        public void a(@NonNull by byVar, @Nullable String str) {
            as.a aVar = bi.this.h;
            if (aVar != null) {
                aVar.onClick();
            }
            hx eC = hx.eC();
            if (TextUtils.isEmpty(str)) {
                eC.a(byVar, bi.this.a.getContext());
            } else {
                eC.c(byVar, str, bi.this.a.getContext());
            }
        }
    }
}
