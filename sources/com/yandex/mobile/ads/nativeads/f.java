package com.yandex.mobile.ads.nativeads;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.view.View;
import com.yandex.mobile.ads.impl.ay;
import com.yandex.mobile.ads.impl.nd;
import com.yandex.mobile.ads.impl.nf;
import com.yandex.mobile.ads.impl.oq;
import com.yandex.mobile.ads.impl.ou;
import com.yandex.mobile.ads.impl.oz;
public abstract class f {
    @VisibleForTesting
    public static final f a = new f() { // from class: com.yandex.mobile.ads.nativeads.f.1
        @Override // com.yandex.mobile.ads.nativeads.f
        @NonNull
        public final View.OnClickListener a(@NonNull oq oqVar, @Nullable ou ouVar, @NonNull a aVar, @NonNull ag agVar, @Nullable ay ayVar) {
            return new nd(oqVar, aVar, agVar, ouVar, ayVar);
        }
    };
    @VisibleForTesting
    public static final f b = new f() { // from class: com.yandex.mobile.ads.nativeads.f.2
        @Override // com.yandex.mobile.ads.nativeads.f
        @NonNull
        public final View.OnClickListener a(@NonNull oq oqVar, @Nullable ou ouVar, @NonNull a aVar, @NonNull ag agVar, @Nullable ay ayVar) {
            if ("call_to_action".equals(oqVar.a())) {
                return new nd(oqVar, aVar, agVar, ouVar, ayVar);
            }
            return new nf(agVar.d().d());
        }
    };

    @NonNull
    public static f a() {
        return a;
    }

    @NonNull
    public abstract View.OnClickListener a(@NonNull oq oqVar, @Nullable ou ouVar, @NonNull a aVar, @NonNull ag agVar, @Nullable ay ayVar);

    @NonNull
    public static f a(@Nullable oz ozVar) {
        if (ozVar == null || !"button_click_only".equals(ozVar.a())) {
            return a;
        }
        return b;
    }
}
