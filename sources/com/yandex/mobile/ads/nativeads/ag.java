package com.yandex.mobile.ads.nativeads;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import com.yandex.mobile.ads.impl.at;
import com.yandex.mobile.ads.impl.lm;
import com.yandex.mobile.ads.impl.ln;
import com.yandex.mobile.ads.impl.lt;
import com.yandex.mobile.ads.impl.lu;
import com.yandex.mobile.ads.impl.oq;
import java.util.Map;
public final class ag<T extends View> {
    @NonNull
    private final f a;
    @NonNull
    private final j b;
    @NonNull
    private final al c;
    @NonNull
    private final Map<String, lm> d;
    @NonNull
    private final ah e = new ah();

    public ag(@NonNull T t, @NonNull ak<T> akVar, @NonNull j jVar, @NonNull at atVar, @NonNull f fVar, @NonNull t tVar, @NonNull ln lnVar) {
        this.a = fVar;
        this.b = jVar;
        lu luVar = new lu(lnVar, atVar, tVar.c());
        al a3 = akVar.a(t);
        this.c = a3;
        this.d = new lt(a3, jVar, luVar).a();
    }

    public final void a() {
        for (lm lmVar : this.d.values()) {
            if (lmVar != null) {
                lmVar.a();
            }
        }
    }

    @Nullable
    public final NativeAdViewBinder b() {
        View a3 = this.c.a();
        if (a3 != null) {
            return ah.a(a3, this.c);
        }
        return null;
    }

    @Nullable
    public final View c() {
        return this.c.a();
    }

    @NonNull
    public final al d() {
        return this.c;
    }

    @NonNull
    public final f e() {
        return this.a;
    }

    @NonNull
    public final j f() {
        return this.b;
    }

    @Nullable
    public final lm a(@Nullable oq oqVar) {
        if (oqVar != null) {
            return this.d.get(oqVar.a());
        }
        return null;
    }
}
