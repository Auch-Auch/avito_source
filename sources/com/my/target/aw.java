package com.my.target;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.my.target.ads.Reward;
import com.my.target.ap;
import com.my.target.common.MyTargetActivity;
import com.my.target.er;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
public class aw extends av {
    @NonNull
    public final cc g;
    @NonNull
    public final cq h;
    @NonNull
    public final ArrayList<cx> i;
    @Nullable
    public WeakReference<er> j;
    @Nullable
    public iq k;

    public static class a implements er.a {
        @NonNull
        public final aw a;
        @NonNull
        public final cc b;
        @NonNull
        public final ap.a c;

        public a(@NonNull aw awVar, @NonNull cc ccVar, @NonNull ap.a aVar) {
            this.a = awVar;
            this.b = ccVar;
            this.c = aVar;
        }

        @Override // com.my.target.er.a
        public void a(@NonNull by byVar, float f, float f2, @NonNull Context context) {
            aw awVar = this.a;
            if (!awVar.i.isEmpty()) {
                float f3 = f2 - f;
                ArrayList arrayList = new ArrayList();
                Iterator<cx> it = awVar.i.iterator();
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
            hx eC = hx.eC();
            if (TextUtils.isEmpty(str)) {
                eC.a(this.b, context);
            } else {
                eC.c(this.b, str, context);
            }
            this.c.onClick();
        }

        @Override // com.my.target.er.a
        public void onNoAd(@NonNull String str) {
            this.a.dismiss();
        }

        @Override // com.my.target.ej.a
        public void p() {
            this.a.dismiss();
        }

        @Override // com.my.target.er.a
        public void p(@NonNull Context context) {
            aw awVar = this.a;
            if (!awVar.c) {
                awVar.c = true;
                awVar.a.onVideoCompleted();
                im.a(awVar.g.getStatHolder().K("reward"), context);
                ap.b am = awVar.am();
                if (am != null) {
                    am.onReward(Reward.getDefault());
                }
            }
        }

        @Override // com.my.target.ej.a
        public void a(@NonNull by byVar, @NonNull View view) {
            StringBuilder L = a2.b.a.a.a.L("Ad shown, banner Id = ");
            L.append(this.b.getId());
            ae.a(L.toString());
            aw awVar = this.a;
            iq iqVar = awVar.k;
            if (iqVar != null) {
                iqVar.fj();
            }
            iq a3 = iq.a(awVar.g.getViewability(), awVar.g.getStatHolder());
            awVar.k = a3;
            if (awVar.b) {
                a3.m(view);
            }
            StringBuilder L2 = a2.b.a.a.a.L("Ad shown, banner Id = ");
            L2.append(byVar.getId());
            ae.a(L2.toString());
            im.a(byVar.getStatHolder().K("playbackStarted"), view.getContext());
        }

        @Override // com.my.target.er.a
        public void a(@NonNull by byVar, @NonNull String str, @NonNull Context context) {
            Objects.requireNonNull(this.a);
            im.a(byVar.getStatHolder().K(str), context);
        }
    }

    public aw(@NonNull cc ccVar, @NonNull cq cqVar, @NonNull ap.a aVar) {
        super(aVar);
        this.g = ccVar;
        this.h = cqVar;
        ArrayList<cx> arrayList = new ArrayList<>();
        this.i = arrayList;
        arrayList.addAll(ccVar.getStatHolder().cA());
    }

    @Override // com.my.target.av
    public boolean al() {
        return this.g.isAllowBackButton();
    }

    @Override // com.my.target.av, com.my.target.common.MyTargetActivity.ActivityEngine
    public void onActivityCreate(@NonNull MyTargetActivity myTargetActivity, @NonNull Intent intent, @NonNull FrameLayout frameLayout) {
        super.onActivityCreate(myTargetActivity, intent, frameLayout);
        er z = "mraid".equals(this.g.getType()) ? ei.z(frameLayout.getContext()) : ee.x(frameLayout.getContext());
        this.j = new WeakReference<>(z);
        z.a(new a(this, this.g, this.a));
        z.a(this.h, this.g);
        frameLayout.addView(z.cZ(), new FrameLayout.LayoutParams(-1, -1));
    }

    @Override // com.my.target.av, com.my.target.common.MyTargetActivity.ActivityEngine
    public void onActivityDestroy() {
        er erVar;
        super.onActivityDestroy();
        WeakReference<er> weakReference = this.j;
        if (!(weakReference == null || (erVar = weakReference.get()) == null)) {
            erVar.destroy();
        }
        this.j = null;
        iq iqVar = this.k;
        if (iqVar != null) {
            iqVar.fj();
            this.k = null;
        }
    }

    @Override // com.my.target.av, com.my.target.common.MyTargetActivity.ActivityEngine
    public void onActivityPause() {
        er erVar;
        super.onActivityPause();
        WeakReference<er> weakReference = this.j;
        if (!(weakReference == null || (erVar = weakReference.get()) == null)) {
            erVar.pause();
        }
        iq iqVar = this.k;
        if (iqVar != null) {
            iqVar.fj();
        }
    }

    @Override // com.my.target.av, com.my.target.common.MyTargetActivity.ActivityEngine
    public void onActivityResume() {
        er erVar;
        super.onActivityResume();
        WeakReference<er> weakReference = this.j;
        if (weakReference != null && (erVar = weakReference.get()) != null) {
            erVar.resume();
            iq iqVar = this.k;
            if (iqVar != null) {
                iqVar.m(erVar.cZ());
            }
        }
    }
}
