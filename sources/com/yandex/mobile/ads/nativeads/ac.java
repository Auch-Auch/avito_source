package com.yandex.mobile.ads.nativeads;

import android.content.Context;
import android.support.annotation.NonNull;
import com.yandex.mobile.ads.impl.an;
import com.yandex.mobile.ads.impl.bo;
import com.yandex.mobile.ads.impl.rc;
import java.util.Iterator;
import java.util.List;
public final class ac extends af {
    private final List<? extends ba> b;

    public ac(@NonNull List<? extends ba> list, @NonNull au auVar) {
        super(auVar);
        this.b = list;
    }

    @Override // com.yandex.mobile.ads.nativeads.af
    public final an a(@NonNull Context context, an.a aVar) {
        boolean z;
        if (an.a.SUCCESS == aVar) {
            Iterator<? extends ba> it = this.b.iterator();
            while (true) {
                z = true;
                boolean z2 = false;
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                ba baVar = (ba) it.next();
                be d = baVar.d();
                Iterator<bo> it2 = baVar.e().b().iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (d.a(context, it2.next().c()).b() != an.a.SUCCESS) {
                            continue;
                            break;
                        }
                    } else {
                        z2 = true;
                        continue;
                        break;
                    }
                }
                if (z2) {
                    break;
                }
            }
            if (!z) {
                aVar = an.a.NO_VISIBLE_ADS;
            }
        }
        return new an(aVar, new rc());
    }
}
