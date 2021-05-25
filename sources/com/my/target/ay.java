package com.my.target;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.my.target.ads.Reward;
import com.my.target.ap;
import com.my.target.common.MyTargetActivity;
import com.my.target.en;
import com.my.target.eo;
import com.my.target.er;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
public class ay extends av {
    @NonNull
    public final cq g;
    public final boolean h;
    @NonNull
    public final ArrayList<cx> i;
    @NonNull
    public ce j;
    @Nullable
    public WeakReference<ej> k;
    @Nullable
    public iq l;

    public static class a implements en.b, eo.b, er.a {
        @NonNull
        public final ay a;

        public a(@NonNull ay ayVar) {
            this.a = ayVar;
        }

        @Override // com.my.target.en.b, com.my.target.eo.b
        public void U() {
            ej c = this.a.c();
            if (c instanceof en) {
                ((en) c).dx();
            }
        }

        @Override // com.my.target.er.a
        public void a(@NonNull by byVar, float f, float f2, @NonNull Context context) {
            ay ayVar = this.a;
            if (!ayVar.i.isEmpty()) {
                float f3 = f2 - f;
                ArrayList arrayList = new ArrayList();
                Iterator<cx> it = ayVar.i.iterator();
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

        @Override // com.my.target.ej.a
        public void b(@Nullable by byVar, @Nullable String str, @NonNull Context context) {
            if (byVar != null) {
                ay ayVar = this.a;
                if (ayVar.c() != null) {
                    hx eC = hx.eC();
                    if (TextUtils.isEmpty(str)) {
                        eC.a(byVar, context);
                    } else {
                        eC.c(byVar, str, context);
                    }
                    boolean z = byVar instanceof cb;
                    if (z) {
                        im.a(ayVar.j.getStatHolder().K("click"), context);
                    }
                    ayVar.a.onClick();
                    if ((z || (byVar instanceof ce)) && ayVar.j.isCloseOnClick()) {
                        ayVar.dismiss();
                    }
                }
            }
        }

        @Override // com.my.target.er.a
        public void onNoAd(@NonNull String str) {
        }

        @Override // com.my.target.ej.a
        public void p() {
            this.a.dismiss();
        }

        @Override // com.my.target.er.a
        public void p(@NonNull Context context) {
        }

        @Override // com.my.target.en.b, com.my.target.eo.b
        public void r(@NonNull Context context) {
            ay ayVar = this.a;
            ayVar.a.onVideoCompleted();
            if (!ayVar.c) {
                ayVar.c = true;
                im.a(ayVar.j.getStatHolder().K("reward"), context);
                ap.b am = ayVar.am();
                if (am != null) {
                    am.onReward(Reward.getDefault());
                }
            }
            ca endCard = ayVar.j.getEndCard();
            ViewParent viewParent = null;
            ej c = ayVar.c();
            if (c != null) {
                viewParent = c.cZ().getParent();
            }
            if (endCard != null && (viewParent instanceof ViewGroup)) {
                ViewGroup viewGroup = (ViewGroup) viewParent;
                ej c2 = ayVar.c();
                if (c2 != null) {
                    c2.destroy();
                }
                if (endCard instanceof cc) {
                    viewGroup.removeAllViews();
                    er z = "mraid".equals(endCard.getType()) ? ei.z(viewGroup.getContext()) : ee.x(viewGroup.getContext());
                    ayVar.k = new WeakReference<>(z);
                    z.a(new a(ayVar));
                    z.a(ayVar.g, (cc) endCard);
                    viewGroup.addView(z.cZ(), new FrameLayout.LayoutParams(-1, -1));
                } else if (endCard instanceof cd) {
                    viewGroup.removeAllViews();
                    ef y = ef.y(viewGroup.getContext());
                    ayVar.k = new WeakReference<>(y);
                    y.a(new a(ayVar));
                    y.a((cd) endCard);
                    viewGroup.addView(y.cZ(), new FrameLayout.LayoutParams(-1, -1));
                } else if (endCard instanceof ce) {
                    viewGroup.removeAllViews();
                    ayVar.b((ce) endCard, viewGroup);
                }
            }
        }

        @Override // com.my.target.ej.a
        public void a(@NonNull by byVar, @NonNull View view) {
            ay ayVar = this.a;
            iq iqVar = ayVar.l;
            if (iqVar != null) {
                iqVar.fj();
            }
            iq a3 = iq.a(byVar.getViewability(), byVar.getStatHolder());
            ayVar.l = a3;
            if (ayVar.b) {
                a3.m(view);
            }
            StringBuilder L = a2.b.a.a.a.L("Ad shown, banner Id = ");
            L.append(byVar.getId());
            ae.a(L.toString());
            im.a(byVar.getStatHolder().K("playbackStarted"), view.getContext());
        }

        @Override // com.my.target.er.a
        public void a(@NonNull by byVar, @NonNull String str, @NonNull Context context) {
            Objects.requireNonNull(this.a);
            im.a(byVar.getStatHolder().K(str), context);
        }
    }

    public ay(@NonNull ce ceVar, @NonNull cq cqVar, boolean z, @NonNull ap.a aVar) {
        super(aVar);
        this.j = ceVar;
        this.g = cqVar;
        this.h = z;
        ArrayList<cx> arrayList = new ArrayList<>();
        this.i = arrayList;
        arrayList.addAll(ceVar.getStatHolder().cA());
    }

    @NonNull
    public static ay a(@NonNull ce ceVar, @NonNull cq cqVar, boolean z, @NonNull ap.a aVar) {
        return new ay(ceVar, cqVar, z, aVar);
    }

    @Override // com.my.target.av
    public boolean al() {
        return this.j.isAllowBackButton();
    }

    public final void b(@NonNull ce ceVar, @NonNull ViewGroup viewGroup) {
        en enVar;
        if (ceVar.getStyle() != 2) {
            enVar = en.a(ceVar, this.h, new a(this), viewGroup.getContext());
        } else {
            he a3 = he.a(ceVar.getPromoStyleSettings(), viewGroup.getContext());
            a3.L(this.h);
            eo a4 = eo.a(a3, ceVar, new a(this));
            a4.start();
            enVar = a4;
        }
        this.k = new WeakReference<>(enVar);
        viewGroup.addView(enVar.cZ(), new FrameLayout.LayoutParams(-1, -1));
        this.j = ceVar;
    }

    @Nullable
    @VisibleForTesting
    public ej c() {
        WeakReference<ej> weakReference = this.k;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // com.my.target.av, com.my.target.common.MyTargetActivity.ActivityEngine
    public void onActivityCreate(@NonNull MyTargetActivity myTargetActivity, @NonNull Intent intent, @NonNull FrameLayout frameLayout) {
        super.onActivityCreate(myTargetActivity, intent, frameLayout);
        b(this.j, frameLayout);
    }

    @Override // com.my.target.av, com.my.target.common.MyTargetActivity.ActivityEngine
    public void onActivityDestroy() {
        super.onActivityDestroy();
        WeakReference<ej> weakReference = this.k;
        if (weakReference != null) {
            ej ejVar = weakReference.get();
            if (ejVar != null) {
                View cZ = ejVar.cZ();
                ViewParent parent = cZ.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(cZ);
                }
                ejVar.destroy();
            }
            this.k.clear();
            this.k = null;
        }
        iq iqVar = this.l;
        if (iqVar != null) {
            iqVar.fj();
            this.l = null;
        }
    }

    @Override // com.my.target.av, com.my.target.common.MyTargetActivity.ActivityEngine
    public void onActivityPause() {
        super.onActivityPause();
        ej c = c();
        if (c != null) {
            c.pause();
        }
        iq iqVar = this.l;
        if (iqVar != null) {
            iqVar.fj();
        }
    }

    @Override // com.my.target.av, com.my.target.common.MyTargetActivity.ActivityEngine
    public void onActivityResume() {
        super.onActivityResume();
        ej c = c();
        if (c != null) {
            c.resume();
            iq iqVar = this.l;
            if (iqVar != null) {
                iqVar.m(c.cZ());
            }
        }
    }

    @Override // com.my.target.av, com.my.target.common.MyTargetActivity.ActivityEngine
    public void onActivityStop() {
        super.onActivityStop();
        ej c = c();
        if (c != null) {
            c.stop();
        }
    }
}
