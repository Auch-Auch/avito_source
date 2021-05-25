package com.my.target;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.my.target.ads.Reward;
import com.my.target.ap;
import com.my.target.az;
import com.my.target.common.MyTargetPrivacy;
import com.my.target.mediation.MediationAdapter;
import com.my.target.mediation.MediationRewardedAdAdapter;
import com.my.target.mediation.MyTargetRewardedAdAdapter;
public class bd extends az<MediationRewardedAdAdapter> implements ap {
    @NonNull
    public final ap.a h;
    @NonNull
    public final a i;
    @Nullable
    public ap.b j;

    public class a implements MediationRewardedAdAdapter.MediationRewardedAdListener {
        @NonNull
        public final cm a;

        public a(cm cmVar) {
            this.a = cmVar;
        }

        @Override // com.my.target.mediation.MediationRewardedAdAdapter.MediationRewardedAdListener
        public void onClick(@NonNull MediationRewardedAdAdapter mediationRewardedAdAdapter) {
            bd bdVar = bd.this;
            if (bdVar.e == mediationRewardedAdAdapter) {
                Context g = bdVar.g();
                if (g != null) {
                    im.a(this.a.getStatHolder().K("click"), g);
                }
                bd.this.h.onClick();
            }
        }

        @Override // com.my.target.mediation.MediationRewardedAdAdapter.MediationRewardedAdListener
        public void onDismiss(@NonNull MediationRewardedAdAdapter mediationRewardedAdAdapter) {
            bd bdVar = bd.this;
            if (bdVar.e == mediationRewardedAdAdapter) {
                bdVar.h.onDismiss();
            }
        }

        @Override // com.my.target.mediation.MediationRewardedAdAdapter.MediationRewardedAdListener
        public void onDisplay(@NonNull MediationRewardedAdAdapter mediationRewardedAdAdapter) {
            bd bdVar = bd.this;
            if (bdVar.e == mediationRewardedAdAdapter) {
                Context g = bdVar.g();
                if (g != null) {
                    im.a(this.a.getStatHolder().K("playbackStarted"), g);
                }
                bd.this.h.onDisplay();
            }
        }

        @Override // com.my.target.mediation.MediationRewardedAdAdapter.MediationRewardedAdListener
        public void onLoad(@NonNull MediationRewardedAdAdapter mediationRewardedAdAdapter) {
            if (bd.this.e == mediationRewardedAdAdapter) {
                StringBuilder L = a2.b.a.a.a.L("MediationRewardedAdEngine: data from ");
                L.append(this.a.getName());
                L.append(" ad network loaded successfully");
                ae.a(L.toString());
                bd.this.a(this.a, true);
                bd.this.h.onLoad();
            }
        }

        @Override // com.my.target.mediation.MediationRewardedAdAdapter.MediationRewardedAdListener
        public void onNoAd(@NonNull String str, @NonNull MediationRewardedAdAdapter mediationRewardedAdAdapter) {
            if (bd.this.e == mediationRewardedAdAdapter) {
                StringBuilder L = a2.b.a.a.a.L("MediationRewardedAdEngine: no data from ");
                L.append(this.a.getName());
                L.append(" ad network");
                ae.a(L.toString());
                bd.this.a(this.a, false);
            }
        }

        @Override // com.my.target.mediation.MediationRewardedAdAdapter.MediationRewardedAdListener
        public void onReward(@NonNull Reward reward, @NonNull MediationRewardedAdAdapter mediationRewardedAdAdapter) {
            bd bdVar = bd.this;
            if (bdVar.e == mediationRewardedAdAdapter) {
                Context g = bdVar.g();
                if (g != null) {
                    im.a(this.a.getStatHolder().K("reward"), g);
                }
                ap.b am = bd.this.am();
                if (am != null) {
                    am.onReward(reward);
                }
            }
        }
    }

    public bd(@NonNull cl clVar, @NonNull a aVar, @NonNull ap.a aVar2) {
        super(clVar);
        this.i = aVar;
        this.h = aVar2;
    }

    @NonNull
    public static bd b(@NonNull cl clVar, @NonNull a aVar, @NonNull ap.a aVar2) {
        return new bd(clVar, aVar, aVar2);
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
    public void b(@NonNull MediationRewardedAdAdapter mediationRewardedAdAdapter, @NonNull cm cmVar, @NonNull Context context) {
        MediationRewardedAdAdapter mediationRewardedAdAdapter2 = mediationRewardedAdAdapter;
        az.a a3 = az.a.a(cmVar.getPlacementId(), cmVar.getPayload(), cmVar.bN(), this.i.getCustomParams().getAge(), this.i.getCustomParams().getGender(), MyTargetPrivacy.currentPrivacy());
        if (mediationRewardedAdAdapter2 instanceof MyTargetRewardedAdAdapter) {
            cn bP = cmVar.bP();
            if (bP instanceof cq) {
                ((MyTargetRewardedAdAdapter) mediationRewardedAdAdapter2).setSection((cq) bP);
            }
        }
        try {
            mediationRewardedAdAdapter2.load(a3, new a(cmVar), context);
        } catch (Throwable th) {
            a2.b.a.a.a.r1(th, a2.b.a.a.a.L("MediationRewardedAdEngine error: "));
        }
    }

    @Override // com.my.target.az
    public boolean c(@NonNull MediationAdapter mediationAdapter) {
        return mediationAdapter instanceof MediationRewardedAdAdapter;
    }

    /* Return type fixed from 'com.my.target.mediation.MediationAdapter' to match base method */
    @Override // com.my.target.az
    @NonNull
    public MediationRewardedAdAdapter d() {
        return new MyTargetRewardedAdAdapter();
    }

    @Override // com.my.target.ap
    public void destroy() {
        T t = this.e;
        if (t == null) {
            ae.b("MediationRewardedAdEngine error: can't destroy ad, adapter is not set");
            return;
        }
        try {
            ((MediationRewardedAdAdapter) t).destroy();
        } catch (Throwable th) {
            a2.b.a.a.a.r1(th, a2.b.a.a.a.L("MediationRewardedAdEngine error: "));
        }
        this.e = null;
    }

    @Override // com.my.target.ap
    public void dismiss() {
        T t = this.e;
        if (t == null) {
            ae.b("MediationRewardedAdEngine error: can't dismiss ad, adapter is not set");
            return;
        }
        try {
            ((MediationRewardedAdAdapter) t).dismiss();
        } catch (Throwable th) {
            a2.b.a.a.a.r1(th, a2.b.a.a.a.L("MediationRewardedAdEngine error: "));
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
            ae.b("MediationRewardedAdEngine error: can't show ad, adapter is not set");
            return;
        }
        try {
            ((MediationRewardedAdAdapter) t).show(context);
        } catch (Throwable th) {
            a2.b.a.a.a.r1(th, a2.b.a.a.a.L("MediationRewardedAdEngine error: "));
        }
    }
}
