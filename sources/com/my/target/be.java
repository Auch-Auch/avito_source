package com.my.target;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.my.target.ads.MyTargetView;
import com.my.target.as;
import com.my.target.az;
import com.my.target.common.MyTargetPrivacy;
import com.my.target.mediation.MediationAdapter;
import com.my.target.mediation.MediationStandardAdAdapter;
import com.my.target.mediation.MyTargetStandardAdAdapter;
import java.util.Objects;
public class be extends az<MediationStandardAdAdapter> implements as {
    @NonNull
    public final MyTargetView h;
    @NonNull
    public final a i;
    @Nullable
    public as.a j;

    public class a implements MediationStandardAdAdapter.MediationStandardAdListener {
        @NonNull
        public final cm a;

        public a(cm cmVar) {
            this.a = cmVar;
        }

        @Override // com.my.target.mediation.MediationStandardAdAdapter.MediationStandardAdListener
        public void onClick(@NonNull MediationStandardAdAdapter mediationStandardAdAdapter) {
            be beVar = be.this;
            if (beVar.e == mediationStandardAdAdapter) {
                Context g = beVar.g();
                if (g != null) {
                    im.a(this.a.getStatHolder().K("click"), g);
                }
                as.a aVar = be.this.j;
                if (aVar != null) {
                    aVar.onClick();
                }
            }
        }

        @Override // com.my.target.mediation.MediationStandardAdAdapter.MediationStandardAdListener
        public void onLoad(@NonNull View view, @NonNull MediationStandardAdAdapter mediationStandardAdAdapter) {
            if (be.this.e == mediationStandardAdAdapter) {
                StringBuilder L = a2.b.a.a.a.L("MediationStandardAdEngine: data from ");
                L.append(this.a.getName());
                L.append(" ad network loaded successfully");
                ae.a(L.toString());
                be.this.a(this.a, true);
                be beVar = be.this;
                Objects.requireNonNull(beVar);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.addRule(13);
                view.setLayoutParams(layoutParams);
                beVar.h.removeAllViews();
                beVar.h.addView(view);
                as.a aVar = be.this.j;
                if (aVar != null) {
                    aVar.onLoad();
                }
            }
        }

        @Override // com.my.target.mediation.MediationStandardAdAdapter.MediationStandardAdListener
        public void onNoAd(@NonNull String str, @NonNull MediationStandardAdAdapter mediationStandardAdAdapter) {
            if (be.this.e == mediationStandardAdAdapter) {
                StringBuilder L = a2.b.a.a.a.L("MediationStandardAdEngine: no data from ");
                L.append(this.a.getName());
                L.append(" ad network");
                ae.a(L.toString());
                be.this.a(this.a, false);
            }
        }

        @Override // com.my.target.mediation.MediationStandardAdAdapter.MediationStandardAdListener
        public void onShow(@NonNull MediationStandardAdAdapter mediationStandardAdAdapter) {
            be beVar = be.this;
            if (beVar.e == mediationStandardAdAdapter) {
                Context g = beVar.g();
                if (g != null) {
                    im.a(this.a.getStatHolder().K("playbackStarted"), g);
                }
                as.a aVar = be.this.j;
                if (aVar != null) {
                    aVar.aa();
                }
            }
        }
    }

    public be(@NonNull MyTargetView myTargetView, @NonNull cl clVar, @NonNull a aVar) {
        super(clVar);
        this.h = myTargetView;
        this.i = aVar;
    }

    @NonNull
    public static be a(@NonNull MyTargetView myTargetView, @NonNull cl clVar, @NonNull a aVar) {
        return new be(myTargetView, clVar, aVar);
    }

    @Override // com.my.target.as
    public void a(@NonNull MyTargetView.AdSize adSize) {
    }

    @Override // com.my.target.as
    public void a(@Nullable as.a aVar) {
        this.j = aVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.my.target.mediation.MediationAdapter, com.my.target.cm, android.content.Context] */
    @Override // com.my.target.az
    public void b(@NonNull MediationStandardAdAdapter mediationStandardAdAdapter, @NonNull cm cmVar, @NonNull Context context) {
        MediationStandardAdAdapter mediationStandardAdAdapter2 = mediationStandardAdAdapter;
        az.a a3 = az.a.a(cmVar.getPlacementId(), cmVar.getPayload(), cmVar.bN(), this.i.getCustomParams().getAge(), this.i.getCustomParams().getGender(), MyTargetPrivacy.currentPrivacy());
        if (mediationStandardAdAdapter2 instanceof MyTargetStandardAdAdapter) {
            cn bP = cmVar.bP();
            if (bP instanceof cu) {
                ((MyTargetStandardAdAdapter) mediationStandardAdAdapter2).setSection((cu) bP);
            }
        }
        try {
            mediationStandardAdAdapter2.load(a3, this.h.getSize(), new a(cmVar), context);
        } catch (Throwable th) {
            a2.b.a.a.a.r1(th, a2.b.a.a.a.L("MediationStandardAdEngine error: "));
        }
    }

    @Override // com.my.target.az
    public boolean c(@NonNull MediationAdapter mediationAdapter) {
        return mediationAdapter instanceof MediationStandardAdAdapter;
    }

    /* Return type fixed from 'com.my.target.mediation.MediationAdapter' to match base method */
    @Override // com.my.target.az
    @NonNull
    public MediationStandardAdAdapter d() {
        return new MyTargetStandardAdAdapter();
    }

    @Override // com.my.target.as
    public void destroy() {
        if (this.e == null) {
            ae.b("MediationStandardAdEngine error: can't destroy ad, adapter is not set");
            return;
        }
        this.h.removeAllViews();
        try {
            ((MediationStandardAdAdapter) this.e).destroy();
        } catch (Throwable th) {
            a2.b.a.a.a.r1(th, a2.b.a.a.a.L("MediationStandardAdEngine error: "));
        }
        this.e = null;
    }

    @Override // com.my.target.az
    public void e() {
        as.a aVar = this.j;
        if (aVar != null) {
            aVar.onNoAd("No data for available ad networks");
        }
    }

    @Override // com.my.target.as
    public void pause() {
    }

    @Override // com.my.target.as
    public void prepare() {
        super.s(this.h.getContext());
    }

    @Override // com.my.target.as
    public void resume() {
    }

    @Override // com.my.target.as
    public void start() {
    }

    @Override // com.my.target.as
    public void stop() {
    }
}
