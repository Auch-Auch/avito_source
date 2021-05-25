package com.my.target;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.my.target.common.models.VideoData;
import com.my.target.ek;
import com.my.target.em;
import com.my.target.eq;
import com.my.target.hf;
import com.my.target.hj;
import java.util.ArrayList;
import java.util.List;
public class he {
    @NonNull
    public final bu a;
    @NonNull
    public final Context b;
    @NonNull
    public final ho c;
    public boolean d = id.eF();

    public he(@NonNull bu buVar, @NonNull Context context) {
        this.a = buVar;
        this.b = context;
        this.c = ho.W(context);
    }

    public static he a(@NonNull bu buVar, @NonNull Context context) {
        return new he(buVar, context);
    }

    public void L(boolean z) {
        this.d = z && id.eF();
    }

    @NonNull
    public eh a(@NonNull cf<VideoData> cfVar, @NonNull fq fqVar, @NonNull em.a aVar) {
        return em.a(cfVar, fqVar, aVar, this.d ? iu.ah(fqVar.getContext()) : it.fm());
    }

    @NonNull
    public eq a(@NonNull hv hvVar, @NonNull List<cb> list, @NonNull eq.a aVar) {
        eq a3 = ep.a(hvVar, list, aVar);
        ArrayList arrayList = new ArrayList();
        for (cb cbVar : list) {
            arrayList.add(b(cbVar, a3));
        }
        hvVar.setAdapter(new hp(arrayList, this));
        return a3;
    }

    @NonNull
    public hf a(@NonNull hf.a aVar) {
        return new hg(this.c, this.b, aVar);
    }

    @NonNull
    public hj a(@NonNull ce ceVar, @NonNull View view, @NonNull View view2, @Nullable View view3, @NonNull hj.a aVar) {
        return !ceVar.getInterstitialAdCards().isEmpty() ? new hl(ceVar.getInterstitialAdCards().get(0).isImageOnly(), view, view2, aVar, view3, this.c, this.b) : ceVar.getVideoBanner() != null ? new hn(view, view2, aVar, view3, this.c, this.b) : new hm(view, view2, aVar, view3, this.c, this.b);
    }

    @NonNull
    public ek b(@NonNull cb cbVar, @NonNull ek.a aVar) {
        return el.a(cbVar, aVar);
    }

    @NonNull
    public fq ep() {
        return new fq(this.b);
    }

    @NonNull
    public hh eq() {
        return new hi(this.b);
    }

    @NonNull
    public hv er() {
        return new hv(this.b);
    }

    @NonNull
    public hq es() {
        return new hr(this.b, this.a, this.c);
    }

    @NonNull
    public Handler et() {
        return new Handler(Looper.getMainLooper());
    }
}
