package com.my.target;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.my.target.ads.Reward;
import com.my.target.ap;
import com.my.target.az;
import com.my.target.common.MyTargetPrivacy;
import com.my.target.mediation.MediationAdapter;
import com.my.target.mediation.MediationInterstitialAdAdapter;
import com.my.target.mediation.MyTargetInterstitialAdAdapter;
public class ba extends az<MediationInterstitialAdAdapter> implements ap {
    @NonNull
    public final ap.a h;
    @NonNull
    public final a i;
    @Nullable
    public ap.b j;

    public class a implements MediationInterstitialAdAdapter.MediationInterstitialAdListener {
        @NonNull
        public final cm a;

        public a(cm cmVar) {
            this.a = cmVar;
        }

        @Override // com.my.target.mediation.MediationInterstitialAdAdapter.MediationInterstitialAdListener
        public void onClick(@NonNull MediationInterstitialAdAdapter mediationInterstitialAdAdapter) {
            ba baVar = ba.this;
            if (baVar.e == mediationInterstitialAdAdapter) {
                Context g = baVar.g();
                if (g != null) {
                    im.a(this.a.getStatHolder().K("click"), g);
                }
                ba.this.h.onClick();
            }
        }

        @Override // com.my.target.mediation.MediationInterstitialAdAdapter.MediationInterstitialAdListener
        public void onDismiss(@NonNull MediationInterstitialAdAdapter mediationInterstitialAdAdapter) {
            ba baVar = ba.this;
            if (baVar.e == mediationInterstitialAdAdapter) {
                baVar.h.onDismiss();
            }
        }

        @Override // com.my.target.mediation.MediationInterstitialAdAdapter.MediationInterstitialAdListener
        public void onDisplay(@NonNull MediationInterstitialAdAdapter mediationInterstitialAdAdapter) {
            ba baVar = ba.this;
            if (baVar.e == mediationInterstitialAdAdapter) {
                Context g = baVar.g();
                if (g != null) {
                    im.a(this.a.getStatHolder().K("playbackStarted"), g);
                }
                ba.this.h.onDisplay();
            }
        }

        @Override // com.my.target.mediation.MediationInterstitialAdAdapter.MediationInterstitialAdListener
        public void onLoad(@NonNull MediationInterstitialAdAdapter mediationInterstitialAdAdapter) {
            if (ba.this.e == mediationInterstitialAdAdapter) {
                StringBuilder L = a2.b.a.a.a.L("MediationInterstitialAdEngine: data from ");
                L.append(this.a.getName());
                L.append(" ad network loaded successfully");
                ae.a(L.toString());
                ba.this.a(this.a, true);
                ba.this.h.onLoad();
            }
        }

        @Override // com.my.target.mediation.MediationInterstitialAdAdapter.MediationInterstitialAdListener
        public void onNoAd(@NonNull String str, @NonNull MediationInterstitialAdAdapter mediationInterstitialAdAdapter) {
            if (ba.this.e == mediationInterstitialAdAdapter) {
                StringBuilder L = a2.b.a.a.a.L("MediationInterstitialAdEngine: no data from ");
                L.append(this.a.getName());
                L.append(" ad network");
                ae.a(L.toString());
                ba.this.a(this.a, false);
            }
        }

        @Override // com.my.target.mediation.MediationInterstitialAdAdapter.MediationInterstitialAdListener
        public void onVideoCompleted(@NonNull MediationInterstitialAdAdapter mediationInterstitialAdAdapter) {
            ba baVar = ba.this;
            if (baVar.e == mediationInterstitialAdAdapter) {
                baVar.h.onVideoCompleted();
                Context g = ba.this.g();
                if (g != null) {
                    im.a(this.a.getStatHolder().K("reward"), g);
                }
                ap.b am = ba.this.am();
                if (am != null) {
                    am.onReward(Reward.getDefault());
                }
            }
        }
    }

    public ba(@NonNull cl clVar, @NonNull a aVar, @NonNull ap.a aVar2) {
        super(clVar);
        this.i = aVar;
        this.h = aVar2;
    }

    @NonNull
    public static ba a(@NonNull cl clVar, @NonNull a aVar, @NonNull ap.a aVar2) {
        return new ba(clVar, aVar, aVar2);
    }

    @Override // com.my.target.ap
    public void a(@Nullable ap.b bVar) {
        this.j = bVar;
    }

    @Nullable
    public ap.b am() {
        return this.j;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.my.target.mediation.MediationAdapter, com.my.target.cm, android.content.Context] */
    @Override // com.my.target.az
    public void b(@NonNull MediationInterstitialAdAdapter mediationInterstitialAdAdapter, @NonNull cm cmVar, @NonNull Context context) {
        MediationInterstitialAdAdapter mediationInterstitialAdAdapter2 = mediationInterstitialAdAdapter;
        az.a a3 = az.a.a(cmVar.getPlacementId(), cmVar.getPayload(), cmVar.bN(), this.i.getCustomParams().getAge(), this.i.getCustomParams().getGender(), MyTargetPrivacy.currentPrivacy());
        if (mediationInterstitialAdAdapter2 instanceof MyTargetInterstitialAdAdapter) {
            cn bP = cmVar.bP();
            if (bP instanceof cq) {
                ((MyTargetInterstitialAdAdapter) mediationInterstitialAdAdapter2).setSection((cq) bP);
            }
        }
        try {
            mediationInterstitialAdAdapter2.load(a3, new a(cmVar), context);
        } catch (Throwable th) {
            a2.b.a.a.a.r1(th, a2.b.a.a.a.L("MediationInterstitialAdEngine error: "));
        }
    }

    @Override // com.my.target.az
    public boolean c(@NonNull MediationAdapter mediationAdapter) {
        return mediationAdapter instanceof MediationInterstitialAdAdapter;
    }

    /* Return type fixed from 'com.my.target.mediation.MediationAdapter' to match base method */
    @Override // com.my.target.az
    @NonNull
    public MediationInterstitialAdAdapter d() {
        return new MyTargetInterstitialAdAdapter();
    }

    @Override // com.my.target.ap
    public void destroy() {
        T t = this.e;
        if (t == null) {
            ae.b("MediationInterstitialAdEngine error: can't destroy ad, adapter is not set");
            return;
        }
        try {
            ((MediationInterstitialAdAdapter) t).destroy();
        } catch (Throwable th) {
            a2.b.a.a.a.r1(th, a2.b.a.a.a.L("MediationInterstitialAdEngine error: "));
        }
        this.e = null;
    }

    @Override // com.my.target.ap
    public void dismiss() {
        T t = this.e;
        if (t == null) {
            ae.b("MediationInterstitialAdEngine error: can't dismiss ad, adapter is not set");
            return;
        }
        try {
            ((MediationInterstitialAdAdapter) t).dismiss();
        } catch (Throwable th) {
            a2.b.a.a.a.r1(th, a2.b.a.a.a.L("MediationInterstitialAdEngine error: "));
        }
    }

    @Override // com.my.target.az
    public void e() {
        this.h.onNoAd("No data for available ad networks");
    }

    @Override // com.my.target.ap
    public void o(@NonNull Context context) {
        T t = this.e;
        if (t == null) {
            ae.b("MediationInterstitialAdEngine error: can't show ad, adapter is not set");
            return;
        }
        try {
            ((MediationInterstitialAdAdapter) t).show(context);
        } catch (Throwable th) {
            a2.b.a.a.a.r1(th, a2.b.a.a.a.L("MediationInterstitialAdEngine error: "));
        }
    }
}
